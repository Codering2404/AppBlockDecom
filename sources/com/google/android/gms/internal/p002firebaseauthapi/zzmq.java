package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class zzmq {
    static final /* synthetic */ int[] zza;

    static {
        int[] iArr = new int[zzzi.values().length];
        zza = iArr;
        try {
            iArr[zzzi.NIST_P256.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            zza[zzzi.NIST_P384.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            zza[zzzi.NIST_P521.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
