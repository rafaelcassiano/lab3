(function() {
    var app = angular.module('lab3-livro',[]);
    app.controller('LivroController', ['$http',function($http){
        store = this;
        store.livros = [];
        $http.get('http://localhost:8080/livros').success(function(data){
           store.livros = data; 
        });
    }]);
})();