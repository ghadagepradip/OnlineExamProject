package onlineexam.service;
import java.util.*;
import onlineexam.model.ExamScheduleModel;
import onlineexam.model.Question;
import onlineexam.repository.ExamRepository;

public class ExamServices {
	
	ExamRepository ex=new ExamRepository();
	public boolean scheduleExam(ExamScheduleModel model)
	{
		return ex.scheduleExam(model);
	}
	
	public ExamScheduleModel getExamSchedule()
	{
		return ex.getExamSchedule();
	}
	public ArrayList getExamSchedules()
	{
		return ex.getExamSchedules();
	}
	public boolean updateExamSchedule(ExamScheduleModel q1)
	{
		return ex.updateExamSchedule(q1);
	}

}
