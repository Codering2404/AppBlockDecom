package cz.mobilesoft.coreblock.view.transformation;

import android.graphics.drawable.PictureDrawable;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.bumptech.glide.request.target.Target;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class SvgSoftwareLayerSetter implements RequestListener<PictureDrawable> {
    @Override // com.bumptech.glide.request.RequestListener
    public boolean a(GlideException glideException, Object model, Target target, boolean z2) {
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(target, "target");
        View viewA = ((ImageViewTarget) target).a();
        Intrinsics.checkNotNullExpressionValue(viewA, "getView(...)");
        ((ImageView) viewA).setLayerType(0, null);
        return false;
    }

    @Override // com.bumptech.glide.request.RequestListener
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean d(PictureDrawable pictureDrawable, Object model, Target target, DataSource dataSource, boolean z2) {
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        View viewA = ((ImageViewTarget) target).a();
        Intrinsics.checkNotNullExpressionValue(viewA, "getView(...)");
        ((ImageView) viewA).setLayerType(1, null);
        return false;
    }
}
