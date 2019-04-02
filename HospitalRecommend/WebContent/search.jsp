<htmal>
	<head>
		<title>
		Find hospital
		</title>
		<style>
		

.h1{
	text-align: center;
	color : #4CAF50;
	font-family: "Roboto", sans-serif;
	
	font-size: 30px;
 }

.content{

text-align: center;
background-color:white;
text-align: center;
	font-size:50px;
	color : #4CAF50;
	font-family: "Roboto", sans-serif;
margin-top:15%;
margin-left:40%;

float:center;}


			
			form {
			  outline: 0; 
			  float:left;
			  -webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
			  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
			  -webkit-border-radius: 4px;
			  border-radius: 4px;
			}

			form > .textbox {
				float:center;
			  outline: 0;
			  height: 50px;
			  width: 330px;
			  line-height: 42px;
			  padding: 0 16px;
			  background-color: rgba(255, 255, 255, 0.8);
			  color: #212121;
			  border: 0;
			  float: left;
			  -webkit-border-radius: 4px 0 0 4px;
			  border-radius: 4px 0 0 4px;
			}

			form > .textbox:focus {
			  outline: 0;
			  background-color: white;
			}

			form > .button {
			  outline: 0;
			  background: none;
			  background-color: rgba(38, 50, 56, 0.8);
			  float: left;
			  height: 50px;
			  width: 60x;
			  text-align: center;
			  line-height: 42px;
			  border: 0;
			  color: #FFF;
			  font: normal normal normal 14px/1 FontAwesome;
			  font-size: 16px;
			  text-rendering: auto;
			  text-shadow: 0 1px 1px rgba(0, 0, 0, 0.2);
			  -webkit-transition: background-color .4s ease;
			  transition: background-color .4s ease;
			  -webkit-border-radius: 0 4px 4px 0;
			  border-radius: 0 4px 4px 0;
			}

			form > .button:hover {
			  background-color: white;
			}
				
		</style>
		
	</head>
		<body align=center>
	
		<div class="h1">
		Search for the hospital</div>
		<div class="content">

			<form method="post" action="search_action.jsp">
				<input type="text" class="textbox" placeholder="Search"name="search">
				<input title="Search" value="search" type="submit" class="button">
			</form>
	
		</div>
		
		</body>
</html>