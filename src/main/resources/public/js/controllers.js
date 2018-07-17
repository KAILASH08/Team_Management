angular.module('app.controllers', []).controller('RfmTeamListController', function($scope, $state, popupService, $window, RfmTeam) {
  $scope.rfmTeams = RfmTeam.query(); //fetch all rfmTeams. Issues a GET to /api/vi/rfmTeams

  $scope.deleteRfmTeam = function(rfmTeam) { // Delete a RfmTeam. Issues a DELETE to /api/v1/rfmTeams/:id
    if (popupService.showPopup('Do you really want to delete this record?')) {
      rfmTeam.$delete(function() {
        $scope.rfmTeams = RfmTeam.query(); 
        $state.go('rfmTeams');
      });
    }
  };
}).controller('RfmTeamViewController', function($scope, $stateParams, RfmTeam) {
  $scope.rfmTeam = RfmTeam.get({ id: $stateParams.id }); //Get a single rfmTeam.Issues a GET to /api/v1/rfmTeams/:id
}).controller('RfmTeamCreateController', function($scope, $state, $stateParams, RfmTeam) {
  $scope.rfmTeam = new RfmTeam();  //create new rfmTeam instance. Properties will be set via ng-model on UI

  $scope.addRfmTeam = function() { //create a new rfmTeam. Issues a POST to /api/v1/rfmTeams
    $scope.rfmTeam.$save(function() {
      $state.go('rfmTeams'); // on success go back to the list i.e. rfmTeams state.
    });
  };
}).controller('RfmTeamEditController', function($scope, $state, $stateParams, RfmTeam) {
  $scope.updateRfmTeam = function() { //Update the edited rfmTeam. Issues a PUT to /api/v1/rfmTeams/:id
    $scope.rfmTeam.$update(function() {
      $state.go('rfmTeams'); // on success go back to the list i.e. rfmTeams state.
    });
  };

  $scope.loadRfmTeam = function() { //Issues a GET request to /api/v1/rfmTeams/:id to get a rfmTeam to update
    $scope.rfmTeam = RfmTeam.get({ id: $stateParams.id });
  };

  $scope.loadRfmTeam(); // Load a rfmTeam which can be edited on UI
});
