<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<div class="container-fluid">
    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Usu�rios</h1>
    <p class="mb-4">Formul�rio de Cadastro</p>

    <a class="btn btn-secondary mb-4" href="${pageContext.request.contextPath}/UsuarioListar">
        <i class="fas fa-undo-alt"></i>
        <strong>Voltar</strong>
    </a>
    <div class="row">
        <!-- Campos de cadastramento -->        
        <div class="col-lg-9">
            <div class="card shadow mb-4">
                <div class="card-body">
                    <form id="formUsuario">
                        <div class="form-group">
                            <label>Id</label>
                            <input class="form-control" type="text" name="id" id="id" 
                                   value="${usuario.id}" readonly="readonly"/>
                        </div>
                        <div class="form-group">
                            <label>Nome</label>
                            <input class="form-control" type="text" name="nome" id="nome" 
                                   value="${usuario.nome}" size="100" maxlength="100" required/>
                        </div>
                        <div class="form-group">
                            <label>CPF</label>
                            <input class="form-control" type="text" name="cpf" id="cpf" 
                                   value="${usuario.cpf}" size="11" maxlength="11" required/>
                            <span id="msgCpf"></span>
                        </div>
                        <div class="form-group">
                            <div class="form-line row">
                                <div class="col-sm">
                                    <label>Data de Nascimento</label>
                                    <input class="form-control" type="date" name="datanascimento" id="datanascimento" 
                                           value="${usuario.dataNascimento}" required/>
                                </div>
                                <div class="col-sm">
                                    <label>Valor do Sal�rio</label>
                                    <input class="form-control" type="text" style="text-align:right;" 
                                           name="salario" id="salario" 
                                           value="<fmt:formatNumber value='${usuario.salario}' type='currency'/>" required/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label>Email</label>
                            <input class="form-control" type="email" name="email" id="email" 
                                   value="${usuario.email}" size="100" maxlength="100" 
                                   required="true"/>
                            <span id="msgEmail" class="form-text"></span>
                        </div>
                        <div class="form-group">
                            <label>Senha</label>
                            <input class="form-control" type="password" name="senha" id="senha" 
                                   value="${usuario.senha}" size="100" maxlength="100" 
                                   required="true"/>
                        </div>
                        <!-- Bot�o de Confirma��o --> 
                        <div class="form-group">
                            <button class="btn btn-success" type="button" id="submit" onclick="validarCampos()">
                                Salvar Documento
                            </button>
                        </div> 
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    // Vari�veis para controle de valida��o
    let emailValido = false;
    let cpfValido = false;

    $(document).ready(function () {
        console.log("entrei na ready do documento");
        
        // M�scara monet�ria
        $("#salario").maskMoney({
            prefix: 'R$',
            suffix: '',
            allowZero: false,
            allowNegative: true,
            allowEmpty: false,
            doubleClickSelection: true,
            selectAllOnFocus: true,
            thousands: '.',
            decimal: ",",
            precision: 2,
            affixesStay: true,
            bringCareAtEndOnFocus: true
        });
        
        // Evento focus no CPF
        $('#cpf').focus(function(){
            trocaMascara();
            this.select();
        });
        
        // Valida��o de Email
        $('#email').blur(function () {
            validarEmail();
        });
        
        // Valida��o de CPF
        $('#cpf').blur(function () {
            validarCpf();
        });
        
        // Limpar mensagens quando o usu�rio come�ar a digitar
        $('#email').on('input', function() {
            $('#msgEmail').html('');
            emailValido = false;
        });
        
        $('#cpf').on('input', function() {
            $('#msgCpf').html('');
            cpfValido = false;
        });
        
        $('#nome').focus();
    });
    
    function validarEmail() {
        var email = $('#email').val().trim();
        var idUsuario = $('#id').val();
        
        if (email === "") {
            $('#msgEmail').html("<span class='text-warning'>Informe o e-mail</span>");
            emailValido = false;
            return;
        }
        
        // Valida��o b�sica de formato
        var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!emailRegex.test(email)) {
            $('#msgEmail').html("<span class='text-danger'>Formato de e-mail inv�lido</span>");
            emailValido = false;
            return;
        }
        
        // S� valida duplicidade se for inclus�o (id = 0) ou se o email foi alterado
        if (idUsuario == 0 || email !== '${usuario.email}') {
            $.ajax({
                type: 'get',
                url: 'UsuarioVerificarEmail',
                data: { email: email },
                success: function (response) {
                    console.log("Resposta valida��o email: " + response);
                    if (response.trim() === '1') {
                        $('#msgEmail').html("<span class='text-danger'>E-mail j� cadastrado!</span>");
                        emailValido = false;
                        Swal.fire({
                            position: 'center',
                            icon: 'warning',
                            title: 'E-mail j� cadastrado!',
                            text: 'Por favor, verifique o e-mail informado.',
                            showConfirmButton: true,
                            timer: 4000
                        }).then(function () {
                            $('#email').focus();
                        });
                    } else {
                        $('#msgEmail').html("<span class='text-success'>E-mail dispon�vel.</span>");
                        emailValido = true;
                    }
                },
                error: function () {
                    console.log("Erro ao verificar e-mail no servidor.");
                    $('#msgEmail').html("<span class='text-warning'>Erro na valida��o</span>");
                    emailValido = false;
                }
            });
        } else {
            emailValido = true;
        }
    }
    
   function validarEmail() {
    var email = $('#email').val().trim();
    var idUsuario = $('#id').val();
    
    if (email === "") {
        $('#msgEmail').html("<span class='text-warning'>Informe o e-mail</span>");
        emailValido = false;
        return;
    }
    
    // Valida��o b�sica de formato
    var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(email)) {
        $('#msgEmail').html("<span class='text-danger'>Formato de e-mail inv�lido</span>");
        emailValido = false;
        return;
    }
    
    // S� valida duplicidade se for inclus�o (id = 0) ou se o email foi alterado
    if (idUsuario == 0 || email !== '${usuario.email}') {
        $.ajax({
            type: 'get',
            url: 'UsuarioVerificarEmail',
            data: { email: email },
            success: function (response) {
                console.log("Resposta valida��o email: ", response);
                
                // CORRE��O: Converter para string antes de usar trim()
                var resposta = response.toString().trim();
                
                if (resposta === '1') {
                    $('#msgEmail').html("<span class='text-danger'>E-mail j� cadastrado!</span>");
                    emailValido = false;
                    Swal.fire({
                        position: 'center',
                        icon: 'warning',
                        title: 'E-mail j� cadastrado!',
                        text: 'Por favor, verifique o e-mail informado.',
                        showConfirmButton: true,
                        timer: 4000
                    }).then(function () {
                        $('#email').focus();
                    });
                } else if (resposta === '0') {
                    $('#msgEmail').html("<span class='text-success'>E-mail dispon�vel.</span>");
                    emailValido = true;
                } else {
                    $('#msgEmail').html("<span class='text-warning'>Erro na valida��o</span>");
                    emailValido = false;
                }
            },
            error: function (xhr, status, error) {
                console.log("Erro ao verificar e-mail: ", error);
                $('#msgEmail').html("<span class='text-warning'>Erro na valida��o</span>");
                emailValido = false;
            }
        });
    } else {
        emailValido = true;
    }
}

