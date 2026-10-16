package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.BackendRequest;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_BackendRequest extends BackendRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Iterable f69372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f69373b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends BackendRequest.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Iterable f69374a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private byte[] f69375b;

        Builder() {
        }

        @Override // com.google.android.datatransport.runtime.backends.BackendRequest.Builder
        public BackendRequest a() {
            String str = "";
            if (this.f69374a == null) {
                str = " events";
            }
            if (str.isEmpty()) {
                return new AutoValue_BackendRequest(this.f69374a, this.f69375b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.backends.BackendRequest.Builder
        public BackendRequest.Builder b(Iterable iterable) {
            if (iterable == null) {
                throw new NullPointerException("Null events");
            }
            this.f69374a = iterable;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.backends.BackendRequest.Builder
        public BackendRequest.Builder c(byte[] bArr) {
            this.f69375b = bArr;
            return this;
        }
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendRequest
    public Iterable b() {
        return this.f69372a;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendRequest
    public byte[] c() {
        return this.f69373b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BackendRequest) {
            BackendRequest backendRequest = (BackendRequest) obj;
            if (this.f69372a.equals(backendRequest.b())) {
                if (Arrays.equals(this.f69373b, backendRequest instanceof AutoValue_BackendRequest ? ((AutoValue_BackendRequest) backendRequest).f69373b : backendRequest.c())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f69372a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f69373b);
    }

    public String toString() {
        return "BackendRequest{events=" + this.f69372a + ", extras=" + Arrays.toString(this.f69373b) + "}";
    }

    private AutoValue_BackendRequest(Iterable iterable, byte[] bArr) {
        this.f69372a = iterable;
        this.f69373b = bArr;
    }
}
