'use strict';

angular.module('mfaauthWebApp')
  .controller('MainCtrl',
              ['$scope', '$timeout', 'mfacodeService',
               function ($scope, $timeout, mfacodeService) {
                   
      $scope.mfakey = null;  
      $scope.mfacode = null;
      $scope.counter = 30;

      $scope.countdown = function() {
          var c = --$scope.counter;
          if(c<0) {
              $scope.counter = 31;
              $scope.getcode();
          } else {
              $timeout($scope.countdown, 1000);
          }
      };
                   
      $scope.getcode = function() {
          if($scope.mfakey) {                           
              mfacodeService.get($scope.mfakey).then(function(d) {
                  $scope.mfacode = d.mfacode;
                  $timeout($scope.countdown);
              });
          } else {
              $scope.mfacode = null;
          }
      };
                   
      $scope.$watch('mfakey', function() {
          $scope.getcode();
      });
    }]);
