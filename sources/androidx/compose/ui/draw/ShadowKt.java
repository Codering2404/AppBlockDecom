package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerScopeKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
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
public final class ShadowKt {
    public static final Modifier a(Modifier modifier, float f3, Shape shape, boolean z2, long j3, long j4) {
        return (Dp.f(f3, Dp.g((float) 0)) > 0 || z2) ? modifier.then(new ShadowGraphicsLayerElement(f3, shape, z2, j3, j4, null)) : modifier;
    }

    public static /* synthetic */ Modifier b(Modifier modifier, float f3, Shape shape, boolean z2, long j3, long j4, int i3, Object obj) {
        boolean z3;
        Shape shapeA = (i3 & 2) != 0 ? RectangleShapeKt.a() : shape;
        if ((i3 & 4) != 0) {
            z3 = false;
            if (Dp.f(f3, Dp.g(0)) > 0) {
                z3 = true;
            }
        } else {
            z3 = z2;
        }
        return a(modifier, f3, shapeA, z3, (i3 & 8) != 0 ? GraphicsLayerScopeKt.a() : j3, (i3 & 16) != 0 ? GraphicsLayerScopeKt.a() : j4);
    }
}
