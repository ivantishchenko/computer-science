// time: O(nlog(log n)) 
// space: O(n)
class Main { 
   public void sieveOfEratosthenes(int n) { 
        boolean prime[] = new boolean[n+1]; 
        for(int i=0;i<n;i++) prime[i] = true; 
          
        for(int p = 2; p*p <=n; p++) { 
            if(prime[p] == true) { 
                for(int i = p*2; i <= n; i += p) {
                    prime[i] = false; 
                }
            } 
        } 
          
        // Print all prime numbers 
        for(int i = 2; i <= n; i++) 
        { 
            if(prime[i] == true) 
                System.out.print(i + " "); 
        } 
    } 
      
    // Driver Program to test above function 
    public static void main(String args[]) { 
        int n = 30; 
        Main g = new Main(); 
        g.sieveOfEratosthenes(n); 
    } 
} 