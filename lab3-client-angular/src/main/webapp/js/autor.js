(function() {
    var app = angular.module('lab3-autor',['lab3']);
    app.controller('AutorController',function($http,$localStorage){
       store = this;
       store.autor = $localStorage.autor = $localStorage.autor || {};
       store.autores = [];
       $http.get("http://localhost:8080/autores").success(function(data){
          store.autores = data; 
       });
       
       this.add = function() {
           $localStorage.autor = {};
           window.location = 'autor-edicao.html';  
       }
       
       this.save = function(autor) {
           $http.post("http://localhost:8080/autores",autor).success(function(){
               $localStorage.autor = {};
               window.location = 'autor-lista.html';   
           });
       };
       
       this.get = function(id) {
           $http.get("http://localhost:8080/autores/"+id).success(function(data){
               $localStorage.autor = data; 
               window.location = 'autor-edicao.html'; 
           });
       }
    });
})();