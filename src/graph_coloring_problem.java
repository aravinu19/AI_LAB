import java.util.Scanner;

public class graph_coloring_problem {

    private static int no_of_vertices, no_of_colors;
    private static int[] color;
    private static int[][] graph;

    public static void graph_color(int[][] current_graph, int current_no_of_colors){

        no_of_vertices = current_graph.length;
        no_of_colors = current_no_of_colors;
        color = new int[no_of_vertices];
        graph = current_graph;

        try{
            solve(0);
            System.out.println("No Solution");
        }catch (Exception e){
            System.out.println("\nSolution Exists");
            display();
        }

    }

    public static void solve(int vertices) throws Exception {

        if (no_of_vertices == vertices){
            throw new Exception("Solution found");
        }

        for (int current_color = 1; current_color <= no_of_colors; current_color++){

            if (isPossible(vertices, current_color)){

                color[vertices] = current_color;
                solve(vertices + 1);
                color[vertices] = 0;

            }

        }

    }

    public static boolean isPossible(int vertices, int current_color){

        for (int index = 0; index < no_of_vertices; index++){

            if (graph[vertices][index] == 1 && current_color == color[index]) return false;

        }

        return true;

    }

    public static void display()
    {
        System.out.println("Colors : ");
        for (int index = 0; index < no_of_vertices; index++){
            System.out.print(color[index] + " ");
        }
        System.out.println();
    }

    public static void main(String[] ivara){

        Scanner scan = new Scanner(System.in);
        System.out.println("Graph Coloring Problem");

        System.out.println("Enter the no of vertices : ");
        no_of_vertices = scan.nextInt();

        System.out.println("Enter the matrix : ");
        graph = new int[no_of_vertices][no_of_vertices];

        for (int index = 0; index < no_of_vertices; index++){
            for (int index2 = 0; index2 < no_of_vertices; index2++){
                graph[index][index2] = scan.nextInt();
            }
        }

        System.out.println("\nEnter the no of colors : ");
        no_of_colors = scan.nextInt();

        graph_color(graph, no_of_colors);

    }

}
