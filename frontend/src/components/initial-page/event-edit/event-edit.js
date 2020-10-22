import React from "react";
import { MDBFreeBird, MDBCol, MDBRow, MDBCardBody, MDBCardTitle, MDBBtn, MDBContainer, MDBEdgeHeader, MDBModal, MDBModalBody, MDBModalFooter, MDBModalHeader, Link } from
    "mdbreact";
import { getToken } from "../../services/auth";
import api from '../../services/api';


class EventEdit extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            horaInicio: "",
            horaFim: "",
            descricao: ""
        };
        const idEvento = this.props.location.state.idEvento;
        api.get('/event-editor/' + idEvento)
            .then(res => {
                if (res.data != null) {
                    this.setState({ horaInicio: res.data.horaInicio });
                    this.setState({ horaFim: res.data.horaFim });
                    this.setState({ descricao: res.data.descricao });
                }
                else {
                    console.log("Error");
                }
            });
    }

    checkCadastro = async () => {
        const horaInicio = this.state.horaInicio + ':00';
        const horaFim = this.state.horaFim + ':00';
        const descricao = this.state.descricao;
        const login = getToken();
        api.post('/event-register', { login, horaInicio, horaFim, descricao })
            .then(res => {
                if (res.data === true) {
                    alert("Evento Registrado com Sucesso!");
                    this.props.history.push('/initial-page');
                }
                else {
                    this.toggleModal();
                }
            })
    };

    submitHandler = event => {
        event.preventDefault()
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

    validateForm = () => {
        return (
            this.state.horaInicio.length > 0 &&
            this.state.horaFim.length > 0
        );
    }

    render() {
        return (
            <MDBContainer className="mt-3 test">

                <MDBEdgeHeader color="mdb-color darken-2"></MDBEdgeHeader>
                <MDBFreeBird>
                    <MDBRow>
                        <MDBCol md="8" lg="7" className="mx-auto float-none white z-depth-1 py-2 px-2">
                            <MDBCardBody>
                                <MDBCardTitle className="headCard">Edição de Evento
                                        <Link className="btnLink voltar" to="/initial-page"><MDBBtn color="mdb-color" className="text-xs-left " type="submit" >Voltar</MDBBtn></Link>
                                </MDBCardTitle>
                                <form
                                    className="needs-validation"
                                    onSubmit={this.submitHandler}
                                    noValidate
                                >
                                    <MDBRow>
                                        <MDBCol md="4" className="mb-3">
                                            <label
                                                htmlFor="horaInicio"
                                                className="grey-text"
                                            >
                                                Horário - Início
                                                </label>
                                            <input
                                                name="horaInicio"
                                                onChange={this.changeHandler}
                                                type="time"
                                                id="horaInicio"
                                                className="form-control"
                                                placeholder=""
                                                value={this.state.horaInicio}
                                                required
                                            />
                                            <div className="invalid-feedback">
                                                Horário inválido.
                                                 </div>
                                        </MDBCol>
                                        <MDBCol md="4" className="mb-3">
                                            <label
                                                htmlFor="horaFim"
                                                className="grey-text"
                                            >
                                                Horário - Fim
                                                </label>
                                            <input
                                                onChange={this.changeHandler}
                                                type="time"
                                                id="horaFim"
                                                className="form-control"
                                                name="horaFim"
                                                placeholder=""
                                                value={this.state.horaFim}
                                                required
                                            />
                                            <div className="invalid-feedback">
                                                Horário inválido.
                                                </div>
                                        </MDBCol>
                                    </MDBRow>
                                    <MDBRow className="align">
                                        <MDBCol md="8" className="mb-3">
                                            <label
                                                htmlFor="descricao"
                                                className="grey-text"
                                            >
                                                Descrição
                                                </label>
                                            <textarea
                                                onChange={this.changeHandler}
                                                id="descricao"
                                                step="any"
                                                className="form-control"
                                                name="descricao"
                                                placeholder=""
                                                value={this.state.descricao}
                                                required
                                            />
                                            <div className="invalid-feedback">
                                                Descrição inválida.
                                                </div>
                                        </MDBCol>
                                    </MDBRow>
                                    <MDBBtn color="mdb-color" type="submit">
                                        Salvar Evento
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
export default EventEdit;