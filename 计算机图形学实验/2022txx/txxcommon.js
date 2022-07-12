/**
 * Created by zhang youhua on 2020/5/10.
 * 此程序仅供大家学习之用，不宜用作其他目的，不要发布至互联网
 */

function setPixel(x,y,color,size) {
    stroke(color);
    strokeWeight(size);
    point(x, y);
}
function getPixel(x, y) {
    var clr;
    clr = get(x, y);
    return [clr[0], clr[1], clr[2],clr[3]];
}


function createCommonDiv(parentdom, id, w, h, posx, posy, bkstr) {
    var key,val;
    if(bkstr.match("#") || bkstr.match("rgb")){
        key="background-color";
        val=bkstr;
    }
    if(bkstr.match("url")){
        key="background";
        val=bkstr;
    }
    var div = createDiv();
    div.size(w, h);
    div.style(key, val);
    div.position(posx, posy);
    div.id(id);
    if(parentdom!=null)  div.parent(parentdom);
    return div;
}

function createLabel(parentdom,id,styl,posx,posy,txt) {
    var lbl=createP(txt);
    lbl.style('font-family', styl.font);
    lbl.style('font-size',styl.fontsize);
    lbl.style('color', styl.fontcolor);
    lbl.style('fontWeight', styl.fontbold);
    lbl.parent(parentdom);
    lbl.id(id);
    lbl.position(posx,posy);
}

function createBtn(parentdom,id,styl,w,h,posx,posy,text) {
    var btn = createButton(text);
    btn.parent(parentdom);
    btn.size(w,h);
    btn.position(posx, posy);
    btn.style('background-color', styl.bkcolor);
    btn.style('font-family', '微软雅黑');
    btn.style('font-size', styl.fontsize);
    return btn;
}

//p0是起点，p1处画arrow
function drawArrowLine(p0, p1, color) {
    var v0 = createVector(p0.x,p0.y);
    var v1 = createVector(p1.x, p1.y);
    push();
    stroke(color);
    strokeWeight(1);
    fill(color);
    translate(v0.x, v0.y);
    v1.x=v1.x-v0.x;
    v1.y=v1.y-v0.y;
    line(0, 0, v1.x, v1.y);
    rotate(v1.heading());
    var arrowSize = 5;
    translate(v1.mag() - arrowSize, 0);
    triangle(0, arrowSize / 2, 0, -arrowSize / 2, arrowSize, 0);
    pop();
}

function drawAxis(parentdiv,ox,oy,color) {
    // stroke(color);
    // noSmooth();
    // line(0, oy, 2*ox, oy);
    // line(ox, 0, ox, 2*oy);
	divAxisX = createCommonDiv(parentdiv, "divAxisX", parentdiv.width, 1, 0,oy, color);
	divAxisY = createCommonDiv(parentdiv, "divAxisY", 1, parentdiv.height, ox,0, color);
}
function moveAxis(nx,ny) {
    divAxisX.position(0,ny);
    divAxisY.position(nx,0);
}
function rotatediv(div,deg) {
    var elt;
    var degstr;
    elt=div.elt;
    deg=-deg;
    degstr="rotate("+deg+"deg)";
    elt.style.webkitTransform = degstr;
    elt.style.mozTransform = degstr;
    elt.style.msTransform = degstr;
    elt.style.oTransform = degstr;
    elt.style.transform = degstr;
}

//"#ff0000"<->[r,g,b]转化
function rgb2color(r,g,b){
    return '#' + byte2Hex(r) + byte2Hex(g) + byte2Hex(b);
}
function byte2Hex(n){
    var str = "0123456789ABCDEF";
    return String(str.substr((n >> 4) & 0x0F,1)) + str.substr(n & 0x0F,1);
}

function color2rgb(x){
    x=x.toUpperCase();
    r=x.slice(1,3);
    g=x.slice(3,5);
    b=x.slice(5,7);
    valr=parseInt("0x"+r);
    valg=parseInt("0x"+g);
    valb=parseInt("0x"+b);
    return [valr,valg,valb];
}

function setup() {main();}
