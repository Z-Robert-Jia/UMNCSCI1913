student_grades = {
    'Andrew': [56, 79, 90, 22, 50],
    'Nisreen': [88, 62, 68, 75, 78],
    'Alan': [95, 88, 92, 85, 85],
    'Chang': [76, 88, 85, 82, 90],
    'Tricia': [99, 92, 95, 89, 99]
}
high_scores = 0
high_name = ""
for name, grade in student_grades.items():
    # Average score
    ave = sum(grade)/len(grade)

    # Score percentage
    perc = min(grade)/max(grade)

    # finding the highest score
    if max(grade)>high_scores:
        high_name=name
        high_scores=max(grade)
    print(f'The grade percentage of {name}\'s score is {perc}, average is {ave}')

# Curve the grades
for grade in student_grades.values():
    for ele in grade:
        ele *= 100/high_scores
print(student_grades)

# Making sets
# Create a set using the set() function.
nums1 = set([1, 2, 3])

# Create a set using a set literal.
nums2 = { 7, 8, 9 }

# Print the contents of the sets.
print(nums1)
print(nums2)
# Invalid syntax: set(10, 20, 25)

male_names = { 'Oliver', 'Declan', 'Henry' }
name_to_remove = 'Oliver'
name_to_add = 'Robert'

''' Your solution goes here '''
male_names.remove(name_to_remove)
male_names.add(name_to_add)
print(len(male_names))
print(male_names)
# clear name
male_names.clear()

person1_cities = {'Edmonton', 'Vancouver', 'Paris', 'Bangkok', 'Bend', 'Boise', 'Memphis', 'Zurich', 'Accra', 'Cairo'}
person2_cities = {'Accra', 'Orlando', 'Tokyo', 'Paris', 'Anaheim', 'Buenos Aires', 'London', 'Lima', 'Seoul', 'Bangkok'}

# Use set methods to create sets all_cities, same_cities, and different_cities.

''' Your solution goes here '''
all_cities = person1_cities.union(person2_cities)
same_cities = person1_cities.intersection(person2_cities)
different_cities = person1_cities.symmetric_difference(person2_cities)

print(sorted(all_cities))
print(sorted(same_cities))
print(sorted(different_cities))