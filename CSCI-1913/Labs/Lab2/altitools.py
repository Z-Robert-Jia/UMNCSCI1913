'''
Authors: TODO: Zheng Robert Jia
         TODO: Daniyal Khan

'''
import math

def steepest_angle(lst):
    """accepts a list
    returns the steepest angle between two mountain ranges"""
    biggest_change = 0
    #Find the biggest change in height
    for i in range(1,len(lst)):
        print(biggest_change)
        dif = abs(lst[i]-lst[i-1])
        if dif > biggest_change:
            biggest_change = dif
    #Computer the angle in radians
    print(biggest_change)
    return math.degrees(math.atan(biggest_change))

def calc_distance(a,b):
    '''helper function
    accepts two altitude of horizontal distance 1
    return the distance between to points'''
    return math.sqrt((a-b)**2+1)

def total_distance(lst):
    '''accepts a list of the traveler's altitude
    returns the total distance the traveler needs to climb as a number'''
    # Check length
    if len(lst) <= 1:
        return 0
    distance = 0
    for i in range(len(lst)-1):
        distance += calc_distance(lst[i],lst[i+1])
    return distance

def longest_sequential_climb(lst):
    ''''accepts a list of traveler's altitude
    returns the longest sequential climb refer to the document for details'''
    # Make sure that the lst contains more than 1 element
    if len(lst) <= 1:
        return 0
    # store all the sequential climb in a list
    seq_climb = 0
    climb_rec = []
    # loop over the list
    # add up the numbers, and if lst[i]>lst[i-1] add the seq_climb and continue
    #                         else append the value to the sequential climb and make seq_climb 0
    for i in range(1,len(lst)):
        # determine if it is climb
        is_climb = (lst[i]-lst[i-1])>0
        climb = calc_distance(lst[i-1],lst[i])
        if is_climb:
            seq_climb += climb
        elif is_climb and i==len(lst)-1:
            seq_climb += climb
            climb_rec.append(seq_climb)
        else:
            climb_rec.append(seq_climb)
            seq_climb = 0
    return max(climb_rec)
    # return the maximum in the list

def num_of_peaks_and_valleys(lst):
    '''accepts a list
    returns a tuble (peak,valleys) representing
    the number of peaks and number of valleys'''
    # make sure the list has more than 2 elements
    if len(lst) <= 2:
        return (0, 0)
    valleys = 0
    peaks = 0
    # loop over the lists for peaks
    for i in range(1,len(lst)-1):
        if lst[i-1]<lst[i]>lst[i+1]:
            peaks += 1

    # loop over the lists for valleys
    for i in range(1, len(lst) - 1):
        if lst[i - 1] > lst[i] < lst[i + 1]:
            valleys += 1

    return peaks,valleys
def fill_valleys(inp,min_height):
    """accepts a list or tuple
    fills the valleys according to min_height
     return the new altitude"""
    # guarantee the input is changed into a list
    lst = list(inp)
    # enhanced for loop that changes every height below min_height into min_height
    for i in range(len(lst)):
        if lst[i] < min_height:
            lst[i] = min_height
    return lst

# print(math.degrees(math.atan(100)))

