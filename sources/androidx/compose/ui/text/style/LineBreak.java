package androidx.compose.ui.text.style;

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
@JvmInline
public final class LineBreak {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f29567b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f29568c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f29569d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f29570e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f29571f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f29572a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return LineBreak.f29568c;
        }

        public final int b() {
            return LineBreak.f29571f;
        }

        private Companion() {
        }
    }

    static {
        Strategy.Companion companion = Strategy.f29573b;
        int iC = companion.c();
        Strictness.Companion companion2 = Strictness.f29579b;
        int iC2 = companion2.c();
        WordBreak.Companion companion3 = WordBreak.f29586b;
        f29568c = d(LineBreak_androidKt.e(iC, iC2, companion3.a()));
        f29569d = d(LineBreak_androidKt.e(companion.a(), companion2.b(), companion3.b()));
        f29570e = d(LineBreak_androidKt.e(companion.b(), companion2.d(), companion3.a()));
        f29571f = d(0);
    }

    private /* synthetic */ LineBreak(int i3) {
        this.f29572a = i3;
    }

    public static final /* synthetic */ LineBreak c(int i3) {
        return new LineBreak(i3);
    }

    public static boolean e(int i3, Object obj) {
        return (obj instanceof LineBreak) && i3 == ((LineBreak) obj).l();
    }

    public static final boolean f(int i3, int i4) {
        return i3 == i4;
    }

    public static final int g(int i3) {
        return Strategy.d(LineBreak_androidKt.f(i3));
    }

    public static final int h(int i3) {
        return Strictness.e(LineBreak_androidKt.g(i3));
    }

    public static final int i(int i3) {
        return WordBreak.c(LineBreak_androidKt.h(i3));
    }

    public static int j(int i3) {
        return Integer.hashCode(i3);
    }

    public static String k(int i3) {
        return "LineBreak(strategy=" + ((Object) Strategy.h(g(i3))) + ", strictness=" + ((Object) Strictness.i(h(i3))) + ", wordBreak=" + ((Object) WordBreak.g(i(i3))) + ')';
    }

    public boolean equals(Object obj) {
        return e(this.f29572a, obj);
    }

    public int hashCode() {
        return j(this.f29572a);
    }

    public final /* synthetic */ int l() {
        return this.f29572a;
    }

    public String toString() {
        return k(this.f29572a);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @JvmInline
    public static final class Strategy {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Companion f29573b = new Companion(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final int f29574c = d(1);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final int f29575d = d(2);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final int f29576e = d(3);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final int f29577f = d(0);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f29578a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int a() {
                return Strategy.f29576e;
            }

            public final int b() {
                return Strategy.f29575d;
            }

            public final int c() {
                return Strategy.f29574c;
            }

            private Companion() {
            }
        }

        public static boolean e(int i3, Object obj) {
            return (obj instanceof Strategy) && i3 == ((Strategy) obj).i();
        }

        public static final boolean f(int i3, int i4) {
            return i3 == i4;
        }

        public static int g(int i3) {
            return Integer.hashCode(i3);
        }

        public static String h(int i3) {
            return f(i3, f29574c) ? "Strategy.Simple" : f(i3, f29575d) ? "Strategy.HighQuality" : f(i3, f29576e) ? "Strategy.Balanced" : f(i3, f29577f) ? "Strategy.Unspecified" : "Invalid";
        }

        public boolean equals(Object obj) {
            return e(this.f29578a, obj);
        }

        public int hashCode() {
            return g(this.f29578a);
        }

        public final /* synthetic */ int i() {
            return this.f29578a;
        }

        public String toString() {
            return h(this.f29578a);
        }

        public static int d(int i3) {
            return i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @JvmInline
    public static final class Strictness {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Companion f29579b = new Companion(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final int f29580c = e(1);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final int f29581d = e(2);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final int f29582e = e(3);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final int f29583f = e(4);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final int f29584g = e(0);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f29585a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int a() {
                return Strictness.f29580c;
            }

            public final int b() {
                return Strictness.f29581d;
            }

            public final int c() {
                return Strictness.f29582e;
            }

            public final int d() {
                return Strictness.f29583f;
            }

            private Companion() {
            }
        }

        public static boolean f(int i3, Object obj) {
            return (obj instanceof Strictness) && i3 == ((Strictness) obj).j();
        }

        public static final boolean g(int i3, int i4) {
            return i3 == i4;
        }

        public static int h(int i3) {
            return Integer.hashCode(i3);
        }

        public static String i(int i3) {
            return g(i3, f29580c) ? "Strictness.None" : g(i3, f29581d) ? "Strictness.Loose" : g(i3, f29582e) ? "Strictness.Normal" : g(i3, f29583f) ? "Strictness.Strict" : g(i3, f29584g) ? "Strictness.Unspecified" : "Invalid";
        }

        public boolean equals(Object obj) {
            return f(this.f29585a, obj);
        }

        public int hashCode() {
            return h(this.f29585a);
        }

        public final /* synthetic */ int j() {
            return this.f29585a;
        }

        public String toString() {
            return i(this.f29585a);
        }

        public static int e(int i3) {
            return i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @JvmInline
    public static final class WordBreak {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Companion f29586b = new Companion(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final int f29587c = c(1);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final int f29588d = c(2);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final int f29589e = c(0);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f29590a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int a() {
                return WordBreak.f29587c;
            }

            public final int b() {
                return WordBreak.f29588d;
            }

            private Companion() {
            }
        }

        public static boolean d(int i3, Object obj) {
            return (obj instanceof WordBreak) && i3 == ((WordBreak) obj).h();
        }

        public static final boolean e(int i3, int i4) {
            return i3 == i4;
        }

        public static int f(int i3) {
            return Integer.hashCode(i3);
        }

        public static String g(int i3) {
            return e(i3, f29587c) ? "WordBreak.None" : e(i3, f29588d) ? "WordBreak.Phrase" : e(i3, f29589e) ? "WordBreak.Unspecified" : "Invalid";
        }

        public boolean equals(Object obj) {
            return d(this.f29590a, obj);
        }

        public final /* synthetic */ int h() {
            return this.f29590a;
        }

        public int hashCode() {
            return f(this.f29590a);
        }

        public String toString() {
            return g(this.f29590a);
        }

        public static int c(int i3) {
            return i3;
        }
    }

    public static int d(int i3) {
        return i3;
    }
}
