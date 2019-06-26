<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>查询商品列表</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/item/showlist.action" method="post">
    查询条件：
    <table width="100%" border=1>
        <tr>
            <td>商品名称</td>
            <td><input name="items.name"/></td>
            <td>商品价格</td>
            <td><input name="items.price"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="查询"/></td>
        </tr>
    </table>
    商品列表：
    <table width="100%" border=1>
        <tr>
            <td>选择</td>
            <td>商品名称</td>
            <td>商品价格</td>
            <td>生产日期</td>
            <td>商品描述</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${itemList }" var="item" varStatus="status">
            <tr>
                <td><input type="checkbox" name="ids" value="${item.id }"/></td>
                <td><input name="itemsList[${status.index}].name" value="${item.name }"/></td>
                <%--
                      关于 name ="itemsList[${status.index}].name" 格式定义

                      在Controller中，定义的形参 QueryVo类中定义了 ArrayList<Items> itemsList 属性，来接受 JSP页面的数据。

                      辣么，这里jsp中应该定义成 itemsList[角标].name  ，这个角标也就是 上面 forEach的属性，使用varStatus来获取。
                --%>
                <td><input name="itemsList[${status.index}].price" value="${item.price }"/></td>
                <td><input name="itemsList[${status.index}].createtime"
                           value="<fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/></td>
                <td><input name="itemsList[${status.index}].detail" value="${item.detail }"/></td>

                <td><a href="${pageContext.request.contextPath }/item/itemEdit.action?id=${item.id}">修改</a></td>

            </tr>
        </c:forEach>

    </table>
    <button type="submit">批量删除</button>
    <button type="submit">批量修改</button>
</form>
</body>

</html>