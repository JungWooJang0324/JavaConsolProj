package Credit;

import java.util.ArrayList;
import java.util.List;

public class GradeCalculator {
	private String name;
	private double lastScore;
	private int allCredit;
	private List<Course> courseList = new ArrayList<Course>();
	
	//직전학기 성적
	public GradeCalculator(String name, double lastScore, int allCredit) {
		this.name = name;
		this.lastScore = lastScore;
		this.allCredit= allCredit;
	}


	public void addCourse(Course course) {
		courseList.add(course);
	}
	
	//직전학기 총점
	public double lastScore() {
		return lastScore*allCredit;
	}
	
	//이번학기 총 점수
	public double thisScore() {
		double thisSemScore= 0.0;
		for(Course c: courseList) {
			thisSemScore += c.getScore() *c.getCredit();
		}
		
		return thisSemScore;
	}
	
	public int thisCredit() {
		int thisSemCredit=0;
		for(Course c : courseList) {
			thisSemCredit += c.getCredit();
		}
		return thisSemCredit;
	}
	
	public double allScoreSum() {
		double allScoreTotal = lastScore()+thisScore();
		return allScoreTotal/allCreditTotal();
		
	}
	public int allCreditTotal() {
		double allCreditTotal = allCredit;

		for(Course c: courseList) {
			allCreditTotal+= c.getCredit();
		}
		
		return (int)allCreditTotal;
	}
	
	public void print() {
		System.out.printf("직전학기 성적: %.1f (총 %d점)\n", lastScore, allCredit);
		System.out.printf("이번학기 성적: %.10f (총 %d학점)\n", thisScore()/thisCredit(), thisCredit());
		System.out.printf("전체학기 성적: %.10f (총 %d학점)\n", allScoreSum(),allCreditTotal());
	}
	
	
	
}
