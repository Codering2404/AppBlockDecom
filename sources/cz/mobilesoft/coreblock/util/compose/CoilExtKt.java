package cz.mobilesoft.coreblock.util.compose;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import coil.decode.SvgDecoder;
import coil.request.ImageRequest;
import coil.size.Dimension;
import cz.mobilesoft.coreblock.util.NetworkHelperKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class CoilExtKt {
    public static final ImageRequest a(String source, Dimension dimension, Dimension dimension2, ImageRequest.Listener listener, Composer composer, int i3, int i4) {
        Intrinsics.checkNotNullParameter(source, "source");
        if ((i4 & 2) != 0) {
            dimension = Dimension.Undefined.f56164a;
        }
        if ((i4 & 4) != 0) {
            dimension2 = Dimension.Undefined.f56164a;
        }
        if ((i4 & 8) != 0) {
            listener = null;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-805769473, i3, -1, "cz.mobilesoft.coreblock.util.compose.getCoilServerResourceModel (CoilExt.kt:23)");
        }
        String strA = NetworkHelperKt.a(source);
        ImageRequest.Builder builderH = new ImageRequest.Builder((Context) composer.q(AndroidCompositionLocals_androidKt.g())).d(strA).q(dimension, dimension2).h(listener);
        if (StringsKt.E(strA, ".svg", false, 2, null)) {
            builderH.e(new SvgDecoder.Factory(false, 1, null));
        }
        ImageRequest imageRequestA = builderH.a();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return imageRequestA;
    }
}
