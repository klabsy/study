/**
 * Created by youhua zhang  on 2022/4/25
 * 此程序仅供大家学习之用，不宜用作其他目的，不要发布至互联网
 * 每个函数、算法都是根据自己的理解编写，不保证完全正确，有错误的地方请予反馈
 * 有些函数和变量来自dom.min.js（第三方js包），如windowWidth,mousePressed,mouseMoved,createCanvas等等
 */


var LeftW = 120,
    TitleH = 80;
var workW = 1300,
    workH = 620;
var defaultcvs, divWork, oX, oY, nX, nY;
var divAxisX, divAxisY;
var divLeft, divTitle, divFootHint;

var zyurl = "./";
var pt = [];

var startx = 0,
    starty = 0; //记录mousePress位置


function main() {
    dispUI();
}

function dispUI() {
    var deltaH = 40,
        h0 = 20;
    divBack = createCommonDiv(null, "divBack", windowWidth, windowHeight, 0, 0, "url(" + zyurl + "cool-background.png)");
    divTitle = createCommonDiv(divBack, "divTitle", windowWidth, TitleH, 0, 0, "url(" + zyurl + "timg.gif)");

    divLabel = createCommonDiv(divTitle, "divLabel", windowWidth, 100, 0, 0, "#0000a000");
    var styl = {
        font: "微软雅黑",
        fontsize: "38px",
        fontcolor: "#ffffff",
        fontbold: "700",
    };
    lblTitle = createLabel(divLabel, "lblTitle", styl, 150, -25, "计算机图形学实验ZYH@安徽省北斗精准农业信息工程实验室(2022)");
    var btnlen = 100;
    divLeft = createCommonDiv(divBack, "divLeft", LeftW, divBack.height - divTitle.height, 0, TitleH, "#393D49");
    var styl1 = {
        fontsize: "14px",
        bkcolor: "#f0fff0"
    };
    var btn0 = createBtn(divLeft, "btn0", styl1, btnlen, 25, 10, h0, "新画布");
    btn0.mousePressed(prepareCanvas);

    var btn1 = createBtn(divLeft, "btn1", styl1, btnlen, 25, 10, h0 + 30, "生成点");
    btn1.mousePressed(drawptproc);

    var btn2 = createBtn(divLeft, "btn2", styl1, btnlen, 25, 10, h0 + 60, "DDA划线");
    btn2.mousePressed(ddaproc);

    var btn3 = createBtn(divLeft, "btn3", styl1, btnlen, 25, 10, h0 + 90, "中点划线");
    btn3.mousePressed(MidLineproc);


    var btn4 = createBtn(divLeft, "btn4", styl1, btnlen, 25, 10, h0 + 120, "Brh划线");
    btn4.mousePressed(BresenhamLineproc);

    var btn5 = createBtn(divLeft, "btn5", styl1, btnlen, 25, 10, h0 + 150, "中点画圆");
    btn5.mousePressed(MidCircleproc);

    var btn6 = createBtn(divLeft, "btn6", styl1, btnlen, 25, 10, h0 + 180, "连接多边形");
    btn6.mousePressed(drawPolyproc);

    var btn7 = createBtn(divLeft, "btn7", styl1, btnlen, 25, 10, h0 + 210, "扫描填充");
    btn7.mousePressed(scanPolyFillproc);
}

function prepareCanvas() {
    var bkcolor = "#000020d0";
    var posx, posy;
    if (divWork) {
        divWork.remove();
    }
    posx = (windowWidth - LeftW - workW) / 2;
    posy = (windowHeight - TitleH - workH) / 2;
    divWork = createCommonDiv(divBack, "divWork", workW, workH, LeftW + posx, TitleH + posy, "#00000000"); //居中
    divWork.mouseMoved(mousemoveproc);


    oX = int(divWork.width / 2);
    oY = int(divWork.height / 2);
    // console.log(oX)
//左上角rgb
    divHint = createCommonDiv(divWork, "divHint", 80, 20, divWork.width - 80, 0, "#ff00f000");
    divHint.style('color', "#ffffff");
    divHint.style('font-size', '16px');
//右上角坐标
    divRgbHint = createCommonDiv(divWork, "divRgbHint", 150, 20, 0, 0, "#ff00f000");
    divRgbHint.style('color', "#ffffff");
    divRgbHint.style('font-size', '16px');

    noCanvas();
    defaultcvs = createCanvas(workW, workH);
    background(bkcolor);
    defaultcvs.parent(divWork);
    drawAxis(divWork, oX, oY, "#00ffff80");
    pt.length = 0; //初始化pt[]

    //自动启用画点
    drawptproc()
}

