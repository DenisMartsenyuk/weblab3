// $(document).ready(function() {
//     updateCheckBox($("#lastR").val());
//     drawPoints();
// });

function selectCheckBox(checkBox) {
    $('.checked').prop("checked", false);
    $('.checked').removeClass("checked");
    $('.checked').addClass("unchecked");
    checkBox.classList.remove("unchecked");
    checkBox.classList.add("checked");
    $(checkBox).prop("checked", true);
    drawPoints();
}


function clickSvg(evt) {
    let element = evt.target;
    let position = element.getBoundingClientRect();
    let srcX = evt.clientX - position.left;
    let srcY = evt.clientY - position.top;
    let x = (srcX - 150) / 100.0;
    let y = (150 - srcY) / 100.0;
    buildClickRequest(x, y);
}

function buildClickRequest(x, y) {
    let r = $('.checked').attr("title");
    console.log(r + " r");
    x = Number(x);
    y = Number(y);
    x = x * r;
    y = y * r;
    console.log("x: " + x);
    console.log("y: " + y);
    console.log("r: " + r);
    // $("#x-field").val(x);
    // $("#y-field").val(y);
    // $("#request").submit();
}

// function updateCheckBox(value) {
//     console.log(value);
//     $('input[name="r"]').each(function (index, elem) {
//         if ($(elem).val() == value){
//             selectCheckBox($(elem));
//         }
//     });
// }
//
function drawPoints() {
    console.log("drawing");
    let value = $('.checked').attr("title");
    let table = document.querySelector('#table-result');
    let group = document.getElementById("point-storage");
    let points = "";
    for (let i = 1; i < table.rows.length; i++) {
        if (Number(table.rows[i].cells[2].textContent) === Number(value)) { //table.rows[i].cells[3].textContent === "true" &&
            points = points + getDescriptionPoint(Number(table.rows[i].cells[0].textContent), Number(table.rows[i].cells[1].textContent), Number(table.rows[i].cells[2].textContent));
            console.log("point");
        }
    }
    group.innerHTML = points;
    //todo отрисовка непопавших
}

function getDescriptionPoint(x, y, r) {
    x = Number(x);
    y = Number(y);
    r = Number(r);
    x = 150.0 + x * 100.0 / r;
    y = 150.0 - y * 100.0 / r;
    return '<circle fill="#32D4E2" class="points" r="3" cx="' + x + '" cy="' + y + '"></circle>';
}
//
// function setDesignInput(input, color, border) {
//     $(input).css("border", border);
//     $(input).css("background", color);
// }
//
// function buildRequest() {
//     if (validation($("#x-field")) && validation($("#y-field"))) {
//         $("#request").submit();
//     }
// }
//
