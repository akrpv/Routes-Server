# Routes-Server API

<b>GET /route-points</b><br>
><b>Parameters:</b><br>
>time=minutes<br>
>start=x,y<br>
>categories=cat1,cat2,cat3, ...<br><br>
>Response:<br>
>[{<br>
>&nbsp;&nbsp;&nbsp;&nbsp;"x": x,<br>
>&nbsp;&nbsp;&nbsp;&nbsp;"y": y,<br>
>&nbsp;&nbsp;&nbsp;&nbsp;"name": name,<br>
>&nbsp;&nbsp;&nbsp;&nbsp;"category": categoryName<br>
>&nbsp;&nbsp;&nbsp;&nbsp;"time": minutes<br>
>},...]

<b>GET /categories</b><br>
>Response:<br>
>["cat1", "cat2", "cat3", ...]
