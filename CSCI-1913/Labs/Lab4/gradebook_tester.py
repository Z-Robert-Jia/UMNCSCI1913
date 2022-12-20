from gradebook import *
import time
sorted_put([(100.0, 'Angeline Milton'), (93.5, 'Bob Giannopoulos'), (91.8, 'John Darwin'), (87.5, 'Kawisenhawe Strnad'), (86.2, 'Kobe Santiago'), (65.1, 'Marja Landau')], 'Lindsey Louvre', 99.2)
empty = []
gb1 = [(100.0, "Angeline Milton"), (91.8, "John Darwin"),
       (99.2, "Lindsey Louvre"), (92.7, "Pepper Potts")]
gb2 = [(88.7, "Renato Joshi"), (65.2, "Newen McEachern"),
       (73.5, "Christ Engberg"), (95.6, "Djuradj Hawkins")]
gb3 = [(90.0, "Ingulf Grosser"), (91.9, "Dot Lukács"),
       (97.6, "Persefoni Oláh"), (93.3, "Isabel Wallace")]
gb4 = [(95.4, "Cáel Heinz"), (68.2, "Kjell Lebrun"),
       (96.3, "Nanjala Santo"), (84.7, "Thelonius Aitken")]
gb5 = [(77.0, "Laurena Muggia"), (86.2, "Alojz Riber"),
       (73.4, "Bartolomeu Mac Ghabhann"), (78.1, "Radhika Friedrich")]

print("\nTesting is_sorted():\n")
print(is_sorted(empty))  # True
print(is_sorted(gb1))   # True
print(is_sorted(gb2))   # False
print(is_sorted(gb3))   # False
print(is_sorted(gb4))   # True
print(is_sorted(gb5))   # False

print("\nTesting grade_average():\n")
print(grade_average(empty))  # 0.0
print(grade_average(gb1))   # 95.925
print(grade_average(gb2))   # 80.75
print(grade_average(gb3))   # 93.2
print(grade_average(gb4))   # 86.15
print(grade_average(gb5))   # 78.675

print("\nTesting unsorted_get():\n")

print(unsorted_get(empty, "Madhava Grünspan"))      # None
print(unsorted_get(gb1, "Angeline Milton"))         # 100.0
print(unsorted_get(gb2, "Ingulf Grosser"))          # None
print(unsorted_get(gb3, "Ingulf Grosser"))          # 90.0
print(unsorted_get(gb4, 4))                         # None
print(unsorted_get(gb5, "Bartolomeu Mac Ghabhann"))  # 73.4
print(unsorted_get(gb1, "Pepper Potts"))  # 92.7

print("\nTesting unsorted_put():\n")
empty = []
unsorted_put(empty, "Marthese Ware", 92.3)
print(empty)                                      # [(92.3, 'Marthese Ware')]
unsorted_put(empty, "Marthese Ware", 93.3)
print(empty)                                      # [(93.3, 'Marthese Ware')]
unsorted_put(empty, "Remus Poirot", 88.8)
# [(93.3, 'Marthese Ware'), (88.8, 'Remus Poirot')]
for x in gb1:
    unsorted_put(empty, x[1], x[0])
print(empty)
#[(93.3, 'Marthese Ware'), (88.8, 'Remus Poirot'), (100.0, 'Angeline Milton'), (91.8, 'John Darwin'), (99.2, 'Lindsey Louvre'), (92.7, 'Pepper Potts')]

empty = []

print("\nTesting sorted_get():\n")
print(sorted_get(empty, "Eutropios Abbatangelo"))  # None
print(sorted_get(gb1, "Angeline Milton"))         # 100.0
print(sorted_get(gb1, "John Darwin"))             # 91.8
print(sorted_get(gb1, "Peter Parker"))            # None
print(sorted_get(gb1, "Pepper Potts"))            # 92.7

print("\nBig sorted_get test:\n")
big = []
for i in range(0, 10000):
    big.append((i, str(i)))
s = time.time()
sorted_get(big, "10000")
e = time.time()
print(e-s < 0.0002)
# True

print("\nTesting sorted_put():\n")
empty = []
sorted_put(empty, "Kobe Santiago", 86.2)
print(empty)    # [(86.2, 'Kobe Santiago')]
sorted_put(empty, "Kawisenhawe Strnad", 81.5)
print(empty)    # [(81.5, 'Kawisenhawe Strnad'), (86.2, 'Kobe Santiago')]
sorted_put(empty, "Kawisenhawe Strnad", 87.5)
print(empty)    # [(87.5, 'Kawisenhawe Strnad'), (86.2, 'Kobe Santiago')]
sorted_put(empty, "Marja Landau", 65.1)
# [(87.5, 'Kawisenhawe Strnad'), (86.2, 'Kobe Santiago'), (65.1, 'Marja Landau')]
print(empty)
sorted_put(empty, "Bob Giannopoulos", 93.5)
# [(93.5, 'Bob Giannopoulos'), (87.5, 'Kawisenhawe Strnad'), (86.2, 'Kobe Santiago'), (65.1, 'Marja Landau')]
print(empty)
sorted_put(empty, "Kobe Santiago", 89.6)
# [(93.5, 'Bob Giannopoulos'), (87.5, 'Kawisenhawe Strnad'), (89.6, 'Kobe Santiago'), (65.1, 'Marja Landau')]
print(empty)
for x in gb1:
    sorted_put(empty, x[1], x[0])
    print(empty)
print(empty)
# [(100.0, 'Angeline Milton'), (93.5, 'Bob Giannopoulos'), (91.8, 'John Darwin'), (87.5, 'Kawisenhawe Strnad'), (89.6, 'Kobe Santiago'), (99.2, 'Lindsey Louvre'), (65.1, 'Marja Landau'), (92.7, 'Pepper Potts')]

'''



Testing is_sorted():

True
True
False
False
True
False

Testing grade_average():

0.0
95.925
80.75
93.2
86.15
78.675

Testing unsorted_get():

None
100.0
None
90.0
None
73.4
92.7

Testing unsorted_put():

[(92.3, 'Marthese Ware')]
[(93.3, 'Marthese Ware')]
[(93.3, 'Marthese Ware'), (88.8, 'Remus Poirot'), (100.0, 'Angeline Milton'), (91.8, 'John Darwin'), (99.2, 'Lindsey Louvre'), (92.7, 'Pepper Potts')]

Testing sorted_get():

None
100.0
91.8
None
92.7

Big sorted_get test:

True

Testing sorted_put():

[(86.2, 'Kobe Santiago')]
[(81.5, 'Kawisenhawe Strnad'), (86.2, 'Kobe Santiago')]
[(87.5, 'Kawisenhawe Strnad'), (86.2, 'Kobe Santiago')]
[(87.5, 'Kawisenhawe Strnad'), (86.2, 'Kobe Santiago'), (65.1, 'Marja Landau')]
[(93.5, 'Bob Giannopoulos'), (87.5, 'Kawisenhawe Strnad'), (86.2, 'Kobe Santiago'), (65.1, 'Marja Landau')]
[(93.5, 'Bob Giannopoulos'), (87.5, 'Kawisenhawe Strnad'), (89.6, 'Kobe Santiago'), (65.1, 'Marja Landau')]
[(100.0, 'Angeline Milton'), (93.5, 'Bob Giannopoulos'), (91.8, 'John Darwin'), (87.5, 'Kawisenhawe Strnad'), (89.6, 'Kobe Santiago'), (99.2, 'Lindsey Louvre'), (65.1, 'Marja Landau'), (92.7, 'Pepper Potts')]
'''
