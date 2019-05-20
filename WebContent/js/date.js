var today = new Date(new Date().getFullYear(), new Date().getMonth(), new Date().getDate());
   $('#startDate').datepicker({
       uiLibrary: 'bootstrap4',
       iconsLibrary: 'fontawesome',
       minDate: today,
       orientation: 'top auto',
       format: 'MM-DD-YY' ,
       maxDate: function () {
           return $('#endDate').val();
       }
   });
   $('#endDate').datepicker({
       uiLibrary: 'bootstrap4',
       iconsLibrary: 'fontawesome',
       orientation: 'top auto',
       format: 'MM-DD-YY' ,
       minDate: function () {
           return $('#startDate').val();
       }
   });
 