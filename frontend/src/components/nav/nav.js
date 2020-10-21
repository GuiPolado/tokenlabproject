import React, { Component } from "react";
import {
  MDBNavbar, MDBNavbarBrand, MDBNavbarNav, MDBNavItem, MDBNavbarToggler, MDBCollapse, MDBDropdown,
  MDBDropdownToggle, MDBDropdownMenu, MDBDropdownItem, MDBIcon, Link
} from "mdbreact";
import { getToken, logout } from "../services/auth";

class NavbarPage extends Component {
  constructor(props){
    super(props);
    this.state = {
      isOpen: false
    };
  }
  
  toggleCollapse = () => {
    this.setState({ isOpen: !this.state.isOpen });
  }

  render() {
    return (
        <MDBNavbar color="mdb-color" dark expand="md">
          <MDBNavbarBrand>
            <strong className="white-text">TokenLabProject</strong>
          </MDBNavbarBrand>
          <MDBNavbarToggler onClick={this.toggleCollapse} />
          <MDBCollapse id="navbarCollapse3" isOpen={this.state.isOpen} navbar>
            <MDBNavbarNav right>
              <MDBNavItem>
                <MDBDropdown dropleft>
                  <MDBDropdownToggle nav caret>
                    <MDBIcon icon="user" /> {getToken()}
                </MDBDropdownToggle>
                  <MDBDropdownMenu className="dropdown-default">
                    <Link to="/sign" onClick={() => logout()}><MDBDropdownItem>Logout</MDBDropdownItem></Link>
                  </MDBDropdownMenu>
                </MDBDropdown>
              </MDBNavItem>
            </MDBNavbarNav>
          </MDBCollapse>
        </MDBNavbar>
    );
  }
}

export default NavbarPage;