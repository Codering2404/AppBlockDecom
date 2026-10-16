package com.google.crypto.tink.util;

import com.google.crypto.tink.subtle.Hex;
import com.google.errorprone.annotations.Immutable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
public final class Bytes {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f87559a;

    private Bytes(byte[] bArr, int i3, int i4) {
        byte[] bArr2 = new byte[i4];
        this.f87559a = bArr2;
        System.arraycopy(bArr, i3, bArr2, 0, i4);
    }

    public static Bytes a(byte[] bArr) {
        if (bArr != null) {
            return b(bArr, 0, bArr.length);
        }
        throw new NullPointerException("data must be non-null");
    }

    public static Bytes b(byte[] bArr, int i3, int i4) {
        if (bArr != null) {
            return new Bytes(bArr, i3, i4);
        }
        throw new NullPointerException("data must be non-null");
    }

    public byte[] c() {
        byte[] bArr = this.f87559a;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Bytes) {
            return Arrays.equals(((Bytes) obj).f87559a, this.f87559a);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f87559a);
    }

    public String toString() {
        return "Bytes(" + Hex.a(this.f87559a) + ")";
    }
}
