// the server all API

var CSA = {};

CSA.callServer = function(callbackFunction) {
    const httpRequest = new XMLHttpRequest();
    httpRequest.open("GET", "http://localhost:8080/isServerAvailable", true);
    httpRequest.onreadystatechange = () => {
        if (httpRequest.readyState === XMLHttpRequest.DONE) {
            const status = httpRequest.status;
            if (status === 200) {
                callbackFunction(true);
            } else {
                callbackFunction(false);
            }
        }
    };
    httpRequest.timeout = 3000;
    httpRequest.send();
}