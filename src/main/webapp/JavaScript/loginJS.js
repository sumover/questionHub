var username = document.getElementById("loginFormUserNameText");
username.addEventListener(event, function(event)
{
    if(username.toString() == null)
        alert("请填写用户名");
});

var password = document.getElementById("loginFormPasswordText");
password.addEventListener(event, function(event)
{
    if(username.toString() != null && password.toString() == null)
        alert("请填写密码");
});