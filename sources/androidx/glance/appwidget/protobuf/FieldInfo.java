package androidx.glance.appwidget.protobuf;

import androidx.glance.appwidget.protobuf.Internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class FieldInfo implements Comparable<FieldInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final java.lang.reflect.Field f38985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FieldType f38986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Class f38987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f38988d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final java.lang.reflect.Field f38989f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f38990g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f38991h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f38992i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final OneofInfo f38993j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final java.lang.reflect.Field f38994k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Class f38995l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Object f38996m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Internal.EnumVerifier f38997n;

    /* JADX INFO: renamed from: androidx.glance.appwidget.protobuf.FieldInfo$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f38998a;

        static {
            int[] iArr = new int[FieldType.values().length];
            f38998a = iArr;
            try {
                iArr[FieldType.f39023p.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f38998a[FieldType.f39031x.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f38998a[FieldType.H.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f38998a[FieldType.f39009d0.ordinal()] = 4;
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
        return this.f38988d - fieldInfo.f38988d;
    }

    public java.lang.reflect.Field b() {
        return this.f38994k;
    }

    public Internal.EnumVerifier c() {
        return this.f38997n;
    }

    public java.lang.reflect.Field d() {
        return this.f38985a;
    }

    public int e() {
        return this.f38988d;
    }

    public Object f() {
        return this.f38996m;
    }

    public Class g() {
        int i3 = AnonymousClass1.f38998a[this.f38986b.ordinal()];
        if (i3 == 1 || i3 == 2) {
            java.lang.reflect.Field field = this.f38985a;
            return field != null ? field.getType() : this.f38995l;
        }
        if (i3 == 3 || i3 == 4) {
            return this.f38987c;
        }
        return null;
    }

    public OneofInfo h() {
        return this.f38993j;
    }

    public java.lang.reflect.Field i() {
        return this.f38989f;
    }

    public int j() {
        return this.f38990g;
    }

    public FieldType k() {
        return this.f38986b;
    }

    public boolean l() {
        return this.f38992i;
    }

    public boolean m() {
        return this.f38991h;
    }
}
