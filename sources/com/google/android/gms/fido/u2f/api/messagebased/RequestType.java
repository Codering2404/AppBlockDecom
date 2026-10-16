package com.google.android.gms.fido.u2f.api.messagebased;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public enum RequestType {
    REGISTER("u2f_register_request"),
    SIGN("u2f_sign_request");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f72770a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class UnsupportedRequestTypeException extends Exception {
    }

    RequestType(String str) {
        this.f72770a = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f72770a;
    }
}
