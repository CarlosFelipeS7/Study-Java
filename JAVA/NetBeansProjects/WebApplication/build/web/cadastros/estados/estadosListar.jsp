<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<div class="container-fluid">
    <h1 class="h3 mb-2 text-gray-800">Estados</h1>
    <p class="mb-4">Lista de Estados Cadastrados</p>

    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">
                Estados
                <a href="/WebApplication/cadastros/estados/estadoCadastrar.jsp" 
                   class="btn btn-success btn-sm float-right">
                    <i class="fas fa-plus"></i> Novo Estado
                </a>
            </h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nome do Estado</th>
                            <th>Sigla</th>
                            <th>Ações</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${estados}" var="estado">
                            <tr>
                                <td>${estado.id}</td>
                                <td>${estado.nomeEstado}</td>
                                <td>${estado.siglaEstado}</td>
                                <td>
                                    <a href="/WebApplication/EstadoCarregar?id=${estado.id}" 
                                       class="btn btn-warning btn-sm">
                                        <i class="fas fa-edit"></i> Editar
                                    </a>
                                    <button onclick="excluirEstado(${estado.id}, '${estado.nomeEstado}')" 
                                            class="btn btn-danger btn-sm">
                                        <i class="fas fa-trash"></i> Excluir
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<script>
    function excluirEstado(id, nome) {
        Swal.fire({
            title: 'Confirmar Exclusão',
            text: 'Deseja realmente excluir o estado ' + nome + '?',
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#d33',
            cancelButtonColor: '#3085d6',
            confirmButtonText: 'Sim, excluir!',
            cancelButtonText: 'Cancelar'
        }).then((result) => {
            if (result.isConfirmed) {
                $.ajax({
                    type: 'post',
                    url: '/WebApplication/EstadoExcluir',  <!-- CORREÇÃO -->
                    data: { id: id },
                    success: function (data) {
                        if (data == 1) {
                            Swal.fire({
                                position: 'center',
                                icon: 'success',
                                title: 'Estado excluído com sucesso!',
                                showConfirmButton: false,
                                timer: 2000
                            }).then(function () {
                                location.reload();
                            });
                        } else {
                            Swal.fire({
                                position: 'center',
                                icon: 'error',
                                title: 'Erro ao excluir estado!',
                                showConfirmButton: true,
                                timer: 5000
                            });
                        }
                    },
                    error: function () {
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
        });
    }
</script>

<jsp:include page="/footer.jsp"/>