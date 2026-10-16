package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.internal.zzbo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzn extends zzbo<AuthResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f88060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f88061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth f88062c;

    @Override // com.google.firebase.auth.internal.zzbo
    public final Task d(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.i("FirebaseAuth", "Creating user with " + this.f88060a + " with empty reCAPTCHA token");
        } else {
            Log.i("FirebaseAuth", "Got reCAPTCHA token for sign up with email " + this.f88060a);
        }
        FirebaseAuth firebaseAuth = this.f88062c;
        return firebaseAuth.f87745e.zza(firebaseAuth.f87741a, this.f88060a, this.f88061b, this.f88062c.f87751k, str, new FirebaseAuth.zza(this.f88062c));
    }
}
