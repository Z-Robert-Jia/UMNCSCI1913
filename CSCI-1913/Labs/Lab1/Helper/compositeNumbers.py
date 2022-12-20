# CSCI 1913 Lab 01 Fall 2022
# All assignments should start with a "header comment" like this one.
# it should list what the file is (lab01 fall 2022) and who wrote it (below)
# This will be a standing REQUIREMENT for the whole semester.
# Authors: TODO: Zheng Robert Jia
#          TODO: Daniyal Khan


# NOTE: You should pay attention to how this file is structured -- you'll be making these files on your own after this
# lab -- so you'll want to know about all the "details" (other than correct code) that we expect! The big things to pay
# attention to here is the header comment at the top, and the docstrings (STRINGS on the first line of a function
# describing what the function does) -- this is a formal part of the programming language that is used to document code.

def num_divisors(n):
    """Given an integer input n, return the number of positive integers that are divisors of n
    (including 1 and itself)"""
    if n <= 0:
        return 0
    count = 1
    for i in range(1,n // 2 + 1):
        if n % i == 0:
            count += 1
    return count


# hard to make this NOT work on negative numbers with num_divisors being weird for negatives.
def is_highly_composite_number(n):
    """ an integer n is a highly composite number if and only if it is a positive integer with
    more divisors than any positive interger smaller than it.
    returns a boolean that indicates if it is a highly composite number"""
    if n <= 0:
        return False
    ret = True
    num_div = num_divisors(n)
    # loop over the previous numers
    for i in range(1,n):
        # determine if the previous divisors are greater than the current one
        if num_divisors(i) >= num_div:
            ret = False
    return ret


def kluver_cat_name():
    return "Willow"


# TODO: you need to declare one extra function here


# REMINDER: For submission you should have no code outside of functions.
# it can be quite useful **while developing your code** to use print statements
# at the end of this file to run tests (example:)
print(is_highly_composite_number(60))  # TODO: before submitting the code -- delete this.
# but, for the actual submission -- this has to be deleted
