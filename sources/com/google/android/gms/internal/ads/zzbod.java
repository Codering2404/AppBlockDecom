package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.formats.OnAdManagerAdViewLoadedListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbod extends zzbnl {
    private final OnAdManagerAdViewLoadedListener zza;

    public zzbod(OnAdManagerAdViewLoadedListener onAdManagerAdViewLoadedListener) {
        this.zza = onAdManagerAdViewLoadedListener;
    }

    final /* synthetic */ OnAdManagerAdViewLoadedListener zzc() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzbnm
    public final void zze(com.google.android.gms.ads.internal.client.zzbu zzbuVar, IObjectWrapper iObjectWrapper) {
        if (zzbuVar == null || iObjectWrapper == null) {
            return;
        }
        AdManagerAdView adManagerAdView = new AdManagerAdView((Context) ObjectWrapper.h5(iObjectWrapper));
        try {
            if (zzbuVar.zzw() instanceof com.google.android.gms.ads.internal.client.zzg) {
                com.google.android.gms.ads.internal.client.zzg zzgVar = (com.google.android.gms.ads.internal.client.zzg) zzbuVar.zzw();
                adManagerAdView.setAdListener(zzgVar != null ? zzgVar.x3() : null);
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
        }
        try {
            if (zzbuVar.zzv() instanceof zzbff) {
                zzbff zzbffVar = (zzbff) zzbuVar.zzv();
                adManagerAdView.setAppEventListener(zzbffVar != null ? zzbffVar.zzc() : null);
            }
        } catch (RemoteException e4) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e4);
        }
        com.google.android.gms.ads.internal.util.client.zzf.f70162b.post(new zzboc(this, adManagerAdView, zzbuVar));
    }
}
