f = open("a_example.txt","r")
x = [line.split() for line in f.readlines()]
numBooks = x[0][0]
numLib = x[0][1]
numDays = x[0][2]

bookScores = x[1][:]
def assignLib():
    info = []
    for i in range(1,int(numLib)+1):
        info += [x[2*i][0], x[2*i][1], x[2*i][2]]
    return info

def assignBooks():
    book = []
    for i in range(1,int(numLib)+1):
        book += [x[2*i+1]]
    return book

class Lib():
    def __init__(self):
        self.numBook = int(assignLib()[0])
        self.signUpdays = int(assignLib()[1])
        self.shipPerday = int(assignLib()[2])
    

class Books():
    def __init__(self):
        self.books = assignBooks()

Book1 = Books()
Lib1 = Lib()