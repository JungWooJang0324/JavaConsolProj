package Credit;

public class Course {
	public static final int CREDIT_MAJOR = 3;
	public static final int CREDIT_GENERAL = 2;
	private String className;
	private int credit;
	private String score;
	
	public Course(String className, int credit, String score) {
		this.className = className;
		this.credit = credit;
		this.score= score;
	}
	
	
	@Override
	public String toString() {
		return "Course [className=" + className + ", credit=" + credit + ", score=" + score + "]";
	}

	
	public int getCredit() {
		return credit;
	}
	
	public double getScore() {
		double s=0.0;
		
		switch(score) {
		case "A+": s=4.5;break;
		case "A": s=4.0;break;
		case "B+": s=3.5;break;
		case "B": s=3.0;break;
		case "C+": s=2.5;break;
		case "C": s=2.0;break;
		case "D+": s=1.5;break;
		case "D": s=1.0;break;
		
		}
		
		return s;
	}
	
	
	
	
}
