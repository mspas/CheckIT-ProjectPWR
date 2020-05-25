package com.checkit.response.entity;

public class StudentWithPresencesAmout extends Student {

	private int presences;

	public StudentWithPresencesAmout(String name, String mail, Long id, long indeks, int presences) {
		super(name, mail, id, indeks);
		this.presences = presences;
	}

	public int getPresences() {
		return presences;
	}

	public void setPresences(int presences) {
		this.presences = presences;
	}

}
