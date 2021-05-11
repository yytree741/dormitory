<%@page  contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>springboot项目测试jsp页面</title>
    <script src="${pageContext.request.contextPath}/js/qrcode.min.js"></script>
</head>
<body>

    <h1>sssssssss</h1>

    <div id="aa"></div>
    <script>
        new QRCode(document.getElementById("aa"),"${requestScope.pay.qr_url}");
    </script>

</body>
</html>