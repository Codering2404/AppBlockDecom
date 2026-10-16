package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaqb {
    private final zzahk zza;
    private long zzb;
    private boolean zzc;
    private int zzd;
    private long zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private long zzk;
    private long zzl;
    private boolean zzm;

    public zzaqb(zzahk zzahkVar) {
        this.zza = zzahkVar;
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
    private final void zze(int i3) {
        long j3 = this.zzl;
        if (j3 != -9223372036854775807L) {
            long j4 = this.zzb;
            long j5 = this.zzk;
            if (j4 == j5) {
                return;
            }
            int i4 = (int) (j4 - j5);
            this.zza.zze(j3, this.zzm ? 1 : 0, i4, i3, null);
        }
    }

    public final void zza() {
        this.zzf = false;
        this.zzg = false;
        this.zzh = false;
        this.zzi = false;
        this.zzj = false;
    }

    public final void zzb(long j3, int i3, int i4, long j4, boolean z2) {
        this.zzg = false;
        this.zzh = false;
        this.zze = j4;
        this.zzd = 0;
        this.zzb = j3;
        if (i4 >= 32 && i4 != 40) {
            if (this.zzi && !this.zzj) {
                if (z2) {
                    zze(i3);
                }
                this.zzi = false;
            }
            if (i4 <= 35 || i4 == 39) {
                this.zzh = !this.zzj;
                this.zzj = true;
            }
        }
        boolean z3 = i4 >= 16 && i4 <= 21;
        this.zzc = z3;
        this.zzf = z3 || i4 <= 9;
    }

    public final void zzc(byte[] bArr, int i3, int i4) {
        if (this.zzf) {
            int i5 = this.zzd;
            int i6 = (i3 + 2) - i5;
            if (i6 >= i4) {
                this.zzd = i5 + (i4 - i3);
            } else {
                this.zzg = (bArr[i6] & 128) != 0;
                this.zzf = false;
            }
        }
    }

    public final void zzd(long j3, int i3, boolean z2) {
        if (this.zzj && this.zzg) {
            this.zzm = this.zzc;
            this.zzj = false;
        } else if (this.zzh || this.zzg) {
            if (z2 && this.zzi) {
                zze(i3 + ((int) (j3 - this.zzb)));
            }
            this.zzk = this.zzb;
            this.zzl = this.zze;
            this.zzm = this.zzc;
            this.zzi = true;
        }
    }
}
