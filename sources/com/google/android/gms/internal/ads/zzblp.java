package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzblp extends zzbmd {
    private final Drawable zza;
    private final Uri zzb;
    private final double zzc;
    private final int zzd;
    private final int zze;
    private final Map zzf;

    public zzblp(Drawable drawable, Uri uri, double d3, int i3, int i4, Map map) {
        this.zza = drawable;
        this.zzb = uri;
        this.zzc = d3;
        this.zzd = i3;
        this.zze = i4;
        this.zzf = map;
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final IObjectWrapper zzb() throws RemoteException {
        return ObjectWrapper.i5(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final Uri zzc() throws RemoteException {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final double zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final int zze() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final int zzf() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final Map zzg() {
        return this.zzf;
    }
}
