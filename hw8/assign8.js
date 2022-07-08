const btn = document.getElementById('btn');

btn.addEventListener('click', tellStory);

function tellStory() {
    document.getElementById('story-container').style.display = "block";
    var name = document.getElementById('mad-name').value;
    var object = document.getElementById('mad-object').value;
    var adverb = document.getElementById('mad-adverb').value;
    var adjective = document.getElementById('mad-adjective').value;

    Array.from(document.getElementsByClassName('name')).forEach(
        function(element) {
            element.textContent = name;
        }
    );
    Array.from(document.getElementsByClassName('obj')).forEach(
        function(element) {
            element.textContent = object;
        }
    );
    Array.from(document.getElementsByClassName('adv')).forEach(
        function(element) {
            element.textContent = adverb;
        }
    );
    Array.from(document.getElementsByClassName('adj')).forEach(
        function(element) {
            element.textContent = adjective;
        }
    );
}