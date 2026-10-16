package com.google.crypto.tink.prf;

import com.google.crypto.tink.util.Bytes;
import com.google.errorprone.annotations.Immutable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class HkdfPrfParameters extends PrfParameters {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f86397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashType f86398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Bytes f86399c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Immutable
    public static final class HashType {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final HashType f86400b = new HashType("SHA1");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final HashType f86401c = new HashType("SHA224");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final HashType f86402d = new HashType("SHA256");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final HashType f86403e = new HashType("SHA384");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final HashType f86404f = new HashType("SHA512");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f86405a;

        private HashType(String str) {
            this.f86405a = str;
        }

        public String toString() {
            return this.f86405a;
        }
    }

    public HashType a() {
        return this.f86398b;
    }

    public int b() {
        return this.f86397a;
    }

    public Bytes c() {
        return this.f86399c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof HkdfPrfParameters)) {
            return false;
        }
        HkdfPrfParameters hkdfPrfParameters = (HkdfPrfParameters) obj;
        return hkdfPrfParameters.b() == b() && hkdfPrfParameters.a() == a() && Objects.equals(hkdfPrfParameters.c(), c());
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f86397a), this.f86398b, this.f86399c);
    }

    public String toString() {
        return "HKDF PRF Parameters (hashType: " + this.f86398b + ", salt: " + this.f86399c + ", and " + this.f86397a + "-byte key)";
    }
}
