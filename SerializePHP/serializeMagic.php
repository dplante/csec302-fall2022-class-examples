<?php

class Account {
    private $username;
    private $password;

    public function __construct($username, $password) {
	print("*** In construct ***\n");
        $this->username = $username;
        $this->password = $password;
    }

    public function __wakeup() {
        print("*** In wakeup ***\n");
    }

    public function __destruct() {
        print("*** In destruct ***\n");
    }
}

/* 
 * Serialize object
 */
$acct = new Account('marcus', '123456');
$serial_acct = serialize($acct) . "\n";
echo $serial_acct . "\n";

/*
 * Deserialize
 */
var_dump(unserialize($serial_acct));

