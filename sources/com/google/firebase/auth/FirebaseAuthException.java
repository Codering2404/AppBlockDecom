package com.google.firebase.auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class FirebaseAuthException extends FirebaseException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f87769a;

    public FirebaseAuthException(String str, String str2) {
        super(str2);
        this.f87769a = Preconditions.g(str);
    }

    public String a() {
        return this.f87769a;
    }
}
