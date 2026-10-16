package androidx.datastore.preferences.protobuf;

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
/* JADX INFO: loaded from: classes3.dex */
public final class JavaType {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final JavaType f36463d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final JavaType f36464f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final JavaType f36465g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final JavaType f36466h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final JavaType f36467i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final JavaType f36468j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final JavaType f36469k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final JavaType f36470l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final JavaType f36471m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final JavaType f36472n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final /* synthetic */ JavaType[] f36473o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class f36474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class f36475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f36476c;

    static {
        JavaType javaType = new JavaType("VOID", 0, Void.class, Void.class, null);
        f36463d = javaType;
        Class cls = Integer.TYPE;
        JavaType javaType2 = new JavaType("INT", 1, cls, Integer.class, 0);
        f36464f = javaType2;
        JavaType javaType3 = new JavaType("LONG", 2, Long.TYPE, Long.class, 0L);
        f36465g = javaType3;
        JavaType javaType4 = new JavaType("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        f36466h = javaType4;
        JavaType javaType5 = new JavaType("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        f36467i = javaType5;
        JavaType javaType6 = new JavaType("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        f36468j = javaType6;
        JavaType javaType7 = new JavaType("STRING", 6, String.class, String.class, "");
        f36469k = javaType7;
        JavaType javaType8 = new JavaType("BYTE_STRING", 7, ByteString.class, ByteString.class, ByteString.f36020b);
        f36470l = javaType8;
        JavaType javaType9 = new JavaType("ENUM", 8, cls, Integer.class, null);
        f36471m = javaType9;
        JavaType javaType10 = new JavaType("MESSAGE", 9, Object.class, Object.class, null);
        f36472n = javaType10;
        f36473o = new JavaType[]{javaType, javaType2, javaType3, javaType4, javaType5, javaType6, javaType7, javaType8, javaType9, javaType10};
    }

    private JavaType(String str, int i3, Class cls, Class cls2, Object obj) {
        this.f36474a = cls;
        this.f36475b = cls2;
        this.f36476c = obj;
    }

    public static JavaType valueOf(String str) {
        return (JavaType) java.lang.Enum.valueOf(JavaType.class, str);
    }

    public static JavaType[] values() {
        return (JavaType[]) f36473o.clone();
    }

    public Class a() {
        return this.f36475b;
    }
}
