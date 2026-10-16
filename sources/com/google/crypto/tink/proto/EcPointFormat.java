package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public enum EcPointFormat implements Internal.EnumLite {
    UNKNOWN_FORMAT(0),
    UNCOMPRESSED(1),
    COMPRESSED(2),
    DO_NOT_USE_CRUNCHY_UNCOMPRESSED(3),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Internal.EnumLiteMap f86452h = new Internal.EnumLiteMap<EcPointFormat>() { // from class: com.google.crypto.tink.proto.EcPointFormat.1
        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLiteMap
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public EcPointFormat a(int i3) {
            return EcPointFormat.a(i3);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f86454a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class EcPointFormatVerifier implements Internal.EnumVerifier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Internal.EnumVerifier f86455a = new EcPointFormatVerifier();

        private EcPointFormatVerifier() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean a(int i3) {
            return EcPointFormat.a(i3) != null;
        }
    }

    EcPointFormat(int i3) {
        this.f86454a = i3;
    }

    public static EcPointFormat a(int i3) {
        if (i3 == 0) {
            return UNKNOWN_FORMAT;
        }
        if (i3 == 1) {
            return UNCOMPRESSED;
        }
        if (i3 == 2) {
            return COMPRESSED;
        }
        if (i3 != 3) {
            return null;
        }
        return DO_NOT_USE_CRUNCHY_UNCOMPRESSED;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLite
    public final int J() {
        if (this != UNRECOGNIZED) {
            return this.f86454a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
