package androidx.compose.runtime.snapshots;

import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableListIterator;

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
final class StateListIterator<T> implements ListIterator<T>, KMutableListIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SnapshotStateList f25014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f25015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f25016c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f25017d;

    public StateListIterator(SnapshotStateList snapshotStateList, int i3) {
        this.f25014a = snapshotStateList;
        this.f25015b = i3 - 1;
        this.f25017d = snapshotStateList.f();
    }

    private final void a() {
        if (this.f25014a.f() != this.f25017d) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator
    public void add(Object obj) {
        a();
        this.f25014a.add(this.f25015b + 1, obj);
        this.f25016c = -1;
        this.f25015b++;
        this.f25017d = this.f25014a.f();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return this.f25015b < this.f25014a.size() - 1;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return this.f25015b >= 0;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public Object next() {
        a();
        int i3 = this.f25015b + 1;
        this.f25016c = i3;
        SnapshotStateListKt.g(i3, this.f25014a.size());
        Object obj = this.f25014a.get(i3);
        this.f25015b = i3;
        return obj;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.f25015b + 1;
    }

    @Override // java.util.ListIterator
    public Object previous() {
        a();
        SnapshotStateListKt.g(this.f25015b, this.f25014a.size());
        int i3 = this.f25015b;
        this.f25016c = i3;
        this.f25015b--;
        return this.f25014a.get(i3);
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.f25015b;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        a();
        this.f25014a.remove(this.f25015b);
        this.f25015b--;
        this.f25016c = -1;
        this.f25017d = this.f25014a.f();
    }

    @Override // java.util.ListIterator
    public void set(Object obj) {
        a();
        int i3 = this.f25016c;
        if (i3 < 0) {
            SnapshotStateListKt.e();
            throw new KotlinNothingValueException();
        }
        this.f25014a.set(i3, obj);
        this.f25017d = this.f25014a.f();
    }
}
