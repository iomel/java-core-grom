package lesson30.home;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {

        DepartmentDAO departmentDAO = DepartmentDAO.getInstance();
        EmployeeDAO employeeDAO = EmployeeDAO.getInstance();
        CustomerDAO customerDAO = CustomerDAO.getInstance();
        ProjectDAO projectDAO = ProjectDAO.getInstance();

        Controller controller = new Controller(employeeDAO, departmentDAO, customerDAO, projectDAO);

        Employee emp1 = new Employee(1234, "Vasya", "Pupkin", new Date(), Position.TEAM_LEAD);
        Employee emp2 = new Employee(1235, "Vova", "Chopin", new Date(), Position.DEVELOPER);
        Employee emp3 = new Employee(1236, "Anrdey", "Komin", new Date(), Position.TEAM_LEAD);
        employeeDAO.add(emp1);
        employeeDAO.add(emp2);
        employeeDAO.add(emp3);
//        System.out.println(EmployeeDAO.getEmployees());


        emp1.setDepartment(departmentDAO.getDepartmentByType(DepartmentType.DEVELOPMENT));
        emp2.setDepartment(departmentDAO.getDepartmentByType(DepartmentType.DEVELOPMENT));
        emp3.setDepartment(departmentDAO.getDepartmentByType(DepartmentType.DEVELOPMENT));

        Customer cust1 = new Customer("IBM");
        Customer cust2 = new Customer("GOOGLE");
        Customer cust3 = new Customer("Amazon");
        Customer cust4 = new Customer("Cisco");
        customerDAO.add(cust1);
        customerDAO.add(cust2);
        customerDAO.add(cust3);
        customerDAO.add(cust4);
//        System.out.println(CustomerDAO.getCustomers());

        Project proj1 = new Project(1111,"New search engine", cust2);
        Project proj2 = new Project(1211,"protocol", cust4);
        Project proj3 = new Project(1131,"shop assist", cust3);
        Project proj4 = new Project(1411,"GUI", cust2);
        projectDAO.add(proj1);
        projectDAO.add(proj2);
        projectDAO.add(proj3);
        projectDAO.add(proj4);
        projectDAO.add(null);
        System.out.println(projectDAO.getAll());

        System.out.println("New Project dao");
        ProjectDAO newProjDao = ProjectDAO.getInstance();
        System.out.println(newProjDao.getAll());

        emp1.addProject(proj1);
        emp1.addProject(proj2);
        emp2.addProject(proj1);
        emp2.addProject(proj2);
        emp2.addProject(proj3);
        emp3.addProject(proj2);
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
        System.out.println(controller.employeesByTeamLead(emp1));

//      6th method
//        System.out.println(controller.teamLeadsByEmployee(emp2));

//      7th method
        System.out.println(controller.employeesByProjectEmployee(emp2));

//      8th method
//        System.out.println(controller.projectsByCustomer(cust2));

//      9th method
//        System.out.println(controller.employeesByCustomerProjects(cust2));


    }
}
