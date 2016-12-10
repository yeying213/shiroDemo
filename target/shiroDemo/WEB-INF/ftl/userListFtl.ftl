<#import "spring.ftl" as spring/>
<html>
<head>
    <title><@spring.message "website.title"/></title>
</head>
<@spring.message "user.userList.title"/>
<#list userList as user>
<tr>
    <td>
        <a href="<@spring.url''/>">
        ${user.userName}
        </a>
    </td>
    <td>${user.userName}</td>
    <td>${user.birthday?String("yyyy-MM-dd")}</td>
</tr>
</#list>
</html>