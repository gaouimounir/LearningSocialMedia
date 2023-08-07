let myComment = document.querySelector("textarea");
let myCommentButton = document.querySelector(".btnComment");

myCommentButton.addEventListener("click", function () {
  if ("commentAreaCacher" == myComment.getAttribute("class")) {
    myComment.setAttribute("class", "commentAreaVisible");
  } else {
    myComment.setAttribute("class", "commentAreaCacher");
  }
});