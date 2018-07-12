var app = angular.module('directivas',[]);

app.directive('modalAgregar', function(){
    return{
        restrict: 'E',
        templateUrl: 'pages/modalAgregar.html'
    };
});

app.directive('modalEditar', function(){
    return{
        restrict: 'E',
        templateUrl: 'pages/editarModal.html'
    };
});

app.directive('modalEliminar', function(){
    return{
        restrict: 'E',
        templateUrl: 'pages/eliminarModal.html'
    };
});