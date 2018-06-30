package myself.study.test.eth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

@Controller
@SpringBootApplication
public class EthApi {
	
	

	public static void main(String[] args) {
		SpringApplication.run(EthApi.class, args);
	}
	
	//account
	@ResponseBody
    @RequestMapping(value = "/account")
	public String getAccount() {
		
		return "account";
	}
	
	@ResponseBody
    @RequestMapping(value = "/select")
	public static String doGet() {
        HttpURLConnection connection = null;
        InputStream is = null;
        BufferedReader br = null;
        String result = null;// 返回结果字符串
        //Get Ether Balance for a single Address
       // http://api.etherscan.io/api?module=account&action=txlist&address=0x4C6Adf8086Df9a1bDab35028B3f9e22Be0A79640&startblock=0&endblock=99999999&sort=asc&apikey=M54JAMGC7ABE1T4G6JHJPGEY3YD2EYNBVV
        String httpurl_balance = "https://api.etherscan.io/api?module=account&action=balance&address=0x28FAd8da5597F1054E92b6270B0d87c001385441&tag=latest&apikey=M54JAMGC7ABE1T4G6JHJPGEY3YD2EYNBVV";
        
        //Check Transaction Receipt Status (Only applicable for Post Byzantium fork transactions) 
        String httpurl_tx = "https://api.etherscan.io/api?module=transaction&action=gettxreceiptstatus&txhash=0xcff6c745554c6c66cbab0002577768e8257fca3b7ae8bb810a69d4aa01111111&apikey=M54JAMGC7ABE1T4G6JHJPGEY3YD2EYNBVV";
        String httpurl_tx1 = "https://api.etherscan.io/api?module=proxy&action=eth_getTransactionByHash&txhash=0x60b6a5ba384108025672e344f912a99b36277c6dc545a6fdf1335b3b1c54f51a&apikey=M54JAMGC7ABE1T4G6JHJPGEY3YD2EYNBVV";
        
        //ASCH
        String account_new = "http://192.6.6.122:4096/api/accounts/new";
        try {
            // 创建远程url连接对象
//            URL url = new URL(httpurl_tx1);
            URL url = new URL(account_new);
            // 通过远程url连接对象打开一个连接，强转成httpURLConnection类
            connection = (HttpURLConnection) url.openConnection();
            // 设置连接方式：get
            connection.setRequestMethod("GET");
            // 设置连接主机服务器的超时时间：15000毫秒
            connection.setConnectTimeout(15000);
            // 设置读取远程返回的数据时间：60000毫秒
            connection.setReadTimeout(60000);
            // 发送请求
            connection.connect();
            // 通过connection连接，获取输入流
            if (connection.getResponseCode() == 200) {
                is = connection.getInputStream();
                // 封装输入流is，并指定字符集
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                // 存放数据
                StringBuffer sbf = new StringBuffer();
                String temp = null;
                while ((temp = br.readLine()) != null) {
                    sbf.append(temp);
                    System.out.println("temp:  "+temp);
                    sbf.append("\r\n");
                }
                result = sbf.toString();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            connection.disconnect();// 关闭远程连接
        }

        return result;
    }
	
	@ResponseBody
    @RequestMapping(value = "/random")
	public Map<String,Integer> getNewResult() {
		int count=3;
		List<String> add_list = new ArrayList<String>();
		Map<String, Integer> storage = new Hashtable<String, Integer>();
		String anchor = EthApi.getRandomString(34);
		storage.put(anchor,  Integer.valueOf(this.stringToBinaryToDecimal(anchor)));	
		for (int i=0;i<count ;i++) {
			String add = JSONObject.parseObject(EthApi.doGet()).getString("address");
			add_list.add(add);
			System.out.println(1);
			System.out.println(this.stringToBinaryToDecimal(add));
			System.out.println(2);
			storage.put(add, Integer.valueOf(this.stringToBinaryToDecimal(add)));
			add="";
		}
		int anchor_int= storage.get(anchor);
		Map<String, Integer> result = new Hashtable<String, Integer>();
		for (int i=0;i< add_list.size();i++) {
			String address=(String) add_list.get(i);
			System.out.println("address: "+storage.get(address));
			System.out.println("result_xor: "+anchor_int);
			int result_xor=anchor_int ^ storage.get(address);
			System.out.println("result_xor: "+result_xor);
			result.put(address, result_xor);
		}
		System.out.println("result map: "+result.toString());
		
		return result;
		
	}
	public int stringToBinaryToDecimal(String str) {
		
		char[] strChar=str.toCharArray();
		System.out.println("strChar"+strChar.toString());
	   int result=0;
	    List<String> list_b=new ArrayList<String>();
	    for(int i=0;i<strChar.length;i++){
	        list_b.add(Integer.toBinaryString(strChar[i]));
	    }
	    System.out.println("result"+list_b.toString());
	    for(int i=list_b.size();i>0;i--) {
	    	result+=Integer.parseInt(list_b.get(i-1));
	    }
		return result;
		
	}
	
	public Map<String,Integer>  getXOR(){
		Map<String, Integer> map = new Hashtable<String, Integer>();
		
		
		return map;
		
	}
	
	 public static String getRandomString(int length){
		    //定义一个字符串（A-Z，a-z，0-9）即62位；
		    String str="zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
		    //由Random生成随机数
		        Random random=new Random();  
		        StringBuffer sb=new StringBuffer();
		        //长度为几就循环几次
		        for(int i=0; i<length; ++i){
		          //产生0-61的数字
		          int number=random.nextInt(62);
		          //将产生的数字通过length次承载到sb中
		          sb.append(str.charAt(number));
		        }
		        //将承载的字符转换成字符串
		        return sb.toString();
		  }
	 
	 public  static  Integer Biannary2Decimal(int bi){

	        String binStr = bi+"";

	        Integer sum = 0;
	        int len = binStr.length();

	        for (int i=1;i<=len;i++){
	            //第i位 的数字为：
	            int dt = Integer.parseInt(binStr.substring(i-1,i));
	            sum+=(int)Math.pow(2,len-i)*dt;
	        }
	        return  sum;
	    }
	 
	 public static String sendPost(String param) {
		    String url="http://45.32.248.33:4096/peer/transactions";
	        PrintWriter out = null;
	        BufferedReader in = null;
	        String result = "";
	        param = "";
	        try {
	            URL realUrl = new URL(url);
	            // 打开和URL之间的连接
	            URLConnection conn = realUrl.openConnection();
	            // 设置通用的请求属性
	            conn.setRequestProperty("accept", "*/*");
	            conn.setRequestProperty("connection", "Keep-Alive");
	            conn.setRequestProperty("Content-Type", "application/json");
	            conn.setRequestProperty("magic", "594fe0f3");
	            conn.setRequestProperty("version", "");
	            
	            // 发送POST请求必须设置如下两行
	            conn.setDoOutput(true);
	            conn.setDoInput(true);
	            // 获取URLConnection对象对应的输出流
	            out = new PrintWriter(conn.getOutputStream());
	            // 发送请求参数
	            out.print(param);
	            // flush输出流的缓冲
	            out.flush();
	            // 定义BufferedReader输入流来读取URL的响应
	            in = new BufferedReader(
	                    new InputStreamReader(conn.getInputStream()));
	            String line;
	            while ((line = in.readLine()) != null) {
	                result += line;
	            }
	        } catch (Exception e) {
	            System.out.println("发送 POST 请求出现异常！"+e);
	            e.printStackTrace();
	        }
	        //使用finally块来关闭输出流、输入流
	        finally{
	            try{
	                if(out!=null){
	                    out.close();
	                }
	                if(in!=null){
	                    in.close();
	                }
	            }
	            catch(IOException ex){
	                ex.printStackTrace();
	            }
	        }
	        return result;
	    }    
	
	// 构建唯一会话Id
	public static String getSessionId(){
	    UUID uuid = UUID.randomUUID();
	    String str = uuid.toString();
	    return str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
	}
	
	

}
