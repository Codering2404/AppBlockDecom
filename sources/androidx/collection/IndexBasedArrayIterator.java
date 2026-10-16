package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
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
public abstract class IndexBasedArrayIterator<T> implements Iterator<T>, KMutableIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f2860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f2862c;

    public IndexBasedArrayIterator(int i3) {
        this.f2860a = i3;
    }

    protected abstract Object a(int i3);

    protected abstract void b(int i3);

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f2861b < this.f2860a;
    }

    @Override // java.util.Iterator
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object objA = a(this.f2861b);
        this.f2861b++;
        this.f2862c = true;
        return objA;
    }

    @Override // java.util.Iterator
    public void remove() {
        if (!this.f2862c) {
            RuntimeHelpersKt.b("Call next() before removing an element.");
        }
        int i3 = this.f2861b - 1;
        this.f2861b = i3;
        b(i3);
        this.f2860a--;
        this.f2862c = false;
    }
}
