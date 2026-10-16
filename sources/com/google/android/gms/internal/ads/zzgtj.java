package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgtj {
    public static void zza(boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException();
        }
    }

    public static void zzb(boolean z2, Object obj) {
        if (!z2) {
            throw new IllegalArgumentException((String) obj);
        }
    }

    public static void zzc(boolean z2, String str, char c3) {
        if (!z2) {
            throw new IllegalArgumentException(zzgua.zzd(str, Character.valueOf(c3)));
        }
    }

    public static void zzd(boolean z2, String str, int i3) {
        if (!z2) {
            throw new IllegalArgumentException(zzgua.zzd(str, Integer.valueOf(i3)));
        }
    }

    public static void zze(boolean z2, String str, long j3) {
        if (!z2) {
            throw new IllegalArgumentException(zzgua.zzd(str, Long.valueOf(j3)));
        }
    }

    public static void zzf(boolean z2, String str, Object obj) {
        if (!z2) {
            throw new IllegalArgumentException(zzgua.zzd(str, obj));
        }
    }

    public static void zzg(boolean z2, String str, int i3, int i4) {
        if (!z2) {
            throw new IllegalArgumentException(zzgua.zzd(str, Integer.valueOf(i3), Integer.valueOf(i4)));
        }
    }

    public static void zzh(boolean z2, String str, Object obj, Object obj2) {
        if (!z2) {
            throw new IllegalArgumentException(zzgua.zzd(str, obj, obj2));
        }
    }

    public static void zzi(boolean z2) {
        if (!z2) {
            throw new IllegalStateException();
        }
    }

    public static void zzj(boolean z2, Object obj) {
        if (!z2) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static Object zzk(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException((String) obj2);
    }

    public static Object zzl(Object obj, String str, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(zzgua.zzd(str, obj2));
    }

    public static int zzm(int i3, int i4, String str) {
        String strZzd;
        if (i3 >= 0 && i3 < i4) {
            return i3;
        }
        if (i3 < 0) {
            strZzd = zzgua.zzd("%s (%s) must not be negative", "index", Integer.valueOf(i3));
        } else {
            if (i4 < 0) {
                StringBuilder sb = new StringBuilder(String.valueOf(i4).length() + 15);
                sb.append("negative size: ");
                sb.append(i4);
                throw new IllegalArgumentException(sb.toString());
            }
            strZzd = zzgua.zzd("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i3), Integer.valueOf(i4));
        }
        throw new IndexOutOfBoundsException(strZzd);
    }

    public static int zzn(int i3, int i4, String str) {
        if (i3 < 0 || i3 > i4) {
            throw new IndexOutOfBoundsException(zzp(i3, i4, "index"));
        }
        return i3;
    }

    public static void zzo(int i3, int i4, int i5) {
        if (i3 < 0 || i4 < i3 || i4 > i5) {
            throw new IndexOutOfBoundsException((i3 < 0 || i3 > i5) ? zzp(i3, i5, "start index") : (i4 < 0 || i4 > i5) ? zzp(i4, i5, "end index") : zzgua.zzd("end index (%s) must not be less than start index (%s)", Integer.valueOf(i4), Integer.valueOf(i3)));
        }
    }

    private static String zzp(int i3, int i4, String str) {
        if (i3 < 0) {
            return zzgua.zzd("%s (%s) must not be negative", str, Integer.valueOf(i3));
        }
        if (i4 >= 0) {
            return zzgua.zzd("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i3), Integer.valueOf(i4));
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i4).length() + 15);
        sb.append("negative size: ");
        sb.append(i4);
        throw new IllegalArgumentException(sb.toString());
    }
}
