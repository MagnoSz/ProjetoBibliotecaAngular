angular.module("BibliotecaApp", []).controller("AutorIncluirController", AutorIncluirController);

AutorIncluirController.$inject = ["$scope", "AutorService", "LivroService"];

function AutorIncluirController($scope, AutorService, LivroService) {

    $scope.salvar = salvar;

    _inicializar();

    function _inicializar(){
        LivroService.listar().then(function (response) {
            $scope.livros = response.data;
        })
    }

    function salvar(){
        AutorService.salvar($scope.autor);
    }

}