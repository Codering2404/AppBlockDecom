package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class CircularArray<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object[] f2802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f2804c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2805d;

    public CircularArray(int i3) {
        if (!(i3 >= 1)) {
            RuntimeHelpersKt.a("capacity must be >= 1");
        }
        if (!(i3 <= 1073741824)) {
            RuntimeHelpersKt.a("capacity must be <= 2^30");
        }
        i3 = Integer.bitCount(i3) != 1 ? Integer.highestOneBit(i3 - 1) << 1 : i3;
        this.f2805d = i3 - 1;
        this.f2802a = new Object[i3];
    }

    private final void b() {
        Object[] objArr = this.f2802a;
        int length = objArr.length;
        int i3 = this.f2803b;
        int i4 = length - i3;
        int i5 = length << 1;
        if (i5 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        Object[] objArr2 = new Object[i5];
        ArraysKt.copyInto(objArr, objArr2, 0, i3, length);
        ArraysKt.copyInto(this.f2802a, objArr2, i4, 0, this.f2803b);
        this.f2802a = objArr2;
        this.f2803b = 0;
        this.f2804c = length;
        this.f2805d = i5 - 1;
    }

    public final void a(Object obj) {
        Object[] objArr = this.f2802a;
        int i3 = this.f2804c;
        objArr[i3] = obj;
        int i4 = this.f2805d & (i3 + 1);
        this.f2804c = i4;
        if (i4 == this.f2803b) {
            b();
        }
    }

    public final Object c(int i3) {
        if (i3 < 0 || i3 >= f()) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.f2810a;
            throw new ArrayIndexOutOfBoundsException();
        }
        Object obj = this.f2802a[this.f2805d & (this.f2803b + i3)];
        Intrinsics.checkNotNull(obj);
        return obj;
    }

    public final boolean d() {
        return this.f2803b == this.f2804c;
    }

    public final Object e() {
        int i3 = this.f2803b;
        if (i3 == this.f2804c) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.f2810a;
            throw new ArrayIndexOutOfBoundsException();
        }
        Object[] objArr = this.f2802a;
        Object obj = objArr[i3];
        objArr[i3] = null;
        this.f2803b = (i3 + 1) & this.f2805d;
        return obj;
    }

    public final int f() {
        return (this.f2804c - this.f2803b) & this.f2805d;
    }
}
