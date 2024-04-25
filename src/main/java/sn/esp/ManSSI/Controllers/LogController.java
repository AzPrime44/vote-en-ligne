package sn.esp.ManSSI.Controllers;
import lombok.Getter;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.esp.ManSSI.logManagement.UserLog;

@RestController
class LogController{

    @GetMapping("/greeting")
    public String greeting(){
        System.out.println("bonjour");
        return "greeting";
    }
    @PostMapping("/log")
    public void log(@RequestBody LogRequest request) {
        UserLog log = new UserLog();
        log.logger(request.getRiskLevel(), request.getCode(), request.getMessage());
    }

    @Getter
    static class LogRequest {
        private String riskLevel;
        private String code;
        private String message;
    }
}


