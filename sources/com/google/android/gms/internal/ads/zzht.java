package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzht {
    public static final /* synthetic */ int zzh = 0;
    public final Uri zza;
    public final int zzb;
    public final byte[] zzc;
    public final Map zzd;
    public final long zze;
    public final long zzf;
    public final int zzg;

    static {
        zzal.zzb("media3.datasource");
    }

    /* synthetic */ zzht(Uri uri, long j3, int i3, byte[] bArr, Map map, long j4, long j5, String str, int i4, Object obj, byte[] bArr2) {
        this(uri, 0L, 1, null, map, j4, j5, null, i4, null);
    }

    public final String toString() {
        String string = this.zza.toString();
        int length = string.length();
        long j3 = this.zze;
        int length2 = String.valueOf(j3).length();
        long j4 = this.zzf;
        int length3 = String.valueOf(j4).length();
        int i3 = this.zzg;
        StringBuilder sb = new StringBuilder(length + 15 + length2 + 2 + length3 + 8 + String.valueOf(i3).length() + 1);
        sb.append("DataSpec[");
        sb.append("GET");
        sb.append(" ");
        sb.append(string);
        sb.append(", ");
        sb.append(j3);
        sb.append(", ");
        sb.append(j4);
        sb.append(", null, ");
        sb.append(i3);
        sb.append("]");
        return sb.toString();
    }

    public final boolean zza(int i3) {
        return (this.zzg & i3) == i3;
    }

    public final zzhs zzb() {
        return new zzhs(this, null);
    }

    private zzht(Uri uri, long j3, int i3, byte[] bArr, Map map, long j4, long j5, String str, int i4, Object obj) {
        boolean z2 = false;
        boolean z3 = j4 >= 0;
        zzgtj.zza(z3);
        zzgtj.zza(z3);
        if (j5 > 0) {
            z2 = true;
        } else if (j5 == -1) {
            j5 = -1;
            z2 = true;
        }
        zzgtj.zza(z2);
        uri.getClass();
        this.zza = uri;
        this.zzb = 1;
        this.zzc = null;
        this.zzd = Collections.unmodifiableMap(new HashMap(map));
        this.zze = j4;
        this.zzf = j5;
        this.zzg = i4;
    }

    @Deprecated
    public zzht(Uri uri, long j3, long j4, String str) {
        this(uri, 0L, 1, null, Collections.EMPTY_MAP, j3, j4, null, 0, null);
    }
}