function validarCpf() {
    var cpfLimpo = $('#cpf').unmask().val();
    var idUsuario = $('#id').val();
    
    if (cpfLimpo === "") {
        $('#msgCpf').html("<span class='text-warning'>Informe o CPF</span>");
        cpfValido = false;
        return;
    }

    // Valida��o local do CPF
    if (!validarCpfCnpj(cpfLimpo)) {
        $('#msgCpf').html("<span class='text-danger'>CPF inv�lido</span>");
        cpfValido = false;
        Swal.fire({
            position: 'center',
            icon: 'error',
            title: 'CPF inv�lido!',
            showConfirmButton: true,
            timer: 4000
        });
        return;
    }

    // Valida��o no backend (s� para inclus�o ou se CPF foi alterado)
    if (idUsuario == 0 || cpfLimpo !== '${usuario.cpf}'.replace(/\D/g, '')) {
        $.ajax({
            type: 'get',
            url: 'UsuarioVerificarCpf',
            data: { cpf: cpfLimpo },
            success: function (response) {
                console.log("Resposta valida��o CPF: ", response);
                
                // CORRE��O: Converter para n�mero para compara��o
                var resposta = parseInt(response);
                
                if (resposta === 1) {
                    $('#msgCpf').html("<span class='text-danger'>CPF j� cadastrado!</span>");
                    cpfValido = false;
                    Swal.fire({
                        position: 'center',
                        icon: 'warning',
                        title: 'CPF j� cadastrado!',
                        text: 'Por favor, verifique o CPF informado.',
                        showConfirmButton: true,
                        timer: 4000
                    });
                } else if (resposta === 0) {
                    $('#msgCpf').html("<span class='text-success'>CPF v�lido</span>");
                    cpfValido = true;
                } else {
                    $('#msgCpf').html("<span class='text-warning'>Erro na valida��o</span>");
                    cpfValido = false;
                }
            },
            error: function (xhr, status, error) {
                console.log("Erro ao verificar CPF: ", error);
                $('#msgCpf').html("<span class='text-warning'>Erro na valida��o</span>");
                cpfValido = false;
            }
        });
    } else {
        cpfValido = true;
    }
    
    // Aplica a m�scara correta
    trocaMascara($('#cpf').val());
}
    
    function trocaMascara(cpfCnpj) {
        if (typeof cpfCnpj === 'undefined') {
            cpfCnpj = "";
        }

        cpfCnpj = cpfCnpj.trim();

        if (cpfCnpj !== "") {
            var masks = ['999.999.999-99', '99.999.999/9999-99'];
            var cpfcnpj = cpfCnpj.replace(/\D/g, '');
            var mask = (cpfcnpj.length > 11) ? masks[1] : masks[0];
            $('#cpf').unmask().mask(mask);
        } else {
            $('#cpf').unmask();
        }
    }

    function validarCampos() {
        console.log("Validando campos...");
        
        // Valida��es b�sicas
        if ($("#nome").val().trim() === '') {
            Swal.fire({
                position: 'center',
                icon: 'error',
                title: 'Informe o nome do usu�rio!',
                showConfirmButton: false,
                timer: 2000
            });
            $("#nome").focus();
            return;
        }
        
        if ($("#cpf").val().trim() === '') {
            Swal.fire({
                position: 'center',
                icon: 'error',
                title: 'Informe o CPF!',
                showConfirmButton: false,
                timer: 2000
            });
            $("#cpf").focus();
            return;
        }
        
        if ($("#email").val().trim() === '') {
            Swal.fire({
                position: 'center',
                icon: 'error',
                title: 'Informe o e-mail!',
                showConfirmButton: false,
                timer: 2000
            });
            $("#email").focus();
            return;
        }
        
        if ($("#senha").val().trim() === '') {
            Swal.fire({
                position: 'center',
                icon: 'error',
                title: 'Informe a senha!',
                showConfirmButton: false,
                timer: 2000
            });
            $("#senha").focus();
            return;
        }
        
        if ($("#datanascimento").val().trim() === '') {
            Swal.fire({
                position: 'center',
                icon: 'error',
                title: 'Informe a data de nascimento!',
                showConfirmButton: false,
                timer: 2000
            });
            $("#datanascimento").focus();
            return;
        }
        
        if ($("#salario").val().trim() === '') {
            Swal.fire({
                position: 'center',
                icon: 'error',
                title: 'Informe o valor do sal�rio!',
                showConfirmButton: false,
                timer: 2000
            });
            $("#salario").focus();
            return;
        }
        
        // Verifica se as valida��es espec�ficas est�o OK
        if (!emailValido) {
            Swal.fire({
                position: 'center',
                icon: 'warning',
                title: 'Verifique o e-mail!',
                text: 'O e-mail precisa ser validado antes do envio.',
                showConfirmButton: false,
                timer: 2000
            });
            $("#email").focus();
            return;
        }
        
        if (!cpfValido) {
            Swal.fire({
                position: 'center',
                icon: 'warning',
                title: 'Verifique o CPF!',
                text: 'O CPF precisa ser validado antes do envio.',
                showConfirmButton: false,
                timer: 2000
            });
            $("#cpf").focus();
            return;
        }
        
        // Se tudo estiver OK, grava os dados
        gravarDados();
    }
    
    function gravarDados() {
        console.log("Gravando dados...");
        
        // Mostra loading
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
            url: 'UsuarioCadastrar',
            data: {
                id: $('#id').val(),
                nome: $('#nome').val().toUpperCase(),
                cpf: $('#cpf').unmask().val(),
                datanascimento: $('#datanascimento').val(),
                salario: $('#salario').maskMoney('unmasked')[0], // Pega o valor num�rico
                email: $('#email').val(),
                senha: $('#senha').val()
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
                            text: 'Usu�rio salvo com sucesso.',
                            showConfirmButton: true,
                            timer: 3000
                        }).then(function () {
                            window.location.href = 'UsuarioListar';
                        });
                        break;
                    case 3:
                        Swal.fire({
                            position: 'center',
                            icon: 'error',
                            title: 'CPF inv�lido!',
                            showConfirmButton: true,
                            timer: 5000
                        });
                        break;
                    case 4:
                        Swal.fire({
                            position: 'center',
                            icon: 'error',
                            title: 'CPF j� cadastrado!',
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
                            title: 'E-mail j� cadastrado!',
                            text: 'Por favor, informe outro e-mail.',
                            showConfirmButton: true,
                            timer: 5000
                        }).then(function () {
                            $('#email').focus();
                        });
                        break;
                    default:
                        Swal.fire({
                            position: 'center',
                            icon: 'error',
                            title: 'Erro!',
                            text: 'N�o foi poss�vel salvar o usu�rio.',
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
                    title: 'Erro de comunica��o',
                    text: 'Falha na conex�o com o servidor.',
                    showConfirmButton: true,
                    timer: 5000
                });
            }
        });
    }
</script>   
<jsp:include page="/footer.jsp"/>