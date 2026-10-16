package com.google.android.play.core.review;

import android.os.Bundle;
import android.os.RemoteException;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzf extends com.google.android.play.core.review.internal.zzj {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f83148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzi f83149c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzf(zzi zziVar, TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.f83148b = taskCompletionSource2;
        this.f83149c = zziVar;
    }

    @Override // com.google.android.play.core.review.internal.zzj
    protected final void a() {
        try {
            com.google.android.play.core.review.internal.zzf zzfVar = (com.google.android.play.core.review.internal.zzf) this.f83149c.f83154a.e();
            String str = this.f83149c.f83155b;
            Bundle bundle = new Bundle();
            Map mapA = zzj.a();
            bundle.putInt("playcore_version_code", ((Integer) mapA.get("java")).intValue());
            if (mapA.containsKey(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE)) {
                bundle.putInt("playcore_native_version", ((Integer) mapA.get(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE)).intValue());
            }
            if (mapA.containsKey("unity")) {
                bundle.putInt("playcore_unity_version", ((Integer) mapA.get("unity")).intValue());
            }
            zzi zziVar = this.f83149c;
            zzfVar.g5(str, bundle, new zzh(zziVar, this.f83148b, zziVar.f83155b));
        } catch (RemoteException e3) {
            zzi.f83153c.b(e3, "error requesting in-app review for %s", this.f83149c.f83155b);
            this.f83148b.trySetException(new RuntimeException(e3));
        }
    }
}
