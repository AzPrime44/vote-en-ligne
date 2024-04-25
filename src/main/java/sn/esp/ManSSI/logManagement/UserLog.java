package sn.esp.ManSSI.logManagement;

public class UserLog extends LogClass{

    @Override
    public void  logger(String riskLevel, String code, String message) {
        String logFileName = "logs/usersLog/usersLog-";
        writeLog(logFileName,riskLevel,code,message);

    }
}
