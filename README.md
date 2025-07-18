# ExcelFileUpload-Spring-Boot-MySql

This project is use to learn how to upload excel file in the spring boot and store excel data in any database like mysql

For Upload simple excel file 
Instraction :
create a new excel file 
Now first row will be header and then data of user
Id | Name | Email          | Age |
01 | Ravi | ravi@gmail.com | 24  |
02 | Adi  | adi@gmail.com  | 25  |

Use this url for upload excel file 
http://localhost:8080/api/excel/upload

now open the postman and select Method as Post 
then goto Body section and select the form-data 
in Key write file and then select Text to File and then 
in Value update your excel file 

*****************************************************
Crulz :
********

curl --location 'http://localhost:8080/api/excel/upload' \
--form 'file=@"/C:/Users/jne_s/OneDrive/Desktop/Book1.xlsx"'

******************************************************
