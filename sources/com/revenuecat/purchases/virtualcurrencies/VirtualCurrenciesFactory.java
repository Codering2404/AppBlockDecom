package com.revenuecat.purchases.virtualcurrencies;

import com.revenuecat.purchases.common.JsonProvider;
import com.revenuecat.purchases.common.networking.HTTPResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import org.json.JSONException;
import org.json.JSONObject;

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
public final class VirtualCurrenciesFactory {
    public static final VirtualCurrenciesFactory INSTANCE = new VirtualCurrenciesFactory();

    private VirtualCurrenciesFactory() {
    }

    public final VirtualCurrencies buildVirtualCurrencies(HTTPResult httpResult) throws JSONException, IllegalArgumentException {
        Intrinsics.checkNotNullParameter(httpResult, "httpResult");
        return buildVirtualCurrencies(httpResult.getBody());
    }

    public final VirtualCurrencies buildVirtualCurrencies(JSONObject body) throws JSONException, IllegalArgumentException {
        Intrinsics.checkNotNullParameter(body, "body");
        Json defaultJson = JsonProvider.Companion.getDefaultJson();
        String string = body.toString();
        Intrinsics.checkNotNullExpressionValue(string, "body.toString()");
        defaultJson.a();
        return (VirtualCurrencies) defaultJson.d(VirtualCurrencies.Companion.serializer(), string);
    }

    public final VirtualCurrencies buildVirtualCurrencies(String jsonString) throws JSONException, IllegalArgumentException {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        Json defaultJson = JsonProvider.Companion.getDefaultJson();
        defaultJson.a();
        return (VirtualCurrencies) defaultJson.d(VirtualCurrencies.Companion.serializer(), jsonString);
    }
}
