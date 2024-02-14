# Available methods in the API:
**OBS: As this microservice is not in production, the domain of the URLS that are being shown below is as "domain_name", if this project is for production level, I will change these images to put the URLS with the production domain .**



## 1 - APPLICATION entity methods:

### 1.1 - Create (POST) Application:

#### 1.1.1 - Request URL:
![POST_application_URI.png](documentation_images/POST_application_URI.png)

#### 1.1.2 - Request body: The body request is of JSON type, below there is an example it. <br />
![POST_application_body](documentation_images/POST_application_body.png)

#### 1.1.3 - Response: The response has 201 status and its body contains the application created: <br />
![POST_application_response](documentation_images/POST_application_response.png)

#### Warnings:
- If the user sent invalid values, he will receive a response with 400 status which contains a body that informs the error. Example:
![POST_application_response_error](documentation_images/POST_application_response_error.png)


### 1.2 - READ (GET) All Applications:

#### 1.2.1 - Request URL: <br />
![GET_application_URI](documentation_images/GET_application_URI.png)

#### 1.2.2: - Request body: This request does not require a body. <br />

#### 1.1.3 - Response: If all goes well, you will receive a response with 200 status. And a body like this: <br />
![GET_application_response](documentation_images/GET_application_response.png)


### 1.3 - READ (GET) One Application:

#### 1.3.1 - Request URL: <br />
![GET_one_application_URI](documentation_images/GET_one_application_URI.png)

#### 1.3.2: - Request body: This request does not require a body. <br />

#### 1.3.3 - Response: If all goes well, you will receive a response with 200 status. And a body like this: <br />
![GET_one_application_response](documentation_images/GET_one_application_response.png)

#### Warnings:
- If the ID is not associated with any Application. You will receive the following response with 400 status: <br />
![application_not_found](documentation_images/application_not_found.png)


### 1.4 - UPDATE (PUT) Application:

#### 1.4.1 - Request URL: <br />
![PUT_application_URI](documentation_images/PUT_application_URI.png)

#### 1.4.2 - Request body: The body request is of JSON type, below there is an example it. <br />
![PUT_application_request](documentation_images/PUT_application_request.png)

#### 1.4.3 - Response: If all goes well, you will receive a response like this: <br />
![PUT_application_response](documentation_images/PUT_application_response.png)

#### Warnings:
- If the user sent invalid values, he will receive a response with 400 status which contains a body that informs the error. Example: <br />
![PUT_application_error](documentation_images/PUT_application_error.png)

- If the ID is not associated with any application. You will receive the following response with 400 status: <br />
  ![application_not_found](documentation_images/application_not_found.png)


### 1.5 - DELETE (DEL) Application:

#### 1.5.1 - Request URL: <br />
![DELETE_application_URI](documentation_images/DELETE_application_URI.png)

#### 1.5.2: - Request body: This request does not require a body, you will need only pass the application ID at URI. <br />

#### 1.5.3 - Response: If all goes well, you will receive a response with 204 status.

#### Warnings:
- If the ID is not associated with any application. You will receive the following response with 400 status: <br />
  ![application_not_found](documentation_images/application_not_found.png)



## 2 - PERMISSION entity methods:

### 2.1 - Create (POST) Permission:

#### 2.1.1 - Request URL:
![POST_permission_URI](documentation_images/POST_permission_URI.png)

#### 2.1.2 - Request body: The body request is of JSON type, below there is an example it. <br />
![POST_permission_request](documentation_images/POST_permission_request.png)

#### 2.1.3 - Response: The response has 201 status and its body contains the permission created: <br />
![POST_permission_response](documentation_images/POST_permission_response.png)

#### Warnings:
- The microservice will always convert the 'name' field (sent in the request) to a valid format. Example: <br />
![handling_permission_name_example](documentation_images/invalid_permission_name_example.png) >>> ![img_18.png](documentation_images/handling_permission_name_example.png)


### 2.2 - READ (GET) All Permissions:

#### 2.2.1 - Request URL: <br />
![GET_permissions_URI](documentation_images/GET_permissions_URI.png)

#### 2.2.2: - Request body: This request does not require a body. <br />

#### 2.1.3 - Response: If all goes well, you will receive a response with 200 status. And a body like this: <br />
![GET_permissions_response](documentation_images/GET_permissions_response.png)


### 2.3 - READ (GET) One Permission:

#### 2.3.1 - Request URL: <br />
![GET_permission_URI](documentation_images/GET_permission_URI.png)

#### 2.3.2: - Request body: This request does not require a body. <br />

#### 2.3.3 - Response: If all goes well, you will receive a response with 200 status. And a body like this: <br />
![GET_permission_response](documentation_images/GET_permission_response.png)

#### Warnings:
- If the ID is not associated with any Permission. You will receive the following response with 400 status: <br />
![permission_not_found](documentation_images/permission_not_found.png)


### 2.4 - UPDATE (PUT) Permission:

