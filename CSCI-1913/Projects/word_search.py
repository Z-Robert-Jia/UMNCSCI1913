# CSCI 1913 Fall 2022
# Author: Zheng Robert Jia
import string

# QUESTIONS -- DO THESE LAST.
# Assumptions: assume the letter grid has width W and height H
# Further assume the word parameter has length L (for find) and than the max_len parameter is L (for extract)
# Finally, Assume that concatenating a letter to a string takes time O(1)
# List any other assumptions you make.

# For each question below, answer your questions by filling in the provided multi-line strings.
# (yes it's a bit of a hokey way to do this, but it should work well enough and it keeps the answers in 1 file)
# For each question state any extra assumptions you made, and explain your answer.
# An incorrect answer with no explanation will get no partial credit.

# Question 1: What is the worst-case big-O runtime of your get_size function?
Question1 = '''
answer
Assuming that the given grid is in rectangular shape, i.e. same length every row
For python, the answer would be O(1). Since len(lst) just ask for the __len__ method of the list object
O(1) for asking len(lst), and O(1) for asking len(lst[0])
O(1) + O(1) = O(1)
'''

# Question 2: What is the worst-case big-O runtime of your copy_word_grid function?
Question2 = '''
answer ***
Given a standard grid with size m*n
The worst-case in big-O is o(m*n)
'''

# Question 3: What is the worst-case big-O runtime of your extract function?
Question3 = '''
answer ***
The worst-case big-O for a m*n grid is to go through the longer side. 
Which is O(max(m,n))
'''

# Question 4: What is the worst-case big-O runtime of your find function?
Question4 = '''
answer *** 
In the worst case, I searched through all possible combinations but still fail to find the solution. 
Each element I search for 4 directions. But this constant could be ignored. 
In the worst case, the for loop that iterates through all possible positions in the grid is O(M*N)
Aad the extract function is O(max(m,n))
Thus, in total, the big-O notation is O(m*n*max(m,n))
'''

### LEAVE THESE LINES ALONE BEGIN:
# So the code I provide at the bottom needs these lines of code.
import random
# *** import

# This code defines valid directions a word can travel.
# Each direction is a tuple (dx, dy) that says how you change x and y 
# coordinates to go in a given direction.
RIGHT=(1, 0)       # to go right add 1 to x
DOWN=(0,1)         # to go down add 1 to y
RIGHT_DOWN=(1, 1)  # to go right_down add 1 to both x and y
RIGHT_UP=(1,-1)    # to go right_up add 1 to x and subtract 1 from y
DIRECTIONS = (RIGHT, DOWN, RIGHT_DOWN, RIGHT_UP)
# Good use of these direction-tuples makes for much easier programs for this project. assignment.

### LEAVE THESE LINES ALONE END:


def get_size(word_grid):
    """
    :param word_grid: list: a letter grid
    :return: a tuple (width,height) representing the width and height of the given grid
    """
    return len(word_grid[0]),len(word_grid)
def print_word_grid(word_grid):
    """
    prints the letters in the grid in a dense format
    :param word_grid: list: letter grid
    :return: nothing
    """
    for row in word_grid:
        print(''.join(row))
    return

def copy_word_grid(word_grid):
    """
    :param word_grid: list: letter grid
    :return: deep copy of word_grid
    """
    copy_grid = []
    for i in range(len(word_grid)):
        copy_grid.append([])
        for j in range(len(word_grid[0])):
            copy_grid[i].append(word_grid[i][j])
    return copy_grid


def add_tuples(tpl1, tpl2):
    """
    elementwise adds the two tuples
    :param tpl1: tuple
    :param tpl2: tuple
    :return: added tuple
    """
    # return tuple(map(operator.add, tpl1, tpl2))
    x1,y1 = tpl1
    x2,y2 = tpl2
    return (x1+x2,y1+y2)



def extract(word_grid, position, direction, max_len):
    """
    extracts the targeted string
    :param word_grid: list: word grid
    :param position: tuple (col,row): starting position
    :param direction: tuple of tuple. The direction we're moving
    :param max_len: int: the number of steps we want to extract.
    :return: string: the string going in the "direction" max_len steps. If hit edges, return a shorter string
    """
    target_str = ""
    curr_len = 1
    # !!!! Careful don't confuse the rows and cols ******
    # while not hitting edge (position + direction)  and max_len not reached:
        #  target_str += word_grid(position)
        # incraese curr position
        # Increase curr_len
    curr_pos = position
    x, y = curr_pos
    while 0 <= x < len(word_grid[0]) and 0 <= y < len(word_grid) and curr_len <= max_len:
        target_str += word_grid[y][x]
        curr_pos = add_tuples(curr_pos,direction)
        x,y = curr_pos
        curr_len += 1
    return target_str

