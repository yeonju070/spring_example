<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<!-- bootstrap CDN link -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>회원 정보 추가</h1>
		
		<form method="post" action="/lesson06/ex01/add_user">
			<div class="form-group">
				<label for="name">이름</label>
				<input type="text" id="name" name="name" class="form-control">
			</div>
			<div class="form-group">
				<label for="yyyymmdd">생년월일</label>
				<input type="text" id="yyyymmdd" name="yyyymmdd" class="form-control">
			</div>
			<div class="form-group">
				<label for="email">이메일 주소</label>
				<input type="text" id="email" name="email" class="form-control">
			</div>
			<div class="form-group">
				<label for="introduce">자기소개</label>
				<textarea id="introduce" name="introduce" class="form-control"></textarea>
			</div>
			
			<%-- ajax를 사용할 때는 type을 반드시 button으로 해야 한다. --%>
			<button type="button" id="addBtn" class="btn btn-success">추가</button>
		</form>
	</div>

<script>
	$(document).ready(function() {
		// (1) jquery의 submit 기능 이용하기
		/* $('form').on('submit', function(e) {
			// e.preventDefault();	// submit 되는 것을 막는다.
			// alert("추가 버튼 클릭");
			
			// validation - 값의 유효성 체크
			let name = $('#name').val().trim();
			if (name.length < 1) {
				alert("이름을 입력하세요.");
				return false;
			}
			
			let yyyymmdd = $('#yyyymmdd').val().trim();
			if (yyyymmdd = "") {
				alert("생년월일을 입력하세요.");
				return false;
			}
			
			if (isNaN(yyyymmdd)) {
				alert("숫자만 입력하세요.");
				return false;
			}
			
			let email = $('#email').val().trim();
			if (email = "") {
				alert("이메일을 입력하세요.");
				return false;
			}
			
			// 여기까지 도달하면 submit이 진행된다.
		}); */
		
		// ☆☆☆(2) jqery의 AJAX 통신을 이용하기 - button type을 button으로 변경☆☆☆
		$('#addBtn').on('click', function(e) {
			e.preventDefault();	// 안해도 된다.
			
			// alert("추가 버튼 클릭");
			
			let name = $('#name').val().trim();
			if (name.length < 1) {
				alert("이름을 입력하세요.");
				return false;
			}
			
			let yyyymmdd = $('#yyyymmdd').val().trim();
			if (yyyymmdd = "") {
				alert("생년월일을 입력하세요.");
				return false;
			}
			
			if (isNaN(yyyymmdd)) {
				alert("숫자만 입력하세요.");
				return false;
			}
			
			let email = $('#email').val().trim();
			if (email = "") {
				alert("이메일을 입력하세요.");
				return false;
			}
			
			// 서버에 전송 AJAX : 폼태그와 상관없이 비동기로 별도 요청(request)
			$.ajax({
				// request
				type:"post"	// method 방식
				, url:'/lesson06/ex01/add_user'	// 요청 주소
				. data:{"name":name, "yyyymmdd":yyyymmdd, "email":email, "introduce":introduce}
				
				// response
				, success: function(data) {
					alert(data);
				}
				, error: function(e) {
					alert("에러 : " + e);
				}
			});
		});
	});
</script>
</body>
</html>