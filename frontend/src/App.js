import React, { Component } from 'react';
import { createBrowserHistory } from "history";
import { Router, Route, Switch, Redirect } from "react-router-dom";
import Login from './components/sign/login/login';
import Footer from './components/footer/footer';
import Register from './components/sign/register/user-register';
import Sign from './components/sign/sign';
import InitialPage from './components/initial-page/initial-page';
import EventRegister from './components/initial-page/event-register/event-register';
//import { isAuthenticated } from "./components/services/auth";
import './index.css';

var hist = createBrowserHistory();

/*const PrivateRoute = ({ component: Component, ...rest }) => (
  <Route
    {...rest}
    render={props =>
      isAuthenticated() ? (
        <Component {...props} />
      ) : (
        <Redirect to={{ pathname: "/", state: { from: props.location } }} />
      )
    }
  />
);*/

class App extends Component {

  render() {

    return (
      <div className="position-relative">
        <Router history={hist}>
          <Switch>
            <Route exact={true} path="/sign" component={Sign} />
            <Route exact={true} path="/login" component={Login} />
            <Route exact={true} path="/user-register" component={Register} />
            <Route exact={true} path="/initial-page" component={InitialPage} />
            <Route exact={true} path="/event-register" component={EventRegister} />
            <Route exact={true} path="/" component={Sign} />
          </Switch>
        </Router>
        <Footer />
      </div>
    );
  }
}
export default App;