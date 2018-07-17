var app = angular.module('plunker', ['mgcrea.ngStrap']);


app.directive('datepickerWithButton', function ($datepicker, $parse){
        return{
            restrict: 'A',
            require: '?ngModel',
            link: function (scope, element, attrs, ngModel){
                if (!ngModel){
                    return;
                }

                //Copy config
                //TODO find the rigth way to avoid this copy
                var options = {scope: scope, controller: ngModel};
                angular.forEach(['placement', 'container', 'delay', 'trigger', 'keyboard', 'html', 'animation', 'template', 'autoclose', 'dateType', 'dateFormat', 'timezone', 'modelDateFormat', 'dayFormat', 'strictFormat', 'startWeek', 'startDate', 'useNative', 'lang', 'startView', 'minView', 'iconLeft', 'iconRight', 'daysOfWeekDisabled', 'id'], function (key){
                        if (angular.isDefined(attrs[key])){
                            options[key] = attrs[key];
                        }
                    }
                );

                //create datepicker popup
                var datepicker = $datepicker(element, ngModel, options);

                //Dump a button to open the datepicker
                //TODO ..not so clean :s
                var button = $("<a class='input-group-addon glyphicon glyphicon-calendar'></a>");
                $(button).on('click', function (){
                    //update the datepicker popup value
                    datepicker.update(ngModel.$dateValue);
                    //open the datepicker
                    datepicker.show();
                });
                button.insertAfter(element);

                scope.$on("$destroy", function (){
                    $(button).off('click');
                });
            }
        };
});