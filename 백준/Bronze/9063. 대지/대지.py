listX = []
listY = []
n = int(input())
for i in range(n):
    a, b = map(int, input().split())
    listX.append(a)
    listY.append(b)

x = max(listX) - min(listX)
y = max(listY) - min(listY)

print(x*y)