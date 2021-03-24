<!DOCTYPE html>
<html>
<head>REPORT HTML</head>
    <body>
    <h1>
        ${name}
    </h1>
    <#list items as item>
        <p>
            <ul>
        <li>Item name: ${item.getName()}</li>
        <li>Item path: ${item.getLocation()}</li>
        <li>Item id: ${item.getId()}</li>
    </ul>
        </p>
    </#list>
    </body>
</html>