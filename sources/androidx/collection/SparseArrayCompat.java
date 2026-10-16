package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public class SparseArrayCompat<E> implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ boolean f3154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public /* synthetic */ int[] f3155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object[] f3156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public /* synthetic */ int f3157d;

    public SparseArrayCompat() {
        this(0, 1, null);
    }

    public void a(int i3, Object obj) {
        int i4 = this.f3157d;
        if (i4 != 0 && i3 <= this.f3155b[i4 - 1]) {
            m(i3, obj);
            return;
        }
        if (this.f3154a && i4 >= this.f3155b.length) {
            SparseArrayCompatKt.e(this);
        }
        int i5 = this.f3157d;
        if (i5 >= this.f3155b.length) {
            int iE = ContainerHelpersKt.e(i5 + 1);
            int[] iArrCopyOf = Arrays.copyOf(this.f3155b, iE);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
            this.f3155b = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f3156c, iE);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
            this.f3156c = objArrCopyOf;
        }
        this.f3155b[i5] = i3;
        this.f3156c[i5] = obj;
        this.f3157d = i5 + 1;
    }

    public void b() {
        int i3 = this.f3157d;
        Object[] objArr = this.f3156c;
        for (int i4 = 0; i4 < i3; i4++) {
            objArr[i4] = null;
        }
        this.f3157d = 0;
        this.f3154a = false;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public SparseArrayCompat clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        Intrinsics.checkNotNull(objClone, "null cannot be cast to non-null type androidx.collection.SparseArrayCompat<E of androidx.collection.SparseArrayCompat>");
        SparseArrayCompat sparseArrayCompat = (SparseArrayCompat) objClone;
        sparseArrayCompat.f3155b = (int[]) this.f3155b.clone();
        sparseArrayCompat.f3156c = (Object[]) this.f3156c.clone();
        return sparseArrayCompat;
    }

    public boolean e(int i3) {
        return i(i3) >= 0;
    }

    public Object g(int i3) {
        return SparseArrayCompatKt.c(this, i3);
    }

    public Object h(int i3, Object obj) {
        return SparseArrayCompatKt.d(this, i3, obj);
    }

    public int i(int i3) {
        if (this.f3154a) {
            SparseArrayCompatKt.e(this);
        }
        return ContainerHelpersKt.a(this.f3155b, this.f3157d, i3);
    }

    public int j(Object obj) {
        if (this.f3154a) {
            SparseArrayCompatKt.e(this);
        }
        int i3 = this.f3157d;
        for (int i4 = 0; i4 < i3; i4++) {
            if (this.f3156c[i4] == obj) {
                return i4;
            }
        }
        return -1;
    }

    public int k(int i3) {
        if (this.f3154a) {
            SparseArrayCompatKt.e(this);
        }
        return this.f3155b[i3];
    }

    public void m(int i3, Object obj) {
        int iA = ContainerHelpersKt.a(this.f3155b, this.f3157d, i3);
        if (iA >= 0) {
            this.f3156c[iA] = obj;
            return;
        }
        int i4 = ~iA;
        if (i4 < this.f3157d && this.f3156c[i4] == SparseArrayCompatKt.f3158a) {
            this.f3155b[i4] = i3;
            this.f3156c[i4] = obj;
            return;
        }
        if (this.f3154a && this.f3157d >= this.f3155b.length) {
            SparseArrayCompatKt.e(this);
            i4 = ~ContainerHelpersKt.a(this.f3155b, this.f3157d, i3);
        }
        int i5 = this.f3157d;
        if (i5 >= this.f3155b.length) {
            int iE = ContainerHelpersKt.e(i5 + 1);
            int[] iArrCopyOf = Arrays.copyOf(this.f3155b, iE);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
            this.f3155b = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f3156c, iE);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
            this.f3156c = objArrCopyOf;
        }
        int i6 = this.f3157d;
        if (i6 - i4 != 0) {
            int[] iArr = this.f3155b;
            int i7 = i4 + 1;
            ArraysKt.copyInto(iArr, iArr, i7, i4, i6);
            Object[] objArr = this.f3156c;
            ArraysKt.copyInto(objArr, objArr, i7, i4, this.f3157d);
        }
        this.f3155b[i4] = i3;
        this.f3156c[i4] = obj;
        this.f3157d++;
    }

    public void o(int i3) {
        if (this.f3156c[i3] != SparseArrayCompatKt.f3158a) {
            this.f3156c[i3] = SparseArrayCompatKt.f3158a;
            this.f3154a = true;
        }
    }

    public Object p(int i3, Object obj) {
        int i4 = i(i3);
        if (i4 < 0) {
            return null;
        }
        Object[] objArr = this.f3156c;
        Object obj2 = objArr[i4];
        objArr[i4] = obj;
        return obj2;
    }

    public int q() {
        if (this.f3154a) {
            SparseArrayCompatKt.e(this);
        }
        return this.f3157d;
    }

    public Object r(int i3) {
        if (this.f3154a) {
            SparseArrayCompatKt.e(this);
        }
        Object[] objArr = this.f3156c;
        if (i3 < objArr.length) {
            return objArr[i3];
        }
        CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.f2810a;
        throw new ArrayIndexOutOfBoundsException();
    }

    public String toString() {
        if (q() <= 0) {
            return JsonUtils.EMPTY_JSON;
        }
        StringBuilder sb = new StringBuilder(this.f3157d * 28);
        sb.append('{');
        int i3 = this.f3157d;
        for (int i4 = 0; i4 < i3; i4++) {
            if (i4 > 0) {
                sb.append(", ");
            }
            sb.append(k(i4));
            sb.append('=');
            Object objR = r(i4);
            if (objR != this) {
                sb.append(objR);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public SparseArrayCompat(int i3) {
        if (i3 == 0) {
            this.f3155b = ContainerHelpersKt.f3174a;
            this.f3156c = ContainerHelpersKt.f3176c;
        } else {
            int iE = ContainerHelpersKt.e(i3);
            this.f3155b = new int[iE];
            this.f3156c = new Object[iE];
        }
    }

    public /* synthetic */ SparseArrayCompat(int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 10 : i3);
    }
}
