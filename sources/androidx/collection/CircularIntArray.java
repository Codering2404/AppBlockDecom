package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class CircularIntArray {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f2806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f2808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2809d;

    public CircularIntArray() {
        this(0, 1, null);
    }

    private final void c() {
        int[] iArr = this.f2806a;
        int length = iArr.length;
        int i3 = this.f2807b;
        int i4 = length - i3;
        int i5 = length << 1;
        if (i5 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        int[] iArr2 = new int[i5];
        ArraysKt.copyInto(iArr, iArr2, 0, i3, length);
        ArraysKt.copyInto(this.f2806a, iArr2, i4, 0, this.f2807b);
        this.f2806a = iArr2;
        this.f2807b = 0;
        this.f2808c = length;
        this.f2809d = i5 - 1;
    }

    public final void a(int i3) {
        int[] iArr = this.f2806a;
        int i4 = this.f2808c;
        iArr[i4] = i3;
        int i5 = this.f2809d & (i4 + 1);
        this.f2808c = i5;
        if (i5 == this.f2807b) {
            c();
        }
    }

    public final void b() {
        this.f2808c = this.f2807b;
    }

    public final boolean d() {
        return this.f2807b == this.f2808c;
    }

    public final int e() {
        int i3 = this.f2807b;
        if (i3 == this.f2808c) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.f2810a;
            throw new ArrayIndexOutOfBoundsException();
        }
        int i4 = this.f2806a[i3];
        this.f2807b = (i3 + 1) & this.f2809d;
        return i4;
    }

    public CircularIntArray(int i3) {
        if (!(i3 >= 1)) {
            RuntimeHelpersKt.a("capacity must be >= 1");
        }
        if (!(i3 <= 1073741824)) {
            RuntimeHelpersKt.a("capacity must be <= 2^30");
        }
        i3 = Integer.bitCount(i3) != 1 ? Integer.highestOneBit(i3 - 1) << 1 : i3;
        this.f2809d = i3 - 1;
        this.f2806a = new int[i3];
    }

    public /* synthetic */ CircularIntArray(int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 8 : i3);
    }
}
