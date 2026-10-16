package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.runtime.SendRequest;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_SendRequest extends SendRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TransportContext f69317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f69318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Event f69319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Transformer f69320d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Encoding f69321e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends SendRequest.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private TransportContext f69322a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f69323b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Event f69324c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Transformer f69325d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Encoding f69326e;

        Builder() {
        }

        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        public SendRequest a() {
            String str = "";
            if (this.f69322a == null) {
                str = " transportContext";
            }
            if (this.f69323b == null) {
                str = str + " transportName";
            }
            if (this.f69324c == null) {
                str = str + " event";
            }
            if (this.f69325d == null) {
                str = str + " transformer";
            }
            if (this.f69326e == null) {
                str = str + " encoding";
            }
            if (str.isEmpty()) {
                return new AutoValue_SendRequest(this.f69322a, this.f69323b, this.f69324c, this.f69325d, this.f69326e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        SendRequest.Builder b(Encoding encoding) {
            if (encoding == null) {
                throw new NullPointerException("Null encoding");
            }
            this.f69326e = encoding;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        SendRequest.Builder c(Event event) {
            if (event == null) {
                throw new NullPointerException("Null event");
            }
            this.f69324c = event;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        SendRequest.Builder d(Transformer transformer) {
            if (transformer == null) {
                throw new NullPointerException("Null transformer");
            }
            this.f69325d = transformer;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        public SendRequest.Builder e(TransportContext transportContext) {
            if (transportContext == null) {
                throw new NullPointerException("Null transportContext");
            }
            this.f69322a = transportContext;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        public SendRequest.Builder f(String str) {
            if (str == null) {
                throw new NullPointerException("Null transportName");
            }
            this.f69323b = str;
            return this;
        }
    }

    @Override // com.google.android.datatransport.runtime.SendRequest
    public Encoding b() {
        return this.f69321e;
    }

    @Override // com.google.android.datatransport.runtime.SendRequest
    Event c() {
        return this.f69319c;
    }

    @Override // com.google.android.datatransport.runtime.SendRequest
    Transformer e() {
        return this.f69320d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SendRequest) {
            SendRequest sendRequest = (SendRequest) obj;
            if (this.f69317a.equals(sendRequest.f()) && this.f69318b.equals(sendRequest.g()) && this.f69319c.equals(sendRequest.c()) && this.f69320d.equals(sendRequest.e()) && this.f69321e.equals(sendRequest.b())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.SendRequest
    public TransportContext f() {
        return this.f69317a;
    }

    @Override // com.google.android.datatransport.runtime.SendRequest
    public String g() {
        return this.f69318b;
    }

    public int hashCode() {
        return ((((((((this.f69317a.hashCode() ^ 1000003) * 1000003) ^ this.f69318b.hashCode()) * 1000003) ^ this.f69319c.hashCode()) * 1000003) ^ this.f69320d.hashCode()) * 1000003) ^ this.f69321e.hashCode();
    }

    public String toString() {
        return "SendRequest{transportContext=" + this.f69317a + ", transportName=" + this.f69318b + ", event=" + this.f69319c + ", transformer=" + this.f69320d + ", encoding=" + this.f69321e + "}";
    }

    private AutoValue_SendRequest(TransportContext transportContext, String str, Event event, Transformer transformer, Encoding encoding) {
        this.f69317a = transportContext;
        this.f69318b = str;
        this.f69319c = event;
        this.f69320d = transformer;
        this.f69321e = encoding;
    }
}
