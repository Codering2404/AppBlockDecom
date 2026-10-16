package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.Serializable;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzo extends zzl implements Serializable {
    private final Pattern zza;

    zzo(Pattern pattern) {
        this.zza = (Pattern) zzu.zza(pattern);
    }

    public final String toString() {
        return this.zza.toString();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzl
    public final zzm zza(CharSequence charSequence) {
        return new zzn(this.zza.matcher(charSequence));
    }
}
