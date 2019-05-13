---
title: "My JavaWeb Growth"
---

---
### Project Name
#### Pending

---
### Introducation

--- Studying JavaWeb`s history of blood and tears on Junior road

---


---
### About Me
--- Name:Cheng Feitian.

--- ID  :***222016321072022***

--- University: Southwest University

--- __*[Aliyun](http://120.79.133.21:8080/LoginServlet/login.html)*__

--- __*[MyBlog](http://119.23.107.137)*__ : I hope you can pay attention to my blog and correct my mistakes that I do not realized!
### The things I do
---
### March
#### Day 14
Learn how to use markdown,before today,I've been submitting the code 10 times.  But I haven't deployed locally written code to tomcat,the conversion between this is a bit of a hassle.I will learn how to use ant and use to war these code,so they will be in aliyun.
#### Day 15
Nowaday,I have deployed the code on aliyun,and adjust the codes in order to they can work on server.
#### Day 17
Accord the video to learn the httpservlet and genericservlet,and try to write the sample code on the video.
#### Day 18
Code my own Httpservlet and Genericservlet according to the video tutorial,in the process of writing not a video tutorial I have read more or less three times,it feels more and more difficult.
#### Day 19
Today,I learned how to connect a servlet programm to a database and encountered a permissions issue.Locally,the user is an ordinary user,but MySQL is possessed by the root user,and I haven't solved the problem yet.
#### Day 21
Today,I have learned the principle of the JSP file,it is essentially a servlet program,in the execution of the JSP engine to compile it into a servlet program.
#### Day 23
As of today,I have looked at a large part of the JSP and expect to be able to finish it learning tomorrow.Today,I realized the login successfully display pop-up window,but JSP script writing I am not quite clear,there is a diffculty has not been resovled,look forward to tomorrow can be resolved.
Tips:
user:tomcat pass:tomcat
#### Day 24
I haven't finished the code,as it is the focus,so I have to look at the tutorial carefully.I've uploaded some code,but I didn't update the README.md.
#### Day 25 
I finished the JSP tutorial.It it more important for the behind content,so it took me twice times to look at tutorials and write code.
* All the home site is http://120.79.133.21:8080/LoginServlet/*.jsp
#### Day 26
Now,I have learned JavaWEB_include directive.These chapters are relatively simple,but in order to learn these chapters I have recreated a project that I will deploy to Aliyun.
#### Day 27
The task I finished today was to complete the JSP tutorials.Now I'm summing up a few inportant conclusions:
* First,the forwarding of the request is based on request,the method is request.getRequestDispatcher(path).forward(request,response);
* Second,the redirection of the request is based on response,the method is response.sendRedirect(path);
* Third,the scope of the four elements of pageContext,request,session,application is small to large and important and they can call methods related to the getAttribute method.These methods all belong to Object objects.
* Forth,There are instructions that can be placed at the first of the JSP to configure the JSP page.Similarly,there are some JSP tags that can be configured with JSP pages.
* The end,all the home site is http://120.79.133.21:8080/web/*.jsp
#### Day 30
I started to learn MVC tutorial,It is a design pattern we're going to follow when we design.Unlike the previous one,the code for this linked database does not need to do anything else,just control.
* New site is http://120.79.133.21:8080/MVCTutorial/test.jsp
#### Day 31
On the basis of the last time I added the delete function,is still the use of MVC mode,but there is a problem ,success.jsp can not be automatically forwarded.I am trying to solve this problem.

### April
#### Day 1
Today I am learning the design anf implementation of DAO layer in the MVC design pattern.So far,I have only writtern the execuses and parent classes required by the DAO layer.The implementation has not yet been completed.This part needs to think more before going on.
#### Day 3
Yesterday and today I was thinking about how to implement the DAO layer.Unfortunately,I didn't realize it,so I followed the vedio tutorial.But there are too many questions here:
* First of all,how is reflact mapped?
* Secondly,I am not very clear about the structure of the DAO layer.
* Again,what is c3p0?
* Fourth,what is the working principle of JUnit?

Another problem that I solved is that the c3p0 data source will introduce the classnotfound error when it is imported into the jar package.The reason is to import two packages.The MVC design pattern is still no as simple as I thought,and I think a lot of the vedio tutorials are missing,I am trying to find some of them.

There also have a problem,due to the JUnit,I can not deploy this code on Aliyun,because ant compilation error.

Now I have settled the problem,but there lacks JSP files.
#### Day 4
I have finished the tutorial about one-to-many servlets.It used the method named reflact as mentioned yesterday.

I searched the invoke method,which is inside the reflact package.It has at least two parameters.These parameters are Object objects.It is used for simplify the code and improve the reusability of the program. 
#### Day 5
Trying to implement the fuzzy query function, has not been fully implemented, the temporary implementation of the query function, unlike the previous one is the code to optimize the structure, each function is dedicated to a function, more neat.

If you want to access it,you can try http://120.79.133.21:8080/MVCTutorial/index.jsp
#### Day 6
Today I have learned how to implement fuzzy query function.The strange thing is that the error report says that the sql statement is wrong, but after checking and JUnit's test sql is not wrong, I am trying to solve this problem.

Now I haven't solved the problem.
#### Day 7
I have solved the problem about deploying codes to aliyun.The problem is that the c3p0-config.xml file is not included in the path, the jar is not packaged for c3p0-config.xml, so I created the classes folder and put the c3p0-config.xml file in the classes folder to solve it.
#### Day 8
The task I finished today is using bootstrap templates to beautify my login page.Now my page is friendly,If you succeed Logining in my page,you will see the webapp's homepage.But the related functions in the hompage have not been fully realized.

As of now,I have completed the first part of the MVC design and some of beautification work,the functions implemented are delete,fuzzy query,increase user,simple query and other operations,but the MVC related code has not been beautified.After the completion,it will beautify.

If you want to access it,you can type http://120.79.133.21:8080/MVCTutorial/*.jsp
#### Day 9
Today I learnde how to implement the modify function.But there exits some questions.I tend to solve the problem tomorrow.
#### Day 10
Today I completed all the MVC tutorials.And implemented all the MVC code,and I will deploy it to Aliyun,This part is more important,so I will slow down the next learning process,and put the things I have learned in this period into the blog.The functhon I implemented:
* addCusomer
* fuzzy
* query
* delete
* modify

etc.
#### Day 11
I started to learn cookie tutorial,and I have already implemented serveral code.They are all in JSP files.At first, these knowledge about cookies is still relatively simple.

The site is http://120.79.133.21:8080/MVCTutorial/login.jsp
#### Day 13
Today I have completed the cookie section, which is not as difficult as I thought. I think this part is important for some APIs of cookies. Below are some functions about cookies.
* Cookie cookie = new Cookie(key,value);
* response.addCookie(cookie);
* cookie.setMaxAge(time);//If time is negative, the cookie is not stored, 0 means delete immediately, and the integer represents the cookie survival time.
* The scope of the cookie is the current directory and subdirectories. You can use the cookie.setPath() method to change the scope of the cookie.
#### Day 14
I start to learn HttpSession,which is an implicit object in JSP.Session is not similar with cookie,but it contains cookie.We can distinguish different sessions by sessionId.

If you would like to access it,you can type http://120.79.133.21:8080/MVCTutorial/*.jsp in the URL address bar.
#### Day 15
Today I learned the life cycle of HttpSession and made a lot of notes, but there is nothing to practice in this part, so I implemented the registration function in the LoginServlet I have done before, and I am ready to implement the forgotten password function. I will share the notes later.
#### Day 16
As of now, I have completed the summary of HttpSession, and summarize the following points:
* First, the session is not necessarily created when it is accessed. It needs to look at the current JSP (or servlet) configuration.
* Second, the session is not destroyed after the browser is closed, and it still exists with the server.

Several important functions:
* request.getSession(); request.getSession(boolean create);
* Session.invalidate();// invalidate session
* session.setMaxInactiveInterval(seconds);//Set the expiration time of the session
* session.setAttribute();session.getAttribute();session.removeAttribute();
* session.encodeURL(); //URL rewriting
#### Day 18
Today I completed a simple case called a simple shopping cart.The technology used is HttpSession.The difficulty of this case is the writing of the front-end page.Others are not too difficult.

In principle,the contents of the form are encapsulated into classes and then loaded into the session object,and then taken out when needed.

The site is http://120.79.133.21:8080/SessionTutorial/shoppingcart/step-1.jsp
#### Day 19
Today what I learned is absolute path and relative path.The most important thing is "/" represents what.There are two general types: one is the root path representing the current web application (actually the root path of the web container plus request.getContextPath()), and the other is the root path of the web container.
#### Day 20
Today I completed the tutorial to solve the form re-submission. There are two ways to solve this problem. One is based on the MVC Struts component, the other is handwritten. The two are similar in principle, the difference is random. The value is different. So I finished the first one and didn't write the second one.

The second is basically to make the token a separate class for the reusability of the code, nothing else changes.The important part of my task in this chapter is when the form is repeatedly submitted, which is the principle we need to know.
#### Day 21
What I completed today is the implementation of the image verification code function.In principle,the implementation of the captcha feature is similar to the form repeat submission,so I won't go into too much detail.And I have finished all Session's tutorials.I will give a summary of this chapter later.
#### Day 22
Tend to implement forgot password function.I have finished most part of the code.I hope I can finish this code tomorrow.
#### Day 23
Today I implement the function that you can reset the password,and you also can create an account.As of the webapp is independent of the course, the functionality is not perfect. Every time I complete a task, I try to add content to the system and try to make it friendly.
#### Day 25
I tryed to solve a problem that memory leak,Now I haven't solved the problem.I would like to deal it locally.
#### Day 26
Finded a new problem,so I reset the code in order to correct it.
#### Day 27
Today I have learned JavaBean and the properties used in JSP Page.It is not difficult that I can totally understand them.Recently I slowed down the progress of learning in order to understand session and cookies well.
#### Day 28
Today I learned the basic EL syntax,which was used as a front-end display to simplify a lot of Java code.The basic constituent element is ${param.value},and EL has automatic type conversion.
All the site is http://120.79.133.21:8080/SessionTutorial/el.jsp
#### Day 29 
Today I finished the EL tutorial and are learning the simple label language, EL and labels are used to simplify the front-end code.
### May
#### Day 4
After a few days of rest,I learned the filter from now on,and realized a simple login control function.The configuration method of the filter is very similar to that of the servlet.The API of the doFilter is only one,which is relatively easy.
#### Day 5
Now I finished the Httpfilter code.It can be used for Http request.And this has an important knowledge point, multiple filters are processed in the order of filter-mapping configuration in web.xml, and then executed in reverse order during execution.
#### Day 6
Kill the problem which JDBC leads memory leak.
#### Day 7
Learn filter's application
#### Day 8
Complete the first phase of the filter, ready to try to contact the rights management.
#### Day 9
I started trying to do the rights management function today. So far, I just set up a shelf. DAO has not been implemented yet, and JSP is almost finished. I am expected to finish writing the code tomorrow.
#### Day 13
In the past three days, I have completed the permission management of the filter part. This part is a bit difficult, so it needs to be done slowly.
