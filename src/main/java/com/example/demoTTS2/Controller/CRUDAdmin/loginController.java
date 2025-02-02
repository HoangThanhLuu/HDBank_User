package com.example.demoTTS2.Controller.CRUDAdmin;
import com.example.demoTTS2.Model.UserEntity;
import com.example.demoTTS2.Service.IUserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class loginController {
    private final IUserService iUserService;

    public loginController(IUserService iUserService) {
        this.iUserService = iUserService;
    }
    @PostMapping("/loginAdmin")
    public ResponseEntity<?> login(@RequestBody UserEntity userEntity, HttpServletResponse response){
    String token= iUserService.loginUserAdmin(userEntity.getUsername(),userEntity.getPassword());
    response.setHeader("Authorization","Bearer "+token);
        // Tạo một đối tượng để trả về trong body (tùy chọn)
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("token", token);
        responseBody.put("message", "Login successful");

        return ResponseEntity.ok(responseBody);
    }
}
