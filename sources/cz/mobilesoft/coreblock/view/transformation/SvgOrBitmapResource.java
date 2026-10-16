package cz.mobilesoft.coreblock.view.transformation;

import android.graphics.Bitmap;
import com.caverock.androidsvg.SVG;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class SvgOrBitmapResource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SVG f133455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Bitmap f133456b;

    public SvgOrBitmapResource(SVG svg, Bitmap bitmap) {
        this.f133455a = svg;
        this.f133456b = bitmap;
    }

    public final Bitmap a() {
        return this.f133456b;
    }

    public final SVG b() {
        return this.f133455a;
    }

    public /* synthetic */ SvgOrBitmapResource(SVG svg, Bitmap bitmap, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : svg, (i3 & 2) != 0 ? null : bitmap);
    }
}
