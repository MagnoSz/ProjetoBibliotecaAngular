angular.module("BibliotecaApp").controller("CategoriaListarController", CategoriaListarController);

CategoriaListarController.$inject = ["$scope", "CategoriaService", "$compile", "$element"];

function CategoriaListarController($scope, CategoriaService) {

    $scope.editar = editar;
    $scope.excluir = excluir;

    _inicializar();

    function _inicializar() {
        recarregarTabela();
    }

    function editar(id) {
        $state.go('');
    }

    function excluir(id) {
        CategoriaService.excluir(id).then(function (){
            recarregarTabela();
        });
    }

    function recarregarTabela() {
        CategoriaService.listar().then(function (response) {
            $scope.categorias = response.data;
        })
    }


}