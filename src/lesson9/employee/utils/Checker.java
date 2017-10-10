package lesson9.employee.utils;

public class Checker {

    public int companyNamesValidatedCount = 0;
    public boolean checkCompanyName(String companyName)
    {
        if(companyNamesValidatedCount > 10)
            return false;

        companyNamesValidatedCount++;
        return  (companyName != "Google" && companyName != "Amazon");
    }
}
