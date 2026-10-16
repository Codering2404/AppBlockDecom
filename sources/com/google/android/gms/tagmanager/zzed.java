package com.google.android.gms.tagmanager;

import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzed extends zzfk {
    private static final String zza = com.google.android.gms.internal.gtm.zza.REGEX.toString();
    private static final String zzb = com.google.android.gms.internal.gtm.zzb.IGNORE_CASE.toString();

    public zzed() {
        super(zza);
    }

    @Override // com.google.android.gms.tagmanager.zzfk
    protected final boolean zzc(String str, String str2, Map map) {
        try {
            return Pattern.compile(str2, true != zzfu.zzf(zzfu.zzk((com.google.android.gms.internal.gtm.zzam) map.get(zzb))).booleanValue() ? 64 : 66).matcher(str).find();
        } catch (PatternSyntaxException unused) {
            return false;
        }
    }
}
