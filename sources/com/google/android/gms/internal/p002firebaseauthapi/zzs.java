package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzs implements zzq {
    private zzs() {
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzq
    public final zzl zza(String str) {
        return new zzo(Pattern.compile(str));
    }
}
