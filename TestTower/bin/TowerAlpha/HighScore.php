<?php

/*
** This php script get the highscore list via ?do=show via MySQL and shows it and adds players via ?do=upload
**/

if(isset($_GET["do"]) && $_GET["do"] == "show") {

// database connection
include("../_database.inc.php");

// rank counter
$i = 0;

// db query
@$playerQry = mysql_query("SELECT `ID`, `name`, `score`, `date` FROM `uni_propra` ORDER BY `score` DESC");

while(@$hs = mysql_fetch_assoc($playerQry)) {

   $i++;

   // output for selfmade xml parser in java
   //echo '<rank>'.$i.'</rank><player>'.$hs['name'].'</player><score>'.$hs['score'].'</score><date>'.date("d.m.y", $hs['date']).'</date>
   echo $i.';'.$hs['name'].';'.$hs['score'].';'.date("d.m.y", $hs['date']).';
';

}


} elseif($_GET["do"] == "upload") {

   if(!$_GET['name'] || !$_GET['score']) exit(1);

   // database connection
   include("../_database.inc.php");

   // escape sql injections
   @$name = mysql_real_escape_string($_GET["name"]);
   @$score = mysql_real_escape_string($_GET["score"]);
   @$hash = $_GET["h"];
   
   //if($hash == md5("$name $score 1337")) {
      // valid hash
      
      @$time = time();
      
      @mysql_query("INSERT INTO `uni_propra` (`name`, `score`, `date`) VALUES ('$name', '$score', '$time')");
      
      exit(1);
   
   /*} else {
      echo 'CHEATER';
   }*/
   
} else {

   echo "0";
   exit(0);
   
}

?>