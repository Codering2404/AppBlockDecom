package androidx.glance.layout;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class Alignment {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f39415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f39416d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Alignment f39417e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Alignment f39418f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Alignment f39419g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Alignment f39420h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Alignment f39421i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Alignment f39422j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Alignment f39423k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Alignment f39424l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Alignment f39425m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f39426n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f39427o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f39428p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int f39429q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int f39430r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int f39431s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f39432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f39433b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Alignment a() {
            return Alignment.f39423k;
        }

        public final Alignment b() {
            return Alignment.f39421i;
        }

        public final int c() {
            return Alignment.f39430r;
        }

        public final Alignment d() {
            return Alignment.f39420h;
        }

        public final int e() {
            return Alignment.f39427o;
        }

        public final int f() {
            return Alignment.f39429q;
        }

        public final int g() {
            return Alignment.f39426n;
        }

        public final Alignment h() {
            return Alignment.f39419g;
        }

        public final Alignment i() {
            return Alignment.f39417e;
        }

        private Companion() {
        }
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        f39415c = new Companion(defaultConstructorMarker);
        Horizontal.Companion companion = Horizontal.f39434b;
        int iC = companion.c();
        Vertical.Companion companion2 = Vertical.f39439b;
        f39417e = new Alignment(iC, companion2.c(), defaultConstructorMarker);
        f39418f = new Alignment(companion.a(), companion2.c(), defaultConstructorMarker);
        f39419g = new Alignment(companion.b(), companion2.c(), defaultConstructorMarker);
        f39420h = new Alignment(companion.c(), companion2.b(), defaultConstructorMarker);
        f39421i = new Alignment(companion.a(), companion2.b(), defaultConstructorMarker);
        f39422j = new Alignment(companion.b(), companion2.b(), defaultConstructorMarker);
        f39423k = new Alignment(companion.c(), companion2.a(), defaultConstructorMarker);
        f39424l = new Alignment(companion.a(), companion2.a(), defaultConstructorMarker);
        f39425m = new Alignment(companion.b(), companion2.a(), defaultConstructorMarker);
        f39426n = companion2.c();
        f39427o = companion2.b();
        f39428p = companion2.a();
        f39429q = companion.c();
        f39430r = companion.a();
        f39431s = companion.b();
    }

    public /* synthetic */ Alignment(int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(Alignment.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.glance.layout.Alignment");
        Alignment alignment = (Alignment) obj;
        return Horizontal.g(this.f39432a, alignment.f39432a) && Vertical.g(this.f39433b, alignment.f39433b);
    }

    public int hashCode() {
        return (Horizontal.h(this.f39432a) * 31) + Vertical.h(this.f39433b);
    }

    public final int j() {
        return this.f39432a;
    }

    public final int k() {
        return this.f39433b;
    }

    public String toString() {
        return "Alignment(horizontal=" + ((Object) Horizontal.i(this.f39432a)) + ", vertical=" + ((Object) Vertical.i(this.f39433b)) + ')';
    }

    private Alignment(int i3, int i4) {
        this.f39432a = i3;
        this.f39433b = i4;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @JvmInline
    public static final class Horizontal {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Companion f39434b = new Companion(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final int f39435c = e(0);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final int f39436d = e(1);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final int f39437e = e(2);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f39438a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int a() {
                return Horizontal.f39436d;
            }

            public final int b() {
                return Horizontal.f39437e;
            }

            public final int c() {
                return Horizontal.f39435c;
            }

            private Companion() {
            }
        }

        private /* synthetic */ Horizontal(int i3) {
            this.f39438a = i3;
        }

        public static final /* synthetic */ Horizontal d(int i3) {
            return new Horizontal(i3);
        }

        public static boolean f(int i3, Object obj) {
            return (obj instanceof Horizontal) && i3 == ((Horizontal) obj).j();
        }

        public static final boolean g(int i3, int i4) {
            return i3 == i4;
        }

        public static int h(int i3) {
            return Integer.hashCode(i3);
        }

        public static String i(int i3) {
            return "Horizontal(value=" + i3 + ')';
        }

        public boolean equals(Object obj) {
            return f(this.f39438a, obj);
        }

        public int hashCode() {
            return h(this.f39438a);
        }

        public final /* synthetic */ int j() {
            return this.f39438a;
        }

        public String toString() {
            return i(this.f39438a);
        }

        private static int e(int i3) {
            return i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @JvmInline
    public static final class Vertical {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Companion f39439b = new Companion(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final int f39440c = e(0);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final int f39441d = e(1);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final int f39442e = e(2);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f39443a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int a() {
                return Vertical.f39442e;
            }

            public final int b() {
                return Vertical.f39441d;
            }

            public final int c() {
                return Vertical.f39440c;
            }

            private Companion() {
            }
        }

        private /* synthetic */ Vertical(int i3) {
            this.f39443a = i3;
        }

        public static final /* synthetic */ Vertical d(int i3) {
            return new Vertical(i3);
        }

        public static boolean f(int i3, Object obj) {
            return (obj instanceof Vertical) && i3 == ((Vertical) obj).j();
        }

        public static final boolean g(int i3, int i4) {
            return i3 == i4;
        }

        public static int h(int i3) {
            return Integer.hashCode(i3);
        }

        public static String i(int i3) {
            return "Vertical(value=" + i3 + ')';
        }

        public boolean equals(Object obj) {
            return f(this.f39443a, obj);
        }

        public int hashCode() {
            return h(this.f39443a);
        }

        public final /* synthetic */ int j() {
            return this.f39443a;
        }

        public String toString() {
            return i(this.f39443a);
        }

        private static int e(int i3) {
            return i3;
        }
    }
}
