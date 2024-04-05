n = int(input())
list = list(map(int, input().split()))

jun_1 = n
sung_1 = n

jun_2 = 0
sung_2 = 0

for i in range(len(list)):
    if jun_1 >= list[i]:
        jun_2 += jun_1//list[i]
        jun_1 -= list[i]*(jun_1//list[i])

for i in range(3, len(list), 1):
    if (list[i] < list[i-1]) and (list[i-1] < list[i-2]) and (list[i-2] < list[i-3]):
        if sung_1 >= list[i]:
            sung_2 += sung_1//list[i]
            sung_1 -= list[i]*(sung_1//list[i])

    if (list[i] > list[i - 1]) and (list[i - 1] > list[i - 2]) and (list[i - 2] > list[i - 3]) and sung_2 > 0:
        sung_1 += list[i] * sung_2
        sung_2 = 0

if jun_1+jun_2*list[13] > sung_1+sung_2*list[13]:
    print("BNP")
elif jun_1+jun_2*list[13] < sung_1+sung_2*list[13]:
    print("TIMING")
else:
    print("SAMESAME")
