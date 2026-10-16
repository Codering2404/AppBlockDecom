package androidx.glance.appwidget.protobuf;

import androidx.glance.appwidget.protobuf.Internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public enum Syntax implements Internal.EnumLite {
    SYNTAX_PROTO2(0),
    SYNTAX_PROTO3(1),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Internal.EnumLiteMap f39266f = new Internal.EnumLiteMap<Syntax>() { // from class: androidx.glance.appwidget.protobuf.Syntax.1
        @Override // androidx.glance.appwidget.protobuf.Internal.EnumLiteMap
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Syntax a(int i3) {
            return Syntax.a(i3);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f39268a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SyntaxVerifier implements Internal.EnumVerifier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Internal.EnumVerifier f39269a = new SyntaxVerifier();

        private SyntaxVerifier() {
        }

        @Override // androidx.glance.appwidget.protobuf.Internal.EnumVerifier
        public boolean a(int i3) {
            return Syntax.a(i3) != null;
        }
    }

    Syntax(int i3) {
        this.f39268a = i3;
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

    @Override // androidx.glance.appwidget.protobuf.Internal.EnumLite
    public final int J() {
        if (this != UNRECOGNIZED) {
            return this.f39268a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
