package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class GoogleSignInResult implements Result {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Status f71225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GoogleSignInAccount f71226b;

    public GoogleSignInResult(GoogleSignInAccount googleSignInAccount, Status status) {
        this.f71226b = googleSignInAccount;
        this.f71225a = status;
    }

    public GoogleSignInAccount a() {
        return this.f71226b;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.f71225a;
    }
}
