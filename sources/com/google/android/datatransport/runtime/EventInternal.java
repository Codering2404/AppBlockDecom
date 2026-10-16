package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class EventInternal {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public final Builder a(String str, int i3) {
            e().put(str, String.valueOf(i3));
            return this;
        }

        public final Builder b(String str, long j3) {
            e().put(str, String.valueOf(j3));
            return this;
        }

        public final Builder c(String str, String str2) {
            e().put(str, str2);
            return this;
        }

        public abstract EventInternal d();

        protected abstract Map e();

        protected abstract Builder f(Map map);

        public abstract Builder g(Integer num);

        public abstract Builder h(EncodedPayload encodedPayload);

        public abstract Builder i(long j3);

        public abstract Builder j(byte[] bArr);

        public abstract Builder k(byte[] bArr);

        public abstract Builder l(Integer num);

        public abstract Builder m(String str);

        public abstract Builder n(String str);

        public abstract Builder o(long j3);
    }

    public static Builder a() {
        return new AutoValue_EventInternal.Builder().f(new HashMap());
    }

    public final String b(String str) {
        String str2 = (String) c().get(str);
        return str2 == null ? "" : str2;
    }

    protected abstract Map c();

    public abstract Integer d();

    public abstract EncodedPayload e();

    public abstract long f();

    public abstract byte[] g();

    public abstract byte[] h();

    public final int i(String str) {
        String str2 = (String) c().get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    public final long j(String str) {
        String str2 = (String) c().get(str);
        if (str2 == null) {
            return 0L;
        }
        return Long.valueOf(str2).longValue();
    }

    public final Map k() {
        return Collections.unmodifiableMap(c());
    }

    public abstract Integer l();

    public abstract String m();

    public abstract String n();

    public abstract long o();

    public Builder p() {
        return new AutoValue_EventInternal.Builder().n(n()).g(d()).l(l()).m(m()).j(g()).k(h()).h(e()).i(f()).o(o()).f(new HashMap(c()));
    }
}
