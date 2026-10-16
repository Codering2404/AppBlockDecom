package coil.decode;

import coil.decode.ImageSource;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class ResourceMetadata extends ImageSource.Metadata {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f55733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f55734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f55735c;

    public ResourceMetadata(String str, int i3, int i4) {
        this.f55733a = str;
        this.f55734b = i3;
        this.f55735c = i4;
    }

    public final int a() {
        return this.f55735c;
    }
}
