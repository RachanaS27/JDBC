package com.zensar.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="skill")
public class Skill {

	@Id
	String skillName;
	@Column
	int skillLevel;
	
	public Skill() {
		super();
	}

	public Skill(int skillLevel) {
		super();
		this.skillLevel = skillLevel;
	}

	public Skill(String skillName) {
		super();
		this.skillName = skillName;
	}

	public Skill(String skillName, int skillLevel) {
		super();
		this.skillName = skillName;
		this.skillLevel = skillLevel;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public int getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(int skillLevel) {
		this.skillLevel = skillLevel;
	}

	@Override
	public String toString() {
		return "Skill [skillName=" + skillName + ", skillLevel=" + skillLevel + "]";
	}
	
	
}
