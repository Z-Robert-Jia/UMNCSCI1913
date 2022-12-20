
print("This should print first")
from altitools import *
# If you're getting prints between the "first" and "Second" lines here
# that's a sign you're not setting altitools.py up correctly! This _might_ cause issues in grading.
print("This should print second")

print(steepest_angle((1,2,1,3,1,4,2))) # 71.56505117707799
print(steepest_angle([10,1,5,10,15,6])) # 83.6598082540901
print(steepest_angle([0, -100, 0, 100, 200])) # 89.42706130231652
print(steepest_angle([0, 1])) # 45.0
print(steepest_angle([0])) # 0.0
print(steepest_angle((1.1, 1.1, 1.1, 1.1, 1.1, 1.1, 1.1, 1.1))) # 0.0



print(total_distance((0, 12, 14, 11, 16, 77, 73, 72, 71, 90))) # 109.52498624153611
print(total_distance([])) # 0
print(total_distance([7.5])) # 0
print(total_distance((-1,1,-2,2,-3,3))) # 20.703233307176834
print(total_distance([1,1,1,1,1,1,1,1,1,1,1,1,1,1])) # 13.0
print(total_distance((0,1))) # 1.4142135623730951

print(longest_sequential_climb(())) # 0
print(longest_sequential_climb([1.312])) # 0
print(longest_sequential_climb([1,2,1,0])) # 1.4142135623730951
print(longest_sequential_climb((1,2,3,1,2,3,4,5,6,3))) # 7.0710678118654755
print(longest_sequential_climb([5, 4, 1, 2, 2.2, 2.3, 2.35, 2.37, 2.39, 2.4, 2.3, 2, 1, 100, 99, 98, 77])) # 99.00505037623081
print(longest_sequential_climb((0, 12, 14, 11, 16, 77, 73, 72, 71, 90))) # 66.10721568427135




print(num_of_peaks_and_valleys([])) # (0, 0)
print(num_of_peaks_and_valleys([2,3])) # (0, 0)
print(num_of_peaks_and_valleys([1,2,3,4,5,6,7,8,9,10])) # (0, 0)
print(num_of_peaks_and_valleys([1,1,2,2,1,1,3,3,2,2,1,1])) # (0, 0)
print(num_of_peaks_and_valleys([1,10,10,10,100])) # (0, 0)
print(num_of_peaks_and_valleys((1,2,1,3,1,4,2,5,4,6,7,8,4,4,2,2,5,6,7,8))) # (5, 4)
print(num_of_peaks_and_valleys([0, 12, 14, 11, 16, 77, 73, 72, 71, 90])) # (2, 2)


print(fill_valleys([], 10)) # []
print(fill_valleys([5], 1)) # [5]
print(fill_valleys([5], 10)) # [10]
print(fill_valleys((0, 12, 14, 11, 16, 77, 73, 72, 71, 90), -10)) # [0, 12, 14, 11, 16, 77, 73, 72, 71, 90]
print(fill_valleys((0, 12, 14, 11, 16, 77, 73, 72, 71, 90), 30)) # [30, 30, 30, 30, 30, 77, 73, 72, 71, 90]
print(fill_valleys((0, 12, 14, 11, 16, 77, 73, 72, 71, 90), 300)) # [300, 300, 300, 300, 300, 300, 300, 300, 300, 300]

# #
'''
This should print first
This should print second
71.56505117707799
83.6598082540901
89.42706130231652
45.0
0.0
0.0
109.52498624153611
0
0
20.703233307176834
13.0
1.4142135623730951
0
0
1.4142135623730951
7.0710678118654755
99.00505037623081
66.10721568427135
(0, 0)
(0, 0)
(0, 0)
(0, 0)
(0, 0)
(5, 4)
(2, 2)
[]
[5]
[10]
[0, 12, 14, 11, 16, 77, 73, 72, 71, 90]
[30, 30, 30, 30, 30, 77, 73, 72, 71, 90]
[300, 300, 300, 300, 300, 300, 300, 300, 300, 300]
'''