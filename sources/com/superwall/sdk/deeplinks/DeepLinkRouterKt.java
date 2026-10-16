package com.superwall.sdk.deeplinks;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class DeepLinkRouterKt {
    public static final Object getRedeemableCode(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        Result.Companion companion = Result.f139772b;
        Object objB = Result.b(ResultKt.a(new UnsupportedOperationException("Link not valid for redemption")));
        String host = uri.getHost();
        if (host != null && StringsKt.a0(host, "superwall", false, 2, null) && StringsKt.G(uri.getLastPathSegment(), "redeem", false, 2, null)) {
            String queryParameter = uri.getQueryParameter("code");
            if (queryParameter == null) {
                queryParameter = uri.getQueryParameter("codes");
            }
            if (queryParameter != null) {
                return Result.b(queryParameter);
            }
        }
        return objB;
    }
}
