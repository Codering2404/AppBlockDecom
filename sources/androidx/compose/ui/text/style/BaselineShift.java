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
public final class BaselineShift {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f29554b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f29555c = e(0.5f);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f29556d = e(-0.5f);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f29557e = e(0.0f);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f29558a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final float a() {
            return BaselineShift.f29557e;
        }

        public final float b() {
            return BaselineShift.f29556d;
        }

        public final float c() {
            return BaselineShift.f29555c;
        }

        private Companion() {
        }
    }

    private /* synthetic */ BaselineShift(float f3) {
        this.f29558a = f3;
    }

    public static final /* synthetic */ BaselineShift d(float f3) {
        return new BaselineShift(f3);
    }

    public static boolean f(float f3, Object obj) {
        return (obj instanceof BaselineShift) && Float.compare(f3, ((BaselineShift) obj).j()) == 0;
    }

    public static final boolean g(float f3, float f4) {
        return Float.compare(f3, f4) == 0;
    }

    public static int h(float f3) {
        return Float.hashCode(f3);
    }

    public static String i(float f3) {
        return "BaselineShift(multiplier=" + f3 + ')';
    }

    public boolean equals(Object obj) {
        return f(this.f29558a, obj);
    }

    public int hashCode() {
        return h(this.f29558a);
    }

    public final /* synthetic */ float j() {
        return this.f29558a;
    }

    public String toString() {
        return i(this.f29558a);
    }

    public static float e(float f3) {
        return f3;
    }
}
