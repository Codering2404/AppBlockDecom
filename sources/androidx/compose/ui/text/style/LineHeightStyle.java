package androidx.compose.ui.text.style;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class LineHeightStyle {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f29591d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final LineHeightStyle f29592e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f29593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f29594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f29595c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @JvmInline
    public static final class Alignment {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Companion f29596b = new Companion(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final float f29597c = d(0.0f);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final float f29598d = d(0.5f);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final float f29599e = d(-1.0f);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final float f29600f = d(1.0f);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f29601a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final float a() {
                return Alignment.f29598d;
            }

            public final float b() {
                return Alignment.f29599e;
            }

            private Companion() {
            }
        }

        private /* synthetic */ Alignment(float f3) {
            this.f29601a = f3;
        }

        public static final /* synthetic */ Alignment c(float f3) {
            return new Alignment(f3);
        }

        public static float d(float f3) {
            if (!((0.0f <= f3 && f3 <= 1.0f) || f3 == -1.0f)) {
                InlineClassHelperKt.c("topRatio should be in [0..1] range or -1");
            }
            return f3;
        }

        public static boolean e(float f3, Object obj) {
            return (obj instanceof Alignment) && Float.compare(f3, ((Alignment) obj).i()) == 0;
        }

        public static final boolean f(float f3, float f4) {
            return Float.compare(f3, f4) == 0;
        }

        public static int g(float f3) {
            return Float.hashCode(f3);
        }

        public static String h(float f3) {
            if (f3 == f29597c) {
                return "LineHeightStyle.Alignment.Top";
            }
            if (f3 == f29598d) {
                return "LineHeightStyle.Alignment.Center";
            }
            if (f3 == f29599e) {
                return "LineHeightStyle.Alignment.Proportional";
            }
            if (f3 == f29600f) {
                return "LineHeightStyle.Alignment.Bottom";
            }
            return "LineHeightStyle.Alignment(topPercentage = " + f3 + ')';
        }

        public boolean equals(Object obj) {
            return e(this.f29601a, obj);
        }

        public int hashCode() {
            return g(this.f29601a);
        }

        public final /* synthetic */ float i() {
            return this.f29601a;
        }

        public String toString() {
            return h(this.f29601a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LineHeightStyle a() {
            return LineHeightStyle.f29592e;
        }

        private Companion() {
        }
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        f29591d = new Companion(defaultConstructorMarker);
        f29592e = new LineHeightStyle(Alignment.f29596b.b(), Trim.f29606b.a(), Mode.f29602b.a(), defaultConstructorMarker);
    }

    public /* synthetic */ LineHeightStyle(float f3, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f3, i3, i4);
    }

    public final float b() {
        return this.f29593a;
    }

    public final int c() {
        return this.f29595c;
    }

    public final int d() {
        return this.f29594b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LineHeightStyle)) {
            return false;
        }
        LineHeightStyle lineHeightStyle = (LineHeightStyle) obj;
        return Alignment.f(this.f29593a, lineHeightStyle.f29593a) && Trim.f(this.f29594b, lineHeightStyle.f29594b) && Mode.f(this.f29595c, lineHeightStyle.f29595c);
    }

    public int hashCode() {
        return (((Alignment.g(this.f29593a) * 31) + Trim.g(this.f29594b)) * 31) + Mode.g(this.f29595c);
    }

    public String toString() {
        return "LineHeightStyle(alignment=" + ((Object) Alignment.h(this.f29593a)) + ", trim=" + ((Object) Trim.j(this.f29594b)) + ",mode=" + ((Object) Mode.h(this.f29595c)) + ')';
    }

    public /* synthetic */ LineHeightStyle(float f3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(f3, i3);
    }

    private LineHeightStyle(float f3, int i3, int i4) {
        this.f29593a = f3;
        this.f29594b = i3;
        this.f29595c = i4;
    }

    private LineHeightStyle(float f3, int i3) {
        this(f3, i3, Mode.f29602b.a(), null);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @JvmInline
    public static final class Mode {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Companion f29602b = new Companion(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final int f29603c = d(0);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final int f29604d = d(1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f29605a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int a() {
                return Mode.f29603c;
            }

            public final int b() {
                return Mode.f29604d;
            }

            private Companion() {
            }
        }

        private /* synthetic */ Mode(int i3) {
            this.f29605a = i3;
        }

        public static final /* synthetic */ Mode c(int i3) {
            return new Mode(i3);
        }

        public static boolean e(int i3, Object obj) {
            return (obj instanceof Mode) && i3 == ((Mode) obj).i();
        }

        public static final boolean f(int i3, int i4) {
            return i3 == i4;
        }

        public static int g(int i3) {
            return Integer.hashCode(i3);
        }

        public static String h(int i3) {
            return "Mode(value=" + i3 + ')';
        }

        public boolean equals(Object obj) {
            return e(this.f29605a, obj);
        }

        public int hashCode() {
            return g(this.f29605a);
        }

        public final /* synthetic */ int i() {
            return this.f29605a;
        }

        public String toString() {
            return h(this.f29605a);
        }

        private static int d(int i3) {
            return i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @JvmInline
    public static final class Trim {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Companion f29606b = new Companion(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final int f29607c = d(1);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final int f29608d = d(16);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final int f29609e = d(17);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final int f29610f = d(0);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f29611a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int a() {
                return Trim.f29609e;
            }

            public final int b() {
                return Trim.f29610f;
            }

            private Companion() {
            }
        }

        private /* synthetic */ Trim(int i3) {
            this.f29611a = i3;
        }

        public static final /* synthetic */ Trim c(int i3) {
            return new Trim(i3);
        }

        public static boolean e(int i3, Object obj) {
            return (obj instanceof Trim) && i3 == ((Trim) obj).k();
        }

        public static final boolean f(int i3, int i4) {
            return i3 == i4;
        }

        public static int g(int i3) {
            return Integer.hashCode(i3);
        }

        public static final boolean h(int i3) {
            return (i3 & 1) > 0;
        }

        public static final boolean i(int i3) {
            return (i3 & 16) > 0;
        }

        public static String j(int i3) {
            return i3 == f29607c ? "LineHeightStyle.Trim.FirstLineTop" : i3 == f29608d ? "LineHeightStyle.Trim.LastLineBottom" : i3 == f29609e ? "LineHeightStyle.Trim.Both" : i3 == f29610f ? "LineHeightStyle.Trim.None" : "Invalid";
        }

        public boolean equals(Object obj) {
            return e(this.f29611a, obj);
        }

        public int hashCode() {
            return g(this.f29611a);
        }

        public final /* synthetic */ int k() {
            return this.f29611a;
        }

        public String toString() {
            return j(this.f29611a);
        }

        private static int d(int i3) {
            return i3;
        }
    }
}
