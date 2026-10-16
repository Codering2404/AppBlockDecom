package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfv implements zzao {
    public final String zza;
    public final byte[] zzb;
    public final int zzc;
    public final int zzd;

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzfv(java.lang.String r5, byte[] r6, int r7, int r8) {
        /*
            r4 = this;
            r4.<init>()
            int r0 = r5.hashCode()
            r1 = 1
            r2 = 0
            switch(r0) {
                case -1949883051: goto L5e;
                case -269399509: goto L41;
                case 1011693540: goto L28;
                case 1098277265: goto L1f;
                case 2002123038: goto Le;
                default: goto Lc;
            }
        Lc:
            goto L75
        Le:
            java.lang.String r0 = "auxiliary.tracks.map"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L75
            if (r8 != 0) goto L19
            goto L1a
        L19:
            r1 = r2
        L1a:
            com.google.android.gms.internal.ads.zzgtj.zza(r1)
            goto L75
        L1f:
            java.lang.String r0 = "auxiliary.tracks.offset"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L75
            goto L30
        L28:
            java.lang.String r0 = "auxiliary.tracks.length"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L75
        L30:
            r0 = 78
            if (r8 != r0) goto L3c
            int r8 = r6.length
            r3 = 8
            if (r8 != r3) goto L3b
            r8 = r0
            goto L3d
        L3b:
            r8 = r0
        L3c:
            r1 = r2
        L3d:
            com.google.android.gms.internal.ads.zzgtj.zza(r1)
            goto L75
        L41:
            java.lang.String r0 = "auxiliary.tracks.interleaved"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L75
            r0 = 75
            if (r8 != r0) goto L59
            int r8 = r6.length
            if (r8 != r1) goto L58
            r8 = r6[r2]
            if (r8 == 0) goto L56
            if (r8 != r1) goto L58
        L56:
            r8 = r0
            goto L5a
        L58:
            r8 = r0
        L59:
            r1 = r2
        L5a:
            com.google.android.gms.internal.ads.zzgtj.zza(r1)
            goto L75
        L5e:
            java.lang.String r0 = "com.android.capture.fps"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L75
            r0 = 23
            if (r8 != r0) goto L71
            int r8 = r6.length
            r3 = 4
            if (r8 != r3) goto L70
            r8 = r0
            goto L72
        L70:
            r8 = r0
        L71:
            r1 = r2
        L72:
            com.google.android.gms.internal.ads.zzgtj.zza(r1)
        L75:
            r4.zza = r5
            r4.zzb = r6
            r4.zzc = r7
            r4.zzd = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfv.<init>(java.lang.String, byte[], int, int):void");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzfv.class == obj.getClass()) {
            zzfv zzfvVar = (zzfv) obj;
            if (this.zza.equals(zzfvVar.zza) && Arrays.equals(this.zzb, zzfvVar.zzb) && this.zzc == zzfvVar.zzc && this.zzd == zzfvVar.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.zza.hashCode() + 527) * 31) + Arrays.hashCode(this.zzb)) * 31) + this.zzc) * 31) + this.zzd;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String toString() {
        /*
            r5 = this;
            int r0 = r5.zzd
            r1 = 0
            if (r0 == 0) goto L57
            r2 = 1
            if (r0 == r2) goto L50
            r2 = 23
            if (r0 == r2) goto L41
            r2 = 67
            if (r0 == r2) goto L36
            r2 = 75
            if (r0 == r2) goto L29
            r2 = 78
            if (r0 == r2) goto L19
            goto L79
        L19:
            byte[] r0 = r5.zzb
            com.google.android.gms.internal.ads.zzet r1 = new com.google.android.gms.internal.ads.zzet
            r1.<init>(r0)
            long r0 = r1.zzJ()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            goto L8a
        L29:
            byte[] r0 = r5.zzb
            r0 = r0[r1]
            int r0 = java.lang.Byte.toUnsignedInt(r0)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            goto L8a
        L36:
            byte[] r0 = r5.zzb
            int r0 = com.google.android.gms.internal.ads.zzhah.zzd(r0)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            goto L8a
        L41:
            byte[] r0 = r5.zzb
            int r0 = com.google.android.gms.internal.ads.zzhah.zzd(r0)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            goto L8a
        L50:
            byte[] r0 = r5.zzb
            java.lang.String r0 = com.google.android.gms.internal.ads.zzfl.zzj(r0)
            goto L8a
        L57:
            java.lang.String r0 = r5.zza
            java.lang.String r2 = "auxiliary.tracks.map"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L79
            java.util.List r0 = r5.zzb()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "track types = "
            r1.append(r2)
            java.lang.String r2 = ","
            com.google.android.gms.internal.ads.zzgtd.zzb(r1, r0, r2)
            java.lang.String r0 = r1.toString()
            goto L8a
        L79:
            byte[] r0 = r5.zzb
            java.lang.String r2 = com.google.android.gms.internal.ads.zzfl.zza
            com.google.android.gms.internal.ads.zzgzh r2 = com.google.android.gms.internal.ads.zzgzh.zzn()
            com.google.android.gms.internal.ads.zzgzh r2 = r2.zzi()
            int r3 = r0.length
            java.lang.String r0 = r2.zzj(r0, r1, r3)
        L8a:
            java.lang.String r1 = r5.zza
            java.lang.String r2 = java.lang.String.valueOf(r1)
            int r2 = r2.length()
            java.lang.String r3 = java.lang.String.valueOf(r0)
            int r2 = r2 + 18
            int r3 = r3.length()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r2 = r2 + r3
            r4.<init>(r2)
            java.lang.String r2 = "mdta: key="
            r4.append(r2)
            r4.append(r1)
            java.lang.String r1 = ", value="
            r4.append(r1)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfv.toString():java.lang.String");
    }

    public final List zzb() {
        zzgtj.zzj(this.zza.equals("auxiliary.tracks.map"), "Metadata is not an auxiliary tracks map");
        byte[] bArr = this.zzb;
        byte b3 = bArr[1];
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < b3; i3++) {
            arrayList.add(Integer.valueOf(bArr[i3 + 2] & 255));
        }
        return arrayList;
    }
}
