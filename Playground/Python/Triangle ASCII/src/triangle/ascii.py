from math import floor

class Triangle:
  """Make Triangle"""
  
  def __init__(self, size: int = 5, symbol: str = "#"):
    if size < 1:
      raise ValueError("Incorrect size")

    if not symbol.strip() or len(symbol) > 1:
      raise ValueError("Incorrect Symbol")
    
    self.size = size
    self.symbol = symbol

    self.ascii_strokes = []
    self.ascii = ""
    
    void_symbol = " "

    for height_index in range(self.size):
      self.ascii_strokes.append(f"{void_symbol * floor(height_index / 2)}{self.symbol * (self.size - height_index)}\n")

    self.ascii_strokes.reverse()
    self.ascii = "".join(self.ascii_strokes)

  def __str__(self):
    return self.ascii