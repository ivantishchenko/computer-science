import random

class RandomizedSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.data_arr = []
        self.data_map = {}

    def insert(self, val: int) -> bool:
        """
        Inserts a value to the set. Returns true if the set did not already contain the specified element.
        """
        if val in self.data_map:
            return False

        self.data_arr.append(val)
        self.data_map[val] = len(self.data_arr) - 1

        return True


    def remove(self, val: int) -> bool:
        """
        Removes a value from the set. Returns true if the set contained the specified element.
        """
        if val not in self.data_map:
            return False

        self.data_map[self.data_arr[-1]] = self.data_map[val]
        self.data_arr[self.data_map[val]], self.data_arr[-1] = self.data_arr[-1], self.data_arr[self.data_map[val]]
        del self.data_map[val]
        self.data_arr.pop()
        return True

    def getRandom(self) -> int:
        """
        Get a random element from the set.
        """
        return random.choice(self.data_arr)

# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()