package com.google.android.gms.ads.internal.adaptersettings;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzbhz;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class AdapterSettings {
    private static volatile AdapterSettings instance;
    private final zzbhz adapterSettingsInternal = zzba.d();

    AdapterSettings() {
    }

    private boolean getBoolean(String str, boolean z2) {
        return this.adapterSettingsInternal.zzf(str, z2);
    }

    private float getFloat(String str, float f3) {
        return this.adapterSettingsInternal.zze(str, f3);
    }

    public static AdapterSettings getInstance() {
        if (instance == null) {
            synchronized (AdapterSettings.class) {
                try {
                    if (instance == null) {
                        instance = new AdapterSettings();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    private int getInt(String str, int i3) {
        return this.adapterSettingsInternal.zzd(str, i3);
    }

    private long getLong(String str, long j3) {
        return this.adapterSettingsInternal.zzc(str, j3);
    }

    private String getString(String str, String str2) {
        return this.adapterSettingsInternal.zzb(str, str2);
    }
}
