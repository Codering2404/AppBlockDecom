package com.android.billingclient.api;

import androidx.core.util.Consumer;
import com.google.android.gms.internal.play_billing.zzjd;
import java.util.Objects;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcs implements com.google.android.gms.internal.play_billing.zzcv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Consumer f57543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Runnable f57544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzcw f57545c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f57546d;

    zzcs(zzcw zzcwVar, int i3, Consumer consumer, Runnable runnable) {
        this.f57546d = i3;
        this.f57543a = consumer;
        this.f57544b = runnable;
        Objects.requireNonNull(zzcwVar);
        this.f57545c = zzcwVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzcv
    public final void zza(Throwable th) {
        if (th instanceof TimeoutException) {
            this.f57545c.Y1(zzjd.BILLING_OVERRIDE_SERVICE_CALL_TIMEOUT, 28, zzdc.E);
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClientTesting", "Asynchronous call to Billing Override Service timed out.", th);
        } else {
            this.f57545c.Y1(zzjd.BILLING_OVERRIDE_SERVICE_CALL_EXCEPTION, 28, zzdc.E);
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClientTesting", "An error occurred while retrieving billing override.", th);
        }
        this.f57544b.run();
    }

    @Override // com.google.android.gms.internal.play_billing.zzcv
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Integer num = (Integer) obj;
        int iIntValue = num.intValue();
        zzcw zzcwVar = this.f57545c;
        if (!zzcw.V1(iIntValue)) {
            this.f57544b.run();
        } else {
            this.f57543a.accept(zzcwVar.W1(this.f57546d, num.intValue()));
        }
    }
}
