from Simpler.network import Simpler
from random import randint

def main():
  """Configure & run simpler"""
  
  simpler = Simpler()

  train_data = [
    (x, x*2) for x in range(50)
  ]
  test_data = [
    (x, x*2) for x in range(50, 71)
  ]

  EPOCHS = 5000

  for epoch in range(EPOCHS):
    for x, y in train_data:
      simpler.train(x, y)

  print(f"TEST ({EPOCHS} Epochs)")
  for start, end in test_data:
    print(f"Answer: {simpler.predict(start):.2f} | Right: {end}")
  print("="*50)
  
  while True:
    try:
      num = int(input(f"\nEnter a Number: "))
      print(f"Answer: {num} -> {simpler.predict(num):.2f}")
      print("="*50)
    except ValueError:
      print("Enter a Number")

if __name__ == "__main__":
  main()