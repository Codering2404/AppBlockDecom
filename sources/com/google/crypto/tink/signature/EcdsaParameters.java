package com.google.crypto.tink.signature;

import com.google.crypto.tink.internal.EllipticCurvesUtil;
import com.google.errorprone.annotations.Immutable;
import java.security.spec.ECParameterSpec;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class EcdsaParameters extends SignatureParameters {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SignatureEncoding f87229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CurveType f87230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashType f87231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Variant f87232d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Immutable
    public static final class CurveType {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final CurveType f87233c = new CurveType("NIST_P256", EllipticCurvesUtil.f86214a);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final CurveType f87234d = new CurveType("NIST_P384", EllipticCurvesUtil.f86215b);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final CurveType f87235e = new CurveType("NIST_P521", EllipticCurvesUtil.f86216c);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f87236a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ECParameterSpec f87237b;

        private CurveType(String str, ECParameterSpec eCParameterSpec) {
            this.f87236a = str;
            this.f87237b = eCParameterSpec;
        }

        public String toString() {
            return this.f87236a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Immutable
    public static final class HashType {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final HashType f87238b = new HashType("SHA256");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final HashType f87239c = new HashType("SHA384");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final HashType f87240d = new HashType("SHA512");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f87241a;

        private HashType(String str) {
            this.f87241a = str;
        }

        public String toString() {
            return this.f87241a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Immutable
    public static final class SignatureEncoding {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final SignatureEncoding f87242b = new SignatureEncoding("IEEE_P1363");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final SignatureEncoding f87243c = new SignatureEncoding("DER");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f87244a;

        private SignatureEncoding(String str) {
            this.f87244a = str;
        }

        public String toString() {
            return this.f87244a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Immutable
    public static final class Variant {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Variant f87245b = new Variant("TINK");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Variant f87246c = new Variant("CRUNCHY");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Variant f87247d = new Variant("LEGACY");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final Variant f87248e = new Variant("NO_PREFIX");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f87249a;

        private Variant(String str) {
            this.f87249a = str;
        }

        public String toString() {
            return this.f87249a;
        }
    }

    public CurveType a() {
        return this.f87230b;
    }

    public HashType b() {
        return this.f87231c;
    }

    public SignatureEncoding c() {
        return this.f87229a;
    }

    public Variant d() {
        return this.f87232d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof EcdsaParameters)) {
            return false;
        }
        EcdsaParameters ecdsaParameters = (EcdsaParameters) obj;
        return ecdsaParameters.c() == c() && ecdsaParameters.a() == a() && ecdsaParameters.b() == b() && ecdsaParameters.d() == d();
    }

    public int hashCode() {
        return Objects.hash(this.f87229a, this.f87230b, this.f87231c, this.f87232d);
    }

    public String toString() {
        return "ECDSA Parameters (variant: " + this.f87232d + ", hashType: " + this.f87231c + ", encoding: " + this.f87229a + ", curve: " + this.f87230b + ")";
    }
}
