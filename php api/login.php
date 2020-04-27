<?php
require "init.php";

$email = $_GET["email"];
$password = $_GET["password"];

$sql = "select email from login_info where email = '$email' and password='$password' ";

$result  = mysqli_query($con, $sql);

if(!mysqli_num_rows($result)>0){
    $status = "failed";
    echo json_encode(array("response"=>$status));
}

else{
    $row = mysqli_fetch_assoc($result);
    $email = $row['email'];
    $status = "ok";
    echo json_encode(array("response"=>$status, "email"=>$email));
}

mysqli_close($con);
?>