package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzdr extends zzeq {
    final /* synthetic */ Context zza;
    final /* synthetic */ Bundle zzb;
    final /* synthetic */ zzfb zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzdr(zzfb zzfbVar, Context context, Bundle bundle) {
        super(zzfbVar, true);
        this.zza = context;
        this.zzb = bundle;
        Objects.requireNonNull(zzfbVar);
        this.zzc = zzfbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void zza() {
        try {
            Context context = this.zza;
            Preconditions.m(context);
            String strA = com.google.android.gms.measurement.internal.zzhu.a(context);
            Preconditions.m(context);
            Resources resources = context.getResources();
            if (TextUtils.isEmpty(strA)) {
                strA = com.google.android.gms.measurement.internal.zzhu.a(context);
            }
            Boolean boolC = com.google.android.gms.measurement.internal.zzhu.c("google_analytics_force_disable_updates", resources, strA);
            zzfb zzfbVar = this.zzc;
            zzfbVar.zzR(zzfbVar.zzc(context, boolC == null || !boolC.booleanValue()));
            if (zzfbVar.zzQ() == null) {
                Log.w(zzfbVar.zzO(), "Failed to connect to measurement client.");
                return;
            }
            int iA = DynamiteModule.a(context, ModuleDescriptor.MODULE_ID);
            ((zzcr) Preconditions.m(zzfbVar.zzQ())).initialize(ObjectWrapper.i5(context), new zzdd(133005L, Math.max(iA, r0), Boolean.TRUE.equals(boolC) || DynamiteModule.c(context, ModuleDescriptor.MODULE_ID) < iA, this.zzb, com.google.android.gms.measurement.internal.zzhu.a(context)), this.zzh);
        } catch (Exception e3) {
            this.zzc.zzN(e3, true, false);
        }
    }
}
