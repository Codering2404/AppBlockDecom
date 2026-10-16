package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class FieldInfo implements Comparable<FieldInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final java.lang.reflect.Field f36327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FieldType f36328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Class f36329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f36330d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final java.lang.reflect.Field f36331f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f36332g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f36333h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f36334i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final OneofInfo f36335j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final java.lang.reflect.Field f36336k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Class f36337l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Object f36338m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Internal.EnumVerifier f36339n;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.FieldInfo$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f36340a;

        static {
            int[] iArr = new int[FieldType.values().length];
            f36340a = iArr;
            try {
                iArr[FieldType.f36365p.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f36340a[FieldType.f36373x.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f36340a[FieldType.H.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f36340a[FieldType.f36351d0.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(FieldInfo fieldInfo) {
        return this.f36330d - fieldInfo.f36330d;
    }

    public java.lang.reflect.Field b() {
        return this.f36336k;
    }

    public Internal.EnumVerifier c() {
        return this.f36339n;
    }

    public java.lang.reflect.Field d() {
        return this.f36327a;
    }

    public int e() {
        return this.f36330d;
    }

    public Object f() {
        return this.f36338m;
    }

    public Class g() {
        int i3 = AnonymousClass1.f36340a[this.f36328b.ordinal()];
        if (i3 == 1 || i3 == 2) {
            java.lang.reflect.Field field = this.f36327a;
            return field != null ? field.getType() : this.f36337l;
        }
        if (i3 == 3 || i3 == 4) {
            return this.f36329c;
        }
        return null;
    }

    public OneofInfo h() {
        return this.f36335j;
    }

    public java.lang.reflect.Field i() {
        return this.f36331f;
    }

    public int j() {
        return this.f36332g;
    }

    public FieldType k() {
        return this.f36328b;
    }

    public boolean l() {
        return this.f36334i;
    }

    public boolean m() {
        return this.f36333h;
    }
}
