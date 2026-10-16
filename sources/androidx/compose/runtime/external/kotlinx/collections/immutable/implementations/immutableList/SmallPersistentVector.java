package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.ListImplementation;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class SmallPersistentVector<E> extends AbstractPersistentList<E> implements ImmutableList<E> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f24446b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f24447c = 8;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SmallPersistentVector f24448d = new SmallPersistentVector(new Object[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object[] f24449a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SmallPersistentVector a() {
            return SmallPersistentVector.f24448d;
        }

        private Companion() {
        }
    }

    public SmallPersistentVector(Object[] objArr) {
        this.f24449a = objArr;
        CommonFunctionsKt.a(objArr.length <= 32);
    }

    private final Object[] d(int i3) {
        return new Object[i3];
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    public PersistentList R1(Function1 function1) {
        Object[] objArrCopyOf = this.f24449a;
        int size = size();
        int size2 = size();
        boolean z2 = false;
        for (int i3 = 0; i3 < size2; i3++) {
            Object obj = this.f24449a[i3];
            if (((Boolean) function1.invoke(obj)).booleanValue()) {
                if (!z2) {
                    Object[] objArr = this.f24449a;
                    objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
                    Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
                    z2 = true;
                    size = i3;
                }
            } else if (z2) {
                objArrCopyOf[size] = obj;
                size++;
            }
        }
        return size == size() ? this : size == 0 ? f24448d : new SmallPersistentVector(ArraysKt.copyOfRange(objArrCopyOf, 0, size));
    }

    @Override // java.util.Collection, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    public PersistentList add(Object obj) {
        if (size() >= 32) {
            return new PersistentVector(this.f24449a, UtilsKt.c(obj), size() + 1, 0);
        }
        Object[] objArrCopyOf = Arrays.copyOf(this.f24449a, size() + 1);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[size()] = obj;
        return new SmallPersistentVector(objArrCopyOf);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList, java.util.Collection, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    public PersistentList addAll(Collection collection) {
        if (size() + collection.size() > 32) {
            PersistentList.Builder builder = builder();
            builder.addAll(collection);
            return builder.build();
        }
        Object[] objArrCopyOf = Arrays.copyOf(this.f24449a, size() + collection.size());
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
        int size = size();
        Iterator<E> it = collection.iterator();
        while (it.hasNext()) {
            objArrCopyOf[size] = it.next();
            size++;
        }
        return new SmallPersistentVector(objArrCopyOf);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    public PersistentList.Builder builder() {
        return new PersistentVectorBuilder(this, null, this.f24449a, 0);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public Object get(int i3) {
        ListImplementation.a(i3, size());
        return this.f24449a[i3];
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f24449a.length;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public int indexOf(Object obj) {
        return ArraysKt.indexOf(this.f24449a, obj);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        return ArraysKt.lastIndexOf(this.f24449a, obj);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public ListIterator listIterator(int i3) {
        ListImplementation.b(i3, size());
        return new BufferIterator(this.f24449a, i3, size());
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    public PersistentList q0(int i3) {
        ListImplementation.a(i3, size());
        if (size() == 1) {
            return f24448d;
        }
        Object[] objArrCopyOf = Arrays.copyOf(this.f24449a, size() - 1);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
        ArraysKt.copyInto(this.f24449a, objArrCopyOf, i3, i3 + 1, size());
        return new SmallPersistentVector(objArrCopyOf);
    }

    @Override // kotlin.collections.AbstractList, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    public PersistentList set(int i3, Object obj) {
        ListImplementation.a(i3, size());
        Object[] objArr = this.f24449a;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[i3] = obj;
        return new SmallPersistentVector(objArrCopyOf);
    }

    @Override // java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    public PersistentList add(int i3, Object obj) {
        ListImplementation.b(i3, size());
        if (i3 == size()) {
            return add(obj);
        }
        if (size() < 32) {
            Object[] objArrD = d(size() + 1);
            ArraysKt.copyInto$default(this.f24449a, objArrD, 0, 0, i3, 6, (Object) null);
            ArraysKt.copyInto(this.f24449a, objArrD, i3 + 1, i3, size());
            objArrD[i3] = obj;
            return new SmallPersistentVector(objArrD);
        }
        Object[] objArr = this.f24449a;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
        ArraysKt.copyInto(this.f24449a, objArrCopyOf, i3 + 1, i3, size() - 1);
        objArrCopyOf[i3] = obj;
        return new PersistentVector(objArrCopyOf, UtilsKt.c(this.f24449a[31]), size() + 1, 0);
    }
}
