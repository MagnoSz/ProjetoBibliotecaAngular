angular.module("BibliotecaApp", []).controller("AutorListarController", AutorListarController);

AutorListarController.$inject = ["$scope", "AutorService"];

function AutorListarController($scope, AutorService) {

    $scope.editar = editar;
    $scope.excluir = excluir;

    _inicializar();

    function _inicializar() {
        recarregarTabela();
    }

    function editar(id) {
        AutorService.consultar(id).then(function (response) {
            $scope.autor = response.data;
            $scope.livros = $scope.autor.livros;
        })
    }

    function excluir(id) {
        AutorService.excluir(id);
    }

    function recarregarTabela() {
        AutorService.listar().then(function (response) {
            $scope.autores = response.data;
        })
    }

}