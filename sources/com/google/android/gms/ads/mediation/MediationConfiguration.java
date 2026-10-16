package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import com.google.android.gms.ads.AdFormat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MediationConfiguration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AdFormat f70486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Bundle f70487b;

    public MediationConfiguration(AdFormat adFormat, Bundle bundle) {
        this.f70486a = adFormat;
        this.f70487b = bundle;
    }

    public AdFormat a() {
        return this.f70486a;
    }

    public Bundle b() {
        return this.f70487b;
    }
}
