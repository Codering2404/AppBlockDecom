package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.Internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public enum Syntax implements Internal.EnumLite {
    SYNTAX_PROTO2(0),
    SYNTAX_PROTO3(1),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Internal.EnumLiteMap f87127f = new Internal.EnumLiteMap<Syntax>() { // from class: com.google.crypto.tink.shaded.protobuf.Syntax.1
        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLiteMap
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Syntax a(int i3) {
            return Syntax.a(i3);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f87129a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SyntaxVerifier implements Internal.EnumVerifier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Internal.EnumVerifier f87130a = new SyntaxVerifier();

        private SyntaxVerifier() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean a(int i3) {
            return Syntax.a(i3) != null;
        }
    }

    Syntax(int i3) {
        this.f87129a = i3;
    }

    public static Syntax a(int i3) {
        if (i3 == 0) {
            return SYNTAX_PROTO2;
        }
        if (i3 != 1) {
            return null;
        }
        return SYNTAX_PROTO3;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLite
    public final int J() {
        if (this != UNRECOGNIZED) {
            return this.f87129a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
