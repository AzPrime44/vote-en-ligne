    package sn.esp.ManSSI.logManagement;
    import java.io.*;
    import java.time.LocalDateTime;
    import java.time.format.DateTimeFormatter;

    public abstract  class LogClass {


        private static String getCurrentDateTime(String format) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            return now.format(formatter);
        }
        public static  void writeLog(String logFileName ,String riskLevel, String code, String message){
            String color;
            switch (riskLevel) {
                case "DEBUG":
                    color = "\u001B[36m"; // Light Blue
                    break;
                case "ERROR":
                    color = "\u001B[31m"; // Red
                    break;
                case "WARNING":
                    color = "\u001B[33m"; // Yellow
                    break;
                default:
                    color = "\u001B[0m"; // Reset color
                    break;
            }

            String logMessage = String.format("[%s] [%s] [%s] - %s%n", getCurrentDateTime("yyyy-MM-dd HH:mm:ss"), riskLevel, code, message);
        System.out.print(color + logMessage + "\u001B[0m"); // Reset color after printing
        String newLogFileName=logFileName+  getCurrentDateTime("yyyy-MM-dd") + ".log";
        try (FileOutputStream fos = new FileOutputStream(newLogFileName, true);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter writer = new BufferedWriter(osw)) {

            writer.write(logMessage);
        } catch (IOException e) {
            System.err.println("Erreur lors de l'enregistrement du log dans le fichier.");
            e.printStackTrace();
        }
    }
    public abstract  void logger(String riskLevel, String code, String message) ;
}

