package com.google.firebase.auth.internal;

import android.util.Log;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuthException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzh implements OnFailureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f87986a;

    public zzh(zzb zzbVar, TaskCompletionSource taskCompletionSource) {
        this.f87986a = taskCompletionSource;
        Objects.requireNonNull(zzbVar);
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        Log.e(zzb.f87895b, String.format("Failed to get reCAPTCHA token with error [%s]- calling backend without app verification", exc.getMessage()));
        if ((exc instanceof FirebaseAuthException) && ((FirebaseAuthException) exc).a().endsWith("UNAUTHORIZED_DOMAIN")) {
            this.f87986a.setException(exc);
        } else {
            this.f87986a.setResult(new zzm().b());
        }
    }
}
