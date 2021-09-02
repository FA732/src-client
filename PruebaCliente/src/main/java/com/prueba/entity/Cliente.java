package com.prueba.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//This Class is the DAO, where you can create a entity and manipulate the date or information of DB H2, could be a specific table using 
//@Table (name ="name of table") or only a new table using @Entity.
//You cannot create a entity without a tag called @Id or @Column(name="name of column id"),as a consequence,table will not be recognized 
//by the @Entity or @Bean in Springboot.
@Entity
public class Cliente {
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	private String lastname;
	private Integer age;
	private String doc;
	public Cliente(Long id, String name, String lastname, Integer age, String doc) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.age = age;
		this.doc = doc;
	}
	public Cliente() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getDoc() {
		return doc;
	}
	public void setDoc(String doc) {
		this.doc = doc;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", name=" + name + ", lastname=" + lastname + ", age=" + age + ", doc=" + doc
				+ "]";
	}
	
}
