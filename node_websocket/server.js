const fs = require('fs');
const https = require('https');
const WebSocket = require('ws');

const server = https.createServer({
  cert: fs.readFileSync('C://Users//eparz//go//Projects//personal_projects//golf-android-app//node_websocket//server.cert'),
  key: fs.readFileSync('C://Users//eparz//go//Projects//personal_projects//golf-android-app//node_websocket//server.key')
});
const wss = new WebSocket.Server({ server });

console.log("Started Server")

wss.on('connection', function connection(ws) {
  console.log("Init Connection");
  ws.on('message', function incoming(message) {
    console.log('received: %s', message);
  });

  ws.send('something');
});

server.listen(8080, function listening() {
  //
  // If the `rejectUnauthorized` option is not `false`, the server certificate
  // is verified against a list of well-known CAs. An 'error' event is emitted
  // if verification fails.
  //
  // The certificate used in this example is self-signed so `rejectUnauthorized`
  // is set to `false`.
  //
  const ws = new WebSocket(`wss://localhost:${server.address().port}`, {
    rejectUnauthorized: false
  });

  ws.on('open', function open() {
    ws.send('All glory to WebSockets!');
  });
});

console.log(`wss://localhost:${server.address().port}`);