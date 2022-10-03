angular.module("BibliotecaApp").controller("CategoriaIncluirController", CategoriaIncluirController);

CategoriaIncluirController.$inject = ["$scope", "CategoriaService", "$state"];

function CategoriaIncluirController($scope, CategoriaService, $state) {

    $scope.salvar = salvar;

    _inicializar();

    function _inicializar(){
        $scope.categoria = {};
    }

    function salvar(){
        CategoriaService.salvar($scope.categoria).then(function () {
            $state.go('categoriaListar');
        });

    }

}