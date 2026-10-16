package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.internal.zzbo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzq extends zzbo<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f88069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ ActionCodeSettings f88070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth f88071c;

    @Override // com.google.firebase.auth.internal.zzbo
    public final Task d(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.i("FirebaseAuth", "Password reset request " + this.f88069a + " with empty reCAPTCHA token");
        } else {
            Log.i("FirebaseAuth", "Got reCAPTCHA token for password reset of email " + this.f88069a);
        }
        FirebaseAuth firebaseAuth = this.f88071c;
        return firebaseAuth.f87745e.zza(firebaseAuth.f87741a, this.f88069a, this.f88070b, this.f88071c.f87751k, str);
    }
}
