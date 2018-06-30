package myself.eth.etherscanApi.po;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * etherscan API 交易list查询返回对象
 * 返回结果：
 * 错误：{"status":"0","message":"No transactions found","result":[]}
 * 正确：{"status":"1","message":"OK","result":[{"blockNumber":"5868299","timeStamp":"1530177403","hash":"0x105dad2d16ee1bda5adb52ef46b3c1cd38d8d1e4bccdc22105c86c129dded887","nonce":"190475","blockHash":"0xb2d2411b184a57307531f6b89b60aeae49994d01a84d740862990d557c06517d","transactionIndex":"155","from":"0x59a5208b32e627891c389ebafc644145224006e8","to":"0x4c6adf8086df9a1bdab35028b3f9e22be0a79640","value":"91430000000000000","gas":"31242","gasPrice":"10000000000","isError":"0","txreceipt_status":"1","input":"0x","contractAddress":"","cumulativeGasUsed":"4943519","gasUsed":"31005","confirmations":"12029"}]}
 */
@Component 
public class TxListResponsePo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String status;
	private String message;
	private TxListResponseResultPo result;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public TxListResponseResultPo getResult() {
		return result;
	}
	public void setResult(TxListResponseResultPo result) {
		this.result = result;
	}
	
	@Override
	public String toString() {
		return "TxListResponsePo [status=" + status + ", message=" + message + ", result=" + result + "]";
	}
	
	

}
