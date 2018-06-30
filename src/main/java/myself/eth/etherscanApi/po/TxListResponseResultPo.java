package myself.eth.etherscanApi.po;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * etherscan API 交易list查询返回对象中包含txlist的result
 * result 如下：
 * {"blockNumber":"5868299","timeStamp":"1530177403","hash":"0x105dad2d16ee1bda5adb52ef46b3c1cd38d8d1e4bccdc22105c86c129dded887","nonce":"190475","blockHash":"0xb2d2411b184a57307531f6b89b60aeae49994d01a84d740862990d557c06517d","transactionIndex":"155","from":"0x59a5208b32e627891c389ebafc644145224006e8","to":"0x4c6adf8086df9a1bdab35028b3f9e22be0a79640","value":"91430000000000000","gas":"31242","gasPrice":"10000000000","isError":"0","txreceipt_status":"1","input":"0x","contractAddress":"","cumulativeGasUsed":"4943519","gasUsed":"31005","confirmations":"12029"},
 * {"blockNumber":"5844727","timeStamp":"1529824295","hash":"0x59ed7521ae88f265145a53e0247092dee3372405142b8a62c4e823ca41633841","nonce":"29","blockHash":"0x305f01ae02bf4f0f86e432f88e7779218526f2228fd1b445e3dbfee958bfc2aa","transactionIndex":"32","from":"0x0e74d9602c8a608afc770a3c9793e4a489e8694a","to":"0x4c6adf8086df9a1bdab35028b3f9e22be0a79640","value":"35000000000000000","gas":"110000","gasPrice":"6000000000","isError":"0","txreceipt_status":"1","input":"0x","contractAddress":"","cumulativeGasUsed":"1738836","gasUsed":"31005","confirmations":"35601"},
 * {"blockNumber":"5832433","timeStamp":"1529643770","hash":"0x2f5cbaf049cb17e9ac163aa8d98b417d2e2ccc8bf0741387d3e724209822cb38","nonce":"28","blockHash":"0x5a67ce4cf75d5a80f63f02857153b9dbdd18587558d4a21c2a8b331a3f6debb5","transactionIndex":"68","from":"0x0e74d9602c8a608afc770a3c9793e4a489e8694a","to":"0x4c6adf8086df9a1bdab35028b3f9e22be0a79640","value":"100000000000000000","gas":"110000","gasPrice":"6000000000","isError":"0","txreceipt_status":"1","input":"0x","contractAddress":"","cumulativeGasUsed":"5835518","gasUsed":"31005","confirmations":"47895"},
 * {"blockNumber":"5832400","timeStamp":"1529643212","hash":"0x958f02049edc544ee1ecd0ac61b066a8a03f7e6b11292471675b6c7e1f647576","nonce":"27","blockHash":"0x5e8b126e18606b8c6fd0506cdcf5d0bcd84bea32e3498d22299f9f3939ab4ed7","transactionIndex":"14","from":"0x0e74d9602c8a608afc770a3c9793e4a489e8694a","to":"0x4c6adf8086df9a1bdab35028b3f9e22be0a79640","value":"110000000000000000","gas":"21000","gasPrice":"11000000000","isError":"1","txreceipt_status":"0","input":"0x","contractAddress":"","cumulativeGasUsed":"442149","gasUsed":"21000","confirmations":"47928"},
 * {"blockNumber":"4975384","timeStamp":"1516962067","hash":"0x3db878f6036e395599830b33522f99b8ef02d4892e67cdc2bf4719d77e314d0d","nonce":"21","blockHash":"0xdd68a767e44d4f954cd7683c15ba7942959def95abb2c680f2a0859e0644709a","transactionIndex":"72","from":"0x5c6e45fd91c2a2ab6cc8d640bcc5f4710799adee","to":"0x4c6adf8086df9a1bdab35028b3f9e22be0a79640","value":"111000000000000000","gas":"21000","gasPrice":"35000000000","isError":"1","txreceipt_status":"0","input":"0x","contractAddress":"","cumulativeGasUsed":"2223317","gasUsed":"21000","confirmations":"904944"},
 * {"blockNumber":"4975282","timeStamp":"1516960507","hash":"0x55f2a5c3cff406d807536caab0f472981b500e67aefb059635a088c13603be80","nonce":"76298","blockHash":"0x8f987c6e91d886f001f4373c588273ac6f3a246ce062edc97322a2174aac92d5","transactionIndex":"78","from":"0x2e05a304d3040f1399c8c20d2a9f659ae7521058","to":"","value":"0","gas":"175000","gasPrice":"3750000000","isError":"0","txreceipt_status":"1","input":"0x6060604052341561000f57600080fd5b3373ffffffffffffffffffffffffffffffffffffffff167fb9691eb0e3c0b237fc7e920772da273eb161e59559cda25b73f8028c1084cbf230604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390a261016d806100986000396000f30060606040526000803073ffffffffffffffffffffffffffffffffffffffff1631915060008211151561003057600080fd5b73af1931c20ee0c11bea17a41bfbbad299b2763bc090508073ffffffffffffffffffffffffffffffffffffffff166108fc839081150290604051600060405180830381858888f19350505050151561008757600080fd5b8073ffffffffffffffffffffffffffffffffffffffff167fe659bb22726afd6009b17c3ae23679ed41784f382129f7fb0b2ef6776e0413d9303385604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828152602001935050505060405180910390a250500000a165627a7a72305820d2aac5a915bf75f10f6a15e259465232009528ad32ea5743ce152309fcde2dd10029","contractAddress":"0x4c6adf8086df9a1bdab35028b3f9e22be0a79640","cumulativeGasUsed":"6684869","gasUsed":"161641","confirmations":"905046"}]} 
 * 
 * 普通交易：
 * "from":"0x5c6e45fd91c2a2ab6cc8d640bcc5f4710799adee","to":"0x4c6adf8086df9a1bdab35028b3f9e22be0a79640","input":"0x"
 * 发布合约交易：
 * "from":"0x2e05a304d3040f1399c8c20d2a9f659ae7521058","to":"","input":"0x6060604052341561000f57600080fd5b3373ffffffffffffffffffffffffffffffffffffffff167fb9691eb0e3c0b237fc7e920772da273eb161e59559cda25b73f8028c1084cbf230604051808273ffffffffffffffffffffffffffffffffffffffff1673fffffffffffffffffffffffffffffff……
 * 正确交易：
 * "isError":"0","txreceipt_status":"1"
 * 错误交易：
 * "isError":"1","txreceipt_status":"0"
 */
