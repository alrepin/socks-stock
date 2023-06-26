##### <img src="http://alrepin.sytes.net/school/student/2/avatar/preview" width="50" height="50"/> Skypro от Skyeng
***

###  Application for automating the accounting of socks in the warehouse of the store

##### [Specification](https://momentous-handsaw-cf6.notion.site/Specification-6525280b048649d99a6aed26b5420016?pvs=4)
The following functionality needs to be implemented:
- To take into account the arrival and release of socks;
- To find out the total number of socks of a certain color and composition at a given time.
###### [Demo](http://socks-stock-backend.edu.repin.cf/)
###### [DB console](http://socks-stock-h2db-console.edu.repin.cf/)
```
login: admin  
password: admin  
url: jdbc:h2:file:./src/main/resources/db/data;AUTO_SERVER=TRUE;DATABASE_TO_UPPER=FALSE;CASE_INSENSITIVE_IDENTIFIERS=TRUE;
```
##### Architectural Features:
<details>
  <summary>Database Schema</summary>
<img src="https://github.com/alrepin/socks-stock/blob/dev/db.png?raw=true" />

</details>  


##### Deployment Instructions:
<details>
  <summary>Docker image building</summary>

```
docker build -t socks-stock-backend .
```
</details>

##### Running in Docker Compose version v2:
`docker compose up -d`
<details>
  <summary>docker-compose.yml listing</summary>

```

```
</details>


***
