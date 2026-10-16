package com.google.crypto.tink;

import com.google.crypto.tink.subtle.Hex;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class PrimitiveSet<P> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentMap f86041a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder<P> {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Entry<P> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f86042a;

        public Object a() {
            return this.f86042a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Prefix implements Comparable<Prefix> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final byte[] f86043a;

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(Prefix prefix) {
            byte[] bArr = this.f86043a;
            int length = bArr.length;
            byte[] bArr2 = prefix.f86043a;
            if (length != bArr2.length) {
                return bArr.length - bArr2.length;
            }
            int i3 = 0;
            while (true) {
                byte[] bArr3 = this.f86043a;
                if (i3 >= bArr3.length) {
                    return 0;
                }
                byte b3 = bArr3[i3];
                byte b4 = prefix.f86043a[i3];
                if (b3 != b4) {
                    return b3 - b4;
                }
                i3++;
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof Prefix) {
                return Arrays.equals(this.f86043a, ((Prefix) obj).f86043a);
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(this.f86043a);
        }

        public String toString() {
            return Hex.a(this.f86043a);
        }

        private Prefix(byte[] bArr) {
            this.f86043a = Arrays.copyOf(bArr, bArr.length);
        }
    }

    public List a(byte[] bArr) {
        List list = (List) this.f86041a.get(new Prefix(bArr));
        return list != null ? list : Collections.EMPTY_LIST;
    }

    public List b() {
        return a(CryptoFormat.f85996a);
    }
}
