package com.android.billingclient.api;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.internal.play_billing.zziu;
import com.google.android.gms.internal.play_billing.zziw;
import com.google.android.gms.internal.play_billing.zziy;
import com.google.android.gms.internal.play_billing.zzja;
import com.google.android.gms.internal.play_billing.zzjb;
import com.google.android.gms.internal.play_billing.zzjd;
import com.google.android.gms.internal.play_billing.zzjf;
import com.google.android.gms.internal.play_billing.zzji;
import com.google.android.gms.internal.play_billing.zzkl;
import com.google.android.gms.internal.play_billing.zzkn;
import com.google.android.gms.internal.play_billing.zzkr;
import com.google.android.gms.internal.play_billing.zzks;
import com.google.android.gms.internal.play_billing.zzku;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbw implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BillingClientStateListener f57487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.gms.internal.play_billing.zzbl f57488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.android.gms.internal.play_billing.zzbl f57489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f57490d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ BillingClientImpl f57491f;

    /* synthetic */ zzbw(BillingClientImpl billingClientImpl, BillingClientStateListener billingClientStateListener, int i3, zzch zzchVar) {
        Objects.requireNonNull(billingClientImpl);
        this.f57491f = billingClientImpl;
        this.f57488b = com.google.android.gms.internal.play_billing.zzbl.zzc(billingClientImpl.K);
        this.f57489c = com.google.android.gms.internal.play_billing.zzbl.zzc(billingClientImpl.K);
        this.f57487a = billingClientStateListener;
        this.f57490d = i3;
    }

    public static /* synthetic */ Object a(zzbw zzbwVar) {
        Bundle bundle;
        com.google.android.gms.internal.play_billing.zzap zzapVar;
        BillingClientImpl billingClientImpl = zzbwVar.f57491f;
        synchronized (billingClientImpl.f57164a) {
            try {
                if (billingClientImpl.f57165b != 3) {
                    boolean z2 = true;
                    if (billingClientImpl.f57165b != 1) {
                        z2 = false;
                    }
                    if (TextUtils.isEmpty(null)) {
                        bundle = null;
                    } else {
                        bundle = new Bundle();
                        bundle.putString("accountName", null);
                        com.google.android.gms.internal.play_billing.zzc.zzc(bundle, billingClientImpl.f57166c, billingClientImpl.f57167d, billingClientImpl.J.longValue());
                    }
                    zzjd zzjdVar = zzjd.REASON_UNSPECIFIED;
                    synchronized (billingClientImpl.f57164a) {
                        zzapVar = billingClientImpl.f57172i;
                    }
                    if (zzapVar == null) {
                        BillingClientImpl billingClientImpl2 = zzbwVar.f57491f;
                        billingClientImpl2.V0(0);
                        int i3 = zzbwVar.f57490d;
                        zzjd zzjdVar2 = zzjd.SERVICE_RESET_TO_NULL;
                        BillingResult billingResult = zzdc.f57560j;
                        billingClientImpl2.U0(zzjdVar2, billingResult, i3);
                        zzbwVar.g(billingResult);
                    } else {
                        BillingClientImpl billingClientImpl3 = zzbwVar.f57491f;
                        String packageName = billingClientImpl3.f57170g.getPackageName();
                        int i4 = 27;
                        int iZzb = 3;
                        int i5 = 27;
                        while (true) {
                            if (i5 < 3) {
                                i5 = 0;
                                break;
                            }
                            try {
                                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "trying subs apiVersion: " + i5);
                                iZzb = bundle == null ? zzapVar.zzb(i5, packageName, "subs") : zzapVar.zzc(i5, packageName, "subs", bundle);
                                if (iZzb == 0) {
                                    com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "highestLevelSupportedForSubs: " + i5);
                                    break;
                                }
                                i5--;
                            } catch (Exception e3) {
                                com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Exception while checking if billing is supported; try to reconnect", e3);
                                zzjd zzjdVar3 = e3 instanceof DeadObjectException ? zzjd.IS_BILLING_SUPPORTED_DEAD_OBJECT_EXCEPTION : e3 instanceof RemoteException ? zzjd.IS_BILLING_SUPPORTED_REMOTE_EXCEPTION : e3 instanceof SecurityException ? zzjd.IS_BILLING_SUPPORTED_SECURITY_EXCEPTION : zzjd.IS_BILLING_SUPPORTED_SERVICE_CALL_EXCEPTION;
                                String strA = zzjdVar3.equals(zzjd.IS_BILLING_SUPPORTED_SERVICE_CALL_EXCEPTION) ? zzcy.a(e3) : null;
                                zzbwVar.f57491f.V0(0);
                                zzbwVar.f(BillingClientImpl.x1(e3), zzjdVar3, strA, z2, 0);
                                zzbwVar.g(BillingClientImpl.x1(e3));
                            }
                        }
                        billingClientImpl3.f57175l = i5 >= 5;
                        billingClientImpl3.f57174k = i5 >= 3;
                        if (i5 < 3) {
                            zzjdVar = zzjd.SUBSCRIPTIONS_NOT_SUPPORTED;
                            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "In-app billing API does not support subscription on this device.");
                        }
                        while (true) {
                            if (i4 < 3) {
                                break;
                            }
                            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "trying inapp apiVersion: " + i4);
                            iZzb = bundle == null ? zzapVar.zzb(i4, packageName, "inapp") : zzapVar.zzc(i4, packageName, "inapp", bundle);
                            if (iZzb == 0) {
                                billingClientImpl3.f57176m = i4;
                                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "mHighestLevelSupportedForInApp: " + billingClientImpl3.f57176m);
                                break;
                            }
                            i4--;
                        }
                        BillingClientImpl.y0(billingClientImpl3, billingClientImpl3.f57176m);
                        if (billingClientImpl3.f57176m < 3) {
                            zzjdVar = zzjd.ONE_TIME_PRODUCT_NOT_SUPPORTED;
                            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "In-app billing API version 3 is not supported on this device.");
                        }
                        zzjd zzjdVar4 = zzjdVar;
                        BillingClientImpl.A0(billingClientImpl3, iZzb);
                        if (iZzb != 0) {
                            BillingResult billingResult2 = zzdc.f57552b;
                            zzbwVar.f(billingResult2, zzjdVar4, null, z2, 0);
                            zzbwVar.g(billingResult2);
                        } else {
                            try {
                                Long lE = zzbwVar.e(z2);
                                if (z2) {
                                    zziy zziyVarZza = zzja.zza();
                                    zziyVarZza.zze(6);
                                    zzks zzksVarZza = zzku.zza();
                                    int i6 = zzbwVar.f57490d;
                                    zzksVarZza.zza(i6 > 0);
                                    zzksVarZza.zzb(i6);
                                    zzksVarZza.zzd(0);
                                    if (lE != null) {
                                        zzksVarZza.zzc(lE.longValue());
                                    }
                                    BillingClientImpl billingClientImpl4 = zzbwVar.f57491f;
                                    zziyVarZza.zzd(zzksVarZza);
                                    billingClientImpl4.T0((zzja) zziyVarZza.zzi());
                                } else {
                                    zzkl zzklVarZza = zzkn.zza();
                                    zzjb zzjbVarZza = zzjf.zza();
                                    zzjbVarZza.zzp(0);
                                    zzjbVarZza.zzc(0);
                                    zzklVarZza.zza(zzjbVarZza);
                                    if (lE != null) {
                                        zzklVarZza.zzb(lE.longValue());
                                    }
                                    zzbwVar.f57491f.f57171h.e((zzkn) zzklVarZza.zzi());
                                }
                            } catch (Throwable th) {
                                com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Unable to log.", th);
                            }
                            zzbwVar.g(zzdc.f57559i);
                        }
                    }
                }
            } finally {
            }
        }
        return null;
    }

    public static /* synthetic */ void b(zzbw zzbwVar) {
        BillingClientImpl billingClientImpl = zzbwVar.f57491f;
        billingClientImpl.V0(0);
        zzjd zzjdVar = zzjd.EXECUTE_ASYNC_TIMEOUT;
        BillingResult billingResult = zzdc.f57561k;
        billingClientImpl.U0(zzjdVar, billingResult, zzbwVar.f57490d);
        zzbwVar.g(billingResult);
    }

    private final Long e(boolean z2) {
        try {
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Exception getting connection establishment duration.", th);
        }
        if (z2) {
            synchronized (this.f57491f.f57164a) {
                try {
                    com.google.android.gms.internal.play_billing.zzbl zzblVar = this.f57488b;
                    if (!zzblVar.zzg()) {
                        return null;
                    }
                    zzblVar.zzf();
                    return Long.valueOf(zzblVar.zza(TimeUnit.MILLISECONDS));
                } finally {
                }
            }
        }
        synchronized (this.f57491f.f57164a) {
            try {
                com.google.android.gms.internal.play_billing.zzbl zzblVar2 = this.f57489c;
                if (!zzblVar2.zzg()) {
                    return null;
                }
                zzblVar2.zzf();
                return Long.valueOf(zzblVar2.zza(TimeUnit.MILLISECONDS));
            } finally {
            }
        }
        com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Exception getting connection establishment duration.", th);
        return null;
    }

    private final void f(BillingResult billingResult, zzjd zzjdVar, String str, boolean z2, int i3) {
        try {
            zzjb zzjbVarZza = zzjf.zza();
            zzjbVarZza.zzp(billingResult.c());
            zzjbVarZza.zzb(billingResult.a());
            zzjbVarZza.zze(zzjdVar);
            zzjbVarZza.zzc(0);
            if (str != null) {
                zzjbVarZza.zza(str);
            }
            Long lE = e(z2);
            if (!z2) {
                zzkl zzklVarZza = zzkn.zza();
                zzklVarZza.zza(zzjbVarZza);
                if (lE != null) {
                    zzklVarZza.zzb(lE.longValue());
                }
                this.f57491f.f57171h.e((zzkn) zzklVarZza.zzi());
                return;
            }
            zzks zzksVarZza = zzku.zza();
            int i4 = this.f57490d;
            zzksVarZza.zza(i4 > 0);
            zzksVarZza.zzb(i4);
            zzksVarZza.zzd(0);
            if (lE != null) {
                zzksVarZza.zzc(lE.longValue());
            }
            BillingClientImpl billingClientImpl = this.f57491f;
            zziu zziuVarZza = zziw.zza();
            zziuVarZza.zzb(zzjbVarZza);
            zziuVarZza.zzp(6);
            zziuVarZza.zze(zzksVarZza);
            billingClientImpl.R0((zziw) zziuVarZza.zzi());
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Unable to log.", th);
        }
    }

    private final void g(BillingResult billingResult) {
        BillingClientImpl billingClientImpl = this.f57491f;
        synchronized (billingClientImpl.f57164a) {
            try {
                if (billingClientImpl.f57165b == 3) {
                    return;
                }
                try {
                    this.f57487a.onBillingSetupFinished(billingResult);
                } catch (Throwable th) {
                    com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Exception while calling onBillingSetupFinished.", th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void c() {
        synchronized (this.f57491f.f57164a) {
            com.google.android.gms.internal.play_billing.zzbl zzblVar = this.f57488b;
            zzblVar.zzd();
            zzblVar.zze();
        }
    }

    final boolean d() {
        return this.f57490d > 0;
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Billing service died.");
        try {
            BillingClientImpl billingClientImpl = this.f57491f;
            if (BillingClientImpl.E0(billingClientImpl)) {
                zzcz zzczVar = billingClientImpl.f57171h;
                zziu zziuVarZza = zziw.zza();
                zziuVarZza.zzp(6);
                zzjb zzjbVarZza = zzjf.zza();
                zzjbVarZza.zze(zzjd.BINDING_DIED);
                zziuVarZza.zzb(zzjbVarZza);
                zzks zzksVarZza = zzku.zza();
                int i3 = this.f57490d;
                zzksVarZza.zza(i3 > 0);
                zzksVarZza.zzb(i3);
                zziuVarZza.zze(zzksVarZza);
                zzczVar.k((zziw) zziuVarZza.zzi());
            } else {
                billingClientImpl.f57171h.b(zzji.zzb());
            }
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Unable to log.", th);
        }
        BillingClientImpl billingClientImpl2 = this.f57491f;
        synchronized (billingClientImpl2.f57164a) {
            if (billingClientImpl2.f57165b != 3 && billingClientImpl2.f57165b != 0) {
                billingClientImpl2.V0(0);
                billingClientImpl2.Y0();
                try {
                    this.f57487a.onBillingServiceDisconnected();
                } catch (Throwable th2) {
                    com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Exception while calling onBillingServiceDisconnected.", th2);
                }
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Billing service connected.");
        BillingClientImpl billingClientImpl = this.f57491f;
        synchronized (billingClientImpl.f57164a) {
            try {
                if (billingClientImpl.f57165b == 3) {
                    return;
                }
                billingClientImpl.f57172i = com.google.android.gms.internal.play_billing.zzao.zzt(iBinder);
                if (BillingClientImpl.y(new Callable() { // from class: com.android.billingclient.api.zzbu
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        zzbw.a(this.f57485a);
                        return null;
                    }
                }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzbv
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzbw.b(this.f57486a);
                    }
                }, billingClientImpl.J0(), billingClientImpl.x()) == null) {
                    int i3 = this.f57490d;
                    BillingResult billingResultM0 = billingClientImpl.M0();
                    billingClientImpl.U0(zzjd.MISSING_RESULT_FROM_EXECUTE_ASYNC, billingResultM0, i3);
                    g(billingResultM0);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Billing service disconnected.");
        try {
            BillingClientImpl billingClientImpl = this.f57491f;
            if (BillingClientImpl.E0(billingClientImpl)) {
                zzcz zzczVar = billingClientImpl.f57171h;
                zziu zziuVarZza = zziw.zza();
                zziuVarZza.zzp(6);
                zzjb zzjbVarZza = zzjf.zza();
                zzjbVarZza.zze(zzjd.SERVICE_DISCONNECTED);
                zziuVarZza.zzb(zzjbVarZza);
                zzks zzksVarZza = zzku.zza();
                int i3 = this.f57490d;
                zzksVarZza.zza(i3 > 0);
                zzksVarZza.zzb(i3);
                zziuVarZza.zze(zzksVarZza);
                zzczVar.k((zziw) zziuVarZza.zzi());
            } else {
                billingClientImpl.f57171h.h(zzkr.zzb());
            }
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Unable to log.", th);
        }
        BillingClientImpl billingClientImpl2 = this.f57491f;
        synchronized (billingClientImpl2.f57164a) {
            try {
                com.google.android.gms.internal.play_billing.zzbl zzblVar = this.f57489c;
                zzblVar.zzd();
                zzblVar.zze();
                if (billingClientImpl2.f57165b == 3) {
                    return;
                }
                billingClientImpl2.V0(0);
                try {
                    this.f57487a.onBillingServiceDisconnected();
                } catch (Throwable th2) {
                    com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Exception while calling onBillingServiceDisconnected.", th2);
                }
            } finally {
            }
        }
    }
}
