package coil.request;

import coil.request.ImageRequest;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

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
public final class ImageRequest$Builder$listener$5 implements ImageRequest.Listener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function1 f56103c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function1 f56104d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ Function2 f56105e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function2 f56106f;

    @Override // coil.request.ImageRequest.Listener
    public void a(ImageRequest imageRequest) {
        this.f56104d.invoke(imageRequest);
    }

    @Override // coil.request.ImageRequest.Listener
    public void b(ImageRequest imageRequest) {
        this.f56103c.invoke(imageRequest);
    }

    @Override // coil.request.ImageRequest.Listener
    public void c(ImageRequest imageRequest, ErrorResult errorResult) {
        this.f56105e.invoke(imageRequest, errorResult);
    }

    @Override // coil.request.ImageRequest.Listener
    public void d(ImageRequest imageRequest, SuccessResult successResult) {
        this.f56106f.invoke(imageRequest, successResult);
    }
}
