angular.module("BibliotecaApp", []).controller("EditoraIncluirController", EditoraIncluirController);

EditoraIncluirController.$inject = ["$scope", "EditoraService"];

function EditoraIncluirController($scope, EditoraService) {

    $scope.salvar = salvar;

    function salvar(){
        EditoraService.salvar($scope.editora);
    }

}