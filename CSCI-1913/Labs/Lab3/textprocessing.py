# CSCI 1913 Lab 01 Fall 2022
"""
Authors: TODO: Zheng Robert Jia
         TODO: Daniyal Khan
"""
import math


def generate_words_list(str):
    """
    :param str: a String separated by spaces and no punctuations
    :return: a list of strings where each string is one word from the input
    """
    if len(str) < 1:
        return []
    return str.split()


def remove_stop_words(lst, stop_words_set):
    """
    removes stop words from lst
    :param lst: a list of words
    :param stop_words_set: a set of stop_words needed to be removed from lst
    :return: the modified list
    """
    ret_lst = []
    # loop, if in don't append
    for ele in lst:
        if ele not in stop_words_set:
            ret_lst.append(ele)
    return ret_lst


def word_count(str):
    """
    counts how many times each word appear in the string
    :param str: a string
    :return: a dictionary of word count
    """
    # list of words and empty dictionary
    dic = {}
    lst = generate_words_list(str)
    # count the number of occurrence of each element and update it to the dictionary
    for words in lst:
        if words not in dic:
            dic.update({words: lst.count(words)})
    return dic


def get_longest_words(str):
    """
    :param str: a string following the previous restrictions in generate word list
    :return: return a set of longest words
    I could potentially improve this by combining the two loops together.
    but for now I think the two loops completes the task
    """
    longest_word_set = set()
    lst = generate_words_list(str)
    if len(lst) == 0:
        return longest_word_set
    # find the length of the longest word
    max_length = 0

    for ele in lst:
        if len(ele) > max_length:
            max_length = len(ele)
    # add all elements with max_length to the set
    for ele in lst:
        if len(ele) == max_length:
            longest_word_set.add(ele)
    return longest_word_set

def cal_cosine_similarity(dic1,dic2):
    """
    accepts 2 dictionaries, and calculate their cosine similarities based on their length
    :param dic1: first dictionary
    :param dic2: second dictionary
    :return: returns a float back
    """
    # Three similarities
    S1 = 0
    S2 = 0
    S3 = 0
    # Calculate S1 and S2
    for values in dic1.values():
        S1 += values ** 2

    for values in dic2.values():
        S2 += values ** 2

    # Calculate S3
    # Find elements that are in both dictionaries and sum up their values
    # Loop through the first dictionary
    for key in dic1.keys():
        if key in dic2:
            S3 += dic1[key] * dic2[key]
    # calculate cos_sim
    if S1 == 0 or S2 == 0 or S3 == 0:
        return round(0.000,4)
    cos_sim = S3/(math.sqrt(S1)*math.sqrt((S2)))
    return round(cos_sim, 4)

def most_similar_string(str,lst_str):
    """
    Combines the previous functions to calculate which string in the lst_str is most similar to str
    :param str: a string
    :param lst_str: a list of strings
    :return: a string is lst_str that is most similar to str
    """
    if len(lst_str)==0:
        return ""
    # Make a dictionary for the query string
    dic_str = word_count(str)
    most_similar_str = ""
    # loop over each string in lst_str
    max_sim = 0
    for ele in lst_str:
        dic_str_lst_str = word_count(ele)
        # use cal_cosine_sim to calculate each cos_sim
        if cal_cosine_similarity(dic_str,dic_str_lst_str) > max_sim:
            max_sim = cal_cosine_similarity(dic_str,dic_str_lst_str)
            most_similar_str = ele

    return most_similar_str
    # Find the biggest cos_sim

