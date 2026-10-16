package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzlh extends zzf implements zzjv {
    public static final /* synthetic */ int zzd = 0;
    private final long zzA;
    private final zzdm zzB;
    private final zzfc zzC;
    private final zzlg zzD;
    private final zzjx zzE;
    private final zzjx zzF;
    private int zzG;
    private int zzH;
    private boolean zzI;
    private zznh zzJ;
    private zzni zzK;
    private zzju zzL;
    private zzax zzM;
    private zzan zzN;
    private Object zzO;
    private Surface zzP;
    private int zzQ;
    private zzeu zzR;
    private zzd zzS;
    private float zzT;
    private boolean zzU;
    private boolean zzV;
    private boolean zzW;
    private int zzX;
    private boolean zzY;
    private zzan zzZ;
    private zzms zzaa;
    private int zzab;
    private long zzac;
    private zzzf zzad;
    final zzabi zzb;
    final zzax zzc;
    private final zzds zze = new zzds(zzdo.zza);
    private final Context zzf;
    private final zzbb zzg;
    private final zzna[] zzh;
    private final zzna[] zzi;
    private final zzabh zzj;
    private final zzdz zzk;
    private final zzls zzl;
    private final zzlu zzm;
    private final zzef zzn;
    private final CopyOnWriteArraySet zzo;
    private final zzbd zzp;
    private final List zzq;
    private final boolean zzr;
    private final zznm zzs;
    private final Looper zzt;
    private final zzabq zzu;
    private final zzdo zzv;
    private final zzkd zzw;
    private final zzlc zzx;
    private final zzfr zzy;
    private final zzfs zzz;

    static {
        zzal.zzb("media3.exoplayer");
    }

    public zzlh(zzjt zzjtVar, zzbb zzbbVar) {
        try {
            String hexString = Integer.toHexString(System.identityHashCode(this));
            String str = zzfl.zza;
            StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 36 + String.valueOf(str).length() + 1);
            sb.append("Init ");
            sb.append(hexString);
            sb.append(" [AndroidXMedia3/1.10.0-rc02] [");
            sb.append(str);
            sb.append("]");
            zzeg.zzb("ExoPlayerImpl", sb.toString());
            this.zzf = zzjtVar.zza.getApplicationContext();
            this.zzs = (zznm) zzjtVar.zzh.apply(zzjtVar.zzb);
            this.zzX = zzjtVar.zzj;
            this.zzS = zzjtVar.zzk;
            this.zzQ = zzjtVar.zzl;
            this.zzU = false;
            this.zzA = zzjtVar.zzq;
            zzkd zzkdVar = new zzkd(this, null);
            this.zzw = zzkdVar;
            this.zzx = new zzlc(null);
            zzna[] zznaVarArrZza = ((zznf) zzjtVar.zzc.zza()).zza(new Handler(zzjtVar.zzi), zzkdVar, zzkdVar, zzkdVar, zzkdVar);
            this.zzh = zznaVarArrZza;
            int length = zznaVarArrZza.length;
            this.zzi = new zzna[2];
            int i3 = 0;
            while (true) {
                zzna[] zznaVarArr = this.zzi;
                int length2 = zznaVarArr.length;
                if (i3 >= 2) {
                    break;
                }
                zzna zznaVar = this.zzh[i3];
                zznaVarArr[i3] = null;
                i3++;
            }
            zzabh zzabhVar = (zzabh) zzjtVar.zze.zza();
            this.zzj = zzabhVar;
            zzabq zzabqVar = (zzabq) zzjtVar.zzg.zza();
            this.zzu = zzabqVar;
            this.zzr = zzjtVar.zzm;
            this.zzK = zzjtVar.zzn;
            this.zzJ = zzjtVar.zzo;
            Looper looper = zzjtVar.zzi;
            this.zzt = looper;
            zzdo zzdoVar = zzjtVar.zzb;
            this.zzv = zzdoVar;
            this.zzg = zzbbVar;
            this.zzn = new zzef(looper, zzdoVar, new zzeb() { // from class: com.google.android.gms.internal.ads.zzlb
                @Override // com.google.android.gms.internal.ads.zzeb
                public final /* synthetic */ void zza(Object obj, zzs zzsVar) {
                    this.zza.zzJ((zzaz) obj, zzsVar);
                }
            });
            CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
            this.zzo = copyOnWriteArraySet;
            this.zzq = new ArrayList();
            this.zzad = new zzzf(0);
            this.zzL = zzju.zza;
            int length3 = this.zzh.length;
            zzabi zzabiVar = new zzabi(new zznd[2], new zzaba[2], zzbn.zza, null);
            this.zzb = zzabiVar;
            this.zzp = new zzbd();
            zzaw zzawVar = new zzaw();
            zzawVar.zzc(1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 35, 22, 24, 27, 28, 32);
            zzabhVar.zzd();
            zzawVar.zzb(29, true);
            zzawVar.zzb(23, false);
            zzawVar.zzb(25, false);
            zzawVar.zzb(33, false);
            zzawVar.zzb(26, false);
            zzawVar.zzb(34, false);
            zzax zzaxVarZze = zzawVar.zze();
            this.zzc = zzaxVarZze;
            zzaw zzawVar2 = new zzaw();
            zzawVar2.zzd(zzaxVarZze);
            zzawVar2.zza(4);
            zzawVar2.zza(10);
            this.zzM = zzawVar2.zze();
            this.zzk = zzdoVar.zzd(looper, null);
            zzls zzlsVar = new zzls() { // from class: com.google.android.gms.internal.ads.zzke
                @Override // com.google.android.gms.internal.ads.zzls
                public final /* synthetic */ void zza(zzlr zzlrVar) {
                    this.zza.zzK(zzlrVar);
                }
            };
            this.zzl = zzlsVar;
            this.zzaa = zzms.zza(zzabiVar);
            this.zzs.zzx(zzbbVar, looper);
            final zzqf zzqfVar = new zzqf(zzjtVar.zzx);
            zzlu zzluVar = new zzlu(this.zzf, this.zzh, this.zzi, zzabhVar, zzabiVar, (zzly) zzjtVar.zzf.zza(), zzabqVar, 0, false, this.zzs, this.zzK, zzjtVar.zzz, zzjtVar.zzp, false, false, looper, zzdoVar, zzlsVar, zzqfVar, null, this.zzL, this.zzx, zzjtVar.zzy);
            this.zzm = zzluVar;
            Looper looperZzn = zzluVar.zzn();
            this.zzT = 1.0f;
            zzan zzanVar = zzan.zza;
            this.zzN = zzanVar;
            this.zzZ = zzanVar;
            this.zzab = -1;
            int i4 = zzcz.zza;
            this.zzV = true;
            zze(this.zzs);
            zzabqVar.zzf(new Handler(looper), this.zzs);
            copyOnWriteArraySet.add(this.zzw);
            int i5 = Build.VERSION.SDK_INT;
            if (i5 >= 31) {
                final Context context = this.zzf;
                final boolean z2 = zzjtVar.zzv;
                zzdoVar.zzd(zzluVar.zzn(), null).zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzjw
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzqb zzqbVarZza = zzqb.zza(context);
                        if (zzqbVarZza == null) {
                            zzeg.zzc("ExoPlayerImpl", "MediaMetricsService unavailable.");
                            return;
                        }
                        if (z2) {
                            this.zzD(zzqbVarZza);
                        }
                        zzqfVar.zzb(zzqbVarZza.zzb());
                    }
                });
            }
            zzdm zzdmVar = new zzdm(0, looperZzn, looper, zzdoVar, new zzdl() { // from class: com.google.android.gms.internal.ads.zzkp
                @Override // com.google.android.gms.internal.ads.zzdl
                public final /* synthetic */ void zza(Object obj, Object obj2) {
                    int iIntValue = ((Integer) obj2).intValue();
                    this.zza.zzL(((Integer) obj).intValue(), iIntValue);
                }
            });
            this.zzB = zzdmVar;
            zzdmVar.zzd(new Runnable() { // from class: com.google.android.gms.internal.ads.zzku
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzM();
                }
            });
            new zzbz(zzjtVar.zza, looperZzn, zzjtVar.zzi, this.zzw, zzdoVar);
            boolean z3 = (zzjtVar.zzs == Integer.MAX_VALUE || zzjtVar.zzt == Integer.MAX_VALUE) ? false : true;
            zzfr zzfrVar = new zzfr(zzjtVar.zza, looperZzn, zzdoVar);
            this.zzy = zzfrVar;
            zzfrVar.zza(z3);
            this.zzz = new zzfs(zzjtVar.zza, looperZzn, zzdoVar);
            int i6 = zzm.zza;
            zzbv zzbvVar = zzbv.zza;
            this.zzR = zzeu.zza;
            this.zzD = i5 >= 34 ? new zzlg(this, zzjtVar.zza, null) : null;
            this.zzE = new zzjx(this, 1, null);
            this.zzF = new zzjx(this, 2, null);
            this.zzC = new zzfc(this, this.zzw, zzdoVar, zzjtVar.zzr, zzjtVar.zzs, zzjtVar.zzt, zzjtVar.zzu);
            zzluVar.zzg(this.zzJ);
            zzluVar.zzi(this.zzS, false);
            zzau(1, 3, this.zzS);
            zzau(2, 4, Integer.valueOf(this.zzQ));
            zzau(2, 5, 0);
            zzau(1, 9, Boolean.valueOf(this.zzU));
            zzau(6, 8, this.zzx);
            zzau(-1, 16, Integer.valueOf(this.zzX));
            this.zze.zza();
        } catch (Throwable th) {
            this.zze.zza();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzaf, reason: merged with bridge method [inline-methods] */
    public final void zzP(zzjk zzjkVar) {
        zzms zzmsVar = this.zzaa;
        zzms zzmsVarZzh = zzmsVar.zzh(zzmsVar.zzb);
        zzmsVarZzh.zzq = zzmsVarZzh.zzs;
        zzmsVarZzh.zzr = 0L;
        zzms zzmsVarZzam = zzam(zzmsVarZzh, 1);
        if (zzjkVar != null) {
            zzmsVarZzam = zzmsVarZzam.zzf(zzjkVar);
        }
        this.zzG++;
        this.zzm.zzh();
        zzaj(zzmsVarZzam, 0, false, 5, -9223372036854775807L, -1, false);
    }

    private final int zzag(zzms zzmsVar) {
        zzbf zzbfVar = zzmsVar.zza;
        return zzbfVar.zzg() ? this.zzab : zzbfVar.zzo(zzmsVar.zzb.zza, this.zzp).zzc;
    }

    private final long zzah(zzms zzmsVar) {
        zzxk zzxkVar = zzmsVar.zzb;
        if (!zzxkVar.zzb()) {
            return zzfl.zzr(zzai(zzmsVar));
        }
        zzbf zzbfVar = zzmsVar.zza;
        zzbfVar.zzo(zzxkVar.zza, this.zzp);
        long j3 = zzmsVar.zzc;
        if (j3 != -9223372036854775807L) {
            return zzfl.zzr(0L) + zzfl.zzr(j3);
        }
        long j4 = zzbfVar.zzb(zzag(zzmsVar), this.zza, 0L).zzl;
        return zzfl.zzr(0L);
    }

    private final long zzai(zzms zzmsVar) {
        zzbf zzbfVar = zzmsVar.zza;
        if (zzbfVar.zzg()) {
            return zzfl.zzs(this.zzac);
        }
        long j3 = zzmsVar.zzs;
        zzxk zzxkVar = zzmsVar.zzb;
        if (zzxkVar.zzb()) {
            return j3;
        }
        zzao(zzbfVar, zzxkVar, j3);
        return j3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x036d  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0404  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0406  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0421  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0454  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x046c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0470  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0476 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x047a  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0480 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0487  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0491 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0495  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x049d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x04a4  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x04b5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:212:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x04c3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:217:0x04c9  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x04db  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0255  */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v19 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v6, types: [com.google.android.gms.internal.ads.zzbf] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.google.android.gms.internal.ads.zzbf] */
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzaj(final com.google.android.gms.internal.ads.zzms r33, final int r34, boolean r35, int r36, long r37, int r39, boolean r40) {
        /*
            Method dump skipped, instruction units count: 1261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlh.zzaj(com.google.android.gms.internal.ads.zzms, int, boolean, int, long, int, boolean):void");
    }

    private static long zzak(zzms zzmsVar) {
        zzbe zzbeVar = new zzbe();
        zzbd zzbdVar = new zzbd();
        zzbf zzbfVar = zzmsVar.zza;
        zzbfVar.zzo(zzmsVar.zzb.zza, zzbdVar);
        long j3 = zzmsVar.zzc;
        if (j3 != -9223372036854775807L) {
            return j3;
        }
        long j4 = zzbfVar.zzb(zzbdVar.zzc, zzbeVar, 0L).zzl;
        return 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.google.android.gms.internal.ads.zzms zzal(com.google.android.gms.internal.ads.zzms r23, com.google.android.gms.internal.ads.zzbf r24, android.util.Pair r25) {
        /*
            Method dump skipped, instruction units count: 360
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlh.zzal(com.google.android.gms.internal.ads.zzms, com.google.android.gms.internal.ads.zzbf, android.util.Pair):com.google.android.gms.internal.ads.zzms");
    }

    private static zzms zzam(zzms zzmsVar, int i3) {
        zzms zzmsVarZze = zzmsVar.zze(i3);
        return (i3 == 1 || i3 == 4) ? zzmsVarZze.zzg(false) : zzmsVarZze;
    }

    private final Pair zzan(zzbf zzbfVar, int i3, long j3) {
        if (zzbfVar.zzg()) {
            this.zzab = i3;
            if (j3 == -9223372036854775807L) {
                j3 = 0;
            }
            this.zzac = j3;
            return null;
        }
        if (i3 == -1 || i3 >= zzbfVar.zza()) {
            i3 = zzbfVar.zzk(false);
            long j4 = zzbfVar.zzb(i3, this.zza, 0L).zzl;
            j3 = zzfl.zzr(0L);
        }
        return zzbfVar.zzm(this.zza, this.zzp, i3, zzfl.zzs(j3));
    }

    private final long zzao(zzbf zzbfVar, zzxk zzxkVar, long j3) {
        zzbfVar.zzo(zzxkVar.zza, this.zzp);
        return j3;
    }

    private final zzmw zzap(zzmv zzmvVar) {
        int iZzag = zzag(this.zzaa);
        zzbf zzbfVar = this.zzaa.zza;
        if (iZzag == -1) {
            iZzag = 0;
        }
        zzdo zzdoVar = this.zzv;
        zzlu zzluVar = this.zzm;
        return new zzmw(zzluVar, zzmvVar, zzbfVar, iZzag, zzdoVar, zzluVar.zzn());
    }

    private final void zzaq(Object obj) {
        Object obj2 = this.zzO;
        boolean z2 = false;
        if (obj2 != null && obj2 != obj) {
            z2 = true;
        }
        boolean zZzl = this.zzm.zzl(obj, z2 ? this.zzA : -9223372036854775807L);
        if (z2) {
            Object obj3 = this.zzO;
            Surface surface = this.zzP;
            if (obj3 == surface) {
                surface.release();
                this.zzP = null;
            }
        }
        this.zzO = obj;
        if (zZzl) {
            return;
        }
        zzP(zzjk.zzc(new zzlv(3), 1003));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzar, reason: merged with bridge method [inline-methods] */
    public final void zzS(final int i3, final int i4) {
        if (i3 == this.zzR.zza() && i4 == this.zzR.zzb()) {
            return;
        }
        this.zzR = new zzeu(i3, i4);
        zzef zzefVar = this.zzn;
        zzefVar.zze(24, new zzea() { // from class: com.google.android.gms.internal.ads.zzkr
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
                int i5 = zzlh.zzd;
                ((zzaz) obj).zzu(i3, i4);
            }
        });
        zzefVar.zzf();
        zzau(2, 14, new zzeu(i3, i4));
    }

    private final void zzas() {
        int iZzh = zzh();
        if (iZzh != 2 && iZzh != 3) {
            this.zzy.zzb(false);
            this.zzz.zza(false);
        } else {
            zzat();
            boolean z2 = this.zzaa.zzp;
            this.zzy.zzb(zzk());
            this.zzz.zza(zzk());
        }
    }

    private final void zzat() {
        this.zze.zzd();
        Looper looper = this.zzt;
        if (Thread.currentThread() != looper.getThread()) {
            Object[] objArr = {Thread.currentThread().getName(), looper.getThread().getName()};
            String str = zzfl.zza;
            String str2 = String.format(Locale.US, "Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://developer.android.com/guide/topics/media/issues/player-accessed-on-wrong-thread", objArr);
            if (this.zzV) {
                throw new IllegalStateException(str2);
            }
            zzeg.zzd("ExoPlayerImpl", str2, this.zzW ? null : new IllegalStateException());
            this.zzW = true;
        }
    }

    private final void zzau(int i3, int i4, Object obj) {
        zzna[] zznaVarArr = this.zzh;
        int length = zznaVarArr.length;
        for (int i5 = 0; i5 < 2; i5++) {
            zzna zznaVar = zznaVarArr[i5];
            if (i3 == -1 || zznaVar.zza() == i3) {
                zzmw zzmwVarZzap = zzap(zznaVar);
                zzmwVarZzap.zzb(i4);
                zzmwVarZzap.zzd(obj);
                zzmwVarZzap.zzg();
            }
        }
        zzna[] zznaVarArr2 = this.zzi;
        int length2 = zznaVarArr2.length;
        for (int i6 = 0; i6 < 2; i6++) {
            zzna zznaVar2 = zznaVarArr2[i6];
            if (zznaVar2 != null && (i3 == -1 || zznaVar2.zza() == i3)) {
                zzmw zzmwVarZzap2 = zzap(zznaVar2);
                zzmwVarZzap2.zzb(i4);
                zzmwVarZzap2.zzd(obj);
                zzmwVarZzap2.zzg();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final long zzA() {
        zzat();
        return zzah(this.zzaa);
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final void zzB(float f3) {
        zzat();
        String str = zzfl.zza;
        final float fMax = Math.max(0.0f, Math.min(f3, 1.0f));
        if (this.zzT == fMax) {
            return;
        }
        this.zzT = fMax;
        this.zzm.zzj(fMax);
        zzef zzefVar = this.zzn;
        zzefVar.zze(22, new zzea() { // from class: com.google.android.gms.internal.ads.zzkw
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
                int i3 = zzlh.zzd;
                ((zzaz) obj).zzr(fMax);
            }
        });
        zzefVar.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final void zzC(Surface surface) {
        zzat();
        zzaq(surface);
        int i3 = surface == null ? 0 : -1;
        zzS(i3, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzjv
    public final void zzD(zznp zznpVar) {
        this.zzs.zzv(zznpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzjv
    public final void zzE(zznp zznpVar) {
        zzat();
        this.zzs.zzw(zznpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzjv
    public final int zzF() {
        zzat();
        int length = this.zzh.length;
        return 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0097  */
    @Override // com.google.android.gms.internal.ads.zzjv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzG(com.google.android.gms.internal.ads.zzxm r14) {
        /*
            Method dump skipped, instruction units count: 221
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlh.zzG(com.google.android.gms.internal.ads.zzxm):void");
    }

    @Override // com.google.android.gms.internal.ads.zzjv
    public final void zzH() {
        String hexString = Integer.toHexString(System.identityHashCode(this));
        String str = zzfl.zza;
        String strZza = zzal.zza();
        int length = String.valueOf(hexString).length();
        StringBuilder sb = new StringBuilder(length + 39 + String.valueOf(str).length() + 3 + String.valueOf(strZza).length() + 1);
        sb.append("Release ");
        sb.append(hexString);
        sb.append(" [AndroidXMedia3/1.10.0-rc02] [");
        sb.append(str);
        sb.append("] [");
        sb.append(strZza);
        sb.append("]");
        zzeg.zzb("ExoPlayerImpl", sb.toString());
        zzat();
        this.zzy.zzb(false);
        this.zzz.zza(false);
        zzlg zzlgVar = this.zzD;
        if (zzlgVar != null && Build.VERSION.SDK_INT >= 34) {
            zzlgVar.zza();
        }
        this.zzC.zza();
        if (!this.zzm.zzm()) {
            zzef zzefVar = this.zzn;
            zzefVar.zze(10, zzkv.zza);
            zzefVar.zzf();
        }
        this.zzn.zzg();
        this.zzk.zzl(null);
        zzabq zzabqVar = this.zzu;
        zznm zznmVar = this.zzs;
        zzabqVar.zzg(zznmVar);
        zzms zzmsVar = this.zzaa;
        boolean z2 = zzmsVar.zzp;
        zzms zzmsVarZzam = zzam(zzmsVar, 1);
        this.zzaa = zzmsVarZzam;
        zzms zzmsVarZzh = zzmsVarZzam.zzh(zzmsVarZzam.zzb);
        this.zzaa = zzmsVarZzh;
        zzmsVarZzh.zzq = zzmsVarZzh.zzs;
        this.zzaa.zzr = 0L;
        zznmVar.zzy();
        Surface surface = this.zzP;
        if (surface != null) {
            surface.release();
            this.zzP = null;
        }
        int i3 = zzcz.zza;
        this.zzY = true;
    }

    public final zzjk zzI() {
        zzat();
        return this.zzaa.zzf;
    }

    final /* synthetic */ void zzJ(zzaz zzazVar, zzs zzsVar) {
        zzazVar.zza(this.zzg, new zzay(zzsVar));
    }

    final /* synthetic */ void zzK(final zzlr zzlrVar) {
        this.zzk.zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzkt
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzO(zzlrVar);
            }
        });
    }

    final /* synthetic */ void zzL(int i3, final int i4) {
        zzat();
        Integer numValueOf = Integer.valueOf(i4);
        zzau(1, 10, numValueOf);
        zzau(2, 10, numValueOf);
        zzea zzeaVar = new zzea() { // from class: com.google.android.gms.internal.ads.zzks
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
                int i5 = zzlh.zzd;
                ((zzaz) obj).zzq(i4);
            }
        };
        zzef zzefVar = this.zzn;
        zzefVar.zze(21, zzeaVar);
        zzefVar.zzf();
    }

    final /* synthetic */ void zzM() {
        String str = zzfl.zza;
        int iGenerateAudioSessionId = zzcj.zza(this.zzf).generateAudioSessionId();
        if (iGenerateAudioSessionId == -1) {
            iGenerateAudioSessionId = 0;
        }
        zzdm zzdmVar = this.zzB;
        if (((Integer) zzdmVar.zza()).intValue() != iGenerateAudioSessionId) {
            Integer numValueOf = Integer.valueOf(iGenerateAudioSessionId);
            zzdmVar.zzc(numValueOf);
            zzau(1, 10, numValueOf);
            zzau(2, 10, numValueOf);
        }
    }

    final /* synthetic */ void zzN(zzaz zzazVar) {
        zzazVar.zzg(this.zzM);
    }

    final /* synthetic */ void zzO(zzlr zzlrVar) {
        int i3;
        long j3;
        boolean z2;
        int i4 = this.zzG - zzlrVar.zzb;
        this.zzG = i4;
        boolean z3 = true;
        if (zzlrVar.zzc) {
            this.zzH = zzlrVar.zzd;
            this.zzI = true;
        }
        if (i4 == 0) {
            zzbf zzbfVar = zzlrVar.zza.zza;
            int iZzs = -1;
            if (!this.zzaa.zza.zzg() && zzbfVar.zzg()) {
                this.zzab = -1;
                this.zzac = 0L;
            }
            if (!zzbfVar.zzg()) {
                List listZzw = ((zzmy) zzbfVar).zzw();
                int size = listZzw.size();
                List list = this.zzq;
                zzgtj.zzi(size == list.size());
                for (int i5 = 0; i5 < listZzw.size(); i5++) {
                    ((zzld) list.get(i5)).zzc((zzbf) listZzw.get(i5));
                }
            }
            long j4 = -9223372036854775807L;
            if (this.zzI) {
                boolean z4 = zzlrVar.zza.zza.zzg() && this.zzaa.zza.zzg();
                boolean zEquals = zzlrVar.zza.zzb.equals(this.zzaa.zzb);
                long j5 = zzlrVar.zza.zzd;
                long j6 = this.zzaa.zzs;
                if (z4 || (zEquals && j5 == j6)) {
                    z3 = false;
                }
                if (z3) {
                    iZzs = zzs();
                    if (zzbfVar.zzg() || zzlrVar.zza.zzb.zzb()) {
                        j4 = zzlrVar.zza.zzd;
                    } else {
                        zzms zzmsVar = zzlrVar.zza;
                        zzxk zzxkVar = zzmsVar.zzb;
                        long j7 = zzmsVar.zzd;
                        zzao(zzbfVar, zzxkVar, j7);
                        j4 = j7;
                    }
                }
                z2 = z3;
                long j8 = j4;
                i3 = iZzs;
                j3 = j8;
            } else {
                i3 = -1;
                j3 = -9223372036854775807L;
                z2 = false;
            }
            this.zzI = false;
            zzaj(zzlrVar.zza, 1, z2, this.zzH, j3, i3, false);
        }
    }

    final /* synthetic */ void zzQ(SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        zzaq(surface);
        this.zzP = surface;
    }

    final /* synthetic */ void zzR(Object obj) {
        zzaq(null);
    }

    final /* synthetic */ void zzT(int i3, int i4, Object obj) {
        zzau(1, 19, obj);
    }

    final /* synthetic */ zzef zzU() {
        return this.zzn;
    }

    final /* synthetic */ zznm zzV() {
        return this.zzs;
    }

    final /* synthetic */ Looper zzW() {
        return this.zzt;
    }

    final /* synthetic */ zzdo zzX() {
        return this.zzv;
    }

    final /* synthetic */ zzdm zzY() {
        return this.zzB;
    }

    final /* synthetic */ zzjx zzZ() {
        return this.zzE;
    }

    final /* synthetic */ zzjx zzaa() {
        return this.zzF;
    }

    final /* synthetic */ Object zzab() {
        return this.zzO;
    }

    final /* synthetic */ boolean zzac() {
        return this.zzU;
    }

    final /* synthetic */ void zzad(boolean z2) {
        this.zzU = z2;
    }

    final /* synthetic */ boolean zzae() {
        return this.zzY;
    }

    @Override // com.google.android.gms.internal.ads.zzf
    protected final void zzc(int i3, long j3, int i4, boolean z2) {
        zzat();
        if (i3 == -1) {
            return;
        }
        zzgtj.zza(i3 >= 0);
        zzbf zzbfVar = this.zzaa.zza;
        if (zzbfVar.zzg() || i3 < zzbfVar.zza()) {
            this.zzs.zzA();
            this.zzG++;
            if (zzx()) {
                zzeg.zzc("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                zzlr zzlrVar = new zzlr(this.zzaa);
                zzlrVar.zza(1);
                this.zzl.zza(zzlrVar);
                return;
            }
            zzms zzmsVarZzam = this.zzaa;
            int i5 = zzmsVarZzam.zze;
            if (i5 == 3 || (i5 == 4 && !zzbfVar.zzg())) {
                zzmsVarZzam = zzam(this.zzaa, 2);
            }
            int iZzs = zzs();
            zzms zzmsVarZzal = zzal(zzmsVarZzam, zzbfVar, zzan(zzbfVar, i3, j3));
            this.zzm.zzf(zzbfVar, i3, zzfl.zzs(j3));
            zzaj(zzmsVarZzal, 0, true, 1, zzai(zzmsVarZzal), iZzs, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final Looper zzd() {
        return this.zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final void zze(zzaz zzazVar) {
        zzazVar.getClass();
        this.zzn.zzc(zzazVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final void zzf(zzaz zzazVar) {
        zzat();
        zzazVar.getClass();
        this.zzn.zzd(zzazVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final void zzg() {
        zzat();
        zzms zzmsVar = this.zzaa;
        if (zzmsVar.zze != 1) {
            return;
        }
        zzms zzmsVarZzf = zzmsVar.zzf(null);
        zzms zzmsVarZzam = zzam(zzmsVarZzf, true != zzmsVarZzf.zza.zzg() ? 2 : 4);
        this.zzG++;
        this.zzm.zzd();
        zzaj(zzmsVarZzam, 1, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final int zzh() {
        zzat();
        return this.zzaa.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final int zzi() {
        zzat();
        return this.zzaa.zzn;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final void zzj(boolean z2) {
        zzat();
        zzms zzmsVar = this.zzaa;
        int i3 = zzmsVar.zzn;
        int i4 = 0;
        if (i3 == 1) {
            if (z2) {
                i3 = 1;
            } else {
                i3 = 1;
                i4 = 1;
            }
        }
        if (zzmsVar.zzl == z2 && i3 == i4 && zzmsVar.zzm == 1) {
            return;
        }
        this.zzG++;
        zzms zzmsVarZzi = zzmsVar.zzi(z2, 1, i4);
        this.zzm.zze(z2, 1, i4);
        zzaj(zzmsVarZzi, 0, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final boolean zzk() {
        zzat();
        return this.zzaa.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final int zzl() {
        zzat();
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final boolean zzm() {
        zzat();
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final zzav zzn() {
        zzat();
        return this.zzaa.zzo;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final void zzo() {
        zzat();
        zzP(null);
        new zzcz(zzgwm.zzi(), this.zzaa.zzs);
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final zzbn zzp() {
        zzat();
        return this.zzaa.zzi.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final zzbf zzq() {
        zzat();
        return this.zzaa.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final int zzr() {
        zzat();
        if (!this.zzaa.zza.zzg()) {
            zzms zzmsVar = this.zzaa;
            return zzmsVar.zza.zze(zzmsVar.zzb.zza);
        }
        int i3 = this.zzab;
        if (i3 == -1) {
            return 0;
        }
        return i3;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final int zzs() {
        zzat();
        int iZzag = zzag(this.zzaa);
        if (iZzag == -1) {
            return 0;
        }
        return iZzag;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final long zzt() {
        zzat();
        if (!zzx()) {
            zzbf zzbfVarZzq = zzq();
            if (zzbfVarZzq.zzg()) {
                return -9223372036854775807L;
            }
            return zzfl.zzr(zzbfVarZzq.zzb(zzs(), this.zza, 0L).zzm);
        }
        zzms zzmsVar = this.zzaa;
        zzxk zzxkVar = zzmsVar.zzb;
        zzbf zzbfVar = zzmsVar.zza;
        Object obj = zzxkVar.zza;
        zzbd zzbdVar = this.zzp;
        zzbfVar.zzo(obj, zzbdVar);
        return zzfl.zzr(zzbdVar.zzh(zzxkVar.zzb, zzxkVar.zzc));
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final long zzu() {
        zzat();
        return zzfl.zzr(zzai(this.zzaa));
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final long zzv() {
        zzat();
        if (zzx()) {
            zzms zzmsVar = this.zzaa;
            return zzmsVar.zzk.equals(zzmsVar.zzb) ? zzfl.zzr(this.zzaa.zzq) : zzt();
        }
        zzat();
        if (this.zzaa.zza.zzg()) {
            return this.zzac;
        }
        zzms zzmsVar2 = this.zzaa;
        long j3 = 0;
        if (zzmsVar2.zzk.zzd != zzmsVar2.zzb.zzd) {
            return zzfl.zzr(zzmsVar2.zza.zzb(zzs(), this.zza, 0L).zzm);
        }
        long j4 = zzmsVar2.zzq;
        if (this.zzaa.zzk.zzb()) {
            zzms zzmsVar3 = this.zzaa;
            zzmsVar3.zza.zzo(zzmsVar3.zzk.zza, this.zzp).zzc(this.zzaa.zzk.zzb);
        } else {
            j3 = j4;
        }
        zzms zzmsVar4 = this.zzaa;
        zzao(zzmsVar4.zza, zzmsVar4.zzk, j3);
        return zzfl.zzr(j3);
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final long zzw() {
        zzat();
        return zzfl.zzr(this.zzaa.zzr);
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final boolean zzx() {
        zzat();
        return this.zzaa.zzb.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final int zzy() {
        zzat();
        if (zzx()) {
            return this.zzaa.zzb.zzb;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final int zzz() {
        zzat();
        if (zzx()) {
            return this.zzaa.zzb.zzc;
        }
        return -1;
    }
}
