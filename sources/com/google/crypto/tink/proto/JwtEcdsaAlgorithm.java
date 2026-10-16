package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public enum JwtEcdsaAlgorithm implements Internal.EnumLite {
    ES_UNKNOWN(0),
    ES256(1),
    ES384(2),
    ES512(3),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Internal.EnumLiteMap f86545h = new Internal.EnumLiteMap<JwtEcdsaAlgorithm>() { // from class: com.google.crypto.tink.proto.JwtEcdsaAlgorithm.1
        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLiteMap
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public JwtEcdsaAlgorithm a(int i3) {
            return JwtEcdsaAlgorithm.a(i3);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f86547a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class JwtEcdsaAlgorithmVerifier implements Internal.EnumVerifier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Internal.EnumVerifier f86548a = new JwtEcdsaAlgorithmVerifier();

        private JwtEcdsaAlgorithmVerifier() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean a(int i3) {
            return JwtEcdsaAlgorithm.a(i3) != null;
        }
    }

    JwtEcdsaAlgorithm(int i3) {
        this.f86547a = i3;
    }

    public static JwtEcdsaAlgorithm a(int i3) {
        if (i3 == 0) {
            return ES_UNKNOWN;
        }
        if (i3 == 1) {
            return ES256;
        }
        if (i3 == 2) {
            return ES384;
        }
        if (i3 != 3) {
            return null;
        }
        return ES512;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLite
    public final int J() {
        if (this != UNRECOGNIZED) {
            return this.f86547a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
