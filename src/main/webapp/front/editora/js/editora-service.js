angular.module("BibliotecaApp").factory("EditoraService", EditoraService);

EditoraService.$inject = ["BaseService"];

function EditoraService(BaseService){
    class IEditoraService extends BaseService{
        constructor() {
            super("editora");
        }
    }
    return new IEditoraService();
}