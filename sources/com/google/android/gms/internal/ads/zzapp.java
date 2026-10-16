package com.google.android.gms.internal.ads;

import com.sun.jna.Function;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzapp implements zzapt {
    private static final byte[] zza = {73, 68, 51};
    private final boolean zzb;
    private final String zze;
    private final int zzf;
    private final String zzg;
    private String zzh;
    private zzahk zzi;
    private zzahk zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private boolean zzn;
    private boolean zzo;
    private int zzr;
    private boolean zzs;
    private int zzu;
    private zzahk zzw;
    private long zzx;
    private final zzes zzc = new zzes(new byte[7], 7);
    private final zzet zzd = new zzet(Arrays.copyOf(zza, 10));
    private int zzp = -1;
    private int zzq = -1;
    private long zzt = -9223372036854775807L;
    private long zzv = -9223372036854775807L;

    public zzapp(boolean z2, String str, int i3, String str2) {
        this.zzb = z2;
        this.zze = str;
        this.zzf = i3;
        this.zzg = str2;
        zzi();
    }

    public static boolean zzf(int i3) {
        return (i3 & 65526) == 65520;
    }

    private final void zzg() {
        this.zzo = false;
        zzi();
    }

    private final boolean zzh(zzet zzetVar, byte[] bArr, int i3) {
        int iMin = Math.min(zzetVar.zzd(), i3 - this.zzl);
        zzetVar.zzm(bArr, this.zzl, iMin);
        int i4 = this.zzl + iMin;
        this.zzl = i4;
        return i4 == i3;
    }

    private final void zzi() {
        this.zzk = 0;
        this.zzl = 0;
        this.zzm = Function.MAX_NARGS;
    }

    private final void zzj(zzahk zzahkVar, long j3, int i3, int i4) {
        this.zzk = 4;
        this.zzl = i3;
        this.zzw = zzahkVar;
        this.zzx = j3;
        this.zzu = i4;
    }

    private final void zzk() {
        this.zzk = 3;
        this.zzl = 0;
    }

    private static final boolean zzl(byte b3, byte b4) {
        return zzf((b4 & 255) | 65280);
    }

    private static final boolean zzm(zzet zzetVar, byte[] bArr, int i3) {
        if (zzetVar.zzd() < i3) {
            return false;
        }
        zzetVar.zzm(bArr, 0, i3);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zza() {
        this.zzv = -9223372036854775807L;
        zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzb(zzagb zzagbVar, zzarh zzarhVar) {
        zzarhVar.zza();
        this.zzh = zzarhVar.zzc();
        zzahk zzahkVarZzu = zzagbVar.zzu(zzarhVar.zzb(), 1);
        this.zzi = zzahkVarZzu;
        this.zzw = zzahkVarZzu;
        if (!this.zzb) {
            this.zzj = new zzafv();
            return;
        }
        zzarhVar.zza();
        zzahk zzahkVarZzu2 = zzagbVar.zzu(zzarhVar.zzb(), 5);
        this.zzj = zzahkVarZzu2;
        zzt zztVar = new zzt();
        zztVar.zza(zzarhVar.zzc());
        zztVar.zzn(this.zzg);
        zztVar.zzo("application/id3");
        zzahkVarZzu2.zzA(zztVar.zzO());
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzc(long j3, int i3) {
        this.zzv = j3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x025b, code lost:
    
        r18.zzk = 1;
        r18.zzl = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0261, code lost:
    
        zzk();
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0264, code lost:
    
        r19.zzh(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0247, code lost:
    
        r18.zzr = (r14 & 8) >> 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0250, code lost:
    
        if (1 == ((r14 & 1) ^ 1)) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0252, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0254, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0255, code lost:
    
        r18.zzn = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0259, code lost:
    
        if (r18.zzo != false) goto L101;
     */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0247 A[EDGE_INSN: B:143:0x0247->B:94:0x0247 BREAK  A[LOOP:1: B:48:0x01a0->B:169:0x01a0], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01ff  */
    @Override // com.google.android.gms.internal.ads.zzapt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzd(com.google.android.gms.internal.ads.zzet r19) throws com.google.android.gms.internal.ads.zzat {
        /*
            Method dump skipped, instruction units count: 716
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzapp.zzd(com.google.android.gms.internal.ads.zzet):void");
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zze(boolean z2) {
    }
}
