def cal(temp, t):
    m = 0
    for i in range(n):
        for j in range(n):
            if temp[i][j] != t[i][j]:
                m += 1
    return m

def check(a, t):
    f = 1
    for i in range(n):
        for j in range(n):
            if a[i][j] != t[i][j]:
                f = 0
    return f

def solve_puzzle(a, t):
    global n
    m = 0
    x = 0
    y = 0
    d = 1000
    dmin = 0
    l = 0
    r = [[0]*10 for _ in range(10)]
    temp = [[0]*10 for _ in range(10)]

    print("\nEntered Matrix is :")
    n = 4
    for i in range(n):
        for j in range(n):
            print(a[i][j], end="\t")
        print()

    print("\nTarget Matrix is :")
    for i in range(n):
        for j in range(n):
            print(t[i][j], end="\t")
        print()

    while not check(a, t):
        l += 1
        d = 1000
        for i in range(n):
            for j in range(n):
                if a[i][j] == 0:
                    x = i
                    y = j

        for i in range(n):
            for j in range(n):
                temp[i][j] = a[i][j]

        if x != 0:
            p = temp[x][y]
            temp[x][y] = temp[x-1][y]
            temp[x-1][y] = p
        m = cal(temp, t)
        dmin = l + m
        if dmin < d:
            d = dmin
            for i in range(n):
                for j in range(n):
                    r[i][j] = temp[i][j]

        for i in range(n):
            for j in range(n):
                temp[i][j] = a[i][j]

        if x != n-1:
            p = temp[x][y]
            temp[x][y] = temp[x+1][y]
            temp[x+1][y] = p
        m = cal(temp, t)
        dmin = l + m
        if dmin < d:
            d = dmin
            for i in range(n):
                for j in range(n):
                    r[i][j] = temp[i][j]

        for i in range(n):
            for j in range(n):
                temp[i][j] = a[i][j]

        if y != n-1:
            p = temp[x][y]
            temp[x][y] = temp[x][y+1]
            temp[x][y+1] = p
        m = cal(temp, t)
        dmin = l + m
        if dmin < d:
            d = dmin
            for i in range(n):
                for j in range(n):
                    r[i][j] = temp[i][j]

        for i in range(n):
            for j in range(n):
                temp[i][j] = a[i][j]

        if y != 0:
            p = temp[x][y]
            temp[x][y] = temp[x][y-1]
            temp[x][y-1] = p
        m = cal(temp, t)
        dmin = l + m
        if dmin < d:
            d = dmin
            for i in range(n):
                for j in range(n):
                    r[i][j] = temp[i][j]

        print("\nCalculated Intermediate Matrix Value :")
        for i in range(n):
            for j in range(n):
                print(r[i][j], end="\t")
            print()

        for i in range(n):
            for j in range(n):
                a[i][j] = r[i][j]
                temp[i][j] = 0

        print("Minimum cost :", d)

# Example puzzle to solve
a = [
    [1, 2, 3, 4],
    [5, 6, 7, 8],
    [9, 10, 11, 0],
    [13, 14, 15, 12]
]

# Example target puzzle
target = [
    [1, 2, 3, 4],
    [5, 6, 7, 8],
    [9, 10, 11, 12],
    [13, 14, 15, 0]
]

solve_puzzle(a, target)
