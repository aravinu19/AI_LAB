import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class unification_problem {

    private static int no_of_predicates;
    private static int no_of_arguments[] = new int[10];
    private static int index1, index2;
    private static char predicate[] = new char[10];
    private static char arguments[][] = new char[10][10];

    public static void main(String[] cli_args) throws IOException {

        String choice;

        do {

            System.out.println("\tUnification Problem");
            System.out.println("Enter the no of predicates : ");

            BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
            no_of_predicates = Integer.parseInt(scan.readLine());

            for (index1 = 0; index1 < no_of_predicates; index1++){

                System.out.println("Enter the predicate " + (index1 + 1) + " : ");
                predicate[index1] = scan.readLine().charAt(0);

                System.out.println("Enter the no of Arguments for predicate " + predicate[index1] + " : ");
                no_of_arguments[index1] = Integer.parseInt(scan.readLine());

                for (index2 = 0; index2 < no_of_arguments[index1]; index2++){

                    System.out.println("Enter the argument " + (index2 + 1) + " : ");
                    arguments[index1][index2] = scan.readLine().charAt(0);

                }

            }

            display();
            check_argument_predicate();

            System.out.println("Do you want to continue ? [yes] / [no] : ");
            choice = scan.readLine();

        }while (choice.contains("yes"));

    }

    private static void display(){

        System.out.println("\n\t=======PREDICATES ARE======");

        for (index1 = 0; index1 < no_of_predicates; index1++){

            System.out.print("\n\t" + predicate[index1] + "(");

            for (index2 = 0; index2 < no_of_arguments[index1]; index2++){

                System.out.print("" + arguments[index1][index2]);

                if (index2 != (no_of_arguments[index1] - 1)) System.out.print(",");

            }

            System.out.print(")");

        }

    }

    private static void check_argument_predicate() {

        boolean predicate_flag = false;
        boolean argument_flag = false;

        for (index1 = 0; index1 < (no_of_predicates - 1); index1++){

            if (predicate[index1] != predicate[index1 + 1]){

                System.out.println("Predicates not same . . .");
                System.out.println("Unification cannot progress!");
                predicate_flag = true;
                break;

            }

        }

        if (!predicate_flag){

            for (index1 = 0; index1 < (no_of_arguments[index1] - 1); index1++){

                if (no_of_arguments[index1] != no_of_arguments[index1 + 1]){

                    System.out.println("Arguments not same . . .");
                    argument_flag = true;
                    break;

                }

            }

        }

        if (!argument_flag && !predicate_flag) unify();

    }

    private static void unify(){

        int flag = 0;

        for (index1 = 0; index1 < no_of_predicates-1; index1++){

            for (index2 = 0; index2 < no_of_arguments[index1]; index2++){

                if (arguments[index1][index2] != arguments[index1 + 1][index2]){

                    if (flag == 0) System.out.println("\n\t======SUBSTITUTION IS======");

                    System.out.print("\n" + arguments[index1 + 1][index2] + " / " + arguments[index1][index2]);
                    flag++;

                }

            }

        }

        if (flag == 0){

            System.out.println("Arguments are Identical . . .");
            System.out.println("No need of Substition .");

        }

    }

}
