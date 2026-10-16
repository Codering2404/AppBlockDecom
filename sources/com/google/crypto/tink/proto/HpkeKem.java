package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public enum HpkeKem implements Internal.EnumLite {
    KEM_UNKNOWN(0),
    DHKEM_X25519_HKDF_SHA256(1),
    DHKEM_P256_HKDF_SHA256(2),
    DHKEM_P384_HKDF_SHA384(3),
    DHKEM_P521_HKDF_SHA512(4),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Internal.EnumLiteMap f86532i = new Internal.EnumLiteMap<HpkeKem>() { // from class: com.google.crypto.tink.proto.HpkeKem.1
        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLiteMap
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public HpkeKem a(int i3) {
            return HpkeKem.a(i3);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f86534a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class HpkeKemVerifier implements Internal.EnumVerifier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Internal.EnumVerifier f86535a = new HpkeKemVerifier();

        private HpkeKemVerifier() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean a(int i3) {
            return HpkeKem.a(i3) != null;
        }
    }

    HpkeKem(int i3) {
        this.f86534a = i3;
    }

    public static HpkeKem a(int i3) {
        if (i3 == 0) {
            return KEM_UNKNOWN;
        }
        if (i3 == 1) {
            return DHKEM_X25519_HKDF_SHA256;
        }
        if (i3 == 2) {
            return DHKEM_P256_HKDF_SHA256;
        }
        if (i3 == 3) {
            return DHKEM_P384_HKDF_SHA384;
        }
        if (i3 != 4) {
            return null;
        }
        return DHKEM_P521_HKDF_SHA512;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLite
    public final int J() {
        if (this != UNRECOGNIZED) {
            return this.f86534a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
