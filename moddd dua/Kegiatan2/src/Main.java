import java.util.*;

public class Main {
    static Object[][] bookList = {
            {"388c-e681-9152", "title1", "author1", "Sejarah", 4},
            {"ed90-be30-5cdb", "title2", "author2", "Sejarah", 0},
            {"d95e-0c4a-9523", "title3", "author3", "Sejarah", 2}
    };

    static String[][] dataStudent = new String[10][4];
    static int jumlahStudent = 0;

    static boolean exitMainMenu = false;

    public static void main(String[] args) {
        dataStudent[0] = new String[]{"Taufiq Ramadhan", "Teknik", "202210370311208", "Informatika"};
        jumlahStudent++;
        dataStudent[1] = new String[]{"Who", "Teknik", "200510370310521", "Informatika"};
        jumlahStudent++;

        while (!exitMainMenu) {
            Menu();
        }
    }

    static public void Menu() {
        Scanner input = new Scanner(System.in);

        System.out.println("=== Library System ===");
        System.out.println("1. Login as Student");
        System.out.println("2. Login as Admin");
        System.out.println("3. Exit");
        System.out.print("Choose option (1-3): ");
        int option = input.nextInt();

        switch (option) {
            case 1:
                inputNim();
                break;
            case 2:
                String usernameAdmin = "admin";
                String passwordAdmin = "admin";

                System.out.print("Enter your username (admin): ");
                String username = input.next();
                System.out.print("Enter your password (admin): ");
                String password = input.next();

                if (username.equals(usernameAdmin) && password.equals(passwordAdmin)) {
                    System.out.println("Successfully login as Admin.");
                    Admin.loginAdmin = true;
                    menuAdmin();
                } else {
                    System.out.println("Invalid credentials for admin.");
                }
                break;
            case 3:
                exitMainMenu = true;
                System.out.println("Thank you. Exiting program.");
                return;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
    }

    public static void inputNim() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your NIM (input 99 untuk back): ");
        String nim = input.next();
        checkNim(nim);
    }

    public static void checkNim(String nim) {
        if (nim.equals("99")) {
            return;
        }

        for (String[] user : dataStudent) {
            System.out.println(user[2]);
            if(user[0] != null) {
                if (user[2].equals(nim)) {
                    System.out.println("Successfully login as Student.");
                    Student.loginStudent = true;
                    menuStudent();
                    return;
                }
            }
        }

        System.out.println("NIM not found.");
    }

    public static void menuAdmin() {
        Scanner input = new Scanner(System.in);

        while (Admin.loginAdmin) {
            System.out.println("=== Admin Menu ===");
            System.out.println("1. Add Student");
            System.out.println("2. Display Registered Students");
            System.out.println("3. Logout");
            System.out.print("Choose option (1-3): ");
            int option = input.nextInt();

            switch (option) {
                case 1:
                    Admin.addStudent();
                    break;
                case 2:
                    Admin.displayStudents();
                    break;
                case 3:
                    Admin.loginAdmin = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    public static void menuStudent() {
        Scanner input = new Scanner(System.in);

        while (Student.loginStudent) {
            System.out.println("=== Student Menu ===");
            System.out.println("1. Buku terpinjam");
            System.out.println("2. Pinjam buku");
            System.out.println("3. Pinjam buku atau Logout");
            System.out.print("Choose option (1-3): ");
            int option = input.nextInt();

            switch (option) {
                case 1:
                    Student.displayBooks();
                    break;
                case 2:
                    boolean adaID = false;
                    System.out.print("Input Id buku yang ingin dipinjam: ");
                    String id_buku = input.next();
                    for (Object[] book : bookList) {
                        if(!adaID) {
                            if (book[0].equals(id_buku)) {
                                adaID = true;
                                if ((int)book[4] != 0) {
                                    book[4] = (int)book[4] - 1;
                                    System.out.println("Successfully borrowed the book.");
                                    break;
                                }else {
                                    System.out.print("There is no stock of the book.");
                                }
                            }
                        }
                    }

                    if(!adaID) {
                        System.out.println("Id book not found.");
                    }
                    break;
                case 3:
                    if (!Student.inginLogoutStudent) {
                        Student.displayBooks();
                        System.out.print("Input Id buku yang ingin dipinjam (input 99 untuk back): ");
                        id_buku = input.next();
                        boolean IDada = false;
                        if (id_buku.equals("99")) {
                            Student.logout();
                            break;
                        }
                        for (Object[] book : bookList) {
                            if (!IDada) {
                                if (book[0].equals(id_buku)) {
                                    IDada = true;
                                    if ((int) book[4] != 0) {
                                        book[4] = (int) book[4] - 1;
                                        System.out.println("Successfully borrowed the book.");
                                    } else {
                                        System.out.print("There is no stock of the book.");
                                    }
                                }
                            }
                        }

                        if (!IDada) {
                            System.out.println("Id book not found.");
                        }
                        Student.logout();
                    }else {
                        System.out.println("System Logout...\n");
                        Student.loginStudent = false;
                    }
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }


}
