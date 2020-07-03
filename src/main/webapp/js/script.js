var socket = io.connect('http://localhost:9032');
var sendButton = document.getElementById("sendButton");
var message = document.getElementById("message");
var logoutButton = document.getElementById("logoutButton");
var listChat = document.getElementById("listChat");
var name = document.getElementById("name");
var typingPopup = document.getElementById("typingPopup");
sendButton.addEventListener("click", function() {
    socket.emit("messageClient", message.value);
});

socket.on("messageServer", function(data) {
    var listString = data.reduce(function(x, y) {
        return x + "<p>" + y["fullname"] + "</p>";
    }, "");
    listChat.innerHTML = listString;
});
socket.on("messageRegister", function(data) {
    console.log(data);
});
message.addEventListener("keyup",function(){
    if (message.value){
        socket.emit("clientTyping",true);
    }else{
        socket.emit("clientTyping",false);
    }
});
socket.on("serverTyping",function(data){
    typingPopup.style.display = data;
});