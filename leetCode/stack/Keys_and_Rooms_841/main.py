class Solution:
    def __init__(self):
        self.visited = set()

    def dfs(self, room_idx, room_list):
        if room_idx not in self.visited:
            self.visited.add(room_idx)
            for next_room in room_list[room_idx]:
                self.dfs(next_room, room_list)

    def canVisitAllRooms(self, rooms):
        self.dfs(0, rooms)
        return len(self.visited) == len(rooms)

