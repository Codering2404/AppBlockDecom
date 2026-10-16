package androidx.glance.text;

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
public final class TextAlign {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f39751b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f39752c = g(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f39753d = g(2);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f39754e = g(3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f39755f = g(4);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f39756g = g(5);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f39757a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return TextAlign.f39754e;
        }

        public final int b() {
            return TextAlign.f39756g;
        }

        public final int c() {
            return TextAlign.f39752c;
        }

        public final int d() {
            return TextAlign.f39753d;
        }

        public final int e() {
            return TextAlign.f39755f;
        }

        private Companion() {
        }
    }

    private /* synthetic */ TextAlign(int i3) {
        this.f39757a = i3;
    }

    public static final /* synthetic */ TextAlign f(int i3) {
        return new TextAlign(i3);
    }

    public static boolean h(int i3, Object obj) {
        return (obj instanceof TextAlign) && i3 == ((TextAlign) obj).l();
    }

    public static final boolean i(int i3, int i4) {
        return i3 == i4;
    }

    public static int j(int i3) {
        return Integer.hashCode(i3);
    }

    public static String k(int i3) {
        return i(i3, f39752c) ? "Left" : i(i3, f39753d) ? "Right" : i(i3, f39754e) ? "Center" : i(i3, f39755f) ? "Start" : i(i3, f39756g) ? "End" : "Invalid";
    }

    public boolean equals(Object obj) {
        return h(this.f39757a, obj);
    }

    public int hashCode() {
        return j(this.f39757a);
    }

    public final /* synthetic */ int l() {
        return this.f39757a;
    }

    public String toString() {
        return k(this.f39757a);
    }

    public static int g(int i3) {
        return i3;
    }
}
