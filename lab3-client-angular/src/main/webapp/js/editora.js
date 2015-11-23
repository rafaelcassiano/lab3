(function() {
    var app = angular.module('lab3-editora',['lab3']);
    app.controller('EditoraController',function($http,$localStorage){
        store = this;
        store.editora = $localStorage.editora = $localStorage.editora || {};
        store.editoras = [];
        $http.get("http://localhost:8080/editoras").success(function(data){
           store.editoras = data; 
        });
        this.save = function(editora) {
          $http.post("http://localhost:8080/editoras", editora).success(function(data){
              window.location = 'editora-lista.html';
              $localStorage.editora = {};
          });
        };
        this.add = function() {
            $localStorage.editora = {};
            window.location = "editora-edicao.html";
        }
        this.get = function(id) {
            $http.get("http://localhost:8080/editoras/"+id).success(function(data){
                $localStorage.editora = data;
                window.location = "editora-edicao.html"; 
             });
        }
     });
})();