package com.sqav.tattow.rest;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.sqav.tattow.model.User;
import com.sqav.tattow.vo.StandardObjectReturn;

import jakarta.servlet.http.HttpServletRequest;

@Component
public class BaseRest {

    protected User getUserLoggedUser(HttpServletRequest request) {
//        return jwtService.readJwtToken(request);
        return null;
    }

    protected String getToken(HttpServletRequest request) {
        return request.getHeader("token");
    }

    protected ResponseEntity<StandardObjectReturn> createObjectReturn(Object object) {
        return ResponseEntity.ok().body(new StandardObjectReturn(HttpStatus.OK.value(), null, object));
    }

    protected ResponseEntity<StandardObjectReturn> createObjectReturn(Object object, String msg) {
        return ResponseEntity.ok().body(new StandardObjectReturn(HttpStatus.OK.value(), msg, object));
    }

	protected ResponseEntity<?> created(Serializable id) {
		Map<String, Serializable> responseBody = new HashMap<>();
		responseBody.put("created_id", id);
		return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
	}

	protected ResponseEntity<?> movedPermanently(String location) {
		return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).header("Location", location).build();
	}

	protected ResponseEntity<?> createObjectReturn(Object object, HttpStatus status) {
		return createObjectReturn(object, status, null);
	}

    protected ResponseEntity<?> createObjectReturn(Object object, HttpStatus status, String msg) {
        return ResponseEntity.status(status).body(new StandardObjectReturn(status.value(), msg, object));
    }

	@ModelAttribute
	LocalDate initLocalDate() {
	    return LocalDate.now();
	}

    protected String getIpUser(HttpServletRequest request){
        try {
             String ipAddress = request.getHeader("X-FORWARDED-FOR");  
             if (Objects.isNull(ipAddress)) {  
                 ipAddress = request.getRemoteAddr();  
             }
             return ipAddress;
        } catch (Exception e) {
            return null;
        }
     }
}