package androidx.glance.layout;

import android.content.res.Resources;
import androidx.compose.ui.unit.Dp;
import androidx.glance.GlanceModifier;
import java.util.Iterator;
import java.util.List;
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
public final class PaddingKt {
    public static final GlanceModifier b(GlanceModifier glanceModifier, float f3) {
        PaddingDimension paddingDimensionH = h(f3);
        return glanceModifier.a(new PaddingModifier(null, paddingDimensionH, paddingDimensionH, null, paddingDimensionH, paddingDimensionH, 9, null));
    }

    public static final GlanceModifier c(GlanceModifier glanceModifier, float f3, float f4) {
        return glanceModifier.a(new PaddingModifier(null, h(f3), h(f4), null, h(f3), h(f4), 9, null));
    }

    public static /* synthetic */ GlanceModifier d(GlanceModifier glanceModifier, float f3, float f4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f3 = Dp.g(0);
        }
        if ((i3 & 2) != 0) {
            f4 = Dp.g(0);
        }
        return c(glanceModifier, f3, f4);
    }

    public static final GlanceModifier e(GlanceModifier glanceModifier, float f3, float f4, float f5, float f6) {
        return glanceModifier.a(new PaddingModifier(null, h(f3), h(f4), null, h(f5), h(f6), 9, null));
    }

    public static /* synthetic */ GlanceModifier f(GlanceModifier glanceModifier, float f3, float f4, float f5, float f6, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f3 = Dp.g(0);
        }
        if ((i3 & 2) != 0) {
            f4 = Dp.g(0);
        }
        if ((i3 & 4) != 0) {
            f5 = Dp.g(0);
        }
        if ((i3 & 8) != 0) {
            f6 = Dp.g(0);
        }
        return e(glanceModifier, f3, f4, f5, f6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float g(List list, Resources resources) {
        float fG = Dp.g(0);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            fG = Dp.g(fG + Dp.g(resources.getDimension(((Number) it.next()).intValue()) / resources.getDisplayMetrics().density));
        }
        return fG;
    }

    private static final PaddingDimension h(float f3) {
        return new PaddingDimension(f3, null, 2, null);
    }
}
