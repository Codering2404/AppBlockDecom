package com.google.android.play.core.appupdate;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzn extends com.google.android.play.core.appupdate.internal.zzn {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f82918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f82919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzr f82920d;

    /* JADX WARN: Type inference failed for: r0v3, types: [android.os.IInterface, com.google.android.play.core.appupdate.internal.zzf] */
    @Override // com.google.android.play.core.appupdate.internal.zzn
    protected final void a() {
        try {
            this.f82920d.f82928a.e().C4(this.f82920d.f82929b, zzr.h(), new zzp(this.f82920d, this.f82918b));
        } catch (RemoteException e3) {
            zzr.f82926e.c(e3, "completeUpdate(%s)", this.f82919c);
            this.f82918b.trySetException(new RuntimeException(e3));
        }
    }
}
