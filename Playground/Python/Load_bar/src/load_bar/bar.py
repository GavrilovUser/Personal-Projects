class Bar:
  WIDTH = 20
  
  def __init__(self, size: int, current: int):
    self.size = size
    self.current = current
    self.fill = "#"
    self.void = "_"

  def __str__(self) -> str:
    ratio = 0 if self.size == 0 else min(self.current / self.size, 1.0)
    filled = int(self.WIDTH * ratio)
    empty = self.WIDTH - filled
    percent = int(100 * ratio)

    return f"[{self.fill * filled}{self.void * empty}] – {percent}/100%"