def find(word_grid, word):
    """
    Find the solution of the word in that grid
    :param word_grid: list: grid of letters
    :param word: the target word we want to find
    :return: None if couldn't be found. (start_pos,direction) if found
    """
    max_len = len(word)
    for y in range(len(word_grid)):
        for x in range(len(word_grid[0])):
            for direction in DIRECTIONS:
                if extract(word_grid,(x,y),direction,max_len) == word:
                    return ((x,y),direction)
    return None

def show_solution(word_grid, word):
    """
    show the solution to a particular word
    :param word_grid: list: word grid
    :param word: string: targeted word
    :return: a copy of the word_grid with the targeted word Capitalized. return could not be found if not in the list
    """
    # Try .upper
    # find(word_grid,word)
    # If not found
    # return print
    # else could be found,
    # Make a copy,
    # follow the initial position and direction, capitalize the words
    solution = find(word_grid,word)
    if solution is None:
        print(f'{word} is not found in this word search')
        return
    else:
        print(f'{word.upper()} can be found as below')
        solution_grid = copy_word_grid(word_grid)
        x_init, y_init = solution[0]
        x_dir, y_dir = solution[1]
        for i in range(len(word)):
            solution_grid[y_init+i*y_dir][x_init+i*x_dir] = solution_grid[y_init+i*y_dir][x_init+i*x_dir].upper()
        print_word_grid(solution_grid)

def make_empty_grid(width, height):
    """
    creates an empty grid full of "?"
    :param width: int: num of cols
    :param height: int: num of rows
    :return: word_grid
    """
    word_grid = [["?" for j in range(width)] for i in range(height)]
    return word_grid

def can_add_word(word_grid, word, position, direction):
    """
    :param word_grid: list: word grid
    :param word: string: targeted string
    :param position: tuple: starting position
    :param direction: tuple: the direction we're searching
    :return:
    """
    find_str = extract(word_grid,position,direction,len(word))
    if len(find_str) != len(word):
        return False
    find_str_lst = list(find_str)
    for i in range(len(find_str)):
        if find_str_lst[i] == "?":
            find_str_lst[i] = word[i]
    return find_str_lst == list(word)
    # The solution below is fun to try.
    # alternative is to extract the string, and then find the indexes with "?", fill them in, then compare.
    # But much less inefficient.
    # I guess mine is N^2 growth, but the proposed one would be N, len(word) = N
    # 1-N possible consecutive "?"
    # word_lst = list(word)
    # ext_lst = []
    # for cons in range(1, len(word_lst) + 1):
    #     # starting index
    #     print(ext_lst)
    #     for i in range(len(word_lst) + 1 - cons):
    #         copy_word_lst = word_lst.copy()
    #         for j in range(cons):
    #             copy_word_lst[i + j] = "?"
    #         ext_lst.append(copy_word_lst)
    # if extract(word_grid,position,direction,len(word)) in ext_lst:
    #     return True
    # else:
    #     return False

def do_add_word(word_grid, word, position, direction):
    """
    Adds a word at the given position at the direction
    :param word_grid: list grid
    :param word: string: word added
    :param position: added position
    :param direction: added direction
    :return: the modified grid
    """
    x,y = position
    dx,dy = direction
    for i in range(len(word)):
        word_grid[y+i*dy][x+i*dx] = word[i]
    return word_grid

def fill_blanks(word_grid):
    """
    fills blanks of word grid with fandom alphabets
    :param word_grid: list: word grid
    :return: the modified grid
    """
    for i in range(len(word_grid)):
        for j in range(len(word_grid[0])):
            if word_grid[i][j] == "?":
                word_grid[i][j] = string.ascii_lowercase[random.randint(0, 25)]

####
#
#  PROVIDED CODE -- You shouldn't need to change any of this.
#  (it's not that we didn't think you could write this, it's this stuff is either
#  1) really easy and not worth putting in a 1913 project or
#  2) really, really specific. (it's hard to describe the correct function of
#     these two functions without just telling you exactly how to do it.)
#
#  These are provided to "complete" the project -- I.E. these work with the code you write and allow you to use your
#  functions to generate word-searches for personal use. It is RECOMMENDED that you build a front-end for this behavior
#  so you can more easily use and play-with the finished product.
####
def add_word(word_grid, word):
    ''' Attempts to '''
    width, height = get_size(word_grid)
    for attempt_num in range(50):
        direction = random.choice(DIRECTIONS)
        x = random.randrange(width)
        y = random.randrange(height)
        location = (x, y)
        if can_add_word(word_grid, word, location, direction):
            do_add_word(word_grid, word, location, direction)
            return True
    return False

def generate(width, height, words):
    words_actual = []
    word_grid = make_empty_grid(width, height)
    for word in words:
        if add_word(word_grid, word):
            words_actual.append(word)
    fill_blanks(word_grid)
    return word_grid, words_actual

if __name__ == "__main__":
    grid, words = generate(10, 10, ["java", "python", "list", "set", "tuple", "string"])
    print_word_grid(grid)
    for ele in words:
        show_solution(grid,ele)