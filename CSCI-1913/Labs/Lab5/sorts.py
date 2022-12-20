# CSCI 1913 Lab 5, list partners here!
# Zheng Robert Jia
# Daniyal Khan
# NAME HERE
# NAME HERE



# LAB5 has a substantial written Q&A component as well. You answer these questions by updating the
# multi-line strings below to indicate your answer. It's a bit hokey, but it works.

# Question 1: Which image file you submitted covers which analysis case?
Answer1 = '''
The files are all in one with specific labels. 
'''

# Question 2: For each algorithm, explain how you see it behaving in your images.
# If the algorithm's behavior differed case-by-case say this and explain how it behaved in each case.

Answer2_insertion = '''
insertion sort perform great for near_sorted and sorted(straight). For random, it's performance was okay(curve upwards), 
not as good as merge_sort, yet better than selection sort. For backwards, it's performance was bad(curve upwards)
'''

Answer2_selection = '''
selection sort performed bad for all cases: backwards, random, near_sorted, and sorted (curve upwards)

'''

Answer2_merge = '''
merge sort performed great for every case(backwards, random, near_sorted, and sorted): straight

'''


# Question 3: For each algorithm, What is the theoretical expectation. I.E. what is the expected big-O runtime behavior.
# If the algorithm's expected behavior differs case-by-case say this and explain how it is
# expected to behave case-by-case. (You should be able to find this information in the textbook.
# If not we will discuss this in class)

Answer3_insertion = '''
Insertion varies based on cases: 
For backwards and random, O(N**2), because a 'small' element might/will be at the very end, 
which requires a lot of comparisons time to switch it to the most beginning. 


For near_sorted and sorted. The algorithm only does one comparison for elements that are in order. 
It only needs to move the elements that are not in order. 
In this case, O(N)

'''

Answer3_selection = '''
Selection sort: 
No matter which case, selection sort always starts from the first element, compares it with elements to the 
right, and continue. 
So it always operates O(N**2)
'''

Answer3_merge = '''
merge sort runtime is always O(N*lognN)

'''


# Question 4: For each algorithm, How did the observed behavior match the theoretical behavior? Again, if your answer
# differs case by case, say that here and explain your findings for each case.

Answer4_insertion = '''
For nearly sorted and sorted data, insertion did performed O(N), which is faster than merge_sort. 
For random and backwards insertion sort performed O(N**2), which looked like a upward curve 
In short, my observation for random and backwards data fits the theoretical runtime. 
But it is faster then the theoretical runtime for sorted and nearly sorted data. 
'''

Answer4_selection = '''
selection sort should be O(N**2) under all cases, which looks like a upward curve under each case
In short, my observation of selection sort fits the theoretical runtime
'''

Answer4_merge = '''
Under all of the cases, mer_sort behaves like O(N*logN), compared to O(N**2), it looks like a straight line
In short, my observation of merge sort under all cases fits the theoretical runtime
'''


# Question 5: Merge sort is theoretically the fastest algorithm, are there
# cases where another algorithm might be faster?

Answer5 = '''
For a nearly sorted list and sorted list, insertion is faster than merge sort. 
'''


# Question 6: If you didn't know the order of data you might want to sort,
# what algorithm might you use to sort it, and why?

Answer6 = '''
We would like to use merge sort. Because it is stable and performs well under all circumstances.
Unlike the other algorithms which might be great under one case and terribly bad under another.  
Plus, we have not considered the 'swaping' of elements in our assignment, which would make the 
runtime of other algorithms vary even more possibly even slower, while mer_sort remaining to be stable and fast. 
'''






# Selection, Insertion, and Merge sorts -- taken from ZyBooks.
# Not too different, its still the same algorithm, they just did it using less memory than I did
# (Which leads to a slightly harder to understand piece of code)

def selection_sort(numbers):
    """Sort the list numbers in-place. (Note, this doesn't have to be numbers)"""
    count = 0
    for i in range(len(numbers) - 1):
        # Find index of smallest remaining element
        index_smallest = i
        for j in range(i + 1, len(numbers)):
            if numbers[j] < numbers[index_smallest]:
                index_smallest = j
            count += 1
        # Swap numbers[i] and numbers[index_smallest]
        temp = numbers[i]
        numbers[i] = numbers[index_smallest]
        numbers[index_smallest] = temp
    return count

