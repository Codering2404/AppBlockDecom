package coil.request;

import android.graphics.drawable.Drawable;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class ErrorResult extends ImageResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Drawable f56042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ImageRequest f56043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Throwable f56044c;

    public ErrorResult(Drawable drawable, ImageRequest imageRequest, Throwable th) {
        super(null);
        this.f56042a = drawable;
        this.f56043b = imageRequest;
        this.f56044c = th;
    }

    @Override // coil.request.ImageResult
    public Drawable a() {
        return this.f56042a;
    }

    @Override // coil.request.ImageResult
    public ImageRequest b() {
        return this.f56043b;
    }

    public final Throwable c() {
        return this.f56044c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ErrorResult)) {
            return false;
        }
        ErrorResult errorResult = (ErrorResult) obj;
        return Intrinsics.areEqual(a(), errorResult.a()) && Intrinsics.areEqual(b(), errorResult.b()) && Intrinsics.areEqual(this.f56044c, errorResult.f56044c);
    }

    public int hashCode() {
        Drawable drawableA = a();
        return ((((drawableA != null ? drawableA.hashCode() : 0) * 31) + b().hashCode()) * 31) + this.f56044c.hashCode();
    }
}
