import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import Nav from '../nav/nav';
import { MDBFreeBird, MDBCol, MDBRow, MDBCardBody, MDBCardTitle, MDBBtn, MDBContainer, MDBEdgeHeader, MDBModal, MDBModalHeader, MDBModalBody, MDBModalFooter } from
  "mdbreact";
import "./initial-page.css";
import api from "../services/api";
import { getToken } from "../services/auth";

class Page extends Component {
  constructor(props) {
    super(props);
    this.state = {
      eventos: [],
      toggleModal: false,
      idEvento: null
    };
  }

  componentDidMount() {
    this.loadEventos();
  }

  loadEventos = async () => {
    const login = getToken();
    const response = await api.get("/user-events/" + login);

    this.setState({ eventos: response.data });
  }

  toggleExclude = id => {
    this.setState({ idEvento: id });
    this.setState({ toggleModal: !this.state.toggleModal })
  }

  exclude = () => {
    api.post('/delete/' + this.state.idEvento)
      .then(res => {
        if (res.data === true) {
          alert("Evento Removido com Sucesso!");
          this.toggleExclude(null);
          window.location.reload(false);
        }
        else {
          alert("Erro, evento não existente")
        }
      });
  }

  goToEdit = id => {
    this.props.history.push({
      pathname: '/event-edit',
      state: {idEvento: id}  
  })
  }

  timestampToHuman = date => {
    var d = new Date(date);
    return (d.getDate() === 31 ? '01' : d.getDate() + 1) + '/' + (d.getMonth() + 1) + '/' + d.getFullYear()
  }
  render() {
    return (
      <div className="full-page">
        <Nav />
        <MDBContainer className="mt-3">
          <MDBContainer>
            <MDBModal isOpen={this.state.toggleModal} toggle={this.toggleExclude}>
              <MDBModalHeader toggle={this.toggleModal}>Aviso</MDBModalHeader>
              <MDBModalBody>
                Deseja mesmo excluir esse evento?
                            </MDBModalBody>
              <MDBModalFooter className="justify-center">
                <MDBCol md="5" className="mb-3"> <MDBBtn color="mdb-color" className="modalBtn" onClick={() => this.toggleExclude(null)}>Cancelar</MDBBtn></MDBCol>
                <MDBCol md="5" className="mb-3"><MDBBtn color="red" className="modalBtn" onClick={() => this.exclude()} to="">Excluir</MDBBtn> </MDBCol>
              </MDBModalFooter>
            </MDBModal>
          </MDBContainer>
          <MDBEdgeHeader color="mdb-color darken-2"></MDBEdgeHeader>
          <MDBFreeBird>
            <MDBRow>
              <MDBCol md="8" lg="7" className="mx-auto float-none white z-depth-1 py-2 px-2">
                <MDBCardTitle className="justify-center" >Eventos</MDBCardTitle>
                <MDBCardBody>
                  {this.state.eventos.map((evento) => (
                    <MDBCol key={evento.idEvento} md="8" lg="10" className="mx-auto float-none white z-depth-1 py-2 px-2 mb-4" >
                      <MDBRow>
                        <MDBCol md="5" className="mb-3">
                          <label
                            htmlFor="dataInicio"
                            className="grey-text labelSpace"
                          >
                            Data Início:
                          </label>
                          {this.timestampToHuman(evento.dataInicio)}
                        </MDBCol>
                        <MDBCol md="5" className="mb-3">
                          <label
                            htmlFor="dataFim"
                            className="grey-text labelSpace"
                          >
                            Data Fim:
                                            </label>
                          {this.timestampToHuman(evento.dataFim)}
                        </MDBCol>
                      </MDBRow>
                      <MDBRow>
                        <MDBCol md="5" className="mb-3">
                          <label
                            htmlFor="horaInicio"
                            className="grey-text labelSpace"
                          >
                            Horário Início:
                                            </label>
                          {evento.horaInicio}
                        </MDBCol>
                        <MDBCol md="5" className="mb-3">
                          <label
                            htmlFor="horaFim"
                            className="grey-text labelSpace"
                          >
                            Horário Fim:
                                            </label>
                          {evento.horaFim}
                        </MDBCol>
                      </MDBRow>
                      <MDBRow className="center">
                        <label
                          htmlFor="Descricao"
                          className="grey-text labelSpace"
                        >
                          Descrição:
                        </label>
                        {evento.descricao}
                      </MDBRow>
                      <MDBRow className="justify-center">
                        <MDBCol md="5" className="mb-3">
                          <MDBBtn color="red" type="submit" onClick={() => this.toggleExclude(evento.idEvento)}>
                            Excluir
                        </MDBBtn>
                        </MDBCol>
                        <MDBCol md="5" className="mb-3">
                          <MDBBtn color="mdb-color" className="btn" onClick={() => this.goToEdit(evento.idEvento)}>Editar</MDBBtn> 
                        </MDBCol>
                      </MDBRow>
                    </MDBCol>
                  ))}
                  <MDBCol md='12' className="mb-4 justify-center">
                    <Link className="btnLink" to="/event-register" ><MDBBtn color="mdb-color" className="btn">Cadastrar Evento</MDBBtn></Link>
                  </MDBCol>
                </MDBCardBody>
              </MDBCol>
            </MDBRow>
          </MDBFreeBird>
        </MDBContainer>
      </div >
    );
  }
}
export default Page;