package kotlinx.collections.immutable.implementations.immutableList;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ImmutableList;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class SmallPersistentVector<E> extends AbstractPersistentList<E> implements ImmutableList<E> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f140725b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SmallPersistentVector f140726c = new SmallPersistentVector(new Object[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object[] f140727a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SmallPersistentVector a() {
            return SmallPersistentVector.f140726c;
        }

        private Companion() {
        }
    }

    public SmallPersistentVector(Object[] buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.f140727a = buffer;
        CommonFunctionsKt.a(buffer.length <= 32);
    }

    @Override // kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList, java.util.Collection, java.util.List, kotlinx.collections.immutable.PersistentList
    public PersistentList addAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (size() + elements.size() > 32) {
            PersistentList.Builder builder = builder();
            builder.addAll(elements);
            return builder.build();
        }
        Object[] objArrCopyOf = Arrays.copyOf(this.f140727a, size() + elements.size());
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
        int size = size();
        Iterator<E> it = elements.iterator();
        while (it.hasNext()) {
            objArrCopyOf[size] = it.next();
            size++;
        }
        return new SmallPersistentVector(objArrCopyOf);
    }

    @Override // kotlinx.collections.immutable.PersistentList
    public PersistentList.Builder builder() {
        return new PersistentVectorBuilder(this, null, this.f140727a, 0);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public Object get(int i3) {
        ListImplementation.a(i3, size());
        return this.f140727a[i3];
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f140727a.length;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public int indexOf(Object obj) {
        return ArraysKt.indexOf(this.f140727a, obj);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        return ArraysKt.lastIndexOf(this.f140727a, obj);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public ListIterator listIterator(int i3) {
        ListImplementation.b(i3, size());
        return new BufferIterator(this.f140727a, i3, size());
    }
}
