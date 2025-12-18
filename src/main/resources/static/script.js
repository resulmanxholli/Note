
    const textarea = document.getElementById("note");
    const status = document.getElementById("status");

    let timeout = null;

    textarea.addEventListener("input", () => {
    status.innerText = "Saving...";
    clearTimeout(timeout);

    timeout = setTimeout(saveNote, 600);
});

    function saveNote() {
    fetch("/note/autosave", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            note: textarea.value
        })
    })
        .then(() => status.innerText = "Saved ✔")
        .catch(() => status.innerText = "Error saving ❌");
}

