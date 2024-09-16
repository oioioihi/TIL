#단일 책임 원칙

def add(num1, num2):
    return num1+num2

def numPrint(num):
    print(num)


# 굳이 메서드 갯수를 줄이고자 이렇게 기능을 합쳐버릴 필요는 없다.
def addPrint(num1,num2):
    num = num1+num2
    print(num)
    return num


# 고양이라는 클래스
class Cat:
    def __init__(self,age,name):
        self.age = age
        self.name = name
    
    def eat(self,food):
        pass
    
    def walk(self):
        pass
    
    def speak(self):
        pass

# 고양이가 먹고, 걷고, 말하는 것은 고양이의 속성이지만, print와 log하는 기능은 고양이와 관련이 없다.
# print와 log 함수는 없애주는 대신, 다른 방법으로 기능이 돌아가독록 해야한다.

#Before
    def print(self):
        print(f"age:{self.age} name:{self.name}")
    
    def log(self,logger):
        logger.log(f"age:{self.age} name:{self.name}")
        logger.log(datetime.now())

    
#After -> 고양이의 상태를 나타내주는 represnet 함수를 구현
    def represnet(self):
        return  print(f"age:{self.age} name:{self.name}")


# 고양이 클래스를 가져다 사용하는 클라이언트 예시
kitty = Cat()
print(kitty.represnet())
logger.log(kitty.represnet())