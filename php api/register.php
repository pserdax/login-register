<?php
require "init.php";

$email = $_GET["email"];
$password = $_GET["password"];
$password_confirm =  $_GET["password_confirm"];

$sql = "select *from  login_info where email= '$email' ";

$result  = mysqli_query($con, $sql);
$rows = mysqli_num_rows($result);

if($rows>0){
    $status  = "exist";
}

else{
    $sql = "insert into login_info(email, password, password_confirm) values('$email', '$password', '$password_confirm')";

    if(mysqli_query($con, $sql) && $password==$password_confirm){
        $status =  "ok";

    }
    else if($password != $password_confirm){
        $status = "password doesn't match!";
    }
   
    else{ 
        $status = "error";
    }
}
echo json_encode(array("response" => $status));
mysqli_close($con)

?>