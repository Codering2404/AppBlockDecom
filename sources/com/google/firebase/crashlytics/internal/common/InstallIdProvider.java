package com.google.firebase.crashlytics.internal.common;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public interface InstallIdProvider {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class InstallIds {
        static InstallIds a(String str, FirebaseInstallationId firebaseInstallationId) {
            return new AutoValue_InstallIdProvider_InstallIds(str, firebaseInstallationId.b(), firebaseInstallationId.a());
        }

        public static InstallIds b(String str) {
            return new AutoValue_InstallIdProvider_InstallIds(str, null, null);
        }

        public abstract String c();

        public abstract String d();

        public abstract String e();
    }

    InstallIds a();
}
