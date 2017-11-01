package lesson30.home;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Controller controller = new Controller();

        Employee emp1 = new Employee(1234, "Vasya", "Pupkin", new Date(), Position.TEAM_LEAD);
        Employee emp2 = new Employee(1235, "Vova", "Chopin", new Date(), Position.DEVELOPER);
        Employee emp3 = new Employee(1236, "Anrdey", "Komin", new Date(), Position.TEAM_LEAD);
        EmployeeDAO.add(emp1);
        EmployeeDAO.add(emp2);
        EmployeeDAO.add(emp3);
//        System.out.println(EmployeeDAO.getEmployees());

        for (DepartmentType d : DepartmentType.values())
            DepartmentDAO.getDepartments().add(new Department(d));

        emp1.setDepartment(DepartmentDAO.getDepartmentByType(DepartmentType.DEVELOPMENT));
        emp2.setDepartment(DepartmentDAO.getDepartmentByType(DepartmentType.DEVELOPMENT));
        emp3.setDepartment(DepartmentDAO.getDepartmentByType(DepartmentType.DEVELOPMENT));

        Customer cust1 = new Customer("IBM");
        Customer cust2 = new Customer("GOOGLE");
        Customer cust3 = new Customer("Amazon");
        Customer cust4 = new Customer("Cisco");
        CustomerDAO.add(cust1);
        CustomerDAO.add(cust2);
        CustomerDAO.add(cust3);
        CustomerDAO.add(cust4);
//        System.out.println(CustomerDAO.getCustomers());

        Project proj1 = new Project(1111,"New search engine", cust2);
        Project proj2 = new Project(1211,"protocol", cust4);
        Project proj3 = new Project(1131,"shop assist", cust3);
        Project proj4 = new Project(1411,"GUI", cust2);
        ProjectDAO.add(proj1);
        ProjectDAO.add(proj2);
        ProjectDAO.add(proj3);
        ProjectDAO.add(proj4);
        ProjectDAO.add(null);
        System.out.println(ProjectDAO.getProjects());

        emp1.addProject(proj1);
        emp1.addProject(proj2);
        emp2.addProject(proj1);
        emp2.addProject(proj4);
        emp3.addProject(proj4);

        //       1st method
//      System.out.println(controller.employeesByProject(proj1));

//      2nd method
//        System.out.println(controller.projectsByEmployee(emp1));

//      3rd method
//        System.out.println(controller.employeesByDepartmentWithoutProject(DepartmentType.DEVELOPMENT));

//      4th method
//        System.out.println(controller.employeesWithoutProject());

//      5th method
//        System.out.println(controller.employeesByTeamLead(emp1));

//      6th method
        System.out.println(controller.teamLeadsByEmployee(emp2));

//      7th method
        System.out.println(controller.employeesByProjectEmployee(emp2));

//      8th method
//        System.out.println(controller.projectsByCustomer(cust2));

//      9th method
//        System.out.println(controller.employeesByCustomerProjects(cust2));


    }
}
