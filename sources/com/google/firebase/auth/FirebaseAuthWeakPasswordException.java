package com.google.firebase.auth;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class FirebaseAuthWeakPasswordException extends FirebaseAuthInvalidCredentialsException {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f87773b;

    public FirebaseAuthWeakPasswordException(String str, String str2, String str3) {
        super(str, str2);
        this.f87773b = str3;
    }
}
