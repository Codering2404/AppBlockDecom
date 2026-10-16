package com.revenuecat.purchases.storage;

import com.revenuecat.purchases.models.Checksum;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import kotlin.Metadata;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public interface LocalFileCache {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
    }

    static /* synthetic */ URI generateLocalFilesystemURI$default(LocalFileCache localFileCache, URL url, Checksum checksum, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: generateLocalFilesystemURI");
        }
        if ((i3 & 2) != 0) {
            checksum = null;
        }
        return localFileCache.generateLocalFilesystemURI(url, checksum);
    }

    static /* synthetic */ void saveData$default(LocalFileCache localFileCache, InputStream inputStream, URI uri, Checksum checksum, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: saveData");
        }
        if ((i3 & 4) != 0) {
            checksum = null;
        }
        localFileCache.saveData(inputStream, uri, checksum);
    }

    boolean cachedContentExists(URI uri);

    URI generateLocalFilesystemURI(URL url, Checksum checksum);

    void saveData(InputStream inputStream, URI uri, Checksum checksum);
}
