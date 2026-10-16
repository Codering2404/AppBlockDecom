package com.google.android.gms.tagmanager;

import android.content.Context;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcv extends zzbt {
    private static final String zza = com.google.android.gms.internal.gtm.zza.INSTALL_REFERRER.toString();
    private static final String zzb = com.google.android.gms.internal.gtm.zzb.COMPONENT.toString();
    private final Context zzc;

    public zzcv(Context context) {
        super(zza, new String[0]);
        this.zzc = context;
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final com.google.android.gms.internal.gtm.zzam zza(Map map) {
        String str = zzb;
        String strZzb = zzcw.zzb(this.zzc, ((com.google.android.gms.internal.gtm.zzam) map.get(str)) != null ? zzfu.zzm(zzfu.zzk((com.google.android.gms.internal.gtm.zzam) map.get(str))) : null);
        return strZzb != null ? zzfu.zzb(strZzb) : zzfu.zza();
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final boolean zzb() {
        return true;
    }
}