function drawptproc() {
    divWork.mouseClicked(divWorkClick);
}


function mousemoveproc() {
    dispHint();
}



function dispHint() {
    var x = mouseX;
    var y = mouseY;
    x = x - oX;
    y = oY - y;
    divHint.html("" + int(x) + "," + int(y));
    var clr;
    clr = xoyGetPixel(x, y);
    var str = "rgb:[" + clr[0] + "," + clr[1] + "," + clr[2] + "]";
    divRgbHint.html(str);
}
//画多边形



function scanPolyFillproc() {
    var _0x37fd7c, _0x41a3a6;
    var _0x1d2a34 = calcRect(pt);
    var _0x5846c7 = [];
    _0x37fd7c = _0x1d2a34[0x1];
    _0x41a3a6 = _0x1d2a34[0x3];
    var _0x3265ee = pt['length'];
    for (var _0x557c7a = 0x0; _0x557c7a < _0x3265ee - 0x1; _0x557c7a++) {
        _0x5846c7['push']([pt[_0x557c7a][0x0], pt[_0x557c7a][0x1], pt[_0x557c7a + 0x1][0x0], pt[_0x557c7a + 0x1][0x1]]);
    }
    _0x5846c7.push([pt[_0x3265ee - 0x1][0x0], pt[_0x3265ee - 0x1][0x1], pt[0x0][0x0], pt[0x0][0x1]]);
    var _0x1a21dd = [], _0x21ad50;
    lncnt = _0x5846c7.length;
    for (var _0x29f1e8 = _0x37fd7c; _0x29f1e8 < _0x41a3a6; _0x29f1e8++) {
        for (var _0x557c7a = 0x0; _0x557c7a < lncnt; _0x557c7a++) {
            if (judgeCross(_0x5846c7[_0x557c7a], _0x29f1e8)) {
                _0x21ad50 = getXRoot(_0x5846c7[_0x557c7a], _0x29f1e8);
                // console.log(_0x51c1('0x1c'),_0x51c1('0x41'))
                _0x1a21dd.push(Math.round(_0x21ad50));
            }
        }
        _0x1a21dd['sort'](function (_0x2686ea, _0x301161) {
            return _0x2686ea - _0x301161;
        });
        if (_0x1a21dd.length >= 0x3 && _0x1a21dd['length'] % 0x2 == 0x1) {
            _0x1a21dd = distinct(_0x1a21dd);
        }
        var _0x192aa4 = int(_0x1a21dd.length / 0x2);
        for (var _0x557c7a = 0x0; _0x557c7a < _0x192aa4; _0x557c7a++) {
            BresenhamLine(_0x1a21dd[_0x557c7a * _0x192aa4], _0x29f1e8, _0x1a21dd[_0x557c7a * _0x192aa4 + 0x1], _0x29f1e8, '#80000080');
        }
        _0x1a21dd.length = 0x0;
    }
    console.log("success")
}

function distinct(_0x5b9bf8) {
    return Array.from(new Set(_0x5b9bf8));
}



function calcRect(_0x11970d) {
    cnt = _0x11970d['length'];
    xmin = 0x2710, xmax = -0x2710, ymin = 0x2710, ymax = -0x2710;
    for (i = 0x0; i < cnt; i++) {
        x = _0x11970d[i][0x0];
        y = _0x11970d[i][0x1];
        if (x < xmin) {
            xmin = x;
        }
        if (y < ymin) {
            ymin = y;
        }
        if (x >= xmax) {
            xmax = x;
        }
        if (y >= ymax) {
            ymax = y;
        }
    }
    return [xmin, ymin, xmax, ymax];
}

function drawRect(_0x41568c, _0x4afea2, _0x37990b, _0x46120f, _0x38301b) {
    var _0x17b6f3 = [[_0x41568c, _0x4afea2], [_0x41568c, _0x46120f], [_0x37990b, _0x46120f], [_0x37990b, _0x4afea2]];
    drawPoly(_0x17b6f3, _0x38301b);
}

function getXRoot(_0x55bdd4, _0x210a91) {
    x0 = _0x55bdd4[0x0], y0 = _0x55bdd4[0x1];
    x1 = _0x55bdd4[0x2], y1 = _0x55bdd4[0x3];
    if (x1 == x0) {
        return x0;
    }
    k = (y1 - y0) / (x1 - x0);
    b = y0 - k * x0;
    x = (_0x210a91 - b) / k;
    return x;
}

function judgeCross(_0x47507f, _0x54c754) {
    p0y = _0x47507f[0x1];
    p1y = _0x47507f[0x3];
    if ((p0y - _0x54c754) * (p1y - _0x54c754) <= 0x0) {
        return !![];
    }
    return ![];
}










