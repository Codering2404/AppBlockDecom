package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
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
public abstract class TrieNodeBaseIterator<K, V, T> implements Iterator<T>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object[] f24491a = TrieNode.f24482e.a().p();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f24492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f24493c;

    public final Object a() {
        CommonFunctionsKt.a(e());
        return this.f24491a[this.f24493c];
    }

    public final TrieNode b() {
        CommonFunctionsKt.a(f());
        Object obj = this.f24491a[this.f24493c];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator>");
        return (TrieNode) obj;
    }

    protected final Object[] c() {
        return this.f24491a;
    }

    protected final int d() {
        return this.f24493c;
    }

    public final boolean e() {
        return this.f24493c < this.f24492b;
    }

    public final boolean f() {
        CommonFunctionsKt.a(this.f24493c >= this.f24492b);
        return this.f24493c < this.f24491a.length;
    }

    public final void g() {
        CommonFunctionsKt.a(e());
        this.f24493c += 2;
    }

    public final void h() {
        CommonFunctionsKt.a(f());
        this.f24493c++;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return e();
    }

    public final void i(Object[] objArr, int i3) {
        j(objArr, i3, 0);
    }

    public final void j(Object[] objArr, int i3, int i4) {
        this.f24491a = objArr;
        this.f24492b = i3;
        this.f24493c = i4;
    }

    protected final void k(int i3) {
        this.f24493c = i3;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
