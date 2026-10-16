package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzvt extends zzix {
    private static final byte[] zzb = {0, 0, 1, 103, 66, -64, Ascii.VT, -38, 37, -112, 0, 0, 1, 104, -50, Ascii.SI, 19, 32, 0, 0, 1, 101, -120, -124, Ascii.CR, -50, 113, Ascii.CAN, -96, 0, 47, -65, Ascii.FS, Framer.STDOUT_FRAME_PREFIX, -61, 39, 93, Framer.EXIT_FRAME_PREFIX};
    private boolean zzA;
    private float zzB;
    private ArrayDeque zzC;
    private zzvp zzD;
    private zzvm zzE;
    private int zzF;
    private boolean zzG;
    private boolean zzH;
    private boolean zzI;
    private boolean zzJ;
    private boolean zzK;
    private long zzL;
    private boolean zzM;
    private long zzN;
    private int zzO;
    private int zzP;
    private ByteBuffer zzQ;
    private boolean zzR;
    private boolean zzS;
    private boolean zzT;
    private boolean zzU;
    private boolean zzV;
    private boolean zzW;
    private int zzX;
    private int zzY;
    private int zzZ;
    protected zzjb zza;
    private boolean zzaa;
    private boolean zzab;
    private boolean zzac;
    private long zzad;
    private boolean zzae;
    private boolean zzaf;
    private boolean zzag;
    private zzvs zzah;
    private long zzai;
    private boolean zzaj;
    private boolean zzak;
    private boolean zzal;
    private long zzam;
    private zziz zzan;
    private zziz zzao;
    private zzgww zzap;
    private final Context zzc;
    private final zzvh zzd;
    private final zzvv zze;
    private final float zzf;
    private final zziv zzg;
    private final zziv zzh;
    private final zziv zzi;
    private final zzva zzj;
    private final MediaCodec.BufferInfo zzk;
    private final ArrayDeque zzl;
    private final zzty zzm;
    private final AtomicInteger zzn;
    private zzv zzo;
    private zzv zzp;
    private zzug zzq;
    private zzug zzr;
    private zzmz zzs;
    private MediaCrypto zzt;
    private long zzu;
    private float zzv;
    private float zzw;
    private zzvj zzx;
    private zzv zzy;
    private MediaFormat zzz;

    public zzvt(Context context, int i3, zzvh zzvhVar, zzvv zzvvVar, boolean z2, float f3) {
        super(i3);
        this.zzc = context.getApplicationContext();
        this.zzd = zzvhVar;
        zzvvVar.getClass();
        this.zze = zzvvVar;
        this.zzf = f3;
        this.zzn = new AtomicInteger();
        this.zzg = new zziv(0, 0);
        this.zzh = new zziv(0, 0);
        this.zzi = new zziv(2, 0);
        zzva zzvaVar = new zzva();
        this.zzj = zzvaVar;
        this.zzk = new MediaCodec.BufferInfo();
        this.zzv = 1.0f;
        this.zzw = 1.0f;
        this.zzu = -9223372036854775807L;
        this.zzl = new ArrayDeque();
        this.zzah = zzvs.zza;
        zzvaVar.zzj(0);
        zzvaVar.zzc.order(ByteOrder.nativeOrder());
        this.zzm = new zzty();
        this.zzB = -1.0f;
        this.zzF = 0;
        this.zzX = 0;
        this.zzO = -1;
        this.zzP = -1;
        this.zzN = -9223372036854775807L;
        this.zzad = -9223372036854775807L;
        this.zzai = -9223372036854775807L;
        this.zzL = -9223372036854775807L;
        this.zzY = 0;
        this.zzZ = 0;
        this.zza = new zzjb();
        this.zzal = false;
        this.zzam = 0L;
        this.zzap = zzgww.zzh();
        zziz zzizVar = zziz.zza;
        this.zzan = zzizVar;
        this.zzao = zzizVar;
    }

    private final boolean zzaA(int i3) throws zzjk {
        zzlw zzlwVarZzI = zzI();
        zziv zzivVar = this.zzg;
        zzivVar.zza();
        int iZzQ = zzQ(zzlwVarZzI, zzivVar, i3 | 4);
        if (iZzQ == -5) {
            zzao(zzlwVarZzI);
            return true;
        }
        if (iZzQ != -4 || !zzivVar.zzb()) {
            return false;
        }
        this.zzae = true;
        zzbr();
        return false;
    }

    private final boolean zzaB(long j3) {
        return this.zzu == -9223372036854775807L || zzM().zzb() - j3 < this.zzu;
    }

    private final boolean zzaC() {
        return this.zzP >= 0;
    }

    private final void zzaq() {
        this.zzT = false;
        zzaw();
    }

    private final void zzaw() {
        zzaz();
        this.zzV = false;
        this.zzj.zza();
        this.zzi.zza();
        this.zzU = false;
        this.zzm.zzb();
    }

    private final boolean zzax() {
        if (this.zzx == null) {
            return false;
        }
        if (zzaO()) {
            zzaM();
            return true;
        }
        if (zzaP()) {
            zzay();
            return false;
        }
        this.zzal = true;
        return false;
    }

    private final void zzay() {
        try {
            zzvj zzvjVar = this.zzx;
            if (zzvjVar == null) {
                throw null;
            }
            zzvjVar.zzk();
        } finally {
            zzaR();
        }
    }

    private final void zzaz() {
        this.zzad = -9223372036854775807L;
        zzbt().zzf = -9223372036854775807L;
        this.zzai = -9223372036854775807L;
    }

    protected static boolean zzbj(zzv zzvVar) {
        return zzvVar.zzO == 0;
    }

    private final void zzbm() {
        this.zzO = -1;
        this.zzh.zzc = null;
    }

    private final void zzbn() {
        this.zzP = -1;
        this.zzQ = null;
    }

    private final boolean zzbo(zzv zzvVar) throws zzjk {
        if (this.zzx != null && this.zzZ != 3 && zze() != 0) {
            float f3 = this.zzw;
            zzvVar.getClass();
            float fZzak = zzak(f3, zzvVar, zzJ());
            float f4 = this.zzB;
            if (f4 != fZzak) {
                if (fZzak == -1.0f) {
                    zzbq();
                    return false;
                }
                if (f4 != -1.0f || fZzak > this.zzf) {
                    Bundle bundle = new Bundle();
                    bundle.putFloat("operating-rate", fZzak);
                    zzvj zzvjVar = this.zzx;
                    zzvjVar.getClass();
                    zzvjVar.zzp(bundle);
                    this.zzB = fZzak;
                }
            }
        }
        return true;
    }

    private final boolean zzbp() throws zzjk {
        if (this.zzaa) {
            this.zzY = 1;
            if (this.zzH) {
                this.zzZ = 3;
                return false;
            }
            this.zzZ = 2;
        } else {
            zzbu();
        }
        return true;
    }

    private final void zzbq() throws zzjk {
        if (this.zzaa) {
            this.zzY = 1;
            this.zzZ = 3;
        } else {
            zzaM();
            zzaE();
        }
    }

    private final void zzbr() throws zzjk {
        int i3 = this.zzZ;
        if (i3 == 1) {
            zzay();
            return;
        }
        if (i3 == 2) {
            zzay();
            zzbu();
        } else if (i3 != 3) {
            this.zzaf = true;
            zzau();
        } else {
            zzaM();
            zzaE();
        }
    }

    private final void zzbs(zzvs zzvsVar) {
        this.zzah = zzvsVar;
        if (zzvsVar.zzd != -9223372036854775807L) {
            this.zzaj = true;
        }
    }

    private final zzvs zzbt() {
        ArrayDeque arrayDeque = this.zzl;
        return !arrayDeque.isEmpty() ? (zzvs) arrayDeque.getLast() : this.zzah;
    }

    private final void zzbu() throws zzjk {
        zzug zzugVar = this.zzr;
        zzugVar.getClass();
        this.zzq = zzugVar;
        this.zzY = 0;
        this.zzZ = 0;
    }

    private final boolean zzbv(long j3, long j4) {
        if (j4 >= j3) {
            return false;
        }
        zzv zzvVar = this.zzp;
        return (zzvVar != null && Objects.equals(zzvVar.zzp, "audio/opus") && zzgv.zzf(j3, j4)) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzix
    protected void zzA(long j3, boolean z2, boolean z3) throws zzjk {
        ArrayDeque arrayDeque = this.zzl;
        if (!arrayDeque.isEmpty()) {
            this.zzah = (zzvs) arrayDeque.getLast();
        }
        arrayDeque.clear();
        if (z3) {
            this.zzae = false;
            this.zzaf = false;
            if (this.zzT) {
                zzaw();
            } else {
                zzaN();
            }
            zzfh zzfhVar = this.zzah.zze;
            if (zzfhVar.zzc() > 0) {
                this.zzag = true;
            }
            zzfhVar.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzix
    protected void zzD() {
        this.zzo = null;
        zzbs(zzvs.zza);
        this.zzl.clear();
        if (this.zzT) {
            zzaq();
        } else {
            zzax();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzix
    protected void zzE() {
        try {
            zzaq();
            zzaM();
        } finally {
            this.zzr = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final long zzV(long j3, long j4) {
        return zzaj(j3, j4, this.zzM);
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public void zzX(float f3, float f4) throws zzjk {
        this.zzv = f3;
        this.zzw = f4;
        zzbo(this.zzy);
    }

    /* JADX WARN: Code restructure failed: missing block: B:250:0x03df, code lost:
    
        r9 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x0422, code lost:
    
        if (r24.zzK != false) goto L276;
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x0424, code lost:
    
        r24.zzab = true;
        r2.zza(r24.zzO, 0, 0, 0, 4);
        zzbm();
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x0437, code lost:
    
        r24.zzY = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007c, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:255:0x03eb A[LOOP:0: B:128:0x01fd->B:255:0x03eb, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:384:0x05fd  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x0617  */
    /* JADX WARN: Removed duplicated region for block: B:393:0x0622  */
    /* JADX WARN: Removed duplicated region for block: B:395:0x0625  */
    /* JADX WARN: Removed duplicated region for block: B:398:0x0634  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x0637  */
    /* JADX WARN: Removed duplicated region for block: B:424:0x03ea A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c7 A[Catch: IllegalStateException -> 0x009c, CryptoException -> 0x00a1, TryCatch #5 {IllegalStateException -> 0x009c, blocks: (B:121:0x01d9, B:46:0x0099, B:56:0x00ac, B:58:0x00b0, B:61:0x00b9, B:64:0x00c7, B:65:0x00d6, B:69:0x00e3, B:71:0x00e9, B:111:0x01c1, B:113:0x01c7, B:114:0x01ca, B:116:0x01d0, B:118:0x01d4, B:72:0x00f3, B:74:0x00f9, B:75:0x0105, B:77:0x0115, B:80:0x0125, B:83:0x012b, B:85:0x012f, B:87:0x0139, B:89:0x0143, B:90:0x0160, B:91:0x0168, B:92:0x0169, B:94:0x0170, B:96:0x0178, B:98:0x017e, B:99:0x0185, B:101:0x0191, B:102:0x019a, B:107:0x01b5, B:109:0x01bb, B:105:0x01a1, B:79:0x011d, B:110:0x01be, B:125:0x01e8, B:127:0x01ef, B:128:0x01fd, B:130:0x0201, B:137:0x0218, B:139:0x021e, B:141:0x0226, B:143:0x0230, B:145:0x0238, B:147:0x023e, B:149:0x0244, B:152:0x024e, B:153:0x025b, B:155:0x0261, B:157:0x026d, B:166:0x027e, B:167:0x0286, B:168:0x028e, B:169:0x0296, B:170:0x029e, B:171:0x02a6, B:173:0x02b2, B:174:0x02b7, B:175:0x02bd, B:176:0x02be, B:178:0x02c2, B:180:0x02c6, B:182:0x02ca, B:183:0x02cd, B:185:0x02d3, B:187:0x02e2), top: B:408:0x0028 }] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r24v0, types: [com.google.android.gms.internal.ads.zzix, com.google.android.gms.internal.ads.zzvt] */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [android.media.MediaFormat, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v5 */
    @Override // com.google.android.gms.internal.ads.zzna
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void zzZ(long r25, long r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1616
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvt.zzZ(long, long):void");
    }

    public final void zzaD() {
        this.zzak = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01d8 A[Catch: Exception -> 0x0105, TryCatch #4 {Exception -> 0x0105, blocks: (B:57:0x00db, B:59:0x00e5, B:61:0x00f9, B:67:0x0137, B:69:0x014a, B:71:0x0164, B:73:0x016f, B:77:0x017b, B:79:0x0184, B:81:0x018c, B:83:0x0194, B:85:0x019c, B:87:0x01a4, B:89:0x01ac, B:101:0x01d2, B:103:0x01d8, B:105:0x01df, B:106:0x01ed, B:108:0x01fb, B:110:0x0203, B:112:0x0207, B:115:0x0219, B:93:0x01b8, B:95:0x01c2, B:97:0x01cc), top: B:157:0x00db }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0253 A[Catch: zzvp -> 0x0082, TryCatch #2 {zzvp -> 0x0082, blocks: (B:25:0x0055, B:27:0x005c, B:29:0x0060, B:31:0x0076, B:36:0x0087, B:40:0x0093, B:42:0x009b, B:44:0x009f, B:46:0x00a3, B:48:0x00ac, B:129:0x023a, B:131:0x0253, B:133:0x025c, B:136:0x0263, B:137:0x0265, B:132:0x0256, B:139:0x0267, B:140:0x0268, B:142:0x026d, B:143:0x026e, B:144:0x0278, B:38:0x008a, B:39:0x0092, B:146:0x027b), top: B:154:0x0055, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0256 A[Catch: zzvp -> 0x0082, TryCatch #2 {zzvp -> 0x0082, blocks: (B:25:0x0055, B:27:0x005c, B:29:0x0060, B:31:0x0076, B:36:0x0087, B:40:0x0093, B:42:0x009b, B:44:0x009f, B:46:0x00a3, B:48:0x00ac, B:129:0x023a, B:131:0x0253, B:133:0x025c, B:136:0x0263, B:137:0x0265, B:132:0x0256, B:139:0x0267, B:140:0x0268, B:142:0x026d, B:143:0x026e, B:144:0x0278, B:38:0x008a, B:39:0x0092, B:146:0x027b), top: B:154:0x0055, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0263 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0225 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v30, types: [com.google.android.gms.internal.ads.zzvh] */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [com.google.android.gms.internal.ads.zzvm] */
    /* JADX WARN: Type inference failed for: r10v6, types: [com.google.android.gms.internal.ads.zzvg] */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r17v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r25v0, types: [com.google.android.gms.internal.ads.zzix, com.google.android.gms.internal.ads.zzvt] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.util.ArrayDeque] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void zzaE() throws com.google.android.gms.internal.ads.zzjk {
        /*
            Method dump skipped, instruction units count: 645
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvt.zzaE():void");
    }

    protected final boolean zzaF(zzv zzvVar) {
        return this.zzr == null && zzag(zzvVar);
    }

    protected boolean zzaG(zzvm zzvmVar) {
        return true;
    }

    protected final boolean zzaH() {
        return this.zzT;
    }

    protected final zzvj zzaI() {
        return this.zzx;
    }

    protected final zzv zzaJ() {
        return this.zzy;
    }

    protected final MediaFormat zzaK() {
        return this.zzz;
    }

    protected final zzvm zzaL() {
        return this.zzE;
    }

    protected final void zzaM() {
        try {
            zzvj zzvjVar = this.zzx;
            if (zzvjVar != null) {
                zzvjVar.zzl();
                this.zza.zzb++;
                zzvm zzvmVar = this.zzE;
                if (zzvmVar == null) {
                    throw null;
                }
                zzam(zzvmVar.zza);
            }
            this.zzx = null;
            this.zzt = null;
            this.zzq = null;
            zzaS();
        } catch (Throwable th) {
            this.zzx = null;
            this.zzt = null;
            this.zzq = null;
            zzaS();
            throw th;
        }
    }

    protected final boolean zzaN() throws zzjk {
        boolean zZzax = zzax();
        if (zZzax) {
            zzaE();
        }
        return zZzax;
    }

    protected boolean zzaO() {
        int i3 = this.zzZ;
        if (i3 == 3 || ((this.zzG && !this.zzac) || (this.zzH && this.zzab))) {
            return true;
        }
        if (i3 != 2) {
            return false;
        }
        try {
            zzbu();
            return false;
        } catch (zzjk e3) {
            zzeg.zzd("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e3);
            return true;
        }
    }

    protected boolean zzaP() {
        return true;
    }

    protected final long zzaQ() {
        return this.zzam;
    }

    protected void zzaR() {
        zzbm();
        zzbn();
        zzaz();
        this.zzN = -9223372036854775807L;
        this.zzab = false;
        this.zzL = -9223372036854775807L;
        this.zzaa = false;
        this.zzI = false;
        this.zzJ = false;
        this.zzR = false;
        this.zzS = false;
        this.zzY = 0;
        this.zzZ = 0;
        this.zzX = this.zzW ? 1 : 0;
        this.zzal = false;
        this.zzam = 0L;
    }

    protected final void zzaS() {
        zzaR();
        this.zzC = null;
        this.zzE = null;
        this.zzy = null;
        this.zzz = null;
        this.zzA = false;
        this.zzac = false;
        this.zzB = -1.0f;
        this.zzF = 0;
        this.zzG = false;
        this.zzH = false;
        this.zzK = false;
        this.zzM = false;
        this.zzW = false;
        this.zzX = 0;
    }

    protected zzvl zzaT(Throwable th, zzvm zzvmVar) {
        return new zzvl(th, zzvmVar);
    }

    protected boolean zzaU(zzv zzvVar) throws zzjk {
        return true;
    }

    protected int zzaW(zziv zzivVar) {
        return 0;
    }

    protected boolean zzaX(zziv zzivVar) {
        return false;
    }

    protected final long zzaY() {
        return this.zzai;
    }

    protected void zzaZ(long j3) {
        this.zzai = j3;
        while (true) {
            ArrayDeque arrayDeque = this.zzl;
            if (arrayDeque.isEmpty() || j3 < ((zzvs) arrayDeque.peek()).zzb) {
                return;
            }
            zzvs zzvsVar = (zzvs) arrayDeque.poll();
            zzvsVar.getClass();
            zzbs(zzvsVar);
            zzar();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public boolean zzaa() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public boolean zzab() {
        return this.zzaf;
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final int zzad(zzv zzvVar) throws zzjk {
        try {
            return zzae(this.zze, zzvVar);
        } catch (zzvx e3) {
            throw zzP(e3, zzvVar, false, 4002);
        }
    }

    protected abstract int zzae(zzvv zzvvVar, zzv zzvVar) throws zzvx;

    protected abstract List zzaf(zzvv zzvvVar, zzv zzvVar, boolean z2) throws zzvx;

    protected boolean zzag(zzv zzvVar) {
        return false;
    }

    protected abstract zzvg zzah(zzvm zzvmVar, zzv zzvVar, MediaCrypto mediaCrypto, float f3);

    protected zzjc zzai(zzvm zzvmVar, zzv zzvVar, zzv zzvVar2) {
        throw null;
    }

    protected long zzaj(long j3, long j4, boolean z2) {
        return super.zzV(j3, j4);
    }

    protected float zzak(float f3, zzv zzvVar, zzv[] zzvVarArr) {
        throw null;
    }

    protected void zzal(String str, zzvg zzvgVar, long j3, long j4) {
        throw null;
    }

    protected void zzam(String str) {
        throw null;
    }

    protected void zzan(Exception exc) {
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected com.google.android.gms.internal.ads.zzjc zzao(com.google.android.gms.internal.ads.zzlw r14) throws com.google.android.gms.internal.ads.zzjk {
        /*
            Method dump skipped, instruction units count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvt.zzao(com.google.android.gms.internal.ads.zzlw):com.google.android.gms.internal.ads.zzjc");
    }

    protected void zzap(zzv zzvVar, MediaFormat mediaFormat) throws zzjk {
        throw null;
    }

    protected abstract boolean zzas(long j3, long j4, zzvj zzvjVar, ByteBuffer byteBuffer, int i3, int i4, int i5, long j5, boolean z2, boolean z3, zzv zzvVar) throws zzjk;

    protected abstract void zzat(zziz zzizVar);

    protected void zzau() throws zzjk {
        throw null;
    }

    protected void zzav(zziv zzivVar) throws zzjk {
        throw null;
    }

    protected final boolean zzba() {
        if (this.zzo == null) {
            return false;
        }
        if (zzS() || zzaC()) {
            return true;
        }
        return this.zzN != -9223372036854775807L && zzM().zzb() < this.zzN;
    }

    protected final float zzbb() {
        return this.zzv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzmz zzbc() {
        return this.zzs;
    }

    protected final boolean zzbd() throws zzjk {
        return zzbo(this.zzy);
    }

    protected final long zzbe() {
        return this.zzah.zzf;
    }

    protected final long zzbf() {
        return this.zzad;
    }

    protected final long zzbg() {
        return this.zzah.zzd;
    }

    protected final long zzbh() {
        return this.zzah.zzc;
    }

    protected final void zzbi(MediaFormat mediaFormat) {
        if (Build.VERSION.SDK_INT >= 29) {
            this.zzan.zzb(mediaFormat);
        }
    }

    final /* synthetic */ void zzbk(zzlw zzlwVar) {
        this.zzn.set(zzQ(zzlwVar, this.zzh, 0));
    }

    final /* synthetic */ zzmz zzbl() {
        return this.zzs;
    }

    @Override // com.google.android.gms.internal.ads.zzix, com.google.android.gms.internal.ads.zznc
    public final int zzu() {
        return 8;
    }

    @Override // com.google.android.gms.internal.ads.zzix, com.google.android.gms.internal.ads.zzmv
    public void zzx(int i3, Object obj) throws zzjk {
        if (i3 != 11) {
            return;
        }
        zzmz zzmzVar = (zzmz) obj;
        zzmzVar.getClass();
        this.zzs = zzmzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzix
    protected void zzy(boolean z2, boolean z3) throws zzjk {
        this.zza = new zzjb();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
    
        if (r4 >= r0) goto L16;
     */
    @Override // com.google.android.gms.internal.ads.zzix
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void zzz(com.google.android.gms.internal.ads.zzv[] r12, long r13, long r15, com.google.android.gms.internal.ads.zzxk r17) throws com.google.android.gms.internal.ads.zzjk {
        /*
            r11 = this;
            com.google.android.gms.internal.ads.zzvs r12 = r11.zzah
            long r0 = r12.zzd
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r12 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r12 != 0) goto L24
            com.google.android.gms.internal.ads.zzvs r4 = new com.google.android.gms.internal.ads.zzvs
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = r13
            r9 = r15
            r4.<init>(r5, r7, r9)
            r11.zzbs(r4)
            boolean r12 = r11.zzak
            if (r12 == 0) goto L56
            r11.zzar()
            return
        L24:
            java.util.ArrayDeque r12 = r11.zzl
            boolean r0 = r12.isEmpty()
            if (r0 == 0) goto L57
            long r0 = r11.zzad
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L3c
            long r4 = r11.zzai
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 == 0) goto L57
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 < 0) goto L57
        L3c:
            com.google.android.gms.internal.ads.zzvs r4 = new com.google.android.gms.internal.ads.zzvs
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = r13
            r9 = r15
            r4.<init>(r5, r7, r9)
            r11.zzbs(r4)
            com.google.android.gms.internal.ads.zzvs r12 = r11.zzah
            long r12 = r12.zzd
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 == 0) goto L56
            r11.zzar()
        L56:
            return
        L57:
            com.google.android.gms.internal.ads.zzvs r0 = new com.google.android.gms.internal.ads.zzvs
            long r1 = r11.zzad
            r3 = r13
            r5 = r15
            r0.<init>(r1, r3, r5)
            r12.add(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvt.zzz(com.google.android.gms.internal.ads.zzv[], long, long, com.google.android.gms.internal.ads.zzxk):void");
    }

    protected void zzar() {
    }

    protected void zzaV(zziv zzivVar) throws zzjk {
    }
}
