package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdlz extends zzcxt {
    private final Context zzc;
    private final WeakReference zzd;
    private final zzdkc zze;
    private final zzdno zzf;
    private final zzcyo zzg;
    private final zzfxq zzh;
    private final zzdde zzi;
    private final zzcfi zzj;
    private final zzdzl zzk;
    private boolean zzl;

    zzdlz(zzcxs zzcxsVar, Context context, @Nullable zzcku zzckuVar, zzdkc zzdkcVar, zzdno zzdnoVar, zzcyo zzcyoVar, zzfxq zzfxqVar, zzdde zzddeVar, zzcfi zzcfiVar, zzdzl zzdzlVar) {
        super(zzcxsVar);
        this.zzl = false;
        this.zzc = context;
        this.zzd = new WeakReference(zzckuVar);
        this.zze = zzdkcVar;
        this.zzf = zzdnoVar;
        this.zzg = zzcyoVar;
        this.zzh = zzfxqVar;
        this.zzi = zzddeVar;
        this.zzj = zzcfiVar;
        this.zzk = zzdzlVar;
    }

    public final void finalize() throws Throwable {
        try {
            final zzcku zzckuVar = (zzcku) this.zzd.get();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhG)).booleanValue()) {
                if (!this.zzl && zzckuVar != null) {
                    zzcfr.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdly
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            zzckuVar.destroy();
                        }
                    });
                }
            } else if (zzckuVar != null) {
                zzckuVar.destroy();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x007d  */
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
    public final boolean zza(boolean r7, @javax.annotation.Nullable android.app.Activity r8) {
        /*
            Method dump skipped, instruction units count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdlz.zza(boolean, android.app.Activity):boolean");
    }

    public final boolean zzb() {
        return this.zzg.zzl();
    }
}
