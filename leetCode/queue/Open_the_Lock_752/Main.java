import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class StateNode {
    StateNode prev;
    String value;

    public StateNode(StateNode s, String v) {
        prev = s;
        value = v;
    }
}

class Solution {
    private int[][] moves = {{0,0,0,1}, {0,0,1,0}, {0,1,0,0}, {1,0,0,0},
                             {0,0,0,-1}, {0,0,-1,0}, {0,-1,0,0}, {-1,0,0,0}};

    private int[] parseValue(String currVal) {
        int stateVal = Integer.parseInt(currVal);
        int[] digits = new int[4];
        int i = 3;
        while(stateVal > 0) {
            digits[i] = stateVal % 10;
            stateVal /= 10;
            i--;
        }
        return digits;
    }

    public int openLockRetainPath(String[] deadends, String target) {
        if(target.equals("0000")) return 0;
        Set<String> deadEndSet = new HashSet<>();
        Set<String> traversedStates = new HashSet<>();
        Collections.addAll(deadEndSet, deadends);
        if(deadEndSet.contains("0000")) return -1;
        Queue<StateNode> stateQueue = new LinkedList<>();
        stateQueue.offer(new StateNode(null, "0000"));
        String currVal = "0000";
        StateNode stateNode = null;
        while(!stateQueue.isEmpty()) {
            if(target.equals(currVal)) {
                int numEdges = -1;        
                while(stateNode != null) {
                    numEdges++;
                    stateNode = stateNode.prev;
                }
                return numEdges;
            }
            stateNode = stateQueue.poll();
            currVal = stateNode.value;
            traversedStates.add(currVal);
            int[] digits = parseValue(currVal);
            List<StateNode> nextStates = new ArrayList<>();
            for (int[] m: moves) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < moves[0].length; i++) {
                    sb.append(Math.floorMod(m[i] + digits[i], 10));
                }
                String nextVal = sb.toString(); 
                if(!deadEndSet.contains(nextVal) && !traversedStates.contains(nextVal)) {
                    stateQueue.offer(new StateNode(stateNode, nextVal));
                    traversedStates.add(nextVal);
                }
            }
        }
        return -1;
    }

    public int openLock(String[] deadends, String target) {
        if(target.equals("0000")) return 0;
        Set<String> deadEndSet = new HashSet<>();
        Collections.addAll(deadEndSet, deadends);
        if(deadEndSet.contains("0000")) return -1;
        Set<String> traversedStates = new HashSet<>();
        Queue<String> stateQueue = new LinkedList<>();
        stateQueue.offer("0000");
        
        int numEdges = 0;
        while(!stateQueue.isEmpty()) {
            int qSize = stateQueue.size();
            for (int i = 0; i < qSize; i++) {
                String currState = stateQueue.poll();
                if(deadEndSet.contains(currState) || traversedStates.contains(currState)) continue;
                if(target.equals(currState)) return numEdges;
                traversedStates.add(currState);

                // This is crucial
                for(int j = 0; j < 4; j++) {
                    int incDigit = Math.floorMod(currState.charAt(j) - '0' + 1, 10);
                    int decDigit = Math.floorMod(currState.charAt(j) - '0' - 1, 10);
                    stateQueue.offer(currState.substring(0, j) + incDigit + currState.substring(j + 1));
                    stateQueue.offer(currState.substring(0, j) + decDigit + currState.substring(j + 1));
                }

            }
            numEdges++;
        }
        return -1;
    }

}