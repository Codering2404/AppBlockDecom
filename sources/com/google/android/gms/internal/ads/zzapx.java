package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzapx {
    private final zzahk zza;
    private boolean zzb;
    private boolean zzc;
    private boolean zzd;
    private int zze;
    private int zzf;
    private long zzg;
    private long zzh;

    public zzapx(zzahk zzahkVar) {
        this.zza = zzahkVar;
    }

    public final void zza() {
        this.zzb = false;
        this.zzc = false;
        this.zzd = false;
        this.zze = -1;
    }

    public final void zzb(int i3, long j3) {
        boolean z2;
        this.zze = i3;
        this.zzd = false;
        if (i3 == 182) {
            z2 = true;
        } else if (i3 == 179) {
            i3 = 179;
            z2 = true;
        } else {
            z2 = false;
        }
        this.zzb = z2;
        this.zzc = i3 == 182;
        this.zzf = 0;
        this.zzh = j3;
    }

    public final void zzc(byte[] bArr, int i3, int i4) {
        if (this.zzc) {
            int i5 = this.zzf;
            int i6 = (i3 + 1) - i5;
            if (i6 >= i4) {
                this.zzf = i5 + (i4 - i3);
            } else {
                this.zzd = ((bArr[i6] & 192) >> 6) == 0;
                this.zzc = false;
            }
        }
    }

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
    public final void zzd(long j3, int i3, boolean z2) {
        zzgtj.zzi(this.zzh != -9223372036854775807L);
        if (this.zze == 182 && z2 && this.zzb) {
            this.zza.zze(this.zzh, this.zzd ? 1 : 0, (int) (j3 - this.zzg), i3, null);
        }
        if (this.zze != 179) {
            this.zzg = j3;
        }
    }
}
