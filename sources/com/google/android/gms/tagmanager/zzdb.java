package com.google.android.gms.tagmanager;

import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdb extends zzbt {
    private static final String zza = com.google.android.gms.internal.gtm.zza.LANGUAGE.toString();

    public zzdb() {
        super(zza, new String[0]);
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final com.google.android.gms.internal.gtm.zzam zza(Map map) {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return zzfu.zza();
        }
        String language = locale.getLanguage();
        return language == null ? zzfu.zza() : zzfu.zzb(language.toLowerCase());
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final boolean zzb() {
        return false;
    }
}
