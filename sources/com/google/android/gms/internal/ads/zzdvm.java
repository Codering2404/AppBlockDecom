package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdvm extends zzcxt {
    private final Context zzc;
    private final WeakReference zzd;
    private final zzdno zze;
    private final zzdkc zzf;
    private final zzdde zzg;
    private final zzdel zzh;
    private final zzcyo zzi;
    private final zzccf zzj;
    private final zzfxq zzk;
    private final zzfks zzl;
    private final zzdzl zzm;
    private boolean zzn;

    zzdvm(zzcxs zzcxsVar, Context context, zzcku zzckuVar, zzdno zzdnoVar, zzdkc zzdkcVar, zzdde zzddeVar, zzdel zzdelVar, zzcyo zzcyoVar, zzfkf zzfkfVar, zzfxq zzfxqVar, zzfks zzfksVar, zzdzl zzdzlVar) {
        super(zzcxsVar);
        this.zzn = false;
        this.zzc = context;
        this.zze = zzdnoVar;
        this.zzd = new WeakReference(zzckuVar);
        this.zzf = zzdkcVar;
        this.zzg = zzddeVar;
        this.zzh = zzdelVar;
        this.zzi = zzcyoVar;
        this.zzk = zzfxqVar;
        zzccb zzccbVar = zzfkfVar.zzl;
        this.zzj = new zzccz(zzccbVar != null ? zzccbVar.zza : "", zzccbVar != null ? zzccbVar.zzb : 1);
        this.zzl = zzfksVar;
        this.zzm = zzdzlVar;
    }

    public final void finalize() throws Throwable {
        try {
            final zzcku zzckuVar = (zzcku) this.zzd.get();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhG)).booleanValue()) {
                if (!this.zzn && zzckuVar != null) {
                    zzcfr.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdvl
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
    public final boolean zza(boolean z2, Activity activity) {
        com.google.android.gms.ads.internal.zzt.g();
        zzdno zzdnoVar = this.zze;
        if (!com.google.android.gms.ads.internal.util.zzs.r(zzdnoVar.zzb())) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzpc)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.g();
                com.google.android.gms.ads.internal.util.zzs.q(this.zzc, this.zzb, this.zzm);
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzbm)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.g();
                if (com.google.android.gms.ads.internal.util.zzs.j(this.zzc)) {
                    int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                    com.google.android.gms.ads.internal.util.client.zzo.f("Rewarded ads that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit https://goo.gle/admob-interstitial-policies");
                    this.zzg.zze();
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzbn)).booleanValue()) {
                        this.zzk.zza(this.zza.zzb.zzb.zzb);
                    }
                    return false;
                }
            }
        }
        if (this.zzn) {
            int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("The rewarded ad have been showed.");
            this.zzg.zzc(zzfma.zzd(10, null, null));
            return false;
        }
        this.zzn = true;
        zzdkc zzdkcVar = this.zzf;
        zzdkcVar.zza();
        Context context = activity;
        if (activity == null) {
            context = this.zzc;
        }
        try {
            zzdnoVar.zza(z2, context, this.zzg);
            zzdkcVar.zzb();
            return true;
        } catch (zzdnn e3) {
            this.zzg.zzd(e3);
            return false;
        }
    }

    public final boolean zzb() {
        return this.zzn;
    }

    public final zzccf zzc() {
        return this.zzj;
    }

    public final boolean zze() {
        return this.zzi.zzl();
    }

    public final boolean zzf() {
        zzcku zzckuVar = (zzcku) this.zzd.get();
        return (zzckuVar == null || zzckuVar.zzaB()) ? false : true;
    }

    public final Bundle zzg() {
        return this.zzh.zzb();
    }

    public final zzfks zzh() {
        return this.zzl;
    }
}
