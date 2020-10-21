import React, { Component } from 'react';
import {Link} from 'react-router-dom';
import Nav from '../nav/nav';
import { MDBFreeBird, MDBCol, MDBRow, MDBCardBody, MDBCardTitle, MDBBtn, MDBContainer, MDBEdgeHeader } from
  "mdbreact";
import "./initial-page.css";
import api from "../services/api";
import {getToken} from "../services/auth";

class Page extends Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <div className="full-page">
        <Nav />
        <MDBContainer className="mt-3">
          <MDBEdgeHeader color="mdb-color darken-2"></MDBEdgeHeader>
          <MDBFreeBird>
            <MDBRow>
              <MDBCol md="8" lg="7" className="mx-auto float-none white z-depth-1 py-2 px-2">
                <MDBCardTitle className="justify-center" >Menu</MDBCardTitle>
                <MDBCardBody>
                    <MDBCol md='12' className="mb-4 justify-center">
                    <Link className="btnLink" to="/event-register" ><MDBBtn color="mdb-color"  className="btn">Cadastrar Evento</MDBBtn></Link>
                      </MDBCol>                          
                </MDBCardBody>
              </MDBCol>
            </MDBRow>
          </MDBFreeBird>
        </MDBContainer>
      </div>
    );
  }
}
export default Page;