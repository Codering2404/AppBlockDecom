package okhttp3.internal.cache;

import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import okhttp3.internal.cache.DiskLruCache;

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
public final class DiskLruCache$snapshots$1 implements Iterator<DiskLruCache.Snapshot>, KMutableIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Iterator f144358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DiskLruCache.Snapshot f144359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private DiskLruCache.Snapshot f144360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ DiskLruCache f144361d;

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public DiskLruCache.Snapshot next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        DiskLruCache.Snapshot snapshot = this.f144359b;
        this.f144360c = snapshot;
        this.f144359b = null;
        Intrinsics.checkNotNull(snapshot);
        return snapshot;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f144359b != null) {
            return true;
        }
        DiskLruCache diskLruCache = this.f144361d;
        synchronized (diskLruCache) {
            if (diskLruCache.J()) {
                return false;
            }
            while (this.f144358a.hasNext()) {
                DiskLruCache.Entry entry = (DiskLruCache.Entry) this.f144358a.next();
                DiskLruCache.Snapshot snapshotR = entry == null ? null : entry.r();
                if (snapshotR != null) {
                    this.f144359b = snapshotR;
                    return true;
                }
            }
            Unit unit = Unit.f139807a;
            return false;
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        DiskLruCache.Snapshot snapshot = this.f144360c;
        if (snapshot == null) {
            throw new IllegalStateException("remove() before next()");
        }
        try {
            this.f144361d.w0(snapshot.c());
        } catch (IOException unused) {
        } finally {
            this.f144360c = null;
        }
    }
}
