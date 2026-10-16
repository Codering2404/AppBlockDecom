package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class zzgm {
    static final /* synthetic */ int[] zza;
    static final /* synthetic */ int[] zzb;

    static {
        int[] iArr = new int[zzvy.values().length];
        zzb = iArr;
        try {
            iArr[zzvy.SHA1.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            zzb[zzvy.SHA224.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            zzb[zzvy.SHA256.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            zzb[zzvy.SHA384.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            zzb[zzvy.SHA512.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        int[] iArr2 = new int[zzxz.values().length];
        zza = iArr2;
        try {
            iArr2[zzxz.TINK.ordinal()] = 1;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            zza[zzxz.CRUNCHY.ordinal()] = 2;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            zza[zzxz.LEGACY.ordinal()] = 3;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            zza[zzxz.RAW.ordinal()] = 4;
        } catch (NoSuchFieldError unused9) {
        }
    }
}
