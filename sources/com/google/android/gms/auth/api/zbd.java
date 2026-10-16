package com.google.android.gms.auth.api;

import android.os.Bundle;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class zbd implements Api.ApiOptions.Optional {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final zbd f71267d = new zbd(new zbc());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f71268a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f71269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f71270c;

    public zbd(zbc zbcVar) {
        this.f71269b = zbcVar.f71265a.booleanValue();
        this.f71270c = zbcVar.f71266b;
    }

    static /* bridge */ /* synthetic */ String b(zbd zbdVar) {
        String str = zbdVar.f71268a;
        return null;
    }

    public final Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("consumer_package", null);
        bundle.putBoolean("force_save_dialog", this.f71269b);
        bundle.putString("log_session_id", this.f71270c);
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zbd)) {
            return false;
        }
        zbd zbdVar = (zbd) obj;
        return Objects.b(null, null) && this.f71269b == zbdVar.f71269b && Objects.b(this.f71270c, zbdVar.f71270c);
    }

    public final int hashCode() {
        return Objects.c(null, Boolean.valueOf(this.f71269b), this.f71270c);
    }
}
