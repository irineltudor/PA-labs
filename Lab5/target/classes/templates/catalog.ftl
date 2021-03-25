<!DOCTYPE html>
<html>
<head>
<title>REPORT HTML</title>
</head>
    <body>
    <h1>
        ${name}
    </h1>
    <#list items as item>

            <ul>
        <li>Item name: ${item.getName()}</li>
        <li>Item path: ${item.getLocation()}</li>
        <li>Item id: ${item.getId()}</li>
    </ul>

    </#list>
    </body>
</html>