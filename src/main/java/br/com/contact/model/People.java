package br.com.contact.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "people")
public class People {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "people_id")
	private Long idPeople;

	@NotNull(message = "people name can't be null")
	@Column(name = "name")
	private String name;

	@NotNull(message = "people age can't be null")
	@Min(1)
	@Column(name = "age")
	private Integer age;

	@OneToMany(mappedBy = "idContact", cascade = CascadeType.ALL)
	@Column(name = "people_contact_id")
	private Set<Contact> peopleContact;

	public People() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Set<Contact> getPeopleContact() {
		return peopleContact;
	}

	public void setPeopleContact(Set<Contact> peopleContact) {
		this.peopleContact = peopleContact;
	}

	public Long getIdPeople() {
		return idPeople;
	}

	public void setIdPeople(Long idPeople) {
		this.idPeople = idPeople;
	}

}
