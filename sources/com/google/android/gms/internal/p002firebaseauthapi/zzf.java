package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzf {
    protected zzf() {
    }

    public int zza(CharSequence charSequence, int i3) {
        int length = charSequence.length();
        zzu.zza(i3, length, "index");
        while (i3 < length) {
            if (zza(charSequence.charAt(i3))) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public abstract boolean zza(char c3);
}
