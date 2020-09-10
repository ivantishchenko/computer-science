def hanoi(n, i, j):
	if n == 0:
		return
	tmp = 6 - i - j
	hanoi(n - 1, i, tmp)
	print("{} - > {}".format(i, j))
	hanoi(n - 1, tmp, j)

hanoi(3, 1, 2)
