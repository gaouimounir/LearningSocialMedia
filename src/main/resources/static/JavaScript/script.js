document.querySelectorAll(".btnLike").forEach((btnLike) => {
  btnLike.addEventListener("click", function () {
    console.log(btnLike.dataset.idpost);
    fetch("/like", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ postId: btnLike.dataset.idpost }),
    })
      .then((response) => response.json())
      .then((data) => {});
  });
});

document.querySelectorAll(".fa-heart").forEach((heartChange) => {
  heartChange.addEventListener("click", function () {
    heartChange.classList.remove("fa-regular");
    heartChange.classList.add("fa-solid");
  });
});



/*------------------*/

let myComment = document.querySelector("textarea");
let myCommentButton = document.querySelector(".btnComment");

myCommentButton.addEventListener("click", function () {
  if ("commentAreaCacher" == myComment.getAttribute("class")) {
    myComment.setAttribute("class", "commentAreaVisible");
  } else {
    myComment.setAttribute("class", "commentAreaCacher");
  }
});