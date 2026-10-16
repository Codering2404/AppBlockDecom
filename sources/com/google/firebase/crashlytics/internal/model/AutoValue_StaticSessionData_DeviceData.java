package com.google.firebase.crashlytics.internal.model;

import com.google.common.cache.LSNn.vfptEEmYY;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_StaticSessionData_DeviceData extends StaticSessionData.DeviceData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f88982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f88983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f88984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f88985d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f88986e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f88987f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f88988g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f88989h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f88990i;

    AutoValue_StaticSessionData_DeviceData(int i3, String str, int i4, long j3, long j4, boolean z2, int i5, String str2, String str3) {
        this.f88982a = i3;
        if (str == null) {
            throw new NullPointerException("Null model");
        }
        this.f88983b = str;
        this.f88984c = i4;
        this.f88985d = j3;
        this.f88986e = j4;
        this.f88987f = z2;
        this.f88988g = i5;
        if (str2 == null) {
            throw new NullPointerException("Null manufacturer");
        }
        this.f88989h = str2;
        if (str3 == null) {
            throw new NullPointerException("Null modelClass");
        }
        this.f88990i = str3;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public int a() {
        return this.f88982a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public int b() {
        return this.f88984c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public long d() {
        return this.f88986e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public boolean e() {
        return this.f88987f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof StaticSessionData.DeviceData) {
            StaticSessionData.DeviceData deviceData = (StaticSessionData.DeviceData) obj;
            if (this.f88982a == deviceData.a() && this.f88983b.equals(deviceData.g()) && this.f88984c == deviceData.b() && this.f88985d == deviceData.j() && this.f88986e == deviceData.d() && this.f88987f == deviceData.e() && this.f88988g == deviceData.i() && this.f88989h.equals(deviceData.f()) && this.f88990i.equals(deviceData.h())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public String f() {
        return this.f88989h;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public String g() {
        return this.f88983b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public String h() {
        return this.f88990i;
    }

    public int hashCode() {
        int iHashCode = (((((this.f88982a ^ 1000003) * 1000003) ^ this.f88983b.hashCode()) * 1000003) ^ this.f88984c) * 1000003;
        long j3 = this.f88985d;
        int i3 = (iHashCode ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003;
        long j4 = this.f88986e;
        return ((((((((i3 ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003) ^ (this.f88987f ? 1231 : 1237)) * 1000003) ^ this.f88988g) * 1000003) ^ this.f88989h.hashCode()) * 1000003) ^ this.f88990i.hashCode();
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public int i() {
        return this.f88988g;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public long j() {
        return this.f88985d;
    }

    public String toString() {
        return "DeviceData{arch=" + this.f88982a + ", model=" + this.f88983b + ", availableProcessors=" + this.f88984c + ", totalRam=" + this.f88985d + ", diskSpace=" + this.f88986e + vfptEEmYY.qiYRl + this.f88987f + ", state=" + this.f88988g + ", manufacturer=" + this.f88989h + ", modelClass=" + this.f88990i + "}";
    }
}
