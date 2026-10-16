package com.google.android.libraries.places.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbvz {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final zzbir f77050g = zzbir.a("io.grpc.internal.ManagedChannelServiceConfig.MethodInfo");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Long f77051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Boolean f77052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Integer f77053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Integer f77054d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final zzbzg f77055e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final zzbta f77056f;

    zzbvz(Map map, boolean z2, int i3, int i4) {
        long j3;
        zzbzg zzbzgVar;
        zzbta zzbtaVar;
        this.f77051a = zzbud.h(map, "timeout");
        this.f77052b = zzbud.i(map, "waitForReady");
        Integer numF = zzbud.f(map, "maxResponseMessageBytes");
        this.f77053c = numF;
        if (numF != null) {
            Preconditions.m(numF.intValue() >= 0, "maxInboundMessageSize %s exceeds bounds", numF);
        }
        Integer numF2 = zzbud.f(map, "maxRequestMessageBytes");
        this.f77054d = numF2;
        if (numF2 != null) {
            Preconditions.m(numF2.intValue() >= 0, "maxOutboundMessageSize %s exceeds bounds", numF2);
        }
        Map mapD = z2 ? zzbud.d(map, "retryPolicy") : null;
        if (mapD == null) {
            j3 = 0;
            zzbzgVar = null;
        } else {
            int iIntValue = ((Integer) Preconditions.u(zzbud.f(mapD, "maxAttempts"), "maxAttempts cannot be empty")).intValue();
            Preconditions.h(iIntValue >= 2, "maxAttempts must be greater than 1: %s", iIntValue);
            int iMin = Math.min(iIntValue, 5);
            long jLongValue = ((Long) Preconditions.u(zzbud.h(mapD, "initialBackoff"), "initialBackoff cannot be empty")).longValue();
            Preconditions.k(jLongValue > 0, "initialBackoffNanos must be greater than 0: %s", jLongValue);
            long jLongValue2 = ((Long) Preconditions.u(zzbud.h(mapD, "maxBackoff"), "maxBackoff cannot be empty")).longValue();
            Preconditions.k(jLongValue2 > 0, "maxBackoff must be greater than 0: %s", jLongValue2);
            Double d3 = (Double) Preconditions.u(zzbud.e(mapD, "backoffMultiplier"), "backoffMultiplier cannot be empty");
            double dDoubleValue = d3.doubleValue();
            j3 = 0;
            Preconditions.m(dDoubleValue > 0.0d, "backoffMultiplier must be greater than 0: %s", d3);
            Long lH = zzbud.h(mapD, "perAttemptRecvTimeout");
            Preconditions.m(lH == null || lH.longValue() >= 0, "perAttemptRecvTimeout cannot be negative: %s", lH);
            Set setA = zzbzt.a(mapD);
            Preconditions.e((lH == null && setA.isEmpty()) ? false : true, "retryableStatusCodes cannot be empty without perAttemptRecvTimeout");
            zzbzgVar = new zzbzg(iMin, jLongValue, jLongValue2, dDoubleValue, lH, setA);
        }
        this.f77055e = zzbzgVar;
        Map mapD2 = z2 ? zzbud.d(map, "hedgingPolicy") : null;
        if (mapD2 == null) {
            zzbtaVar = null;
        } else {
            int iIntValue2 = ((Integer) Preconditions.u(zzbud.f(mapD2, "maxAttempts"), "maxAttempts cannot be empty")).intValue();
            Preconditions.h(iIntValue2 >= 2, "maxAttempts must be greater than 1: %s", iIntValue2);
            int iMin2 = Math.min(iIntValue2, 5);
            long jLongValue3 = ((Long) Preconditions.u(zzbud.h(mapD2, "hedgingDelay"), "hedgingDelay cannot be empty")).longValue();
            Preconditions.k(jLongValue3 >= j3, "hedgingDelay must not be negative: %s", jLongValue3);
            zzbtaVar = new zzbta(iMin2, jLongValue3, zzbzt.b(mapD2));
        }
        this.f77056f = zzbtaVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbvz)) {
            return false;
        }
        zzbvz zzbvzVar = (zzbvz) obj;
        return Objects.a(this.f77051a, zzbvzVar.f77051a) && Objects.a(this.f77052b, zzbvzVar.f77052b) && Objects.a(this.f77053c, zzbvzVar.f77053c) && Objects.a(this.f77054d, zzbvzVar.f77054d) && Objects.a(this.f77055e, zzbvzVar.f77055e) && Objects.a(this.f77056f, zzbvzVar.f77056f);
    }

    public final int hashCode() {
        return Objects.b(this.f77051a, this.f77052b, this.f77053c, this.f77054d, this.f77055e, this.f77056f);
    }

    public final String toString() {
        return MoreObjects.c(this).d("timeoutNanos", this.f77051a).d("waitForReady", this.f77052b).d("maxInboundMessageSize", this.f77053c).d("maxOutboundMessageSize", this.f77054d).d("retryPolicy", this.f77055e).d("hedgingPolicy", this.f77056f).toString();
    }
}
