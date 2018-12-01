<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2018/7/6
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript">

        var isPhone=false;

        function checkPhone(){
            //根据id得到 input标签
            var pinput = document.getElementById("phone");
            var pspan=document.getElementById("phonemsg");
            // pinput的value值
            var strPhone= pinput.value;
            if(strPhone==null || strPhone.trim().length==0){
                pspan.style.color="red";
                pspan.innerHTML="手机号不能为空";
                isPhone=false;
            }else{
                //对内容进行判断：是否符合手机号码的格式   11 正则表达式 ：手机号
                var reg=new RegExp("^1[0-9]{10}$");
                if(!reg.test(strPhone)){
                    pspan.style.color="red";
                    pspan.innerHTML="手机号不符合格式";
                    isPhone=false;

                }else{

                    //进一步判断数据库中有没有这个电话号码，有，不能注册：
                    // 没有的  ajax

                    $.ajax({
                        async:true,
                        type:"POST",
                        data:{"phone":strPhone},
                        url:"CheckPhoneServlet",
                        dataType:"text",
                        success: function(data){
                            console.log(data);
                            if(data=="true"){
                                //绿色通过
                                pspan.style.color="green";
                                pspan.innerHTML="√";
                                isPhone=true;

                            }else{
                                pspan.style.color="red";
                                pspan.innerHTML="该手机号已经注册";
                                isPhone=false;
                            }
                        }
                    });
                }
            }
        }

        function checkPwd(){
            //  获取 id为pwd的value值
            var strPwd= $("#pwd").val();
            if(strPwd==null || strPwd.trim().length==0){
                $("#pwdmsg").css("color","red");
                $("#pwdmsg").html("密码不能为空");
                return false;
            }else{
                // js是弱数据类型
                var regPwd=/^[0-9a-zA-Z_]{4,16}$/;
                if(!regPwd.test(strPwd)){
                    $("#pwdmsg").css("color","red");
                    $("#pwdmsg").html("密码必须是4-16位");
                    return false;

                }else{
                    $("#pwdmsg").css("color","green");
                    $("#pwdmsg").html("√");
                    return true;
                }
            }
        }

        function checkAll(){
            if(isPhone&&checkPwd()){
                return true;
            }
            return false;
        }
    </script>
</head>
<body>
<h3>欢迎注册</h3>
    <form action="RegisterServlet" method="get" onsubmit="return checkAll();">
        <label>手机号</label> <input type="text" onblur="checkPhone()" id="phone" value="" name="phone" placeholder="手机号"/>   <span id="phonemsg"></span> <br/>
        <label>密码</label>  <input type="password" onblur="checkPwd()" id="pwd" name="pwd" placeholder="4-16密码"/><span id="pwdmsg"></span><br/>
        <input type="submit" value="注册"/>
    </form>
</body>
</html>
