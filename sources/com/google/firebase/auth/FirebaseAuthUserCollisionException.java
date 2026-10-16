package com.google.firebase.auth;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class FirebaseAuthUserCollisionException extends FirebaseAuthException {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AuthCredential f87771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f87772c;

    public FirebaseAuthUserCollisionException(String str, String str2) {
        super(str, str2);
    }

    public final FirebaseAuthUserCollisionException b(AuthCredential authCredential) {
        this.f87771b = authCredential;
        return this;
    }

    public final FirebaseAuthUserCollisionException c(String str) {
        this.f87772c = str;
        return this;
    }
}
