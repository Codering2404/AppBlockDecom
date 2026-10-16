package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.Surface;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzadk implements zzaeu {
    final /* synthetic */ zzadq zza;
    private zzgwm zzb;
    private zzv zzc;
    private long zzd;
    private long zze;
    private int zzf;

    public zzadk(zzadq zzadqVar, Context context, int i3) {
        Objects.requireNonNull(zzadqVar);
        this.zza = zzadqVar;
        zzfl.zzU(context);
        this.zzb = zzgwm.zzi();
        this.zze = -9223372036854775807L;
        zzaer zzaerVar = zzaer.zzb;
    }

    private static final void zzy(zzv zzvVar) {
        zzt zztVarZza = zzvVar.zza();
        zztVarZza.zzE(zzadq.zzC(zzvVar.zzF));
        zztVarZza.zzO();
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zza() {
        zzadq zzadqVar = this.zza;
        if (zzadqVar.zzt()) {
            zzadqVar.zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzb() {
        zzadq zzadqVar = this.zza;
        if (zzadqVar.zzt()) {
            zzadqVar.zzf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final boolean zzd(zzv zzvVar) throws zzaet {
        return this.zza.zzi(zzvVar, 0);
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final boolean zze() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzg(boolean z2) {
        this.zze = -9223372036854775807L;
        this.zza.zzm(z2);
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final boolean zzh(boolean z2) {
        return this.zza.zzj(false);
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzi() {
        zzadq zzadqVar = this.zza;
        zzadqVar.zzA(this.zze);
        if (zzadqVar.zzy() >= zzadqVar.zzz()) {
            zzadqVar.zzk();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final boolean zzj() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final Surface zzk() {
        zzgtj.zzi(false);
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzl(zzadr zzadrVar) {
        this.zza.zzp(zzadrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzm(float f3) {
        this.zza.zzq(f3);
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzn(List list) {
        if (this.zzb.equals(list)) {
            return;
        }
        this.zzb = zzgwm.zzq(list);
        zzv zzvVar = this.zzc;
        if (zzvVar != null) {
            zzy(zzvVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzo(long j3) {
        this.zzd = j3;
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzp(Surface surface, zzeu zzeuVar) {
        this.zza.zzc(surface, zzeuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzq() {
        this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzr(int i3) {
        this.zza.zzr(i3);
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzs(int i3, zzv zzvVar, long j3, int i4, List list) {
        zzgtj.zzi(false);
        this.zzb = zzgwm.zzq(list);
        this.zzc = zzvVar;
        zzadq zzadqVar = this.zza;
        zzadqVar.zzA(-9223372036854775807L);
        zzy(zzvVar);
        long j4 = this.zze;
        long j5 = -4611686018427387904L;
        if (zzadqVar.zzt()) {
            if (j4 != -9223372036854775807L) {
                j5 = j4 + 1;
            }
        } else if (j4 != -9223372036854775807L) {
            return;
        }
        long j6 = j5;
        zzadqVar.zzw().zza(j6, new zzadp(j3 + this.zzd, i4, j6));
    }

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
    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzt() {
        zzadq zzadqVar = this.zza;
        if (zzadqVar.zzw().zzc() == 0) {
            zzadqVar.zzo();
            return;
        }
        zzfh zzfhVar = new zzfh(10);
        boolean z2 = true;
        while (zzadqVar.zzw().zzc() > 0) {
            zzadp zzadpVar = (zzadp) zzadqVar.zzw().zzd();
            zzadpVar.getClass();
            if (z2) {
                int i3 = zzadpVar.zzb;
                if (i3 == 0 || i3 == 1) {
                    zzadpVar = new zzadp(zzadpVar.zza, 0, zzadpVar.zzc);
                } else {
                    zzadqVar.zzo();
                }
            }
            zzfhVar.zza(zzadpVar.zzc, zzadpVar);
            z2 = false;
        }
        zzadqVar.zzx(zzfhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final boolean zzu(long j3, zzaes zzaesVar) {
        int i3;
        zzgtj.zzi(false);
        long j4 = j3 + this.zzd;
        zzadq zzadqVar = this.zza;
        long jZzb = zzadqVar.zzv().zzb(j4);
        if (jZzb == -9223372036854775807L || jZzb >= zzadqVar.zzu() || (i3 = this.zzf) >= 2) {
            if (zzadqVar.zzs()) {
                throw null;
            }
            return false;
        }
        this.zzf = i3 + 1;
        zzaesVar.zzb();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzv(long j3, long j4) throws zzaet {
        this.zza.zzl(j3 + this.zzd, j4);
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzw(boolean z2) {
        zzadq zzadqVar = this.zza;
        if (zzadqVar.zzt()) {
            zzadqVar.zzn(z2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzx() {
        this.zza.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzc(zzaer zzaerVar, Executor executor) {
    }
}
