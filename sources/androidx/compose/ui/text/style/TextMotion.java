package androidx.compose.ui.text.style;

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
public final class TextMotion {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f29651c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final TextMotion f29652d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final TextMotion f29653e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f29654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f29655b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TextMotion a() {
            return TextMotion.f29652d;
        }

        private Companion() {
        }
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        f29651c = new Companion(defaultConstructorMarker);
        Linearity.Companion companion = Linearity.f29656b;
        f29652d = new TextMotion(companion.a(), false, defaultConstructorMarker);
        f29653e = new TextMotion(companion.b(), true, defaultConstructorMarker);
    }

    public /* synthetic */ TextMotion(int i3, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, z2);
    }

    public final int b() {
        return this.f29654a;
    }

    public final boolean c() {
        return this.f29655b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextMotion)) {
            return false;
        }
        TextMotion textMotion = (TextMotion) obj;
        return Linearity.g(this.f29654a, textMotion.f29654a) && this.f29655b == textMotion.f29655b;
    }

    public int hashCode() {
        return (Linearity.h(this.f29654a) * 31) + Boolean.hashCode(this.f29655b);
    }

    public String toString() {
        return Intrinsics.areEqual(this, f29652d) ? "TextMotion.Static" : Intrinsics.areEqual(this, f29653e) ? "TextMotion.Animated" : "Invalid";
    }

    private TextMotion(int i3, boolean z2) {
        this.f29654a = i3;
        this.f29655b = z2;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @JvmInline
    public static final class Linearity {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Companion f29656b = new Companion(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final int f29657c = e(1);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final int f29658d = e(2);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final int f29659e = e(3);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f29660a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int a() {
                return Linearity.f29658d;
            }

            public final int b() {
                return Linearity.f29657c;
            }

            public final int c() {
                return Linearity.f29659e;
            }

            private Companion() {
            }
        }

        private /* synthetic */ Linearity(int i3) {
            this.f29660a = i3;
        }

        public static final /* synthetic */ Linearity d(int i3) {
            return new Linearity(i3);
        }

        public static boolean f(int i3, Object obj) {
            return (obj instanceof Linearity) && i3 == ((Linearity) obj).j();
        }

        public static final boolean g(int i3, int i4) {
            return i3 == i4;
        }

        public static int h(int i3) {
            return Integer.hashCode(i3);
        }

        public static String i(int i3) {
            return g(i3, f29657c) ? "Linearity.Linear" : g(i3, f29658d) ? "Linearity.FontHinting" : g(i3, f29659e) ? "Linearity.None" : "Invalid";
        }

        public boolean equals(Object obj) {
            return f(this.f29660a, obj);
        }

        public int hashCode() {
            return h(this.f29660a);
        }

        public final /* synthetic */ int j() {
            return this.f29660a;
        }

        public String toString() {
            return i(this.f29660a);
        }

        private static int e(int i3) {
            return i3;
        }
    }
}
