package myself.imagine.minhash;

import java.io.IOException;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {

		System.out.println("-----------使用k-shingle技术分析两段文本之间的Jaccard相似度-------");
		int k = 3;
		System.out.println("请输入k-shingle中k的值："+k);
		Set<String> set = KShingle.jaccard(k);
		System.out.println("-----------使用MinHash技术分析两段文本之间的Jaccard相似度------------");
		MinHash.minHashJaccard(k, set);
		System.out.println("-----------用hash函数代替行打乱计算最小哈希签名------------");
		MinHashSignature.signatureJaccard(set, k);
	}

}
