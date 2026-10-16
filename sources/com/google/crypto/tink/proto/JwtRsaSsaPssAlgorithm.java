package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public enum JwtRsaSsaPssAlgorithm implements Internal.EnumLite {
    PS_UNKNOWN(0),
    PS256(1),
    PS384(2),
    PS512(3),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Internal.EnumLiteMap f86580h = new Internal.EnumLiteMap<JwtRsaSsaPssAlgorithm>() { // from class: com.google.crypto.tink.proto.JwtRsaSsaPssAlgorithm.1
        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLiteMap
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public JwtRsaSsaPssAlgorithm a(int i3) {
            return JwtRsaSsaPssAlgorithm.a(i3);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f86582a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class JwtRsaSsaPssAlgorithmVerifier implements Internal.EnumVerifier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Internal.EnumVerifier f86583a = new JwtRsaSsaPssAlgorithmVerifier();

        private JwtRsaSsaPssAlgorithmVerifier() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean a(int i3) {
            return JwtRsaSsaPssAlgorithm.a(i3) != null;
        }
    }

    JwtRsaSsaPssAlgorithm(int i3) {
        this.f86582a = i3;
    }

    public static JwtRsaSsaPssAlgorithm a(int i3) {
        if (i3 == 0) {
            return PS_UNKNOWN;
        }
        if (i3 == 1) {
            return PS256;
        }
        if (i3 == 2) {
            return PS384;
        }
        if (i3 != 3) {
            return null;
        }
        return PS512;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLite
    public final int J() {
        if (this != UNRECOGNIZED) {
            return this.f86582a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
