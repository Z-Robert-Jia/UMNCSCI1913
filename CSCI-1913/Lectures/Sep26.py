# def count_unique(lst):
#     lst.sort()
#     count = 0
#     [count += 1 for i in range(1, len(lst)-1) if lst[i]!=lst[i+1]]

def count_unique(lst):
    return len(set(lst))

# [print(1) for i in range(10) if i == 1]

print(count_unique([1,2,3,2,2,2,2,1,3,4,5,6]))


# keys can only be immutable types
# keys cannot be duplicated

dic = {'key': 'value', 'key1': 'value2', 'key3': 'value3'}
print(len(dic),dic["key1"])
print(dic.pop('key1'))
print(dic.get('key1','Not in there!'))
print(dic.pop('key','Not in there!'))
# keys(), items(), values()