package com.google.android.libraries.places.internal;

import com.appsflyer.AppsFlyerProperties;
import com.google.common.base.Preconditions;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class zzcdw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbit f77691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbis f77692b;

    protected zzcdw(zzbit zzbitVar, zzbis zzbisVar) {
        this.f77691a = (zzbit) Preconditions.u(zzbitVar, AppsFlyerProperties.CHANNEL);
        this.f77692b = (zzbis) Preconditions.u(zzbisVar, "callOptions");
    }

    protected abstract zzcdw a(zzbit zzbitVar, zzbis zzbisVar);

    public final zzbit b() {
        return this.f77691a;
    }

    public final zzbis c() {
        return this.f77692b;
    }

    public final zzcdw d(zzbiy... zzbiyVarArr) {
        return a(zzbja.a(this.f77691a, Arrays.asList(zzbiyVarArr)), this.f77692b);
    }
}
