<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<div class="container-fluid">
    <h1 class="h3 mb-2 text-gray-800">Estados</h1>
    <p class="mb-4">Formulário de Cadastro</p>

    <a class="btn btn-secondary mb-4" href="/WebApplication/EstadoListar">
        <i class="fas fa-undo-alt"></i>
        <strong>Voltar</strong>
    </a>
    
    <div class="row">
        <div class="col-lg-6">
            <div class="card shadow mb-4">
                <div class="card-body">
                    <form id="formEstado">
                        <div class="form-group">
                            <label>Id</label>
                            <input class="form-control" type="text" name="id" id="id" 
                                   value="${estado.id}" readonly="readonly"/>
                        </div>
                        <div class="form-group">
                            <label>Nome do Estado</label>
                            <input class="form-control" type="text" name="nomeEstado" id="nomeEstado" 
                                   value="${estado.nomeEstado}" maxlength="100" required
                                   placeholder="Digite o nome do estado"/>
                        </div>
                        <div class="form-group">
                            <label>Sigla</label>
                            <input class="form-control" type="text" name="siglaEstado" id="siglaEstado" 
                                   value="${estado.siglaEstado}" maxlength="2" required
                                   placeholder="Digite a sigla (2 caracteres)"/>
                            <span id="msgSigla" class="form-text"></span>
                        </div>
                        <div class="form-group">
                            <button class="btn btn-success" type="button" id="submit" onclick="validarCampos()">
                                <i class="fas fa-save"></i> Salvar Estado
                            </button>
                        </div> 
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    let siglaValida = false;
    let validandoSigla = false; // Variável para controlar se já está validando

    $(document).ready(function () {
        // Validação da sigla em tempo real
        $('#siglaEstado').blur(function () {
            if (!validandoSigla) {
                validarSigla();
            }
        });
        
        // Limpar mensagem quando usuário digitar
        $('#siglaEstado').on('input', function() {
            $('#msgSigla').html('');
            siglaValida = false;
            validandoSigla = false;
        });
        
        $('#nomeEstado').focus();
    });
    
    function validarSigla() {
        validandoSigla = true;
        var sigla = $('#siglaEstado').val().trim().toUpperCase();
        var idEstado = $('#id').val();
        
        if (sigla === "") {
            $('#msgSigla').html("<span class='text-warning'>Informe a sigla</span>");
            siglaValida = false;
            validandoSigla = false;
            return;
        }
        
        // Validar se tem 2 caracteres
        if (sigla.length !== 2) {
            $('#msgSigla').html("<span class='text-danger'>Sigla deve ter 2 caracteres</span>");
            siglaValida = false;
            validandoSigla = false;
            
            Swal.fire({
                position: 'center',
                icon: 'error',
                title: 'Sigla inválida!',
                text: 'A sigla deve ter exatamente 2 caracteres.',
                showConfirmButton: true,
                timer: 4000
            });
            return;
        }
        
        // Converter para maiúsculo
        $('#siglaEstado').val(sigla);
        
        // Verificar duplicidade no servidor
        if (idEstado == 0 || sigla !== '${estado.siglaEstado}') {
            $.ajax({
                type: 'get',
                url: '/WebApplication/EstadoVerificarSigla',
                data: { 
                    sigla: sigla,
                    id: idEstado
                },
                success: function (response) {
                    console.log("Resposta validação sigla: ", response);
                    
                    if (response == 1) {
                        $('#msgSigla').html("<span class='text-danger'>Sigla já cadastrada!</span>");
                        siglaValida = false;
                        
                        // REMOVIDO o .then() que causava o loop
                        Swal.fire({
                            position: 'center',
                            icon: 'warning',
                            title: 'Sigla já cadastrada!',
                            text: 'Por favor, informe outra sigla.',
                            showConfirmButton: true,
                            timer: 4000
                        });
                        
                    } else if (response == 0) {
                        $('#msgSigla').html("<span class='text-success'>Sigla disponível.</span>");
                        siglaValida = true;
                    } else {
                        $('#msgSigla').html("<span class='text-warning'>Erro na validação</span>");
                        siglaValida = false;
                    }
                    validandoSigla = false;
                },
                error: function () {
                    $('#msgSigla').html("<span class='text-warning'>Erro na validação</span>");
                    siglaValida = false;
                    validandoSigla = false;
                }
            });
        } else {
            siglaValida = true;
            validandoSigla = false;
        }
    }
    
    function validarCampos() {
        if ($("#nomeEstado").val().trim() === '') {
            Swal.fire({
                position: 'center',
                icon: 'error',
                title: 'Informe o nome do estado!',
                showConfirmButton: false,
                timer: 2000
            });
            $("#nomeEstado").focus();
            return;
        }
        
        if ($("#siglaEstado").val().trim() === '') {
            Swal.fire({
                position: 'center',
                icon: 'error',
                title: 'Informe a sigla!',
                showConfirmButton: false,
                timer: 2000
            });
            $("#siglaEstado").focus();
            return;
        }
        
        if (!siglaValida) {
            Swal.fire({
                position: 'center',
                icon: 'warning',
                title: 'Verifique a sigla!',
                text: 'A sigla precisa ser validada antes do envio.',
                showConfirmButton: false,
                timer: 2000
            });
            $("#siglaEstado").focus();
            return;
        }
        
        gravarDados();
    }
    
    function gravarDados() {
        console.log("Gravando estado...");
        
        Swal.fire({
            title: 'Salvando...',
            text: 'Por favor, aguarde.',
            allowOutsideClick: false,
            didOpen: () => {
                Swal.showLoading()
            }
        });
        
        $.ajax({
            type: 'post',
            url: '/WebApplication/EstadoCadastrar',
            data: {
                id: $('#id').val(),
                nomeEstado: $('#nomeEstado').val().toUpperCase(),
                siglaEstado: $('#siglaEstado').val().toUpperCase()
            },
            success: function (data) {
                Swal.close();
                console.log("Resposta do servidor: " + data);
                
                switch(parseInt(data)) {
                    case 1:
                        Swal.fire({
                            position: 'center',
                            icon: 'success',
                            title: 'Sucesso!',
                            text: 'Estado salvo com sucesso.',
                            showConfirmButton: true,
                            timer: 3000
                        }).then(function () {
                            window.location.href = '/WebApplication/EstadoListar';
                        });
                        break;
                    case 2:
                        Swal.fire({
                            position: 'center',
                            icon: 'error',
                            title: 'Erro!',
                            text: 'Não foi possível salvar o estado.',
                            showConfirmButton: true,
                            timer: 5000
                        });
                        break;
                    case 5:
                        Swal.fire({
                            position: 'center',
                            icon: 'error',
                            title: 'Dados em branco!',
                            text: 'Verifique todos os campos.',
                            showConfirmButton: true,
                            timer: 5000
                        });
                        break;
                    case 6:
                        Swal.fire({
                            position: 'center',
                            icon: 'error',
                            title: 'Sigla já existe!',
                            text: 'Por favor, informe outra sigla.',
                            showConfirmButton: true,
                            timer: 5000
                        });
                        break;
                    case 7:
                        Swal.fire({
                            position: 'center',
                            icon: 'error',
                            title: 'Sigla inválida!',
                            text: 'A sigla deve ter 2 caracteres.',
                            showConfirmButton: true,
                            timer: 5000
                        });
                        break;
                    default:
                        Swal.fire({
                            position: 'center',
                            icon: 'error',
                            title: 'Erro desconhecido!',
                            showConfirmButton: true,
                            timer: 5000
                        });
                }
            },
            error: function () {
                Swal.close();
                Swal.fire({
                    position: 'center',
                    icon: 'error',
                    title: 'Erro de comunicação',
                    text: 'Falha na conexão com o servidor.',
                    showConfirmButton: true,
                    timer: 5000
                });
            }
        });
    }
</script>   

<jsp:include page="/footer.jsp"/>