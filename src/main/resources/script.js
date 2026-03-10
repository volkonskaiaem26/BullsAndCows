function numberList() {
   $.ajax({
      url: 'http://localhost:8080/api/numbers',
      type: 'GET',
      dataType: 'json',
      success: function (numbers) {
         numberListSuccess(numbers);
      },
      error: function (request, message, error) {
         handleException(request, message, error);
      }
   });
}

function numbersListSuccess(numbers) {
   $.each(numbers, function (index, number) {
      numberAddRow(number);
   });
}

function numberAddRow(number) {
   if ($("#numberTable tbody").length == 0) {
      $("#numberTable").append("<tbody></tbody>");
   }
   $("#numberTable tbody").append(

      numberBuildTableRow(number));
}

function numberBuildTableRow(user) {
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
   if (request.responseJSON != null) {
      msg += "Message" + request.responseJSON.Message + "\n";
   }
   alert(msg);
}

function formClear() {
   $("#number").val("");
}

function Start() {
   $.ajax({
      url: "http://localhost:8080/api/start",
      type: 'POST',
      success: function () {
         numberDeleteSuccess();
      },
      error: function (request, message, error) {
         handleException(request, message, error);
      }
   });
}

function updateClick() {
   const Number = {};
   Number.number = $("#number").val();
   numberAdd(Number);
}

function numberAdd(user) {
   $.ajax({
      url: "http://localhost:8080/api/play",
      type: 'POST',
      contentType: "application/json;charset=utf-8",
      data: JSON.stringify(number),
      success: function (number) {
         numberAddSuccess(number);
      },
      error: function (request, message, error) {
         handleException(request, message, error);
      }
   });
}


function numberDeleteSuccess() {
   $("#userTable tbody").remove();
}

function numberAddSuccess(number) {
   numberAddRow(number);
   formClear();
}