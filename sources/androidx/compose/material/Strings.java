package androidx.compose.material;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@JvmInline
public final class Strings {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f14174b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f14175c = h(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f14176d = h(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f14177e = h(2);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f14178f = h(3);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f14179g = h(4);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f14180h = h(5);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f14181i = h(6);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f14182a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return Strings.f14176d;
        }

        public final int b() {
            return Strings.f14177e;
        }

        public final int c() {
            return Strings.f14178f;
        }

        public final int d() {
            return Strings.f14179g;
        }

        public final int e() {
            return Strings.f14175c;
        }

        public final int f() {
            return Strings.f14181i;
        }

        public final int g() {
            return Strings.f14180h;
        }

        private Companion() {
        }
    }

    public static boolean i(int i3, Object obj) {
        return (obj instanceof Strings) && i3 == ((Strings) obj).m();
    }

    public static final boolean j(int i3, int i4) {
        return i3 == i4;
    }

    public static int k(int i3) {
        return Integer.hashCode(i3);
    }

    public static String l(int i3) {
        return "Strings(value=" + i3 + ')';
    }

    public boolean equals(Object obj) {
        return i(this.f14182a, obj);
    }

    public int hashCode() {
        return k(this.f14182a);
    }

    public final /* synthetic */ int m() {
        return this.f14182a;
    }

    public String toString() {
        return l(this.f14182a);
    }

    private static int h(int i3) {
        return i3;
    }
}
