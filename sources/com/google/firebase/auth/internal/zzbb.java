package com.google.firebase.auth.internal;

import android.content.Context;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthResult;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbb implements OnSuccessListener<AuthResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f87900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f87901b;

    public zzbb(zzax zzaxVar, TaskCompletionSource taskCompletionSource, Context context) {
        this.f87900a = taskCompletionSource;
        this.f87901b = context;
        Objects.requireNonNull(zzaxVar);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final /* synthetic */ void onSuccess(AuthResult authResult) {
        this.f87900a.setResult(authResult);
        zzax.d(this.f87901b);
    }
}
