public class EmployeeDemo
{
    public static void printInfo(Employee e)
    {
        System.out.println(e.getName() + ", " + e.getIdNumber() + ", " + e.getDepartment() + ", " + e.getPosition());
    }

    public static void main(String[] args)
    {
        Employee e1 = new Employee();
        Employee e2 = new Employee("Bill Gates", 1975);
        Employee e3 = new Employee("Steve Jobs", 1976, "Design", "Engineer");

        printInfo(e1);
        printInfo(e2);
        printInfo(e3);
    }
}
