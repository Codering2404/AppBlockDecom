package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import android.util.Pair;
import android.view.Surface;
import com.facebook.ads.AdError;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.NativeProtocol;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.PriorityQueue;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzade extends zzvt implements zzadt {
    private static final int[] zzb = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private static boolean zzc;
    private static boolean zzd;
    private int zzA;
    private long zzB;
    private int zzC;
    private int zzD;
    private int zzE;
    private zznh zzF;
    private long zzG;
    private boolean zzH;
    private long zzI;
    private int zzJ;
    private long zzK;
    private zzbv zzL;
    private zzbv zzM;
    private int zzN;
    private int zzO;
    private zzadr zzP;
    private long zzQ;
    private long zzR;
    private boolean zzS;
    private int zzT;
    private final Context zze;
    private final boolean zzf;
    private final zzaeo zzg;
    private final boolean zzh;
    private final zzadu zzi;
    private final zzads zzj;
    private final zzacn zzk;
    private final long zzl;
    private final zzadv zzm;
    private final PriorityQueue zzn;
    private zzadd zzo;
    private boolean zzp;
    private boolean zzq;
    private zzaeu zzr;
    private boolean zzs;
    private int zzt;
    private List zzu;
    private Surface zzv;
    private zzadg zzw;
    private zzeu zzx;
    private boolean zzy;
    private int zzz;

    protected zzade(zzadc zzadcVar) {
        super(zzadcVar.zze().getApplicationContext(), 2, zzadcVar.zzg(), zzadcVar.zzf(), false, 30.0f);
        Context applicationContext = zzadcVar.zze().getApplicationContext();
        this.zze = applicationContext;
        this.zzr = null;
        this.zzg = new zzaeo(zzadcVar.zzh(), zzadcVar.zzi());
        this.zzf = this.zzr == null;
        this.zzi = new zzadu(applicationContext, this, 0L);
        this.zzj = new zzads();
        this.zzh = "NVIDIA".equals(Build.MANUFACTURER);
        this.zzx = zzeu.zza;
        this.zzz = 1;
        this.zzA = 0;
        this.zzL = zzbv.zza;
        this.zzO = 0;
        this.zzM = null;
        this.zzN = -1000;
        this.zzQ = -9223372036854775807L;
        this.zzR = -9223372036854775807L;
        this.zzk = new zzacn();
        this.zzn = new PriorityQueue();
        this.zzl = -15000L;
        this.zzm = new zzadv(1.0f);
        this.zzF = null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005c, code lost:
    
        if (r3.equals("video/x-vnd.on2.vp8") != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a2, code lost:
    
        if (r3.equals("video/mp4v-es") != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00ba, code lost:
    
        if (r3.equals("video/av01") != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00c3, code lost:
    
        if (r3.equals("video/3gpp") != false) goto L57;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int zzaw(com.google.android.gms.internal.ads.zzvm r8, com.google.android.gms.internal.ads.zzv r9) {
        /*
            Method dump skipped, instruction units count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzade.zzaw(com.google.android.gms.internal.ads.zzvm, com.google.android.gms.internal.ads.zzv):int");
    }

    private final void zzbA() {
        zzadg zzadgVar = this.zzw;
        if (zzadgVar != null) {
            zzadgVar.release();
            this.zzw = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresNonNull
    /* JADX INFO: renamed from: zzbB, reason: merged with bridge method [inline-methods] */
    public final void zzbo() {
        this.zzg.zzg(this.zzv);
        this.zzy = true;
    }

    private final void zzbC() {
        zzbv zzbvVar = this.zzM;
        if (zzbvVar != null) {
            this.zzg.zzf(zzbvVar);
        }
    }

    protected static int zzbm(zzvm zzvmVar, zzv zzvVar) {
        int i3 = zzvVar.zzq;
        if (i3 == -1) {
            return zzaw(zzvmVar, zzvVar);
        }
        List list = zzvVar.zzs;
        int size = list.size();
        int length = 0;
        for (int i4 = 0; i4 < size; i4++) {
            length += ((byte[]) list.get(i4)).length;
        }
        return i3 + length;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0070 A[Catch: all -> 0x006d, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:7:0x000d, B:72:0x00cf, B:10:0x0013, B:12:0x001a, B:71:0x00cb, B:41:0x0070), top: B:77:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected static final boolean zzbq(java.lang.String r4) {
        /*
            Method dump skipped, instruction units count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzade.zzbq(java.lang.String):boolean");
    }

    protected static final boolean zzbr(zzvm zzvmVar) {
        return Build.VERSION.SDK_INT >= 35 && zzvmVar.zzh;
    }

    private static List zzbs(Context context, zzvv zzvvVar, zzv zzvVar, boolean z2, boolean z3) throws zzvx {
        String str = zzvVar.zzp;
        if (str == null) {
            return zzgwm.zzi();
        }
        if ("video/dolby-vision".equals(str) && !zzadb.zza(context)) {
            List listZzd = zzwf.zzd(zzvvVar, zzvVar, z2, z3);
            if (!listZzd.isEmpty()) {
                return listZzd;
            }
        }
        return zzwf.zzc(zzvvVar, zzvVar, z2, z3);
    }

    private final void zzbt(zzxk zzxkVar) {
        int iZze;
        zzbf zzbfVarZzN = zzN();
        if (zzbfVarZzN.zzg() || (iZze = zzbfVarZzN.zze(zzxkVar.zza)) == -1) {
            this.zzR = -9223372036854775807L;
        } else {
            this.zzR = zzbfVarZzN.zzd(iZze, new zzbd(), false).zzd;
        }
    }

    private final void zzbu(Object obj) throws zzjk {
        Surface surface = obj instanceof Surface ? (Surface) obj : null;
        if (this.zzv == surface) {
            if (surface != null) {
                zzbC();
                Surface surface2 = this.zzv;
                if (surface2 == null || !this.zzy) {
                    return;
                }
                this.zzg.zzg(surface2);
                return;
            }
            return;
        }
        this.zzv = surface;
        if (this.zzr == null) {
            this.zzi.zzd(surface);
        }
        this.zzy = false;
        int iZze = zze();
        zzvj zzvjVarZzaI = zzaI();
        if (zzvjVarZzaI != null && this.zzr == null) {
            zzvm zzvmVarZzaL = zzaL();
            zzvmVarZzaL.getClass();
            if (!zzby(zzvmVarZzaL) || this.zzp) {
                zzaM();
                zzaE();
            } else {
                Surface surfaceZzbz = zzbz(zzvmVarZzaL);
                if (surfaceZzbz != null) {
                    zzvjVarZzaI.zzn(surfaceZzbz);
                } else {
                    if (Build.VERSION.SDK_INT < 35) {
                        throw new IllegalStateException();
                    }
                    zzvjVarZzaI.zzo();
                }
            }
        }
        if (surface != null) {
            zzbC();
        } else {
            this.zzM = null;
            zzaeu zzaeuVar = this.zzr;
            if (zzaeuVar != null) {
                zzaeuVar.zzq();
            }
        }
        if (iZze == 2) {
            zzaeu zzaeuVar2 = this.zzr;
            if (zzaeuVar2 != null) {
                zzaeuVar2.zzw(true);
            } else {
                this.zzi.zzj(true);
            }
        }
    }

    private final boolean zzbv(zziv zzivVar) {
        if (zzcW() || zzivVar.zzd() || this.zzR == -9223372036854775807L) {
            return true;
        }
        return this.zzR - (zzivVar.zze - zzbg()) <= 100000;
    }

    private final boolean zzbw(zziv zzivVar) {
        return zzivVar.zze < zzH();
    }

    private final void zzbx(long j3, long j4, zzv zzvVar) {
        zzadr zzadrVar = this.zzP;
        if (zzadrVar != null) {
            zzadrVar.zzcS(j3, j4, zzvVar, zzaK());
        }
    }

    private final boolean zzby(zzvm zzvmVar) {
        if (this.zzr != null) {
            return true;
        }
        Surface surface = this.zzv;
        return (surface != null && surface.isValid()) || zzbr(zzvmVar) || zzaC(zzvmVar);
    }

    private final Surface zzbz(zzvm zzvmVar) {
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar != null) {
            return zzaeuVar.zzk();
        }
        Surface surface = this.zzv;
        if (surface != null) {
            return surface;
        }
        if (zzbr(zzvmVar)) {
            return null;
        }
        zzgtj.zzi(zzaC(zzvmVar));
        zzadg zzadgVar = this.zzw;
        if (zzadgVar != null) {
            if (zzadgVar.zza != zzvmVar.zzf) {
                zzbA();
            }
        }
        if (this.zzw == null) {
            this.zzw = zzadg.zzb(this.zze, zzvmVar.zzf);
        }
        return this.zzw;
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzix
    protected final void zzA(long j3, boolean z2, boolean z3) throws zzjk {
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar != null && !z2) {
            zzaeuVar.zzg(true);
        }
        if (z3) {
            this.zzG = j3;
        }
        super.zzA(j3, z2, z3);
        if (this.zzr == null) {
            this.zzi.zzl();
        }
        zzadv zzadvVar = this.zzm;
        if (zzadvVar != null) {
            zzadvVar.zzd();
        }
        if (z2) {
            zzaeu zzaeuVar2 = this.zzr;
            if (zzaeuVar2 != null) {
                zzaeuVar2.zzw(false);
            } else {
                this.zzi.zzj(false);
            }
        }
        this.zzD = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzix
    protected final void zzB() {
        this.zzC = 0;
        this.zzB = zzM().zzb();
        this.zzI = 0L;
        this.zzJ = 0;
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar != null) {
            zzaeuVar.zza();
        } else {
            this.zzi.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzix
    protected final void zzC() {
        if (this.zzC > 0) {
            long jZzb = zzM().zzb();
            this.zzg.zzd(this.zzC, jZzb - this.zzB);
            this.zzC = 0;
            this.zzB = jZzb;
        }
        int i3 = this.zzJ;
        if (i3 != 0) {
            this.zzg.zze(this.zzI, i3);
            this.zzI = 0L;
            this.zzJ = 0;
        }
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar != null) {
            zzaeuVar.zzb();
        } else {
            this.zzi.zzc();
        }
        zzadv zzadvVar = this.zzm;
        if (zzadvVar != null) {
            zzadvVar.zzd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzix
    protected final void zzD() {
        this.zzM = null;
        this.zzR = -9223372036854775807L;
        this.zzy = false;
        this.zzH = true;
        try {
            super.zzD();
        } finally {
            zzaeo zzaeoVar = this.zzg;
            zzaeoVar.zzi(((zzvt) this).zza);
            zzaeoVar.zzf(zzbv.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzix
    protected final void zzE() {
        try {
            super.zzE();
        } finally {
            this.zzs = false;
            this.zzQ = -9223372036854775807L;
            zzbA();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzix
    protected final void zzF() {
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar == null || !this.zzf) {
            return;
        }
        zzaeuVar.zzx();
    }

    @Override // com.google.android.gms.internal.ads.zzix
    protected final void zzG(zzbf zzbfVar) {
        zzxk zzxkVarZzO = zzO();
        if (zzxkVarZzO != null) {
            zzbt(zzxkVarZzO);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzna, com.google.android.gms.internal.ads.zznc
    public final String zzU() {
        return "MediaCodecVideoRenderer";
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final boolean zzW(long j3) {
        if (zzbf() == -9223372036854775807L || j3 < this.zzG) {
            return false;
        }
        long jZzaY = zzaY();
        return jZzaY == -9223372036854775807L || j3 > jZzaY;
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzna
    public final void zzX(float f3, float f4) throws zzjk {
        super.zzX(f3, f4);
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar != null) {
            zzaeuVar.zzm(f3);
        } else {
            this.zzi.zzn(f3);
        }
        zzadv zzadvVar = this.zzm;
        if (zzadvVar != null) {
            zzadvVar.zzc(f3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final void zzY() {
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar == null) {
            this.zzi.zzh();
            return;
        }
        int i3 = this.zzt;
        if (i3 == 0 || i3 == 1) {
            this.zzt = 0;
        } else {
            zzaeuVar.zzt();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzna
    public final void zzZ(long j3, long j4) throws Throwable {
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar != null) {
            try {
                zzaeuVar.zzv(j3, j4);
            } catch (zzaet e3) {
                throw zzP(e3, e3.zza, false, AdError.SHOW_CALLED_BEFORE_LOAD_ERROR_CODE);
            }
        }
        super.zzZ(j3, j4);
    }

    protected final void zzaA(long j3) {
        zzjb zzjbVar = ((zzvt) this).zza;
        zzjbVar.zzk += j3;
        zzjbVar.zzl++;
        this.zzI += j3;
        this.zzJ++;
    }

    protected final void zzaB(zzvj zzvjVar, int i3, long j3, long j4) {
        Trace.beginSection("releaseOutputBuffer");
        zzvjVar.zzd(i3, j4);
        Trace.endSection();
        ((zzvt) this).zza.zze++;
        this.zzD = 0;
        if (this.zzr == null) {
            zzbv zzbvVar = this.zzL;
            if (!zzbvVar.equals(zzbv.zza) && !zzbvVar.equals(this.zzM)) {
                this.zzM = zzbvVar;
                this.zzg.zzf(zzbvVar);
            }
            if (!this.zzi.zzf() || this.zzv == null) {
                return;
            }
            zzbo();
        }
    }

    protected final boolean zzaC(zzvm zzvmVar) {
        if (zzbq(zzvmVar.zza)) {
            return false;
        }
        return !zzvmVar.zzf || zzadg.zza(this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final boolean zzaG(zzvm zzvmVar) {
        return zzby(zzvmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final boolean zzaO() {
        zzvm zzvmVarZzaL = zzaL();
        if (this.zzr != null && zzvmVarZzaL != null) {
            String str = zzvmVarZzaL.zza;
            if (str.equals("c2.mtk.avc.decoder") || str.equals("c2.mtk.hevc.decoder")) {
                return true;
            }
        }
        return super.zzaO();
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x002a  */
    @Override // com.google.android.gms.internal.ads.zzvt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final boolean zzaP() {
        /*
            r12 = this;
            com.google.android.gms.internal.ads.zzv r0 = r12.zzaJ()
            long r1 = r12.zzR
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r6 = 0
            r7 = 1
            if (r5 == 0) goto L2a
            r8 = 1
            long r1 = r1 + r8
            long r8 = r12.zzbg()
            long r10 = r12.zzR
            long r8 = r8 + r10
            long r10 = r12.zzaQ()
            long r10 = r10 + r1
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            long r1 = r1 - r8
            int r1 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r1 <= 0) goto L2c
        L2a:
            r1 = r7
            goto L2d
        L2c:
            r1 = r6
        L2d:
            com.google.android.gms.internal.ads.zznh r2 = r12.zzF
            if (r2 != 0) goto L32
            goto L47
        L32:
            boolean r2 = r12.zzH
            if (r2 != 0) goto L47
            if (r0 == 0) goto L3c
            int r0 = r0.zzr
            if (r0 > 0) goto L47
        L3c:
            if (r1 != 0) goto L47
            long r0 = r12.zzbe()
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L47
            return r6
        L47:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzade.zzaP():boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final void zzaR() {
        super.zzaR();
        this.zzn.clear();
        this.zzE = 0;
        this.zzT = 0;
        this.zzH = false;
        zzacn zzacnVar = this.zzk;
        if (zzacnVar != null) {
            zzacnVar.zzc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final zzvl zzaT(Throwable th, zzvm zzvmVar) {
        return new zzacy(th, zzvmVar, this.zzv);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final boolean zzaU(zzv zzvVar) throws zzjk {
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar == null || zzaeuVar.zze()) {
            return true;
        }
        try {
            zzaeuVar.zzd(zzvVar);
            return true;
        } catch (zzaet e3) {
            throw zzP(e3, zzvVar, false, 7000);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final void zzaV(zziv zzivVar) throws zzjk {
        ByteBuffer byteBuffer;
        zzacn zzacnVar = this.zzk;
        if (zzacnVar != null) {
            zzvm zzvmVarZzaL = zzaL();
            zzvmVarZzaL.getClass();
            if (zzvmVarZzaL.zzb.equals("video/av01") && zzivVar.zzc() && (byteBuffer = zzivVar.zzc) != null) {
                zzacnVar.zzb(byteBuffer);
            }
        }
        this.zzT = 0;
        int iZzaW = zzaW(zzivVar);
        if (Build.VERSION.SDK_INT < 34 || (iZzaW & 32) == 0) {
            this.zzE++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final int zzaW(zziv zzivVar) {
        return (Build.VERSION.SDK_INT < 34 || this.zzF == null || !zzbw(zzivVar) || zzbv(zzivVar)) ? 0 : 32;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0098  */
    @Override // com.google.android.gms.internal.ads.zzvt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final boolean zzaX(com.google.android.gms.internal.ads.zziv r9) {
        /*
            r8 = this;
            boolean r0 = r8.zzbv(r9)
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            boolean r0 = r8.zzbw(r9)
            com.google.android.gms.internal.ads.zzadv r2 = r8.zzm
            r3 = 1
            if (r2 == 0) goto L28
            long r4 = r9.zze
            long r4 = r2.zzb(r4)
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 == 0) goto L28
            long r6 = r8.zzl
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 >= 0) goto L28
            r2 = r3
            goto L29
        L28:
            r2 = r1
        L29:
            if (r0 != 0) goto L2e
            if (r2 != 0) goto L2e
            return r1
        L2e:
            boolean r2 = r9.zze()
            if (r2 == 0) goto L35
            return r1
        L35:
            boolean r2 = r9.zzf()
            if (r2 == 0) goto L40
            r9.zza()
        L3e:
            r1 = r3
            goto L96
        L40:
            com.google.android.gms.internal.ads.zzacn r2 = r8.zzk
            if (r2 == 0) goto L96
            com.google.android.gms.internal.ads.zzvm r4 = r8.zzaL()
            r4.getClass()
            java.lang.String r4 = r4.zzb
            java.lang.String r5 = "video/av01"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L96
            java.nio.ByteBuffer r4 = r9.zzc
            if (r4 == 0) goto L96
            if (r0 != 0) goto L5f
            int r5 = r8.zzT
            if (r5 > 0) goto L61
        L5f:
            r5 = r3
            goto L62
        L61:
            r5 = r1
        L62:
            java.nio.ByteBuffer r4 = r4.asReadOnlyBuffer()
            r4.flip()
            int r2 = r2.zza(r4, r5)
            if (r2 != 0) goto L73
            r9.zza()
            goto L3e
        L73:
            int r5 = r4.limit()
            if (r2 == r5) goto L96
            com.google.android.gms.internal.ads.zzadd r5 = r8.zzo
            r5.getClass()
            int r5 = r5.zzc
            int r5 = r5 + r2
            int r4 = r4.capacity()
            if (r5 >= r4) goto L96
            boolean r4 = r9.zzk()
            if (r4 != 0) goto L96
            java.nio.ByteBuffer r1 = r9.zzc
            r1.getClass()
            r1.position(r2)
            goto L3e
        L96:
            if (r1 == 0) goto Lb2
            if (r0 == 0) goto La2
            com.google.android.gms.internal.ads.zzjb r9 = r8.zza
            int r0 = r9.zzd
            int r0 = r0 + r3
            r9.zzd = r0
            return r1
        La2:
            java.util.PriorityQueue r0 = r8.zzn
            long r4 = r9.zze
            java.lang.Long r9 = java.lang.Long.valueOf(r4)
            r0.add(r9)
            int r9 = r8.zzT
            int r9 = r9 + r3
            r8.zzT = r9
        Lb2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzade.zzaX(com.google.android.gms.internal.ads.zziv):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final void zzaZ(long j3) {
        super.zzaZ(j3);
        this.zzE--;
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzna
    public final boolean zzaa() {
        boolean zZzba = zzba();
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar != null) {
            return zzaeuVar.zzh(zZzba);
        }
        if (zZzba && zzaI() == null) {
            return true;
        }
        return this.zzi.zzi(zZzba);
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzna
    public final boolean zzab() {
        if (!super.zzab()) {
            return false;
        }
        zzaeu zzaeuVar = this.zzr;
        return zzaeuVar == null || zzaeuVar.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final int zzae(zzvv zzvvVar, zzv zzvVar) throws zzvx {
        boolean z2;
        String str = zzvVar.zzp;
        boolean zZzb = zzas.zzb(str);
        int i3 = ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (!zZzb) {
            return ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        Context context = this.zze;
        int i4 = 0;
        boolean z3 = zzvVar.zzt != null;
        List listZzbs = zzbs(context, zzvvVar, zzvVar, z3, false);
        if (z3 && listZzbs.isEmpty()) {
            listZzbs = zzbs(context, zzvvVar, zzvVar, false, false);
        }
        if (listZzbs.isEmpty()) {
            return 129;
        }
        if (!zzvt.zzbj(zzvVar)) {
            return 130;
        }
        zzvm zzvmVar = (zzvm) listZzbs.get(0);
        boolean zZzc = zzvmVar.zzc(context, zzvVar);
        if (zZzc) {
            z2 = true;
        } else {
            for (int i5 = 1; i5 < listZzbs.size(); i5++) {
                zzvm zzvmVar2 = (zzvm) listZzbs.get(i5);
                if (zzvmVar2.zzc(context, zzvVar)) {
                    zZzc = true;
                    z2 = false;
                    zzvmVar = zzvmVar2;
                    break;
                }
            }
            z2 = true;
        }
        int i6 = true != zZzc ? 3 : 4;
        int i7 = true != zzvmVar.zze(zzvVar) ? 8 : 16;
        int i8 = true != zzvmVar.zzg ? 0 : 64;
        if (true != z2) {
            i3 = 0;
        }
        if ("video/dolby-vision".equals(str) && !zzadb.zza(context)) {
            i3 = Function.MAX_NARGS;
        }
        if (zZzc) {
            List listZzbs2 = zzbs(context, zzvvVar, zzvVar, z3, true);
            if (!listZzbs2.isEmpty()) {
                zzvm zzvmVar3 = (zzvm) zzwf.zze(context, listZzbs2, zzvVar).get(0);
                if (zzvmVar3.zzc(context, zzvVar) && zzvmVar3.zze(zzvVar)) {
                    i4 = 32;
                }
            }
        }
        return i6 | i7 | i4 | i8 | i3;
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final List zzaf(zzvv zzvvVar, zzv zzvVar, boolean z2) throws zzvx {
        Context context = this.zze;
        return zzwf.zze(context, zzbs(context, zzvvVar, zzvVar, false, false), zzvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final zzvg zzah(zzvm zzvmVar, zzv zzvVar, MediaCrypto mediaCrypto, float f3) {
        int i3;
        zzadd zzaddVar;
        Point pointZzi;
        int i4;
        int i5;
        int i6;
        boolean z2;
        zzv[] zzvVarArr;
        byte b3;
        boolean z3;
        Pair pairZze;
        int iZzaw;
        zzv[] zzvVarArrZzJ = zzJ();
        int length = zzvVarArrZzJ.length;
        int iZzbm = zzbm(zzvmVar, zzvVar);
        int i7 = zzvVar.zzx;
        int i8 = zzvVar.zzw;
        if (length == 1) {
            if (iZzbm != -1 && (iZzaw = zzaw(zzvmVar, zzvVar)) != -1) {
                iZzbm = Math.min((int) (iZzbm * 1.5f), iZzaw);
            }
            zzaddVar = new zzadd(i8, i7, iZzbm);
            i3 = 35;
        } else {
            int iMax = i7;
            int iMax2 = i8;
            int i9 = 0;
            boolean z4 = false;
            i3 = 35;
            while (i9 < length) {
                zzv zzvVarZzO = zzvVarArrZzJ[i9];
                zzi zziVar = zzvVar.zzF;
                if (zziVar != null && zzvVarZzO.zzF == null) {
                    zzt zztVarZza = zzvVarZzO.zza();
                    zztVarZza.zzE(zziVar);
                    zzvVarZzO = zztVarZza.zzO();
                }
                if (zzvmVar.zzf(zzvVar, zzvVarZzO).zzd != 0) {
                    int i10 = zzvVarZzO.zzw;
                    b3 = -1;
                    if (i10 != -1) {
                        zzvVarArr = zzvVarArrZzJ;
                        if (zzvVarZzO.zzx != -1) {
                            z3 = false;
                        }
                        z4 |= z3;
                        iMax2 = Math.max(iMax2, i10);
                        iMax = Math.max(iMax, zzvVarZzO.zzx);
                        iZzbm = Math.max(iZzbm, zzbm(zzvmVar, zzvVarZzO));
                    } else {
                        zzvVarArr = zzvVarArrZzJ;
                    }
                    z3 = true;
                    z4 |= z3;
                    iMax2 = Math.max(iMax2, i10);
                    iMax = Math.max(iMax, zzvVarZzO.zzx);
                    iZzbm = Math.max(iZzbm, zzbm(zzvmVar, zzvVarZzO));
                } else {
                    zzvVarArr = zzvVarArrZzJ;
                    b3 = -1;
                }
                i9++;
                zzvVarArrZzJ = zzvVarArr;
            }
            if (z4) {
                StringBuilder sb = new StringBuilder(String.valueOf(iMax2).length() + 44 + String.valueOf(iMax).length());
                sb.append("Resolutions unknown. Codec max resolution: ");
                sb.append(iMax2);
                sb.append("x");
                sb.append(iMax);
                zzeg.zzc("MediaCodecVideoRenderer", sb.toString());
                boolean z5 = i7 > i8;
                int i11 = z5 ? i7 : i8;
                int i12 = true != z5 ? i7 : i8;
                int[] iArr = zzb;
                int i13 = 0;
                while (i13 < 9) {
                    float f4 = i12;
                    float f5 = i11;
                    int i14 = iArr[i13];
                    int i15 = i13;
                    float f6 = i14;
                    if (i14 <= i11 || (i4 = (int) (f6 * (f4 / f5))) <= i12) {
                        break;
                    }
                    int i16 = i11;
                    if (true != z5) {
                        i5 = i12;
                        i6 = i14;
                    } else {
                        i5 = i12;
                        i6 = i4;
                    }
                    if (true != z5) {
                        i14 = i4;
                    }
                    pointZzi = zzvmVar.zzi(i6, i14);
                    float f7 = zzvVar.zzA;
                    if (pointZzi != null) {
                        z2 = z5;
                        if (zzvmVar.zzg(pointZzi.x, pointZzi.y, f7)) {
                            break;
                        }
                    } else {
                        z2 = z5;
                    }
                    i13 = i15 + 1;
                    i11 = i16;
                    i12 = i5;
                    z5 = z2;
                }
                pointZzi = null;
                if (pointZzi != null) {
                    iMax2 = Math.max(iMax2, pointZzi.x);
                    iMax = Math.max(iMax, pointZzi.y);
                    zzt zztVarZza2 = zzvVar.zza();
                    zztVarZza2.zzv(iMax2);
                    zztVarZza2.zzw(iMax);
                    iZzbm = Math.max(iZzbm, zzaw(zzvmVar, zztVarZza2.zzO()));
                    StringBuilder sb2 = new StringBuilder(String.valueOf(iMax2).length() + 35 + String.valueOf(iMax).length());
                    sb2.append("Codec max resolution adjusted to: ");
                    sb2.append(iMax2);
                    sb2.append("x");
                    sb2.append(iMax);
                    zzeg.zzc("MediaCodecVideoRenderer", sb2.toString());
                }
            }
            zzaddVar = new zzadd(iMax2, iMax, iZzbm);
        }
        String str = zzvmVar.zzc;
        this.zzo = zzaddVar;
        boolean z6 = this.zzh;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, i8);
        mediaFormat.setInteger(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, i7);
        zzej.zza(mediaFormat, zzvVar.zzs);
        float f8 = zzvVar.zzA;
        if (f8 != -1.0f) {
            mediaFormat.setFloat("frame-rate", f8);
        }
        zzej.zzb(mediaFormat, "rotation-degrees", zzvVar.zzB);
        zzi zziVar2 = zzvVar.zzF;
        if (zziVar2 != null) {
            zzej.zzb(mediaFormat, "color-transfer", zziVar2.zzd);
            zzej.zzb(mediaFormat, "color-standard", zziVar2.zzb);
            zzej.zzb(mediaFormat, "color-range", zziVar2.zzc);
            byte[] bArr = zziVar2.zze;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        if ("video/dolby-vision".equals(zzvVar.zzp) && (pairZze = zzdq.zze(zzvVar)) != null) {
            zzej.zzb(mediaFormat, "profile", ((Integer) pairZze.first).intValue());
        }
        mediaFormat.setInteger("max-width", zzaddVar.zza);
        mediaFormat.setInteger("max-height", zzaddVar.zzb);
        zzej.zzb(mediaFormat, "max-input-size", zzaddVar.zzc);
        mediaFormat.setInteger("priority", 0);
        if (f3 != -1.0f) {
            mediaFormat.setFloat("operating-rate", f3);
        }
        if (z6) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (Build.VERSION.SDK_INT >= i3) {
            mediaFormat.setInteger("importance", Math.max(0, -this.zzN));
        }
        zzbi(mediaFormat);
        Surface surfaceZzbz = zzbz(zzvmVar);
        if (this.zzr != null && !zzfl.zzU(this.zze)) {
            mediaFormat.setInteger("allow-frame-drop", 0);
        }
        return zzvg.zzb(zzvmVar, mediaFormat, zzvVar, surfaceZzbz, null);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final zzjc zzai(zzvm zzvmVar, zzv zzvVar, zzv zzvVar2) {
        int i3;
        int i4;
        int i5;
        zzjc zzjcVarZzf = zzvmVar.zzf(zzvVar, zzvVar2);
        int i6 = zzjcVarZzf.zze;
        zzadd zzaddVar = this.zzo;
        zzaddVar.getClass();
        if (zzvVar2.zzw > zzaddVar.zza || zzvVar2.zzx > zzaddVar.zzb) {
            i6 |= Function.MAX_NARGS;
        }
        if (zzbm(zzvmVar, zzvVar2) > zzaddVar.zzc) {
            i6 |= 64;
        }
        if (this.zzA != Integer.MIN_VALUE) {
            float f3 = zzvVar.zzA;
            if (f3 != -1.0f) {
                float f4 = zzvVar2.zzA;
                if (f4 != -1.0f && Math.abs(f4 - f3) > 1.0f && ((i5 = Build.VERSION.SDK_INT) < 30 || (i5 == 30 && Build.MODEL.startsWith("MiTV")))) {
                    i6 |= NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
                }
            }
        }
        String str = zzvmVar.zza;
        if (i6 != 0) {
            i4 = 0;
            i3 = i6;
        } else {
            i3 = 0;
            i4 = zzjcVarZzf.zzd;
        }
        return new zzjc(str, zzvVar, zzvVar2, i4, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final float zzak(float f3, zzv zzvVar, zzv[] zzvVarArr) {
        zzvm zzvmVarZzaL;
        float fMax = -1.0f;
        for (zzv zzvVar2 : zzvVarArr) {
            float f4 = zzvVar2.zzA;
            if (f4 != -1.0f) {
                fMax = Math.max(fMax, f4);
            }
        }
        float f5 = fMax == -1.0f ? -1.0f : fMax * f3;
        if (this.zzF == null || (zzvmVarZzaL = zzaL()) == null) {
            return f5;
        }
        float fZzh = zzvmVarZzaL.zzh(zzvVar.zzw, zzvVar.zzx);
        return f5 != -1.0f ? Math.max(f5, fZzh) : fZzh;
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final void zzal(String str, zzvg zzvgVar, long j3, long j4) {
        this.zzg.zzb(str, j3, j4);
        this.zzp = zzbq(str);
        zzvm zzvmVarZzaL = zzaL();
        zzvmVarZzaL.getClass();
        boolean z2 = false;
        if (Build.VERSION.SDK_INT >= 29 && "video/x-vnd.on2.vp9".equals(zzvmVarZzaL.zzb)) {
            MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrZzb = zzvmVarZzaL.zzb();
            int length = codecProfileLevelArrZzb.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (codecProfileLevelArrZzb[i3].profile == 16384) {
                    z2 = true;
                    break;
                }
                i3++;
            }
        }
        this.zzq = z2;
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final void zzam(String str) {
        this.zzg.zzh(str);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final void zzan(Exception exc) {
        zzeg.zzf("MediaCodecVideoRenderer", "Video codec error", exc);
        this.zzg.zzj(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final zzjc zzao(zzlw zzlwVar) throws zzjk {
        zzjc zzjcVarZzao = super.zzao(zzlwVar);
        zzv zzvVar = zzlwVar.zzb;
        zzvVar.getClass();
        this.zzg.zzc(zzvVar, zzjcVarZzao);
        zzadv zzadvVar = this.zzm;
        if (zzadvVar != null) {
            zzadvVar.zzd();
        }
        return zzjcVarZzao;
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final void zzap(zzv zzvVar, MediaFormat mediaFormat) {
        zzvj zzvjVarZzaI = zzaI();
        if (zzvjVarZzaI != null) {
            zzvjVarZzaI.zzq(this.zzz);
        }
        mediaFormat.getClass();
        boolean z2 = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        int integer = z2 ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
        int integer2 = z2 ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
        float f3 = zzvVar.zzC;
        int i3 = zzvVar.zzB;
        if (i3 == 90 || i3 == 270) {
            f3 = 1.0f / f3;
            int i4 = integer2;
            integer2 = integer;
            integer = i4;
        }
        this.zzL = new zzbv(integer, integer2, f3);
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar == null || !this.zzS) {
            this.zzi.zze(zzvVar.zzA);
        } else {
            zzt zztVarZza = zzvVar.zza();
            zztVarZza.zzv(integer);
            zztVarZza.zzw(integer2);
            zztVarZza.zzB(f3);
            zzv zzvVarZzO = zztVarZza.zzO();
            int i5 = this.zzt;
            List listZzi = this.zzu;
            if (listZzi == null) {
                listZzi = zzgwm.zzi();
            }
            zzaeuVar.zzs(1, zzvVarZzO, zzbh(), i5, listZzi);
            this.zzt = 2;
        }
        this.zzS = false;
    }

    @Override // com.google.android.gms.internal.ads.zzadt
    public final boolean zzaq(long j3, long j4, long j5, boolean z2, boolean z3) throws zzjk {
        int iZzR;
        if (this.zzr != null && this.zzf) {
            j4 -= -this.zzQ;
        }
        if (j3 >= -500000 || z2 || (iZzR = zzR(j4)) == 0) {
            return false;
        }
        this.zzG = j4;
        if (z3) {
            zzjb zzjbVar = ((zzvt) this).zza;
            int i3 = zzjbVar.zzd + iZzR;
            zzjbVar.zzd = i3;
            zzjbVar.zzf += this.zzE;
            zzjbVar.zzd = i3 + this.zzn.size();
        } else {
            ((zzvt) this).zza.zzj++;
            zzaz(iZzR + this.zzn.size(), this.zzE);
        }
        zzaN();
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar != null) {
            zzaeuVar.zzg(false);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final void zzar() {
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar != null) {
            zzaeuVar.zzi();
            long jZzbh = this.zzQ;
            if (jZzbh == -9223372036854775807L) {
                jZzbh = zzbh();
                this.zzQ = jZzbh;
            }
            this.zzr.zzo(-jZzbh);
        } else {
            this.zzi.zza(2);
        }
        this.zzS = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d0  */
    @Override // com.google.android.gms.internal.ads.zzvt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final boolean zzas(long r19, long r21, com.google.android.gms.internal.ads.zzvj r23, java.nio.ByteBuffer r24, int r25, int r26, int r27, long r28, boolean r30, boolean r31, com.google.android.gms.internal.ads.zzv r32) throws com.google.android.gms.internal.ads.zzjk {
        /*
            Method dump skipped, instruction units count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzade.zzas(long, long, com.google.android.gms.internal.ads.zzvj, java.nio.ByteBuffer, int, int, int, long, boolean, boolean, com.google.android.gms.internal.ads.zzv):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final void zzat(zziz zzizVar) {
        this.zzg.zzk(zzizVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final void zzau() {
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar != null) {
            zzaeuVar.zzi();
        } else if (zzbe() != -9223372036854775807L) {
            zzbe();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final void zzav(zziv zzivVar) throws zzjk {
        if (this.zzq) {
            ByteBuffer byteBuffer = zzivVar.zzf;
            byteBuffer.getClass();
            if (byteBuffer.remaining() >= 7) {
                byte b3 = byteBuffer.get();
                short s2 = byteBuffer.getShort();
                short s3 = byteBuffer.getShort();
                byte b4 = byteBuffer.get();
                byte b5 = byteBuffer.get();
                byteBuffer.position(0);
                if (b3 == -75 && s2 == 60 && s3 == 1 && b4 == 4) {
                    if (b5 == 0 || b5 == 1) {
                        byte[] bArr = new byte[byteBuffer.remaining()];
                        byteBuffer.get(bArr);
                        byteBuffer.position(0);
                        zzvj zzvjVarZzaI = zzaI();
                        zzvjVarZzaI.getClass();
                        Bundle bundle = new Bundle();
                        bundle.putByteArray("hdr10-plus-info", bArr);
                        zzvjVarZzaI.zzp(bundle);
                    }
                }
            }
        }
    }

    protected final void zzax(zzvj zzvjVar, int i3, long j3) {
        Trace.beginSection("skipVideoBuffer");
        zzvjVar.zzc(i3, false);
        Trace.endSection();
        ((zzvt) this).zza.zzf++;
    }

    protected final void zzay(zzvj zzvjVar, int i3, long j3) {
        Trace.beginSection("dropVideoBuffer");
        zzvjVar.zzc(i3, false);
        Trace.endSection();
        zzaz(0, 1);
    }

    protected final void zzaz(int i3, int i4) {
        zzjb zzjbVar = ((zzvt) this).zza;
        zzjbVar.zzh += i3;
        int i5 = i3 + i4;
        zzjbVar.zzg += i5;
        this.zzC += i5;
        int i6 = this.zzD + i5;
        this.zzD = i6;
        zzjbVar.zzi = Math.max(i6, zzjbVar.zzi);
    }

    final /* synthetic */ Surface zzbp() {
        return this.zzv;
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzix, com.google.android.gms.internal.ads.zzmv
    public final void zzx(int i3, Object obj) throws zzjk {
        if (i3 == 1) {
            zzbu(obj);
            return;
        }
        if (i3 == 7) {
            obj.getClass();
            zzadr zzadrVar = (zzadr) obj;
            this.zzP = zzadrVar;
            zzaeu zzaeuVar = this.zzr;
            if (zzaeuVar != null) {
                zzaeuVar.zzl(zzadrVar);
                return;
            }
            return;
        }
        if (i3 == 10) {
            obj.getClass();
            int iIntValue = ((Integer) obj).intValue();
            if (this.zzO != iIntValue) {
                this.zzO = iIntValue;
                return;
            }
            return;
        }
        if (i3 == 4) {
            obj.getClass();
            int iIntValue2 = ((Integer) obj).intValue();
            this.zzz = iIntValue2;
            zzvj zzvjVarZzaI = zzaI();
            if (zzvjVarZzaI != null) {
                zzvjVarZzaI.zzq(iIntValue2);
                return;
            }
            return;
        }
        if (i3 == 5) {
            obj.getClass();
            int iIntValue3 = ((Integer) obj).intValue();
            this.zzA = iIntValue3;
            zzaeu zzaeuVar2 = this.zzr;
            if (zzaeuVar2 != null) {
                zzaeuVar2.zzr(iIntValue3);
                return;
            } else {
                this.zzi.zzm(iIntValue3);
                return;
            }
        }
        if (i3 == 13) {
            obj.getClass();
            List list = (List) obj;
            if (list.equals(zzbr.zza)) {
                zzaeu zzaeuVar3 = this.zzr;
                if (zzaeuVar3 == null || !zzaeuVar3.zze()) {
                    return;
                }
                zzaeuVar3.zzf();
                return;
            }
            this.zzu = list;
            zzaeu zzaeuVar4 = this.zzr;
            if (zzaeuVar4 != null) {
                zzaeuVar4.zzn(list);
                return;
            }
            return;
        }
        if (i3 == 14) {
            obj.getClass();
            zzeu zzeuVar = (zzeu) obj;
            if (zzeuVar.zza() == 0 || zzeuVar.zzb() == 0) {
                return;
            }
            this.zzx = zzeuVar;
            zzaeu zzaeuVar5 = this.zzr;
            if (zzaeuVar5 != null) {
                Surface surface = this.zzv;
                surface.getClass();
                zzaeuVar5.zzp(surface, zzeuVar);
                return;
            }
            return;
        }
        switch (i3) {
            case 16:
                obj.getClass();
                this.zzN = ((Integer) obj).intValue();
                zzvj zzvjVarZzaI2 = zzaI();
                if (zzvjVarZzaI2 != null && Build.VERSION.SDK_INT >= 35) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("importance", Math.max(0, -this.zzN));
                    zzvjVarZzaI2.zzp(bundle);
                    break;
                }
                break;
            case 17:
                Surface surface2 = this.zzv;
                zzbu(null);
                obj.getClass();
                ((zzade) obj).zzx(1, surface2);
                break;
            case 18:
                boolean z2 = this.zzF != null;
                zznh zznhVar = (zznh) obj;
                this.zzF = zznhVar;
                if (z2 != (zznhVar != null)) {
                    zzbd();
                }
                break;
            default:
                super.zzx(i3, obj);
                break;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzix
    protected final void zzy(boolean z2, boolean z3) throws zzjk {
        super.zzy(z2, z3);
        zzK();
        this.zzg.zza(((zzvt) this).zza);
        if (!this.zzs) {
            if (this.zzu != null && this.zzr == null) {
                zzadi zzadiVar = new zzadi(this.zze, this.zzi);
                zzadiVar.zza(true);
                zzadiVar.zzc(-this.zzl);
                zzadiVar.zzb(zzM());
                zzadq zzadqVarZzd = zzadiVar.zzd();
                zzadqVarZzd.zza(1);
                this.zzr = zzadqVarZzd.zzb(0);
            }
            this.zzs = true;
        }
        int i3 = !z3 ? 1 : 0;
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar == null) {
            zzadu zzaduVar = this.zzi;
            zzaduVar.zzg(zzM());
            zzaduVar.zza(i3);
            return;
        }
        zzaeuVar.zzc(new zzacz(this), zzhcn.zza());
        zzadr zzadrVar = this.zzP;
        if (zzadrVar != null) {
            this.zzr.zzl(zzadrVar);
        }
        if (this.zzv != null && !this.zzx.equals(zzeu.zza)) {
            this.zzr.zzp(this.zzv, this.zzx);
        }
        this.zzr.zzr(this.zzA);
        this.zzr.zzm(zzbb());
        List list = this.zzu;
        if (list != null) {
            this.zzr.zzn(list);
        }
        this.zzt = i3;
        zzaD();
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzix
    protected final void zzz(zzv[] zzvVarArr, long j3, long j4, zzxk zzxkVar) throws zzjk {
        super.zzz(zzvVarArr, j3, j4, zzxkVar);
        zzbt(zzxkVar);
        zzadv zzadvVar = this.zzm;
        if (zzadvVar != null) {
            zzadvVar.zzd();
        }
    }
}
