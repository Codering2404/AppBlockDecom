package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzmc implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f74220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f74221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzr f74222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f74223d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcu f74224f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ zznl f74225g;

    zzmc(zznl zznlVar, String str, String str2, zzr zzrVar, boolean z2, com.google.android.gms.internal.measurement.zzcu zzcuVar) {
        this.f74220a = str;
        this.f74221b = str2;
        this.f74222c = zzrVar;
        this.f74223d = z2;
        this.f74224f = zzcuVar;
        Objects.requireNonNull(zznlVar);
        this.f74225g = zznlVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        Bundle bundle;
        RemoteException e3;
        Bundle bundle2 = new Bundle();
        try {
            zznl zznlVar = this.f74225g;
            zzgb zzgbVarN = zznlVar.N();
            if (zzgbVarN == null) {
                zzic zzicVar = zznlVar.f73997a;
                zzicVar.a().o().c("Failed to get user properties; not connected to service", this.f74220a, this.f74221b);
                zzicVar.C().f0(this.f74224f, bundle2);
                return;
            }
            zzr zzrVar = this.f74222c;
            Preconditions.m(zzrVar);
            List<zzpl> listK4 = zzgbVarN.K4(this.f74220a, this.f74221b, this.f74223d, zzrVar);
            int i3 = zzpp.f74491k;
            bundle = new Bundle();
            if (listK4 != null) {
                for (zzpl zzplVar : listK4) {
                    String str = zzplVar.f74481f;
                    if (str != null) {
                        bundle.putString(zzplVar.f74478b, str);
                    } else {
                        Long l3 = zzplVar.f74480d;
                        if (l3 != null) {
                            bundle.putLong(zzplVar.f74478b, l3.longValue());
                        } else {
                            Double d3 = zzplVar.f74483h;
                            if (d3 != null) {
                                bundle.putDouble(zzplVar.f74478b, d3.doubleValue());
                            }
                        }
                    }
                }
            }
            try {
                try {
                    zznlVar.J();
                    zzic zzicVar2 = zznlVar.f73997a;
                    zzicVar2.C().f0(this.f74224f, bundle);
                } catch (RemoteException e4) {
                    e3 = e4;
                    this.f74225g.f73997a.a().o().c("Failed to get user properties; remote exception", this.f74220a, e3);
                    zznl zznlVar2 = this.f74225g;
                    zznlVar2.f73997a.C().f0(this.f74224f, bundle);
                }
            } catch (Throwable th) {
                th = th;
                bundle2 = bundle;
                zznl zznlVar3 = this.f74225g;
                zznlVar3.f73997a.C().f0(this.f74224f, bundle2);
                throw th;
            }
        } catch (RemoteException e5) {
            bundle = bundle2;
            e3 = e5;
        } catch (Throwable th2) {
            th = th2;
            zznl zznlVar32 = this.f74225g;
            zznlVar32.f73997a.C().f0(this.f74224f, bundle2);
            throw th;
        }
    }
}
