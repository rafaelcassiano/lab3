(function() {
    var app = angular.module('lab3-editora',[]);
    app.controller('EditoraController', ['$http', function($http){
        store = this;
        store.editora = {};
        store.editoras = [];
        $http.get("http://localhost:8080/editoras").success(function(data){
           store.editoras = data; 
        });
        this.save = function(editora) {
          $http.post("http://localhost:8080/editoras", editora).success(function(data){
              
          });
        };
     }]);
})();