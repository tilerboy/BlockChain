package myself.eth.etherscanApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import myself.eth.etherscanApi.po.TxListRequestPo;
import myself.eth.etherscanApi.po.TxListResponsePo;
import myself.eth.etherscanApi.po.TxListResponseResultPo;

@Controller
@SpringBootApplication
public class EtherscanApiImp {

//	private static String ETH_add = "0x4C6Adf8086Df9a1bDab35028B3f9e22Be0A79640";
	private static String ETH_add = "0x4C6Adf8086Df9a1bDab35028B3f9e22Be0A79640";

	String http_add = "https://api.etherscan.io/api?";
	HttpURLConnection connection = null;
	InputStream is = null;
	BufferedReader br = null;
	
	@Autowired
	TxListResponsePo txListResponse = null;
	@Autowired
	TxListResponseResultPo txListResponseResult = null;

	public static void main(String[] args) {
		SpringApplication.run(EtherscanApiImp.class, args);
	}

	@ResponseBody
	@RequestMapping(value = "/txlist")
	public String getTxList() {
		//初始化
		TxListRequestPo txListPo = new TxListRequestPo("account", "txlist", ETH_add, "0", "99999999", "desc",
				"M54JAMGC7ABE1T4G6JHJPGEY3YD2EYNBVV");
		String args = "module=" + txListPo.getModule() + "&action=" + txListPo.getAction() + "&address="
				+ txListPo.getAddress() + "&startblock=" + txListPo.getStartblock() + "&endblock="
				+ txListPo.getEndblock() + "&sort=" + txListPo.getSort() + "&apikey=" + txListPo.getApikey();
		String url_str = http_add + args;
		
		//获取结果
		String txList_str = this.httpGet(url_str);
		System.out.println("result String : "+txList_str);
		
		//封装结果
        JSONObject jsonObject = (JSONObject) JSONObject.parseObject(txList_str);
        JSONArray jsonObject_result = jsonObject.getJSONArray("result");
//        System.out.println(jsonObject_result);
        
        //封装result
        for (Object object : jsonObject_result) {
//        	System.out.println(object);
//        	System.out.println(((JSONObject) object).getString("blockNumber"));
			
        	txListResponseResult.setBlockNumber(((JSONObject) object).getString("blockNumber"));
        	txListResponseResult.setTimeStamp(((JSONObject) object).getString("timeStamp"));
        	txListResponseResult.setHash((String)((JSONObject) object).getString("hash"));
        	txListResponseResult.setNonce((String)((JSONObject) object).getString("nonce"));
        	txListResponseResult.setBlockHash((String)((JSONObject) object).getString("blockHash"));
        	txListResponseResult.setTransactionIndex((String)((JSONObject) object).getString("transactionIndex"));
        	txListResponseResult.setFrom((String)((JSONObject) object).getString("from"));
        	txListResponseResult.setTo((String)((JSONObject) object).getString("to"));
        	txListResponseResult.setValue((String)((JSONObject) object).getString("value"));
        	txListResponseResult.setGas((String)((JSONObject) object).getString("gas"));
        	txListResponseResult.setGasPrice((String)((JSONObject) object).getString("gasPrice"));
        	txListResponseResult.setIsError((String)((JSONObject) object).getString("isError"));
        	txListResponseResult.setTxreceipt_status((String)((JSONObject) object).getString("txreceipt_status"));
        	txListResponseResult.setInput((String)((JSONObject) object).getString("input"));
        	txListResponseResult.setContractAddress((String)((JSONObject) object).getString("contractAddress"));
        	txListResponseResult.setCumulativeGasUsed((String)((JSONObject) object).getString("cumulativeGasUsed"));
        	txListResponseResult.setGasUsed((String)((JSONObject) object).getString("gasUsed"));
        	txListResponseResult.setConfirmations((String)((JSONObject) object).getString("confirmations"));
		}
        
        //封装回复
        txListResponse.setStatus((String)jsonObject.get("status"));
        txListResponse.setMessage((String)jsonObject.get("message"));
        txListResponse.setResult(txListResponseResult);
        
//        System.out.println(txList_str);
        
		
		return txList_str;

	}

	public String httpGet(String url_str) {

		System.out.println(url_str);
		String result = null;

		try {
			URL url = new URL(url_str);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(15000);
			connection.setReadTimeout(60000);
			connection.connect();
			if (connection.getResponseCode() == 200) {
				is = connection.getInputStream();
				br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				StringBuffer sbf = new StringBuffer();
				String temp = null;
				while ((temp = br.readLine()) != null) {
					sbf.append(temp);
//					System.out.println("temp:  " + temp);
					sbf.append("\r\n");
				}
				result = sbf.toString();
			}
		} catch (Exception e) {
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
		}

		return result;

	}

}