@Component 
public class TxListResponseResultPo implements Serializable {

	private static final long serialVersionUID = 1L;
	private String blockNumber;
	private String timeStamp;
	private String hash;
	private String nonce;
	private String blockHash;
	private String transactionIndex;
	private String from;
	private String to;
	private String value;
	private String gas;
	private String gasPrice;
	private String isError;
	private String txreceipt_status;
	private String input;
	private String contractAddress;
	private String cumulativeGasUsed;
	private String gasUsed;
	private String confirmations;
	
	
	public String getBlockNumber() {
		return blockNumber;
	}
	public void setBlockNumber(String blockNumber) {
		this.blockNumber = blockNumber;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public String getNonce() {
		return nonce;
	}
	public void setNonce(String nonce) {
		this.nonce = nonce;
	}
	public String getBlockHash() {
		return blockHash;
	}
	public void setBlockHash(String blockHash) {
		this.blockHash = blockHash;
	}
	public String getTransactionIndex() {
		return transactionIndex;
	}
	public void setTransactionIndex(String transactionIndex) {
		this.transactionIndex = transactionIndex;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getGas() {
		return gas;
	}
	public void setGas(String gas) {
		this.gas = gas;
	}
	public String getGasPrice() {
		return gasPrice;
	}
	public void setGasPrice(String gasPrice) {
		this.gasPrice = gasPrice;
	}
	public String getIsError() {
		return isError;
	}
	public void setIsError(String isError) {
		this.isError = isError;
	}
	public String getTxreceipt_status() {
		return txreceipt_status;
	}
	public void setTxreceipt_status(String txreceipt_status) {
		this.txreceipt_status = txreceipt_status;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public String getContractAddress() {
		return contractAddress;
	}
	public void setContractAddress(String contractAddress) {
		this.contractAddress = contractAddress;
	}
	public String getCumulativeGasUsed() {
		return cumulativeGasUsed;
	}
	public void setCumulativeGasUsed(String cumulativeGasUsed) {
		this.cumulativeGasUsed = cumulativeGasUsed;
	}
	public String getGasUsed() {
		return gasUsed;
	}
	public void setGasUsed(String gasUsed) {
		this.gasUsed = gasUsed;
	}
	public String getConfirmations() {
		return confirmations;
	}
	public void setConfirmations(String confirmations) {
		this.confirmations = confirmations;
	}
	@Override
	public String toString() {
		return "TxListResponseResult [blockNumber=" + blockNumber + ", timeStamp=" + timeStamp + ", hash=" + hash
				+ ", nonce=" + nonce + ", blockHash=" + blockHash + ", transactionIndex=" + transactionIndex + ", from="
				+ from + ", to=" + to + ", value=" + value + ", gas=" + gas + ", gasPrice=" + gasPrice + ", isError="
				+ isError + ", txreceipt_status=" + txreceipt_status + ", input=" + input + ", contractAddress="
				+ contractAddress + ", cumulativeGasUsed=" + cumulativeGasUsed + ", gasUsed=" + gasUsed
				+ ", confirmations=" + confirmations + "]";
	}
	
}