function drawPoly(ptlist, _0xb28ada, _0x4a62fe) {
    // console.log(ptlist[])
    pcnt = ptlist['length'];
    console.log(ptlist)
    p0 = ptlist[0];
    for (var i = 0; i < pcnt; i++) {
        p1 = ptlist[i];
        BresenhamLine(p0[0], p0[1], p1[0], p1[1], _0xb28ada, _0x4a62fe);
        p0 = p1;
    }
    p1 = ptlist[0];
    BresenhamLine(p0[0], p0[1], p1[0], p1[1], _0xb28ada, _0x4a62fe);

    console.log(_0xb28ada)
    console.log(_0x4a62fe)
}

function drawPolyproc() {
    var cnt;
    cnt = pt.length;
    if (cnt < 0x3) {
        divHint['html']('<3个点');
        return;
    }
    divHint.html("共" + cnt + "个点");
    var ptlist = [];
    for (var i = 0; i < pt.length; i++) {
        // ptlist['push']([pt[i][0], pt[i][0]]);
        ptlist.push([pt[i].x, pt[i].y]);
    }
    console.log(ptlist)
    drawPoly(ptlist, "#ff0000",4);

}


function xoyDrawArrowLine(p0, p1, color) {
    p0.x = p0.x + oX;
    p0.y = oY - p0.y;
    p1.x = p1.x + oX;
    p1.y = oY - p1.y;
    drawArrowLine(p0, p1, color);
}

function Bresenhamproc() {
    var cnt;
    var rndcolor;
    cnt = pt.length;
    if (cnt < 2) {
        divHint.html("<2个点");
        return;
    }
    divHint.html("共" + cnt + "个点");
    for (var i = 0; i < cnt - 1; i++) {
        rndcolor = rndColor();
        BresenhamLine(pt[i].x, pt[i].y, pt[i + 1].x, pt[i + 1].y, rndcolor);
    }
}

function ddaproc() {

    var cnt;
    var rndcolor;
    cnt = pt.length;
    console.log(cnt)
    // if (cnt < 2) {
    //     divHint.html("<2个点");
    //     return;
    // }
    // divHint.html("共" + cnt + "个点");
    for (var i = 0; i < cnt - 1; i++) {
        color = "#ff0000";//rndColor();
        DDALine(pt[i].x, pt[i].y, pt[i + 1].x, pt[i + 1].y, color, 2);
    }
}

function MidLineproc() {

    var cnt;
    var rndcolor;
    cnt = pt.length;
    if (cnt < 2) {
        divHint.html("<2个点");
        return;
    }
    divHint.html("共" + cnt + "个点");
    for (var i = 0; i < cnt - 1; i++) {
        color = "#ff0000";//rndColor();
        MidLine(pt[i].x, pt[i].y, pt[i + 1].x, pt[i + 1].y, color, 1);
    }
}

function BresenhamLineproc() {

    var cnt;
    var rndcolor;
    cnt = pt.length;
    if (cnt < 2) {
        divHint.html("<2个点");
        return;
    }
    divHint.html("共" + cnt + "个点");
    for (var i = 0; i < cnt - 1; i++) {
        color = "#ff0000";//rndColor();
        BresenhamLine(pt[i].x, pt[i].y, pt[i + 1].x, pt[i + 1].y, color, 6);
    }
}

function MidCircleproc() {
    var cnt;
    var rndcolor;
    cnt = pt.length;
    if (cnt < 2) {
        divHint.html("<2个点");
        return;
    }
    divHint.html("共" + cnt + "个点");
    for (var i = 0; i < cnt - 1; i++) {
        color = "#ff0000";//rndColor();
        r = Math.sqrt((pt[i].x - pt[i + 1].x) * (pt[i].x - pt[i + 1].x) + (pt[i].y - pt[i + 1].y) * (pt[i].y - pt[i + 1].y));
        r = int(r);
        MidCircle(pt[i].x, pt[i].y, r, color, 1);
    }
}

function Duobianxingproc() {
    var cnt;
    var rndcolor;
    cnt = pt.length;
    if (cnt < 2) {
        divHint.html("<2个点");
        return;
    }
    divHint.html("共" + cnt + "个点");
    // for (var i = 0; i < cnt - 1; i++) {
    color = "#ff0000";//rndColor();
    console.log(pt)
    polyfilldata(polyfill(pt),color, 1);

    // }
}


function divWorkClick() {
    var obj = {
        x: int(mouseX - oX),
        y: int(oY - mouseY)
    };
    pt.push(obj);
    xoySetPixel(obj.x, obj.y, "#ff0000", 5);
    biaozhu("p" + (pt.length), obj.x + 3, obj.y - 3);
}

