# def count_common(lst):
#
#     for

x = [1]
y = [x,x,x,x]
x = 'gotya'
print(y) #[[1], [1], [1], [1]]
y = [[1]]*4
y[0][0] = 'gotcha'
print(y) # [['gotcha'], ['gotcha'], ['gotcha'], ['gotcha']]

inp = input('Enter a number from 1 to 10: ')
lst = [0]*10
user_inp = []
while inp != 'quit':
    # Convert to the corresponding index
    if not inp.isnumeric():
        print("Please enter a number")
        inp = input('Enter a number from 1 to 10: ')
        continue
    int_inp = int(inp) - 1
    lst[int_inp] += 1
    # appned to the list
    inp = input('Enter a number from 1 to 10: ')
    #Ask for input
max_num = max(lst)
print(lst.index(max_num)+1)
# print(max(lst)+1)
# print(max([1,2,0]))
0 == 0.0 # True
0 is 0.0 # False (Checks identity)

x = [1,0,4]
y = [1,0,4]
print(x == y) # True
print(x is y) # False

x = [1,0,4]
y = x
print(x==y)
print(x is y)
x[0] = 4
print(x) # [4, 0, 4]
print(y) # [4, 0, 4]

elem = 1
index = 1
lst.insert(index,elem)
lst2 = lst.copy()
lst.extend(lst2)
