package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public enum OutputPrefixType implements Internal.EnumLite {
    UNKNOWN_PREFIX(0),
    TINK(1),
    LEGACY(2),
    RAW(3),
    CRUNCHY(4),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Internal.EnumLiteMap f86621i = new Internal.EnumLiteMap<OutputPrefixType>() { // from class: com.google.crypto.tink.proto.OutputPrefixType.1
        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLiteMap
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public OutputPrefixType a(int i3) {
            return OutputPrefixType.a(i3);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f86623a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class OutputPrefixTypeVerifier implements Internal.EnumVerifier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Internal.EnumVerifier f86624a = new OutputPrefixTypeVerifier();

        private OutputPrefixTypeVerifier() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean a(int i3) {
            return OutputPrefixType.a(i3) != null;
        }
    }

    OutputPrefixType(int i3) {
        this.f86623a = i3;
    }

    public static OutputPrefixType a(int i3) {
        if (i3 == 0) {
            return UNKNOWN_PREFIX;
        }
        if (i3 == 1) {
            return TINK;
        }
        if (i3 == 2) {
            return LEGACY;
        }
        if (i3 == 3) {
            return RAW;
        }
        if (i3 != 4) {
            return null;
        }
        return CRUNCHY;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLite
    public final int J() {
        if (this != UNRECOGNIZED) {
            return this.f86623a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
