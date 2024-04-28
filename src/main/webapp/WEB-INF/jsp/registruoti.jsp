<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
    <head>
        <title>Skaičiuotuvas</title>
        <style>
            .error{color:red}
        </style>
    </head>
    <body>
        <h2>Internetinis skaičiuotuvas</h2><br>
            <h3>Registracija</h3>
            <form:form method="post" action="registruoti" modelAttribute="user">
                <form:input type="text" placeholder="El. paštas" path="email"/>
                <form:errors path="email" cssClass="error"/><br/><br/>
                <form:input type="password" placeholder="Slaptažodis"  path="password"/>
                <form:errors path="password" cssClass="error"/><br/><br/>
                <form:input type="password" placeholder="Slaptažodžio patvirtinimas" path="confirmPassword"/>
                <form:errors path="confirmPassword" cssClass="error"/><br/><br/>
                <input type="submit" value="Registruotis">
        </form:form>
    </body>
</html>