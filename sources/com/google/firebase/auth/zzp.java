package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.internal.zzbo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzp extends zzbo<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f88066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ ActionCodeSettings f88067b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth f88068c;

    @Override // com.google.firebase.auth.internal.zzbo
    public final Task d(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.i("FirebaseAuth", "Email link sign in for " + this.f88066a + " with empty reCAPTCHA token");
        } else {
            Log.i("FirebaseAuth", "Got reCAPTCHA token for email link sign in for " + this.f88066a);
        }
        FirebaseAuth firebaseAuth = this.f88068c;
        return firebaseAuth.f87745e.zzb(firebaseAuth.f87741a, this.f88066a, this.f88067b, this.f88068c.f87751k, str);
    }
}
