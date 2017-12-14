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
        // Check out
        .state("check-out",
            {
                  url:"/check-out" ,
                  templateUrl: "views/user/check-out.jsp",
                  controller: "CheckOutCtrl",
                  data: {
                      requireLogin: false
                  }
            }
        )
        // Change password
        .state("change-password",
            {
                  url:"/change-password" ,
                  templateUrl: "views/user/change-password.jsp",
                  controller: "ChangePasswordCtrl",
                  data: {
                      requireLogin: false
                  }
            }
        )
        // Edit account
        .state("edit-account",
            {
                  url:"/edit-account" ,
                  templateUrl: "views/user/edit-account.jsp",
                  controller: "EditAccountCtrl",
                  data: {
                      requireLogin: false
                  }
            }
        )
        // Forgot password
        .state("forgot-password",
            {
                  url:"/forgot-password" ,
                  templateUrl: "views/user/forgot-password.jsp",
                  controller: "ForgotPasswordCtrl",
                  data: {
                      requireLogin: false
                  }
            }
        )
        // Order history
        .state("order-history",
            {
                  url:"/order-history" ,
                  templateUrl: "views/user/order-history.jsp",
                  controller: "OrderHistoryCtrl",
                  data: {
                      requireLogin: false
                  }
            }
        )
        // Order detail
        .state("order-detail",
            {
                  url:"/order-detail/:id" ,
                  templateUrl: "views/user/order-detail.jsp",
                  controller: "OrderDetailCtrl",
                  data: {
                      requireLogin: false
                  }
            }
        )
        // Search
        .state("search",
            {
                  url:"/search/:keywords" ,
                  templateUrl: "views/user/search.jsp",
                  controller: "SearchCtrl",
                  data: {
                      requireLogin: false
                  }
            }
        )
        // Search hang
        .state("search-hang",
            {
                  url:"/search-hang/:hang" ,
                  templateUrl: "views/user/search-hang.jsp",
                  controller: "SearchHangCtrl",
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

