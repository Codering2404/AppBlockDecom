package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzfk extends zzdx {
    public zzfk(String str) {
        super(str);
    }

    protected abstract boolean zzc(String str, String str2, Map map);

    @Override // com.google.android.gms.tagmanager.zzdx
    protected final boolean zzd(com.google.android.gms.internal.gtm.zzam zzamVar, com.google.android.gms.internal.gtm.zzam zzamVar2, Map map) {
        String strZzm = zzfu.zzm(zzfu.zzk(zzamVar));
        String strZzm2 = zzfu.zzm(zzfu.zzk(zzamVar2));
        if (strZzm == zzfu.zzl() || strZzm2 == zzfu.zzl()) {
            return false;
        }
        return zzc(strZzm, strZzm2, map);
    }
}
