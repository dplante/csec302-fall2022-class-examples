# General Information
For your demo, you are to provide information so that everyone in class can reproduce your demo.  This material is all testable!  Here is an example, which I will present in class, of what would be a decent demo assignment.

Searched Google for "cve vulnerable open source code" as shown in class, found:
(https://www.mend.io/resources/blog/top-security-open-source-vulnerabilities-2020/#1_Lodash)

This led me to the Hackerone report by `posix` showing the vulnerability discovered, CVE-2018–3721:
(https://hackerone.com/reports/712065)

Trying to understand this better, a bit of searching led me to this link which gives even more details on the Synk vulnerability in Lodash, CVE-2019–10744:
(https://itnext.io/prototype-pollution-attack-on-nodejs-applications-94a8582373e7)

To really understand prototypes in Javascript, the advanced official documentation from Mozilla is here:
(https://developer.mozilla.org/en-US/docs/Web/JavaScript/Inheritance_and_the_prototype_chain)

# Walkthrough
There are two directories, `lodash-demo` and `lodash-demo-fix` which just have the `package.json` files that install a vulnerable version of *lodash* and a fixed version in the two directories.

To understand the broken then fixed versions, copy the three files `attack1.json`, `attack2.json`, and `attack3.json` files into both directories.  Run this in *Visual Studio Code* with the debugger to step INTO the modules in `node-modules` and see the before and after versions of the code. 