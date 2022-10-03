angular.module("BibliotecaApp", []).controller("EditoraListarController", EditoraListarController);

EditoraListarController.$inject = ["$scope", "EditoraService"];

function EditoraListarController($scope, EditoraService) {

    $scope.editar = editar;
    $scope.excluir = excluir;

    _inicializar();

    function _inicializar() {
        recarregarTabela();
    }

    function editar(id) {
        EditoraService.consultar(id).then(function (response) {
            $scope.livro = response.data;
            $scope.autor = $scope.livro.autor;
            $scope.categoria = $scope.livro.categoria;
        })
    }

    function excluir(id) {
        EditoraService.excluir(id);
    }

    function recarregarTabela() {
        EditoraService.listar().then(function (response) {
            $scope.editoras = response.data;
        })
    }

}