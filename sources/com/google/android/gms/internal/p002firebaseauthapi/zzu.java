package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzu {
    public static int zza(int i3, int i4) {
        String strZza;
        if (i3 >= 0 && i3 < i4) {
            return i3;
        }
        if (i3 < 0) {
            strZza = zzac.zza("%s (%s) must not be negative", "index", Integer.valueOf(i3));
        } else {
            if (i4 < 0) {
                throw new IllegalArgumentException("negative size: " + i4);
            }
            strZza = zzac.zza("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i3), Integer.valueOf(i4));
        }
        throw new IndexOutOfBoundsException(strZza);
    }

    public static int zzb(int i3, int i4) {
        if (i3 < 0 || i3 > i4) {
            throw new IndexOutOfBoundsException(zzb(i3, i4, "index"));
        }
        return i3;
    }

    private static String zzb(int i3, int i4, String str) {
        if (i3 < 0) {
            return zzac.zza("%s (%s) must not be negative", str, Integer.valueOf(i3));
        }
        if (i4 >= 0) {
            return zzac.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i3), Integer.valueOf(i4));
        }
        throw new IllegalArgumentException("negative size: " + i4);
    }

    public static int zza(int i3, int i4, String str) {
        if (i3 < 0 || i3 > i4) {
            throw new IndexOutOfBoundsException(zzb(i3, i4, str));
        }
        return i3;
    }

    public static <T> T zza(T t2) {
        t2.getClass();
        return t2;
    }

    public static void zza(boolean z2, Object obj) {
        if (!z2) {
            throw new IllegalArgumentException(zzp.zza(obj));
        }
    }

    public static void zza(int i3, int i4, int i5) {
        String strZzb;
        if (i3 < 0 || i4 < i3 || i4 > i5) {
            if (i3 < 0 || i3 > i5) {
                strZzb = zzb(i3, i5, "start index");
            } else if (i4 >= 0 && i4 <= i5) {
                strZzb = zzac.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i4), Integer.valueOf(i3));
            } else {
                strZzb = zzb(i4, i5, "end index");
            }
            throw new IndexOutOfBoundsException(strZzb);
        }
    }
}
