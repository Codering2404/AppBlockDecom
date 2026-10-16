package androidx.compose.ui.draw;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
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
public final class PainterModifierKt {
    public static final Modifier a(Modifier modifier, Painter painter, boolean z2, Alignment alignment, ContentScale contentScale, float f3, ColorFilter colorFilter) {
        return modifier.then(new PainterElement(painter, z2, alignment, contentScale, f3, colorFilter));
    }

    public static /* synthetic */ Modifier b(Modifier modifier, Painter painter, boolean z2, Alignment alignment, ContentScale contentScale, float f3, ColorFilter colorFilter, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = true;
        }
        boolean z3 = z2;
        if ((i3 & 4) != 0) {
            alignment = Alignment.f25072a.e();
        }
        Alignment alignment2 = alignment;
        if ((i3 & 8) != 0) {
            contentScale = ContentScale.f27054a.f();
        }
        ContentScale contentScale2 = contentScale;
        if ((i3 & 16) != 0) {
            f3 = 1.0f;
        }
        float f4 = f3;
        if ((i3 & 32) != 0) {
            colorFilter = null;
        }
        return a(modifier, painter, z3, alignment2, contentScale2, f4, colorFilter);
    }
}
