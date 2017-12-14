<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
<base href="${pageContext.request.contextPath}/">
</head>
<div class="main-content-agile">
    <div class="sub-main-w3">	
        <form action="admin/home/login.php" method="post">
            <input id="id" placeholder="Tên đăng nhập" name="id" class="user" type="text" required=""><br>
            <input id="pw" placeholder="Mật khẩu" name="pw" class="pass" type="password" required=""><br>

            <input formaction="admin/home/login.php" formmethod="post" type="submit" value="">
        	
        </form>
		<span style="color: red; margin-top: 20px">${mess}</span>
    </div>
</div>