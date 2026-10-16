package coil.util;

import android.content.Context;
import coil.disk.DiskCache;
import kotlin.Metadata;
import kotlin.io.FilesKt;

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
public final class SingletonDiskCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SingletonDiskCache f56240a = new SingletonDiskCache();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static DiskCache f56241b;

    private SingletonDiskCache() {
    }

    public final synchronized DiskCache a(Context context) {
        DiskCache diskCacheA;
        diskCacheA = f56241b;
        if (diskCacheA == null) {
            diskCacheA = new DiskCache.Builder().b(FilesKt.t(Utils.n(context), "image_cache")).a();
            f56241b = diskCacheA;
        }
        return diskCacheA;
    }
}
