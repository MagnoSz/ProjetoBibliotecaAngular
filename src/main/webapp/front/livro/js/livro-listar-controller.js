angular.module("BibliotecaApp", []).controller("LivroListarController", LivroListarController);

LivroListarController.$inject = ["$scope", "LivroService"];

function LivroListarController($scope, LivroService) {

    $scope.editar = editar;
    $scope.excluir = excluir;

    _inicializar();

    function _inicializar() {
        recarregarTabela();
    }

    function editar(id) {
        LivroService.consultar(id).then(function (response) {
            $scope.livro = response.data;
            $scope.autor = $scope.livro.autor;
            $scope.categoria = $scope.livro.categoria;
        })
    }

    function excluir(id) {
        LivroService.excluir(id);
    }

    function recarregarTabela() {
        LivroService.listar().then(function (response) {
            $scope.livros = response.data;
        })
    }

}