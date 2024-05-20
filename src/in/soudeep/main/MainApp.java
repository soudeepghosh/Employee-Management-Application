package in.soudeep.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import in.soudeep.controller.IEmployeeController;
import in.soudeep.dataobjects.EmployeeVo;
import in.soudeep.factory.EmployeeControllerFactory;

public class MainApp {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		IEmployeeController controller = EmployeeControllerFactory.getEmployeeController();
		
		while(true) {
			System.out.println("******* Welcome to Employee CRUD Application *******");
			System.out.println("1. INSERT");
			System.out.println("2. READ");
			System.out.println("3. UPDATE");
			System.out.println("4. DELETE");
			System.out.println("5. EXIT");
			System.out.print("ENTER YOUR CHOICE[1/2/3/4/5]:: ");
			String option = br.readLine();
			
			switch (option) {
			case "1":
				try {
					insertRecord(br, controller);
				} catch (Exception e) {
					System.out.println("Some thing went wrong...");
					e.printStackTrace();
				}
				break;
				
			case "2":
				try {
					readRecord(br, controller);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case "3":
				try {
					updateRecord(br, controller);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case "4":
				try {
					deleteRecord(br, controller);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case "5":
				System.out.println("***THANKS FOR USING THE APPLICATION****");
				System.exit(0);
				
			default:
				break;
			}
		}
	}

	private static void insertRecord(BufferedReader br, IEmployeeController controller) throws Exception {
		System.out.print("Enter the name:: ");
		String ename = br.readLine();

		System.out.print("Enter the age:: ");
		String eage = br.readLine();

		System.out.print("Enter the salary:: ");
		String esal = br.readLine();

		System.out.print("Enter company name:: ");
		String company = br.readLine();

		EmployeeVo empVo = new EmployeeVo();
		empVo.setEname(ename);
		empVo.setEage(eage);
		empVo.setEsal(esal);
		empVo.setCompany(company);

		System.out.println("****SENDING VO TO CONTROLLER*****");
		String status = controller.insertRecord(empVo);
		if (status.equalsIgnoreCase("success")) {
			System.out.println("Record inserted succesfully...");
		} else {
			System.out.println("Record insertion failure...");
		}
		
	}
	
	private static void readRecord(BufferedReader br, IEmployeeController controller) throws Exception {
		System.out.print("Enter the id:: ");
		String id = br.readLine();
		EmployeeVo empVo = controller.readRecord(id);

		if (empVo == null) {
			System.out.println("Record not found for the given id :: " + id);
		} else {
			System.out.println(empVo);
		}
		
	}
	
	private static void updateRecord(BufferedReader br, IEmployeeController controller) throws Exception {
		System.out.print("Enter the id:: ");
		String id = br.readLine();

		EmployeeVo empVo = controller.readRecord(id);
		
		if (empVo != null) {

			// ID should not be altered :: PK
			System.out.println("STUEDENT ID :: " + empVo.getEid());
			empVo.setEid(empVo.getEid());

			// Asking for updation :: Name
			System.out.print("STUDENT OLDNAME IS :: " + empVo.getEname() + "\nENTER NEW NAME :: ");
			String newName = br.readLine();
			if (newName.equals("") || newName == "") {
				empVo.setEname(empVo.getEname());
			} else {
				empVo.setEname(newName);
			}

			// Asking for updation :: Age
			System.out.print("STUDENT AGE IS :: " + empVo.getEage() + "  \nENTER NEW AGE :: ");
			String newAge = br.readLine();
			if (newAge.equals("") || newAge == "") {
				empVo.setEage(empVo.getEage());
			} else {
				empVo.setEage(newAge);
			}

			// Asking for updation :: salary
			System.out.print("Employee Salary is :: " + empVo.getEsal() + "  \nENTER NEW SALARY :: ");
			String newSal = br.readLine();
			if (newSal.equals("") || newSal == "") {
				empVo.setEsal(empVo.getEsal());
			} else {
				empVo.setEsal(newSal);
			}
			
			// Asking for updation :: company
			System.out.print("Employee Salary is :: " + empVo.getCompany() + "  \nENTER NEW COMPANY :: ");
			String newCom = br.readLine();
			if (newCom.equals("") || newCom == "") {
				empVo.setCompany(empVo.getCompany());
			} else {
				empVo.setCompany(newCom);
			}			
			
			System.out.println("Record sending for updation is :: "+empVo);
			
			String status = controller.updateRecord(empVo);
			if (status.equalsIgnoreCase("success")) {
				System.out.println("Record updated succefully for the id :: " + id);
			} else {
				System.out.println(status);
			}

		} else {
			System.out.println("Record not available for updation :: " + id);
		}
		
	}

	private static void deleteRecord(BufferedReader br, IEmployeeController controller) throws Exception {
		System.out.print("Enter the id:: ");
		String id = br.readLine();
		String status = controller.deleteRecord(id);
		if (status.equalsIgnoreCase("success")) {
			System.out.println("Record deleted succesfully...");
		} else
			System.out.println("Record not found for deletion...");
	}

	

}
