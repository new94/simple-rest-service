# simple-rest-service
## Simple REST-service by using Spring.
Service implemets GET-methods <code>save</code> and <code>getById</code> for saving and getting data from database.

- As a database use **H2**.
- As a template engine use **Mustache**.
- As a servlet containers use **Tomcat embedded**.
- Spring dependecies: **Web**, **JPA**, **DevTools**.

Clone and run project. Enter in your web-browser <code>localhos:8080/api/save/message</code> and you will get page with label:</p><code>Message:ID:1, DATA:message.</code>
</p>Enter in your browser 
<code>localhos:8080/api/getById/1</code> and you will get page with label:</p><code>Message:ID:1, DATA:message.</code>
</p>Enter in your browser <code>localhos:8080/api/getById/2</code> and you will get page with label:</p><code>Not found data by id = 2.</code>
