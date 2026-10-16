package com.google.android.gms.internal.location;

import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzer {
    public static void zza(boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException();
        }
    }

    public static void zzb(boolean z2, @CheckForNull Object obj) {
        if (!z2) {
            throw new IllegalArgumentException((String) obj);
        }
    }

    public static int zzc(int i3, int i4, String str) {
        String strZza;
        if (i3 >= 0 && i3 < i4) {
            return i3;
        }
        if (i3 < 0) {
            strZza = zzes.zza("%s (%s) must not be negative", "index", Integer.valueOf(i3));
        } else {
            if (i4 < 0) {
                StringBuilder sb = new StringBuilder(String.valueOf(i4).length() + 15);
                sb.append("negative size: ");
                sb.append(i4);
                throw new IllegalArgumentException(sb.toString());
            }
            strZza = zzes.zza("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i3), Integer.valueOf(i4));
        }
        throw new IndexOutOfBoundsException(strZza);
    }

    public static int zzd(int i3, int i4, String str) {
        if (i3 < 0 || i3 > i4) {
            throw new IndexOutOfBoundsException(zzf(i3, i4, "index"));
        }
        return i3;
    }

    public static void zze(int i3, int i4, int i5) {
        if (i3 < 0 || i4 < i3 || i4 > i5) {
            throw new IndexOutOfBoundsException((i3 < 0 || i3 > i5) ? zzf(i3, i5, "start index") : (i4 < 0 || i4 > i5) ? zzf(i4, i5, "end index") : zzes.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i4), Integer.valueOf(i3)));
        }
    }

    private static String zzf(int i3, int i4, String str) {
        if (i3 < 0) {
            return zzes.zza("%s (%s) must not be negative", str, Integer.valueOf(i3));
        }
        if (i4 >= 0) {
            return zzes.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i3), Integer.valueOf(i4));
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i4).length() + 15);
        sb.append("negative size: ");
        sb.append(i4);
        throw new IllegalArgumentException(sb.toString());
    }
}
