package androidx.glance.appwidget.protobuf;

import androidx.glance.appwidget.protobuf.WireFormat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class MapEntryLite<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Metadata f39145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f39146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f39147c;

    /* JADX INFO: renamed from: androidx.glance.appwidget.protobuf.MapEntryLite$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f39148a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f39148a = iArr;
            try {
                iArr[WireFormat.FieldType.f39339n.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f39148a[WireFormat.FieldType.f39342q.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f39148a[WireFormat.FieldType.f39338m.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Metadata<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WireFormat.FieldType f39149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f39150b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WireFormat.FieldType f39151c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f39152d;

        public Metadata(WireFormat.FieldType fieldType, Object obj, WireFormat.FieldType fieldType2, Object obj2) {
            this.f39149a = fieldType;
            this.f39150b = obj;
            this.f39151c = fieldType2;
            this.f39152d = obj2;
        }
    }

    private MapEntryLite(WireFormat.FieldType fieldType, Object obj, WireFormat.FieldType fieldType2, Object obj2) {
        this.f39145a = new Metadata(fieldType, obj, fieldType2, obj2);
        this.f39146b = obj;
        this.f39147c = obj2;
    }

    static int b(Metadata metadata, Object obj, Object obj2) {
        return FieldSet.d(metadata.f39149a, 1, obj) + FieldSet.d(metadata.f39151c, 2, obj2);
    }

    public static MapEntryLite d(WireFormat.FieldType fieldType, Object obj, WireFormat.FieldType fieldType2, Object obj2) {
        return new MapEntryLite(fieldType, obj, fieldType2, obj2);
    }

    static void e(CodedOutputStream codedOutputStream, Metadata metadata, Object obj, Object obj2) {
        FieldSet.A(codedOutputStream, metadata.f39149a, 1, obj);
        FieldSet.A(codedOutputStream, metadata.f39151c, 2, obj2);
    }

    public int a(int i3, Object obj, Object obj2) {
        return CodedOutputStream.M0(i3) + CodedOutputStream.u0(b(this.f39145a, obj, obj2));
    }

    Metadata c() {
        return this.f39145a;
    }
}
