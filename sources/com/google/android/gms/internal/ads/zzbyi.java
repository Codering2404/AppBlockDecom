package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.nativead.NativeAd;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbyi extends NativeAd.AdChoicesInfo {
    private final List zza = new ArrayList();
    private String zzb;

    public zzbyi(zzblx zzblxVar) {
        try {
            this.zzb = zzblxVar.zzb();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
            this.zzb = "";
        }
        try {
            for (Object obj : zzblxVar.zzc()) {
                zzbme zzbmeVarZzh = obj instanceof IBinder ? zzbmd.zzh((IBinder) obj) : null;
                if (zzbmeVarZzh != null) {
                    this.zza.add(new zzbyk(zzbmeVarZzh));
                }
            }
        } catch (RemoteException e4) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e4);
        }
    }

    public final List<NativeAd.Image> getImages() {
        return this.zza;
    }

    public final CharSequence getText() {
        return this.zzb;
    }
}
