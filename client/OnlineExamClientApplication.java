package onlineexam.client;
import java.util.*;

import onlineexam.model.Question;
import onlineexam.service.QuestionService;

public class OnlineExamClientApplication {
	public static void main(String[] args) {
		
		QuestionService qService = new QuestionService();
		do
		{
			System.out.println("1.Add new question");
			System.out.println("2.View all question");
			System.out.println("3.Add new exam with schedule");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter your choice:");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:{
				sc.nextLine();
				System.out.println("Enter Question,its Option and Answer");
				String qname=sc.nextLine();
				String op1=sc.nextLine();
				String op2=sc.nextLine();
				String op3=sc.nextLine();
				String op4=sc.nextLine();
				String answer=sc.nextLine();
				Question q=new Question(qname,op1,op2,op3,op4,answer);
				boolean b=qService.isAddQuestion(q);
				if(b)
				{
					System.out.println("Question added succesfully...");
				}
				else {
					System.out.println("Some problem...");
				}
				break;
			}
			
			case 2:
				ArrayList al=qService.getAllQuestion();
				if(al!=null)
				{
					for(Object obj:al)
					{
						Question q1=(Question)obj;
						System.out.println(q1.getId()+"\t"+q1.getName()+"\t"+q1.getOp1()+"\t"+q1.getOp2()+
								"\t"+q1.getOp3()+"\t"+q1.getOp4()+"\t"+q1.getAnswer());
					}
				}
				else
				{
					System.out.println("No questions are available...");
				}
				break;
				
			case 3:
			{
				System.out.println("Enter Exam name,date,StarTime,EndTime");
				String ename=sc.nextLine();
				String edate=sc.nextLine();
				String eStarTime=sc.nextLine();
				String eEndTime=sc.nextLine();
				Question q=new Question();
				boolean b=qService.isAddQuestion(q);
				if(b)
				{
					System.out.println("Question added succesfully...");
				}
				else {
					System.out.println("Some problem...");
				}
				break;
			}
			default:System.out.println("Please enter correct choice...");
			}
			
		}while(true);
		
	}
}
