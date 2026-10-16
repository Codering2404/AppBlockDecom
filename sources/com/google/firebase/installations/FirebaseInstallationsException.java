package com.google.firebase.installations;

import com.google.firebase.FirebaseException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class FirebaseInstallationsException extends FirebaseException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Status f89241a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Status {
        BAD_CONFIG,
        UNAVAILABLE,
        TOO_MANY_REQUESTS
    }

    public FirebaseInstallationsException(Status status) {
        this.f89241a = status;
    }

    public FirebaseInstallationsException(String str, Status status) {
        super(str);
        this.f89241a = status;
    }
}
