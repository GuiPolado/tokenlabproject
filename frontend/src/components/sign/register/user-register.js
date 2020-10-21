import React from "react";
import { MDBFreeBird, MDBCol, MDBRow, MDBCardBody, MDBCardTitle, MDBBtn, MDBContainer, MDBEdgeHeader, MDBModal,MDBModalBody,MDBModalHeader,MDBModalFooter,Link } from
  "mdbreact";
import api from "../../services/api";
import {logar} from "../../services/auth";
import '../sign.css';

class Register extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      usuario: "",
      senha: "",
    };
  }

  checkCadastro = async () => {
    const usuario = this.state.usuario;
    const senha = this.state.senha;
    api.post('/user', { usuario, senha})
      .then(res => {
        if (res.data === true) {
          logar(usuario);
          alert("Usuário cadastrado com sucesso!");
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
    if (this.validateForm()) {
      this.checkCadastro();
    }
    else {
      console.log("ERROR: Algum campo está NULL");
    }

  };

  changeHandler = event => {
    this.setState({ [event.target.name]: event.target.value });
  };

  toggleCheckbox = () => {
    this.setState({ checkbox: !this.state.checkbox });
  };

  toggleModal = () => {
    this.setState({ modal: !this.state.modal });
  }

  validateForm = () => {
    return (
      this.state.usuario.length > 0 &&
      this.state.senha.length > 0 
    );
  }
  render() {
    return (

      <MDBContainer className="mt-3">
        <MDBContainer>
          <MDBModal isOpen={this.state.modal} toggle={this.toggleModal}>
            <MDBModalHeader toggle={this.toggleModal}>ERRO</MDBModalHeader>
            <MDBModalBody>
              Usuário já existe !
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
                <MDBCardTitle className = "headCard">Registro
                <Link className="btnLink voltar" to="/sign"><MDBBtn color="mdb-color" className="text-xs-left " type="submit" >Voltar</MDBBtn></Link>
                </MDBCardTitle>
                <form
                  className="needs-validation"
                  onSubmit={this.submitHandler}
                  noValidate
                >                 
                  <MDBRow>
                    <MDBCol md="4" className="mb-3">
                      <label
                        htmlFor="usuario"
                        className="grey-text"
                      >
                        Usuário
                </label>
                      <input
                        onChange={this.changeHandler}
                        type="text"
                        id="usuario"
                        className="form-control"
                        name="usuario"
                        placeholder=""
                        required
                      />
                      <div className="invalid-feedback">
                        Usuário inválido.
                </div>
                    </MDBCol>
                    <MDBCol md="4" className="mb-3">
                      <label
                        htmlFor="senha"
                        className="grey-text"
                      >
                        Senha
                </label>
                      <input
                        onChange={this.changeHandler}
                        type="password"
                        id="senha"
                        className="form-control"
                        name="senha"
                        placeholder=""
                        required
                      />
                      <div className="invalid-feedback">
                        Senha inválida
                </div>
                    </MDBCol>
                  </MDBRow>
                  <MDBBtn color="mdb-color" type="submit">
                    Registrar-se
            </MDBBtn>
                </form>
              </MDBCardBody>
            </MDBCol>
          </MDBRow>
        </MDBFreeBird>
      </MDBContainer>
    );
  };
}
export default Register;