function numberList() {
$.ajax({
url: 'http://localhost:8080/api/numbers',
type: 'GET',
dataType: 'json',
success: function (numbers) {
numbersListSuccess(numbers);
},
error: function (request, message, error) {
handleException(request, message, error);
}
});
}

function numbersListSuccess(numbers) {
$("#numberTable tbody").remove();
$.each(numbers, function (index, number) {
numberAddRow(number);
});
}

function numberAddRow(number) {
if ($("#numberTable tbody").length == 0) {
$("#numberTable").append("<tbody></tbody>");
}
$("#numberTable tbody").append(numberBuildTableRow(number));
}

function numberBuildTableRow(number) {
return "<tr>" +
"<td>" + number.result + "</td>" +
"<td>" + number.cows + "</td>" +
"<td>" + number.bulls + "</td>" +
"</tr>";
}

function handleException(request, message, error) {
let msg = "";
msg += "Code: " + request.status + "\n";
msg += "Text: " + request.statusText + "\n";
if (request.responseJSON != null && request.responseJSON.Message) {
msg += "Message: " + request.responseJSON.Message + "\n";
}
alert(msg);
}

function formClear() {
$("#number").val("");
}


function Start() {
console.log("start clicked");
  $.ajax({
    url: "http://localhost:8080/api/start",
    type: 'POST',
    success: function () {
       $("#numberTable tbody").remove();
       formClear();
    },
    error: function (request, message, error) {
      handleException(request, message, error);
    }
  });
}

function updateClick() {
console.log("updateClick clicked");
const input = $("#number").val().trim();
if (input.length !== 4 || !/^\d{4}$/.test(input)) {
alert("Введите ровно 4 цифры");
return;
}
const numberData = {
first: parseInt(input[0]),
second: parseInt(input[1]),
third: parseInt(input[2]),
forth: parseInt(input[3])
};
numberAdd(numberData);
}

function numberAdd(numberData) {
$.ajax({
url: "http://localhost:8080/api/play",
type: 'POST',
contentType: "application/json",
data: JSON.stringify(numberData),
success: function (number) {
numberAddSuccess(number);
},
error: function (request, message, error) {
handleException(request, message, error);
}
});
}

function numberAddSuccess(number) {
numberAddRow(number);
formClear();
}

$(document).ready(function () {
numberList();
});
