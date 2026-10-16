package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

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
public class PersistentOrderedSetIterator<E> implements Iterator<E>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f24569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f24570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f24571c;

    public PersistentOrderedSetIterator(Object obj, Map map) {
        this.f24569a = obj;
        this.f24570b = map;
    }

    private final void a() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
    }

    public final int b() {
        return this.f24571c;
    }

    public final void c(int i3) {
        this.f24571c = i3;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f24571c < this.f24570b.size();
    }

    @Override // java.util.Iterator
    public Object next() {
        a();
        Object obj = this.f24569a;
        this.f24571c++;
        Object obj2 = this.f24570b.get(obj);
        if (obj2 != null) {
            this.f24569a = ((Links) obj2).c();
            return obj;
        }
        throw new ConcurrentModificationException("Hash code of an element (" + obj + ") has changed after it was added to the persistent set.");
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
