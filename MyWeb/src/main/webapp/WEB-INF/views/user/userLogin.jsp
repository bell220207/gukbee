<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
    
  
    <section>
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-7 col-xs-10 login-form">
                    <div class="titlebox"> 로그인 </div>
                    <form action="login" method="post">
                        <div class="form-group"><!--사용자클래스선언-->
                            <label for="id">아이디</label>
                            <input type="text" class="form-control" name="id" id="id"  placeholder="아이디" required>
                            <span>${msg }</span>
                            ${users.id }
                            ${users.name }
                            ${users.addrZipNum }
                        </div>
                        <div class="form-group"><!--사용자클래스선언-->
                            <label for="id">비밀번호</label>
                            <input type="password" class="form-control" name="pw" id="pw" placeholder="비밀번호" required>
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-info btn-block">로그인</button>
                            <button type="button" class="btn btn-primary btn-block">회원가입</button>
                        </div>
                    </form> <!-- 폼 태그 끝 -->               
                </div>  	<!-- 로그인폼? div 끝 -->
            </div> 			<!-- 로우 div 끝 -->
        </div> 				<!-- 컨테이너 div 끝 -->
    </section>
    <%@ include file="../include/footer.jsp" %>

</body>
</html>