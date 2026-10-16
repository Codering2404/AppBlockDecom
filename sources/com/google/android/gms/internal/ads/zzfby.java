package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfby implements zzfck {
    private final zzhcg zza;
    private final Context zzb;
    private final VersionInfoParcel zzc;
    private final String zzd;

    zzfby(zzhcg zzhcgVar, Context context, VersionInfoParcel versionInfoParcel, String str) {
        this.zza = zzhcgVar;
        this.zzb = context;
        this.zzc = versionInfoParcel;
        this.zzd = str;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        return this.zza.submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzfbx
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 35;
    }

    final /* synthetic */ zzfbz zzc() {
        Context context = this.zzb;
        boolean zG = Wrappers.a(context).g();
        com.google.android.gms.ads.internal.zzt.g();
        boolean zH = com.google.android.gms.ads.internal.util.zzs.h(context);
        String str = this.zzc.f70149a;
        com.google.android.gms.ads.internal.zzt.g();
        boolean zI = com.google.android.gms.ads.internal.util.zzs.i();
        com.google.android.gms.ads.internal.zzt.g();
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return new zzfbz(zG, zH, str, zI, applicationInfo == null ? 0 : applicationInfo.targetSdkVersion, DynamiteModule.c(context, ModuleDescriptor.MODULE_ID), DynamiteModule.a(context, ModuleDescriptor.MODULE_ID), this.zzd);
    }
}
