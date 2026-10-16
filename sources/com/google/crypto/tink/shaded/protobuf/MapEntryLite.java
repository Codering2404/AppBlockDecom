package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.WireFormat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class MapEntryLite<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Metadata f87006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f87007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f87008c;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.MapEntryLite$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f87009a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f87009a = iArr;
            try {
                iArr[WireFormat.FieldType.f87200n.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f87009a[WireFormat.FieldType.f87203q.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f87009a[WireFormat.FieldType.f87199m.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Metadata<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WireFormat.FieldType f87010a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f87011b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WireFormat.FieldType f87012c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f87013d;

        public Metadata(WireFormat.FieldType fieldType, Object obj, WireFormat.FieldType fieldType2, Object obj2) {
            this.f87010a = fieldType;
            this.f87011b = obj;
            this.f87012c = fieldType2;
            this.f87013d = obj2;
        }
    }

    private MapEntryLite(WireFormat.FieldType fieldType, Object obj, WireFormat.FieldType fieldType2, Object obj2) {
        this.f87006a = new Metadata(fieldType, obj, fieldType2, obj2);
        this.f87007b = obj;
        this.f87008c = obj2;
    }

    static int b(Metadata metadata, Object obj, Object obj2) {
        return FieldSet.d(metadata.f87010a, 1, obj) + FieldSet.d(metadata.f87012c, 2, obj2);
    }

    public static MapEntryLite d(WireFormat.FieldType fieldType, Object obj, WireFormat.FieldType fieldType2, Object obj2) {
        return new MapEntryLite(fieldType, obj, fieldType2, obj2);
    }

    static void e(CodedOutputStream codedOutputStream, Metadata metadata, Object obj, Object obj2) {
        FieldSet.A(codedOutputStream, metadata.f87010a, 1, obj);
        FieldSet.A(codedOutputStream, metadata.f87012c, 2, obj2);
    }

    public int a(int i3, Object obj, Object obj2) {
        return CodedOutputStream.L0(i3) + CodedOutputStream.u0(b(this.f87006a, obj, obj2));
    }

    Metadata c() {
        return this.f87006a;
    }
}
