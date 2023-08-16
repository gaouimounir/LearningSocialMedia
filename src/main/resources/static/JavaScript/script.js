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

const btnsComment = document.querySelectorAll(".btnComment");
btnsComment.forEach((btnComment) => {
  const textComment =
    btnComment.parentElement.parentElement.querySelector(".commentAreaCacher");
  const btnCommenter =
    btnComment.parentElement.parentElement.querySelector(".commenter");
  let isCommentVisible = false;

  btnComment.addEventListener("click", function () {
    console.log(btnComment);
    if (isCommentVisible) {
      textComment.style.display = "none";
      btnCommenter.style.display = "none";
    } else {
      textComment.style.display = "flex";
      btnCommenter.style.display = "flex";
    }
    isCommentVisible = !isCommentVisible;
  });

  btnCommenter.addEventListener("click", function () {
    console.log(btnCommenter);
    btnCommenter.style.display = "none";
    textComment.style.display = "none";

    const postId = btnCommenter.dataset.idcomment;
    const commentText = textComment.value;

    fetch("/commentaire", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        commentId: postId,
        textComment: commentText,
      }),
    }).then((response) => response.json());
  });
});