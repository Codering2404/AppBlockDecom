package androidx.compose.ui.unit;

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
public final class Dp implements Comparable<Dp> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f29970b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f29971c = g(0.0f);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f29972d = g(Float.POSITIVE_INFINITY);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f29973f = g(Float.NaN);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f29974a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final float a() {
            return Dp.f29971c;
        }

        public final float b() {
            return Dp.f29972d;
        }

        public final float c() {
            return Dp.f29973f;
        }

        private Companion() {
        }
    }

    private /* synthetic */ Dp(float f3) {
        this.f29974a = f3;
    }

    public static final /* synthetic */ Dp d(float f3) {
        return new Dp(f3);
    }

    public static int f(float f3, float f4) {
        return Float.compare(f3, f4);
    }

    public static boolean h(float f3, Object obj) {
        return (obj instanceof Dp) && Float.compare(f3, ((Dp) obj).l()) == 0;
    }

    public static final boolean i(float f3, float f4) {
        return Float.compare(f3, f4) == 0;
    }

    public static int j(float f3) {
        return Float.hashCode(f3);
    }

    public static String k(float f3) {
        if (Float.isNaN(f3)) {
            return "Dp.Unspecified";
        }
        return f3 + ".dp";
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Dp dp) {
        return e(dp.l());
    }

    public int e(float f3) {
        return f(this.f29974a, f3);
    }

    public boolean equals(Object obj) {
        return h(this.f29974a, obj);
    }

    public int hashCode() {
        return j(this.f29974a);
    }

    public final /* synthetic */ float l() {
        return this.f29974a;
    }

    public String toString() {
        return k(this.f29974a);
    }

    public static float g(float f3) {
        return f3;
    }
}
