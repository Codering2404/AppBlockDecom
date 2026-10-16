package androidx.glance.appwidget.protobuf;

import androidx.glance.appwidget.protobuf.Internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public enum NullValue implements Internal.EnumLite {
    NULL_VALUE(0),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Internal.EnumLiteMap f39190d = new Internal.EnumLiteMap<NullValue>() { // from class: androidx.glance.appwidget.protobuf.NullValue.1
        @Override // androidx.glance.appwidget.protobuf.Internal.EnumLiteMap
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public NullValue a(int i3) {
            return NullValue.a(i3);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f39192a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class NullValueVerifier implements Internal.EnumVerifier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Internal.EnumVerifier f39193a = new NullValueVerifier();

        private NullValueVerifier() {
        }

        @Override // androidx.glance.appwidget.protobuf.Internal.EnumVerifier
        public boolean a(int i3) {
            return NullValue.a(i3) != null;
        }
    }

    NullValue(int i3) {
        this.f39192a = i3;
    }

    public static NullValue a(int i3) {
        if (i3 != 0) {
            return null;
        }
        return NULL_VALUE;
    }

    @Override // androidx.glance.appwidget.protobuf.Internal.EnumLite
    public final int J() {
        if (this != UNRECOGNIZED) {
            return this.f39192a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
