package lesson30.home;

import lesson30.home.enams.DepartmentType;

import java.util.Set;

public class Controller {

    //- employeesByProject(Project project) - список сотрудников, работающих над заданным проектом
    public Set<Employee> employeesByProject(Project project){
        //TODO
        return null;
    }

//- projectsByEMployee(Employee employee) список проектов, в которых участвует заданный сотрудник
    public Set<Project> projectsByEmployee(Employee employee) {
        //TODO
        return null;
    }

//- employeesByDepartmentWithoutProject() - список сотрудников из заданного отдела, не участвующих ни в одном проекте
    public Set<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType){
        //TODO
        return null;
    }

//- employeesWithoutProject() - список сотрудников, не участвующих ни в одном проекте
    public Set<Employee> employeesWithoutProject() {
        //TODO
        return null;
    }

//- employeesByTeamLead(Employee lead) - список подчиненных для заданного руководителя (по всем проектам, которыми он руководит)
    public Set<Employee> employeesByTeamLead(Employee lead) {
        //TODO
        return null;
    }

//- teamLeadsByEmployee(Employee employee) - список руководителей для заданного сотрудника (по всем проектам, в которых он участвует)
    public Set<Employee> teamLeadsByEmployee(Employee employee) {
        //TODO
        return null;
    }

//- employeesByProjectEmployee(Employee employee) - список сотрудников, участвующих в тех же проектах, что и заданный сотрудник
    public Set<Employee> employeesByProjectEmployee(Employee employee) {
        //TODO
        return null;
    }

//- projectsByCustomer(Customer customer) - список проектов, выполняемых для заданного заказчика
    public Set<Project> projectsByCustomer(Customer customer) {
        //TODO
        return null;
    }

//- employeesByCustomerProjects(Customer customer) - список сотрудников, участвующих в проектах, выполняемых для заданного заказчика
    public Set<Employee> employeesByCustomerProjects(Customer customer) {
        //TODO
        return null;
    }

}
