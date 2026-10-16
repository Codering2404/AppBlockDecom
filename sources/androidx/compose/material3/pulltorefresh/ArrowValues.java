package androidx.compose.material3.pulltorefresh;

import kotlin.Metadata;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class ArrowValues {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f22199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f22200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f22201c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f22202d;

    public ArrowValues(float f3, float f4, float f5, float f6) {
        this.f22199a = f3;
        this.f22200b = f4;
        this.f22201c = f5;
        this.f22202d = f6;
    }

    public final float a() {
        return this.f22201c;
    }

    public final float b() {
        return this.f22199a;
    }

    public final float c() {
        return this.f22202d;
    }

    public final float d() {
        return this.f22200b;
    }
}
