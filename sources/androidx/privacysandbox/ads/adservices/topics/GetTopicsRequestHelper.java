package androidx.privacysandbox.ads.adservices.topics;

import android.adservices.topics.GetTopicsRequest;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class GetTopicsRequestHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final GetTopicsRequestHelper f51361a = new GetTopicsRequestHelper();

    private GetTopicsRequestHelper() {
    }

    public final android.adservices.topics.GetTopicsRequest a(GetTopicsRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        android.adservices.topics.GetTopicsRequest getTopicsRequestA = new GetTopicsRequest.Builder().b(request.a()).c(request.b()).a();
        Intrinsics.checkNotNullExpressionValue(getTopicsRequestA, "Builder()\n            .s…ion)\n            .build()");
        return getTopicsRequestA;
    }

    public final android.adservices.topics.GetTopicsRequest b(GetTopicsRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        android.adservices.topics.GetTopicsRequest getTopicsRequestA = new GetTopicsRequest.Builder().b(request.a()).a();
        Intrinsics.checkNotNullExpressionValue(getTopicsRequestA, "Builder()\n            .s…ame)\n            .build()");
        return getTopicsRequestA;
    }
}
