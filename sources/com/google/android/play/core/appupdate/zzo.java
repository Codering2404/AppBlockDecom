package com.google.android.play.core.appupdate;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class zzo extends com.google.android.play.core.appupdate.internal.zzg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final com.google.android.play.core.appupdate.internal.zzm f82921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final TaskCompletionSource f82922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzr f82923c;

    zzo(zzr zzrVar, com.google.android.play.core.appupdate.internal.zzm zzmVar, TaskCompletionSource taskCompletionSource) {
        this.f82923c = zzrVar;
        this.f82921a = zzmVar;
        this.f82922b = taskCompletionSource;
    }

    @Override // com.google.android.play.core.appupdate.internal.zzh
    public void K3(Bundle bundle) {
        this.f82923c.f82928a.u(this.f82922b);
        this.f82921a.d("onRequestInfo", new Object[0]);
    }

    @Override // com.google.android.play.core.appupdate.internal.zzh
    public void zzb(Bundle bundle) {
        this.f82923c.f82928a.u(this.f82922b);
        this.f82921a.d("onCompleteUpdate", new Object[0]);
    }
}
