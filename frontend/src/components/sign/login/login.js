import React from "react";
import { MDBFreeBird, MDBInput, MDBCol, MDBRow, MDBCardBody, MDBCardTitle, MDBBtn, MDBContainer, MDBEdgeHeader,MDBModal,MDBModalBody,MDBModalFooter,MDBModalHeader,Link } from
  "mdbreact";
import api from "../../services/api";
import {logar} from '../../services/auth';
import '../sign.css';

class Login extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      usuario: null,
      senha: null,
      modal: false
    };
  }

  toggleModal = () => {
    this.setState({ modal: !this.state.modal });
  }

  checkUser = async () => {
    const login = this.state.usuario;
    const senha = this.state.senha;
    api.post('/login', { login, senha })
      .then(res => {
        if (res.data === true) {
          logar(login);
          this.props.history.push('/initial-page');
        }
        else {
          this.toggleModal();
        }
      })

  };

  submitHandler = event => {
    event.preventDefault();
    event.target.className += " was-validated";
    this.checkUser();
  };

  changeHandler = event => {
    this.setState({ [event.target.name]: event.target.value });
  };

  render() {
    return (
      <MDBContainer className="mt-3">
        <MDBContainer>
          <MDBModal isOpen={this.state.modal} toggle={this.toggleModal}>
            <MDBModalHeader toggle={this.toggleModal}>ERRO</MDBModalHeader>
            <MDBModalBody>
              Login/Senha inválidos!
        </MDBModalBody>
            <MDBModalFooter>
              <MDBBtn color="mdb-color" onClick={this.toggleModal}>Close</MDBBtn>
            </MDBModalFooter>
          </MDBModal>
        </MDBContainer>

        <MDBEdgeHeader color="mdb-color darken-2"></MDBEdgeHeader>
        <MDBFreeBird>
          <MDBRow>
            <MDBCol md="8" lg="7" className="mx-auto float-none white z-depth-1 py-2 px-2">
              <MDBCardBody>
                <MDBCardTitle className = "headCard">Login
                <Link className="btnLink voltar" to="/sign"><MDBBtn color="mdb-color" className="text-xs-left " type="submit" >Voltar</MDBBtn></Link>
                </MDBCardTitle>
                <form
                  className="needs-validation"
                  onSubmit={this.submitHandler}
                  noValidate
                >
                  <MDBInput name="usuario" label="Usuário" group type="text" icon="user" onChange={this.changeHandler} required />
                  <MDBInput name="senha" label="Senha" group type="password" icon="lock" onChange={this.changeHandler} required />

                  <div className="text-center">
                    <MDBBtn color="mdb-color" className="text-xs-left" type="submit" >Login</MDBBtn>
                  </div>
                </form>
                <div className="my-2">
                </div>
              </MDBCardBody>
            </MDBCol>
          </MDBRow>
        </MDBFreeBird>
      </MDBContainer>
    );
  }
};

export default Login;