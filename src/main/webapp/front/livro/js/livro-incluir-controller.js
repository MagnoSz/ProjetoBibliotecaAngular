angular.module("BibliotecaApp", []).controller("LivroIncluirController", LivroIncluirController);

LivroIncluirController.$inject = ["$scope", "LivroService", "AutorService", "CategoriaService", "EditoraService"];

function LivroIncluirController($scope, LivroService, AutorService, CategoriaService, EditoraService) {

    $scope.salvar = salvar;

    _inicializar();

    function _inicializar(){
        AutorService.listar().then(function (response) {
            $scope.autores = response.data;
        });

        CategoriaService.listar().then(function (response) {
            $scope.categorias = response.data;
        });

        EditoraService.listar().then(function (response) {
            $scope.editoras = response.data;
        })

    }

    function salvar(){
        LivroService.salvar($scope.editora);
    }

}