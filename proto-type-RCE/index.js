const express = require('express');
const fileUpload = require('express-fileupload');
const app = express();

app.use(fileUpload({ parseNested: true }));

app.get('/', (req, res) => {
    res.end('express-fileupload poc = '+Object.prototype.polluted);
});

app.listen(7777)
