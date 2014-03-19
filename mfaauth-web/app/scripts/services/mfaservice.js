'use strict';

var mfacodeService = angular.module('mfacodeService', []);

mfacodeService.service('mfacodeService', function($http) {
    return {
        get: function(key) {
            var promise = $http.get('/api/mfacode/' + key).then(function (response) {
                console.log(response);
                return response.data;
            });
            return promise;
        }
      };
  });
