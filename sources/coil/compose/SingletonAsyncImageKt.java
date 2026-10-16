package coil.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
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
public final class SingletonAsyncImageKt {
    public static final void a(Object obj, String str, Modifier modifier, Function1 function1, Function1 function12, Alignment alignment, ContentScale contentScale, float f3, ColorFilter colorFilter, int i3, Composer composer, int i4, int i5) {
        composer.F(-941517612);
        Modifier modifier2 = (i5 & 4) != 0 ? Modifier.b8 : modifier;
        Function1 function1A = (i5 & 8) != 0 ? AsyncImagePainter.f55509w.a() : function1;
        Function1 function13 = (i5 & 16) != 0 ? null : function12;
        Alignment alignmentE = (i5 & 32) != 0 ? Alignment.f25072a.e() : alignment;
        ContentScale contentScaleE = (i5 & 64) != 0 ? ContentScale.f27054a.e() : contentScale;
        float f4 = (i5 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? 1.0f : f3;
        ColorFilter colorFilter2 = (i5 & Function.MAX_NARGS) == 0 ? colorFilter : null;
        int iB = (i5 & 512) != 0 ? DrawScope.e8.b() : i3;
        if (ComposerKt.M()) {
            ComposerKt.U(-941517612, i4, -1, "coil.compose.AsyncImage (SingletonAsyncImage.kt:102)");
        }
        int i6 = i4 << 3;
        float f5 = f4;
        ColorFilter colorFilter3 = colorFilter2;
        AsyncImageKt.a(obj, str, ImageLoaderProvidableCompositionLocal.d(LocalImageLoaderKt.a(), composer, 6), modifier2, function1A, function13, alignmentE, contentScaleE, f5, colorFilter3, iB, composer, (i6 & 1879048192) | (i4 & 112) | 520 | (i6 & 7168) | (57344 & i6) | (458752 & i6) | (3670016 & i6) | (29360128 & i6) | (234881024 & i6), (i4 >> 27) & 14, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.Y();
    }

    public static final void b(Object obj, String str, Modifier modifier, Painter painter, Painter painter2, Painter painter3, Function1 function1, Function1 function12, Function1 function13, Alignment alignment, ContentScale contentScale, float f3, ColorFilter colorFilter, int i3, Composer composer, int i4, int i5, int i6) {
        composer.F(2027616330);
        Modifier modifier2 = (i6 & 4) != 0 ? Modifier.b8 : modifier;
        Painter painter4 = (i6 & 8) != 0 ? null : painter;
        Painter painter5 = (i6 & 16) != 0 ? null : painter2;
        Painter painter6 = (i6 & 32) != 0 ? painter5 : painter3;
        Function1 function14 = (i6 & 64) != 0 ? null : function1;
        Function1 function15 = (i6 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : function12;
        Function1 function16 = (i6 & Function.MAX_NARGS) != 0 ? null : function13;
        Alignment alignmentE = (i6 & 512) != 0 ? Alignment.f25072a.e() : alignment;
        ContentScale contentScaleE = (i6 & 1024) != 0 ? ContentScale.f27054a.e() : contentScale;
        float f4 = (i6 & 2048) != 0 ? 1.0f : f3;
        ColorFilter colorFilter2 = (i6 & 4096) != 0 ? null : colorFilter;
        int iB = (i6 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? DrawScope.e8.b() : i3;
        if (ComposerKt.M()) {
            ComposerKt.U(2027616330, i4, i5, "coil.compose.AsyncImage (SingletonAsyncImage.kt:45)");
        }
        int i7 = i4 << 3;
        int i8 = i5 << 3;
        Modifier modifier3 = modifier2;
        Painter painter7 = painter4;
        Painter painter8 = painter5;
        Function1 function17 = function14;
        Function1 function18 = function16;
        ContentScale contentScale2 = contentScaleE;
        ColorFilter colorFilter3 = colorFilter2;
        AsyncImageKt.b(obj, str, ImageLoaderProvidableCompositionLocal.d(LocalImageLoaderKt.a(), composer, 6), modifier3, painter7, painter8, painter6, function17, function15, function18, alignmentE, contentScale2, f4, colorFilter3, iB, composer, (i7 & 7168) | (i4 & 112) | 2392584 | (29360128 & i7) | (234881024 & i7) | (i7 & 1879048192), ((i4 >> 27) & 14) | (i8 & 112) | (i8 & 896) | (i8 & 7168) | (i8 & 57344), 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.Y();
    }
}
