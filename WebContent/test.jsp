<!DOCTYPE html>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script>
$(document).ready(function(){
    $("input").blur(function(){
        alert("This input field has lost its focus.");
    });
});
</script>
</head>
<body>

Enter your name: <input type="text">
<p>Write something in the input field, and then click outside the field to lose focus (blur).</p>

</body>
</html>