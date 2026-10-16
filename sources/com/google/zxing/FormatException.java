package com.google.zxing;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class FormatException extends ReaderException {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final FormatException f91606c;

    static {
        FormatException formatException = new FormatException();
        f91606c = formatException;
        formatException.setStackTrace(ReaderException.f91623b);
    }

    private FormatException() {
    }

    public static FormatException a() {
        return ReaderException.f91622a ? new FormatException() : f91606c;
    }
}
