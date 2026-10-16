package com.google.android.play.core.appupdate;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzm extends com.google.android.play.core.appupdate.internal.zzn {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f82915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f82916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzr f82917d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzm(zzr zzrVar, TaskCompletionSource taskCompletionSource, String str, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.f82917d = zzrVar;
        this.f82915b = str;
        this.f82916c = taskCompletionSource2;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.os.IInterface, com.google.android.play.core.appupdate.internal.zzf] */
    @Override // com.google.android.play.core.appupdate.internal.zzn
    protected final void a() {
        try {
            ?? E = this.f82917d.f82928a.e();
            zzr zzrVar = this.f82917d;
            E.Y4(zzrVar.f82929b, zzr.b(zzrVar, this.f82915b), new zzq(this.f82917d, this.f82916c, this.f82915b));
        } catch (RemoteException e3) {
            zzr.f82926e.c(e3, "requestUpdateInfo(%s)", this.f82915b);
            this.f82916c.trySetException(new RuntimeException(e3));
        }
    }
}
