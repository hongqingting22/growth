package com.lxl;


import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ConstantData {

	private static Map<String,String> indexMap = new HashMap<String,String>();//敏感号码


	private static final int num = 6;

	//修改需要同步job项目的公司列表
	static{
		indexMap.put("1730", Constant.INDEX_NAME_1);
		indexMap.put("8362", Constant.INDEX_NAME_1);
		indexMap.put("920", Constant.INDEX_NAME_1);
		indexMap.put("6741", Constant.INDEX_NAME_1);
		indexMap.put("3883", Constant.INDEX_NAME_1);
		indexMap.put("5401", Constant.INDEX_NAME_1);
		indexMap.put("23dc13b71a784e9c9962efd10accf7d4", Constant.INDEX_NAME_1);
		indexMap.put("88786ad01ffc4023841d7960543bd851", Constant.INDEX_NAME_1);
		indexMap.put("a776bce7681b499a9c8048cc477a27ba", Constant.INDEX_NAME_1);
		indexMap.put("934ae7bde2c14af9a0ec26055fc214ce", Constant.INDEX_NAME_1);
		indexMap.put("8172422beeb84b25afba9b333e0328e2", Constant.INDEX_NAME_1);
		indexMap.put("32e61778e0ca47a988cd277e7382b4a3", Constant.INDEX_NAME_1);
		indexMap.put("13043706ea504adda213792906f568d9", Constant.INDEX_NAME_1);
		indexMap.put("12a56e55daff4d2285c76fdc3ba47cb2", Constant.INDEX_NAME_1);
		indexMap.put("0fd1ba000ce94bb1a178f333587c2439", Constant.INDEX_NAME_1);
		indexMap.put("b96b3e57c0814d9d987bd21efc7c5934", Constant.INDEX_NAME_1);

		indexMap.put("cc0cf423ce6f42f2ad2f2e1857f52503", Constant.INDEX_NAME_1);
		indexMap.put("4075", Constant.INDEX_NAME_1);
		indexMap.put("924", Constant.INDEX_NAME_1);
		indexMap.put("a74bd70fbd4c45aa810e693f7a382a18", Constant.INDEX_NAME_1);
		indexMap.put("2328cf9b26a648878caf455be55c507f", Constant.INDEX_NAME_1);
		indexMap.put("2939", Constant.INDEX_NAME_1);
		indexMap.put("901", Constant.INDEX_NAME_1);
		indexMap.put("4982", Constant.INDEX_NAME_1);


		indexMap.put("8372", Constant.INDEX_NAME_2);
		indexMap.put("204", Constant.INDEX_NAME_2);
		indexMap.put("2895", Constant.INDEX_NAME_2);
		indexMap.put("1313", Constant.INDEX_NAME_2);
		indexMap.put("3162", Constant.INDEX_NAME_2);
		indexMap.put("1220", Constant.INDEX_NAME_2);
		indexMap.put("5462", Constant.INDEX_NAME_2);
		indexMap.put("c25049aef2284c18ae78ecd019114cd7", Constant.INDEX_NAME_2);
		indexMap.put("aac02a3181c94a1c991a8e1cf559e352", Constant.INDEX_NAME_2);
		indexMap.put("fcf7665c86fe48d795058eea91f5d271", Constant.INDEX_NAME_2);
		indexMap.put("03fe99c189194c52961468e9f59974f1", Constant.INDEX_NAME_2);
		indexMap.put("b460438565e14341a27ea88fbc757994", Constant.INDEX_NAME_2);
		indexMap.put("144246c9a64e4c6093ad6e09cafc2bb7", Constant.INDEX_NAME_2);
		indexMap.put("20ab7dce1e3346e8b90b649bd8baf591", Constant.INDEX_NAME_2);
		indexMap.put("3bbb6b89ca044eb69360c1a6cc742dbf", Constant.INDEX_NAME_2);
		indexMap.put("545a1dc0a4a646889ede877d16451268", Constant.INDEX_NAME_2);
		indexMap.put("613b490be53d49e58e97db76dc3dec34", Constant.INDEX_NAME_2);
		indexMap.put("d1495edfe9834b2ea76b205d3f6e9697", Constant.INDEX_NAME_2);

		indexMap.put("a9a33a54e6374c778185cbdbbcd87c02", Constant.INDEX_NAME_2);
		indexMap.put("4988", Constant.INDEX_NAME_2);
		indexMap.put("19ced614a9224be08f600e4426235efe", Constant.INDEX_NAME_2);
		indexMap.put("e6a1cbb19100481ab00d8b3026e2af6f", Constant.INDEX_NAME_2);
		indexMap.put("d455de035d764e9f8c2b9f3d1fe8d3a3", Constant.INDEX_NAME_2);
		indexMap.put("4956", Constant.INDEX_NAME_2);
		indexMap.put("95f145b6c90c48a19783af9d0f6a0f44", Constant.INDEX_NAME_2);
		indexMap.put("6ee01aaeaa76422391e1bf027215b81a", Constant.INDEX_NAME_2);
		indexMap.put("9435e7856f95462aafe398067b3f3f0a", Constant.INDEX_NAME_2);


		indexMap.put("316", Constant.INDEX_NAME_3);
		indexMap.put("4547", Constant.INDEX_NAME_3);
		indexMap.put("3135", Constant.INDEX_NAME_3);
		indexMap.put("9e30de40563c4d95af9fe701d8e9519a", Constant.INDEX_NAME_3);
		indexMap.put("9d893303283d4a7d9e3e267157567411", Constant.INDEX_NAME_3);
		indexMap.put("6429ade2acbf495cb3f69bf0dbdedb13", Constant.INDEX_NAME_3);
		indexMap.put("6b76159f05bb467fa4f8bc0e1a1f66cf", Constant.INDEX_NAME_3);
		indexMap.put("37c29f97190c47b783e7be0c3291e76c", Constant.INDEX_NAME_3);
		indexMap.put("10514", Constant.INDEX_NAME_3);
		indexMap.put("a0e2fe0dd27d49078c8e954486c45b87", Constant.INDEX_NAME_3);
		indexMap.put("95174886a4eb441da3538ee0d98abd47", Constant.INDEX_NAME_3);
		indexMap.put("a5a6699de68b444cae8b94527ed96e73", Constant.INDEX_NAME_3);
		indexMap.put("afdac111c9f24dd7bf2fe1131feae72b", Constant.INDEX_NAME_3);
		indexMap.put("b5dc48a7e6b04dcdb74f5c21f82f3b2c", Constant.INDEX_NAME_3);
		indexMap.put("c107b3284c214404998aa05d621e1f7f", Constant.INDEX_NAME_3);
		indexMap.put("c370211e8c41490eb9b7a70f741fcbbf", Constant.INDEX_NAME_3);
		indexMap.put("dba317c8371c4b0ca08658960a4e36fa", Constant.INDEX_NAME_3);

		indexMap.put("2444", Constant.INDEX_NAME_3);
		indexMap.put("9910", Constant.INDEX_NAME_3);
		indexMap.put("4874", Constant.INDEX_NAME_3);
		indexMap.put("16dbe3a2a40842668732fe3a4b7e8c08", Constant.INDEX_NAME_3);
		indexMap.put("a08c00b9a8d340e485d297cf54599254", Constant.INDEX_NAME_3);
		indexMap.put("581056622eda44d3be1b4a07342f45f0", Constant.INDEX_NAME_3);
		indexMap.put("4948", Constant.INDEX_NAME_3);
		indexMap.put("f78376109888493f9a79634a0c6aee0a", Constant.INDEX_NAME_3);
		indexMap.put("51198d62b6574403a0b7e85d72d31b78", Constant.INDEX_NAME_3);
		indexMap.put("4c44c40982d74b44811ad8fb91407794", Constant.INDEX_NAME_2);
		indexMap.put("8b1ffba807764bc3bf2da878e5bb3df6", Constant.INDEX_NAME_2);


		//新增队列固定的调整
		indexMap.put("5515456d96b54fba8f84c1edb8361cdb", Constant.INDEX_NAME_4);
		indexMap.put("a0b937bf3de445f5ad0063e2d0024eaf", Constant.INDEX_NAME_4);
		indexMap.put("b5f3078e0e514c1cb93243f5d6dfd09d", Constant.INDEX_NAME_5);
		indexMap.put("eb8a96f4fd1647fda3fcd90879976470", Constant.INDEX_NAME_5);
		indexMap.put("42981bb2c1bc4f0eba40837c3579470a", Constant.INDEX_NAME_6);
		indexMap.put("a6e3a0c606cc49a89cc30733be30075e", Constant.INDEX_NAME_6);
		indexMap.put("fb2bdaba0d8c4fe2bb8ccfdf2a1f02be", Constant.INDEX_NAME_6);

		indexMap.put("ee71a51d98ab44eabdcd1028a2869848", Constant.INDEX_NAME_04);
	}

	public static String getIndexMap(String companyId) {
		String index = indexMap.get(companyId);
		if(StringUtils.isEmpty(index)){
			int i = hashFunc(companyId);
			String indexI = String.valueOf(i);
			if(indexI.length() == 2){
				indexI = indexI.substring(1,2);
			}
			index = Constant.INDEX_NAME + indexI;
		}
		return index;
	}



	


	public static int hashFunc(String key){
		int code = -key.hashCode();
		return code % num;
	}
	public static int hashFuncDefault(String key){
		int code = -key.hashCode();
		return code % 3;
	}



	public static String getAnswerFlagColumn(Integer answerFlag){

		String column = "";//1文本，2图片，3图文，4视频
		switch (answerFlag) {
			case 1:
				column = "文本";
				break;
			case 2:
				column = "图片";
				break;
			case 3:
				column = "图文";
				break;
			case 4:
				column = "视频";
				break;
			default:
				column = "其他";
				break;
		}
		return column;
	}
	public static String getUsedFlagColumn(Integer usedFlag){

		String column = "";//0启用，1手动停用，2系统停用，3过期停用，9删除
		switch (usedFlag) {
			case 0:
				column = "启用";
				break;
			case 1:
				column = "手动停用";
				break;
			case 2:
				column = "系统停用";
				break;
			case 3:
				column = "过期停用";
				break;
			case 9:
				column = "删除";
				break;
			default:
				column = "其他";
				break;
		}
		return column;
	}
	public static String getMatchNameColumn(Integer matchFlag){

		String column = "";//0智能匹配，1完全匹配，2包含匹配，3欢迎语匹配
		switch (matchFlag) {
			case 0:
				column = "智能匹配";
				break;
			case 1:
				column = "完全匹配";
				break;
			case 2:
				column = "包含匹配";
				break;
			case 3:
				column = "欢迎语匹配";
				break;
			default:
				column = "其他";
				break;
		}
		return column;
	}
	public static Integer getMatchFlagColumn(String matchName){
		//0智能匹配，1完全匹配，2包含匹配，3欢迎语匹配
		Integer matchFalg = -1;
		if("智能匹配".equals(matchName)){
			matchFalg = 0;
		}else if("完全匹配".equals(matchName)){
			matchFalg = 1;
		}else if("包含匹配".equals(matchName)){
			matchFalg = 2;
		}else{
			matchFalg = -1;
		}
		return matchFalg;
	}

	/**
	 * 判断时间格式是否正确
	 * @param str yyyy-MM-dd
	 * @return
	 */
	public static boolean isValidDate(String str) {
		//String str = "2007-01-02";
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try{
			Date date = (Date)formatter.parse(str);
			return str.equals(formatter.format(date));
		}catch(Exception e){
			return false;
		}
	}

	/**
	 * 判断时间格式是否正确
	 * @param str yyyy-MM-dd
	 * @param pattern yyyy-MM-dd
	 * @return
	 */
	public static boolean isValidDate(String str,String pattern) {
		//String str = "2007-01-02";
		if(StringUtils.isEmpty(pattern))
			pattern = "yyyy-MM-dd";
		DateFormat formatter = new SimpleDateFormat(pattern);
		try{
			formatter.parse(str);
		}catch(Exception e){
			return false;
		}
		return true;
	}

	/**
	 * 判断字符串日期是否为指定 格式化 的日期类型
	 * @param date 检测日期
	 * @param pattern 检测日期格式
	 * @return
	 */
	public static boolean isDateByPattern(String date,String pattern) {
		if(StringUtils.isEmpty(pattern)||StringUtils.isEmpty(date)) {
			return false;
		}
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		try {
			format.parse(date);
		} catch (ParseException e) {
			return false;
		}
		return true;

	}
	public static void main(String[] args) throws InterruptedException {
//		String effectStr = "2016-12-12,2017-7-20";
//		String[] dateStr =  effectStr.split(",");
//		System.out.println(ConstantData.isValidDate(dateStr[0]));
//		System.out.println(ConstantData.isValidDate(dateStr[1]));

		while (true){
			String companyId = "39f71a5a66db48fbb8ae4e2bfade84cf";
			String index = getIndexMap(companyId);
			System.out.println(index);

			System.out.println("=================");
			TimeUnit.MILLISECONDS.sleep(600);
		}


	}

}
