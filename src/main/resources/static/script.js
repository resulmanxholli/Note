const textarea = document.getElementById("note");
const noteIdInput = document.getElementById("noteId");
const status = document.getElementById("status");

let timeout = null;

textarea.addEventListener("input", () => {
    status.innerText = "Saving...";
    clearTimeout(timeout);

    timeout = setTimeout(saveNote, 600);
});

function saveNote() {
    // merr id dhe note aktuale
    const noteData = {
        id: noteIdInput.value || null,
        note: textarea.value
    };

    fetch("/note/autosave", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(noteData)
    })
        .then(() => status.innerText = "Saved ✔")
        .catch(() => status.innerText = "Error saving ❌");
}
