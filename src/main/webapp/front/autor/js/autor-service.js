angular.module("BibliotecaApp").factory("AutorService", AutorService);

AutorService.$inject = ["BaseService"];

function AutorService(BaseService){
    class IAutorService extends BaseService{
        constructor() {
            super("autor");
        }
    }
    return new IAutorService();
}