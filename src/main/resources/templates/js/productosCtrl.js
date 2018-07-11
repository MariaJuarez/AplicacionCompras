var app = angular.module('controlador',[]);

app.controller('productosCtrl', ['$scope', '$http', 'servicios', function($scope, $http, servicios) {
	$scope.producto = {};

	$scope.productos = [];

	$scope.listarProducto = function () {
		servicios.lista(function (success) {
			$scope.productos = success.data;
		});
	}

	$scope.agregarProducto = function () {
		servicios.agregar($scope.producto,
		function (success){
			$scope.limpiar();
			$scope.listarProducto();
		}, function (failure){
			if (failure.status < 0) {
				alert('No se ha recibido respuesta del servidor');
			} else {
				alert('Ha habido un error con los datos ingresados');
			}
			$scope.limpiar();
		});
		
	}
	$scope.editarProducto = function () {
		servicios.editar($scope.producto,
		function (success){
			$scope.listarProducto();
			$scope.limpiar();
		}, function (failure){
			if (failure.status < 0) {
				alert('No se ha recibido respuesta del servidor');
			} else {
				alert(failure.data.mensaje);
			}
			$scope.limpiar();
		});
	}
	$scope.idEliminar = function(pro){
		$scope.producto = pro;
	}

	$scope.eliminarProducto = function () {
		servicios.eliminar($scope.producto,
		function (success){
			$scope.listarProducto();
			$scope.limpiar();
		}, function (failure){
			if (failure.status < 0) {
				alert('No se ha recibido respuesta del servidor');
			} else {
				alert(failure.data.mensaje);
			}
			$scope.limpiar();
		});
	}

	$scope.modalEditar = function(pro) {
		$scope.producto = angular.copy(pro);
	}

	$scope.limpiar = function () {
		$scope.producto = {};
		$scope.buscar = {};
		$scope.formularioAgregar.$setPristine();
		$scope.formularioEditar.$setPristine();
	}

	$scope.esCorrectoNombre = function (editarCrear){
		if(editarCrear.localeCompare('Agregar') == 0){
			return !$scope.formularioAgregar.nombre.$error.required;
		}
		return !$scope.formularioEditar.nombre.$error.required;
	}

	$scope.esIncorrectoNombre = function (editarCrear){
		if(editarCrear.localeCompare('Agregar') == 0){
			return !$scope.formularioAgregar.nombre.$pristine && $scope.formularioAgregar.nombre.$error.required;
		}
		return !$scope.formularioEditar.nombre.$pristine && $scope.formularioEditar.nombre.$error.required;
	}

	$scope.esCorrectoPrecio = function (editarCrear){
		if(editarCrear.localeCompare('Agregar') == 0){
			return !$scope.formularioAgregar.precio.$error.required
			&& !$scope.formularioAgregar.precio.$error.min && !$scope.formularioAgregar.precio.$error.max;
		}
		return !$scope.formularioEditar.precio.$error.required
		&& !$scope.formularioEditar.precio.$error.min && !$scope.formularioEditar.precio.$error.max;
	}

	$scope.esIncorrectoPrecio = function (editarCrear){
		if(editarCrear.localeCompare('Agregar') == 0){
			return !$scope.formularioAgregar.precio.$pristine &&
			($scope.formularioAgregar.precio.$error.required || $scope.formularioAgregar.precio.$error.min || $scope.formularioAgregar.precio.$error.max);
		}
		return !$scope.formularioEditar.precio.$pristine &&
		($scope.formularioEditar.precio.$error.required || $scope.formularioEditar.precio.$error.min || $scope.formularioEditar.precio.$error.max);
	}

	$scope.esIncorrectoPrecioSpan = function (editarCrear){
		if(editarCrear.localeCompare('Agregar') == 0){
			return !$scope.formularioAgregar.precio.$pristine && $scope.formularioAgregar.precio.$error.required;
		}
		return !$scope.formularioEditar.precio.$pristine && $scope.formularioEditar.precio.$error.required;
	}

	$scope.esCorrectoCantidad = function (editarCrear){
		if(editarCrear.localeCompare('Agregar') == 0){
			return !$scope.formularioAgregar.cantidad.$error.required
			&& !$scope.formularioAgregar.cantidad.$error.min && !$scope.formularioAgregar.cantidad.$error.max;
		}
		return !$scope.formularioEditar.cantidad.$error.required
		&& !$scope.formularioEditar.cantidad.$error.min && !$scope.formularioEditar.cantidad.$error.max;
	}	

	$scope.esIncorrectoCantidad = function (editarCrear){
		if(editarCrear.localeCompare('Agregar') == 0){
			return !$scope.formularioAgregar.cantidad.$pristine &&
			($scope.formularioAgregar.cantidad.$error.required || $scope.formularioAgregar.cantidad.$error.min || $scope.formularioAgregar.cantidad.$error.max);
		}
		return !$scope.formularioEditar.cantidad.$pristine &&
		($scope.formularioEditar.cantidad.$error.required || $scope.formularioEditar.cantidad.$error.min || $scope.formularioEditar.cantidad.$error.max);
	}

	$scope.esIncorrectoCantidadSpan = function (editarCrear){
		if(editarCrear.localeCompare('Agregar') == 0){
			return !$scope.formularioAgregar.cantidad.$pristine && $scope.formularioAgregar.cantidad.$error.required;
		}
		return !$scope.formularioEditar.cantidad.$pristine && $scope.formularioEditar.cantidad.$error.required;
	}
	$scope.listarProducto();
    /**
	 * Fecha
     */
    $scope.esCorrectoFechaCompra = function (editarCrear){
        if(editarCrear.localeCompare('Agregar') == 0){
            return !$scope.formularioAgregar.cantidad.$error.required
                && !$scope.formularioAgregar.cantidad.$error.min && !$scope.formularioAgregar.cantidad.$error.max;
        }
        return !$scope.formularioEditar.cantidad.$error.required
            && !$scope.formularioEditar.cantidad.$error.min && !$scope.formularioEditar.cantidad.$error.max;
    }

    $scope.esIncorrectoFechaCompra = function (editarCrear){
        if(editarCrear.localeCompare('Agregar') == 0){
            return !$scope.formularioAgregar.cantidad.$pristine &&
                ($scope.formularioAgregar.cantidad.$error.required || $scope.formularioAgregar.cantidad.$error.min || $scope.formularioAgregar.cantidad.$error.max);
        }
        return !$scope.formularioEditar.cantidad.$pristine &&
            ($scope.formularioEditar.cantidad.$error.required || $scope.formularioEditar.cantidad.$error.min || $scope.formularioEditar.cantidad.$error.max);
    }

    $scope.ingresarFechaCompra = function(){
        $('#input-group.date.compra').datepicker({
            format : "dd-mm-yyyy",
            weekStart : 0,
            endDate : "",
            clearBtn : false,
            todayHighlight: true,
            language : "es",
            autoclose: true
        });
    }
    $scope.ingresarFechaAgote = function(){
        $('#datepicker').datepicker({
            format : "dd-mm-yyyy",
            weekStart : 0,
            endDate : "",
            clearBtn : false,
            todayHighlight: true,
            language : "es",
            autoclose: true
        });
    }
}

]);