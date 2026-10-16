package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbly extends NativeAd.AdChoicesInfo {
    private final zzblx zza;
    private final List zzb = new ArrayList();
    private String zzc;

    public zzbly(zzblx zzblxVar) {
        zzbme zzbmcVar;
        this.zza = zzblxVar;
        try {
            this.zzc = zzblxVar.zzb();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
            this.zzc = "";
        }
        try {
            for (Object obj : zzblxVar.zzc()) {
                if (obj instanceof IBinder) {
                    IBinder iBinder = (IBinder) obj;
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    zzbmcVar = iInterfaceQueryLocalInterface instanceof zzbme ? (zzbme) iInterfaceQueryLocalInterface : new zzbmc(iBinder);
                } else {
                    zzbmcVar = null;
                }
                if (zzbmcVar != null) {
                    this.zzb.add(new zzbmf(zzbmcVar));
                }
            }
        } catch (RemoteException e4) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e4);
        }
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzb;
    }

    public final CharSequence getText() {
        return this.zzc;
    }
}
