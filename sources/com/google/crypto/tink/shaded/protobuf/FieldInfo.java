package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.Internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@CheckReturnValue
final class FieldInfo implements Comparable<FieldInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final java.lang.reflect.Field f86846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FieldType f86847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Class f86848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f86849d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final java.lang.reflect.Field f86850f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f86851g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f86852h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f86853i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final OneofInfo f86854j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final java.lang.reflect.Field f86855k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Class f86856l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Object f86857m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Internal.EnumVerifier f86858n;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.FieldInfo$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f86859a;

        static {
            int[] iArr = new int[FieldType.values().length];
            f86859a = iArr;
            try {
                iArr[FieldType.f86884p.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f86859a[FieldType.f86892x.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f86859a[FieldType.H.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f86859a[FieldType.f86870d0.ordinal()] = 4;
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
        return this.f86849d - fieldInfo.f86849d;
    }

    public java.lang.reflect.Field b() {
        return this.f86855k;
    }

    public Internal.EnumVerifier c() {
        return this.f86858n;
    }

    public java.lang.reflect.Field d() {
        return this.f86846a;
    }

    public int e() {
        return this.f86849d;
    }

    public Object f() {
        return this.f86857m;
    }

    public Class g() {
        int i3 = AnonymousClass1.f86859a[this.f86847b.ordinal()];
        if (i3 == 1 || i3 == 2) {
            java.lang.reflect.Field field = this.f86846a;
            return field != null ? field.getType() : this.f86856l;
        }
        if (i3 == 3 || i3 == 4) {
            return this.f86848c;
        }
        return null;
    }

    public OneofInfo h() {
        return this.f86854j;
    }

    public java.lang.reflect.Field i() {
        return this.f86850f;
    }

    public int j() {
        return this.f86851g;
    }

    public FieldType k() {
        return this.f86847b;
    }

    public boolean l() {
        return this.f86853i;
    }

    public boolean m() {
        return this.f86852h;
    }
}
