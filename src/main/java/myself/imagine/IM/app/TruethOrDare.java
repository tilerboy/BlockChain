package myself.imagine.IM.app;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import myself.imagine.IM.app.util.StringOperateUtils;

/*
 * trueth or dare - 真心话大冒险
 * 这个程序演示了基于区块链地址随机竞猜游戏的原理。
 * 这个原理可以用于真心话大冒险，猜拳，以及选择性活动，例如抽奖等。
 */

@Controller
@SpringBootApplication
public class TruethOrDare {
	
	private static String ETH_a = null;
	private static String ETH_b = null;
	private static String ETH_c = null;
	private static int ETH_add_length;

	static {
		  ETH_a = "0x95645Dd9f39aF47882B229ed5558F6251fd879E6";
	      ETH_b = "0x57a4775185dfcF70544f3c737B9C008d007F44A6";
		  ETH_c = "0xd2DA9c3fF9A667798774bdc550ef29640878e9dB";
	}
	
	//注册springBoot
	public static void main(String[] args) {
		SpringApplication.run(TruethOrDare.class, args);
		ETH_add_length = ETH_a.length();
		
	}
	
	
	@ResponseBody
    @RequestMapping(value = "/TOD")
	public Map<String,BigInteger> getTOD(String ETH_add){
		
		//获取一个锚定字符串，和对应的地址一般长度。
		String anchor_str = StringOperateUtils.getRandomString(ETH_add_length) ;
		
		//将字符串转化为对应int
		//注意：首先将字符串转换成对应的二进制数，然后二进制转换成int
		BigInteger anchor_int = StringOperateUtils.BinaryToDecimal(StringOperateUtils.stringToBinary(anchor_str));
		BigInteger ETH_a_int = StringOperateUtils.BinaryToDecimal(StringOperateUtils.stringToBinary(ETH_a));
		BigInteger ETH_b_int = StringOperateUtils.BinaryToDecimal(StringOperateUtils.stringToBinary(ETH_b));
		BigInteger ETH_c_int = StringOperateUtils.BinaryToDecimal(StringOperateUtils.stringToBinary(ETH_c));
		
		//进行异或运算
		Map<String,BigInteger> map_result = new HashMap<String, BigInteger>();
		map_result.put(ETH_a, anchor_int.xor(ETH_a_int));
		map_result.put(ETH_b, anchor_int.xor(ETH_b_int));
		map_result.put(ETH_c, anchor_int.xor(ETH_c_int));
		
		System.out.println("ETH_a: "+4.1049719077352317e+86);
		System.out.println("ETH_b: "+4.1049711181478084e+86);
		System.out.println("ETH_c: "+4.1049719077397896e+86);
		
		return map_result;
		
	}

}
