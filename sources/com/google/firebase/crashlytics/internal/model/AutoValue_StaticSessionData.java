package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.StaticSessionData;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_StaticSessionData extends StaticSessionData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StaticSessionData.AppData f88973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final StaticSessionData.OsData f88974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final StaticSessionData.DeviceData f88975c;

    AutoValue_StaticSessionData(StaticSessionData.AppData appData, StaticSessionData.OsData osData, StaticSessionData.DeviceData deviceData) {
        if (appData == null) {
            throw new NullPointerException("Null appData");
        }
        this.f88973a = appData;
        if (osData == null) {
            throw new NullPointerException("Null osData");
        }
        this.f88974b = osData;
        if (deviceData == null) {
            throw new NullPointerException("Null deviceData");
        }
        this.f88975c = deviceData;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData
    public StaticSessionData.AppData a() {
        return this.f88973a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData
    public StaticSessionData.DeviceData c() {
        return this.f88975c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData
    public StaticSessionData.OsData d() {
        return this.f88974b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof StaticSessionData) {
            StaticSessionData staticSessionData = (StaticSessionData) obj;
            if (this.f88973a.equals(staticSessionData.a()) && this.f88974b.equals(staticSessionData.d()) && this.f88975c.equals(staticSessionData.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f88973a.hashCode() ^ 1000003) * 1000003) ^ this.f88974b.hashCode()) * 1000003) ^ this.f88975c.hashCode();
    }

    public String toString() {
        return "StaticSessionData{appData=" + this.f88973a + ", osData=" + this.f88974b + ", deviceData=" + this.f88975c + "}";
    }
}
