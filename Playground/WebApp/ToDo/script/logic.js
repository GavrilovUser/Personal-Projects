const markTemplate = document.querySelector(".mark_template");
const marksList = document.querySelector(".marks_list");
const nullMarksText = document.getElementById("null_marks");
const newMarkButton = document.querySelector(".new_mark_manage button");
const inputText = document.querySelector(".new_mark_manage input");

const marks = [];
let ids = 1;

function updateList() {
  if (marks.length > 0) {
    nullMarksText.hidden = true;
  } else {
    nullMarksText.hidden = false;
  }
}

function newMark() {
  const mark = markTemplate.content.cloneNode(true);
  let markContent;

  mark.querySelector(".id").textContent = `№${ids}`;
  ids++;
  
  if (inputText && typeof inputText.value === 'string' && inputText.value.trim() !== '') {
    markContent = inputText.value;
  } else {
    markContent = mark.querySelector(".content").textContent;
  }
  
  mark.querySelector(".content").textContent = markContent;
  
  marksList.appendChild(mark);

  marks.push(mark);

  inputText.value = '';
  updateList();

  addMark(markContent);
  
  window.scrollTo({
    top: document.body.scrollHeight,
    behavior: 'smooth'
  })
}

function deleteMark(object) {
  object.remove();
  marks.splice(marks.indexOf(object));
  
  updateList();
}

newMarkButton.addEventListener("click", newMark);