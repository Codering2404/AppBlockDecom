package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.AutoValue_LogRequest;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class LogRequest {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public abstract LogRequest a();

        public abstract Builder b(ClientInfo clientInfo);

        public abstract Builder c(List list);

        abstract Builder d(Integer num);

        abstract Builder e(String str);

        public abstract Builder f(QosTier qosTier);

        public abstract Builder g(long j3);

        public abstract Builder h(long j3);

        public Builder i(int i3) {
            return d(Integer.valueOf(i3));
        }

        public Builder j(String str) {
            return e(str);
        }
    }

    public static Builder a() {
        return new AutoValue_LogRequest.Builder();
    }

    public abstract ClientInfo b();

    public abstract List c();

    public abstract Integer d();

    public abstract String e();

    public abstract QosTier f();

    public abstract long g();

    public abstract long h();
}
