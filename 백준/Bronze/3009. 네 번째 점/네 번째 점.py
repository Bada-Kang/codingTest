list = []
for i in range(3):
    a, b = map(int, input().split())
    list.append(a)
    list.append(b)
if list[0] == list[2] and list[1] == list[3]:
    print(list[4], list[5])
elif list[0] == list[4] and list[1] == list[3]:
    print(list[2], list[5])
elif list[2] == list[4] and list[1] == list[3]:
    print(list[0], list[5])
if list[0] == list[2] and list[1] == list[5]:
    print(list[4], list[3])
elif list[0] == list[4] and list[1] == list[5]:
    print(list[2], list[3])
elif list[2] == list[4] and list[1] == list[5]:
    print(list[0], list[3])
if list[0] == list[2] and list[3] == list[5]:
    print(list[4], list[1])
elif list[0] == list[4] and list[3] == list[5]:
    print(list[2], list[1])
elif list[2] == list[4] and list[3] == list[5]:
    print(list[0], list[1])
