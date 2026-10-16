package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzahp implements zzafy {
    private static final int[] zza;
    private static final int[] zzb;
    private static final byte[] zzc;
    private static final byte[] zzd;
    private final byte[] zze;
    private final zzahk zzf;
    private boolean zzg;
    private long zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private long zzm;
    private zzagb zzn;
    private zzahk zzo;
    private zzahk zzp;
    private zzahb zzq;
    private long zzr;
    private boolean zzs;

    static {
        int i3 = zzaho.zza;
        zza = new int[]{13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
        zzb = new int[]{18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        String str = zzfl.zza;
        Charset charset = StandardCharsets.UTF_8;
        zzc = "#!AMR\n".getBytes(charset);
        zzd = "#!AMR-WB\n".getBytes(charset);
    }

    public zzahp() {
        throw null;
    }

    private final boolean zzh(zzafz zzafzVar) throws IOException {
        byte[] bArr = zzc;
        if (zzi(zzafzVar, bArr)) {
            this.zzg = false;
            zzafzVar.zzf(bArr.length);
            return true;
        }
        byte[] bArr2 = zzd;
        if (!zzi(zzafzVar, bArr2)) {
            return false;
        }
        this.zzg = true;
        zzafzVar.zzf(bArr2.length);
        return true;
    }

    private static boolean zzi(zzafz zzafzVar, byte[] bArr) throws IOException {
        zzafzVar.zzl();
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        zzafzVar.zzi(bArr2, 0, length);
        return Arrays.equals(bArr2, bArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003a A[Catch: EOFException -> 0x009f, TryCatch #0 {EOFException -> 0x009f, blocks: (B:4:0x0007, B:6:0x0018, B:20:0x003a, B:22:0x0043, B:21:0x003f, B:31:0x005d, B:32:0x0080, B:33:0x0081, B:34:0x009e), top: B:44:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003f A[Catch: EOFException -> 0x009f, TryCatch #0 {EOFException -> 0x009f, blocks: (B:4:0x0007, B:6:0x0018, B:20:0x003a, B:22:0x0043, B:21:0x003f, B:31:0x005d, B:32:0x0080, B:33:0x0081, B:34:0x009e), top: B:44:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int zzj(com.google.android.gms.internal.ads.zzafz r12) throws java.io.IOException {
        /*
            r11 = this;
            int r0 = r11.zzj
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != 0) goto La0
            java.lang.String r0 = "Invalid padding bits for frame header "
            r12.zzl()     // Catch: java.io.EOFException -> L9f
            byte[] r4 = r11.zze     // Catch: java.io.EOFException -> L9f
            r12.zzi(r4, r3, r2)     // Catch: java.io.EOFException -> L9f
            r4 = r4[r3]     // Catch: java.io.EOFException -> L9f
            r5 = r4 & 131(0x83, float:1.84E-43)
            r6 = 0
            if (r5 > 0) goto L81
            int r0 = r4 >> 3
            java.lang.String r4 = "Illegal AMR "
            java.lang.String r5 = " frame type "
            boolean r7 = r11.zzg     // Catch: java.io.EOFException -> L9f
            r0 = r0 & 15
            if (r7 == 0) goto L2d
            r8 = 10
            if (r0 < r8) goto L38
            r8 = 13
            if (r0 <= r8) goto L2d
            goto L38
        L2d:
            if (r7 != 0) goto L56
            r8 = 12
            if (r0 < r8) goto L38
            r8 = 14
            if (r0 > r8) goto L38
            goto L56
        L38:
            if (r7 == 0) goto L3f
            int[] r4 = com.google.android.gms.internal.ads.zzahp.zzb     // Catch: java.io.EOFException -> L9f
            r0 = r4[r0]     // Catch: java.io.EOFException -> L9f
            goto L43
        L3f:
            int[] r4 = com.google.android.gms.internal.ads.zzahp.zza     // Catch: java.io.EOFException -> L9f
            r0 = r4[r0]     // Catch: java.io.EOFException -> L9f
        L43:
            r11.zzi = r0     // Catch: java.io.EOFException -> L9f
            r11.zzj = r0
            int r4 = r11.zzk
            if (r4 != r1) goto L4e
            r11.zzk = r0
            r4 = r0
        L4e:
            if (r4 != r0) goto La0
            int r4 = r11.zzl
            int r4 = r4 + r2
            r11.zzl = r4
            goto La0
        L56:
            java.lang.String r12 = "WB"
            java.lang.String r3 = "NB"
            if (r2 == r7) goto L5d
            r12 = r3
        L5d:
            java.lang.String r2 = java.lang.String.valueOf(r0)     // Catch: java.io.EOFException -> L9f
            int r2 = r2.length()     // Catch: java.io.EOFException -> L9f
            int r2 = r2 + 26
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.io.EOFException -> L9f
            r3.<init>(r2)     // Catch: java.io.EOFException -> L9f
            r3.append(r4)     // Catch: java.io.EOFException -> L9f
            r3.append(r12)     // Catch: java.io.EOFException -> L9f
            r3.append(r5)     // Catch: java.io.EOFException -> L9f
            r3.append(r0)     // Catch: java.io.EOFException -> L9f
            java.lang.String r12 = r3.toString()     // Catch: java.io.EOFException -> L9f
            com.google.android.gms.internal.ads.zzat r12 = com.google.android.gms.internal.ads.zzat.zzb(r12, r6)     // Catch: java.io.EOFException -> L9f
            throw r12     // Catch: java.io.EOFException -> L9f
        L81:
            java.lang.String r12 = java.lang.String.valueOf(r4)     // Catch: java.io.EOFException -> L9f
            int r12 = r12.length()     // Catch: java.io.EOFException -> L9f
            int r12 = r12 + 38
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.io.EOFException -> L9f
            r2.<init>(r12)     // Catch: java.io.EOFException -> L9f
            r2.append(r0)     // Catch: java.io.EOFException -> L9f
            r2.append(r4)     // Catch: java.io.EOFException -> L9f
            java.lang.String r12 = r2.toString()     // Catch: java.io.EOFException -> L9f
            com.google.android.gms.internal.ads.zzat r12 = com.google.android.gms.internal.ads.zzat.zzb(r12, r6)     // Catch: java.io.EOFException -> L9f
            throw r12     // Catch: java.io.EOFException -> L9f
        L9f:
            return r1
        La0:
            com.google.android.gms.internal.ads.zzahk r4 = r11.zzp
            int r12 = r4.zza(r12, r0, r2)
            if (r12 != r1) goto La9
            return r1
        La9:
            int r0 = r11.zzj
            int r0 = r0 - r12
            r11.zzj = r0
            if (r0 <= 0) goto Lb1
            return r3
        Lb1:
            com.google.android.gms.internal.ads.zzahk r4 = r11.zzp
            long r5 = r11.zzh
            int r8 = r11.zzi
            r9 = 0
            r10 = 0
            r7 = 1
            r4.zze(r5, r7, r8, r9, r10)
            long r0 = r11.zzh
            r4 = 20000(0x4e20, double:9.8813E-320)
            long r0 = r0 + r4
            r11.zzh = r0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahp.zzj(com.google.android.gms.internal.ads.zzafz):int");
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final boolean zza(zzafz zzafzVar) throws IOException {
        return zzh(zzafzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzc(zzagb zzagbVar) {
        this.zzn = zzagbVar;
        zzahk zzahkVarZzu = zzagbVar.zzu(0, 1);
        this.zzo = zzahkVarZzu;
        this.zzp = zzahkVarZzu;
        zzagbVar.zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final int zzd(zzafz zzafzVar, zzagy zzagyVar) throws IOException {
        this.zzo.getClass();
        String str = zzfl.zza;
        if (zzafzVar.zzn() == 0 && !zzh(zzafzVar)) {
            throw zzat.zzb("Could not find AMR header.", null);
        }
        if (!this.zzs) {
            this.zzs = true;
            boolean z2 = this.zzg;
            String str2 = true != z2 ? "audio/amr" : "audio/amr-wb";
            String str3 = true != z2 ? "audio/3gpp" : "audio/amr-wb";
            int i3 = true != z2 ? 8000 : 16000;
            int i4 = z2 ? zzb[8] : zza[7];
            zzahk zzahkVar = this.zzo;
            zzt zztVar = new zzt();
            zztVar.zzn(str2);
            zztVar.zzo(str3);
            zztVar.zzp(i4);
            zztVar.zzG(1);
            zztVar.zzH(i3);
            zzahkVar.zzA(zztVar.zzO());
        }
        int iZzj = zzj(zzafzVar);
        if (this.zzq == null) {
            zzaha zzahaVar = new zzaha(-9223372036854775807L, 0L);
            this.zzq = zzahaVar;
            this.zzn.zzw(zzahaVar);
        }
        return iZzj == -1 ? -1 : 0;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zze(long j3, long j4) {
        this.zzh = 0L;
        this.zzi = 0;
        this.zzj = 0;
        this.zzr = j4;
        this.zzm = 0L;
    }

    public zzahp(int i3) {
        this.zze = new byte[1];
        this.zzk = -1;
        zzafv zzafvVar = new zzafv();
        this.zzf = zzafvVar;
        this.zzp = zzafvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzf() {
    }
}
