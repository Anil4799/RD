var today = new Date(new Date().getFullYear(), new Date().getMonth(), new Date().getDate());
   $('#startDate').datepicker({
       uiLibrary: 'bootstrap4',
       iconsLibrary: 'fontawesome',
       orientation: 'top auto',
   });
   $('#endDate').datepicker({
       uiLibrary: 'bootstrap4',
       iconsLibrary: 'fontawesome',
       orientation: 'top auto',

   });
   
   
   
//   var today = new Date(new Date().getFullYear(), new Date().getMonth(), new Date().getDate());
//   $('#startDate').datepicker({
//       uiLibrary: 'bootstrap4',
//       iconsLibrary: 'fontawesome',
//       minDate: today,
//       orientation: 'top auto',
//       maxDate: function () {
//           return $('#endDate').val();
//       }
//   });
//   $('#endDate').datepicker({
//       uiLibrary: 'bootstrap4',
//       iconsLibrary: 'fontawesome',
//       orientation: 'top auto',
//       minDate: function () {
//           return $('#startDate').val();
//       }
//   });
// 