n = int(input())


#5로만 나눠지는 경우
if n % 5 == 0:
    print(n//5)
#5와 3 두개로 나눠지는 경우
elif n>3 and (n-3) % 5 == 0:
    print((n-3) // 5 + 1)
elif n>6 and (n-6) % 5 == 0:
    print((n-6) // 5 + 2)
elif n>9 and(n-9) % 5 == 0:
    print((n-9) // 5 + 3)
elif n>12 and(n-12) % 5 == 0:
    print((n-12) // 5 + 4)
#3으로만 나눠지는 경우
elif n % 3 == 0:
    print(n//3)
else:
    print(-1)