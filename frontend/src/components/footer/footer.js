
import React from "react";
import {MDBContainer, MDBFooter } from "mdbreact";
import "./footer.css";

const FooterPage = () => {
  return (
    <MDBFooter color="mdb-color" className="font-small pt-4 mt-4 footer">
      <div className="footer-copyright text-center py-3">
        <MDBContainer fluid>
          &copy; {new Date().getFullYear()} Copyright: TokenLabProject
        </MDBContainer>
      </div>
    </MDBFooter>
  );
}

export default FooterPage;