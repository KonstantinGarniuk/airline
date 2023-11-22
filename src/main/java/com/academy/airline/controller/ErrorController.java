// package com.academy.airline.controller;

// import java.sql.SQLException;

// import org.springframework.http.HttpStatus;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.ControllerAdvice;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.ResponseStatus;
// // import org.springframework.web.bind.annotation.GetMapping;
// //import org.springframework.web.servlet.ModelAndView;

// import jakarta.servlet.http.HttpServletRequest;

// @ControllerAdvice
// public class ErrorController {
    
//     @ExceptionHandler(SQLException.class)
// 	public String handleSQLException(HttpServletRequest request, Exception ex){
// 		//logger.info("SQLException Occured:: URL="+request.getRequestURL());
// 		return "database_error";
// 	}
	
// 	@ResponseStatus(value=HttpStatus.FORBIDDEN)
// 	@ExceptionHandler(Exception.class)
// 	public String handleIOException(Model model) {
// 		//logger.error("IOException handler executed");
//         String exeptionMessage = "FORBIDEN";
// 		model.addAttribute("exception", exeptionMessage);
//         return "error";
// 	}

//     // @GetMapping(value = "/error")
//     // public String errorPage() {
//     //     return "error";
//     // }
// }
