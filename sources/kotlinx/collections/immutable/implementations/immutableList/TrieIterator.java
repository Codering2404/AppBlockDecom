package kotlinx.collections.immutable.implementations.immutableList;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class TrieIterator<E> extends AbstractListIterator<E> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f140728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object[] f140729d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f140730f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v3 */
    public TrieIterator(Object[] root, int i3, int i4, int i5) {
        super(i3, i4);
        Intrinsics.checkNotNullParameter(root, "root");
        this.f140728c = i5;
        Object[] objArr = new Object[i5];
        this.f140729d = objArr;
        ?? r5 = i3 == i4 ? 1 : 0;
        this.f140730f = r5;
        objArr[0] = root;
        h(i3 - r5, 1);
    }

    private final Object g() {
        int iC = c() & 31;
        Object obj = this.f140729d[this.f140728c - 1];
        if (obj != null) {
            return ((Object[]) obj)[iC];
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<E of kotlinx.collections.immutable.implementations.immutableList.TrieIterator>");
    }

    private final void h(int i3, int i4) {
        int i5 = (this.f140728c - i4) * 5;
        while (i4 < this.f140728c) {
            Object[] objArr = this.f140729d;
            Object obj = objArr[i4 - 1];
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            }
            objArr[i4] = ((Object[]) obj)[UtilsKt.a(i3, i5)];
            i5 -= 5;
            i4++;
        }
    }

    private final void i(int i3) {
        int i4 = 0;
        while (UtilsKt.a(c(), i4) == i3) {
            i4 += 5;
        }
        if (i4 > 0) {
            h(c(), ((this.f140728c - 1) - (i4 / 5)) + 1);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final void j(Object[] root, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(root, "root");
        e(i3);
        f(i4);
        this.f140728c = i5;
        if (this.f140729d.length < i5) {
            this.f140729d = new Object[i5];
        }
        this.f140729d[0] = root;
        ?? r02 = i3 == i4 ? 1 : 0;
        this.f140730f = r02;
        h(i3 - r02, 1);
    }

    @Override // kotlinx.collections.immutable.implementations.immutableList.AbstractListIterator, java.util.ListIterator, java.util.Iterator
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object objG = g();
        e(c() + 1);
        if (c() == d()) {
            this.f140730f = true;
            return objG;
        }
        i(0);
        return objG;
    }

    @Override // java.util.ListIterator
    public Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        e(c() - 1);
        if (this.f140730f) {
            this.f140730f = false;
            return g();
        }
        i(31);
        return g();
    }
}
