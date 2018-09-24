public class missionary_cannibals_problem {

    private static int initial_missionaries = 3, initial_cannibals = 3, final_missionaries = 0, final_cannibals = 0, status = 0, select = 0;
    private static boolean boat_side = false;

    static void display_step(char passenger1, char passenger2){

        System.out.println("\n");

        for (int i = 0; i < final_missionaries; i++){
            System.out.print(" M ");
        }

        for (int i = 0; i < final_cannibals; i++){
            System.out.print(" C ");
        }

        if (!boat_side){
            System.out.print("       ------WATER------<BO( " + passenger1 + "," + passenger2 + " )AT> ");
        } else {
            System.out.print("       <BO( " + passenger1 + "," + passenger2 + " )AT>-------WATER------ ");
        }

        for (int i = 0; i < initial_missionaries; i++){
            System.out.print(" M ");
        }

        for (int i = 0; i < initial_cannibals; i++){
            System.out.print(" C ");
        }

    }

    static boolean check_for_win(){
        return final_cannibals != 3 || final_missionaries != 3;
    }

    public static void problem_steps(){

        while (check_for_win()){

            if (!boat_side){

                switch (select){

                    case 1: display_step('C', ' ');
                            initial_cannibals++;
                            break;

                    case 2: display_step('C', 'M');
                            initial_cannibals++;
                            initial_missionaries++;
                            break;

                }

                if (((initial_missionaries - 2) >= initial_cannibals && (final_missionaries +2) >= final_cannibals) || (initial_missionaries - 2) == 0){

                    initial_missionaries -= 2;
                    select = 1;
                    display_step('M', 'M');
                    boat_side = true;

                }else if ((initial_cannibals - 2) < initial_missionaries && (final_missionaries == 0 || (final_cannibals + 2) <= final_missionaries) || initial_missionaries == 0){

                    initial_cannibals -= 2;
                    select = 2;
                    display_step('C', 'C');
                    boat_side = true;

                }else if ((initial_cannibals--) <= (initial_missionaries--) && (final_missionaries++) >= (final_cannibals++)){

                    initial_cannibals--;
                    initial_missionaries--;
                    select = 3;
                    display_step('M', 'C');
                    boat_side = true;

                }

            }else {

                switch (select){

                    case 1: display_step('M', 'M');
                            final_missionaries += 2;
                            break;

                    case 2: display_step('C', 'C');
                            final_cannibals += 2;
                            break;

                    case 3: display_step('M', 'C');
                            final_missionaries--;
                            final_cannibals--;
                            break;

                }

                if (check_for_win()){

                    if (((final_cannibals > 1 && final_missionaries == 0) || initial_missionaries == 0 )){

                        final_cannibals--;
                        select = 1;
                        display_step('C', ' ');
                        boat_side = false;

                    }else if ((initial_cannibals + 2) > initial_missionaries){

                        final_cannibals--;
                        final_missionaries--;
                        select = 2;
                        display_step('C', 'M');
                        boat_side = false;

                    }

                }

            }

        }

    }

    public static void main(String[] ivara){

        System.out.println("MISSIONARIES AND CANNIBALS PROBLEM");
        display_step(' ', ' ');
        problem_steps();
        display_step(' ', ' ');

    }

}
