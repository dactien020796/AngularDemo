/**
 * AngularJS Tutorial 1
 * @author Nick Kaye <nick.c.kaye@gmail.com>
 */

/**
 * Main AngularJS Web Application
 */
var app = angular.module('app', [
  'ui.router', 'angular-jwt', 'angular-storage', 'app.services'
]);

/**
 * Configure the Routes
 */
app.config( function ($stateProvider, $urlRouterProvider, jwtInterceptorProvider, $httpProvider) {
    $urlRouterProvider.otherwise('/');
    $stateProvider
    	// Home
        .state("home",
            {
                  url:"/" ,
                  templateUrl: "views/user/home.jsp",
                  controller: "HomeCtrl",
                  data: {
                      requireLogin: false
                  }
            }
        )
        // Pages
        .state("about",
            {
                url:"/about",
                templateUrl: "views/user/about.jsp",
                controller: "AboutCtrl",
                data: {
                    requireLogin: false
                }
            }
        )
        .state("login",
            {
                url:"/login",
                templateUrl: "views/user/login.jsp",
                controller: "LoginCtrl",
                data: {
                    requireLogin: false
                }
            }
        )
        // Product detail
        .state("product-detail",
            {
                  url:"/product-detail/:id" ,
                  templateUrl: "views/user/product-detail.jsp",
                  controller: "Product-Detail-Controller",
                  data: {
                      requireLogin: false
                  }
            }
        )
        // Shopping cart
        .state("shopping-cart",
            {
                  url:"/shopping-cart" ,
                  templateUrl: "views/user/shopping-cart.jsp",
                  controller: "ShoppingCartCtrl",
                  data: {
                      requireLogin: false
                  }
            }
        )
});

app.run(function ($rootScope, $state) {

    $rootScope.$on('$stateChangeStart', function (event, toState, toParams, AuthenticationService) {
        var requireLogin = toState.data.requireLogin;

        if (requireLogin) {
            event.preventDefault();
            // process auth
            if (typeof $rootScope.token === 'undefined') {
                $state.go("login");
            } else {
                AuthenticationService.checkToken($rootScope.token)
                .catch(function (error) {
                    if (error.status === 401 && error.data.errorKey === "EXPIRED_TOKEN") {
                        $state.go("login");
                    }
                });
            }

        }
    });
});
