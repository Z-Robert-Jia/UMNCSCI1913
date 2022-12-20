# Creating classes

class Employee:
    def __init__(self, first, last, pay):
        self.first = first
        self.last = last
        self.pay = pay
        self.email = first + '.' + last + '@company.com'
    def fullname(self):
        return '{} {}'.format(self.first,self.last)

empy_1 = Employee('Zheng Roebrt', 'Jia', 5201314)
empy_2 = Employee('Katherine', 'Kang', 5201314)
print(empy_1.fullname())
print(empy_1.email)
print(empy_2.email)
