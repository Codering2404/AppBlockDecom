package kotlinx.collections.immutable.implementations.immutableSet;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
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
public final class TrieNodeIterator<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object[] f140798a = TrieNode.f140793d.a().l();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f140799b;

    public static /* synthetic */ void i(TrieNodeIterator trieNodeIterator, Object[] objArr, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 0;
        }
        trieNodeIterator.h(objArr, i3);
    }

    public final Object a() {
        CommonFunctionsKt.a(d());
        return this.f140798a[this.f140799b];
    }

    public final TrieNode b() {
        CommonFunctionsKt.a(e());
        Object obj = this.f140798a[this.f140799b];
        if (obj != null) {
            return (TrieNode) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of kotlinx.collections.immutable.implementations.immutableSet.TrieNodeIterator>");
    }

    public final boolean c() {
        return this.f140799b < this.f140798a.length;
    }

    public final boolean d() {
        return c() && !(this.f140798a[this.f140799b] instanceof TrieNode);
    }

    public final boolean e() {
        return c() && (this.f140798a[this.f140799b] instanceof TrieNode);
    }

    public final void f() {
        CommonFunctionsKt.a(c());
        this.f140799b++;
    }

    public final Object g() {
        CommonFunctionsKt.a(d());
        Object[] objArr = this.f140798a;
        int i3 = this.f140799b;
        this.f140799b = i3 + 1;
        return objArr[i3];
    }

    public final void h(Object[] buffer, int i3) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.f140798a = buffer;
        this.f140799b = i3;
    }
}
