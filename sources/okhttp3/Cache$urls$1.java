package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import okhttp3.internal.cache.DiskLruCache;
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
public final class Cache$urls$1 implements Iterator<String>, KMutableIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Iterator f143908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f143909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f143910c;

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        String str = this.f143909b;
        Intrinsics.checkNotNull(str);
        this.f143909b = null;
        this.f143910c = true;
        return str;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f143909b != null) {
            return true;
        }
        this.f143910c = false;
        while (this.f143908a.hasNext()) {
            try {
                Closeable closeable = (Closeable) this.f143908a.next();
                try {
                    continue;
                    this.f143909b = Okio.d(((DiskLruCache.Snapshot) closeable).b(0)).Q0();
                    CloseableKt.a(closeable, null);
                    return true;
                } finally {
                    try {
                        continue;
                    } catch (Throwable th) {
                    }
                }
            } catch (IOException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Iterator
    public void remove() {
        if (!this.f143910c) {
            throw new IllegalStateException("remove() before next()");
        }
        this.f143908a.remove();
    }
}
