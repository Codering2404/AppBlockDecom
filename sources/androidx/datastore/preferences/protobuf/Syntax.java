package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public enum Syntax implements Internal.EnumLite {
    SYNTAX_PROTO2(0),
    SYNTAX_PROTO3(1),
    SYNTAX_EDITIONS(2),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Internal.EnumLiteMap f36624g = new Internal.EnumLiteMap<Syntax>() { // from class: androidx.datastore.preferences.protobuf.Syntax.1
        @Override // androidx.datastore.preferences.protobuf.Internal.EnumLiteMap
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Syntax a(int i3) {
            return Syntax.a(i3);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f36626a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SyntaxVerifier implements Internal.EnumVerifier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Internal.EnumVerifier f36627a = new SyntaxVerifier();

        private SyntaxVerifier() {
        }

        @Override // androidx.datastore.preferences.protobuf.Internal.EnumVerifier
        public boolean a(int i3) {
            return Syntax.a(i3) != null;
        }
    }

    Syntax(int i3) {
        this.f36626a = i3;
    }

    public static Syntax a(int i3) {
        if (i3 == 0) {
            return SYNTAX_PROTO2;
        }
        if (i3 == 1) {
            return SYNTAX_PROTO3;
        }
        if (i3 != 2) {
            return null;
        }
        return SYNTAX_EDITIONS;
    }

    @Override // androidx.datastore.preferences.protobuf.Internal.EnumLite
    public final int J() {
        if (this != UNRECOGNIZED) {
            return this.f36626a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
