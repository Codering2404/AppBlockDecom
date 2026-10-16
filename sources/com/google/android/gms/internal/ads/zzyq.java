package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import com.facebook.appevents.AppEventsConstants;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzyq implements zzxi, zzagb, zzabv, zzaca, zzza {
    private static final Map zzb;
    private static final zzv zzc;
    private boolean zzA;
    private zzyp zzB;
    private zzahb zzC;
    private long zzD;
    private boolean zzE;
    private boolean zzG;
    private boolean zzH;
    private boolean zzI;
    private int zzJ;
    private boolean zzK;
    private long zzL;
    private boolean zzN;
    private int zzO;
    private boolean zzP;
    private boolean zzQ;
    private final Uri zzd;
    private final zzhp zze;
    private final zzun zzf;
    private final zzxu zzg;
    private final zzui zzh;
    private final zzyi zzi;
    private final zzabl zzj;
    private final long zzk;
    private final long zzl;
    private final zzyd zzn;
    private zzxh zzs;
    private zzajd zzt;
    private boolean zzx;
    private boolean zzy;
    private boolean zzz;
    private final zzacd zzm = new zzacd("ProgressiveMediaPeriod");
    private final zzds zzo = new zzds(zzdo.zza);
    private final Runnable zzp = new Runnable() { // from class: com.google.android.gms.internal.ads.zzym
        @Override // java.lang.Runnable
        public final /* synthetic */ void run() {
            this.zza.zzD();
        }
    };
    private final Runnable zzq = new Runnable() { // from class: com.google.android.gms.internal.ads.zzyj
        @Override // java.lang.Runnable
        public final /* synthetic */ void run() {
            this.zza.zzE();
        }
    };
    private final Handler zzr = zzfl.zzd(null);
    private zzyo[] zzw = new zzyo[0];
    private zzzb[] zzv = new zzzb[0];
    private zzyg[] zzu = new zzyg[0];
    private long zzM = -9223372036854775807L;
    private int zzF = 1;

    static {
        HashMap map = new HashMap();
        map.put("Icy-MetaData", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        zzb = Collections.unmodifiableMap(map);
        zzt zztVar = new zzt();
        zztVar.zza("icy");
        zztVar.zzo("application/x-icy");
        zzc = zztVar.zzO();
    }

    public zzyq(Uri uri, zzhp zzhpVar, zzyd zzydVar, zzun zzunVar, zzui zzuiVar, zzabu zzabuVar, zzxu zzxuVar, zzyi zzyiVar, zzabl zzablVar, String str, int i3, boolean z2, int i4, zzv zzvVar, long j3, zzacj zzacjVar) {
        this.zzd = uri;
        this.zze = zzhpVar;
        this.zzf = zzunVar;
        this.zzh = zzuiVar;
        this.zzg = zzxuVar;
        this.zzi = zzyiVar;
        this.zzj = zzablVar;
        this.zzk = i3;
        this.zzn = zzydVar;
        this.zzl = j3;
    }

    private final void zzR(int i3) {
        zzaa();
        zzyp zzypVar = this.zzB;
        boolean[] zArr = zzypVar.zzd;
        if (zArr[i3]) {
            return;
        }
        zzv zzvVarZza = zzypVar.zza.zza(i3).zza(0);
        this.zzg.zzh(new zzxg(1, zzas.zzf(zzvVarZza.zzp), zzvVarZza, 0, null, zzfl.zzr(this.zzL), -9223372036854775807L));
        zArr[i3] = true;
    }

    private final void zzS(int i3) {
        zzaa();
        if (this.zzN) {
            if ((!this.zzz || this.zzB.zzb[i3]) && !this.zzv[i3].zzr(false)) {
                this.zzM = 0L;
                this.zzN = false;
                this.zzH = true;
                this.zzL = 0L;
                this.zzO = 0;
                for (zzzb zzzbVar : this.zzv) {
                    zzzbVar.zzg(false);
                }
                zzxh zzxhVar = this.zzs;
                zzxhVar.getClass();
                zzxhVar.zzs(this);
            }
        }
    }

    private final boolean zzT() {
        return this.zzH || zzZ();
    }

    private final zzahk zzU(zzyo zzyoVar) {
        int length = this.zzv.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (zzyoVar.equals(this.zzw[i3])) {
                return this.zzv[i3];
            }
        }
        if (this.zzx) {
            int i4 = zzyoVar.zza;
            StringBuilder sb = new StringBuilder(String.valueOf(i4).length() + 55);
            sb.append("Extractor added new track (id=");
            sb.append(i4);
            sb.append(") after finishing tracks.");
            zzeg.zzc("ProgressiveMediaPeriod", sb.toString());
            return new zzafv();
        }
        zzzb zzzbVar = new zzzb(this.zzj, this.zzf, this.zzh);
        zzyg zzygVar = new zzyg(zzzbVar);
        zzzbVar.zzz(this);
        int i5 = length + 1;
        zzyo[] zzyoVarArr = (zzyo[]) Arrays.copyOf(this.zzw, i5);
        zzyoVarArr[length] = zzyoVar;
        String str = zzfl.zza;
        this.zzw = zzyoVarArr;
        zzzb[] zzzbVarArr = (zzzb[]) Arrays.copyOf(this.zzv, i5);
        zzzbVarArr[length] = zzzbVar;
        this.zzv = zzzbVarArr;
        zzyg[] zzygVarArr = (zzyg[]) Arrays.copyOf(this.zzu, i5);
        zzygVarArr[length] = zzygVar;
        this.zzu = zzygVarArr;
        return zzygVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzV, reason: merged with bridge method [inline-methods] */
    public final void zzD() {
        int i3;
        if (this.zzQ || this.zzy || !this.zzx || this.zzC == null) {
            return;
        }
        for (zzzb zzzbVar : this.zzv) {
            if (zzzbVar.zzo() == null) {
                return;
            }
        }
        this.zzo.zzb();
        int length = this.zzv.length;
        int i4 = -1;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            zzv zzvVarZzo = this.zzv[i6].zzo();
            zzvVarZzo.getClass();
            int iZzf = zzas.zzf(zzvVarZzo.zzp);
            int iZzab = zzab(iZzf);
            int iZzab2 = zzab(i4);
            if (iZzab > iZzab2) {
                i4 = iZzf;
            }
            if (iZzab > iZzab2) {
                i5 = i6;
            }
        }
        zzbg[] zzbgVarArr = new zzbg[length];
        boolean[] zArr = new boolean[length];
        for (int i7 = 0; i7 < length; i7++) {
            zzv zzvVarZzo2 = this.zzv[i7].zzo();
            zzvVarZzo2.getClass();
            String str = zzvVarZzo2.zzp;
            boolean zZza = zzas.zza(str);
            boolean z2 = zZza || zzas.zzb(str);
            zArr[i7] = z2;
            this.zzz = z2 | this.zzz;
            this.zzA = this.zzl != -9223372036854775807L && length == 1 && zzas.zzc(str);
            zzajd zzajdVar = this.zzt;
            if (zzajdVar != null) {
                if (zZza || this.zzw[i7].zzb) {
                    zzap zzapVar = zzvVarZzo2.zzl;
                    zzap zzapVar2 = zzapVar == null ? new zzap(-9223372036854775807L, zzajdVar) : zzapVar.zzg(zzajdVar);
                    zzt zztVarZza = zzvVarZzo2.zza();
                    zztVarZza.zzl(zzapVar2);
                    zzvVarZzo2 = zztVarZza.zzO();
                }
                if (zZza && zzvVarZzo2.zzh == -1 && zzvVarZzo2.zzi == -1 && (i3 = zzajdVar.zza) != -1) {
                    zzt zztVarZza2 = zzvVarZzo2.zza();
                    zztVarZza2.zzi(i3);
                    zzvVarZzo2 = zztVarZza2.zzO();
                }
            }
            zzv zzvVarZzb = zzvVarZzo2.zzb(this.zzf.zzb(zzvVarZzo2));
            if (i7 != i5) {
                zzt zztVarZza3 = zzvVarZzb.zza();
                zztVarZza3.zzm(Integer.toString(i5));
                zzvVarZzb = zztVarZza3.zzO();
            }
            zzbgVarArr[i7] = new zzbg(Integer.toString(i7), zzvVarZzb);
            this.zzI = zzvVarZzb.zzv | this.zzI;
            this.zzv[i7].zzi(Long.MIN_VALUE);
        }
        this.zzB = new zzyp(new zzzn(zzbgVarArr), zArr);
        if (this.zzA && this.zzD == -9223372036854775807L) {
            this.zzD = this.zzl;
            this.zzC = new zzye(this, this.zzC);
        }
        this.zzi.zzb(this.zzD, this.zzC, this.zzE);
        this.zzy = true;
        zzxh zzxhVar = this.zzs;
        zzxhVar.getClass();
        zzxhVar.zzp(this);
    }

    private final void zzW() {
        zzyh zzyhVar = new zzyh(this, this.zzd, this.zze, this.zzn, this, this.zzo);
        if (this.zzy) {
            zzgtj.zzi(zzZ());
            long j3 = this.zzD;
            if (j3 != -9223372036854775807L && this.zzM > j3) {
                this.zzP = true;
                this.zzM = -9223372036854775807L;
                return;
            }
            zzahb zzahbVar = this.zzC;
            zzahbVar.getClass();
            zzyhVar.zzd(zzahbVar.zzc(this.zzM).zza.zzc, this.zzM);
            for (zzzb zzzbVar : this.zzv) {
                zzzbVar.zzh(this.zzM);
            }
            this.zzM = -9223372036854775807L;
        }
        this.zzO = zzX();
        this.zzm.zzd(zzyhVar, this, zzabu.zza(this.zzF));
    }

    private final int zzX() {
        int iZzj = 0;
        for (zzzb zzzbVar : this.zzv) {
            iZzj += zzzbVar.zzj();
        }
        return iZzj;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final long zzY(boolean r6) {
        /*
            r5 = this;
            r0 = 0
            r1 = -9223372036854775808
        L3:
            com.google.android.gms.internal.ads.zzzb[] r3 = r5.zzv
            int r4 = r3.length
            if (r0 >= r4) goto L22
            if (r6 != 0) goto L15
            com.google.android.gms.internal.ads.zzyp r4 = r5.zzB
            r4.getClass()
            boolean[] r4 = r4.zzc
            boolean r4 = r4[r0]
            if (r4 == 0) goto L1f
        L15:
            r3 = r3[r0]
            long r3 = r3.zzp()
            long r1 = java.lang.Math.max(r1, r3)
        L1f:
            int r0 = r0 + 1
            goto L3
        L22:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzyq.zzY(boolean):long");
    }

    private final boolean zzZ() {
        return this.zzM != -9223372036854775807L;
    }

    @EnsuresNonNull
    private final void zzaa() {
        zzgtj.zzi(this.zzy);
        this.zzB.getClass();
        this.zzC.getClass();
    }

    private static int zzab(int i3) {
        if (i3 == 1) {
            return 3;
        }
        if (i3 == 2) {
            return 4;
        }
        if (i3 != 3) {
            return i3 != 4 ? 0 : 2;
        }
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final /* bridge */ /* synthetic */ void zzA(zzabz zzabzVar, long j3, long j4, boolean z2) {
        zzyh zzyhVar = (zzyh) zzabzVar;
        zzim zzimVarZzf = zzyhVar.zzf();
        zzxb zzxbVar = new zzxb(zzyhVar.zze(), zzyhVar.zzh(), zzimVarZzf.zzg(), zzimVarZzf.zzh(), j3, j4, zzimVarZzf.zzf());
        zzyhVar.zze();
        this.zzg.zzf(zzxbVar, new zzxg(1, -1, null, 0, null, zzfl.zzr(zzyhVar.zzg()), zzfl.zzr(this.zzD)));
        if (z2) {
            return;
        }
        for (zzzb zzzbVar : this.zzv) {
            zzzbVar.zzg(false);
        }
        if (this.zzJ > 0) {
            zzxh zzxhVar = this.zzs;
            zzxhVar.getClass();
            zzxhVar.zzs(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final /* bridge */ /* synthetic */ void zzB(zzabz zzabzVar, long j3, long j4) {
        zzyh zzyhVar = (zzyh) zzabzVar;
        if (this.zzD == -9223372036854775807L && this.zzC != null) {
            long jZzY = zzY(true);
            long j5 = jZzY == Long.MIN_VALUE ? 0L : jZzY + 10000;
            this.zzD = j5;
            this.zzi.zzb(j5, this.zzC, this.zzE);
        }
        zzim zzimVarZzf = zzyhVar.zzf();
        zzxb zzxbVar = new zzxb(zzyhVar.zze(), zzyhVar.zzh(), zzimVarZzf.zzg(), zzimVarZzf.zzh(), j3, j4, zzimVarZzf.zzf());
        zzyhVar.zze();
        this.zzg.zze(zzxbVar, new zzxg(1, -1, null, 0, null, zzfl.zzr(zzyhVar.zzg()), zzfl.zzr(this.zzD)));
        this.zzP = true;
        zzxh zzxhVar = this.zzs;
        zzxhVar.getClass();
        zzxhVar.zzs(this);
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final /* bridge */ /* synthetic */ void zzC(zzabz zzabzVar, long j3, long j4, int i3) {
        zzxb zzxbVar;
        zzyh zzyhVar = (zzyh) zzabzVar;
        zzim zzimVarZzf = zzyhVar.zzf();
        if (i3 == 0) {
            long jZze = zzyhVar.zze();
            zzht zzhtVarZzh = zzyhVar.zzh();
            zzxbVar = new zzxb(jZze, zzhtVarZzh, zzhtVarZzh.zza, Collections.EMPTY_MAP, j3, 0L, 0L);
        } else {
            zzxbVar = new zzxb(zzyhVar.zze(), zzyhVar.zzh(), zzimVarZzf.zzg(), zzimVarZzf.zzh(), j3, j4, zzimVarZzf.zzf());
        }
        this.zzg.zzd(zzxbVar, new zzxg(1, -1, null, 0, null, zzfl.zzr(zzyhVar.zzg()), zzfl.zzr(this.zzD)), i3);
    }

    final /* synthetic */ void zzE() {
        if (this.zzQ) {
            return;
        }
        zzxh zzxhVar = this.zzs;
        zzxhVar.getClass();
        zzxhVar.zzs(this);
    }

    final /* synthetic */ void zzF(zzahb zzahbVar) {
        this.zzC = this.zzt == null ? zzahbVar : new zzaha(-9223372036854775807L, 0L);
        this.zzD = zzahbVar.zza();
        boolean z2 = false;
        if (!this.zzK && zzahbVar.zza() == -9223372036854775807L) {
            z2 = true;
        }
        this.zzE = z2;
        this.zzF = true == z2 ? 7 : 1;
        if (this.zzy) {
            this.zzi.zzb(this.zzD, zzahbVar, z2);
        } else {
            zzD();
        }
    }

    final /* synthetic */ void zzG() {
        this.zzK = true;
    }

    final /* synthetic */ void zzH() {
        this.zzr.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzyl
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzG();
            }
        });
    }

    final /* synthetic */ long zzI(boolean z2) {
        return zzY(true);
    }

    final /* synthetic */ long zzL() {
        return this.zzk;
    }

    final /* synthetic */ Runnable zzM() {
        return this.zzq;
    }

    final /* synthetic */ Handler zzN() {
        return this.zzr;
    }

    final /* synthetic */ zzajd zzO() {
        return this.zzt;
    }

    final /* synthetic */ void zzP(zzajd zzajdVar) {
        this.zzt = zzajdVar;
    }

    final /* synthetic */ long zzQ() {
        return this.zzD;
    }

    public final void zza() {
        if (this.zzy) {
            for (zzzb zzzbVar : this.zzv) {
                zzzbVar.zzk();
            }
        }
        this.zzm.zzg(this);
        this.zzr.removeCallbacksAndMessages(null);
        this.zzs = null;
        this.zzQ = true;
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final void zzb(zzxh zzxhVar, long j3) {
        this.zzs = zzxhVar;
        this.zzo.zza();
        zzW();
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final void zzc() throws IOException {
        zzr();
        if (this.zzP && !this.zzy) {
            throw zzat.zzb("Loading finished before preparation is complete.", null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final zzzn zzd() {
        zzaa();
        return this.zzB.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final long zze(zzaba[] zzabaVarArr, boolean[] zArr, zzzc[] zzzcVarArr, boolean[] zArr2, long j3) {
        zzaba zzabaVar;
        zzaa();
        zzyp zzypVar = this.zzB;
        zzzn zzznVar = zzypVar.zza;
        boolean[] zArr3 = zzypVar.zzc;
        int i3 = this.zzJ;
        int i4 = 0;
        for (int i5 = 0; i5 < zzabaVarArr.length; i5++) {
            zzzc zzzcVar = zzzcVarArr[i5];
            if (zzzcVar != null && (zzabaVarArr[i5] == null || !zArr[i5])) {
                int iZza = ((zzyn) zzzcVar).zza();
                zzgtj.zzi(zArr3[iZza]);
                this.zzJ--;
                zArr3[iZza] = false;
                zzzcVarArr[i5] = null;
            }
        }
        boolean z2 = !this.zzG ? j3 == 0 || this.zzA : i3 != 0;
        for (int i6 = 0; i6 < zzabaVarArr.length; i6++) {
            if (zzzcVarArr[i6] == null && (zzabaVar = zzabaVarArr[i6]) != null) {
                zzgtj.zzi(zzabaVar.zze() == 1);
                zzgtj.zzi(zzabaVar.zzf(0) == 0);
                int iZzb = zzznVar.zzb(zzabaVar.zza());
                zzgtj.zzi(!zArr3[iZzb]);
                this.zzJ++;
                zArr3[iZzb] = true;
                this.zzI = zzabaVar.zzc().zzv | this.zzI;
                zzzcVarArr[i6] = new zzyn(this, iZzb);
                zArr2[i6] = true;
                if (!z2) {
                    zzzb zzzbVar = this.zzv[iZzb];
                    z2 = (zzzbVar.zzn() == 0 || zzzbVar.zzu(j3, true)) ? false : true;
                }
            }
        }
        if (this.zzJ == 0) {
            this.zzN = false;
            this.zzH = false;
            this.zzI = false;
            zzacd zzacdVar = this.zzm;
            if (zzacdVar.zze()) {
                zzzb[] zzzbVarArr = this.zzv;
                int length = zzzbVarArr.length;
                while (i4 < length) {
                    zzzbVarArr[i4].zzy();
                    i4++;
                }
                zzacdVar.zzf();
            } else {
                this.zzP = false;
                for (zzzb zzzbVar2 : this.zzv) {
                    zzzbVar2.zzg(false);
                }
            }
        } else if (z2) {
            j3 = zzj(j3);
            while (i4 < zzzcVarArr.length) {
                if (zzzcVarArr[i4] != null) {
                    zArr2[i4] = true;
                }
                i4++;
            }
        }
        this.zzG = true;
        return j3;
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final void zzf(long j3, boolean z2) {
        if (this.zzA) {
            return;
        }
        zzaa();
        if (zzZ()) {
            return;
        }
        boolean[] zArr = this.zzB.zzc;
        int length = this.zzv.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.zzv[i3].zzx(j3, false, zArr[i3]);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final long zzh() {
        if (this.zzI) {
            this.zzI = false;
        } else {
            if (!this.zzH) {
                return -9223372036854775807L;
            }
            if (!this.zzP && zzX() <= this.zzO) {
                return -9223372036854775807L;
            }
            this.zzH = false;
        }
        return this.zzL;
    }

    @Override // com.google.android.gms.internal.ads.zzxi, com.google.android.gms.internal.ads.zzze
    public final long zzi() {
        long jZzY;
        zzaa();
        if (this.zzP || this.zzJ == 0) {
            return Long.MIN_VALUE;
        }
        if (zzZ()) {
            return this.zzM;
        }
        if (this.zzz) {
            int length = this.zzv.length;
            jZzY = Long.MAX_VALUE;
            for (int i3 = 0; i3 < length; i3++) {
                zzyp zzypVar = this.zzB;
                if (zzypVar.zzb[i3] && zzypVar.zzc[i3] && !this.zzv[i3].zzq()) {
                    jZzY = Math.min(jZzY, this.zzv[i3].zzp());
                }
            }
        } else {
            jZzY = Long.MAX_VALUE;
        }
        if (jZzY == Long.MAX_VALUE) {
            jZzY = zzY(false);
        }
        return jZzY == Long.MIN_VALUE ? this.zzL : jZzY;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0094  */
    @Override // com.google.android.gms.internal.ads.zzxi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long zzj(long r9) {
        /*
            r8 = this;
            r8.zzaa()
            com.google.android.gms.internal.ads.zzyp r0 = r8.zzB
            boolean[] r0 = r0.zzb
            com.google.android.gms.internal.ads.zzahb r1 = r8.zzC
            boolean r1 = r1.zzb()
            r2 = 1
            if (r2 == r1) goto L12
            r9 = 0
        L12:
            r1 = 0
            r8.zzH = r1
            long r2 = r8.zzL
            r8.zzL = r9
            boolean r4 = r8.zzZ()
            if (r4 == 0) goto L22
            r8.zzM = r9
            return r9
        L22:
            int r4 = r8.zzF
            r5 = 7
            if (r4 == r5) goto L73
            boolean r4 = r8.zzP
            if (r4 != 0) goto L33
            com.google.android.gms.internal.ads.zzacd r4 = r8.zzm
            boolean r4 = r4.zze()
            if (r4 == 0) goto L73
        L33:
            com.google.android.gms.internal.ads.zzzb[] r4 = r8.zzv
            int r4 = r4.length
            r5 = r1
        L37:
            if (r5 >= r4) goto La5
            com.google.android.gms.internal.ads.zzzb[] r6 = r8.zzv
            r6 = r6[r5]
            com.google.android.gms.internal.ads.zzyg[] r7 = r8.zzu
            r7 = r7[r5]
            boolean r7 = r7.zzf()
            if (r7 != 0) goto L48
            goto L70
        L48:
            int r7 = r6.zzn()
            if (r7 != 0) goto L52
            int r7 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r7 == 0) goto L70
        L52:
            boolean r7 = r8.zzA
            if (r7 == 0) goto L5f
            int r7 = r6.zzm()
            boolean r6 = r6.zzt(r7)
            goto L65
        L5f:
            boolean r7 = r8.zzP
            boolean r6 = r6.zzu(r9, r7)
        L65:
            if (r6 != 0) goto L70
            boolean r6 = r0[r5]
            if (r6 != 0) goto L73
            boolean r6 = r8.zzz
            if (r6 != 0) goto L70
            goto L73
        L70:
            int r5 = r5 + 1
            goto L37
        L73:
            r8.zzN = r1
            r8.zzM = r9
            r8.zzP = r1
            r8.zzI = r1
            com.google.android.gms.internal.ads.zzacd r0 = r8.zzm
            boolean r2 = r0.zze()
            if (r2 == 0) goto L94
            com.google.android.gms.internal.ads.zzzb[] r2 = r8.zzv
            int r3 = r2.length
        L86:
            if (r1 >= r3) goto L90
            r4 = r2[r1]
            r4.zzy()
            int r1 = r1 + 1
            goto L86
        L90:
            r0.zzf()
            return r9
        L94:
            r0.zzc()
            com.google.android.gms.internal.ads.zzzb[] r0 = r8.zzv
            int r2 = r0.length
            r3 = r1
        L9b:
            if (r3 >= r2) goto La5
            r4 = r0[r3]
            r4.zzg(r1)
            int r3 = r3 + 1
            goto L9b
        La5:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzyq.zzj(long):long");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00da A[RETURN] */
    @Override // com.google.android.gms.internal.ads.zzxi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long zzk(long r28, com.google.android.gms.internal.ads.zzni r30) {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzyq.zzk(long, com.google.android.gms.internal.ads.zzni):long");
    }

    @Override // com.google.android.gms.internal.ads.zzxi, com.google.android.gms.internal.ads.zzze
    public final long zzl() {
        return zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzxi, com.google.android.gms.internal.ads.zzze
    public final boolean zzm(zzma zzmaVar) {
        if (this.zzP) {
            return false;
        }
        zzacd zzacdVar = this.zzm;
        if (zzacdVar.zzb() || this.zzN) {
            return false;
        }
        if (this.zzy && this.zzJ == 0) {
            return false;
        }
        boolean zZza = this.zzo.zza();
        if (zzacdVar.zze()) {
            return zZza;
        }
        zzW();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzxi, com.google.android.gms.internal.ads.zzze
    public final boolean zzn() {
        return !this.zzP && this.zzm.zze() && this.zzo.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzaca
    public final void zzo() {
        for (zzzb zzzbVar : this.zzv) {
            zzzbVar.zzf();
        }
        this.zzn.zzb();
    }

    final boolean zzp(int i3) {
        return !zzT() && this.zzv[i3].zzr(this.zzP);
    }

    final void zzq(int i3) throws IOException {
        this.zzv[i3].zzl();
        zzr();
    }

    final void zzr() throws IOException {
        this.zzm.zzh(zzabu.zza(this.zzF));
    }

    final int zzs(int i3, zzlw zzlwVar, zziv zzivVar, int i4) {
        if (zzT()) {
            return -3;
        }
        zzR(i3);
        int iZzs = this.zzv[i3].zzs(zzlwVar, zzivVar, i4, this.zzP);
        if (iZzs == -3) {
            zzS(i3);
        }
        return iZzs;
    }

    final int zzt(int i3, long j3) {
        if (zzT()) {
            return 0;
        }
        zzR(i3);
        zzzb zzzbVar = this.zzv[i3];
        int iZzv = zzzbVar.zzv(j3, this.zzP);
        zzzbVar.zzw(iZzv);
        if (iZzv != 0) {
            return iZzv;
        }
        zzS(i3);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzagb
    public final zzahk zzu(int i3, int i4) {
        return zzU(new zzyo(i3, false));
    }

    @Override // com.google.android.gms.internal.ads.zzagb
    public final void zzv() {
        this.zzx = true;
        this.zzr.post(this.zzp);
    }

    @Override // com.google.android.gms.internal.ads.zzagb
    public final void zzw(final zzahb zzahbVar) {
        this.zzr.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzyk
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzF(zzahbVar);
            }
        });
    }

    final zzahk zzx() {
        return zzU(new zzyo(0, true));
    }

    @Override // com.google.android.gms.internal.ads.zzza
    public final void zzy(zzv zzvVar) {
        this.zzr.post(this.zzp);
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final /* bridge */ /* synthetic */ zzabx zzz(zzabz zzabzVar, long j3, long j4, IOException iOException, int i3) {
        long jMin;
        zzabx zzabxVarZza;
        zzahb zzahbVar;
        zzyh zzyhVar = (zzyh) zzabzVar;
        zzim zzimVarZzf = zzyhVar.zzf();
        zzxb zzxbVar = new zzxb(zzyhVar.zze(), zzyhVar.zzh(), zzimVarZzf.zzg(), zzimVarZzf.zzh(), j3, j4, zzimVarZzf.zzf());
        zzyhVar.zzg();
        String str = zzfl.zza;
        for (Throwable cause = iOException; cause != null; cause = cause.getCause()) {
            if ((cause instanceof zzat) || (cause instanceof FileNotFoundException) || (cause instanceof zzid) || (cause instanceof zzacc) || ((cause instanceof zzhq) && ((zzhq) cause).zza == 2008)) {
                jMin = -9223372036854775807L;
                break;
            }
        }
        jMin = Math.min((i3 - 1) * 1000, 5000);
        if (jMin == -9223372036854775807L) {
            zzabxVarZza = zzacd.zzb;
        } else {
            int iZzX = zzX();
            boolean z2 = iZzX > this.zzO;
            if (this.zzK || !((zzahbVar = this.zzC) == null || zzahbVar.zza() == -9223372036854775807L)) {
                this.zzO = iZzX;
            } else {
                boolean z3 = this.zzy;
                if (!z3 || zzT()) {
                    this.zzH = z3;
                    this.zzL = 0L;
                    this.zzO = 0;
                    for (zzzb zzzbVar : this.zzv) {
                        zzzbVar.zzg(false);
                    }
                    zzyhVar.zzd(0L, 0L);
                } else {
                    this.zzN = true;
                    zzabxVarZza = zzacd.zza;
                }
            }
            zzabxVarZza = zzacd.zza(z2, jMin);
        }
        boolean zZza = zzabxVarZza.zza();
        this.zzg.zzg(zzxbVar, new zzxg(1, -1, null, 0, null, zzfl.zzr(zzyhVar.zzg()), zzfl.zzr(this.zzD)), iOException, !zZza);
        if (!zZza) {
            zzyhVar.zze();
        }
        return zzabxVarZza;
    }

    @Override // com.google.android.gms.internal.ads.zzxi, com.google.android.gms.internal.ads.zzze
    public final void zzg(long j3) {
    }
}
