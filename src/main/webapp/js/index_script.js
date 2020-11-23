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
    // console.log(r + " r");
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

function getPoints() {
    let points = [];
    let pointsNodes = document.getElementById("table-result_data").childNodes;
    for (let i = 0; i < pointsNodes.length; i++) {
        let values = pointsNodes[i].childNodes;
        if (values.length !== 4) {
            continue;
        }
        points.push({
            x: values[0].innerText,
            y: values[1].innerText,
            r: values[2].innerText,
            hit: values[3].innerText
        });
    }
    return points;
}


function drawPoints() {
    console.log("drawing");
    let value = $('.checked').attr("title");
    let points = getPoints();
    let group = document.getElementById("point-storage");
    let pointsResult = "";
    for (let i = 0; i < points.length; i++) {
        if (Number(points[i].r) === Number(value)) {
            pointsResult = pointsResult + getDescriptionPoint(Number(points[i].x), Number(points[i].y), Number(points[i].r), points[i].hit);
        }
    }
    group.innerHTML = pointsResult;
}

function getDescriptionPoint(x, y, r, hit) {
    x = Number(x);
    y = Number(y);
    r = Number(r);
    x = 150.0 + x * 100.0 / r;
    y = 150.0 - y * 100.0 / r;
    let pointType;
    if (hit === "true") {
        pointType = "hit";
    } else {
        pointType = "not-hit";
    }
    return '<circle class="' + pointType +'" r="3" cx="' + x + '" cy="' + y + '"></circle>';
}
