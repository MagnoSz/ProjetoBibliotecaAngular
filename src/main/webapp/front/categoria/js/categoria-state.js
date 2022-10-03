var app = angular.module('BibliotecaApp');

app.config(['$stateProvider', '$locationProvider', function ($stateProvider, $locationProvider) {
    $locationProvider.hashPrefix('');
    $stateProvider
        .state('firstMessage', {
            url: '/first-msg',
            templateUrl: './teste.html'
        })
        .state('categoriaListar', {
            url: '/categoria/listar',
            templateUrl: 'front/categoria/view/categoria-listar.html',
            controller: 'CategoriaListarController'
        })
        .state('categoriaIncluir', {
            url: '/categoria/nova',
            templateUrl: 'front/categoria/view/categoria-incluir.html',
            controller: 'CategoriaIncluirController'
        })
        .state('tabelaListar', {
            url: 'tabela/listar',
            templateUrl: 'front/tabela/view/tabela.html',
            controller: 'TabelaListar'
        })
}])