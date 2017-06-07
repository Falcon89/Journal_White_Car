function ProductCtrl($scope, $localStorage, $sessionStorage) {
  $scope.$storage = $localStorage.$default({
    products: [],
    settings: {}
  });
  
  /*
  $scope.products = [
    {
      name: 'Gold coin',
      sku: 'gld13',
      price: '289.90',
      expiration: '07/27/2015 07:00 AM',
      active: false
    },
    {
      name: 'Silver coin',
      sku: 'slv13',
      price: '189.90',
      expiration: '07/27/2015 07:00 AM',
      active: false
    },
    {
      name: '1/2 oz Silver',
      sku: 'silv15',
      price: '99.90',
      expiration: '07/27/2015 07:00 AM',
      active: false
    }
  ];
  */
  
  $scope.init = function() {
    $scope.clearForm();
    $scope.setting_domain = $scope.$storage.settings.domain;
    $scope.setting_apikey = $scope.$storage.settings.apikey;
  }
  
  $scope.settingsAreSet = function() {
    if(jQuery.isEmptyObject($scope.$storage.settings))
      return false;
    if(!$scope.$storage.settings.hasOwnProperty('domain'))
      return false;
    else if($scope.$storage.settings.domain == null)
      return false;
    if(!$scope.$storage.settings.hasOwnProperty('apikey'))
      return false;
    else if($scope.$storage.settings.apikey == null)
      return false;
    return true;
  }
  
  $scope.dismissSettings = function() {
    $scope.setting_domain = $scope.$storage.settings.domain;
    $scope.setting_apikey = $scope.$storage.settings.apikey;
    $("#settings").modal('hide');
  }
  
  $scope.saveSettings = function() {
    $scope.$storage.settings.domain = $scope.setting_domain;
    $scope.$storage.settings.apikey = $scope.setting_apikey;
    $("#settings").modal('hide');
  }
  
  $scope.editProduct = function(productId) {
    if($scope.$storage.product_id != null)
      $scope.$storage.products[$scope.$storage.product_id].active = false;
    $scope.$storage.product_id = productId;
    var product = $scope.$storage.products[productId];
    product.active = true;
    $scope.form_legend = "Update Product";
    $scope.product_name = product.name;
    $scope.product_sku = product.sku;
    $scope.product_price = product.price;
    $('#datetimepicker').data("DateTimePicker").date(
      moment(product.expiration, "MM/DD/YY hh:mm A")
    );
    $scope.form_button = "Save";
    $scope.loadCodeblock();
  }
  
  $scope.clearForm = function() {
    if($scope.$storage.product_id != null)
      $scope.$storage.products[$scope.$storage.product_id].active = false;
    $scope.$storage.product_id = null;
    $scope.form_legend = "Create Product";
    $scope.product_name = null;
    $scope.product_sku = null;
    $scope.product_price = null;
    var picker = $('#datetimepicker').data("DateTimePicker");
    if(picker)
      picker.date(picker.defaultDate());
    $scope.form_button = "Create";
    $scope.codeblock = null;
  }
  
  $scope.updateProduct = function() {
    var expiration = $('#datetimepicker').data("DateTimePicker").date();
    if($scope.$storage.product_id != null)
    {
      var product = $scope.$storage.products[$scope.$storage.product_id];
      product.name = $scope.product_name;
      product.sku = $scope.product_sku;
      product.price = $scope.product_price;
      product.expiration = expiration.format('MM/DD/YYYY hh:mm A');
    }
    else
    {
      $scope.$storage.product_id = $scope.$storage.products.push({
        name: $scope.product_name,
        sku: $scope.product_sku,
        price: $scope.product_price,
        expiration: expiration.format('MM/DD/YYYY hh:mm A'),
        active: true
      }) - 1;
    }
    $scope.loadCodeblock();
    console.log(expiration);
  }
  
  $scope.loadCodeblock = function() {
    if(!$scope.settingsAreSet()) {
      $scope.codeblock = "";
      return;
    }
    var expiration = $('#datetimepicker').data("DateTimePicker").date();
    var codeblock = "<form action='https://"+$scope.setting_domain+"/cart' method='post' accept-charset='utf-8'>\n";
    codeblock += "\t$"+$scope.product_price+"\n";
    codeblock += "\t<input type='hidden' name='name||"+$scope.get_verification('name', $scope.product_name, $scope.product_sku)+"' value='"+$scope.product_name+"' />\n";
    codeblock += "\t<input type='hidden' name='price||"+$scope.get_verification('price', $scope.product_price, $scope.product_sku)+"' value='"+$scope.product_price+"' />\n";
    codeblock += "\t<input type='hidden' name='code||"+$scope.get_verification('code', $scope.product_sku, $scope.product_sku)+"' value='"+$scope.product_sku+"' />\n";
    codeblock += "\t<input type='hidden' name='expires||"+$scope.get_verification('expires', expiration.unix(), $scope.product_sku)+"' value='"+expiration.unix()+"' />\n";
    codeblock += "\t<input type='submit' value='Add to cart' class='submit' style='margin-left:10px' />\n";
    codeblock += "</form>";
    $scope.codeblock = codeblock;
  }
  
  $scope.get_verification = function(name, value, code) {
    var shaObj = new jsSHA("SHA-256", "TEXT");
    shaObj.setHMACKey($scope.setting_apikey, "TEXT");
    shaObj.update(code+name+value);
    return shaObj.getHMAC("HEX");
  }
}

angular.module('foxyCartApp', ['ngStorage']).controller('ProductCtrl', ProductCtrl);


$(function () {
  $('#datetimepicker').datetimepicker({
    defaultDate: moment().day(8).hour(7).minute(0).second(0)
   });
});