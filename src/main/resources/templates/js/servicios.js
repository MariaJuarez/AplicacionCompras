var app = angular.module('servicios',[]);

app.service('servicios', ['$http', function($http){
	this.lista = function(success, failure){
		$http.get("http://localhost:8080/productos/list")
		.then(success,failure);
	}

	this.agregar = function(producto, success, failure){
		$http.post("http://localhost:8080/productos/agregar", producto)
		.then(success,failure);
	}

	this.editar = function(producto, success, failure){
		$http.put("http://localhost:8080/productos/editar", producto)
		.then(success,failure);
	}

	this.eliminar = function(producto, success, failure){
		$http.delete("http://localhost:8080/productos/eliminar", producto)
		.then(success,failure);
	}
}]);