#### 2.4.1 - Request URL: <br />
![PUT_permission_URI](documentation_images/PUT_permission_URI.png)

#### 2.4.2 - Request body: The body request is of JSON type, below there is an example it. <br />
![POST_permission_request](documentation_images/POST_permission_request.png)

#### 2.4.3 - Response: If all goes well, you will receive a response like this: <br />
![PUT_permission_response](documentation_images/PUT_permission_response.png)

#### Warnings:
- The microservice will always convert the 'name' field (sent in the request) to a valid format. Example: <br />
  ![invalid_permission_name_example](documentation_images/invalid_permission_name_example.png) >>> ![handling_permission_name_example](documentation_images/handling_permission_name_example.png)

- If the ID is not associated with any Permission. You will receive the following response with 400 status: <br />
  ![permission_not_found](documentation_images/permission_not_found.png)


### 2.5 - DELETE (DEL) Permission:

#### 2.5.1 - Request URL: <br />
![DELETE_permission_URI](documentation_images/DELETE_permission_URI.png)

#### 2.5.2: - Request body: This request does not require a body, you will need only pass the permission ID at URI. <br />

#### 2.5.3 - Response: If all goes well, you will receive a response with 204 status.

#### Warnings:
- If the ID is not associated with any Permission. You will receive the following response with 400 status: <br />
  ![permission_not_found](documentation_images/permission_not_found.png)


  
## 3 - GROUP entity methods:

### 3.1 - Create (POST) Group:

#### 3.1.1 - Request URL:
![POST_group_URI](documentation_images/POST_group_URI.png)

#### 3.1.2 - Request body: The body request is of JSON type, below there is an example it. <br />
![POST_group_request](documentation_images/POST_group_request.png)

#### 3.1.3 - Response: The response has 201 status and its body contains the group created: <br />
![POST_group_response](documentation_images/POST_group_response.png)

#### Warnings:
- If the user sent invalid values, he will receive a response with 400 status which contains a body that informs the error. Example: <br />
![application_not_found_with_access_key](documentation_images/application_not_found_with_access_key.png)
- If the user sent a group name which already exists at the same application, he will receive a response with 400 status which contains a body that informs the error. Example: <br />
![group_name_already_in_use](documentation_images/group_name_already_in_use.png)


### 3.2 - READ (GET) All Group:

#### 3.2.1 - Request URL: <br />
![GET_groups_URI](documentation_images/GET_groups_URI.png)

#### 3.2.2: - Request body: This request does not require a body. <br />

#### 3.1.3 - Response: If all goes well, you will receive a response with 200 status. And a body like this: <br />
![GET_groups_response](documentation_images/GET_groups_response.png)


### 3.3 - READ (GET) One Group:

#### 3.3.1 - Request URL: <br />
![GET_group_URI](documentation_images/GET_group_URI.png)

#### 3.3.2: - Request body: This request does not require a body. <br />

#### 3.3.3 - Response: If all goes well, you will receive a response with 200 status. And a body like this: <br />
![GET_group_response](documentation_images/GET_group_response.png)

#### Warnings:
- If the ID is not associated with any Group. You will receive the following response with 400 status: <br />
![group_not_found](documentation_images/group_not_found.png)


### 3.4 - UPDATE (PUT) Group:

#### 3.4.1 - Request URL: <br />
![PUT_group_URI](documentation_images/PUT_group_URI.png)

#### 3.4.2 - Request body: The body request is of JSON type, below there is an example it. <br />
![PUT_group_request](documentation_images/PUT_group_request.png)

#### 3.4.3 - Response: If all goes well, you will receive a response like this: <br />
![PUT_group_response](documentation_images/PUT_group_response.png)

#### Warnings:
- If the user sent invalid values, he will receive a response with 400 status which contains a body that informs the error. Example: <br />
  ![application_not_found_with_access_key](documentation_images/application_not_found_with_access_key.png)
- If the user sent a group name which already exists at the same application, he will receive a response with 400 status which contains a body that informs the error. Example: <br />
  ![group_name_already_in_use](documentation_images/group_name_already_in_use.png)
- If the ID is not associated with any Group. You will receive the following response with 400 status: <br />
  ![group_not_found](documentation_images/group_not_found.png)


### 3.5 - DELETE (DEL) Group:

#### 3.5.1 - Request URL: <br />
![DELETE_group_URI](documentation_images/DELETE_group_URI.png)

#### 3.5.2: - Request body: This request does not require a body, you will need only pass the group ID at URI. <br />

#### 3.5.3 - Response: If all goes well, you will receive a response with 204 status.

#### Warnings:
- If the ID is not associated with any Group. You will receive the following response with 400 status: <br />
  ![group_not_found](documentation_images/group_not_found.png)


  
## 4 - USER entity methods:

### 4.1 - Create (POST) User:

#### 4.1.1 - Request URL:
![POST_user_URI](documentation_images/POST_user_URI.png)

#### 4.1.2 - Request body: The body request is of JSON type, below there is an example it. <br />
![POST_user_request](documentation_images/POST_user_request.png)

