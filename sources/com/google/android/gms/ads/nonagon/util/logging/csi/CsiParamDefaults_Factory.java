package com.google.android.gms.ads.nonagon.util.logging.csi;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.nonagon.devicetier.DeviceTierManager;
import com.google.android.gms.internal.ads.zzimu;
import com.google.android.gms.internal.ads.zzind;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class CsiParamDefaults_Factory implements zzimu<CsiParamDefaults> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzind f70804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzind f70805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzind f70806c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzind f70807d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzind f70808e;

    private CsiParamDefaults_Factory(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4, zzind zzindVar5) {
        this.f70804a = zzindVar;
        this.f70805b = zzindVar2;
        this.f70806c = zzindVar3;
        this.f70807d = zzindVar4;
        this.f70808e = zzindVar5;
    }

    public static CsiParamDefaults_Factory a(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4, zzind zzindVar5) {
        return new CsiParamDefaults_Factory(zzindVar, zzindVar2, zzindVar3, zzindVar4, zzindVar5);
    }

    public static CsiParamDefaults c(Context context, VersionInfoParcel versionInfoParcel, PackageInfo packageInfo, String str, DeviceTierManager deviceTierManager) {
        return new CsiParamDefaults(context, versionInfoParcel, packageInfo, str, deviceTierManager);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public CsiParamDefaults zzb() {
        return c((Context) this.f70804a.zzb(), (VersionInfoParcel) this.f70805b.zzb(), (PackageInfo) this.f70806c.zzb(), (String) this.f70807d.zzb(), (DeviceTierManager) this.f70808e.zzb());
    }
}
