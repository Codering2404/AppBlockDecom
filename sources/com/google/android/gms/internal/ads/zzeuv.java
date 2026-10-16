package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.RoundedCorner;
import android.view.WindowInsets;
import androidx.core.graphics.Insets;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeuv implements zzfck {
    private final zzfck zza;
    private final zzfky zzb;
    private final Context zzc;
    private final zzcfd zzd;

    zzeuv(zzewy zzewyVar, zzfky zzfkyVar, Context context, zzcfd zzcfdVar) {
        this.zza = zzewyVar;
        this.zzb = zzfkyVar;
        this.zzc = context;
        this.zzd = zzcfdVar;
    }

    private static final int zzd(WindowInsets windowInsets, int i3) {
        RoundedCorner roundedCorner = windowInsets.getRoundedCorner(i3);
        if (roundedCorner != null) {
            return roundedCorner.getRadius();
        }
        return 0;
    }

    private static final int zze(int i3, float f3) {
        if (f3 == 0.0f) {
            return 0;
        }
        return (int) Math.ceil(i3 / f3);
    }

    private static final Insets zzf(Insets insets, float f3) {
        return f3 == 0.0f ? Insets.f33963e : Insets.b((int) Math.ceil(insets.f33964a / f3), (int) Math.ceil(insets.f33965b / f3), (int) Math.ceil(insets.f33966c / f3), (int) Math.ceil(insets.f33967d / f3));
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        return zzhbw.zzk(this.zza.zza(), new zzgta() { // from class: com.google.android.gms.internal.ads.zzeuu
            @Override // com.google.android.gms.internal.ads.zzgta
            public final /* synthetic */ Object apply(Object obj) {
                return this.zza.zzc((zzfct) obj);
            }
        }, zzcfr.zzh);
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 7;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r4v1 com.google.android.gms.internal.ads.zzeuw, still in use, count: 4, list:
          (r4v1 com.google.android.gms.internal.ads.zzeuw) from 0x02d5: MOVE (r19v0 com.google.android.gms.internal.ads.zzeuw) = (r4v1 com.google.android.gms.internal.ads.zzeuw) (LINE:726)
          (r4v1 com.google.android.gms.internal.ads.zzeuw) from 0x01a1: MOVE (r19v4 com.google.android.gms.internal.ads.zzeuw) = (r4v1 com.google.android.gms.internal.ads.zzeuw) (LINE:418)
          (r4v1 com.google.android.gms.internal.ads.zzeuw) from 0x01ca: MOVE (r19v5 com.google.android.gms.internal.ads.zzeuw) = (r4v1 com.google.android.gms.internal.ads.zzeuw) (LINE:459)
          (r4v1 com.google.android.gms.internal.ads.zzeuw) from 0x017c: MOVE (r19v7 com.google.android.gms.internal.ads.zzeuw) = (r4v1 com.google.android.gms.internal.ads.zzeuw) (LINE:381)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:91)
        	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:57)
        	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:463)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:97)
        */
    final /* synthetic */ com.google.android.gms.internal.ads.zzeuw zzc(com.google.android.gms.internal.ads.zzfct r22) {
        /*
            Method dump skipped, instruction units count: 958
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeuv.zzc(com.google.android.gms.internal.ads.zzfct):com.google.android.gms.internal.ads.zzeuw");
    }
}
