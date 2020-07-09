import java.util.Set;

class Solution {
    private Set<Integer> visited;

    private void dfs(List<List<Integer>> rooms, int startRoom) {
        if(!visited.contains(startRoom)) {
            visited.add(startRoom);
            for (int key : rooms.get(startRoom)) {
                dfs(rooms, key);
            }
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new HashSet<>();
        dfs(rooms, 0);
        return visited.size() == rooms.size();
    }
}