package androidx.window.embedding;

import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class EmbeddingAspectRatio {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f54193c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final EmbeddingAspectRatio f54194d = new EmbeddingAspectRatio("ALWAYS_ALLOW", 0.0f);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final EmbeddingAspectRatio f54195e = new EmbeddingAspectRatio("ALWAYS_DISALLOW", -1.0f);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f54196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f54197b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EmbeddingAspectRatio a(float f3) {
            if (f3 <= 1.0f) {
                throw new IllegalArgumentException("Ratio must be greater than 1.");
            }
            return new EmbeddingAspectRatio("ratio:" + f3, f3, null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ EmbeddingAspectRatio(String str, float f3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, f3);
    }

    public final float a() {
        return this.f54197b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EmbeddingAspectRatio)) {
            return false;
        }
        EmbeddingAspectRatio embeddingAspectRatio = (EmbeddingAspectRatio) obj;
        return this.f54197b == embeddingAspectRatio.f54197b && Intrinsics.areEqual(this.f54196a, embeddingAspectRatio.f54196a);
    }

    public int hashCode() {
        return this.f54196a.hashCode() + (Float.hashCode(this.f54197b) * 31);
    }

    public String toString() {
        return "EmbeddingAspectRatio(" + this.f54196a + ')';
    }

    private EmbeddingAspectRatio(String str, float f3) {
        this.f54196a = str;
        this.f54197b = f3;
    }
}
