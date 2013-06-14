<html>
<head><title>FreeMarker Hello World</title>

<body>


<h2>Hello people with the same letters for your first and last names!</h2>
  <table class="datatable">
  	<tr>
  		<th>Firstname</th>  <th>Lastname</th>
  	</tr>
    <#list users as user>
  	<tr><td>${user.firstname}</td> <td>${user.lastname}</td></tr>
    </#list>
  </table>
  
  <h2>Say hello to someone new!</h2>
  <form name="user" action="hello" method="post">
  	Firstname: <input type="text" name="firstname" />	<br/>
  	Lastname: <input type="text" name="lastname" />		<br/>
  	<input type="submit" value="Add to list" />
  </form>
  <h2>Note that the whole page gets reloaded when saved<h2> 
  <h4>(why put so many names, so it would be easier to see)<h4>
  <h2>
  , also note that you can update the flt file <u>without</u> needing to restart the jetty server
  </h2>
  
  Based on tutorial from here:
  <a href="http://viralpatel.net/blogs/freemarker-servlet-tutorial-example/">
  	http://viralpatel.net/blogs/freemarker-servlet-tutorial-example/
  </a>
</body>
</html>