(function() {
    var app = angular.module('lab3-autor',[]);
    app.controller('AutorController', ['$http', function($http){
       store = this;
       store.autor = {};
       store.autores = [];
       $http.get("http://localhost:8080/autores").success(function(data){
          store.autores = data; 
       });
       
       this.save = function(autor) {
           $http.post("http://localhost:8080/autores",autor).success(function(){
               window.location = 'autor-lista.html';               
           });
       };
       
       this.get = function(id) {
           $http.get("http://localhost:8080/autores/"+id).success(function(data){
              store.autor = data; 
           });
       }
       
       this.openForm = function(id) {
           
       }
    }]);
})();