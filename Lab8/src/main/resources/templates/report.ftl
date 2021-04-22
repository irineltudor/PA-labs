<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Laborator 8 Report</title>
</head>
<body>
<h1>Bellow we are going to show you the information for ${movie_title}</h1>
<p>
<ul>
    Movie Details:
    <li>
        Movie's Genre: ${movie_genre}
    </li>
    <li>
        Movie's release date: ${movie_release_date}
    </li>

    <li>
        Movie's score: ${movie_score}
    </li>
    Director Information:
    <#list directors as director>
    <li>
        Name: ${director.getName()}
    </li>
    </#list>
    Actors from the movie:
    <#list actors as actor>
        <li>
            Name: ${actor.getName()}
        </li>
    </#list>
</ul>
</p>
</body>
</html>