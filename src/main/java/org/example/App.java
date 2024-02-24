package org.example;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args ) throws SQLException {
        operation op = new operation();
        Scanner sc = new Scanner(System.in);
        int choice = 0,acc_no = 0;
        System.out.println("Do you already have an account");
        int active = sc.next().charAt(0);
        if(active == 'y' || active == 'Y'){
            System.out.println("Enter your account number");
            acc_no = sc.nextInt();
            System.out.println("1. Check Balance\n2. Withdraw Money\n3. Deposit Money\n4. Delete Account");
            choice = sc.nextInt();
            sc.nextLine();
        }else if(active == 'n' || active == 'N'){
            op.new_acc();
            System.out.println("1. Check Balance\n2. Withdraw Money\n3. Deposit Money\n4. Delete Account");
            choice = sc.nextInt();
            sc.nextLine();
        }else{
            System.out.println("Please try again and enter valid input");
            System.exit(0);
        }
        while(choice != 0){
            switch (choice){
                case 1:
                    op.check_bal(acc_no);
                    break;
                case 2:
                    op.withdraw(acc_no);
                    break;
                case 3:
                    op.deposit(acc_no);
                case 4:
                    op.delete_acc(acc_no);
                default:
                    System.out.println("Enter Valid Choice");
                    break;
            }
            System.out.println("Do you want to Login from a different account\nY or y for yes\nN or n for No\nif you want to create a new account again enter 'A' or 'a'");
            active = sc.next().charAt(0);
            if(active == 'y' || active == 'Y'){
                System.out.println("Enter your account number");
//                while(choice != 0)
                acc_no = sc.nextInt();
                System.out.println("1. Check Balance\n2. Withdraw Money\n3. Deposit Money\n4. Delete Account\n0. To exit application");
                choice = sc.nextInt();
                sc.nextLine();
            }else if(active == 'n' || active == 'N'){
                System.out.println("1. Check Balance\n2. Withdraw Money\n3. Deposit Money\n4. Delete Account");
                choice = sc.nextInt();
                sc.nextLine();
            } else if (active == 'A' || active == 'a') {
                op.new_acc();
                System.out.println("1. Check Balance\n2. Withdraw Money\n3. Deposit Money\n4. Delete Account");
                choice = sc.nextInt();
                sc.nextLine();
            } else{
                System.out.println("Please try again and enter valid input");
                System.exit(0);
            }
        }

    }
}
