package OptionalClassProblems.CombinedProblemsOnStreamAndOptional;

class Student {
	int id;
	String name;
	int score;

	public Student(int id, String name, int score) {
		this.id = id;
		this.name = name;
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student{id=" + id + ", name='" + name + "', score=" + score + "}";
	}
}
