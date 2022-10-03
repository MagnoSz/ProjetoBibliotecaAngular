angular.module("BibliotecaApp").factory("BaseService", function ($http) {

    return class IBaseService {
        constructor(url) {
            this.urlBase = "http://localhost:8080/biblioteca/rest/";
            this.url = url;
        }

        salvar (objeto, urlBase = this.urlBase, url = this.url) {
            return $http({
                method: 'POST',
                url: urlBase + url + "/novo",
                data: objeto
            });
        }

        alterar(objeto, urlBase = this.urlBase, url = this.url) {
            return $http({
                method: 'PUT',
                url: urlBase + url + "/",
                data: objeto
            });
        }

        excluir(id, urlBase = this.urlBase, url = this.url) {
            return $http({
                method: 'DELETE',
                url: urlBase + url + "/" + id + "/",
            });
        }

        listar(urlBase = this.urlBase, url = this.url) {
            return $http({
                method: 'GET',
                url: urlBase + url + "/listar"
            })
        }

        consultar(id, urlBase = this.urlBase, url = this.url){
            return $http({
                method: 'GET',
                url: urlBase + url + "/" +id + "/"
            })
        }

    }

});