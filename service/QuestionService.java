package onlineexam.service;
import onlineexam.model.Question;
import java.util.*;
import onlineexam.repository.QuestionRepository;

public class QuestionService {
	QuestionRepository qRepo =new QuestionRepository();
	
	public boolean isAddQuestion(Question q)
	{
		int qid = qRepo.getId();
		qid+=1;
		q.setId(qid);
		boolean b=qRepo.isAddQuestion(q);
		return b;
	}
	public ArrayList getAllQuestion()
	{
		ArrayList a=qRepo.getAllQuestion();
		return a.size()>0?a:null;
	}
	public boolean removeQuestion(int id)
	{
		return qRepo.removeQuestion(id);
	}
	public boolean updateQuestion(Question q1)
	{
		return qRepo.updateQuestion(q1);
	}
}
