### A FEW NOTES TO STUDENTS. READ THIS TO GET THE MOST OUT OF THE TESTS:
# 1. Each test is setup as printing either "True" (test passed) or "False" (test failed)
# 2. Each test-block has a "header" like "generate_words_list tests" that you can use to find specific tests in the file
#    the file is kind of long so plan to use this...
# 3. The tests are _incremental_ some are really basic, others are really complicated and try to push your code to it's
#    limit, or check for specific edge-cases. As you do fail some tests make sure you try to understand why the test is
#    setup the way it is and what it's actually trying to evaluate.
# 4. Most tests have a _commented out_ print line after which will show you what your code actually output. If you are
#    having trouble with a given function, make sure you're uncommenting this to help you debug your code!
# 5. Don't forget that many of the functions rely on earlier functions -- if you're failing tests for early functions
#    this itself can make you fail tests for the later functions too!


stopwords = {'i', 'me', 'my', 'myself', 'we', 'our', 'ours', 'ourselves', 'you', 'your', 'yours', 'yourself',
             'yourselves', 'he', 'him', 'his', 'himself', 'she', 'her', 'hers', 'herself', 'it', 'its', 'itself',
             'they', 'them', 'their', 'theirs', 'themselves', 'what', 'which', 'who', 'whom', 'this', 'that', 'these',
             'those', 'am', 'is', 'are', 'was', 'were', 'be', 'been', 'being', 'have', 'has', 'had', 'having', 'do',
             'does', 'did', 'doing', 'a', 'an', 'the', 'and', 'but', 'if', 'or', 'because', 'as', 'until', 'while',
             'of', 'at', 'by', 'for', 'with', 'about', 'against', 'between', 'into', 'through', 'during', 'before',
             'after', 'above', 'below', 'to', 'from', 'up', 'down', 'in', 'out', 'on', 'off', 'over', 'under', 'again',
             'further', 'then', 'once', 'here', 'there', 'when', 'where', 'why', 'how', 'all', 'any', 'both', 'each',
             'few', 'more', 'most', 'other', 'some', 'such', 'no', 'nor', 'not', 'only', 'own', 'same', 'so', 'than',
             'too', 'very', 's', 't', 'can', 'will', 'just', 'don', 'should', 'now'}


from textprocessing import generate_words_list
print("generate_words_list tests")

toy = 'a b c d e'
expected = ['a', 'b', 'c', 'd', 'e']
words_list1 = generate_words_list(toy)
print(words_list1 == expected)
# print(words_list1)

text2 = 'a player who gets an out gets a negative probability in most cases thus i am not sure in any given game when you add up all the numbers for a team who won that they will add up to 1 in that game sometimes they will add up to more then one sometime less than one also the pitchers bad performance giving up 6 runs may have given them a large negative percentage for that game'
expected = ['a', 'player', 'who', 'gets', 'an', 'out', 'gets', 'a', 'negative', 'probability', 'in', 'most', 'cases',
            'thus', 'i', 'am', 'not', 'sure', 'in', 'any', 'given', 'game', 'when', 'you', 'add', 'up', 'all', 'the',
            'numbers', 'for', 'a', 'team', 'who', 'won', 'that', 'they', 'will', 'add', 'up', 'to', '1', 'in', 'that',
            'game', 'sometimes', 'they', 'will', 'add', 'up', 'to', 'more', 'then', 'one', 'sometime', 'less', 'than',
            'one', 'also', 'the', 'pitchers', 'bad', 'performance', 'giving', 'up', '6', 'runs', 'may', 'have', 'given',
            'them', 'a', 'large', 'negative', 'percentage', 'for', 'that', 'game']
words_list2 = generate_words_list(text2)
print(words_list2 == expected)
# print(words_list2)

empty = ''
result = generate_words_list(empty)
expected = []
print(result == expected)
# print(result)

