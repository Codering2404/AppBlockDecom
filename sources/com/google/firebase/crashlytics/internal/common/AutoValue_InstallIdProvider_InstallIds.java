package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.common.InstallIdProvider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_InstallIdProvider_InstallIds extends InstallIdProvider.InstallIds {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f88309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f88310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f88311c;

    AutoValue_InstallIdProvider_InstallIds(String str, String str2, String str3) {
        if (str == null) {
            throw new NullPointerException("Null crashlyticsInstallId");
        }
        this.f88309a = str;
        this.f88310b = str2;
        this.f88311c = str3;
    }

    @Override // com.google.firebase.crashlytics.internal.common.InstallIdProvider.InstallIds
    public String c() {
        return this.f88309a;
    }

    @Override // com.google.firebase.crashlytics.internal.common.InstallIdProvider.InstallIds
    public String d() {
        return this.f88311c;
    }

    @Override // com.google.firebase.crashlytics.internal.common.InstallIdProvider.InstallIds
    public String e() {
        return this.f88310b;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof InstallIdProvider.InstallIds) {
            InstallIdProvider.InstallIds installIds = (InstallIdProvider.InstallIds) obj;
            if (this.f88309a.equals(installIds.c()) && ((str = this.f88310b) != null ? str.equals(installIds.e()) : installIds.e() == null) && ((str2 = this.f88311c) != null ? str2.equals(installIds.d()) : installIds.d() == null)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.f88309a.hashCode() ^ 1000003) * 1000003;
        String str = this.f88310b;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f88311c;
        return iHashCode2 ^ (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "InstallIds{crashlyticsInstallId=" + this.f88309a + ", firebaseInstallationId=" + this.f88310b + ", firebaseAuthenticationToken=" + this.f88311c + "}";
    }
}
