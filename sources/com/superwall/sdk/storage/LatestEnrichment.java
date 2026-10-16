package com.superwall.sdk.storage;

import android.content.Context;
import com.superwall.sdk.models.enrichment.Enrichment;
import com.superwall.sdk.storage.Storable;
import java.io.File;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;

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
public final class LatestEnrichment implements Storable<Enrichment> {
    public static final LatestEnrichment INSTANCE = new LatestEnrichment();

    private LatestEnrichment() {
    }

    @Override // com.superwall.sdk.storage.Storable
    public File file(Context context) {
        return Storable.DefaultImpls.file(this, context);
    }

    @Override // com.superwall.sdk.storage.Storable
    public SearchPathDirectory getDirectory() {
        return SearchPathDirectory.CACHE;
    }

    @Override // com.superwall.sdk.storage.Storable
    public String getKey() {
        return "store.enrichmentCache";
    }

    @Override // com.superwall.sdk.storage.Storable
    public KSerializer<Enrichment> getSerializer() {
        return Enrichment.Companion.serializer();
    }
}
