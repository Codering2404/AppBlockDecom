package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public enum JwtHmacAlgorithm implements Internal.EnumLite {
    HS_UNKNOWN(0),
    HS256(1),
    HS384(2),
    HS512(3),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Internal.EnumLiteMap f86557h = new Internal.EnumLiteMap<JwtHmacAlgorithm>() { // from class: com.google.crypto.tink.proto.JwtHmacAlgorithm.1
        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLiteMap
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public JwtHmacAlgorithm a(int i3) {
            return JwtHmacAlgorithm.a(i3);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f86559a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class JwtHmacAlgorithmVerifier implements Internal.EnumVerifier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Internal.EnumVerifier f86560a = new JwtHmacAlgorithmVerifier();

        private JwtHmacAlgorithmVerifier() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean a(int i3) {
            return JwtHmacAlgorithm.a(i3) != null;
        }
    }

    JwtHmacAlgorithm(int i3) {
        this.f86559a = i3;
    }

    public static JwtHmacAlgorithm a(int i3) {
        if (i3 == 0) {
            return HS_UNKNOWN;
        }
        if (i3 == 1) {
            return HS256;
        }
        if (i3 == 2) {
            return HS384;
        }
        if (i3 != 3) {
            return null;
        }
        return HS512;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLite
    public final int J() {
        if (this != UNRECOGNIZED) {
            return this.f86559a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
