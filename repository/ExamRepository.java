package onlineexam.repository;

import java.util.ArrayList;
import java.util.Scanner;

import onlineexam.model.ExamScheduleModel;
import onlineexam.model.Question;

public class ExamRepository {
	static QuestionRepository qr=new QuestionRepository();
	static ArrayList examsch=new ArrayList();
	Scanner sc=new Scanner(System.in);
	ExamScheduleModel model=null;
	
	
	public boolean scheduleExam(ExamScheduleModel model)
	{
		this.model=model;
		ArrayList al=qr.getAllQuestion();
		if(al.size()>0)
		{
			model.setQuestionBank(al);
			examsch.add(model);
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public ExamScheduleModel getExamSchedule()
	{
		return model!=null?model:null;
	}
	public ArrayList getExamSchedules()
	{
		return examsch.size()>0?examsch:null;
	}
	public boolean updateExamSchedule(ExamScheduleModel q1)
	{
		try
		{
			System.out.println("Enter Exam name,date,StarTime and EndTime");
			String ename = sc.nextLine();
			String edate = sc.nextLine();
			String eStarTime = sc.nextLine();
			String eEndTime = sc.nextLine();
			q1.setName(ename);
			q1.setDate(edate);
			q1.setStaTime(eStarTime);
			q1.setEndTime(eEndTime);
			 return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	
	}

}
