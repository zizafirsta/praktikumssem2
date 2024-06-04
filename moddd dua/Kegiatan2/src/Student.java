public class Student {
    static boolean loginStudent = false;
    static boolean inginLogoutStudent = false;

    public static void displayBooks() {
        int noBuku = 1;
        System.out.print("=======================================================================================\n");
        System.out.print("|| No. \t|| Id buku \t\t\t|| Nama buku \t\t|| Author \t\t|| Category\t|| Stock ||\n");
        System.out.print("=======================================================================================\n");
        for (Object[] book : Main.bookList) {
            System.out.print("|| " + noBuku + "\t|| " + book[0] + " \t|| " + book[1] + " \t\t\t|| " + book[2] + " \t\t|| " + book[3] + " \t|| " + book[4] + "\t ||\n");
            noBuku++;
        }
        System.out.print("=======================================================================================\n");
    }

    public static void logout() {
        inginLogoutStudent = true;
    }
}
