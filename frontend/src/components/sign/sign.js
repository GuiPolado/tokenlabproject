import React, { Component } from 'react';
import {Link} from 'react-router-dom';
import { MDBFreeBird, MDBCol, MDBRow, MDBCardBody, MDBCardTitle, MDBBtn, MDBContainer, MDBEdgeHeader } from
  "mdbreact";
import "./sign.css";
class Sign extends Component {

  render() {
    return (
        <MDBContainer className="mt-3">
          <MDBEdgeHeader color="mdb-color darken-2"></MDBEdgeHeader>
          <MDBFreeBird>
            <MDBRow>
              <MDBCol md="8" lg="7" className="mx-auto float-none white z-depth-1 py-2 px-2">
                <MDBCardTitle className="justify-center headCard" >Menu</MDBCardTitle>
                <MDBCardBody>
                    <MDBCol md='12' className="mb-4 justify-center">
                    <Link className="btnLink" to="/login"><MDBBtn color="mdb-color"  className="btn" >Efetuar Login</MDBBtn></Link>
                      </MDBCol>        
                    <MDBCol md='12' className="mb-4 justify-center">
                    <Link className="btnLink" to="/user-register"><MDBBtn color="mdb-color"  className="btn">Cadastrar Usuário</MDBBtn></Link>
                    </MDBCol>
                  
                </MDBCardBody>
              </MDBCol>
            </MDBRow>
          </MDBFreeBird>
        </MDBContainer>
    );
  }
}
export default Sign;