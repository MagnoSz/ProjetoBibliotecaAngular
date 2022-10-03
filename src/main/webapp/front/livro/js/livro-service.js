angular.module("BibliotecaApp").factory("LivroService", LivroService);

LivroService.$inject = ["BaseService"];

function LivroService(BaseService){
    class ILivroService extends BaseService{
        constructor() {
            super("livro");
        }
    }
    return new ILivroService();
}