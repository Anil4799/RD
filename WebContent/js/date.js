var today = new Date(new Date().getFullYear(), new Date().getMonth(), new Date().getDate());
   $('#startDate').datepicker({
       uiLibrary: 'bootstrap4',
       iconsLibrary: 'fontawesome',

       orientation: 'top auto',
       format:'mm-dd-yyyy',

   });
   $('#endDate').datepicker({
       uiLibrary: 'bootstrap4',
       iconsLibrary: 'fontawesome',
       orientation: 'top auto',
       format:'mm-dd-yyyy',

   });
 
   
   