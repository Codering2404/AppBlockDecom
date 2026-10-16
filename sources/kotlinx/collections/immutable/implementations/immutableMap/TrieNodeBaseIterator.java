package kotlinx.collections.immutable.implementations.immutableMap;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.collections.immutable.internal.CommonFunctionsKt;

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
public abstract class TrieNodeBaseIterator<K, V, T> implements Iterator<T>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object[] f140773a = TrieNode.f140767e.a().m();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f140774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f140775c;

    public final Object a() {
        CommonFunctionsKt.a(e());
        return this.f140773a[this.f140775c];
    }

    public final TrieNode b() {
        CommonFunctionsKt.a(f());
        Object obj = this.f140773a[this.f140775c];
        if (obj != null) {
            return (TrieNode) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator, V of kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator>");
    }

    protected final Object[] c() {
        return this.f140773a;
    }

    protected final int d() {
        return this.f140775c;
    }

    public final boolean e() {
        return this.f140775c < this.f140774b;
    }

    public final boolean f() {
        CommonFunctionsKt.a(this.f140775c >= this.f140774b);
        return this.f140775c < this.f140773a.length;
    }

    public final void g() {
        CommonFunctionsKt.a(e());
        this.f140775c += 2;
    }

    public final void h() {
        CommonFunctionsKt.a(f());
        this.f140775c++;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return e();
    }

    public final void i(Object[] buffer, int i3) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        j(buffer, i3, 0);
    }

    public final void j(Object[] buffer, int i3, int i4) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.f140773a = buffer;
        this.f140774b = i3;
        this.f140775c = i4;
    }

    protected final void k(int i3) {
        this.f140775c = i3;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
