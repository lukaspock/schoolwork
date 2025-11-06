package at.htlpinkafeld.Employee;


public class TestAbstract {
    public static double calcTotalWages(Employee[] allEmp){
        double retVal = 0;

        for(Employee emp: allEmp)
            retVal += emp.getWage();

        return retVal;
    }

    public static void main(String[] args){
        Employee[] company = new Employee[5];
        double totWage;

        company[0] = new Worker(1,1,1,"Vortschi");
        company[1] = new Worker(2,2,2,"Justin");
        company[2] = new OfficeWorker(3,3,3,"Sinan");
        company[3] = new OfficeWorker(4,4,4,"Kinni");
        company[4] = new Manager(5,5,5,"Posch",5,5,5);

        totWage = calcTotalWages(company);
        System.out.println("The overall salary for all employees is " + totWage);
    }
}
