package onlineexam.repository;
import java.util.*;

import onlineexam.model.Question;

public class QuestionRepository {

	static ArrayList al=new ArrayList();
	
	
	public int getId()
	{
			return al.size();
	}
	
	public boolean isAddQuestion(Question q)
	{
		boolean b=al.add(q);
		return b;
	}
	public ArrayList getAllQuestion()
	{
		return al;
	}
		
}
