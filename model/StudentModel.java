package onlineexam.model;

public class StudentModel {

	private int id;
	private String name;
	private ExamScheduleModel model;
	private float per;

	public float getPer() {
		return per;
	}

	public void setPer(float per) {
		this.per = per;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ExamScheduleModel getModel() {
		return model;
	}

	public void setModel(ExamScheduleModel model) {
		this.model = model;
	}
}
