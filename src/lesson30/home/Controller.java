package lesson30.home;

import java.util.HashSet;
import java.util.Set;

public class Controller {

    private EmployeeDAO employeeDAO;
    private DepartmentDAO departmentDAO;
    private CustomerDAO customerDAO;
    private ProjectDAO projectDAO;

    public Controller(EmployeeDAO employeeDAO, DepartmentDAO departmentDAO, CustomerDAO customerDAO, ProjectDAO projectDAO) {
        this.employeeDAO = employeeDAO;
        this.departmentDAO = departmentDAO;
        this.customerDAO = customerDAO;
        this.projectDAO = projectDAO;
    }

    //- employeesByProject(Project project) - список сотрудников, работающих над заданным проектом
    public Set<Employee> employeesByProject(Project project){
        return employeeDAO.getByProject(project);
    }

//- projectsByEmployee(Employee employee) список проектов, в которых участвует заданный сотрудник
    public Set<Project> projectsByEmployee(Employee employee) {
        return employee.getProjects();
    }

//- employeesByDepartmentWithoutProject() - список сотрудников из заданного отдела, не участвующих ни в одном проекте
    public Set<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType){
        Set<Employee> result = new HashSet<>();
        for (Employee e : employeeDAO.getByDepartment(departmentType))
            if(e != null && e.getProjects().isEmpty())
                result.add(e);
        return result;
    }

//- employeesWithoutProject() - список сотрудников, не участвующих ни в одном проекте
    public Set<Employee> employeesWithoutProject() {
        Set<Employee> result = new HashSet<>();
        for (Employee e : employeeDAO.getAll())
            if(e != null && e.getProjects().isEmpty())
                result.add(e);
        return result;
    }

//- employeesByTeamLead(Employee lead) - список подчиненных для заданного руководителя (по всем проектам, которыми он руководит)
    public Set<Employee> employeesByTeamLead(Employee lead) {
        Set<Employee> result = new HashSet<>();
        for (Employee e : employeeDAO.getByDepartment(lead.getDepartment().getType())) {
            // If result has include TeamLead in the result - remove the following IF verification!
            if (e.equals(lead))
                continue;
            for (Project leadProject : lead.getProjects())
                if (e.getProjects().contains(leadProject)) {
                    result.add(e);
                    break;
                }
        }
        return result;
    }

//- teamLeadsByEmployee(Employee employee) - список руководителей для заданного сотрудника (по всем проектам, в которых он участвует)
    public Set<Employee> teamLeadsByEmployee(Employee employee) {
        Set<Employee> leads = new HashSet<>();
        for (Employee e : this.employeesByProjectEmployee(employee))
            if (e.getPosition() == Position.TEAM_LEAD)
                leads.add(e);
        return leads;
    }

//- employeesByProjectEmployee(Employee employee) - список сотрудников, участвующих в тех же проектах, что и заданный сотрудник
    public Set<Employee> employeesByProjectEmployee(Employee employee) {
        Set<Employee> result = new HashSet<>();
        for (Project project : employee.getProjects())
            result.addAll(employeeDAO.getByProject(project));
        result.remove(employee);  // If employee should be in the final list too - remove this string!
        return result;
    }

//- projectsByCustomer(Customer customer) - список проектов, выполняемых для заданного заказчика
    public Set<Project> projectsByCustomer(Customer customer) {
        Set<Project> result = new HashSet<>();
        for (Project project : projectDAO.getAll())
            if (project != null && project.getCustomer().equals(customer))
                result.add(project);
        return result;
    }

//- employeesByCustomerProjects(Customer customer) - список сотрудников, участвующих в проектах, выполняемых для заданного заказчика
    public Set<Employee> employeesByCustomerProjects(Customer customer) {
        Set<Employee> result = new HashSet<>();
        Set<Project> customerProjects = this.projectsByCustomer(customer);
        for (Project project : customerProjects)
            result.addAll(employeeDAO.getByProject(project));
        return result;
    }

}
