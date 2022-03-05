var obj = {};
obj.name = "华仔";
obj.age = 18;
obj.fun = function () {
    alert("姓名：" + this.name + " , 年龄：" + this.age);
}
obj.fun();