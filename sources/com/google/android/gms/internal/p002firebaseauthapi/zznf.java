package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zznf implements zzby {
    private final SharedPreferences.Editor zza;
    private final String zzb;

    public zznf(Context context, String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("keysetName cannot be null");
        }
        this.zzb = str;
        Context applicationContext = context.getApplicationContext();
        if (str2 == null) {
            this.zza = PreferenceManager.getDefaultSharedPreferences(applicationContext).edit();
        } else {
            this.zza = applicationContext.getSharedPreferences(str2, 0).edit();
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzby
    public final void zza(zzvv zzvvVar) throws IOException {
        if (!this.zza.putString(this.zzb, zzzx.zza(zzvvVar.zzk())).commit()) {
            throw new IOException("Failed to write to SharedPreferences");
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzby
    public final void zza(zzxh zzxhVar) throws IOException {
        if (!this.zza.putString(this.zzb, zzzx.zza(zzxhVar.zzk())).commit()) {
            throw new IOException("Failed to write to SharedPreferences");
        }
    }
}
