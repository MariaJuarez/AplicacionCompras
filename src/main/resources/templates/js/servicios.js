var app = angular.module('servicios',[]);

app.servicios('servicios', ['$http', function($http){
	this.lista = function(success, failure){
		$http.get("http://localhost:8080/producto/list")
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

	this.eliminar = function(empleado, success, failure){
		$http.delete("http://localhost:8080/producto/eliminar/" + producto.id)
		.then(success,failure);
	}
}]);