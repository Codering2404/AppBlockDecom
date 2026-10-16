package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.collection.internal.RuntimeHelpersKt;
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
public class LongSparseArray<E> implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ boolean f2943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public /* synthetic */ long[] f2944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object[] f2945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public /* synthetic */ int f2946d;

    public LongSparseArray() {
        this(0, 1, null);
    }

    public void a(long j3, Object obj) {
        int i3 = this.f2946d;
        if (i3 != 0 && j3 <= this.f2944b[i3 - 1]) {
            m(j3, obj);
            return;
        }
        if (this.f2943a) {
            long[] jArr = this.f2944b;
            if (i3 >= jArr.length) {
                Object[] objArr = this.f2945c;
                int i4 = 0;
                for (int i5 = 0; i5 < i3; i5++) {
                    Object obj2 = objArr[i5];
                    if (obj2 != LongSparseArrayKt.f2947a) {
                        if (i5 != i4) {
                            jArr[i4] = jArr[i5];
                            objArr[i4] = obj2;
                            objArr[i5] = null;
                        }
                        i4++;
                    }
                }
                this.f2943a = false;
                this.f2946d = i4;
            }
        }
        int i6 = this.f2946d;
        if (i6 >= this.f2944b.length) {
            int iF = ContainerHelpersKt.f(i6 + 1);
            long[] jArrCopyOf = Arrays.copyOf(this.f2944b, iF);
            Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
            this.f2944b = jArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f2945c, iF);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
            this.f2945c = objArrCopyOf;
        }
        this.f2944b[i6] = j3;
        this.f2945c[i6] = obj;
        this.f2946d = i6 + 1;
    }

    public void b() {
        int i3 = this.f2946d;
        Object[] objArr = this.f2945c;
        for (int i4 = 0; i4 < i3; i4++) {
            objArr[i4] = null;
        }
        this.f2946d = 0;
        this.f2943a = false;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public LongSparseArray clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        Intrinsics.checkNotNull(objClone, "null cannot be cast to non-null type androidx.collection.LongSparseArray<E of androidx.collection.LongSparseArray>");
        LongSparseArray longSparseArray = (LongSparseArray) objClone;
        longSparseArray.f2944b = (long[]) this.f2944b.clone();
        longSparseArray.f2945c = (Object[]) this.f2945c.clone();
        return longSparseArray;
    }

    public boolean e(long j3) {
        return i(j3) >= 0;
    }

    public Object g(long j3) {
        int iB = ContainerHelpersKt.b(this.f2944b, this.f2946d, j3);
        if (iB < 0 || this.f2945c[iB] == LongSparseArrayKt.f2947a) {
            return null;
        }
        return this.f2945c[iB];
    }

    public Object h(long j3, Object obj) {
        int iB = ContainerHelpersKt.b(this.f2944b, this.f2946d, j3);
        return (iB < 0 || this.f2945c[iB] == LongSparseArrayKt.f2947a) ? obj : this.f2945c[iB];
    }

    public int i(long j3) {
        if (this.f2943a) {
            int i3 = this.f2946d;
            long[] jArr = this.f2944b;
            Object[] objArr = this.f2945c;
            int i4 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                Object obj = objArr[i5];
                if (obj != LongSparseArrayKt.f2947a) {
                    if (i5 != i4) {
                        jArr[i4] = jArr[i5];
                        objArr[i4] = obj;
                        objArr[i5] = null;
                    }
                    i4++;
                }
            }
            this.f2943a = false;
            this.f2946d = i4;
        }
        return ContainerHelpersKt.b(this.f2944b, this.f2946d, j3);
    }

    public boolean j() {
        return r() == 0;
    }

    public long k(int i3) {
        if (!(i3 >= 0 && i3 < this.f2946d)) {
            RuntimeHelpersKt.a("Expected index to be within 0..size()-1, but was " + i3);
        }
        if (this.f2943a) {
            int i4 = this.f2946d;
            long[] jArr = this.f2944b;
            Object[] objArr = this.f2945c;
            int i5 = 0;
            for (int i6 = 0; i6 < i4; i6++) {
                Object obj = objArr[i6];
                if (obj != LongSparseArrayKt.f2947a) {
                    if (i6 != i5) {
                        jArr[i5] = jArr[i6];
                        objArr[i5] = obj;
                        objArr[i6] = null;
                    }
                    i5++;
                }
            }
            this.f2943a = false;
            this.f2946d = i5;
        }
        return this.f2944b[i3];
    }

    public void m(long j3, Object obj) {
        int iB = ContainerHelpersKt.b(this.f2944b, this.f2946d, j3);
        if (iB >= 0) {
            this.f2945c[iB] = obj;
            return;
        }
        int i3 = ~iB;
        if (i3 < this.f2946d && this.f2945c[i3] == LongSparseArrayKt.f2947a) {
            this.f2944b[i3] = j3;
            this.f2945c[i3] = obj;
            return;
        }
        if (this.f2943a) {
            int i4 = this.f2946d;
            long[] jArr = this.f2944b;
            if (i4 >= jArr.length) {
                Object[] objArr = this.f2945c;
                int i5 = 0;
                for (int i6 = 0; i6 < i4; i6++) {
                    Object obj2 = objArr[i6];
                    if (obj2 != LongSparseArrayKt.f2947a) {
                        if (i6 != i5) {
                            jArr[i5] = jArr[i6];
                            objArr[i5] = obj2;
                            objArr[i6] = null;
                        }
                        i5++;
                    }
                }
                this.f2943a = false;
                this.f2946d = i5;
                i3 = ~ContainerHelpersKt.b(this.f2944b, i5, j3);
            }
        }
        int i7 = this.f2946d;
        if (i7 >= this.f2944b.length) {
            int iF = ContainerHelpersKt.f(i7 + 1);
            long[] jArrCopyOf = Arrays.copyOf(this.f2944b, iF);
            Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
            this.f2944b = jArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f2945c, iF);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
            this.f2945c = objArrCopyOf;
        }
        int i8 = this.f2946d;
        if (i8 - i3 != 0) {
            long[] jArr2 = this.f2944b;
            int i9 = i3 + 1;
            ArraysKt.copyInto(jArr2, jArr2, i9, i3, i8);
            Object[] objArr2 = this.f2945c;
            ArraysKt.copyInto(objArr2, objArr2, i9, i3, this.f2946d);
        }
        this.f2944b[i3] = j3;
        this.f2945c[i3] = obj;
        this.f2946d++;
    }

    public void o(LongSparseArray other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iR = other.r();
        for (int i3 = 0; i3 < iR; i3++) {
            m(other.k(i3), other.s(i3));
        }
    }

    public void p(long j3) {
        int iB = ContainerHelpersKt.b(this.f2944b, this.f2946d, j3);
        if (iB < 0 || this.f2945c[iB] == LongSparseArrayKt.f2947a) {
            return;
        }
        this.f2945c[iB] = LongSparseArrayKt.f2947a;
        this.f2943a = true;
    }

    public void q(int i3) {
        if (this.f2945c[i3] != LongSparseArrayKt.f2947a) {
            this.f2945c[i3] = LongSparseArrayKt.f2947a;
            this.f2943a = true;
        }
    }

    public int r() {
        if (this.f2943a) {
            int i3 = this.f2946d;
            long[] jArr = this.f2944b;
            Object[] objArr = this.f2945c;
            int i4 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                Object obj = objArr[i5];
                if (obj != LongSparseArrayKt.f2947a) {
                    if (i5 != i4) {
                        jArr[i4] = jArr[i5];
                        objArr[i4] = obj;
                        objArr[i5] = null;
                    }
                    i4++;
                }
            }
            this.f2943a = false;
            this.f2946d = i4;
        }
        return this.f2946d;
    }

    public Object s(int i3) {
        if (!(i3 >= 0 && i3 < this.f2946d)) {
            RuntimeHelpersKt.a("Expected index to be within 0..size()-1, but was " + i3);
        }
        if (this.f2943a) {
            int i4 = this.f2946d;
            long[] jArr = this.f2944b;
            Object[] objArr = this.f2945c;
            int i5 = 0;
            for (int i6 = 0; i6 < i4; i6++) {
                Object obj = objArr[i6];
                if (obj != LongSparseArrayKt.f2947a) {
                    if (i6 != i5) {
                        jArr[i5] = jArr[i6];
                        objArr[i5] = obj;
                        objArr[i6] = null;
                    }
                    i5++;
                }
            }
            this.f2943a = false;
            this.f2946d = i5;
        }
        return this.f2945c[i3];
    }

    public String toString() {
        if (r() <= 0) {
            return JsonUtils.EMPTY_JSON;
        }
        StringBuilder sb = new StringBuilder(this.f2946d * 28);
        sb.append('{');
        int i3 = this.f2946d;
        for (int i4 = 0; i4 < i3; i4++) {
            if (i4 > 0) {
                sb.append(", ");
            }
            sb.append(k(i4));
            sb.append('=');
            Object objS = s(i4);
            if (objS != sb) {
                sb.append(objS);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public LongSparseArray(int i3) {
        if (i3 == 0) {
            this.f2944b = ContainerHelpersKt.f3175b;
            this.f2945c = ContainerHelpersKt.f3176c;
        } else {
            int iF = ContainerHelpersKt.f(i3);
            this.f2944b = new long[iF];
            this.f2945c = new Object[iF];
        }
    }

    public /* synthetic */ LongSparseArray(int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 10 : i3);
    }
}
