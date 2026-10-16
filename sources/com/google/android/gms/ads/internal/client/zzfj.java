package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbrw;
import com.google.android.gms.internal.ads.zzbvc;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfj extends zzcx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private zzbrw f69943a;

    final /* synthetic */ void zzb() {
        zzbrw zzbrwVar = this.f69943a;
        if (zzbrwVar != null) {
            try {
                zzbrwVar.zzb(Collections.EMPTY_LIST);
            } catch (RemoteException e3) {
                com.google.android.gms.ads.internal.util.client.zzo.g("Could not notify onComplete event.", e3);
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zze() {
        com.google.android.gms.ads.internal.util.client.zzo.c("The initialization is not processed because MobileAdsSettingsManager is not created successfully.");
        com.google.android.gms.ads.internal.util.client.zzf.f70162b.post(new Runnable() { // from class: com.google.android.gms.ads.internal.client.zzfi
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f69942a.zzb();
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final float zzk() {
        return 1.0f;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final boolean zzl() {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final String zzm() {
        return "";
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zzp(zzbrw zzbrwVar) {
        this.f69943a = zzbrwVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final List zzq() {
        return Collections.EMPTY_LIST;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zzs() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zzw() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zzf(float f3) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zzg(String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zzh(boolean z2) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zzn(String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zzo(zzbvc zzbvcVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zzr(zzfr zzfrVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zzt(zzdk zzdkVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zzu(boolean z2) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zzv(String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zzi(IObjectWrapper iObjectWrapper, String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zzj(String str, IObjectWrapper iObjectWrapper) {
    }
}
