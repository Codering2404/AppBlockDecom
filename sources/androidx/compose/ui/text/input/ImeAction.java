package androidx.compose.ui.text.input;

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
public final class ImeAction {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f29348b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f29349c = k(-1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f29350d = k(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f29351e = k(0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f29352f = k(2);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f29353g = k(3);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f29354h = k(4);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f29355i = k(5);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f29356j = k(6);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f29357k = k(7);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f29358a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return ImeAction.f29350d;
        }

        public final int b() {
            return ImeAction.f29357k;
        }

        public final int c() {
            return ImeAction.f29352f;
        }

        public final int d() {
            return ImeAction.f29356j;
        }

        public final int e() {
            return ImeAction.f29351e;
        }

        public final int f() {
            return ImeAction.f29355i;
        }

        public final int g() {
            return ImeAction.f29353g;
        }

        public final int h() {
            return ImeAction.f29354h;
        }

        public final int i() {
            return ImeAction.f29349c;
        }

        private Companion() {
        }
    }

    private /* synthetic */ ImeAction(int i3) {
        this.f29358a = i3;
    }

    public static final /* synthetic */ ImeAction j(int i3) {
        return new ImeAction(i3);
    }

    public static boolean l(int i3, Object obj) {
        return (obj instanceof ImeAction) && i3 == ((ImeAction) obj).p();
    }

    public static final boolean m(int i3, int i4) {
        return i3 == i4;
    }

    public static int n(int i3) {
        return Integer.hashCode(i3);
    }

    public static String o(int i3) {
        return m(i3, f29349c) ? "Unspecified" : m(i3, f29351e) ? "None" : m(i3, f29350d) ? "Default" : m(i3, f29352f) ? "Go" : m(i3, f29353g) ? "Search" : m(i3, f29354h) ? "Send" : m(i3, f29355i) ? "Previous" : m(i3, f29356j) ? "Next" : m(i3, f29357k) ? "Done" : "Invalid";
    }

    public boolean equals(Object obj) {
        return l(this.f29358a, obj);
    }

    public int hashCode() {
        return n(this.f29358a);
    }

    public final /* synthetic */ int p() {
        return this.f29358a;
    }

    public String toString() {
        return o(this.f29358a);
    }

    private static int k(int i3) {
        return i3;
    }
}