function biaozhu(label, x, y) {
    var biaozhu = createCommonDiv(divWork, "biaozhu" + label, 20, 16, x + oX, oY - y, "#ff00f000");
    biaozhu.style('color', "#ffffff");
    biaozhu.style('font-size', '10px');
    biaozhu.html(label);
}


//DDALine算法
function DDALine(x0, y0, x1, y1, color, size) {
    var dx = x1 - x0;
    var dy = y1 - y0;
    var k, x, y, xs, ys, xe, ye, xx, yy;
    if (Math.abs(dx) > Math.abs(dy)) {
        k = dy / dx;
        if (x1 > x0) {
            xs = x0;
            xe = x1;
            y = y0;
            for (x = xs; x <= xe; x++) {
                yy = int(y + 0.5);
                xoySetPixel(x, yy, color, size);
                y = y + k;
            }
        }
        if (x0 > x1) {
            xs = x1;
            xe = x0;
            y = y1;
            for (x = xs; x <= xe; x++) {
                yy = int(y + 0.5);
                xoySetPixel(x, yy, color, size);
                y = y + k;
            }
        }
    }

    if (Math.abs(dy) > Math.abs(dx)) {
        k = dx / dy;
        if (y1 > y0) {
            ys = y0;
            ye = y1;
            x = x0;
            for (y = ys; y <= ye; y++) {
                xx = int(x + 0.5);
                xoySetPixel(xx, y, color, size);
                x = x + k;
            }
        }
        if (y0 > y1) {
            ys = y1;
            ye = y0;
            x = x1;
            for (y = ys; y <= ye; y++) {
                xx = int(x + 0.5);
                xoySetPixel(xx, y, color, size);  //画点
                x = x + k;
            }
        }
    }

}

//MidLine算法
function MidLine(x0, y0, x1, y1, color, size) {
    var dx;
    var dy;
    var tmpx, tmpy;
    if (x0 > x1) { //交换，让第一个点的x比第二个点x始终小，从而最终变换到k>0 && k<=1这种模式
        tmpx = x1;
        tmpy = y1;
        x1 = x0;
        y1 = y0;
        x0 = tmpx;
        y0 = tmpy;
    }

    dx = x1 - x0;
    dy = y1 - y0;
    var flag = dx * dy;
    if (flag < 0) {
        x0 = -x0;
        y0 = y0;
        x1 = -x1;
        y1 = y1;
        if (x0 > x1) { //交换，让第一个点的x比第二个点x始终小，从而最终变换到k>0 && k<=1这种模式
            tmpx = x1;
            tmpy = y1;
            x1 = x0;
            y1 = y0;
            x0 = tmpx;
            y0 = tmpy;
        }
    }
    var pt;
    if ((Math.abs(dx) > Math.abs(dy)) && (x1 > x0)) {
        pt = MidLinek1data(x0, y0, x1, y1);
        if (flag < 0) {
            for (var i = 0; i < pt.length; i++) xoySetPixel(-pt[i][0], pt[i][1], color, size);
        }
        if (flag > 0) {
            for (var i = 0; i < pt.length; i++) xoySetPixel(pt[i][0], pt[i][1], color, size);
        }
    }
    if ((Math.abs(dy) > Math.abs(dx)) && (x1 > x0)) {
        xn0 = y0;
        yn0 = x0;
        xn1 = y1;
        yn1 = x1;
        pt = MidLinek1data(xn0, yn0, xn1, yn1);
        if (flag < 0) {
            for (var i = 0; i < pt.length; i++) xoySetPixel(-pt[i][1], pt[i][0], color, size);
        }
        if (flag > 0) {
            for (var i = 0; i < pt.length; i++) xoySetPixel(pt[i][1], pt[i][0], color, size);
        }

    }
}

function MidLinek1data(x0, y0, x1, y1) {
    var a = y0 - y1;
    var b = x1 - x0;
    var pt = [];
    d = 2 * a + b;
    d1 = 2 * a;
    d2 = 2 * (a + b);
    x = x0;
    y = y0;
    //xoySetPixel(x, y, color);
    pt.push([x, y]);
    while (x < x1) {
        if (d < 0) {
            x++;
            y++;
            d += d2;
        } else {
            x++;
            d += d1;
        }
        //xoySetPixel(x, y, color);
        pt.push([x, y]);
    }
    return pt;
}

