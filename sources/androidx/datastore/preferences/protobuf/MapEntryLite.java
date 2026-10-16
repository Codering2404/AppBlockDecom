package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.WireFormat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class MapEntryLite<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Metadata f36499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f36500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f36501c;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.MapEntryLite$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f36502a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f36502a = iArr;
            try {
                iArr[WireFormat.FieldType.f36698n.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f36502a[WireFormat.FieldType.f36701q.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f36502a[WireFormat.FieldType.f36697m.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Metadata<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WireFormat.FieldType f36503a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f36504b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WireFormat.FieldType f36505c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f36506d;

        public Metadata(WireFormat.FieldType fieldType, Object obj, WireFormat.FieldType fieldType2, Object obj2) {
            this.f36503a = fieldType;
            this.f36504b = obj;
            this.f36505c = fieldType2;
            this.f36506d = obj2;
        }
    }

    private MapEntryLite(WireFormat.FieldType fieldType, Object obj, WireFormat.FieldType fieldType2, Object obj2) {
        this.f36499a = new Metadata(fieldType, obj, fieldType2, obj2);
        this.f36500b = obj;
        this.f36501c = obj2;
    }

    static int b(Metadata metadata, Object obj, Object obj2) {
        return FieldSet.d(metadata.f36503a, 1, obj) + FieldSet.d(metadata.f36505c, 2, obj2);
    }

    public static MapEntryLite d(WireFormat.FieldType fieldType, Object obj, WireFormat.FieldType fieldType2, Object obj2) {
        return new MapEntryLite(fieldType, obj, fieldType2, obj2);
    }

    static void e(CodedOutputStream codedOutputStream, Metadata metadata, Object obj, Object obj2) {
        FieldSet.A(codedOutputStream, metadata.f36503a, 1, obj);
        FieldSet.A(codedOutputStream, metadata.f36505c, 2, obj2);
    }

    public int a(int i3, Object obj, Object obj2) {
        return CodedOutputStream.M0(i3) + CodedOutputStream.u0(b(this.f36499a, obj, obj2));
    }

    Metadata c() {
        return this.f36499a;
    }
}
