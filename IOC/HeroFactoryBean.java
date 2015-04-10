package chap01;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.AbstractFactoryBean;


public class HeroFactoryBean extends AbstractFactoryBean<Hero> {
	Hero hero;
	public Class<?> getObjectType() {
		return Hero.class;
	}

	@Override
	protected Hero createInstance() throws Exception {
		List<String> list = new ArrayList<String>();
		list.add("会变带旗杆的庙宇");
		list.add("会变美女");
		hero.setTechs(list);//这些技能列表是动态变化的，可以来源于数据库,,...
		return hero;
	}

	public Hero getHero() {
		return hero;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}

}
