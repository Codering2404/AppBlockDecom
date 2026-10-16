package com.google.crypto.tink.mac;

import com.google.errorprone.annotations.Immutable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class HmacParameters extends MacParameters {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f86346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f86347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Variant f86348c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashType f86349d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Immutable
    public static final class HashType {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final HashType f86350b = new HashType("SHA1");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final HashType f86351c = new HashType("SHA224");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final HashType f86352d = new HashType("SHA256");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final HashType f86353e = new HashType("SHA384");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final HashType f86354f = new HashType("SHA512");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f86355a;

        private HashType(String str) {
            this.f86355a = str;
        }

        public String toString() {
            return this.f86355a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Immutable
    public static final class Variant {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Variant f86356b = new Variant("TINK");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Variant f86357c = new Variant("CRUNCHY");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Variant f86358d = new Variant("LEGACY");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final Variant f86359e = new Variant("NO_PREFIX");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f86360a;

        private Variant(String str) {
            this.f86360a = str;
        }

        public String toString() {
            return this.f86360a;
        }
    }

    public int a() {
        return this.f86347b;
    }

    public HashType b() {
        return this.f86349d;
    }

    public int c() {
        return this.f86346a;
    }

    public int d() {
        Variant variant = this.f86348c;
        if (variant == Variant.f86359e) {
            return a();
        }
        if (variant != Variant.f86356b && variant != Variant.f86357c && variant != Variant.f86358d) {
            throw new IllegalStateException("Unknown variant");
        }
        int iA = a();
        return iA + 5;
    }

    public Variant e() {
        return this.f86348c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof HmacParameters)) {
            return false;
        }
        HmacParameters hmacParameters = (HmacParameters) obj;
        return hmacParameters.c() == c() && hmacParameters.d() == d() && hmacParameters.e() == e() && hmacParameters.b() == b();
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f86346a), Integer.valueOf(this.f86347b), this.f86348c, this.f86349d);
    }

    public String toString() {
        return "HMAC Parameters (variant: " + this.f86348c + ", hashType: " + this.f86349d + ", " + this.f86347b + "-byte tags, and " + this.f86346a + "-byte key)";
    }
}
