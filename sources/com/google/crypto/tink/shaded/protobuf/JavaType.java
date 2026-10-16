package com.google.crypto.tink.shaded.protobuf;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'f' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class JavaType {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final JavaType f86969d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final JavaType f86970f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final JavaType f86971g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final JavaType f86972h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final JavaType f86973i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final JavaType f86974j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final JavaType f86975k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final JavaType f86976l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final JavaType f86977m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final JavaType f86978n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final /* synthetic */ JavaType[] f86979o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class f86980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class f86981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f86982c;

    static {
        JavaType javaType = new JavaType("VOID", 0, Void.class, Void.class, null);
        f86969d = javaType;
        Class cls = Integer.TYPE;
        JavaType javaType2 = new JavaType("INT", 1, cls, Integer.class, 0);
        f86970f = javaType2;
        JavaType javaType3 = new JavaType("LONG", 2, Long.TYPE, Long.class, 0L);
        f86971g = javaType3;
        JavaType javaType4 = new JavaType("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        f86972h = javaType4;
        JavaType javaType5 = new JavaType("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        f86973i = javaType5;
        JavaType javaType6 = new JavaType("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        f86974j = javaType6;
        JavaType javaType7 = new JavaType("STRING", 6, String.class, String.class, "");
        f86975k = javaType7;
        JavaType javaType8 = new JavaType("BYTE_STRING", 7, ByteString.class, ByteString.class, ByteString.f86695b);
        f86976l = javaType8;
        JavaType javaType9 = new JavaType("ENUM", 8, cls, Integer.class, null);
        f86977m = javaType9;
        JavaType javaType10 = new JavaType("MESSAGE", 9, Object.class, Object.class, null);
        f86978n = javaType10;
        f86979o = new JavaType[]{javaType, javaType2, javaType3, javaType4, javaType5, javaType6, javaType7, javaType8, javaType9, javaType10};
    }

    private JavaType(String str, int i3, Class cls, Class cls2, Object obj) {
        this.f86980a = cls;
        this.f86981b = cls2;
        this.f86982c = obj;
    }

    public static JavaType valueOf(String str) {
        return (JavaType) java.lang.Enum.valueOf(JavaType.class, str);
    }

    public static JavaType[] values() {
        return (JavaType[]) f86979o.clone();
    }

    public Class a() {
        return this.f86981b;
    }
}
