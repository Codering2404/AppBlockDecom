package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class EncodedPayload {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Encoding f69348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f69349b;

    public EncodedPayload(Encoding encoding, byte[] bArr) {
        if (encoding == null) {
            throw new NullPointerException("encoding is null");
        }
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        this.f69348a = encoding;
        this.f69349b = bArr;
    }

    public byte[] a() {
        return this.f69349b;
    }

    public Encoding b() {
        return this.f69348a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EncodedPayload)) {
            return false;
        }
        EncodedPayload encodedPayload = (EncodedPayload) obj;
        if (this.f69348a.equals(encodedPayload.f69348a)) {
            return Arrays.equals(this.f69349b, encodedPayload.f69349b);
        }
        return false;
    }

    public int hashCode() {
        return ((this.f69348a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f69349b);
    }

    public String toString() {
        return "EncodedPayload{encoding=" + this.f69348a + ", bytes=[...]}";
    }
}
