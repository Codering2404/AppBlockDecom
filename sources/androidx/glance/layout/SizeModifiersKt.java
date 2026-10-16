package androidx.glance.layout;

import androidx.glance.GlanceModifier;
import androidx.glance.unit.Dimension;
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
public final class SizeModifiersKt {
    public static final GlanceModifier a(GlanceModifier glanceModifier) {
        return glanceModifier.a(new HeightModifier(Dimension.Fill.f39788a));
    }

    public static final GlanceModifier b(GlanceModifier glanceModifier) {
        return a(c(glanceModifier));
    }

    public static final GlanceModifier c(GlanceModifier glanceModifier) {
        return glanceModifier.a(new WidthModifier(Dimension.Fill.f39788a));
    }

    public static final GlanceModifier d(GlanceModifier glanceModifier, float f3) {
        return glanceModifier.a(new HeightModifier(new Dimension.Dp(f3, null)));
    }

    public static final GlanceModifier e(GlanceModifier glanceModifier, float f3) {
        return d(f(glanceModifier, f3), f3);
    }

    public static final GlanceModifier f(GlanceModifier glanceModifier, float f3) {
        return glanceModifier.a(new WidthModifier(new Dimension.Dp(f3, null)));
    }

    public static final GlanceModifier g(GlanceModifier glanceModifier) {
        return glanceModifier.a(new HeightModifier(Dimension.Wrap.f39790a));
    }
}
