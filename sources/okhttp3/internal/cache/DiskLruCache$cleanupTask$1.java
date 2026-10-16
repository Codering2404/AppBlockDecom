package okhttp3.internal.cache;

import java.io.IOException;
import kotlin.Metadata;
import okhttp3.internal.concurrent.Task;
import okio.Okio;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class DiskLruCache$cleanupTask$1 extends Task {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ DiskLruCache f144356e;

    @Override // okhttp3.internal.concurrent.Task
    public long f() {
        DiskLruCache diskLruCache = this.f144356e;
        synchronized (diskLruCache) {
            if (!diskLruCache.f144324p || diskLruCache.J()) {
                return -1L;
            }
            try {
                diskLruCache.O0();
            } catch (IOException unused) {
                diskLruCache.f144326r = true;
            }
            try {
                if (diskLruCache.T()) {
                    diskLruCache.q0();
                    diskLruCache.f144321m = 0;
                }
            } catch (IOException unused2) {
                diskLruCache.f144327s = true;
                diskLruCache.f144319k = Okio.c(Okio.b());
            }
            return -1L;
        }
    }
}
