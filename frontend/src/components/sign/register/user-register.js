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
      nome: "",
      cpf: "",
      email: "",
      usuario: "",
      senha: "",
      telefoneResidencial: "",
      telefoneComercial: "",
      celular: "",
      checkbox: false,
      modal: false
    };
  }

  checkCadastro = async () => {
    const nome = this.state.nome;
    const cpf = this.state.cpf;
    const email = this.state.email;
    const usuario = this.state.usuario;
    const senha = this.state.senha;
    const telefoneResidencial = this.state.telefoneResidencial;
    const telefoneComercial = this.state.telefoneComercial;
    const celular = this.state.celular;
    api.post('/user', { nome, cpf, email, usuario, senha, telefoneResidencial, telefoneComercial, celular })
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
      this.state.nome.length > 0 &&
      this.state.cpf.length > 0 &&
      this.state.email.length > 0 &&
      this.state.usuario.length > 0 &&
      this.state.senha.length > 0 &&
      this.state.telefoneComercial.length > 0 &&
      this.state.telefoneResidencial.length > 0 &&
      this.state.celular.length > 0 &&
      this.state.checkbox === true
    );
  }
  render() {
    return (

      <MDBContainer className="mt-3">
        <MDBContainer>
          <MDBModal isOpen={this.state.modal} toggle={this.toggleModal}>
            <MDBModalHeader toggle={this.toggleModal}>ERRO</MDBModalHeader>
            <MDBModalBody>
              CPF ou Usuário já existem !
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
                        htmlFor="nome"
                        className="grey-text"
                      >
                        Nome
                </label>
                      <input
                        name="nome"
                        onChange={this.changeHandler}
                        type="text"
                        id="nome"
                        className="form-control"
                        placeholder=""
                        required
                      />
                      <div className="invalid-feedback">
                        Nome inválido.
                </div>
                    </MDBCol>
                    <MDBCol md="4" className="mb-3">
                      <label
                        htmlFor="cpf"
                        className="grey-text"
                      >
                        CPF
                </label>
                      <input
                        name="cpf"
                        onChange={this.changeHandler}
                        type="text"
                        id="cpf"
                        className="form-control"
                        placeholder=""
                        required
                      />
                      <div className="invalid-feedback">
                        CPF inválido.
                </div>
                    </MDBCol>
                    <MDBCol md="4" className="mb-3">
                      <label
                        htmlFor="email"
                        className="grey-text"
                      >
                        Email
                </label>
                      <input
                        onChange={this.changeHandler}
                        type="email"
                        id="email"
                        className="form-control"
                        name="email"
                        placeholder=""
                        required
                      />
                      <div className="invalid-feedback">
                        E-mail inválido.
                </div>
                    </MDBCol>
                  </MDBRow>
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
                  <MDBRow>
                    <MDBCol md="4" className="mb-3">
                      <label
                        htmlFor="telefoneResidencial"
                        className="grey-text"
                      >
                        Telefone
                </label>
                      <input
                        name="telefoneResidencial"
                        onChange={this.changeHandler}
                        type="tel"
                        id="telefoneResidencial"
                        className="form-control"
                        placeholder=""
                        required
                      />
                      <div className="invalid-feedback">
                        Número inválido.
                </div>
                    </MDBCol>
                    <MDBCol md="4" className="mb-3">
                      <label
                        htmlFor="telefoneComercial"
                        className="grey-text"
                      >
                        Telefone Comercial
                </label>
                      <input
                        name="telefoneComercial"
                        onChange={this.changeHandler}
                        type="tel"
                        id="telefoneComercial"
                        className="form-control"
                        placeholder=""
                        required
                      />
                      <div className="invalid-feedback">
                        Número inválido.
                </div>
                    </MDBCol>
                    <MDBCol md="4" className="mb-3">
                      <label
                        htmlFor="celular"
                        className="grey-text"
                      >
                        Celular
                </label>
                      <input
                        onChange={this.changeHandler}
                        type="tel"
                        id="celular"
                        className="form-control"
                        name="celular"
                        placeholder=""
                        required
                      />
                      <div className="invalid-feedback">
                        Número inválido.
                </div>
                    </MDBCol>
                  </MDBRow>
                  <MDBCol md="4" className="mb-3">
                    <div className="custom-control custom-checkbox pl-3">
                      <input
                        onChange={this.toggleCheckbox}
                        className="custom-control-input"
                        type="checkbox"
                        value=""
                        id="invalidCheck"
                        name="checkbox"
                        required
                      />
                      <label className="custom-control-label" htmlFor="invalidCheck">
                        Aceito os termos de condições.
                </label>
                      <div className="invalid-feedback">
                        Você deve aceitar os termos.
                </div>
                    </div>
                  </MDBCol>
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