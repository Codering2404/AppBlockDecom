package com.sun.jna;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class LastErrorException extends RuntimeException {
    private static final long serialVersionUID = 1;
    private int errorCode;

    public LastErrorException(String str) {
        super(parseMessage(str.trim()));
        try {
            this.errorCode = Integer.parseInt(str.startsWith("[") ? str.substring(1, str.indexOf("]")) : str);
        } catch (NumberFormatException unused) {
            this.errorCode = -1;
        }
    }

    private static String formatMessage(int i3) {
        if (Platform.isWindows()) {
            return "GetLastError() returned " + i3;
        }
        return "errno was " + i3;
    }

    private static String parseMessage(String str) {
        try {
            return formatMessage(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            return str;
        }
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public LastErrorException(int i3) {
        this(i3, formatMessage(i3));
    }

    protected LastErrorException(int i3, String str) {
        super(str);
        this.errorCode = i3;
    }
}
