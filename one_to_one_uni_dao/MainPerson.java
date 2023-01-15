package one_to_one_uni_control;

import java.util.Scanner;
import one_to_one_uni_dao.PersonDao;
import one_to_one_uni_dto.Adharcard;
import one_to_one_uni_dto.Person;
public class MainPerson {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		boolean condition=true;
		PersonDao dao=new PersonDao();
		do {
			System.out.println("Enter your choice \n1 for save the person details\n2 for update person name \n3 for delte person details \n4 for get person details on Id \n5 for get all person details \n6 for exit");
			int choice=scanner.nextInt();
			switch (choice) {
			case 1:{
				System.out.println("Enter person id");
				int id =scanner.nextInt();
				System.out.println("Enter person name");
				String name=scanner.next();
				System.out.println("Enter person phone");
				long phone=scanner.nextLong();
				System.out.println("Enter address");
				String address=scanner.next();
				Person person=new Person();
				person.setAddress(address);
				person.setId(id);
				person.setPhone(phone);
				person.setName(name);
				System.out.println("Enter adhar id");
				int aid=scanner.nextInt();
				System.out.println("Enter adhar name");
				String name1=scanner.next();
				System.out.println("Enter address");
				String address1=scanner.next();
				Adharcard adharcard=new Adharcard();
				adharcard.setAddress(address1);
				adharcard.setAid(aid);
				adharcard.setName(name1);
				person.setAdharcard(adharcard);
				dao.savePerson(person);	
			}break;
			case 2:{
				System.out.println("Enter person id");
				int id=scanner.nextInt();
				System.out.println("Enter the new name ");
				String name=scanner.next();
				dao.updatePerson(id, name);
			}break;
			case 3:{
				System.out.println("Enter person id");
				int id=scanner.nextInt();
				dao.delete(id);
			}break;
			case 4:{
				System.out.println("Enter person id");
				int id=scanner.nextInt();
				dao.personDetailsOnId(id);
			}break;
			case 5:{
				System.out.println("The person has ");
				dao.getPersonDetailsAll();
			}break;
			case 6:{
				condition=false;
			}break;
			default:
			System.out.println("invalid choice");
			}
		} while (condition);
		System.out.println("Thank you.....!!!!");
	}
}