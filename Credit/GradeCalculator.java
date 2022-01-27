package Credit;

import java.util.ArrayList;
import java.util.List;

public class GradeCalculator {
	private String name;
	private double lastScore;
	private int allCredit;
	private List<Course> courseList = new ArrayList<Course>();
	
	//�����б� ����
	public GradeCalculator(String name, double lastScore, int allCredit) {
		this.name = name;
		this.lastScore = lastScore;
		this.allCredit= allCredit;
	}


	public void addCourse(Course course) {
		courseList.add(course);
	}
	
	//�����б� ����
	public double lastScore() {
		return lastScore*allCredit;
	}
	
	//�̹��б� �� ����
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
		System.out.printf("�����б� ����: %.1f (�� %d��)\n", lastScore, allCredit);
		System.out.printf("�̹��б� ����: %.10f (�� %d����)\n", thisScore()/thisCredit(), thisCredit());
		System.out.printf("��ü�б� ����: %.10f (�� %d����)\n", allScoreSum(),allCreditTotal());
	}
	
	
	
}
