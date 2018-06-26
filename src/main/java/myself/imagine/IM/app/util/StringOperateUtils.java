package myself.imagine.IM.app.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StringOperateUtils {

	/*
	 * 获取随机字符串 
	 * 获取和地址一样长度的的一个字符串，作为对标字符串 
	 * wyk 2018.6.28
	 */
	public static String getRandomString(int length) {
		// 定义一个字符串（A-Z，a-z，0-9）即62位；
		String str = "zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
		// 由Random生成随机数
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		// 长度为几就循环几次
		for (int i = 0; i < length; ++i) {
			// 产生0-61的数字
			int number = random.nextInt(62);
			// 将产生的数字通过length次承载到sb中
			sb.append(str.charAt(number));
		}
		// 将承载的字符转换成字符串
		return sb.toString();
	}

	/*
	 * 将字符串转化为二进制数 
	 * 地址的对比最终是以int类型结果展示，需要首先将地址字符串转化成二进制，然而地址转化成二进制后以字符串形式存储太长，使用Integer转化函数报错，
	 * 故将字符串每个字符对应的二进制按顺序存放到list中。
	 *  wyk 2018.6.28
	 */

	@SuppressWarnings("unused")
	public static List<String> stringToBinary(String strToBina) {

		char[] strToBin_char = null;
		if (strToBina.length() > 0 || null != strToBina) {
			strToBin_char = strToBina.toCharArray();
		} else {
			throw new NullPointerException("the strToBina who turn into Binary is Empty! ");
		}
		List<String> list_bina = new ArrayList<String>();

		for (char str_char : strToBin_char) {
			list_bina.add(Integer.toBinaryString(str_char));
		}

		return list_bina;

	}
	
	/*
	 * 将二进制字符串转化成int
	 * 将存放于list中的地址对应的二进制表示方式，转化为int方式，然后在进行后续操作。
	 *  wyk 2018.6.28
	 */
	public static BigInteger  BinaryToDecimal(List<String> list_bina) {

		StringBuffer stringBuffer_bina = new StringBuffer();
		
		for (String str : list_bina) {
			stringBuffer_bina.append(str);
		}
		
	    BigInteger bi = new BigInteger(stringBuffer_bina.toString(), 2);    //转换为BigInteger类型  
		
		return bi;

	}

}
