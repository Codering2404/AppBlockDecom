package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.StaticSessionData;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_StaticSessionData_OsData extends StaticSessionData.OsData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f88991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f88992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f88993c;

    AutoValue_StaticSessionData_OsData(String str, String str2, boolean z2) {
        if (str == null) {
            throw new NullPointerException("Null osRelease");
        }
        this.f88991a = str;
        if (str2 == null) {
            throw new NullPointerException("Null osCodeName");
        }
        this.f88992b = str2;
        this.f88993c = z2;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.OsData
    public boolean b() {
        return this.f88993c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.OsData
    public String c() {
        return this.f88992b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.OsData
    public String d() {
        return this.f88991a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof StaticSessionData.OsData) {
            StaticSessionData.OsData osData = (StaticSessionData.OsData) obj;
            if (this.f88991a.equals(osData.d()) && this.f88992b.equals(osData.c()) && this.f88993c == osData.b()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f88991a.hashCode() ^ 1000003) * 1000003) ^ this.f88992b.hashCode()) * 1000003) ^ (this.f88993c ? 1231 : 1237);
    }

    public String toString() {
        return "OsData{osRelease=" + this.f88991a + ", osCodeName=" + this.f88992b + ", isRooted=" + this.f88993c + "}";
    }
}
