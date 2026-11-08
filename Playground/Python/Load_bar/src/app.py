import time
import os
from load_bar.bar import Bar

def clear():
  os.system("cls" if os.name == "nt" else "clear")

#Пример использования
def loop_bar():
  max_value = 100
  current_value = 0

  while True:
    clear()
    
    awesome_bar = Bar(max_value, current_value)
    print(awesome_bar)

    current_value += 2
    if current_value >= max_value:
      current_value = 0
    
    time.sleep(.2)

def main():
  loop_bar()

if __name__ == "__main__":
  main()