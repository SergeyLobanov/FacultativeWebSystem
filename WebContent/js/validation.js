$(document).ready(function(){

    $("#registration").validate({

       rules:{

            name:{
                required: true,
            },
            login:{
                required: true,
                minlength: 4,
                maxlength: 16,
            },
            password:{
                required: true,
                minlength: 4,
                maxlength: 20,
            },
            confirmPassword:{
                equalTo: "#password"
            },

       },

       messages:{

            name:{
                required: "Please enter your name!",
            },
            login:{
                required: "Please enter your login!",
            },
            password:{
                required: "Please enter 6-20 characters!",
            },
            submitPassword:{
            	equalTo: "Passwords are not the same!",
            },


       }

    });
    
    $("#add_course").validate({

        rules:{

             course:{
                 required: true,
                 minlength: 2,
                 maxlength: 20,
             },
             start:{
                 required: true,
                 checkDate: true,
             },
             end:{
                 required: true,
                 checkDate: true,
                 greaterThan: "#start",
             },

        },

        messages:{

             course:{
                 required: "Please enter course name!",
             },
             start:{
                 required: "Please enter start date of course!",
                 date: "Please enter a start date in the format yyyy-mm-dd.",
             },
             end:{
                 required: "Please enter end date of course!",
                 date: "Please enter a end date in the format yyyy-mm-dd.",
             },

        }

     });

});

$.validator.addMethod(
	    "checkDate",
	    function(value, element) {
	        return value.match(/^\d\d\d\d?\-\d\d?\-\d\d$/);
	    },
	    "Please enter a date in the format yyyy-mm-dd."
	);
$.validator.addMethod(
		"greaterThan", 
		function(value, element, params) {

		    if (!/Invalid|NaN/.test(new Date(value))) {
		        return new Date(value) > new Date($(params).val());
		    }

		    return isNaN(value) && isNaN($(params).val()) 
		        || (Number(value) > Number($(params).val())); 
		},'Must be greater than start date.');
/*
function validate()
      {
      
         if( document.registration.name.value == "" )
         {
            alert( "Please provide your name!" );
            document.registration.name.focus() ;
            return false;
         }
         
         if( document.registration.login.value == "" )
         {
            alert( "Please enter your login!" );
            document.registration.login.focus() ;
            return false;
         }

         if( document.registration.password.value < 6 ||  document.registration.password.value > 20)
         {
            alert( "Please enter 6-20 characters!" );
            document.registration.password.focus() ;
            return false;
         }

         if( document.registration.confirmPassword.value != document.registration.password.value )
         {
            alert( "Passwords are not the same!" );
            document.registration.confirmPassword.focus() ;
            return false;
         }
         
         return( true );
      }*/