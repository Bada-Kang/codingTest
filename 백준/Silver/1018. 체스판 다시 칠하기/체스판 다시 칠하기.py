n, m = map(int, input().split())
arr1 = [[0 for j in range(m)] for i in range(n)]
for i in range(n):
    str = input()
    arr1[i] = list(str)


minNum = int((n*m)/2)


x = 0
y = 0
for k in range((n-7)*(m-7)):
    tmp1 = 0
    tmp2 = 0
    for i in range(8):
        for j in range(8):
            if (x+i) % 2 == 0 and (y+j) % 2 == 0:
                if arr1[x+i][y+j] == 'B':
                    tmp1 += 1
                elif arr1[x+i][y+j] == 'W':
                    tmp2 += 1
            elif (x+i) % 2 == 0 and (y+j) % 2 == 1:
                if arr1[x+i][y+j] == 'W':
                    tmp1 += 1
                elif arr1[x+i][y+j] == 'B':
                    tmp2 += 1
            elif (x+i) % 2 == 1 and (y+j) % 2 == 0:
                if arr1[x+i][y+j] == 'W':
                    tmp1 += 1
                elif arr1[x+i][y+j] == 'B':
                    tmp2 += 1
            elif (x+i) % 2 == 1 and (y+j) % 2 == 1:
                if arr1[x+i][y+j] == 'B':
                    tmp1 += 1
                elif arr1[x+i][y+j] == 'W':
                    tmp2 += 1


    if tmp1 < minNum:
        minNum = tmp1
    if tmp2 < minNum:
        minNum = tmp2

    if y < (m-8) and (y+8) < m:
        y += 1

    elif x < (n-8) and (x+8) < n:
        x += 1
        y = 0

print(minNum)