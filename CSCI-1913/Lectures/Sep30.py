import numpy as np
_nums = [['.' for _ in range(9)] for _ in range(9)]
print(np.shape(_nums))
str = zip(_nums[0][::3], _nums[0][1::3])
str = "  ".join([(a,b) for a,b in zip(_nums[0][::3], _nums[0][1::3])])
print(str)
# for r in range(9):
#     print('   '
#           .join(["{} {} {}".format(a, b, c) for a, b, c in
#                  zip(_nums[r][::3], _nums[r][1::3], _nums[r][2::3])]))
