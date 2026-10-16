package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_StaticSessionData_AppData extends StaticSessionData.AppData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f88976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f88977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f88978c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f88979d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f88980e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final DevelopmentPlatformProvider f88981f;

    AutoValue_StaticSessionData_AppData(String str, String str2, String str3, String str4, int i3, DevelopmentPlatformProvider developmentPlatformProvider) {
        if (str == null) {
            throw new NullPointerException("Null appIdentifier");
        }
        this.f88976a = str;
        if (str2 == null) {
            throw new NullPointerException("Null versionCode");
        }
        this.f88977b = str2;
        if (str3 == null) {
            throw new NullPointerException("Null versionName");
        }
        this.f88978c = str3;
        if (str4 == null) {
            throw new NullPointerException("Null installUuid");
        }
        this.f88979d = str4;
        this.f88980e = i3;
        if (developmentPlatformProvider == null) {
            throw new NullPointerException("Null developmentPlatformProvider");
        }
        this.f88981f = developmentPlatformProvider;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData
    public String a() {
        return this.f88976a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData
    public int c() {
        return this.f88980e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData
    public DevelopmentPlatformProvider d() {
        return this.f88981f;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData
    public String e() {
        return this.f88979d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof StaticSessionData.AppData) {
            StaticSessionData.AppData appData = (StaticSessionData.AppData) obj;
            if (this.f88976a.equals(appData.a()) && this.f88977b.equals(appData.f()) && this.f88978c.equals(appData.g()) && this.f88979d.equals(appData.e()) && this.f88980e == appData.c() && this.f88981f.equals(appData.d())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData
    public String f() {
        return this.f88977b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData
    public String g() {
        return this.f88978c;
    }

    public int hashCode() {
        return ((((((((((this.f88976a.hashCode() ^ 1000003) * 1000003) ^ this.f88977b.hashCode()) * 1000003) ^ this.f88978c.hashCode()) * 1000003) ^ this.f88979d.hashCode()) * 1000003) ^ this.f88980e) * 1000003) ^ this.f88981f.hashCode();
    }

    public String toString() {
        return "AppData{appIdentifier=" + this.f88976a + ", versionCode=" + this.f88977b + ", versionName=" + this.f88978c + ", installUuid=" + this.f88979d + ", deliveryMechanism=" + this.f88980e + ", developmentPlatformProvider=" + this.f88981f + "}";
    }
}
