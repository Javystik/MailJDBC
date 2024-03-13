package com.zoi4erom.mailjdbc.persistence.entity;

import java.util.ArrayList;

public class ParselType extends Entity{
	private int id;
	private String name;
	private String description;

	public ParselType(ParselTypeBuilder parselTypeBuilder) {
		this.id = parselTypeBuilder.id;
		this.name = parselTypeBuilder.name;
		this.description = parselTypeBuilder.description;
		this.validationMessages = new ArrayList<>();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ParselType{" +
		    "id=" + id +
		    ", name='" + name + '\'' +
		    ", description='" + description + '\'' +
		    '}';
	}
	public static ParselTypeBuilder builder(){
		return new ParselTypeBuilder();
	}

	public static class ParselTypeBuilder {
		private int id;
		private String name;
		private String description;

		public ParselTypeBuilder id(int id){
			this.id = id;
			return this;
		}
		public ParselTypeBuilder name(String name){
			this.name = name;
			return this;
		}
		public ParselTypeBuilder description(String description){
			this.description = description;
			return this;
		}
		public ParselType build(){
			return new ParselType(this);
		}
	}
}