#### 4.1.3 - Response: The response has 201 status and its body contains the user created: <br />
![POST_user_response](documentation_images/POST_user_response.png)

#### Warnings:
- If the user sent invalid values, he will receive a response with 400 status which contains a body that informs the error. Examples: <br />
![username_already_in_use_example](documentation_images/username_already_in_use_example.png)
![group_not_found_error_example](documentation_images/group_not_found_error_example.png)
- If the user submits one ID of a group that doesn't belong to the corresponding application of the access key sent, he will receive a response with 400 status which contains a body that informs the error. Example: <br />
![group_does_not_belong_application_eror](documentation_images/group_does_not_belong_application_eror.png)


### 4.2 - READ (GET) All User:

#### 4.2.1 - Request URL: <br />
![GET_users_URI](documentation_images/GET_users_URI.png)

#### 4.2.2: - Request body: This request does not require a body. <br />

#### 4.1.3 - Response: If all goes well, you will receive a response with 200 status. And a body like this: <br />
![GET_users_response](documentation_images/GET_users_response.png)


### 4.3 - READ (GET) One User:

#### 4.3.1 - Request URL: <br />
![GET_user_URI](documentation_images/GET_user_URI.png)

#### 4.3.2: - Request body: This request does not require a body. <br />

#### 4.3.3 - Response: If all goes well, you will receive a response with 200 status. And a body like this: <br />
![GET_user_response](documentation_images/GET_user_response.png)

#### Warnings:
- If the ID is not associated with any User. You will receive the following response with 400 status: <br />
![user_not_found](documentation_images/user_not_found.png)


### 4.4 - UPDATE (PUT) User:

#### 4.4.1 - Request URL: <br />
![PUT_user_URI](documentation_images/PUT_user_URI.png)

#### 4.4.2 - Request body: The body request is of JSON type, below there is an example it. <br />
![PUT_user_request](documentation_images/PUT_user_request.png)

#### 4.4.3 - Response: If all goes well, you will receive a response like this: <br />
![PUT_user_response](documentation_images/PUT_user_response.png)

#### Warnings:
- If the user sent invalid values, he will receive a response with 400 status which contains a body that informs the error. Examples: <br />
  ![username_already_in_use_example](documentation_images/username_already_in_use_example.png)
  ![group_not_found_error_example](documentation_images/group_not_found_error_example.png)
- If the user submits one ID of a group that doesn't belong to the corresponding application of the access key sent, he will receive a response with 400 status which contains a body that informs the error. Example: <br />
  ![group_does_not_belong_application_eror](documentation_images/group_does_not_belong_application_eror.png)
- If the ID is not associated with any User. You will receive the following response with 400 status: <br />
  ![user_not_found](documentation_images/user_not_found.png)


### 4.5 - DELETE (DEL) User:

#### 4.5.1 - Request URL: <br />
![DELETE_user_URI](documentation_images/DELETE_user_URI.png)

#### 4.5.2: - Request body: This request does not require a body, you will need only pass the user ID at URI. <br />

#### 4.5.3 - Response: If all goes well, you will receive a response with 204 status.

#### Warnings:
- If the ID is not associated with any User. You will receive the following response with 400 status: <br />
  ![group_not_found](documentation_images/group_not_found.png)
- If the ID is not associated with any User. You will receive the following response with 400 status: <br />
  ![user_not_found](documentation_images/user_not_found.png)


### 4.5 - LOGIN User:

#### 4.5.1 - Request URL: <br />
![login_user_URI](documentation_images/login_user_URI.png)

#### 4.5.2 - Request body: The body request is of JSON type, below there is an example it. <br />
![login_user_request](documentation_images/login_user_request.png)

#### 4.5.3 - Response: If all goes well, you will receive a response which contains the permissions of user and one JWT token that has the user's credentials. Example: <br />
![login_user_response](documentation_images/login_user_response.png)

#### Warnings:
- If the user sent invalid values, he will receive a response with 400 status which contains a body that informs the error. Examples: <br />
![data_invalid_error](documentation_images/data_invalid_error.png)
![application_not_found_with_access_key_error](documentation_images/application_not_found_with_access_key_error.png)


### 4.6 - VERIFY PERMISSION of User:

#### 4.6.1 - Request URL: <br />
![verify_permission_URI](documentation_images/verify_permission_URI.png)

#### 4.6.2: - Request body: This request does not require a body, but you will need to pass the user's JWT token in order to microservice perform authentication of user and verify if the user has the permission sent. <br />

#### 4.6.3 - Response: If all goes well and the user has the permission related, he will receive a response with 204 status. But if he does not have permission, he will receive a response with 401 (UNAUTHORIZED) status.

#### Warnings:
- If the user sent an invalid JWT token, he will receive a response with 400 status which contains a body that informs the error. Example: <br />
![JWT_token_invalid_error_example](documentation_images/JWT_token_invalid_error_example.png)