package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public enum HpkeAead implements Internal.EnumLite {
    AEAD_UNKNOWN(0),
    AES_128_GCM(1),
    AES_256_GCM(2),
    CHACHA20_POLY1305(3),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Internal.EnumLiteMap f86513h = new Internal.EnumLiteMap<HpkeAead>() { // from class: com.google.crypto.tink.proto.HpkeAead.1
        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLiteMap
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public HpkeAead a(int i3) {
            return HpkeAead.a(i3);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f86515a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class HpkeAeadVerifier implements Internal.EnumVerifier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Internal.EnumVerifier f86516a = new HpkeAeadVerifier();

        private HpkeAeadVerifier() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean a(int i3) {
            return HpkeAead.a(i3) != null;
        }
    }

    HpkeAead(int i3) {
        this.f86515a = i3;
    }

    public static HpkeAead a(int i3) {
        if (i3 == 0) {
            return AEAD_UNKNOWN;
        }
        if (i3 == 1) {
            return AES_128_GCM;
        }
        if (i3 == 2) {
            return AES_256_GCM;
        }
        if (i3 != 3) {
            return null;
        }
        return CHACHA20_POLY1305;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLite
    public final int J() {
        if (this != UNRECOGNIZED) {
            return this.f86515a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
