class Stack{
    final int MAX = 10;
    int top = -1;
    int s []= new int[MAX];

    void push (int num){
        if (top == MAX-1){
            System.out.println("Stack is Full!");
            return;
        }
        s[++top] = num;
    }
    int pop (){
        return s[top --];
    }
    boolean isEmpty (){
        return top == -1;
    }
}
public class TopologicalOrdering {
    int vertices;
    int adjacencyMatrix[][];

    public TopologicalOrdering(int vertices, int adjacencyMatrix[][]) {
        this.vertices = vertices;
        this.adjacencyMatrix = adjacencyMatrix;
    }

    public void topologicalSort() {
        Stack s = new Stack();
        boolean visited[] = new boolean[vertices];

        for (int i = 0; i < vertices; i++)
            if (!visited[i])
                dfs(i, visited, s);

        System.out.println("Topological Ordering:");
        while (!s.isEmpty())
            System.out.print((s.pop()+1)+" ");
    }


    public void dfs(int vertex, boolean visited[], Stack s) {
        visited[vertex] = true;
        for (int i = 0; i < vertices; i++)
            if (adjacencyMatrix[vertex][i] == 1 && !visited[i])
                dfs(i, visited, s);
        s.push(vertex);
    }

    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
                {0, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 0},
                {0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}
        };
        TopologicalOrdering to = new TopologicalOrdering(6, adjacencyMatrix);
        to.topologicalSort();
    }
}
