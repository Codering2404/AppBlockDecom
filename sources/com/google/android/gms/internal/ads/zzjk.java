package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzjk extends zzau {
    public final int zzc;
    public final String zzd;
    public final int zze;
    public final zzv zzf;
    public final int zzg;
    public final zzxk zzh;
    final boolean zzi;

    private zzjk(int i3, Throwable th, int i4) {
        this(i3, th, null, i4, null, -1, null, 4, null, false);
    }

    public static zzjk zza(IOException iOException, int i3) {
        return new zzjk(0, iOException, i3);
    }

    public static zzjk zzb(Throwable th, String str, int i3, zzv zzvVar, int i4, zzxk zzxkVar, boolean z2, int i5) {
        if (zzvVar == null) {
            i4 = 4;
        }
        return new zzjk(1, th, null, i5, str, i3, zzvVar, i4, zzxkVar, z2);
    }

    public static zzjk zzc(RuntimeException runtimeException, int i3) {
        return new zzjk(2, runtimeException, i3);
    }

    final zzjk zzd(zzxk zzxkVar) {
        String message = getMessage();
        String str = zzfl.zza;
        return new zzjk(message, getCause(), this.zza, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, zzxkVar, this.zzb, this.zzi);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private zzjk(int i3, Throwable th, String str, int i4, String str2, int i5, zzv zzvVar, int i6, zzxk zzxkVar, boolean z2) {
        String str3;
        int i7;
        String string;
        String str4;
        if (i3 == 0) {
            str3 = str2;
            i7 = i5;
            string = "Source error";
        } else if (i3 != 1) {
            string = "Unexpected runtime error";
            str3 = str2;
            i7 = i5;
        } else {
            String strValueOf = String.valueOf(zzvVar);
            String str5 = zzfl.zza;
            if (i6 == 0) {
                str4 = "NO";
            } else if (i6 == 1) {
                str4 = "NO_UNSUPPORTED_SUBTYPE";
            } else if (i6 == 2) {
                str4 = "NO_UNSUPPORTED_DRM";
            } else if (i6 == 3) {
                str4 = "NO_EXCEEDS_CAPABILITIES";
            } else {
                if (i6 != 4) {
                    throw new IllegalStateException();
                }
                str4 = "YES";
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 14 + String.valueOf(i5).length() + 9 + strValueOf.length() + 19 + str4.length());
            str3 = str2;
            sb.append(str3);
            sb.append(" error, index=");
            i7 = i5;
            sb.append(i7);
            sb.append(", format=");
            sb.append(strValueOf);
            sb.append(", format_supported=");
            sb.append(str4);
            string = sb.toString();
        }
        this(TextUtils.isEmpty(null) ? string : string.concat(": null"), th, i4, i3, str3, i7, zzvVar, i6, zzxkVar, SystemClock.elapsedRealtime(), z2);
    }

    private zzjk(String str, Throwable th, int i3, int i4, String str2, int i5, zzv zzvVar, int i6, zzxk zzxkVar, long j3, boolean z2) {
        boolean z3;
        super(str, th, i3, Bundle.EMPTY, j3);
        if (!z2) {
            z3 = true;
        } else if (i4 == 1) {
            i4 = 1;
            z3 = true;
        } else {
            z3 = false;
        }
        zzgtj.zza(z3);
        zzgtj.zza(th != null);
        this.zzc = i4;
        this.zzd = str2;
        this.zze = i5;
        this.zzf = zzvVar;
        this.zzg = i6;
        this.zzh = zzxkVar;
        this.zzi = z2;
    }
}
