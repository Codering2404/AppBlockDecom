package com.google.android.libraries.places.internal;

import com.google.common.collect.ImmutableList;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzqy extends zzry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ImmutableList f78492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ImmutableList f78493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private UUID f78494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f78495d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte f78496e;

    zzqy() {
    }

    @Override // com.google.android.libraries.places.internal.zzry
    public final zzry a(ImmutableList immutableList) {
        if (immutableList == null) {
            throw new NullPointerException("Null spansNames");
        }
        this.f78492a = immutableList;
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zzry
    public final zzry b(ImmutableList immutableList) {
        if (immutableList == null) {
            throw new NullPointerException("Null extras");
        }
        this.f78493b = immutableList;
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zzry
    public final zzry c(UUID uuid) {
        if (uuid == null) {
            throw new NullPointerException("Null rootTraceId");
        }
        this.f78494c = uuid;
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zzry
    public final zzry d(long j3) {
        this.f78495d = -1L;
        this.f78496e = (byte) 1;
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zzry
    public final zzrz e() {
        ImmutableList immutableList;
        ImmutableList immutableList2;
        UUID uuid;
        if (this.f78496e == 1 && (immutableList = this.f78492a) != null && (immutableList2 = this.f78493b) != null && (uuid = this.f78494c) != null) {
            return new zzqz(immutableList, immutableList2, uuid, this.f78495d, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f78492a == null) {
            sb.append(" spansNames");
        }
        if (this.f78493b == null) {
            sb.append(" extras");
        }
        if (this.f78494c == null) {
            sb.append(" rootTraceId");
        }
        if (this.f78496e == 0) {
            sb.append(" rootDurationMs");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
