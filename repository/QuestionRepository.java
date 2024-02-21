package onlineexam.repository;
import java.util.*;

import onlineexam.model.Question;

public class QuestionRepository {

	static ArrayList al=new ArrayList();
	Scanner sc=new Scanner(System.in);
	
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
	public boolean removeQuestion(int id)
	{
		Object obj=null ;
		obj=al.remove(id-1);
		return obj!=null?true:false;
	}
	public boolean updateQuestion(Question q1)
	{
		try
		{
			System.out.println("Enter updated Question,its 4 Option and Answer");
			String qname = sc.nextLine();
			String op1 = sc.nextLine();
			String op2 = sc.nextLine();
			String op3 = sc.nextLine();
			String op4 = sc.nextLine();
			String answer = sc.nextLine();
			q1.setName(qname);
			q1.setOp1(op1);
			q1.setOp2(op2);
			q1.setOp3(op3);
			q1.setOp4(op4);
			q1.setAnswer(answer);
			 return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	
	}
		
}
