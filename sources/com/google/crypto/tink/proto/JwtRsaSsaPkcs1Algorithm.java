package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public enum JwtRsaSsaPkcs1Algorithm implements Internal.EnumLite {
    RS_UNKNOWN(0),
    RS256(1),
    RS384(2),
    RS512(3),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Internal.EnumLiteMap f86568h = new Internal.EnumLiteMap<JwtRsaSsaPkcs1Algorithm>() { // from class: com.google.crypto.tink.proto.JwtRsaSsaPkcs1Algorithm.1
        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLiteMap
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public JwtRsaSsaPkcs1Algorithm a(int i3) {
            return JwtRsaSsaPkcs1Algorithm.a(i3);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f86570a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class JwtRsaSsaPkcs1AlgorithmVerifier implements Internal.EnumVerifier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Internal.EnumVerifier f86571a = new JwtRsaSsaPkcs1AlgorithmVerifier();

        private JwtRsaSsaPkcs1AlgorithmVerifier() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean a(int i3) {
            return JwtRsaSsaPkcs1Algorithm.a(i3) != null;
        }
    }

    JwtRsaSsaPkcs1Algorithm(int i3) {
        this.f86570a = i3;
    }

    public static JwtRsaSsaPkcs1Algorithm a(int i3) {
        if (i3 == 0) {
            return RS_UNKNOWN;
        }
        if (i3 == 1) {
            return RS256;
        }
        if (i3 == 2) {
            return RS384;
        }
        if (i3 != 3) {
            return null;
        }
        return RS512;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLite
    public final int J() {
        if (this != UNRECOGNIZED) {
            return this.f86570a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
