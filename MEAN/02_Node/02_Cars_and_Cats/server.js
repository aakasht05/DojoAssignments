// get the http module:
var http = require('http');
// fs module allows us to read and write content for responses!!
var fs = require('fs');
// creating a server using http module:
var server = http.createServer(function (request, response) {
    // see what URL the clients are requesting:
    console.log('client request URL: ', request.url);
    // this is how we do routing:
    if (request.url === '/cars') {
        fs.readFile('./views/cars.html', 'utf8', function (errors, contents) {
            response.writeHead(200, {
                'Content-Type': 'text/html'
            }); // send data about response
            response.write(contents); //  send response body
            response.end(); // finished!
        });
    } else if (request.url === "/cats") {
        fs.readFile('./views/cats.html', 'utf8', function (errors, contents) {
            response.writeHead(200, {
                'Content-type': 'text/html'
            });
            response.write(contents);
            response.end();
        });
    } else if (request.url === "/cars/new") {
        fs.readFile('./views/newcars.html', 'utf8', function (errors, contents) {
            response.writeHead(200, {
                'Content-type': 'text/html'
            });
            response.write(contents);
            response.end();
        });
    } else if (request.url === '/stylesheets/style.css') {
        fs.readFile('./stylesheets/style.css', 'utf8', function (errors, contents) {
            response.writeHead(200, {
                'Content-type': 'text/css'
            });
            response.write(contents);
            response.end();
        })
    } else if (request.url === '/images/cars1.jpg') {
        // notice we won't include the utf8 encoding
        fs.readFile('./images/cars1.jpg', function (errors, contents) {
            response.writeHead(200, {
                'Content-type': 'image/jpg'
            });
            response.write(contents);
            response.end();
        })
    } else if (request.url === '/images/cars2.jpg') {
        // notice we won't include the utf8 encoding
        fs.readFile('./images/cars2.jpg', function (errors, contents) {
            response.writeHead(200, {
                'Content-type': 'image/jpg'
            });
            response.write(contents);
            response.end();
        })
    } else if (request.url === '/images/cars3.jpg') {
        // notice we won't include the utf8 encoding
        fs.readFile('./images/cars3.jpg', function (errors, contents) {
            response.writeHead(200, {
                'Content-type': 'image/jpg'
            });
            response.write(contents);
            response.end();
        })
    } else if (request.url === '/images/cats1.jpg') {
        // notice we won't include the utf8 encoding
        fs.readFile('./images/cats1.jpg', function (errors, contents) {
            response.writeHead(200, {
                'Content-type': 'image/jpg'
            });
            response.write(contents);
            response.end();
        })
    }else if (request.url === '/images/cats2.jpg') {
        // notice we won't include the utf8 encoding
        fs.readFile('./images/cats2.jpg', function (errors, contents) {
            response.writeHead(200, {
                'Content-type': 'image/jpg'
            });
            response.write(contents);
            response.end();
        })
    }else if (request.url === '/images/cats3.jpg') {
        // notice we won't include the utf8 encoding
        fs.readFile('./images/cats3.jpg', function (errors, contents) {
            response.writeHead(200, {
                'Content-type': 'image/jpg'
            });
            response.write(contents);
            response.end();
        })
    }

    // request didn't match anything:
    else {
        response.writeHead(404);
        response.end('File not found!!!');
    }
});
// tell your server which port to run on
server.listen(7077);
// print to terminal window
console.log("Running in localhost at port 7077");