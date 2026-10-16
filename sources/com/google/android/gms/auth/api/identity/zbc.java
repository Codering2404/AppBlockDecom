package com.google.android.gms.auth.api.identity;

import android.os.Bundle;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zbc implements Api.ApiOptions.Optional {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f71155a;

    public zbc(String str) {
        this.f71155a = str;
    }

    public final Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString(SDKAnalyticsEvents.PARAMETER_SESSION_ID, this.f71155a);
        return bundle;
    }

    public final String b() {
        return this.f71155a;
    }

    public final boolean equals(Object obj) {
        return obj instanceof zbc;
    }

    public final int hashCode() {
        return Objects.c(zbc.class);
    }
}