text1 = 'the only problem here is an insistance that these number mean exactly how many wins the team has first we are using averages over many seasons and applying them to one game second remember some players performance take away from the chance of you winning that is a player who gets an out gets a negative probability in most cases thus i am not sure in any given game when you add up all the numbers for a team who won that they will add up to 1 in that game sometimes they will add up to more then one sometime less than one also the pitchers bad performance giving up 6 runs may have given them a large negative percentage for that game also any batter that pulled an 0-4 night would give large negatives'
expected = ['the', 'only', 'problem', 'here', 'is', 'an', 'insistance', 'that', 'these', 'number', 'mean', 'exactly',
            'how', 'many', 'wins', 'the', 'team', 'has', 'first', 'we', 'are', 'using', 'averages', 'over', 'many',
            'seasons', 'and', 'applying', 'them', 'to', 'one', 'game', 'second', 'remember', 'some', 'players',
            'performance', 'take', 'away', 'from', 'the', 'chance', 'of', 'you', 'winning', 'that', 'is', 'a', 'player',
            'who', 'gets', 'an', 'out', 'gets', 'a', 'negative', 'probability', 'in', 'most', 'cases', 'thus', 'i',
            'am', 'not', 'sure', 'in', 'any', 'given', 'game', 'when', 'you', 'add', 'up', 'all', 'the', 'numbers',
            'for', 'a', 'team', 'who', 'won', 'that', 'they', 'will', 'add', 'up', 'to', '1', 'in', 'that', 'game',
            'sometimes', 'they', 'will', 'add', 'up', 'to', 'more', 'then', 'one', 'sometime', 'less', 'than', 'one',
            'also', 'the', 'pitchers', 'bad', 'performance', 'giving', 'up', '6', 'runs', 'may', 'have', 'given',
            'them', 'a', 'large', 'negative', 'percentage', 'for', 'that', 'game', 'also', 'any', 'batter', 'that',
            'pulled', 'an', '0-4', 'night', 'would', 'give', 'large', 'negatives']
words_list1 = generate_words_list(text1)
print(words_list1 == expected)
# print(words_list1)


from textprocessing import remove_stop_words
print("remove_stop_words tests")

toy = ['a', 'b', 'c', 'd', 'e']
result = remove_stop_words(toy, stopwords)
expected = ['b', 'c', 'd', 'e']

print(result == expected)
# print(words_list1)

words_list1 = ['the', 'only', 'problem', 'here', 'is', 'an', 'insistance', 'that', 'these', 'number', 'mean', 'exactly', 'how', 'many', 'wins', 'the', 'team', 'has', 'first', 'we', 'are', 'using', 'averages', 'over', 'many', 'seasons', 'and', 'applying', 'them', 'to', 'one', 'game', 'second', 'remember', 'some', 'players', 'performance', 'take', 'away', 'from', 'the', 'chance', 'of', 'you', 'winning', 'that', 'is', 'a', 'player', 'who', 'gets', 'an', 'out', 'gets', 'a', 'negative', 'probability', 'in', 'most', 'cases', 'thus', 'i', 'am', 'not', 'sure', 'in', 'any', 'given', 'game', 'when', 'you', 'add', 'up', 'all', 'the', 'numbers', 'for', 'a', 'team', 'who', 'won', 'that', 'they', 'will', 'add', 'up', 'to', '1', 'in', 'that', 'game', 'sometimes', 'they', 'will', 'add', 'up', 'to', 'more', 'then', 'one', 'sometime', 'less', 'than', 'one', 'also', 'the', 'pitchers', 'bad', 'performance', 'giving', 'up', '6', 'runs', 'may', 'have', 'given', 'them', 'a', 'large', 'negative', 'percentage', 'for', 'that', 'game', 'also', 'any', 'batter', 'that', 'pulled', 'an', '0-4', 'night', 'would', 'give', 'large', 'negatives']
result = remove_stop_words(words_list1, stopwords)
expected = ['problem', 'insistance', 'number', 'mean', 'exactly', 'many', 'wins', 'team', 'first', 'using', 'averages', 'many', 'seasons', 'applying', 'one', 'game', 'second', 'remember', 'players', 'performance', 'take', 'away', 'chance', 'winning', 'player', 'gets', 'gets', 'negative', 'probability', 'cases', 'thus', 'sure', 'given', 'game', 'add', 'numbers', 'team', 'won', 'add', '1', 'game', 'sometimes', 'add', 'one', 'sometime', 'less', 'one', 'also', 'pitchers', 'bad', 'performance', 'giving', '6', 'runs', 'may', 'given', 'large', 'negative', 'percentage', 'game', 'also', 'batter', 'pulled', '0-4', 'night', 'would', 'give', 'large', 'negatives']

print(result == expected)
# print(words_list1)

result = generate_words_list(empty)
expected = []
print(result == expected)
# print(result)

