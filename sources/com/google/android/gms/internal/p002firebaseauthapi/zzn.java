package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.regex.Matcher;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzn extends zzm {
    private final Matcher zza;

    zzn(Matcher matcher) {
        this.zza = (Matcher) zzu.zza(matcher);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzm
    public final int zza() {
        return this.zza.end();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzm
    public final int zzb() {
        return this.zza.start();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzm
    public final boolean zzc() {
        return this.zza.matches();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzm
    public final boolean zza(int i3) {
        return this.zza.find(i3);
    }
}
