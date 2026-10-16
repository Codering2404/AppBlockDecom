package androidx.glance.color;

import androidx.glance.unit.ColorProvider;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class ColorProvidersKt {
    public static final ColorProviders a(ColorProvider colorProvider, ColorProvider colorProvider2, ColorProvider colorProvider3, ColorProvider colorProvider4, ColorProvider colorProvider5, ColorProvider colorProvider6, ColorProvider colorProvider7, ColorProvider colorProvider8, ColorProvider colorProvider9, ColorProvider colorProvider10, ColorProvider colorProvider11, ColorProvider colorProvider12, ColorProvider colorProvider13, ColorProvider colorProvider14, ColorProvider colorProvider15, ColorProvider colorProvider16, ColorProvider colorProvider17, ColorProvider colorProvider18, ColorProvider colorProvider19, ColorProvider colorProvider20, ColorProvider colorProvider21, ColorProvider colorProvider22, ColorProvider colorProvider23, ColorProvider colorProvider24, ColorProvider colorProvider25, ColorProvider colorProvider26) {
        return new CustomColorProviders(colorProvider, colorProvider2, colorProvider3, colorProvider4, colorProvider5, colorProvider6, colorProvider7, colorProvider8, colorProvider9, colorProvider10, colorProvider11, colorProvider12, colorProvider13, colorProvider14, colorProvider15, colorProvider16, colorProvider17, colorProvider18, colorProvider19, colorProvider20, colorProvider21, colorProvider22, colorProvider23, colorProvider24, colorProvider25, colorProvider26);
    }
}