words_list2 = ['a', 'player', 'who', 'gets', 'an', 'out', 'gets', 'a', 'negative', 'probability', 'in', 'most', 'cases', 'thus', 'i', 'am', 'not', 'sure', 'in', 'any', 'given', 'game', 'when', 'you', 'add', 'up', 'all', 'the', 'numbers', 'for', 'a', 'team', 'who', 'won', 'that', 'they', 'will', 'add', 'up', 'to', '1', 'in', 'that', 'game', 'sometimes', 'they', 'will', 'add', 'up', 'to', 'more', 'then', 'one', 'sometime', 'less', 'than', 'one', 'also', 'the', 'pitchers', 'bad', 'performance', 'giving', 'up', '6', 'runs', 'may', 'have', 'given', 'them', 'a', 'large', 'negative', 'percentage', 'for', 'that', 'game']
result = remove_stop_words(words_list2, stopwords)
expected = ['player', 'gets', 'gets', 'negative', 'probability', 'cases', 'thus', 'sure', 'given', 'game', 'add', 'numbers', 'team', 'won', 'add', '1', 'game', 'sometimes', 'add', 'one', 'sometime', 'less', 'one', 'also', 'pitchers', 'bad', 'performance', 'giving', '6', 'runs', 'may', 'given', 'large', 'negative', 'percentage', 'game']
print(result == expected)
# print(words_list2)



from textprocessing import word_count
print("word_count tests")

toy = 'a b c d e'
result = word_count(toy)
expected = {'a': 1, 'b': 1, 'c': 1, 'd': 1, 'e': 1}
print(result == expected)
#print(result)


result = word_count(text2)
expected = {'a': 4, 'player': 1, 'who': 2, 'gets': 2, 'an': 1, 'out': 1, 'negative': 2, 'probability': 1, 'in': 3, 'most': 1, 'cases': 1, 'thus': 1, 'i': 1, 'am': 1, 'not': 1, 'sure': 1, 'any': 1, 'given': 2, 'game': 3, 'when': 1, 'you': 1, 'add': 3, 'up': 4, 'all': 1, 'the': 2, 'numbers': 1, 'for': 2, 'team': 1, 'won': 1, 'that': 3, 'they': 2, 'will': 2, 'to': 2, '1': 1, 'sometimes': 1, 'more': 1, 'then': 1, 'one': 2, 'sometime': 1, 'less': 1, 'than': 1, 'also': 1, 'pitchers': 1, 'bad': 1, 'performance': 1, 'giving': 1, '6': 1, 'runs': 1, 'may': 1, 'have': 1, 'them': 1, 'large': 1, 'percentage': 1}
print(result == expected)
#print(result)

result = word_count(empty)
expected = {}
print(result == expected)
#print(result)
result = word_count(text1)
expected = {'the': 5, 'only': 1, 'problem': 1, 'here': 1, 'is': 2, 'an': 3, 'insistance': 1, 'that': 6, 'these': 1, 'number': 1, 'mean': 1, 'exactly': 1, 'how': 1, 'many': 2, 'wins': 1, 'team': 2, 'has': 1, 'first': 1, 'we': 1, 'are': 1, 'using': 1, 'averages': 1, 'over': 1, 'seasons': 1, 'and': 1, 'applying': 1, 'them': 2, 'to': 3, 'one': 3, 'game': 4, 'second': 1, 'remember': 1, 'some': 1, 'players': 1, 'performance': 2, 'take': 1, 'away': 1, 'from': 1, 'chance': 1, 'of': 1, 'you': 2, 'winning': 1, 'a': 4, 'player': 1, 'who': 2, 'gets': 2, 'out': 1, 'negative': 2, 'probability': 1, 'in': 3, 'most': 1, 'cases': 1, 'thus': 1, 'i': 1, 'am': 1, 'not': 1, 'sure': 1, 'any': 2, 'given': 2, 'when': 1, 'add': 3, 'up': 4, 'all': 1, 'numbers': 1, 'for': 2, 'won': 1, 'they': 2, 'will': 2, '1': 1, 'sometimes': 1, 'more': 1, 'then': 1, 'sometime': 1, 'less': 1, 'than': 1, 'also': 2, 'pitchers': 1, 'bad': 1, 'giving': 1, '6': 1, 'runs': 1, 'may': 1, 'have': 1, 'large': 2, 'percentage': 1, 'batter': 1, 'pulled': 1, '0-4': 1, 'night': 1, 'would': 1, 'give': 1, 'negatives': 1}
print(result == expected)
#print(result)

from textprocessing import get_longest_words
print("get_longest_word tests")

toy = 'a b c de e'
result = get_longest_words(toy)
expected = {'de'}
print(result == expected)
# print(result)

