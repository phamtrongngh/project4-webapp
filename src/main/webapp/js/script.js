var socket = io.connect('http://localhost:9032');
var sendButton = document.getElementById("sendButton");
var message = document.getElementById("message");
sendButton.addEventListener("click", function() {
    socket.emit("messageClient", message.value);
});
socket.on("messageServer",function(data){
    console.log(data);
});