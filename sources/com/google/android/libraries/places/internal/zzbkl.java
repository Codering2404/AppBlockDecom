package com.google.android.libraries.places.internal;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbkl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f76337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zzbkk f76338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f76339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final zzbkz f76340d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final zzbkz f76341e;

    /* synthetic */ zzbkl(String str, zzbkk zzbkkVar, long j3, zzbkz zzbkzVar, zzbkz zzbkzVar2, byte[] bArr) {
        this.f76337a = str;
        this.f76338b = (zzbkk) Preconditions.u(zzbkkVar, SDKConstants.PARAM_DEBUG_MESSAGE_SEVERITY);
        this.f76339c = j3;
        this.f76341e = zzbkzVar2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzbkl) {
            zzbkl zzbklVar = (zzbkl) obj;
            if (Objects.a(this.f76337a, zzbklVar.f76337a) && Objects.a(this.f76338b, zzbklVar.f76338b) && this.f76339c == zzbklVar.f76339c && Objects.a(null, null) && Objects.a(this.f76341e, zzbklVar.f76341e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.b(this.f76337a, this.f76338b, Long.valueOf(this.f76339c), null, this.f76341e);
    }

    public final String toString() {
        return MoreObjects.c(this).d("description", this.f76337a).d(SDKConstants.PARAM_DEBUG_MESSAGE_SEVERITY, this.f76338b).c("timestampNanos", this.f76339c).d("channelRef", null).d("subchannelRef", this.f76341e).toString();
    }
}