result = get_longest_words(text2)
expected = {'probability', 'performance'}
print(result == expected)
# print(result)

result = get_longest_words(empty)
expected = set()
print(result == expected)
# print(result)

result = get_longest_words(text1)
expected = {'probability', 'performance'}
print(result == expected)
# print(result)

from textprocessing import cal_cosine_similarity
print("cal_cosine_similarity")

example1 = {'a': 1, 'b': 2, 'c': 3}
example2 = {'a': 5, 'd': 2, 'c': 1, 'e': 4}
result = cal_cosine_similarity(example1, example2)
expected = 0.3152
print(result == expected)
# print(result)


example1 = {}
example2 = {}
result = cal_cosine_similarity(example1, example2)
expected = 0
print(result == expected)
# print(result)


example1 = {'the': 5, 'only': 1, 'problem': 1, 'here': 1, 'is': 2, 'an': 3, 'insistance': 1, 'that': 6, 'these': 1, 'number': 1, 'mean': 1, 'exactly': 1, 'how': 1, 'many': 2, 'wins': 1, 'team': 2, 'has': 1, 'first': 1, 'we': 1, 'are': 1, 'using': 1, 'averages': 1, 'over': 1, 'seasons': 1, 'and': 1, 'applying': 1, 'them': 2, 'to': 3, 'one': 3, 'game': 4, 'second': 1, 'remember': 1, 'some': 1, 'players': 1, 'performance': 2, 'take': 1, 'away': 1, 'from': 1, 'chance': 1, 'of': 1, 'you': 2, 'winning': 1, 'a': 4, 'player': 1, 'who': 2, 'gets': 2, 'out': 1, 'negative': 2, 'probability': 1, 'in': 3, 'most': 1, 'cases': 1, 'thus': 1, 'i': 1, 'am': 1, 'not': 1, 'sure': 1, 'any': 2, 'given': 2, 'when': 1, 'add': 3, 'up': 4, 'all': 1, 'numbers': 1, 'for': 2, 'won': 1, 'they': 2, 'will': 2, '1': 1, 'sometimes': 1, 'more': 1, 'then': 1, 'sometime': 1, 'less': 1, 'than': 1, 'also': 2, 'pitchers': 1, 'bad': 1, 'giving': 1, '6': 1, 'runs': 1, 'may': 1, 'have': 1, 'large': 2, 'percentage': 1, 'batter': 1, 'pulled': 1, '0-4': 1, 'night': 1, 'would': 1, 'give': 1, 'negatives': 1}
example2 = {'a': 4, 'player': 1, 'who': 2, 'gets': 2, 'an': 1, 'out': 1, 'negative': 2, 'probability': 1, 'in': 3, 'most': 1, 'cases': 1, 'thus': 1, 'i': 1, 'am': 1, 'not': 1, 'sure': 1, 'any': 1, 'given': 2, 'game': 3, 'when': 1, 'you': 1, 'add': 3, 'up': 4, 'all': 1, 'the': 2, 'numbers': 1, 'for': 2, 'team': 1, 'won': 1, 'that': 3, 'they': 2, 'will': 2, 'to': 2, '1': 1, 'sometimes': 1, 'more': 1, 'then': 1, 'one': 2, 'sometime': 1, 'less': 1, 'than': 1, 'also': 1, 'pitchers': 1, 'bad': 1, 'performance': 1, 'giving': 1, '6': 1, 'runs': 1, 'may': 1, 'have': 1, 'them': 1, 'large': 1, 'percentage': 1}
result = cal_cosine_similarity(example1, example2)
expected = 0.8673
print(result == expected)
# print(result)


from textprocessing import most_similar_string
print("most_similar_string tests")
query = 'ab bc cd'
string_list = ['aa ab ac',
               'bb bb dd de',
               'ae bc cd']


result = most_similar_string(query, string_list)
expected = 'ae bc cd'
print(result == expected)
# print(result)

query = 'ab a ce'
string_list = ['aa ab ac',
               'bb ce dd a',
               'ae ebc cd']

result = most_similar_string(query, string_list)
expected = 'bb ce dd a'
print(result == expected)
# print(result)

query = ''
string_list = []

result = most_similar_string(query, string_list)
expected = ''
print(result == expected)
# print(result)

query = 'g'
string_list = ['aa ab ac',
               'c g',
               'b']

result = most_similar_string(query, string_list)
expected = 'c g'

print(result == expected)
# print(result)