def insertion_sort(numbers):
    """Sort the list numbers in-place. (Note, this doesn't have to be numbers)"""
    count = 0
    for i in range(1, len(numbers)):
        j = i
        # Insert numbers[i] into sorted part
        # stopping once numbers[i] in correct position
        # KLUVER NOTE - PLEASE READ - so this line is a bit tricky. Technically, if j > 0 then numbers would not be compared
        #               to make things easier you can assume that every time the list condition is checked one array element
        #               comparison occurs. That is -- you can ignore the short-circuit evaluatio of the logical and in this
        #               counting problem.
        while j > 0 and numbers[j] < numbers[j - 1]:
            count += 1
            # Swap numbers[j] and numbers[j - 1]
            temp = numbers[j]
            numbers[j] = numbers[j - 1]
            numbers[j - 1] = temp
            j = j - 1
        count += 1 #The comparison made to exit the for loop
    return count

def merge(numbers, i, j, k):
    """ Given two sorted sub-lists create one sorted list. This is done in-place, meaning we are given one list
    and expected to modify the list to be sorted. Furthermore, this operates on "sub-lists" (a specific range of the list)
    The list named numbers may contain other types of data than just numbers
    the variables i, j, and k are all indices into the numbers list
    So so the part of the list to be sorted is from position i to k (inclusive) with i to j being one sorted list, and j+1 to k being another."""
    merged_size = k - i + 1   #  Size of merged partition
    merged_numbers = []        #  Temporary list for merged numbers
    count = 0
    for l in range(merged_size):
        merged_numbers.append(0)

    merge_pos = 0      #  Position to insert merged number

    left_pos = i       #  Initialize left partition position
    right_pos = j + 1  #  Initialize right partition position

    #  Add smallest element from left or right partition to merged numbers
    while left_pos <= j and right_pos <= k:
        if numbers[left_pos] < numbers[right_pos]:
            merged_numbers[merge_pos] = numbers[left_pos]
            left_pos = left_pos + 1
        else:
            merged_numbers[merge_pos] = numbers[right_pos]
            right_pos = right_pos + 1
        count += 1
        merge_pos = merge_pos + 1
    #  If left partition is not empty, add remaining elements to merged numbers
    while left_pos <= j:
        merged_numbers[merge_pos] = numbers[left_pos]
        left_pos = left_pos + 1
        merge_pos = merge_pos + 1

    #  If right partition is not empty, add remaining elements to merged numbers
    while right_pos <= k:
        merged_numbers[merge_pos] = numbers[right_pos]
        right_pos = right_pos + 1
        merge_pos = merge_pos + 1

    #  Copy merge number back to numbers
    merge_pos = 0
    while merge_pos < merged_size:
        numbers[i + merge_pos] = merged_numbers[merge_pos]
        merge_pos = merge_pos + 1
    return count

def merge_sort_recursive(numbers, i, k):
    """ Sort the sub-list in numbers from position i to k (inclusive)"""
    count = 0
    if i < k:
        j = (i + k) // 2  #  Find the midpoint in the partition

        #  Recursively sort left and right partitions
        # KLUVER NOTE - PLEASE READ - you should think about these two function calls as returning a count of
        #     comparisons. Naturally the comparisons done by those function-calls will count against this function-call.
        #     make sure you're not ignoring the return values on the following two lines.
        count += merge_sort_recursive(numbers, i, j)
        count += merge_sort_recursive(numbers, j + 1, k)

        #  Merge left and right partition in sorted order
        count += merge(numbers, i, j, k)

    return count
def merge_sort(numbers):
    """ Sort a list of numbers

    This function is added on-top of the textbook's code to simply start the recursive process with the
    appropriate parameters. This also gives us a consistent sorting interface over the three sorts."""
    return merge_sort_recursive(numbers, 0, len(numbers)-1)
