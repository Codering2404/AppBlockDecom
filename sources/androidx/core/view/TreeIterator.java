package androidx.core.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class TreeIterator<T> implements Iterator<T>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1 f34435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f34436b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Iterator f34437c;

    public TreeIterator(Iterator it, Function1 function1) {
        this.f34435a = function1;
        this.f34437c = it;
    }

    private final void a(Object obj) {
        Iterator it = (Iterator) this.f34435a.invoke(obj);
        if (it != null && it.hasNext()) {
            this.f34436b.add(this.f34437c);
            this.f34437c = it;
        } else {
            while (!this.f34437c.hasNext() && !this.f34436b.isEmpty()) {
                this.f34437c = (Iterator) CollectionsKt.last(this.f34436b);
                CollectionsKt.removeLast(this.f34436b);
            }
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f34437c.hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        Object next = this.f34437c.next();
        a(next);
        return next;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
