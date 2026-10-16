package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.TransportContext;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_TransportContext extends TransportContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f69327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f69328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Priority f69329c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends TransportContext.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f69330a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private byte[] f69331b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Priority f69332c;

        Builder() {
        }

        @Override // com.google.android.datatransport.runtime.TransportContext.Builder
        public TransportContext a() {
            String str = "";
            if (this.f69330a == null) {
                str = " backendName";
            }
            if (this.f69332c == null) {
                str = str + " priority";
            }
            if (str.isEmpty()) {
                return new AutoValue_TransportContext(this.f69330a, this.f69331b, this.f69332c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.TransportContext.Builder
        public TransportContext.Builder b(String str) {
            if (str == null) {
                throw new NullPointerException("Null backendName");
            }
            this.f69330a = str;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.TransportContext.Builder
        public TransportContext.Builder c(byte[] bArr) {
            this.f69331b = bArr;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.TransportContext.Builder
        public TransportContext.Builder d(Priority priority) {
            if (priority == null) {
                throw new NullPointerException("Null priority");
            }
            this.f69332c = priority;
            return this;
        }
    }

    @Override // com.google.android.datatransport.runtime.TransportContext
    public String b() {
        return this.f69327a;
    }

    @Override // com.google.android.datatransport.runtime.TransportContext
    public byte[] c() {
        return this.f69328b;
    }

    @Override // com.google.android.datatransport.runtime.TransportContext
    public Priority d() {
        return this.f69329c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof TransportContext) {
            TransportContext transportContext = (TransportContext) obj;
            if (this.f69327a.equals(transportContext.b())) {
                if (Arrays.equals(this.f69328b, transportContext instanceof AutoValue_TransportContext ? ((AutoValue_TransportContext) transportContext).f69328b : transportContext.c()) && this.f69329c.equals(transportContext.d())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f69327a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f69328b)) * 1000003) ^ this.f69329c.hashCode();
    }

    private AutoValue_TransportContext(String str, byte[] bArr, Priority priority) {
        this.f69327a = str;
        this.f69328b = bArr;
        this.f69329c = priority;
    }
}
