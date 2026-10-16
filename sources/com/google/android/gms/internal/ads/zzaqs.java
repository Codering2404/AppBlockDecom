package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaqs implements zzafy {
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
    private long zzh;
    private zzaqo zzi;
    private zzagb zzj;
    private boolean zzk;
    private final zzfi zza = new zzfi(0);
    private final zzet zzc = new zzet(4096);
    private final SparseArray zzb = new SparseArray();
    private final zzaqp zzd = new zzaqp();

    static {
        int i3 = zzaqr.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final boolean zza(zzafz zzafzVar) throws IOException {
        byte[] bArr = new byte[14];
        zzafp zzafpVar = (zzafp) zzafzVar;
        zzafpVar.zzh(bArr, 0, 14, false);
        if ((((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) != 442 || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        zzafpVar.zzj(bArr[13] & 7, false);
        zzafpVar.zzh(bArr, 0, 3, false);
        return ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255)) == 1;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzc(zzagb zzagbVar) {
        this.zzj = zzagbVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x012e  */
    @Override // com.google.android.gms.internal.ads.zzafy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzd(com.google.android.gms.internal.ads.zzafz r14, com.google.android.gms.internal.ads.zzagy r15) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 402
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqs.zzd(com.google.android.gms.internal.ads.zzafz, com.google.android.gms.internal.ads.zzagy):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    @Override // com.google.android.gms.internal.ads.zzafy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zze(long r5, long r7) {
        /*
            r4 = this;
            com.google.android.gms.internal.ads.zzfi r5 = r4.zza
            long r0 = r5.zzc()
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 == 0) goto L21
            long r0 = r5.zza()
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 == 0) goto L24
            r2 = 0
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 == 0) goto L24
            int r6 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r6 == 0) goto L24
        L21:
            r5.zzd(r7)
        L24:
            com.google.android.gms.internal.ads.zzaqo r5 = r4.zzi
            r6 = 0
            if (r5 == 0) goto L2c
            r5.zzb(r7)
        L2c:
            android.util.SparseArray r5 = r4.zzb
            int r7 = r5.size()
            if (r6 >= r7) goto L40
            java.lang.Object r5 = r5.valueAt(r6)
            com.google.android.gms.internal.ads.zzaqq r5 = (com.google.android.gms.internal.ads.zzaqq) r5
            r5.zza()
            int r6 = r6 + 1
            goto L2c
        L40:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqs.zze(long, long):void");
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzf() {
    }
}
