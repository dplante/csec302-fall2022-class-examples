<?php
/*
 * Serialize single elements and arrays 
 */
echo serialize('hello') . "\n";
echo serialize(array(1,-2,13.99,round(13.721342355),100)) . "\n";

/*
 * Serialize array of strings 
 */
$people = ['Georgette','Abdullah','Lee',     'Justin'];
$peeps = serialize($people);
echo $peeps . "\n";

/* 
 * Serialize associative array
 */
$values = ['dog'=>'Fido', 'cat'=>'Scratcher', 'student'=>'Peter', 'gpa'=>3.75];
$serial_map = serialize($values) . "\n";
echo $serial_map . "\n";

/*
 * Deserialize
 */
echo unserialize($peeps) . "\n";
var_dump(unserialize($peeps));
var_dump(unserialize($serial_map));
