import java.io.*;
import java.util.*;

// To read and write ASCII characters with codes more than 127 in the same way as in other programming languages,
// you should use the following constructors:

// Scanner scanner = new Scanner(System.in, "ISO-8859-1");
// BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
// PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));

class FastReader { 
    BufferedReader br; 
    StringTokenizer st; 

    public FastReader() { 
        br = new BufferedReader(new InputStreamReader(System.in)); 
    } 

    String next() { 
        while (st == null || !st.hasMoreElements()) { 
            try { 
                st = new StringTokenizer(br.readLine()); 
            } 
            catch (IOException  e) { 
                e.printStackTrace(); 
            } 
        } 
        return st.nextToken(); 
    } 

    int nextInt() { 
        return Integer.parseInt(next()); 
    } 

    long nextLong() { 
        return Long.parseLong(next()); 
    } 

    double nextDouble() { 
        return Double.parseDouble(next()); 
    } 

    String nextLine() { 
        String str = ""; 
        try { 
            str = br.readLine(); 
        } 
        catch (IOException e) { 
            e.printStackTrace(); 
        } 
        return str; 
    } 
}

public class Main {
    private StreamTokenizer in;
    private PrintWriter out;

    private int nextInt() throws IOException {
        in.nextToken();
        return (int)in.nval;
    }

    private void run() throws IOException {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);
        solve();
        out.flush();
    }

    private void solve() throws IOException {
        // var fr = new FastReader();
        // int a = fr.nextInt();
        // int b = fr.nextInt();
        int a = nextInt();
        int b = nextInt();
        out.print(a + b);
        out.print(" ");
        out.println(a - b);
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}
