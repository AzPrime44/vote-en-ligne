package sn.esp.ManSSI.logManagement;

public class SystemLog extends LogClass{

    @Override
    public void logger(String riskLevel, String code, String message) {
        String logFileName = "logs/systemLog/systemLog-";
        writeLog(logFileName,riskLevel,code,message);

    }
}
