package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.bumptech.glide.load.data.Bwyd.SbbqvQlxi;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@ParametersAreNonnullByDefault
@Deprecated
public final class zzbiw {
    public static final void zza(zzbiv zzbivVar, zzbit zzbitVar) {
        if (zzbitVar.zzb() != null) {
            if (!TextUtils.isEmpty(zzbitVar.zzc())) {
                zzbivVar.zza(zzbitVar.zzb(), zzbitVar.zzc(), zzbitVar.zza(), zzbitVar.zzd());
                return;
            }
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
        throw new IllegalArgumentException(SbbqvQlxi.pny);
    }
}
