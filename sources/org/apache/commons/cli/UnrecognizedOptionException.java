package org.apache.commons.cli;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class UnrecognizedOptionException extends ParseException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f145255a;

    public UnrecognizedOptionException(String str) {
        super(str);
    }

    public UnrecognizedOptionException(String str, String str2) {
        this(str);
        this.f145255a = str2;
    }
}
