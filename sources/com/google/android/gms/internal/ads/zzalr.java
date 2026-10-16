package com.google.android.gms.internal.ads;

import android.util.Pair;
import android.util.SparseArray;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzalr implements zzafy {
    private static final byte[] zza;
    private static final zzv zzb;
    private long zzA;
    private long zzB;
    private zzalq zzC;
    private int zzD;
    private int zzE;
    private int zzF;
    private boolean zzG;
    private boolean zzH;
    private zzagb zzI;
    private zzahk[] zzJ;
    private zzahk[] zzK;
    private boolean zzL;
    private boolean zzM;
    private long zzN;
    private long zzO;
    private final zzanj zzc;
    private final int zzd;
    private final List zze;
    private final SparseArray zzf;
    private final zzet zzg;
    private final zzet zzh;
    private final zzet zzi;
    private final byte[] zzj;
    private final zzet zzk;
    private final zzajb zzl;
    private final zzet zzm;
    private final ArrayDeque zzn;
    private final ArrayDeque zzo;
    private final zzgz zzp;
    private final zzafn zzq;
    private zzgwm zzr;
    private int zzs;
    private int zzt;
    private long zzu;
    private int zzv;
    private zzet zzw;
    private long zzx;
    private int zzy;
    private long zzz;

    static {
        int i3 = zzalm.zza;
        zza = new byte[]{-94, 57, 79, 82, 90, -101, 79, Ascii.DC4, -94, 68, 108, 66, 124, 100, -115, -12};
        zzt zztVar = new zzt();
        zztVar.zzo("application/x-emsg");
        zzb = zztVar.zzO();
    }

    @Deprecated
    public zzalr() {
        this(zzanj.zza, 32, null, null, zzgwm.zzi(), null);
    }

    private final void zzi() {
        this.zzs = 0;
        this.zzv = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:302:0x075f, code lost:
    
        zzi();
     */
    /* JADX WARN: Code restructure failed: missing block: B:303:0x0762, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:139:0x03e7  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0477  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzj(long r56) throws com.google.android.gms.internal.ads.zzat {
        /*
            Method dump skipped, instruction units count: 1891
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzalr.zzj(long):void");
    }

    private static int zzk(int i3) throws zzat {
        if (i3 >= 0) {
            return i3;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 27);
        sb.append("Unexpected negative value: ");
        sb.append(i3);
        throw zzat.zzb(sb.toString(), null);
    }

    private static void zzl(zzet zzetVar, int i3, zzamk zzamkVar) throws zzat {
        zzetVar.zzh(i3 + 8);
        int iZzB = zzetVar.zzB();
        int i4 = zzalj.zza;
        if ((iZzB & 1) != 0) {
            throw zzat.zzc("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z2 = (iZzB & 2) != 0;
        int iZzH = zzetVar.zzH();
        if (iZzH == 0) {
            Arrays.fill(zzamkVar.zzl, 0, zzamkVar.zze, false);
            return;
        }
        int i5 = zzamkVar.zze;
        if (iZzH != i5) {
            StringBuilder sb = new StringBuilder(String.valueOf(iZzH).length() + 58 + String.valueOf(i5).length());
            sb.append("Senc sample count ");
            sb.append(iZzH);
            sb.append(" is different from fragment sample count");
            sb.append(i5);
            throw zzat.zzb(sb.toString(), null);
        }
        Arrays.fill(zzamkVar.zzl, 0, iZzH, z2);
        zzamkVar.zza(zzetVar.zzd());
        zzet zzetVar2 = zzamkVar.zzn;
        zzetVar.zzm(zzetVar2.zzi(), 0, zzetVar2.zze());
        zzetVar2.zzh(0);
        zzamkVar.zzo = false;
    }

    private static Pair zzm(zzet zzetVar, long j3) throws zzat {
        long jZzJ;
        long jZzJ2;
        zzet zzetVar2 = zzetVar;
        zzetVar2.zzh(8);
        int iZza = zzalj.zza(zzetVar2.zzB());
        zzetVar2.zzk(4);
        long jZzz = zzetVar2.zzz();
        if (iZza == 0) {
            jZzJ = zzetVar2.zzz();
            jZzJ2 = zzetVar2.zzz();
        } else {
            jZzJ = zzetVar2.zzJ();
            jZzJ2 = zzetVar2.zzJ();
        }
        long j4 = j3 + jZzJ2;
        long jZzv = zzfl.zzv(jZzJ, 1000000L, jZzz, RoundingMode.DOWN);
        zzetVar2.zzk(2);
        int iZzt = zzetVar2.zzt();
        int[] iArr = new int[iZzt];
        long[] jArr = new long[iZzt];
        long[] jArr2 = new long[iZzt];
        long[] jArr3 = new long[iZzt];
        long j5 = j4;
        long j6 = jZzv;
        int i3 = 0;
        while (i3 < iZzt) {
            int iZzB = zzetVar2.zzB();
            if ((Integer.MIN_VALUE & iZzB) != 0) {
                throw zzat.zzb("Unhandled indirect reference", null);
            }
            long jZzz2 = zzetVar2.zzz();
            iArr[i3] = iZzB & Api.BaseClientBuilder.API_PRIORITY_OTHER;
            jArr[i3] = j5;
            jArr3[i3] = j6;
            jZzJ += jZzz2;
            long[] jArr4 = jArr2;
            long[] jArr5 = jArr3;
            long jZzv2 = zzfl.zzv(jZzJ, 1000000L, jZzz, RoundingMode.DOWN);
            jArr4[i3] = jZzv2 - jArr5[i3];
            zzetVar2.zzk(4);
            j5 += (long) iArr[i3];
            i3++;
            zzetVar2 = zzetVar;
            iZzt = iZzt;
            j6 = jZzv2;
            jArr2 = jArr4;
            jArr3 = jArr5;
        }
        return Pair.create(Long.valueOf(jZzv), new zzafm(iArr, jArr, jArr2, jArr3));
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0156  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.google.android.gms.internal.ads.zzq zzn(java.util.List r19) {
        /*
            Method dump skipped, instruction units count: 371
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzalr.zzn(java.util.List):com.google.android.gms.internal.ads.zzq");
    }

    private final void zzo(zzahb zzahbVar, zzagy zzagyVar) {
        this.zzI.zzw(zzahbVar);
        this.zzL = true;
        zzagyVar.zza = this.zzO;
        zzi();
    }

    private static final zzalk zzp(SparseArray sparseArray, int i3) {
        if (sparseArray.size() == 1) {
            return (zzalk) sparseArray.valueAt(0);
        }
        zzalk zzalkVar = (zzalk) sparseArray.get(i3);
        zzalkVar.getClass();
        return zzalkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final boolean zza(zzafz zzafzVar) throws IOException {
        zzahf zzahfVarZza = zzamh.zza(zzafzVar);
        this.zzr = zzahfVarZza != null ? zzgwm.zzj(zzahfVarZza) : zzgwm.zzi();
        return zzahfVarZza == null;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final /* synthetic */ List zzb() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzc(zzagb zzagbVar) {
        int i3;
        int i4 = this.zzd;
        if ((i4 & 32) == 0) {
            zzagbVar = new zzanm(zzagbVar, this.zzc);
        }
        this.zzI = zzagbVar;
        zzi();
        zzahk[] zzahkVarArr = new zzahk[2];
        this.zzJ = zzahkVarArr;
        int i5 = 100;
        int i6 = 0;
        if ((i4 & 4) != 0) {
            zzahkVarArr[0] = this.zzI.zzu(100, 5);
            i3 = 1;
            i5 = 101;
        } else {
            i3 = 0;
        }
        zzahk[] zzahkVarArr2 = (zzahk[]) zzfl.zzb(this.zzJ, i3);
        this.zzJ = zzahkVarArr2;
        for (zzahk zzahkVar : zzahkVarArr2) {
            zzahkVar.zzA(zzb);
        }
        List list = this.zze;
        this.zzK = new zzahk[list.size()];
        while (i6 < this.zzK.length) {
            zzahk zzahkVarZzu = this.zzI.zzu(i5, 3);
            zzahkVarZzu.zzA((zzv) list.get(i6));
            this.zzK[i6] = zzahkVarZzu;
            i6++;
            i5++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01eb, code lost:
    
        if (r4 <= 0) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01f3, code lost:
    
        if (com.google.android.gms.internal.ads.zzgp.zzb(r2.zzg, r12, 4) == false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01f5, code lost:
    
        r6 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01f7, code lost:
    
        r6 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01f8, code lost:
    
        r41.zzH = r6;
        r8.zzc(r11, r4);
        r41.zzE += r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0202, code lost:
    
        if (r4 <= 0) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0206, code lost:
    
        if (r41.zzG != false) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x020f, code lost:
    
        if (com.google.android.gms.internal.ads.zzgp.zzd(r12, 4, r4, r2.zzg) == false) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0211, code lost:
    
        r41.zzG = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0222, code lost:
    
        throw com.google.android.gms.internal.ads.zzat.zzb("Invalid NAL length", null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0225, code lost:
    
        if (r41.zzH == false) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0227, code lost:
    
        r6 = r41.zzi;
        r6.zza(r4);
        r42.zzc(r6.zzi(), r7, r41.zzF);
        r8.zzc(r6, r41.zzF);
        r4 = r41.zzF;
        r14 = com.google.android.gms.internal.ads.zzgp.zza(r6.zzi(), r6.zze());
        r6.zzh(r7);
        r6.zzf(r14);
        r14 = r2.zzg.zzr;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0253, code lost:
    
        if (r14 != (-1)) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0255, code lost:
    
        r14 = r41.zzp;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x025b, code lost:
    
        if (r14.zzb() == 0) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x025d, code lost:
    
        r14.zza(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0261, code lost:
    
        r15 = r41.zzp;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0267, code lost:
    
        if (r15.zzb() == r14) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0269, code lost:
    
        r15.zza(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x026c, code lost:
    
        r7 = r41.zzp;
        r7.zzc(r9, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0279, code lost:
    
        if ((r3.zzg() & 4) == 0) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x027b, code lost:
    
        r7.zze();
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x027f, code lost:
    
        r4 = r8.zza(r42, r4, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0284, code lost:
    
        r41.zzE += r4;
        r41.zzF -= r4;
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0292, code lost:
    
        r1 = r3.zzg();
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0298, code lost:
    
        if (r41.zzG != false) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x029a, code lost:
    
        r1 = r1 | 67108864;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x029d, code lost:
    
        r11 = r1;
        r1 = r3.zzj();
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x02a2, code lost:
    
        if (r1 == null) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x02a4, code lost:
    
        r14 = r1.zzc;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x02a8, code lost:
    
        r14 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x02a9, code lost:
    
        r8.zze(r9, r11, r41.zzD, 0, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x02af, code lost:
    
        r1 = r41.zzo;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x02b5, code lost:
    
        if (r1.isEmpty() != false) goto L555;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x02b7, code lost:
    
        r1 = (com.google.android.gms.internal.ads.zzalo) r1.removeFirst();
        r2 = r41.zzy;
        r15 = r1.zzc;
        r41.zzy = r2 - r15;
        r4 = r1.zza;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x02c8, code lost:
    
        if (r1.zzb == false) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x02ca, code lost:
    
        r4 = r4 + r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x02cb, code lost:
    
        r12 = r4;
        r1 = r41.zzJ;
        r2 = r1.length;
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x02d0, code lost:
    
        if (r4 >= r2) goto L558;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x02d2, code lost:
    
        r1[r4].zze(r12, 1, r15, r41.zzy, null);
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x02e5, code lost:
    
        if (r3.zzh() != false) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x02e7, code lost:
    
        r41.zzC = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x02ea, code lost:
    
        r41.zzs = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x02ee, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:357:0x07fd, code lost:
    
        throw com.google.android.gms.internal.ads.zzat.zzc("Atom size less than header length (unsupported).");
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b2, code lost:
    
        if (r41.zzs != 3) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b4, code lost:
    
        r41.zzD = r3.zzf();
        r2 = r3.zzd.zza.zzg.zzp;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c8, code lost:
    
        if (java.util.Objects.equals(r2, "video/avc") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ce, code lost:
    
        if ((r41.zzd & 64) == 0) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00d0, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00d2, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00da, code lost:
    
        if (java.util.Objects.equals(r2, "video/hevc") == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e0, code lost:
    
        if ((r41.zzd & com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00e3, code lost:
    
        r41.zzG = !r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ea, code lost:
    
        if (r3.zzf >= r3.zzi) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:564:?, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00ec, code lost:
    
        r42.zzf(r41.zzD);
        r1 = r3.zzj();
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00f5, code lost:
    
        if (r1 != null) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00f8, code lost:
    
        r2 = r3.zzb;
        r5 = r2.zzn;
        r1 = r1.zzd;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00fe, code lost:
    
        if (r1 == 0) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0100, code lost:
    
        r5.zzk(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0109, code lost:
    
        if (r2.zzb(r3.zzf) == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x010b, code lost:
    
        r5.zzk(r5.zzt() * 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0118, code lost:
    
        if (r3.zzh() != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x011a, code lost:
    
        r41.zzC = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x011c, code lost:
    
        r41.zzs = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0127, code lost:
    
        if (r3.zzd.zza.zzh != 1) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0129, code lost:
    
        r41.zzD -= 8;
        r42.zzf(8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0140, code lost:
    
        if ("audio/ac4".equals(r3.zzd.zza.zzg.zzp) == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0142, code lost:
    
        r41.zzE = r3.zzi(r41.zzD, 7);
        r2 = r41.zzD;
        r8 = r41.zzk;
        com.google.android.gms.internal.ads.zzafb.zzc(r2, r8);
        r3.zza.zzc(r8, 7);
        r2 = r41.zzE + 7;
        r41.zzE = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x015d, code lost:
    
        r2 = r3.zzi(r41.zzD, 0);
        r41.zzE = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0165, code lost:
    
        r41.zzD += r2;
        r41.zzs = 4;
        r41.zzF = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x016f, code lost:
    
        r2 = r3.zzd.zza;
        r8 = r3.zza;
        r9 = r3.zzd();
        r5 = r2.zzk;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x017b, code lost:
    
        if (r5 != 0) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x017d, code lost:
    
        r2 = r41.zzE;
        r5 = r41.zzD;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0181, code lost:
    
        if (r2 >= r5) goto L554;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0183, code lost:
    
        r41.zzE += r8.zza(r42, r5 - r2, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x018e, code lost:
    
        r11 = r41.zzh;
        r12 = r11.zzi();
        r12[0] = 0;
        r12[1] = 0;
        r12[r25] = 0;
        r13 = 4 - r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01a0, code lost:
    
        if (r41.zzE >= r41.zzD) goto L559;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01a2, code lost:
    
        r4 = r41.zzF;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01a4, code lost:
    
        if (r4 != 0) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01a9, code lost:
    
        if (r41.zzK.length > 0) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01ad, code lost:
    
        if (r41.zzG != false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01b0, code lost:
    
        r4 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01b2, code lost:
    
        r4 = com.google.android.gms.internal.ads.zzgp.zzc(r2.zzg);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01bf, code lost:
    
        if ((r5 + r4) <= (r41.zzD - r41.zzE)) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01c2, code lost:
    
        r42.zzc(r12, r13, r5 + r4);
        r11.zzh(r7);
        r6 = r11.zzB();
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01ce, code lost:
    
        if (r6 < 0) goto L560;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01d0, code lost:
    
        r41.zzF = r6 - r4;
        r6 = r41.zzg;
        r6.zzh(r7);
        r8.zzc(r6, 4);
        r41.zzE += 4;
        r41.zzD += r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01e9, code lost:
    
        if (r41.zzK.length <= 0) goto L104;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:381:0x089b  */
    /* JADX WARN: Removed duplicated region for block: B:386:0x08ba  */
    /* JADX WARN: Removed duplicated region for block: B:387:0x08c7  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.ads.zzafy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzd(com.google.android.gms.internal.ads.zzafz r42, com.google.android.gms.internal.ads.zzagy r43) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 2606
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzalr.zzd(com.google.android.gms.internal.ads.zzafz, com.google.android.gms.internal.ads.zzagy):int");
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zze(long j3, long j4) {
        SparseArray sparseArray = this.zzf;
        int size = sparseArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((zzalq) sparseArray.valueAt(i3)).zzc();
        }
        this.zzo.clear();
        this.zzy = 0;
        this.zzp.zzd();
        this.zzz = j4;
        this.zzn.clear();
        this.zzO = -1L;
        zzi();
    }

    final /* synthetic */ void zzh(long j3, zzet zzetVar) {
        zzafl.zza(j3, zzetVar, this.zzK);
    }

    public zzalr(zzanj zzanjVar, int i3, zzfi zzfiVar, zzami zzamiVar, List list, zzahk zzahkVar) {
        this.zzc = zzanjVar;
        this.zzd = i3;
        this.zze = Collections.unmodifiableList(list);
        this.zzl = new zzajb();
        this.zzm = new zzet(16);
        this.zzg = new zzet(zzgp.zza);
        this.zzh = new zzet(6);
        this.zzi = new zzet();
        byte[] bArr = new byte[16];
        this.zzj = bArr;
        this.zzk = new zzet(bArr);
        this.zzn = new ArrayDeque();
        this.zzo = new ArrayDeque();
        this.zzf = new SparseArray();
        this.zzr = zzgwm.zzi();
        this.zzA = -9223372036854775807L;
        this.zzz = -9223372036854775807L;
        this.zzB = -9223372036854775807L;
        this.zzI = zzagb.zza;
        this.zzJ = new zzahk[0];
        this.zzK = new zzahk[0];
        this.zzp = new zzgz(new zzgy() { // from class: com.google.android.gms.internal.ads.zzaln
            @Override // com.google.android.gms.internal.ads.zzgy
            public final /* synthetic */ void zza(long j3, zzet zzetVar) {
                this.zza.zzh(j3, zzetVar);
            }
        });
        this.zzq = new zzafn();
        this.zzN = -1L;
        this.zzO = -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzf() {
    }
}
