package one_to_one_uni_dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import one_to_one_uni_dto.Adharcard;
import one_to_one_uni_dto.Person;

public class PersonDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}
	public void savePerson(Person person) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		Adharcard adharcard=person.getAdharcard();
		entityManager.persist(adharcard);
		entityManager.persist(person);
		entityTransaction.commit();
	}
	public void updatePerson(int id,String name) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Person person1=entityManager.find(Person.class, id);
		person1.setName(name);
		entityTransaction.begin();
		entityManager.merge(person1);
		entityTransaction.commit();
	}
	public void delete(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Person person=entityManager.find(Person.class, id);
		Adharcard adharcard=person.getAdharcard();
		entityTransaction.begin();
		entityManager.remove(adharcard);
		entityManager.remove(person);
		entityTransaction.commit();
	}
	public void personDetailsOnId(int id) {
		EntityManager entityManager=getEntityManager();
		//EntityTransaction entityTransaction=entityManager.getTransaction();
		Person person=entityManager.find(Person.class, id);
		System.out.println(person);
		
	}
	public void getPersonDetailsAll() {
		EntityManager entityManager=getEntityManager();
		//EntityTransaction entityTransaction=entityManager.getTransaction();
		Query query=entityManager.createQuery("select s from Person s");
		List<Person> list=query.getResultList();
		System.out.println(list);
		//entityTransaction.begin();
	
	}

}
