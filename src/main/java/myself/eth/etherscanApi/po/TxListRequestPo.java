package myself.eth.etherscanApi.po;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component 
public class TxListRequestPo implements Serializable {

	/**
	 * 通过地址获取交易列表po
	 * wyk 2018.6.28
	 */
	private static final long serialVersionUID = 1L;
	
	private String module;         //模块：account，contract和trasaction
	private String action;         //查询的需求，balance，balancemult或txlist
	private String address;        //地址
	private String startblock;     //开始区块编号
	private String endblock;       //结束去开编号，可以远远超过现有最大区块
	private String sort;           //返回的result按照时间排序，分为asc和desc
	private String apikey;         //平台账号秘钥
	
	
	@Override
	public String toString() {
		return "TxListPo [module=" + module + ", action=" + action + ", address=" + address + ", startblock="
				+ startblock + ", endblock=" + endblock + ", sort=" + sort + ", apikey=" + apikey + "]";
	}
	
	
	
	public TxListRequestPo() {
		super();
	}



	public TxListRequestPo(String module, String action, String address, String startblock, String endblock, String sort,
			String apikey) {
		super();
		this.module = module;
		this.action = action;
		this.address = address;
		this.startblock = startblock;
		this.endblock = endblock;
		this.sort = sort;
		this.apikey = apikey;
	}

	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStartblock() {
		return startblock;
	}
	public void setStartblock(String startblock) {
		this.startblock = startblock;
	}
	public String getEndblock() {
		return endblock;
	}
	public void setEndblock(String endblock) {
		this.endblock = endblock;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getApikey() {
		return apikey;
	}
	public void setApikey(String apikey) {
		this.apikey = apikey;
	}

}
