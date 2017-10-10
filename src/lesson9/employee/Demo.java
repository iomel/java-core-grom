package lesson9.employee;

import lesson9.employee.utils.Checker;

public class Demo {
    public static void main(String[] args) {
        Company company = new Company("KJD", "Vietnam");

        System.out.println(company.getCountryFounded());
        System.out.println(company.getName());


        Checker checker = new Checker();
        System.out.println(checker.checkCompanyName(company.getName()));
        System.out.println(checker.companyNamesValidatedCount);


    }
}
