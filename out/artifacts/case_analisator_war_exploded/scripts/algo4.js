function send() {

    var text=document.getElementById("text");
    var st=text.value;

    var request = new XMLHttpRequest();
    request.open('POST',"http://localhost:8008/algo4", true);
    request.setRequestHeader('Content-Type', 'text/plain; charset=UTF-8');
    request.onreadystatechange = function (ev) {
        if (this.readyState === 4) {
            if (this.status >= 200 && this.status < 400) {
                var resp=document.getElementById("resp");

                var resp2 = this.responseText;
                resp.innerHTML=resp2;
            } else {
                // Error :(
            }
        }
    }
    request.send(st);
}
function response() {
    if (this.readyState === 4) {
        if (this.status >= 200 && this.status < 400) {
            var resp=document.getElementById("resp");

            var resp2 = this.responseText;
            resp.innerHTML=resp2;
        } else {
            // Error :(
        }
    }
}