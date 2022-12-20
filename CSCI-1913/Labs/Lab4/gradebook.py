"""
CSCI 1913 Lab4
Oct 4 2022
Author:
Zheng Robert jia
Daniyal Khan
"""
def is_sorted(lst):
    """
    determines if the input grade books is sorted
    :param lst: a list of tuples of student grades
    :return: a boolean indicating if it is sorted
    """
    for i in range(len(lst)-1):
        if lst[i][1] > lst[i+1][1]:
            return False
    return True

def grade_average(lst):
    """
    calculates the average grade of the input list
    :param lst:a list of tuples of students' grades
    :return: a floating value of the average grade
    """
    if len(lst) < 1:
        return 0.0
    # Sum of graddes
    sum = 0
    for ele in lst:
        sum += ele[0]
    return sum/len(lst)

def unsorted_get(lst, name):
    """
    dict.key()
    :param lst: an unsorted gradebook
    :param name: string student name
    :return: return name grade if student in the gradebook else return None
    """
    for ele in lst:
        if ele[1] == name:
            return ele[0]
    return None

def unsorted_put(lst, name, grade):
    """
    updates a student score in the gradebook
    :param lst: list. Gradebook
    :param name: name of the student
    :param grade: updated grade
    :return:
    """
    for i in range(len(lst)):
        if lst[i][1] == name:
            lst[i] = (grade, name)
            return
    lst.append((grade,name))
    return

def sorted_get(lst, name):
    """
    :param lst: sorted list: gradebook
    :param name: the name of the student
    :return: the score of the student. None if the student not in the gradebook
    """
    low = 0
    high = len(lst)-1
    while low <= high:
        mid = (low + high) // 2
        if lst[mid][1] < name:
            low = mid + 1
        elif lst[mid][1] > name:
            high = mid - 1
        else:
            return lst[mid][0]

    return None

def sorted_put(lst, name, grade):
    """
    update student grade in the input gradebook
    :param lst: a sorted list of tuples: sorted gradebook
    :param name: the student name
    :param grade: the student grade to be updated
    :return:
    """
    low = 0
    high = len(lst)-1
    mid = 0
    while (low <= high):
        mid = (low + high) // 2
        if lst[mid][1] < name:
            low = mid + 1
        elif lst[mid][1] > name:
            high = mid - 1
        else:
            lst[mid] = (grade, name)
            return
    # if low > mid, then insert at [low]
    # else, insert at [high]
    if low > mid:
        lst.insert(low,(grade,name))
    elif high<0:
        lst.insert(0,(grade,name))
    else:
        lst.insert(mid,(grade,name))
