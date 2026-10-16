package com.google.android.gms.internal.ads;

import com.facebook.appevents.AppEventsConstants;
import java.math.BigInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcfg {
    private BigInteger zza = BigInteger.ONE;
    private String zzb = AppEventsConstants.EVENT_PARAM_VALUE_NO;

    public final synchronized String zza() {
        String string;
        string = this.zza.toString();
        this.zza = this.zza.add(BigInteger.ONE);
        this.zzb = string;
        return string;
    }

    public final synchronized String zzb() {
        return this.zzb;
    }
}
