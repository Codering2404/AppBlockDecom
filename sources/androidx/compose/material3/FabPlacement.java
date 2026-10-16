package androidx.compose.material3;

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
public final class FabPlacement {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f17742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f17743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f17744c;

    public FabPlacement(int i3, int i4, int i5) {
        this.f17742a = i3;
        this.f17743b = i4;
        this.f17744c = i5;
    }

    public final int a() {
        return this.f17744c;
    }

    public final int b() {
        return this.f17742a;
    }
}
