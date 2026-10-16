package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public enum KeyStatusType implements Internal.EnumLite {
    UNKNOWN_STATUS(0),
    ENABLED(1),
    DISABLED(2),
    DESTROYED(3),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Internal.EnumLiteMap f86603h = new Internal.EnumLiteMap<KeyStatusType>() { // from class: com.google.crypto.tink.proto.KeyStatusType.1
        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLiteMap
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public KeyStatusType a(int i3) {
            return KeyStatusType.a(i3);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f86605a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class KeyStatusTypeVerifier implements Internal.EnumVerifier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Internal.EnumVerifier f86606a = new KeyStatusTypeVerifier();

        private KeyStatusTypeVerifier() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean a(int i3) {
            return KeyStatusType.a(i3) != null;
        }
    }

    KeyStatusType(int i3) {
        this.f86605a = i3;
    }

    public static KeyStatusType a(int i3) {
        if (i3 == 0) {
            return UNKNOWN_STATUS;
        }
        if (i3 == 1) {
            return ENABLED;
        }
        if (i3 == 2) {
            return DISABLED;
        }
        if (i3 != 3) {
            return null;
        }
        return DESTROYED;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLite
    public final int J() {
        if (this != UNRECOGNIZED) {
            return this.f86605a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
