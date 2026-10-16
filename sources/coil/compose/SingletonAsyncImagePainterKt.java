package coil.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.ContentScale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

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
public final class SingletonAsyncImagePainterKt {
    public static final AsyncImagePainter a(Object obj, Function1 function1, Function1 function12, ContentScale contentScale, int i3, Composer composer, int i4, int i5) {
        composer.F(-1494234083);
        Function1 function1A = (i5 & 2) != 0 ? AsyncImagePainter.f55509w.a() : function1;
        Function1 function13 = (i5 & 4) != 0 ? null : function12;
        ContentScale contentScaleE = (i5 & 8) != 0 ? ContentScale.f27054a.e() : contentScale;
        int iB = (i5 & 16) != 0 ? DrawScope.e8.b() : i3;
        if (ComposerKt.M()) {
            ComposerKt.U(-1494234083, i4, -1, "coil.compose.rememberAsyncImagePainter (SingletonAsyncImagePainter.kt:91)");
        }
        int i6 = i4 << 3;
        AsyncImagePainter asyncImagePainterE = AsyncImagePainterKt.e(obj, ImageLoaderProvidableCompositionLocal.d(LocalImageLoaderKt.a(), composer, 6), function1A, function13, contentScaleE, iB, composer, (i6 & 896) | 72 | (i6 & 7168) | (57344 & i6) | (i6 & 458752), 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.Y();
        return asyncImagePainterE;
    }
}
