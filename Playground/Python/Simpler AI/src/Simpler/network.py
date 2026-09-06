from random import random

class Simpler:
  def __init__(self, learning_rate = 0.0001):
    self.learning_rate = learning_rate
    
    self.weight = random()
    self.bias = random()

  def predict(self, start):
    return start * self.weight + self.bias

  def train(self, start, y_true):
    y_pred = start * self.weight + self.bias

    error = y_true - y_pred

    grad_weight = -2 * start * error
    grad_bias = -2 * error

    self.weight -= self.learning_rate * grad_weight
    self.bias -= self.learning_rate * grad_bias

    return error