function BresenhamLine(x0, y0, x1, y1, color, size) {
    var dx;
    var dy;
    var tmpx, tmpy;
    if (x0 == x1) { //垂直线
        if (y0 > y1)
            for (var i = y1; i < y0; i++) xoySetPixel(x0, i, color, size);
        if (y0 < y1)
            for (var i = y0; i < y1; i++) xoySetPixel(x0, i, color, size);
        return;
    }
    if (y0 == y1) { //水平线
        if (x0 > x1)
            for (var i = x1; i < x0; i++) xoySetPixel(i, y0, color, size);
        if (x0 < x1)
            for (var i = x0; i < x1; i++) xoySetPixel(i, y0, color, size);
        return;
    }

    if (x0 > x1) { //交换，让第一个点的x比第二个点x始终小，从而最终变换到k>0 && k<=1这种模式
        tmpx = x1;
        tmpy = y1;
        x1 = x0;
        y1 = y0;
        x0 = tmpx;
        y0 = tmpy;
    }

    dx = x1 - x0;
    dy = y1 - y0;
    var flag = dx * dy;
    if (flag < 0) {
        x0 = -x0;
        y0 = y0;
        x1 = -x1;
        y1 = y1;
        if (x0 > x1) { //交换，让第一个点的x比第二个点x始终小，从而最终变换到k>0 && k<=1这种模式
            tmpx = x1;
            tmpy = y1;
            x1 = x0;
            y1 = y0;
            x0 = tmpx;
            y0 = tmpy;
        }
    }
    var pt;
    if ((Math.abs(dx) > Math.abs(dy)) && (x1 > x0)) {
        pt = Bresenhamk1data(x0, y0, x1, y1);
        if (flag < 0) {
            for (var i = 0; i < pt.length; i++) xoySetPixel(-pt[i][0], pt[i][1], color, size);
        }
        if (flag > 0) {
            for (var i = 0; i < pt.length; i++) xoySetPixel(pt[i][0], pt[i][1], color, size);
        }
    }
    if ((Math.abs(dy) > Math.abs(dx)) && (x1 > x0)) {
        xn0 = y0;
        yn0 = x0;
        xn1 = y1;
        yn1 = x1;
        pt = Bresenhamk1data(xn0, yn0, xn1, yn1);
        if (flag < 0) {
            for (var i = 0; i < pt.length; i++) xoySetPixel(-pt[i][1], pt[i][0], color, size);
        }
        if (flag > 0) {
            for (var i = 0; i < pt.length; i++) xoySetPixel(pt[i][1], pt[i][0], color, size);
        }
    }
}

function Bresenhamk1data(x0, y0, x1, y1) {
    var dx, dy;
    var pt = [];
    dx = x1 - x0;
    dy = y1 - y0;
    e = -dx;
    x = x0;
    y = y0;
    for (i = 0; i <= dx; i++) {
        //xoySetPixel(x, y, color);
        pt.push([x, y]);
        x++;
        e = e + 2 * dy;
        if (e >= 0) {
            y++;
            e = e - 2 * dx;
        }
    }
    return pt;
}

//画圆算法
function MidCircle(x0, y0, r, color, size) {
    var pt, x, y;
    pt = MidCircledata(r);  //一个八分之一弧线的数组
    console.log(pt)
    for (var i = 0; i < pt.length; i++) {
        x = pt[i][0];
        y = pt[i][1];
        xoySetPixel(x + x0, y + y0, color, size);
        xoySetPixel(y + x0, x + y0, color, size);
        xoySetPixel(-x + x0, y + y0, color, size);
        xoySetPixel(y + x0, -x + y0, color, size);
        xoySetPixel(x + x0, -y + y0, color, size);
        xoySetPixel(-y + x0, x + y0, color, size);
        xoySetPixel(-x + x0, -y + y0, color, size);
        xoySetPixel(-y + x0, -x + y0, color, size);
    }
}

function MidCircledata(r) {
    var pt = [];
    var x = 0;
    var y = r;
    var d = 3 - 2 * r;
    pt.push([x, y]);
    while (x <= y) {
        if (d < 0) {
            d += 2 * x + 3;
        } else {
            d += 2 * (x - y) + 5;
            y--;
        }
        x++;
        pt.push([x, y]);
    }
    return pt;
}

function xoySetPixel(x, y, color, size) {
    setPixel(x + oX, oY - y, color, size);
}

function xoyGetPixel(x, y) {
    var clr;
    clr = get(x + oX, oY - y);
    return [clr[0], clr[1], clr[2], clr[3]];
}

function rndColor() {
    var r, g, b, clr;
    r = int(Math.random() * 255);
    g = int(Math.random() * 255);
    b = int(Math.random() * 255);
    clr = "rgb(" + r + "," + g + "," + b + ")";
    return clr;
}

