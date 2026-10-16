package androidx.compose.ui.text.style;

import kotlin.Metadata;
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
public final class TextGeometricTransform {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f29643c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final TextGeometricTransform f29644d = new TextGeometricTransform(1.0f, 0.0f);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f29645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f29646b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TextGeometricTransform a() {
            return TextGeometricTransform.f29644d;
        }

        private Companion() {
        }
    }

    public TextGeometricTransform(float f3, float f4) {
        this.f29645a = f3;
        this.f29646b = f4;
    }

    public final float b() {
        return this.f29645a;
    }

    public final float c() {
        return this.f29646b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextGeometricTransform)) {
            return false;
        }
        TextGeometricTransform textGeometricTransform = (TextGeometricTransform) obj;
        return this.f29645a == textGeometricTransform.f29645a && this.f29646b == textGeometricTransform.f29646b;
    }

    public int hashCode() {
        return (Float.hashCode(this.f29645a) * 31) + Float.hashCode(this.f29646b);
    }

    public String toString() {
        return "TextGeometricTransform(scaleX=" + this.f29645a + ", skewX=" + this.f29646b + ')';
    }
}
