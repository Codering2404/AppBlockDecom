package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public enum EllipticCurveType implements Internal.EnumLite {
    UNKNOWN_CURVE(0),
    NIST_P256(2),
    NIST_P384(3),
    NIST_P521(4),
    CURVE25519(5),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Internal.EnumLiteMap f86483i = new Internal.EnumLiteMap<EllipticCurveType>() { // from class: com.google.crypto.tink.proto.EllipticCurveType.1
        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLiteMap
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public EllipticCurveType a(int i3) {
            return EllipticCurveType.a(i3);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f86485a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class EllipticCurveTypeVerifier implements Internal.EnumVerifier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Internal.EnumVerifier f86486a = new EllipticCurveTypeVerifier();

        private EllipticCurveTypeVerifier() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean a(int i3) {
            return EllipticCurveType.a(i3) != null;
        }
    }

    EllipticCurveType(int i3) {
        this.f86485a = i3;
    }

    public static EllipticCurveType a(int i3) {
        if (i3 == 0) {
            return UNKNOWN_CURVE;
        }
        if (i3 == 2) {
            return NIST_P256;
        }
        if (i3 == 3) {
            return NIST_P384;
        }
        if (i3 == 4) {
            return NIST_P521;
        }
        if (i3 != 5) {
            return null;
        }
        return CURVE25519;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLite
    public final int J() {
        if (this != UNRECOGNIZED) {
            return this.f86485a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
