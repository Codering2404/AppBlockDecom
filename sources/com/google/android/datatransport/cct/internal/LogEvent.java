package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.AutoValue_LogEvent;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class LogEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public abstract LogEvent a();

        public abstract Builder b(ComplianceData complianceData);

        public abstract Builder c(Integer num);

        public abstract Builder d(long j3);

        public abstract Builder e(long j3);

        public abstract Builder f(ExperimentIds experimentIds);

        public abstract Builder g(NetworkConnectionInfo networkConnectionInfo);

        abstract Builder h(byte[] bArr);

        abstract Builder i(String str);

        public abstract Builder j(long j3);
    }

    private static Builder a() {
        return new AutoValue_LogEvent.Builder();
    }

    public static Builder k(String str) {
        return a().i(str);
    }

    public static Builder l(byte[] bArr) {
        return a().h(bArr);
    }

    public abstract ComplianceData b();

    public abstract Integer c();

    public abstract long d();

    public abstract long e();

    public abstract ExperimentIds f();

    public abstract NetworkConnectionInfo g();

    public abstract byte[] h();

    public abstract String i();

    public abstract long j();
}
