package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public enum HpkeKdf implements Internal.EnumLite {
    KDF_UNKNOWN(0),
    HKDF_SHA256(1),
    HKDF_SHA384(2),
    HKDF_SHA512(3),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Internal.EnumLiteMap f86522h = new Internal.EnumLiteMap<HpkeKdf>() { // from class: com.google.crypto.tink.proto.HpkeKdf.1
        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLiteMap
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public HpkeKdf a(int i3) {
            return HpkeKdf.a(i3);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f86524a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class HpkeKdfVerifier implements Internal.EnumVerifier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Internal.EnumVerifier f86525a = new HpkeKdfVerifier();

        private HpkeKdfVerifier() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean a(int i3) {
            return HpkeKdf.a(i3) != null;
        }
    }

    HpkeKdf(int i3) {
        this.f86524a = i3;
    }

    public static HpkeKdf a(int i3) {
        if (i3 == 0) {
            return KDF_UNKNOWN;
        }
        if (i3 == 1) {
            return HKDF_SHA256;
        }
        if (i3 == 2) {
            return HKDF_SHA384;
        }
        if (i3 != 3) {
            return null;
        }
        return HKDF_SHA512;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLite
    public final int J() {
        if (this != UNRECOGNIZED) {
            return this.f86524a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
