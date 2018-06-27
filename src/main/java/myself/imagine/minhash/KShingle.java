package myself.imagine.minhash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Set;
import java.util.TreeSet;

public class KShingle {
	
	public static String eth_add_a = "0x95645Dd9f39aF47882B229ed5558F6251fd879E6";
	public static String eth_add_b = "0x57a4775185dfcF70544f3c737B9C008d007F44A6";
	
	// 读测试文本一
	protected static String ReadFile1() throws IOException {
		InputStream in = KShingle.class.getResourceAsStream("测试文本一.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = br.readLine()) != null) {
			sb.append(line);
			sb.append("\n");
		}
		return sb.toString();
	}

	// 读测试文本二
	protected static String ReadFile2() throws IOException {
		InputStream in = KShingle.class.getResourceAsStream("测试文本二.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = br.readLine()) != null) {
			sb.append(line);
			sb.append("\n");
		}
		return sb.toString();
	}

	// 删除停用词及空格符(仅针对本样例文本)
	protected static String deleteWord(String str) {
		String replaceStr = str.replaceAll("and ", "").replaceAll("by ", "").replaceAll("the ", "")
				.replaceAll("of ", "").replace("with ", "").replaceAll("\\)", "").replaceAll("\\(", "")
				.replaceAll(",", "").replaceAll("\\D\\.", "").replaceAll("\\s", "");
		return replaceStr;
	}

	// 使用k-shingle算法分隔
	protected static Set<String> split(String str, int k) {
		Set<String> shingSet = new TreeSet<String>();// 使用TreeSet而不使用HashSet有利于在MinHash算法中降低算法复杂度
		for (int i = 0; i <= str.length() - k; i++) {
			shingSet.add(str.substring(i, i + k));
		}
		return shingSet;
	}

	// 获得两段文本之间的相似度
	protected static Set<String> jaccard(int k) throws IOException {
		String str1 = "0x95645Dd9f39aF47882B229ed5558F6251fd879E6";
		String str2 = "0x57a4775185dfcF70544f3c737B9C008d007F44A6";
		String replacedStr1 = deleteWord(str1);
		String replacedStr2 = deleteWord(str2);
		Set<String> set1 = split(replacedStr1, k);
		Set<String> set2 = split(replacedStr2, k);
		Set<String> allElementSet = new TreeSet<String>();
		allElementSet.addAll(set1);
		allElementSet.addAll(set2);
		double jaccardValue = (set1.size() + set2.size() - allElementSet.size()) * 1.0 / allElementSet.size();
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println("使用" + k + "-shingle的两段文本之间的相似度结果为：" + df.format(jaccardValue));
		return allElementSet;
	}

}
