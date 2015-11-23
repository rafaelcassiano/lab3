(function() {
    var app = angular.module('lab3',['ngStorage']);
    app.controller('TabController', function($scope, $localStorage){
       $localStorage.selectedMenu = $localStorage.selectedMenu || 0;
       this.setSelectedMenu = function(menu) {
           $localStorage.selectedMenu = menu;  
       };
       this.isSelectedMenu = function(menu) {
           return $localStorage.selectedMenu === menu;
       }
    });
})();