(function() {
    var app = angular.module('lab3-livro',['lab3']);
    app.controller('LivroController',function($http,$localStorage){
        store = this;
        store.livro = $localStorage.livro = $localStorage.livro || {};
        store.livros = [];
        store.autores = [];
        store.editoras = [];
        
        $http.get('http://localhost:8080/livros').success(function(data){
           store.livros = data; 
        });
        $http.get('http://localhost:8080/editoras').success(function(data){
            store.editoras = data; 
         });
        $http.get('http://localhost:8080/autores').success(function(data){
            store.autores = data; 
         });
        this.save = function(livro) {
            $http.post('http://localhost:8080/livros',livro).success(function(data){
                window.location = 'livro-lista.html';
                $localStorage.livro = {};
            });
        };
        this.add = function() {
            $localStorage.livro = {};
            window.location = 'livro-edicao.html';
        };
        this.get = function(id) {
            $http.get("http://localhost:8080/livros/"+id).success(function(data){
                $localStorage.livro = data;
                window.location = 'livro-edicao.html';
            });
        };
    });
})();