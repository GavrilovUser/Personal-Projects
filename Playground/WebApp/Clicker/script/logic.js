const counter = document.querySelector(".balance");
const buttonClick = document.querySelector(".btn");
const buttonUpgrade = document.querySelector(".upgrade");

let count = 0;
let multiplier = 1;

function updateCounter() {
  counter.textContent = `₽ ${count}`;
}

function increment() {
  count += multiplier;
  updateCounter();
}

function upgrade() {
  if (count >= 50) {
    multiplier++;
    count -= 50;
  }
  updateCounter();
}

buttonClick.addEventListener("click", increment);
buttonUpgrade.addEventListener("click", upgrade);