package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzapz {
    private final zzahk zza;
    private final SparseArray zzb = new SparseArray();
    private final SparseArray zzc = new SparseArray();
    private final byte[] zzd;
    private int zze;
    private long zzf;
    private long zzg;
    private boolean zzh;
    private long zzi;
    private long zzj;
    private boolean zzk;
    private boolean zzl;

    public zzapz(zzahk zzahkVar, boolean z2, boolean z3) {
        this.zza = zzahkVar;
        byte[] bArr = new byte[ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD];
        this.zzd = bArr;
        new zzgw(bArr, 0, 0);
        this.zzh = false;
    }

    public final void zza(zzgo zzgoVar) {
        this.zzb.append(zzgoVar.zzd, zzgoVar);
    }

    public final void zzb(zzgn zzgnVar) {
        this.zzc.append(zzgnVar.zza, zzgnVar);
    }

    public final void zzc() {
        this.zzh = false;
    }

    public final void zzd(long j3, int i3, long j4, boolean z2) {
        this.zze = i3;
        this.zzg = j4;
        this.zzf = j3;
        this.zzl = z2;
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
    public final boolean zze(long j3, int i3, boolean z2) {
        boolean z3 = false;
        if (this.zze == 9) {
            if (z2 && this.zzh) {
                long j4 = this.zzf;
                int i4 = i3 + ((int) (j3 - j4));
                long j5 = this.zzj;
                if (j5 != -9223372036854775807L) {
                    long j6 = this.zzi;
                    if (j4 != j6) {
                        this.zza.zze(j5, this.zzk ? 1 : 0, (int) (j4 - j6), i4, null);
                    }
                }
            }
            this.zzi = this.zzf;
            this.zzj = this.zzg;
            this.zzk = false;
            this.zzh = true;
        }
        boolean z4 = this.zzl;
        boolean z5 = this.zzk;
        int i5 = this.zze;
        if (i5 == 5 || (z4 && i5 == 1)) {
            z3 = true;
        }
        boolean z6 = z5 | z3;
        this.zzk = z6;
        this.zze = 24;
        return z6;
    }
}
