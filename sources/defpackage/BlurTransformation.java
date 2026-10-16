package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import coil.size.Size;
import coil.transform.Transformation;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class BlurTransformation implements Transformation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f48a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f49b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f50c;

    public BlurTransformation(Context context, float f3) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f48a = context;
        this.f49b = f3;
        this.f50c = BlurTransformation.class.getName() + '-' + f3;
    }

    @Override // coil.transform.Transformation
    public String a() {
        return this.f50c;
    }

    @Override // coil.transform.Transformation
    public Object b(Bitmap bitmap, Size size, Continuation continuation) {
        return BlurTransformationKt.b(bitmap, this.f48a, this.f49b, false, 4, null);
    }
}