# # Testing the functions
# if __name__ == "__main__":
#     stopwords = {'i', 'me', 'my', 'myself', 'we', 'our', 'ours', 'ourselves', 'you', 'your', 'yours', 'yourself',
#                  'yourselves', 'he', 'him', 'his', 'himself', 'she', 'her', 'hers', 'herself', 'it', 'its', 'itself',
#                  'they', 'them', 'their', 'theirs', 'themselves', 'what', 'which', 'who', 'whom', 'this', 'that',
#                  'these',
#                  'those', 'am', 'is', 'are', 'was', 'were', 'be', 'been', 'being', 'have', 'has', 'had', 'having', 'do',
#                  'does', 'did', 'doing', 'a', 'an', 'the', 'and', 'but', 'if', 'or', 'because', 'as', 'until', 'while',
#                  'of', 'at', 'by', 'for', 'with', 'about', 'against', 'between', 'into', 'through', 'during', 'before',
#                  'after', 'above', 'below', 'to', 'from', 'up', 'down', 'in', 'out', 'on', 'off', 'over', 'under',
#                  'again',
#                  'further', 'then', 'once', 'here', 'there', 'when', 'where', 'why', 'how', 'all', 'any', 'both',
#                  'each',
#                  'few', 'more', 'most', 'other', 'some', 'such', 'no', 'nor', 'not', 'only', 'own', 'same', 'so',
#                  'than',
#                  'too', 'very', 's', 't', 'can', 'will', 'just', 'don', 'should', 'now'}
#     print("generate_words_list tests")
#     # --------- Testing the first function
#     toy = 'a b c d e'
#     expected = ['a', 'b', 'c', 'd', 'e']
#     words_list1 = generate_words_list(toy)
#     print(words_list1 == expected)
#     # print(words_list1)
#
#     text2 = 'a player who gets an out gets a negative probability in most cases thus i am not sure in any given game when you add up all the numbers for a team who won that they will add up to 1 in that game sometimes they will add up to more then one sometime less than one also the pitchers bad performance giving up 6 runs may have given them a large negative percentage for that game'
#     expected = ['a', 'player', 'who', 'gets', 'an', 'out', 'gets', 'a', 'negative', 'probability', 'in', 'most',
#                 'cases',
#                 'thus', 'i', 'am', 'not', 'sure', 'in', 'any', 'given', 'game', 'when', 'you', 'add', 'up', 'all',
#                 'the',
#                 'numbers', 'for', 'a', 'team', 'who', 'won', 'that', 'they', 'will', 'add', 'up', 'to', '1', 'in',
#                 'that',
#                 'game', 'sometimes', 'they', 'will', 'add', 'up', 'to', 'more', 'then', 'one', 'sometime', 'less',
#                 'than',
#                 'one', 'also', 'the', 'pitchers', 'bad', 'performance', 'giving', 'up', '6', 'runs', 'may', 'have',
#                 'given',
#                 'them', 'a', 'large', 'negative', 'percentage', 'for', 'that', 'game']
#     words_list2 = generate_words_list(text2)
#     print(words_list2 == expected)
#     # print(words_list2)
#
#     empty = ''
#     result = generate_words_list(empty)
#     expected = []
#     print(result == expected)
#     # print(result)
#
#     text1 = 'the only problem here is an insistance that these number mean exactly how many wins the team has first we are using averages over many seasons and applying them to one game second remember some players performance take away from the chance of you winning that is a player who gets an out gets a negative probability in most cases thus i am not sure in any given game when you add up all the numbers for a team who won that they will add up to 1 in that game sometimes they will add up to more then one sometime less than one also the pitchers bad performance giving up 6 runs may have given them a large negative percentage for that game also any batter that pulled an 0-4 night would give large negatives'
#     expected = ['the', 'only', 'problem', 'here', 'is', 'an', 'insistance', 'that', 'these', 'number', 'mean',
#                 'exactly',
#                 'how', 'many', 'wins', 'the', 'team', 'has', 'first', 'we', 'are', 'using', 'averages', 'over', 'many',
#                 'seasons', 'and', 'applying', 'them', 'to', 'one', 'game', 'second', 'remember', 'some', 'players',
#                 'performance', 'take', 'away', 'from', 'the', 'chance', 'of', 'you', 'winning', 'that', 'is', 'a',
#                 'player',
#                 'who', 'gets', 'an', 'out', 'gets', 'a', 'negative', 'probability', 'in', 'most', 'cases', 'thus', 'i',
#                 'am', 'not', 'sure', 'in', 'any', 'given', 'game', 'when', 'you', 'add', 'up', 'all', 'the', 'numbers',
#                 'for', 'a', 'team', 'who', 'won', 'that', 'they', 'will', 'add', 'up', 'to', '1', 'in', 'that', 'game',
#                 'sometimes', 'they', 'will', 'add', 'up', 'to', 'more', 'then', 'one', 'sometime', 'less', 'than',
#                 'one',
#                 'also', 'the', 'pitchers', 'bad', 'performance', 'giving', 'up', '6', 'runs', 'may', 'have', 'given',
#                 'them', 'a', 'large', 'negative', 'percentage', 'for', 'that', 'game', 'also', 'any', 'batter', 'that',
#                 'pulled', 'an', '0-4', 'night', 'would', 'give', 'large', 'negatives']
#     words_list1 = generate_words_list(text1)
#     print(words_list1 == expected)
#     # print(words_list1)
#
#     # Testing the second function
#     print("remove_stop_words tests")
#
#     toy = ['a', 'b', 'c', 'd', 'e']
#     result = remove_stop_words(toy, stopwords)
#     expected = ['b', 'c', 'd', 'e']
#
#     print(result == expected)
#     # print(words_list1)
#
#     words_list1 = ['the', 'only', 'problem', 'here', 'is', 'an', 'insistance', 'that', 'these', 'number', 'mean',
#                    'exactly', 'how', 'many', 'wins', 'the', 'team', 'has', 'first', 'we', 'are', 'using', 'averages',
#                    'over', 'many', 'seasons', 'and', 'applying', 'them', 'to', 'one', 'game', 'second', 'remember',
#                    'some', 'players', 'performance', 'take', 'away', 'from', 'the', 'chance', 'of', 'you', 'winning',
#                    'that', 'is', 'a', 'player', 'who', 'gets', 'an', 'out', 'gets', 'a', 'negative', 'probability',
#                    'in', 'most', 'cases', 'thus', 'i', 'am', 'not', 'sure', 'in', 'any', 'given', 'game', 'when', 'you',
#                    'add', 'up', 'all', 'the', 'numbers', 'for', 'a', 'team', 'who', 'won', 'that', 'they', 'will',
#                    'add', 'up', 'to', '1', 'in', 'that', 'game', 'sometimes', 'they', 'will', 'add', 'up', 'to', 'more',
#                    'then', 'one', 'sometime', 'less', 'than', 'one', 'also', 'the', 'pitchers', 'bad', 'performance',
#                    'giving', 'up', '6', 'runs', 'may', 'have', 'given', 'them', 'a', 'large', 'negative', 'percentage',
#                    'for', 'that', 'game', 'also', 'any', 'batter', 'that', 'pulled', 'an', '0-4', 'night', 'would',
#                    'give', 'large', 'negatives']
#     result = remove_stop_words(words_list1, stopwords)
#     expected = ['problem', 'insistance', 'number', 'mean', 'exactly', 'many', 'wins', 'team', 'first', 'using',
#                 'averages', 'many', 'seasons', 'applying', 'one', 'game', 'second', 'remember', 'players',
#                 'performance', 'take', 'away', 'chance', 'winning', 'player', 'gets', 'gets', 'negative', 'probability',
#                 'cases', 'thus', 'sure', 'given', 'game', 'add', 'numbers', 'team', 'won', 'add', '1', 'game',
#                 'sometimes', 'add', 'one', 'sometime', 'less', 'one', 'also', 'pitchers', 'bad', 'performance',
#                 'giving', '6', 'runs', 'may', 'given', 'large', 'negative', 'percentage', 'game', 'also', 'batter',
#                 'pulled', '0-4', 'night', 'would', 'give', 'large', 'negatives']
#
#     print(result == expected)
#     # print(words_list1)
#
#     result = generate_words_list(empty)
#     expected = []
#     print(result == expected)
#     # print(result)
#
#     words_list2 = ['a', 'player', 'who', 'gets', 'an', 'out', 'gets', 'a', 'negative', 'probability', 'in', 'most',
#                    'cases', 'thus', 'i', 'am', 'not', 'sure', 'in', 'any', 'given', 'game', 'when', 'you', 'add', 'up',
#                    'all', 'the', 'numbers', 'for', 'a', 'team', 'who', 'won', 'that', 'they', 'will', 'add', 'up', 'to',
#                    '1', 'in', 'that', 'game', 'sometimes', 'they', 'will', 'add', 'up', 'to', 'more', 'then', 'one',
#                    'sometime', 'less', 'than', 'one', 'also', 'the', 'pitchers', 'bad', 'performance', 'giving', 'up',
#                    '6', 'runs', 'may', 'have', 'given', 'them', 'a', 'large', 'negative', 'percentage', 'for', 'that',
#                    'game']
#     result = remove_stop_words(words_list2, stopwords)
#     expected = ['player', 'gets', 'gets', 'negative', 'probability', 'cases', 'thus', 'sure', 'given', 'game', 'add',
#                 'numbers', 'team', 'won', 'add', '1', 'game', 'sometimes', 'add', 'one', 'sometime', 'less', 'one',
#                 'also', 'pitchers', 'bad', 'performance', 'giving', '6', 'runs', 'may', 'given', 'large', 'negative',
#                 'percentage', 'game']
#     print(result == expected)
#     # print(words_list2)
#
#     # Test function 3
#     print("word_count tests")
#
#     toy = 'a b c d e'
#     result = word_count(toy)
#     expected = {'a': 1, 'b': 1, 'c': 1, 'd': 1, 'e': 1}
#     print(result == expected)
#     # print(result)
#
#     result = word_count(text2)
#     expected = {'a': 4, 'player': 1, 'who': 2, 'gets': 2, 'an': 1, 'out': 1, 'negative': 2, 'probability': 1, 'in': 3,
#                 'most': 1, 'cases': 1, 'thus': 1, 'i': 1, 'am': 1, 'not': 1, 'sure': 1, 'any': 1, 'given': 2, 'game': 3,
#                 'when': 1, 'you': 1, 'add': 3, 'up': 4, 'all': 1, 'the': 2, 'numbers': 1, 'for': 2, 'team': 1, 'won': 1,
#                 'that': 3, 'they': 2, 'will': 2, 'to': 2, '1': 1, 'sometimes': 1, 'more': 1, 'then': 1, 'one': 2,
#                 'sometime': 1, 'less': 1, 'than': 1, 'also': 1, 'pitchers': 1, 'bad': 1, 'performance': 1, 'giving': 1,
#                 '6': 1, 'runs': 1, 'may': 1, 'have': 1, 'them': 1, 'large': 1, 'percentage': 1}
#     print(result == expected)
#     # print(result)
#
#     result = word_count(empty)
#     expected = {}
#     print(result == expected)
#     # print(result)
#     result = word_count(text1)
#     expected = {'the': 5, 'only': 1, 'problem': 1, 'here': 1, 'is': 2, 'an': 3, 'insistance': 1, 'that': 6, 'these': 1,
#                 'number': 1, 'mean': 1, 'exactly': 1, 'how': 1, 'many': 2, 'wins': 1, 'team': 2, 'has': 1, 'first': 1,
#                 'we': 1, 'are': 1, 'using': 1, 'averages': 1, 'over': 1, 'seasons': 1, 'and': 1, 'applying': 1,
#                 'them': 2, 'to': 3, 'one': 3, 'game': 4, 'second': 1, 'remember': 1, 'some': 1, 'players': 1,
#                 'performance': 2, 'take': 1, 'away': 1, 'from': 1, 'chance': 1, 'of': 1, 'you': 2, 'winning': 1, 'a': 4,
#                 'player': 1, 'who': 2, 'gets': 2, 'out': 1, 'negative': 2, 'probability': 1, 'in': 3, 'most': 1,
#                 'cases': 1, 'thus': 1, 'i': 1, 'am': 1, 'not': 1, 'sure': 1, 'any': 2, 'given': 2, 'when': 1, 'add': 3,
#                 'up': 4, 'all': 1, 'numbers': 1, 'for': 2, 'won': 1, 'they': 2, 'will': 2, '1': 1, 'sometimes': 1,
#                 'more': 1, 'then': 1, 'sometime': 1, 'less': 1, 'than': 1, 'also': 2, 'pitchers': 1, 'bad': 1,
#                 'giving': 1, '6': 1, 'runs': 1, 'may': 1, 'have': 1, 'large': 2, 'percentage': 1, 'batter': 1,
#                 'pulled': 1, '0-4': 1, 'night': 1, 'would': 1, 'give': 1, 'negatives': 1}
#     print(result == expected)
#     # print(result)
#
#     print("get_longest_word tests")
#
#     toy = 'a b c de e'
#     result = get_longest_words(toy)
#     expected = {'de'}
#     print(result == expected)
#     # print(result)
#
#     result = get_longest_words(text2)
#     expected = {'probability', 'performance'}
#     print(result == expected)
#     # print(result)
#
#     result = get_longest_words(empty)
#     expected = set()
#     print(result == expected)
#     # print(result)
#
#     result = get_longest_words(text1)
#     expected = {'probability', 'performance'}
#     print(result == expected)
#     # print(result)
