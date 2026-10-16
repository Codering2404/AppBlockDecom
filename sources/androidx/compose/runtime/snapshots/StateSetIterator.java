package androidx.compose.runtime.snapshots;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.markers.KMutableIterator;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class StateSetIterator<T> implements Iterator<T>, KMutableIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SnapshotStateSet f25029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Iterator f25030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f25031c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object f25032d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f25033f;

    public StateSetIterator(SnapshotStateSet snapshotStateSet, Iterator it) {
        this.f25029a = snapshotStateSet;
        this.f25030b = it;
        this.f25033f = snapshotStateSet.b();
        a();
    }

    private final void a() {
        this.f25031c = this.f25032d;
        this.f25032d = this.f25030b.hasNext() ? this.f25030b.next() : null;
    }

    private final void b() {
        if (this.f25029a.b() != this.f25033f) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f25032d != null;
    }

    @Override // java.util.Iterator
    public Object next() {
        b();
        a();
        Object obj = this.f25031c;
        if (obj != null) {
            return obj;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.Iterator
    public void remove() {
        b();
        Object obj = this.f25031c;
        if (obj == null) {
            throw new IllegalStateException();
        }
        this.f25029a.remove(obj);
        this.f25031c = null;
        Unit unit = Unit.f139807a;
        this.f25033f = this.f25029a.b();
    }
}
