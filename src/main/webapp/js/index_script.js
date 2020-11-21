$(document).ready(function() {
    fillCheckBox();
    drawPoints();
});

function fillCheckBox() {
    $(".r-checkbox").each(function() {
        if ($(this).attr("checked") === "checked") {
            $(this).addClass("checked");
        } else {
            $(this).addClass("unchecked");
        }
    });
}

function selectCheckBox(checkBox) {
    $('.checked').prop("checked", false);
    $('.checked').removeClass("checked").addClass("unchecked");
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
    document.getElementById('check-form-invisible:x-value-click').value = x;
    document.getElementById('check-form-invisible:y-value-click').value = y;
    $("#check-form-invisible\\:button-invisible").click();
}

function updateSvg(data) {
    //sleep(100);
    drawPoints();
    //todo как решить ajaxom...
}


function drawPoints() {
    console.log("drawing");
    let value = $('.checked').attr("title");
    let table = document.querySelector('#table-result');
    let group = document.getElementById("point-storage");
    let points = "";
    for (let i = 1; i < table.rows.length; i++) {
        if (Number(table.rows[i].cells[2].textContent) === Number(value)) { //table.rows[i].cells[3].textContent === "true" &&
            points = points + getDescriptionPoint(Number(table.rows[i].cells[0].textContent), Number(table.rows[i].cells[1].textContent), Number(table.rows[i].cells[2].textContent), table.rows[i].cells[3].textContent);

        }
    }
    group.innerHTML = points;
}

function getDescriptionPoint(x, y, r, hit) {
    x = Number(x);
    y = Number(y);
    r = Number(r);
    x = 150.0 + x * 100.0 / r;
    y = 150.0 - y * 100.0 / r;
    hit = hit.replace(/\s+/g, "");
    let pointType;
    if (hit === "true") {
        pointType = "hit";
    } else {
        pointType = "not-hit";
    }
    return '<circle class="' + pointType +'" r="3" cx="' + x + '" cy="' + y + '"></circle>';
}
