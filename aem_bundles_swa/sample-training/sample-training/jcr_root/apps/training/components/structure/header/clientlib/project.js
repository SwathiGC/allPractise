console.log("sanjay");
$( document ).ready(function() {
    console.log( "ready!" );
    $.ajax({
        url: "https://api.github.com/users/defunkt",
        success: function(result) {
            console.log("result 	: 	",result);
            $('#urlResult').attr('src',result.avatar_url);
            $('#urlResult').attr('name',result.name);
            $('#nameTag').text(result.name);
        },
        error: function(errorResult){
            console.log("error	:	",errorResult);
        }
	});
})