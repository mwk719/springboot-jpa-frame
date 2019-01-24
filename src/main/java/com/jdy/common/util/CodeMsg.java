package com.jdy.common.util;

/**
 * 错误状态码定义
 * @author 闵渭凯
 *
 * 2018年8月7日
 */
public enum CodeMsg {
	
	/**
	 * 100-300
	 * 基础信息
	 */
	LOGOUTSUCCESS("退出成功", 101),
	LOGINSUCCESS("登陆成功", 102),
	NOTFINDUSER("用户不存在",103),
	PSWDERROR("密码错误",104),
	
	NO_POWER("管理员没有该权限",201),
	NO_ROLE("该用户未分配角色",202),
	AUTHORIZATION_FAILURE("授权失败，请再重新登陆",203),
	//请求拦截校验
	LOGINEXPIRE("您登陆已过期，请重新登陆", 211),//
	OYHERLOGIN("您已在其他地方登陆", 212),//
	NOEXIT("您的信息已不存在", 213),//
	NO_LOGIN("您尚未登陆，请先去登陆", 214),//
	
	/**
	 * 301-700
	 * 业务信息
	 */
	
	/**
	 * 701-900
	 * 错误信息
	 */
	
	NOTEMPTY("参数不能为空", 100), 
	CHEEKERROR("验证码错误", 101), 
	FINDNULL("查询为空", 102), 
	LOGINERROR("登陆错误，请重新登陆", 103),
	PHONENUMERROR("手机号格式不正确", 104),
	VCODEEXPIRE("验证码已过期", 105),
	VCODEGETERROR("验证码获取错误,请重新获取", 106),
	OPENTIONMORE("操作频繁", 107),
	MORE1("一小时内发送给单个手机次数超过限制", 108),
	MORE2("一天内发送给单个手机次数超过限制", 109),
	MORE3("一分钟内下发短信超过次数限制", 110),
	SMSERROR("来自短信提供方的未知错误", 111),
	Unidentified("暂不识别该类型或证件不清晰", 113),//
	UPLOADIMG("图片上传失败,请重新上传", 114),//
	DistinguishERROR("图片不清晰识别失败,请重新上传", 115),//
	PARAM_ERROR("提交的参数有误", 116),//
	CARDEXPIRE("证件有效期已过", 117),//
	OPENUSERTYPEERROR("开户类型错误", 118),//
	NOTFINDOPENUSER("开户用户不存在",120),
	NOTFINDREGISTUSER("注册用户不存在",121),
	NOTFINDWORKERUSER("工人用户不存在",122),
	INSTALLTYPEERROR("安装类型错误",123),
	INSTALLTIMEERROR("安装时间错误",124),
	PHONEPSWDERROR("手机号或密码错误",125),
	PHONEISEXIT("该手机号已存在",126),
	GONGHAO("该工号已存在",128),
	USERTASKNOT("该用户任务不存在",129),
	NOTFIRSTLOGIN("您不是第一次登陆哦",130),
	WORDTOOLONG("您输入的字数过多请重新输入",131),
	ACCOUNTNUMBEREXIT("该账号已存在",132),
	ACCOUNTNUMBER_FORMAT("仅支持英文字母 、数字和下划线",133),
	ADMINPAWER_NOEXIT("该管理员未分配权限",134),
	USER_AUDITED("该用户已审核，请刷新页面",135),
	MANAGENOEXIST("管理员不存在",136),
	ADMIN_ROLE("管理员不能被分配角色",137),
	ROLE_USED("该角色正被管理员使用，请重新分配后，再进行删除",139),
	
	ALLOCATENOTCANCLE("须先取消预约后才允许再次预约",150),
	CANCELERROR("工人小哥哥快准备出发了，不能取消了",151),
	WORKERQUIT("该工人已离职",152),
	
	//字段验证
	check201("姓名不能包含特殊字符", 201),//
	check202("地址不能包含特殊字符", 202),//
	check203("发证机关不能包含特殊字符", 203),//
	check204("身份证号码有误", 204),//
	check205("军官证证号有误", 205),//
	check206("护照号码有误", 206),//
	check207("户号有误", 207),//
	check208("有效期限有误", 208),//
	check209("不动产单元编号有误", 209),//
	
	CHECK_BESPEAK_TYPE("需要先进行过装表操作才允许进行通气预约",210),//

	
	CHECK_BANNER_IMAGEURL("banner 上传时必须有播放图片",231),//
	
	CHECK_BANNER_MAX("banner 超出最大生效数量",233),//
	
	
	
	OPERATION_FALSE("操作执行失败",400),//
	
	EXCEPTION("服务器未知错误", 500),
	EXTERNALSERVERDIE("EXTERNAL服务已宕机", 501),
	REDIS("REDIS服务错误", 502),
	DATABASERROR("数据库服务错误", 503),
	
	PAYmethoderror("支付方式错误（0微信/1支付宝）",700),
	
	GoodsNull("商品不存在",800),
	GOODSPULLOFFSHELVES("商品已下架",801),
	GOODSSTOCKNUMNULL("商品库存不足",802),
	GOODSREPEAT("商品编号已存在，请检查",803),
	
	MATERIALEXIST("该材料已存在，请勿重复提交",820),
	MATERNOT("该表具不存在，请确认表号或是其他表具信息",821),
	
	PRICEERROR("价格不在合理范围",830),
	
	ORDERNULL("订单不存在",850),
	ORDERcancel("订单已取消",851),
	PAYORDERNULL("支付订单不存在",852),
	SENDNULL("配送信息不存在",853), 
	NOPAYMENT("您的订单暂未支付",854), 
	ORDERNOTPAY("该订单不能支付",855), 
	
	WORKNOTCANCEL("该工单已确认不能取消",860), 
	WORKERFULL("该工人当日已分配满8单不能再分配新的工单",861), 
	WORKERLEAVE("该工人已离职不能再分配新的工单",862), 
	WORKCANCEL("该工单用户已取消，请刷新页面",863), 
	WORKDISTRIBUTE("该工单已分配",864), 
	WORKSTATUSNO("该工单状态不允许调配",865), 
	
	DATA_ERROR_NULL("数据异常，数据为空",1000),//
	DATA_ERROR("数据异常，具体查看返回详情",1001),
	DATA_REPEAT("数据重复，请勿重复提交数据",1002),//
	
	NETWORK_ERROR("网络错误，请稍后重试",2001);
	
	// 成员变量
	private String name;
	private int index;

	// 构造方法
	private CodeMsg(String name, int index) {
		this.name = name;
		this.index = index;
	}

	// 普通方法
	public static String getName(int index) {
		for (CodeMsg c : CodeMsg.values()) {
			if (c.getIndex() == index) {
				return c.name;
			}
		}
		return "未知异常";
	}

	// get set 方法
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public static void main(String[] args) {
		System.out.println(CodeMsg.getName(100));
	}
}