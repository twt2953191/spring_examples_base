package chap02;

import org.apache.commons.lang.StringUtils;

public class HighManFactoryBean {
	//必须是静态方法
	public static HighMan newHighMan(String book){
		HighMan hm = new HighMan();
		if(StringUtils.equals(book, "九阴真经")){
			hm.setName("周芷若");
		}else if(StringUtils.equals(book, "玉女心经")){
			hm.setName("小龙女");
		}
		return hm;
	}
}
