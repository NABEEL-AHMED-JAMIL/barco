# 1 CURL Command For Api-Access
#### 1. Login Curl-Cmd
	* curl client:secret@localhost:8080/oauth/token -d grant_type=password -d username=user -d password=pwd
	* curl -vu barco:ballistic 'http://localhost:9191/api/oauth/token?username=nabeel.amd93@gmail.com&password=ballistic&grant_type=password'
#### 2. Refresh Token Curl-Cmd
	* curl -vu barco:ballistic 'http://localhost:9191/api/oauth/token?grant_type=refresh_token&refresh_token=<refresh_token>'
#### 3. Logout Curl-Cmd
    * curl -i -H "Authorization: Bearer <access_token>" http://localhost:9191/api/oauth/logout
#### 4. Access Secure Curl-Cmd
	* curl -i -H "Authorization: Bearer <access_token>" http://localhost:9191/api/secure
	* curl -i X POST -H "Authorization: Bearer <access_token>" http://localhost:9191/api/qr-code/generate-qr
	* curl -i X GET -H "Authorization: Bearer <access_token>" http://localhost:9191/api/qr-code/decode-qr
#### 5. No Secure method access Curl-Cmd
	* curl -i -X POST  http://localhost:9191/api/oauth/register
	* curl -i -X GET  http://localhost:9191/api/oauth/lost/password
	* curl -i -X POST  http://localhost:9191/api/oauth/reset/password
	* curl -i -X POST  http://localhost:9191/api/oauth/activated
#### 6. Example of Creating Request Curl-Cmd
	* curl -i -X GET http://rest-api.io/items
	* curl -i -X GET http://rest-api.io/items/5069b47aa892630aae059584
	* curl -i -X DELETE http://rest-api.io/items/5069b47aa892630aae059584
	* curl -i -X POST -H 'Content-Type: application/json' -d '{"name": "New item", "year": "2009"}' http://rest-api.io/items
	* curl -i -X PUT -H 'Content-Type: application/json' -d '{"name": "Updated item", "year": "2010"}' http://rest-api.io/items/5069b47aa892630aae059584
	* curl -i -X DELETE localhost:8080/rest/customers/2
	* curl -i -H "Content-Type: application/json" -X PUT -d '{"id":3,"firstName":"Joe","lastName":"Smith333333","dateOfBirth":379468800000,"address":{"id":3,"street":"High Street","town":"Belfast","county":"Down","postcode":"BT893PY"}}' localhost:8080/rest/customers/3
	* curl -i -H "Content-Type: application/json" -X POST -d '{"firstName":"JoeXXXXXXXXXXXXXXX","lastName":"SmithXXXXXXXXXXXXX","dateOfBirth":379468800000,"address":{"street":"High Street","town":"Belfast","county":"Down","postcode":"BT893PY"}}' localhost:8080/rest/customers
	* curl -i localhost:8080/rest/customers
	* curl -i localhost:8080/rest/customers/1

#### 7. Upload file Request Curl-Cmd
	* curl -F 'img_avatar=@/home/petehouston/hello.txt' http://localhost/upload
	* curl -F ‘data=@path/to/local/file’ UPLOAD_ADDRESS

# 2 Google Re-Captcha Setting
#### 1) Key/Value paire
```
* Label: spring-ionic
* Domains: localhost
* Owners: nabee.amd93@gmail.com
* Site key: 6Le3zkEUAAAAAHWmmdTdoUiE11izsUH4iTqjJVSc
* Secret key: 6Le3zkEUAAAAACYZS7ue0in1RM-UAGjwutkA0Qz4
```
#### 2) Client Side Integration
```
* Paste this snippet before the closing </head> tag on your HTML template: <script src='https://www.google.com/recaptcha/api.js'></script>
* Paste this snippet at the end of the <form> where you want the reCAPTCHA widget to appear: <div class="g-recaptcha" data-sitekey="6Le3zkEUAAAAAHWmmdTdoUiE11izsUH4iTqjJVSc"></div>
```
#### 3) Server side Integration
```
When your users submit the form where you integrated reCAPTCHA, you'll get as part of the payload a string with the name "g-recaptcha-response".
In order to check whether Google has verified that user, send a POST request with these parameters:
  1) URL: https://www.google.com/recaptcha/api/siteverify
  2) secret (required) 6Le3zkEUAAAAACYZS7ue0in1RM-UAGjwutkA0Qz4
  3) response (required)   The value of 'g-recaptcha-response'.
  4) remoteip  The end user's ip address.
```
# 3 Image For Post-Man Request
![alt text](postman/access_data.png)
![alt text](postman/login.png)
![alt text](postman/refresh_token.png)
![alt text](postman/token_image.png)
![alt text](postman/unauthorized.png)
![alt text](postman/FileUpload_Postman.png)
![alt text](postman/barco.png)
