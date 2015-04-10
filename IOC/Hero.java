package chap01;
import java.util.List;
/**
 * 意中人
 */
public class Hero {
	String dress;
	private Teacher teacher;
	/**
	 * 技能列表
	 */
	private List<String> techs;
	public String getDress() {
		return dress;
	}

	public void setDress(String dress) {
		this.dress = dress;
	}

	public Hero(){
		
	}
	public Hero(String dress) {
		super();
		this.dress = dress;
	}

	public List<String> getTechs() {
		return techs;
	}

	public void setTechs(List<String> techs) {
		this.techs = techs;
	}

	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
}
