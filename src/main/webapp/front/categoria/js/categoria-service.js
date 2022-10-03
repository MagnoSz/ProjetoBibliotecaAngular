angular.module("BibliotecaApp").factory("CategoriaService", CategoriaService);

CategoriaService.$inject = ["BaseService"];

function CategoriaService(BaseService){
    class ICategoriaService extends BaseService{
        constructor() {
            super("categorias");
        }
    }
    return new ICategoriaService();
}