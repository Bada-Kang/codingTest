E, S, M = map(int, input().split())
E1, S1, M1 = 0, 0, 0
sum = 0

if E == S and S == M:
    print(E)
else:
    try:
        while True:
            if E1 < 15 and S1 < 28 and M1 < 19:
                E1 += 1
                S1 += 1
                M1 += 1
                sum += 1
            # 두개씩 어긋나는 경우
            elif E1 >= 15 and S1 >= 28:
                E1 = 1
                S1 = 1
                M1 += 1
                sum += 1
            elif S1 >= 28 and M1 >= 19:
                E1 += 1
                S1 = 1
                M1 = 1
                sum += 1
            elif E1 >= 15 and M1 >= 19:
                E1 = 1
                S1 += 1
                M1 = 1
                sum += 1
            #하나씩 어긋나는 경우
            elif E1 >= 15:
                E1 = 1
                S1 += 1
                M1 += 1
                sum += 1
            elif S1 >= 28:
                E1 += 1
                S1 = 1
                M1 += 1
                sum += 1
            elif M1 >= 19:
                E1 += 1
                S1 += 1
                M1 = 1
                sum += 1
            #세개 다 어긋나는 경우
            else:
                E1 = 1
                S1 = 1
                M1 = 1
                sum += 1
            if E1 == E and S1 == S and M1 == M:
                break
        print(sum)
    except:
        print("Error")




