package com.google.android.libraries.places.internal;

import com.google.common.collect.ImmutableList;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzqz extends zzrz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImmutableList f78497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ImmutableList f78498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final UUID f78499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f78500d;

    /* synthetic */ zzqz(ImmutableList immutableList, ImmutableList immutableList2, UUID uuid, long j3, byte[] bArr) {
        this.f78497a = immutableList;
        this.f78498b = immutableList2;
        this.f78499c = uuid;
        this.f78500d = j3;
    }

    @Override // com.google.android.libraries.places.internal.zzrz
    public final ImmutableList a() {
        return this.f78497a;
    }

    @Override // com.google.android.libraries.places.internal.zzrz
    public final ImmutableList b() {
        return this.f78498b;
    }

    @Override // com.google.android.libraries.places.internal.zzrz
    public final UUID c() {
        return this.f78499c;
    }

    @Override // com.google.android.libraries.places.internal.zzrz
    public final long d() {
        return this.f78500d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzrz) {
            zzrz zzrzVar = (zzrz) obj;
            if (this.f78497a.equals(zzrzVar.a()) && this.f78498b.equals(zzrzVar.b()) && this.f78499c.equals(zzrzVar.c()) && this.f78500d == zzrzVar.d()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = ((((this.f78497a.hashCode() ^ 1000003) * 1000003) ^ this.f78498b.hashCode()) * 1000003) ^ this.f78499c.hashCode();
        long j3 = this.f78500d;
        return (iHashCode * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)));
    }
}
