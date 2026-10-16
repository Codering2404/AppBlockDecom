package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class StaticSessionData {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class AppData {
        public static AppData b(String str, String str2, String str3, String str4, int i3, DevelopmentPlatformProvider developmentPlatformProvider) {
            return new AutoValue_StaticSessionData_AppData(str, str2, str3, str4, i3, developmentPlatformProvider);
        }

        public abstract String a();

        public abstract int c();

        public abstract DevelopmentPlatformProvider d();

        public abstract String e();

        public abstract String f();

        public abstract String g();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class DeviceData {
        public static DeviceData c(int i3, String str, int i4, long j3, long j4, boolean z2, int i5, String str2, String str3) {
            return new AutoValue_StaticSessionData_DeviceData(i3, str, i4, j3, j4, z2, i5, str2, str3);
        }

        public abstract int a();

        public abstract int b();

        public abstract long d();

        public abstract boolean e();

        public abstract String f();

        public abstract String g();

        public abstract String h();

        public abstract int i();

        public abstract long j();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class OsData {
        public static OsData a(String str, String str2, boolean z2) {
            return new AutoValue_StaticSessionData_OsData(str, str2, z2);
        }

        public abstract boolean b();

        public abstract String c();

        public abstract String d();
    }

    public static StaticSessionData b(AppData appData, OsData osData, DeviceData deviceData) {
        return new AutoValue_StaticSessionData(appData, osData, deviceData);
    }

    public abstract AppData a();

    public abstract DeviceData c();

    public abstract OsData d();
}
