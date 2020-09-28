# frontend-web


### Running the App

An angular application to showcase an example implementation of the frontend-web assignment. This project does not include the source code. Inorder for the app to run correctly the backend `Employees (registry.jar)` service needs to be running on port 8080.

First you need to install the `angular-http-server` to serve the application:

```Shell
npm install -g angular-http-server
```
Then run the http server and provide the path to the app and a port to listen to:

```Shell
angular-http-server --path ./dist/frontend-web/ -p 4200
```

To see the application visit http://localhost:4200

More Info on the angular http server can be found here: [Angular-Http-Server](https://github.com/simonh1000/angular-http-server)
