package com.google.android.libraries.places.internal;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbkj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f76328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zzbkk f76329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Long f76330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzbkz f76331d;

    public final zzbkj a(String str) {
        this.f76328a = str;
        return this;
    }

    public final zzbkj b(long j3) {
        this.f76330c = Long.valueOf(j3);
        return this;
    }

    public final zzbkj c(zzbkk zzbkkVar) {
        this.f76329b = zzbkkVar;
        return this;
    }

    public final zzbkj d(zzbkz zzbkzVar) {
        this.f76331d = zzbkzVar;
        return this;
    }

    public final zzbkl e() {
        Preconditions.u(this.f76328a, "description");
        Preconditions.u(this.f76329b, SDKConstants.PARAM_DEBUG_MESSAGE_SEVERITY);
        Preconditions.u(this.f76330c, "timestampNanos");
        Preconditions.A(true, "at least one of channelRef and subchannelRef must be null");
        return new zzbkl(this.f76328a, this.f76329b, this.f76330c.longValue(), null, this.f76331d, null);
    }
}
