package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.runtime.AutoValue_SendRequest;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
abstract class SendRequest {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public abstract SendRequest a();

        abstract Builder b(Encoding encoding);

        abstract Builder c(Event event);

        abstract Builder d(Transformer transformer);

        public abstract Builder e(TransportContext transportContext);

        public abstract Builder f(String str);
    }

    SendRequest() {
    }

    public static Builder a() {
        return new AutoValue_SendRequest.Builder();
    }

    public abstract Encoding b();

    abstract Event c();

    public byte[] d() {
        return (byte[]) e().apply(c().c());
    }

    abstract Transformer e();

    public abstract TransportContext f();

    public abstract String g();
}
