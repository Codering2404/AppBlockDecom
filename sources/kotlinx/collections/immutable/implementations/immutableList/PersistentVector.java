package kotlinx.collections.immutable.implementations.immutableList;

import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.collections.immutable.PersistentList;
import kotlinx.collections.immutable.internal.CommonFunctionsKt;
import kotlinx.collections.immutable.internal.ListImplementation;

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
public final class PersistentVector<E> extends AbstractPersistentList<E> implements PersistentList<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object[] f140705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object[] f140706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f140707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f140708d;

    public PersistentVector(Object[] root, Object[] tail, int i3, int i4) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(tail, "tail");
        this.f140705a = root;
        this.f140706b = tail;
        this.f140707c = i3;
        this.f140708d = i4;
        if (size() <= 32) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("Trie-based persistent vector should have at least 33 elements, got ", Integer.valueOf(size())).toString());
        }
        CommonFunctionsKt.a(size() - UtilsKt.c(size()) <= RangesKt.k(tail.length, 32));
    }

    private final Object[] b(int i3) {
        if (e() <= i3) {
            return this.f140706b;
        }
        Object[] objArr = this.f140705a;
        for (int i4 = this.f140708d; i4 > 0; i4 -= 5) {
            Object[] objArr2 = objArr[UtilsKt.a(i3, i4)];
            if (objArr2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            }
            objArr = objArr2;
        }
        return objArr;
    }

    private final int e() {
        return UtilsKt.c(size());
    }

    @Override // kotlinx.collections.immutable.PersistentList
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public PersistentVectorBuilder builder() {
        return new PersistentVectorBuilder(this, this.f140705a, this.f140706b, this.f140708d);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public Object get(int i3) {
        ListImplementation.a(i3, size());
        return b(i3)[i3 & 31];
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f140707c;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public ListIterator listIterator(int i3) {
        ListImplementation.b(i3, size());
        return new PersistentVectorIterator(this.f140705a, this.f140706b, i3, size(), (this.f140708d / 5) + 1);
    }
}
