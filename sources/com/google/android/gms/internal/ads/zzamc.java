package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzamc implements zzafy {
    public static final /* synthetic */ int zza = 0;
    private zzagb zzA;
    private zzamb[] zzB;
    private long[][] zzC;
    private int zzD;
    private final zzanj zzb;
    private final int zzc;
    private final zzet zzd;
    private final zzet zze;
    private final zzet zzf;
    private final zzet zzg;
    private final ArrayDeque zzh;
    private final zzamg zzi;
    private final List zzj;
    private zzgwm zzk;
    private int zzl;
    private int zzm;
    private long zzn;
    private int zzo;
    private zzet zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private int zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private long zzx;
    private boolean zzy;
    private long zzz;

    static {
        int i3 = zzaly.zza;
    }

    @Deprecated
    public zzamc() {
        this(zzanj.zza, 16);
    }

    static /* synthetic */ long zzh(zzaml zzamlVar, long j3, long j4) {
        int iZzl = zzl(zzamlVar, j3);
        return iZzl == -1 ? j4 : Math.min(zzamlVar.zzc[iZzl], j4);
    }

    private final void zzj() {
        this.zzl = 0;
        this.zzo = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x03ba A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0002 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzk(long r43) throws com.google.android.gms.internal.ads.zzat {
        /*
            Method dump skipped, instruction units count: 987
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamc.zzk(long):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzl(zzaml zzamlVar, long j3) {
        int iZza = zzamlVar.zza(j3);
        return iZza == -1 ? zzamlVar.zzb(j3) : iZza;
    }

    private static int zzm(int i3) {
        return i3 != 1903435808 ? 0 : 1;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final boolean zza(zzafz zzafzVar) throws IOException {
        zzahf zzahfVarZzb = zzamh.zzb(zzafzVar);
        this.zzk = zzahfVarZzb != null ? zzgwm.zzj(zzahfVarZzb) : zzgwm.zzi();
        return zzahfVarZzb == null;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final /* synthetic */ List zzb() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzc(zzagb zzagbVar) {
        if ((this.zzc & 16) == 0) {
            zzagbVar = new zzanm(zzagbVar, this.zzb);
        }
        this.zzA = zzagbVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x034f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:271:0x033b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:300:0x009c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0096  */
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
    public final int zzd(com.google.android.gms.internal.ads.zzafz r34, com.google.android.gms.internal.ads.zzagy r35) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamc.zzd(com.google.android.gms.internal.ads.zzafz, com.google.android.gms.internal.ads.zzagy):int");
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zze(long j3, long j4) {
        this.zzh.clear();
        this.zzo = 0;
        this.zzq = -1;
        this.zzr = 0;
        this.zzs = 0;
        this.zzt = 0;
        this.zzu = false;
        if (j3 == 0) {
            if (this.zzl != 3) {
                zzj();
                return;
            } else {
                this.zzi.zza();
                this.zzj.clear();
                return;
            }
        }
        for (zzamb zzambVar : this.zzB) {
            zzaml zzamlVar = zzambVar.zzb;
            int iZza = zzamlVar.zza(j4);
            if (iZza == -1) {
                iZza = zzamlVar.zzb(j4);
            }
            zzambVar.zze = iZza;
            zzahl zzahlVar = zzambVar.zzd;
            if (zzahlVar != null) {
                zzahlVar.zza();
            }
        }
    }

    public zzamc(zzanj zzanjVar, int i3) {
        this.zzb = zzanjVar;
        this.zzc = i3;
        this.zzk = zzgwm.zzi();
        this.zzl = (i3 & 4) != 0 ? 3 : 0;
        this.zzi = new zzamg();
        this.zzj = new ArrayList();
        this.zzg = new zzet(16);
        this.zzh = new ArrayDeque();
        this.zzd = new zzet(zzgp.zza);
        this.zze = new zzet(6);
        this.zzf = new zzet();
        this.zzq = -1;
        this.zzA = zzagb.zza;
        this.zzB = new zzamb[0];
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzf() {
    }
}
