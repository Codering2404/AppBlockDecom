package androidx.glance.appwidget.protobuf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class WireFormat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f39324a = c(1, 3);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final int f39325b = c(1, 4);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final int f39326c = c(2, 0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int f39327d = c(3, 2);

    /* JADX INFO: renamed from: androidx.glance.appwidget.protobuf.WireFormat$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f39328a;

        static {
            int[] iArr = new int[FieldType.values().length];
            f39328a = iArr;
            try {
                iArr[FieldType.f39329c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f39328a[FieldType.f39330d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f39328a[FieldType.f39331f.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f39328a[FieldType.f39332g.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f39328a[FieldType.f39333h.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f39328a[FieldType.f39334i.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f39328a[FieldType.f39335j.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f39328a[FieldType.f39336k.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f39328a[FieldType.f39340o.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f39328a[FieldType.f39341p.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f39328a[FieldType.f39343r.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f39328a[FieldType.f39344s.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f39328a[FieldType.f39345t.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f39328a[FieldType.f39346u.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f39328a[FieldType.f39337l.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f39328a[FieldType.f39338m.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f39328a[FieldType.f39339n.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f39328a[FieldType.f39342q.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

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
    public static class FieldType {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final FieldType f39329c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final FieldType f39330d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final FieldType f39331f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final FieldType f39332g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final FieldType f39333h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final FieldType f39334i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final FieldType f39335j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final FieldType f39336k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final FieldType f39337l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final FieldType f39338m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final FieldType f39339n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final FieldType f39340o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final FieldType f39341p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final FieldType f39342q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final FieldType f39343r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final FieldType f39344s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final FieldType f39345t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final FieldType f39346u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private static final /* synthetic */ FieldType[] f39347v;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final JavaType f39348a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f39349b;

        static {
            FieldType fieldType = new FieldType("DOUBLE", 0, JavaType.DOUBLE, 1);
            f39329c = fieldType;
            FieldType fieldType2 = new FieldType("FLOAT", 1, JavaType.FLOAT, 5);
            f39330d = fieldType2;
            JavaType javaType = JavaType.LONG;
            FieldType fieldType3 = new FieldType("INT64", 2, javaType, 0);
            f39331f = fieldType3;
            FieldType fieldType4 = new FieldType("UINT64", 3, javaType, 0);
            f39332g = fieldType4;
            JavaType javaType2 = JavaType.INT;
            FieldType fieldType5 = new FieldType("INT32", 4, javaType2, 0);
            f39333h = fieldType5;
            FieldType fieldType6 = new FieldType("FIXED64", 5, javaType, 1);
            f39334i = fieldType6;
            FieldType fieldType7 = new FieldType("FIXED32", 6, javaType2, 5);
            f39335j = fieldType7;
            FieldType fieldType8 = new FieldType("BOOL", 7, JavaType.BOOLEAN, 0);
            f39336k = fieldType8;
            FieldType fieldType9 = new FieldType("STRING", 8, JavaType.STRING, 2) { // from class: androidx.glance.appwidget.protobuf.WireFormat.FieldType.1
                {
                    AnonymousClass1 anonymousClass1 = null;
                }
            };
            f39337l = fieldType9;
            JavaType javaType3 = JavaType.MESSAGE;
            FieldType fieldType10 = new FieldType("GROUP", 9, javaType3, 3) { // from class: androidx.glance.appwidget.protobuf.WireFormat.FieldType.2
                {
                    AnonymousClass1 anonymousClass1 = null;
                }
            };
            f39338m = fieldType10;
            int i3 = 2;
            FieldType fieldType11 = new FieldType("MESSAGE", 10, javaType3, i3) { // from class: androidx.glance.appwidget.protobuf.WireFormat.FieldType.3
                {
                    AnonymousClass1 anonymousClass1 = null;
                }
            };
            f39339n = fieldType11;
            FieldType fieldType12 = new FieldType("BYTES", 11, JavaType.BYTE_STRING, i3) { // from class: androidx.glance.appwidget.protobuf.WireFormat.FieldType.4
                {
                    AnonymousClass1 anonymousClass1 = null;
                }
            };
            f39340o = fieldType12;
            FieldType fieldType13 = new FieldType("UINT32", 12, javaType2, 0);
            f39341p = fieldType13;
            FieldType fieldType14 = new FieldType("ENUM", 13, JavaType.ENUM, 0);
            f39342q = fieldType14;
            FieldType fieldType15 = new FieldType("SFIXED32", 14, javaType2, 5);
            f39343r = fieldType15;
            FieldType fieldType16 = new FieldType("SFIXED64", 15, javaType, 1);
            f39344s = fieldType16;
            FieldType fieldType17 = new FieldType("SINT32", 16, javaType2, 0);
            f39345t = fieldType17;
            FieldType fieldType18 = new FieldType("SINT64", 17, javaType, 0);
            f39346u = fieldType18;
            f39347v = new FieldType[]{fieldType, fieldType2, fieldType3, fieldType4, fieldType5, fieldType6, fieldType7, fieldType8, fieldType9, fieldType10, fieldType11, fieldType12, fieldType13, fieldType14, fieldType15, fieldType16, fieldType17, fieldType18};
        }

        /* synthetic */ FieldType(String str, int i3, JavaType javaType, int i4, AnonymousClass1 anonymousClass1) {
            this(str, i3, javaType, i4);
        }

        public static FieldType valueOf(String str) {
            return (FieldType) java.lang.Enum.valueOf(FieldType.class, str);
        }

        public static FieldType[] values() {
            return (FieldType[]) f39347v.clone();
        }

        public JavaType a() {
            return this.f39348a;
        }

        public int b() {
            return this.f39349b;
        }

        private FieldType(String str, int i3, JavaType javaType, int i4) {
            this.f39348a = javaType;
            this.f39349b = i4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum JavaType {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(Boolean.FALSE),
        STRING(""),
        BYTE_STRING(ByteString.f38830b),
        ENUM(null),
        MESSAGE(null);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f39360a;

        JavaType(Object obj) {
            this.f39360a = obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    enum Utf8Validation {
        LOOSE { // from class: androidx.glance.appwidget.protobuf.WireFormat.Utf8Validation.1
        },
        STRICT { // from class: androidx.glance.appwidget.protobuf.WireFormat.Utf8Validation.2
        },
        LAZY { // from class: androidx.glance.appwidget.protobuf.WireFormat.Utf8Validation.3
        };

        /* synthetic */ Utf8Validation(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static int a(int i3) {
        return i3 >>> 3;
    }

    public static int b(int i3) {
        return i3 & 7;
    }

    static int c(int i3, int i4) {
        return (i3 << 3) | i4;
    }
}
