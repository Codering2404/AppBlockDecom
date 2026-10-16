package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.collection.internal.RuntimeHelpersKt;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;
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
public class SimpleArrayMap<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f3151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object[] f3152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3153c;

    public SimpleArrayMap() {
        this(0, 1, null);
    }

    private final int c(Object obj, int i3) {
        int i4 = this.f3153c;
        if (i4 == 0) {
            return -1;
        }
        int iA = ContainerHelpersKt.a(this.f3151a, i4, i3);
        if (iA < 0 || Intrinsics.areEqual(obj, this.f3152b[iA << 1])) {
            return iA;
        }
        int i5 = iA + 1;
        while (i5 < i4 && this.f3151a[i5] == i3) {
            if (Intrinsics.areEqual(obj, this.f3152b[i5 << 1])) {
                return i5;
            }
            i5++;
        }
        for (int i6 = iA - 1; i6 >= 0 && this.f3151a[i6] == i3; i6--) {
            if (Intrinsics.areEqual(obj, this.f3152b[i6 << 1])) {
                return i6;
            }
        }
        return ~i5;
    }

    private final int e() {
        int i3 = this.f3153c;
        if (i3 == 0) {
            return -1;
        }
        int iA = ContainerHelpersKt.a(this.f3151a, i3, 0);
        if (iA < 0 || this.f3152b[iA << 1] == null) {
            return iA;
        }
        int i4 = iA + 1;
        while (i4 < i3 && this.f3151a[i4] == 0) {
            if (this.f3152b[i4 << 1] == null) {
                return i4;
            }
            i4++;
        }
        for (int i5 = iA - 1; i5 >= 0 && this.f3151a[i5] == 0; i5--) {
            if (this.f3152b[i5 << 1] == null) {
                return i5;
            }
        }
        return ~i4;
    }

    public final int a(Object obj) {
        int i3 = this.f3153c * 2;
        Object[] objArr = this.f3152b;
        if (obj == null) {
            for (int i4 = 1; i4 < i3; i4 += 2) {
                if (objArr[i4] == null) {
                    return i4 >> 1;
                }
            }
            return -1;
        }
        for (int i5 = 1; i5 < i3; i5 += 2) {
            if (Intrinsics.areEqual(obj, objArr[i5])) {
                return i5 >> 1;
            }
        }
        return -1;
    }

    public void b(int i3) {
        int i4 = this.f3153c;
        int[] iArr = this.f3151a;
        if (iArr.length < i3) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, i3);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
            this.f3151a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f3152b, i3 * 2);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
            this.f3152b = objArrCopyOf;
        }
        if (this.f3153c != i4) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        if (this.f3153c > 0) {
            this.f3151a = ContainerHelpersKt.f3174a;
            this.f3152b = ContainerHelpersKt.f3176c;
            this.f3153c = 0;
        }
        if (this.f3153c > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return d(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return a(obj) >= 0;
    }

    public int d(Object obj) {
        return obj == null ? e() : c(obj, obj.hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof SimpleArrayMap) {
                if (size() != ((SimpleArrayMap) obj).size()) {
                    return false;
                }
                SimpleArrayMap simpleArrayMap = (SimpleArrayMap) obj;
                int i3 = this.f3153c;
                for (int i4 = 0; i4 < i3; i4++) {
                    Object objF = f(i4);
                    Object objJ = j(i4);
                    Object obj2 = simpleArrayMap.get(objF);
                    if (objJ == null) {
                        if (obj2 != null || !simpleArrayMap.containsKey(objF)) {
                            return false;
                        }
                    } else if (!Intrinsics.areEqual(objJ, obj2)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(obj instanceof Map) || size() != ((Map) obj).size()) {
                return false;
            }
            int i5 = this.f3153c;
            for (int i6 = 0; i6 < i5; i6++) {
                Object objF2 = f(i6);
                Object objJ2 = j(i6);
                Object obj3 = ((Map) obj).get(objF2);
                if (objJ2 == null) {
                    if (obj3 != null || !((Map) obj).containsKey(objF2)) {
                        return false;
                    }
                } else if (!Intrinsics.areEqual(objJ2, obj3)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public Object f(int i3) {
        boolean z2 = false;
        if (i3 >= 0 && i3 < this.f3153c) {
            z2 = true;
        }
        if (!z2) {
            RuntimeHelpersKt.a("Expected index to be within 0..size()-1, but was " + i3);
        }
        return this.f3152b[i3 << 1];
    }

    public void g(SimpleArrayMap map) {
        Intrinsics.checkNotNullParameter(map, "map");
        int i3 = map.f3153c;
        b(this.f3153c + i3);
        if (this.f3153c != 0) {
            for (int i4 = 0; i4 < i3; i4++) {
                put(map.f(i4), map.j(i4));
            }
        } else if (i3 > 0) {
            ArraysKt.copyInto(map.f3151a, this.f3151a, 0, 0, i3);
            ArraysKt.copyInto(map.f3152b, this.f3152b, 0, 0, i3 << 1);
            this.f3153c = i3;
        }
    }

    public Object get(Object obj) {
        int iD = d(obj);
        if (iD >= 0) {
            return this.f3152b[(iD << 1) + 1];
        }
        return null;
    }

    public Object getOrDefault(Object obj, Object obj2) {
        int iD = d(obj);
        return iD >= 0 ? this.f3152b[(iD << 1) + 1] : obj2;
    }

    public Object h(int i3) {
        if (!(i3 >= 0 && i3 < this.f3153c)) {
            RuntimeHelpersKt.a("Expected index to be within 0..size()-1, but was " + i3);
        }
        Object[] objArr = this.f3152b;
        int i4 = i3 << 1;
        Object obj = objArr[i4 + 1];
        int i5 = this.f3153c;
        if (i5 <= 1) {
            clear();
            return obj;
        }
        int i6 = i5 - 1;
        int[] iArr = this.f3151a;
        if (iArr.length <= 8 || i5 >= iArr.length / 3) {
            if (i3 < i6) {
                int i7 = i3 + 1;
                ArraysKt.copyInto(iArr, iArr, i3, i7, i5);
                Object[] objArr2 = this.f3152b;
                ArraysKt.copyInto(objArr2, objArr2, i4, i7 << 1, i5 << 1);
            }
            Object[] objArr3 = this.f3152b;
            int i8 = i6 << 1;
            objArr3[i8] = null;
            objArr3[i8 + 1] = null;
        } else {
            int i9 = i5 > 8 ? i5 + (i5 >> 1) : 8;
            int[] iArrCopyOf = Arrays.copyOf(iArr, i9);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
            this.f3151a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f3152b, i9 << 1);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
            this.f3152b = objArrCopyOf;
            if (i5 != this.f3153c) {
                throw new ConcurrentModificationException();
            }
            if (i3 > 0) {
                ArraysKt.copyInto(iArr, this.f3151a, 0, 0, i3);
                ArraysKt.copyInto(objArr, this.f3152b, 0, 0, i4);
            }
            if (i3 < i6) {
                int i10 = i3 + 1;
                ArraysKt.copyInto(iArr, this.f3151a, i3, i10, i5);
                ArraysKt.copyInto(objArr, this.f3152b, i4, i10 << 1, i5 << 1);
            }
        }
        if (i5 != this.f3153c) {
            throw new ConcurrentModificationException();
        }
        this.f3153c = i6;
        return obj;
    }

    public int hashCode() {
        int[] iArr = this.f3151a;
        Object[] objArr = this.f3152b;
        int i3 = this.f3153c;
        int i4 = 1;
        int i5 = 0;
        int iHashCode = 0;
        while (i5 < i3) {
            Object obj = objArr[i4];
            iHashCode += (obj != null ? obj.hashCode() : 0) ^ iArr[i5];
            i5++;
            i4 += 2;
        }
        return iHashCode;
    }

    public Object i(int i3, Object obj) {
        boolean z2 = false;
        if (i3 >= 0 && i3 < this.f3153c) {
            z2 = true;
        }
        if (!z2) {
            RuntimeHelpersKt.a("Expected index to be within 0..size()-1, but was " + i3);
        }
        int i4 = (i3 << 1) + 1;
        Object[] objArr = this.f3152b;
        Object obj2 = objArr[i4];
        objArr[i4] = obj;
        return obj2;
    }

    public boolean isEmpty() {
        return this.f3153c <= 0;
    }

    public Object j(int i3) {
        boolean z2 = false;
        if (i3 >= 0 && i3 < this.f3153c) {
            z2 = true;
        }
        if (!z2) {
            RuntimeHelpersKt.a("Expected index to be within 0..size()-1, but was " + i3);
        }
        return this.f3152b[(i3 << 1) + 1];
    }

    public Object put(Object obj, Object obj2) {
        int i3 = this.f3153c;
        int iHashCode = obj != null ? obj.hashCode() : 0;
        int iC = obj != null ? c(obj, iHashCode) : e();
        if (iC >= 0) {
            int i4 = (iC << 1) + 1;
            Object[] objArr = this.f3152b;
            Object obj3 = objArr[i4];
            objArr[i4] = obj2;
            return obj3;
        }
        int i5 = ~iC;
        int[] iArr = this.f3151a;
        if (i3 >= iArr.length) {
            int i6 = 8;
            if (i3 >= 8) {
                i6 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i6 = 4;
            }
            int[] iArrCopyOf = Arrays.copyOf(iArr, i6);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
            this.f3151a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f3152b, i6 << 1);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
            this.f3152b = objArrCopyOf;
            if (i3 != this.f3153c) {
                throw new ConcurrentModificationException();
            }
        }
        if (i5 < i3) {
            int[] iArr2 = this.f3151a;
            int i7 = i5 + 1;
            ArraysKt.copyInto(iArr2, iArr2, i7, i5, i3);
            Object[] objArr2 = this.f3152b;
            ArraysKt.copyInto(objArr2, objArr2, i7 << 1, i5 << 1, this.f3153c << 1);
        }
        int i8 = this.f3153c;
        if (i3 == i8) {
            int[] iArr3 = this.f3151a;
            if (i5 < iArr3.length) {
                iArr3[i5] = iHashCode;
                Object[] objArr3 = this.f3152b;
                int i9 = i5 << 1;
                objArr3[i9] = obj;
                objArr3[i9 + 1] = obj2;
                this.f3153c = i8 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public Object putIfAbsent(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 == null ? put(obj, obj2) : obj3;
    }

    public Object remove(Object obj) {
        int iD = d(obj);
        if (iD >= 0) {
            return h(iD);
        }
        return null;
    }

    public Object replace(Object obj, Object obj2) {
        int iD = d(obj);
        if (iD >= 0) {
            return i(iD, obj2);
        }
        return null;
    }

    public int size() {
        return this.f3153c;
    }

    public String toString() {
        if (isEmpty()) {
            return JsonUtils.EMPTY_JSON;
        }
        StringBuilder sb = new StringBuilder(this.f3153c * 28);
        sb.append('{');
        int i3 = this.f3153c;
        for (int i4 = 0; i4 < i3; i4++) {
            if (i4 > 0) {
                sb.append(", ");
            }
            Object objF = f(i4);
            if (objF != sb) {
                sb.append(objF);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object objJ = j(i4);
            if (objJ != sb) {
                sb.append(objJ);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public SimpleArrayMap(int i3) {
        this.f3151a = i3 == 0 ? ContainerHelpersKt.f3174a : new int[i3];
        this.f3152b = i3 == 0 ? ContainerHelpersKt.f3176c : new Object[i3 << 1];
    }

    public boolean remove(Object obj, Object obj2) {
        int iD = d(obj);
        if (iD < 0 || !Intrinsics.areEqual(obj2, j(iD))) {
            return false;
        }
        h(iD);
        return true;
    }

    public boolean replace(Object obj, Object obj2, Object obj3) {
        int iD = d(obj);
        if (iD < 0 || !Intrinsics.areEqual(obj2, j(iD))) {
            return false;
        }
        i(iD, obj3);
        return true;
    }

    public /* synthetic */ SimpleArrayMap(int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i3);
    }

    public SimpleArrayMap(SimpleArrayMap simpleArrayMap) {
        this(0, 1, null);
        if (simpleArrayMap != null) {
            g(simpleArrayMap);
        }
    }
}
