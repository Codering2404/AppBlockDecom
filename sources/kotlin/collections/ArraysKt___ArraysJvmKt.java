package kotlin.collections;

import com.facebook.stetho.inspector.helper.qp.sKeKFMqmvNzY;
import com.google.android.gms.ads_identifier.mrU.pMpIcGE;
import com.google.firebase.crashlytics.internal.breadcrumbs.PKU.tDEtWsFLJfe;
import com.revenuecat.purchases.ui.revenuecatui.templates.VWmQ.cJfnYMIyomoWf;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.comparisons.xn.YvFRmou;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
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
public class ArraysKt___ArraysJvmKt extends ArraysKt__ArraysKt {

    /* JADX INFO: renamed from: kotlin.collections.ArraysKt___ArraysJvmKt$asList$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnonymousClass1 extends AbstractList<Byte> implements RandomAccess {
        final /* synthetic */ byte[] $this_asList;

        AnonymousClass1(byte[] bArr) {
            this.$this_asList = bArr;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Byte) {
                return contains(((Number) obj).byteValue());
            }
            return false;
        }

        @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
        public int getSize() {
            return this.$this_asList.length;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Byte) {
                return indexOf(((Number) obj).byteValue());
            }
            return -1;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.$this_asList.length == 0;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Byte) {
                return lastIndexOf(((Number) obj).byteValue());
            }
            return -1;
        }

        public boolean contains(byte b3) {
            return ArraysKt___ArraysKt.contains(this.$this_asList, b3);
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public Byte get(int i3) {
            return Byte.valueOf(this.$this_asList[i3]);
        }

        public int indexOf(byte b3) {
            return ArraysKt___ArraysKt.indexOf(this.$this_asList, b3);
        }

        public int lastIndexOf(byte b3) {
            return ArraysKt___ArraysKt.lastIndexOf(this.$this_asList, b3);
        }
    }

    /* JADX INFO: renamed from: kotlin.collections.ArraysKt___ArraysJvmKt$asList$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnonymousClass2 extends AbstractList<Short> implements RandomAccess {
        final /* synthetic */ short[] $this_asList;

        AnonymousClass2(short[] sArr) {
            this.$this_asList = sArr;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Short) {
                return contains(((Number) obj).shortValue());
            }
            return false;
        }

        @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
        public int getSize() {
            return this.$this_asList.length;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Short) {
                return indexOf(((Number) obj).shortValue());
            }
            return -1;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.$this_asList.length == 0;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Short) {
                return lastIndexOf(((Number) obj).shortValue());
            }
            return -1;
        }

        public boolean contains(short s2) {
            return ArraysKt___ArraysKt.contains(this.$this_asList, s2);
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public Short get(int i3) {
            return Short.valueOf(this.$this_asList[i3]);
        }

        public int indexOf(short s2) {
            return ArraysKt___ArraysKt.indexOf(this.$this_asList, s2);
        }

        public int lastIndexOf(short s2) {
            return ArraysKt___ArraysKt.lastIndexOf(this.$this_asList, s2);
        }
    }

    /* JADX INFO: renamed from: kotlin.collections.ArraysKt___ArraysJvmKt$asList$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnonymousClass3 extends AbstractList<Integer> implements RandomAccess {
        final /* synthetic */ int[] $this_asList;

        AnonymousClass3(int[] iArr) {
            this.$this_asList = iArr;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Integer) {
                return contains(((Number) obj).intValue());
            }
            return false;
        }

        @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
        public int getSize() {
            return this.$this_asList.length;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Integer) {
                return indexOf(((Number) obj).intValue());
            }
            return -1;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.$this_asList.length == 0;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Integer) {
                return lastIndexOf(((Number) obj).intValue());
            }
            return -1;
        }

        public boolean contains(int i3) {
            return ArraysKt___ArraysKt.contains(this.$this_asList, i3);
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public Integer get(int i3) {
            return Integer.valueOf(this.$this_asList[i3]);
        }

        public int indexOf(int i3) {
            return ArraysKt___ArraysKt.indexOf(this.$this_asList, i3);
        }

        public int lastIndexOf(int i3) {
            return ArraysKt___ArraysKt.lastIndexOf(this.$this_asList, i3);
        }
    }

    /* JADX INFO: renamed from: kotlin.collections.ArraysKt___ArraysJvmKt$asList$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnonymousClass4 extends AbstractList<Long> implements RandomAccess {
        final /* synthetic */ long[] $this_asList;

        AnonymousClass4(long[] jArr) {
            this.$this_asList = jArr;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Long) {
                return contains(((Number) obj).longValue());
            }
            return false;
        }

        @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
        public int getSize() {
            return this.$this_asList.length;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Long) {
                return indexOf(((Number) obj).longValue());
            }
            return -1;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.$this_asList.length == 0;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Long) {
                return lastIndexOf(((Number) obj).longValue());
            }
            return -1;
        }

        public boolean contains(long j3) {
            return ArraysKt___ArraysKt.contains(this.$this_asList, j3);
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public Long get(int i3) {
            return Long.valueOf(this.$this_asList[i3]);
        }

        public int indexOf(long j3) {
            return ArraysKt___ArraysKt.indexOf(this.$this_asList, j3);
        }

        public int lastIndexOf(long j3) {
            return ArraysKt___ArraysKt.lastIndexOf(this.$this_asList, j3);
        }
    }

    /* JADX INFO: renamed from: kotlin.collections.ArraysKt___ArraysJvmKt$asList$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnonymousClass5 extends AbstractList<Float> implements RandomAccess {
        final /* synthetic */ float[] $this_asList;

        AnonymousClass5(float[] fArr) {
            this.$this_asList = fArr;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Float) {
                return contains(((Number) obj).floatValue());
            }
            return false;
        }

        @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
        public int getSize() {
            return this.$this_asList.length;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Float) {
                return indexOf(((Number) obj).floatValue());
            }
            return -1;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.$this_asList.length == 0;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Float) {
                return lastIndexOf(((Number) obj).floatValue());
            }
            return -1;
        }

        public boolean contains(float f3) {
            for (float f4 : this.$this_asList) {
                if (Float.floatToIntBits(f4) == Float.floatToIntBits(f3)) {
                    return true;
                }
            }
            return false;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public Float get(int i3) {
            return Float.valueOf(this.$this_asList[i3]);
        }

        public int indexOf(float f3) {
            float[] fArr = this.$this_asList;
            int length = fArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                if (Float.floatToIntBits(fArr[i3]) == Float.floatToIntBits(f3)) {
                    return i3;
                }
            }
            return -1;
        }

        public int lastIndexOf(float f3) {
            float[] fArr = this.$this_asList;
            int length = fArr.length - 1;
            if (length >= 0) {
                while (true) {
                    int i3 = length - 1;
                    if (Float.floatToIntBits(fArr[length]) == Float.floatToIntBits(f3)) {
                        return length;
                    }
                    if (i3 < 0) {
                        break;
                    }
                    length = i3;
                }
            }
            return -1;
        }
    }

    /* JADX INFO: renamed from: kotlin.collections.ArraysKt___ArraysJvmKt$asList$6, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnonymousClass6 extends AbstractList<Double> implements RandomAccess {
        final /* synthetic */ double[] $this_asList;

        AnonymousClass6(double[] dArr) {
            this.$this_asList = dArr;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Double) {
                return contains(((Number) obj).doubleValue());
            }
            return false;
        }

        @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
        public int getSize() {
            return this.$this_asList.length;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Double) {
                return indexOf(((Number) obj).doubleValue());
            }
            return -1;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.$this_asList.length == 0;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Double) {
                return lastIndexOf(((Number) obj).doubleValue());
            }
            return -1;
        }

        public boolean contains(double d3) {
            for (double d4 : this.$this_asList) {
                if (Double.doubleToLongBits(d4) == Double.doubleToLongBits(d3)) {
                    return true;
                }
            }
            return false;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public Double get(int i3) {
            return Double.valueOf(this.$this_asList[i3]);
        }

        public int indexOf(double d3) {
            double[] dArr = this.$this_asList;
            int length = dArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                if (Double.doubleToLongBits(dArr[i3]) == Double.doubleToLongBits(d3)) {
                    return i3;
                }
            }
            return -1;
        }

        public int lastIndexOf(double d3) {
            double[] dArr = this.$this_asList;
            int length = dArr.length - 1;
            if (length >= 0) {
                while (true) {
                    int i3 = length - 1;
                    if (Double.doubleToLongBits(dArr[length]) == Double.doubleToLongBits(d3)) {
                        return length;
                    }
                    if (i3 < 0) {
                        break;
                    }
                    length = i3;
                }
            }
            return -1;
        }
    }

    /* JADX INFO: renamed from: kotlin.collections.ArraysKt___ArraysJvmKt$asList$7, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnonymousClass7 extends AbstractList<Boolean> implements RandomAccess {
        final /* synthetic */ boolean[] $this_asList;

        AnonymousClass7(boolean[] zArr) {
            this.$this_asList = zArr;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Boolean) {
                return contains(((Boolean) obj).booleanValue());
            }
            return false;
        }

        @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
        public int getSize() {
            return this.$this_asList.length;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Boolean) {
                return indexOf(((Boolean) obj).booleanValue());
            }
            return -1;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.$this_asList.length == 0;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Boolean) {
                return lastIndexOf(((Boolean) obj).booleanValue());
            }
            return -1;
        }

        public boolean contains(boolean z2) {
            return ArraysKt___ArraysKt.contains(this.$this_asList, z2);
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public Boolean get(int i3) {
            return Boolean.valueOf(this.$this_asList[i3]);
        }

        public int indexOf(boolean z2) {
            return ArraysKt___ArraysKt.indexOf(this.$this_asList, z2);
        }

        public int lastIndexOf(boolean z2) {
            return ArraysKt___ArraysKt.lastIndexOf(this.$this_asList, z2);
        }
    }

    /* JADX INFO: renamed from: kotlin.collections.ArraysKt___ArraysJvmKt$asList$8, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnonymousClass8 extends AbstractList<Character> implements RandomAccess {
        final /* synthetic */ char[] $this_asList;

        AnonymousClass8(char[] cArr) {
            this.$this_asList = cArr;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Character) {
                return contains(((Character) obj).charValue());
            }
            return false;
        }

        @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
        public int getSize() {
            return this.$this_asList.length;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Character) {
                return indexOf(((Character) obj).charValue());
            }
            return -1;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.$this_asList.length == 0;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Character) {
                return lastIndexOf(((Character) obj).charValue());
            }
            return -1;
        }

        public boolean contains(char c3) {
            return ArraysKt___ArraysKt.contains(this.$this_asList, c3);
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public Character get(int i3) {
            return Character.valueOf(this.$this_asList[i3]);
        }

        public int indexOf(char c3) {
            return ArraysKt___ArraysKt.indexOf(this.$this_asList, c3);
        }

        public int lastIndexOf(char c3) {
            return ArraysKt___ArraysKt.lastIndexOf(this.$this_asList, c3);
        }
    }

    public static <T> List<T> asList(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        List<T> listAsList = ArraysUtilJVM.asList(tArr);
        Intrinsics.checkNotNullExpressionValue(listAsList, "asList(...)");
        return listAsList;
    }

    public static final <T> int binarySearch(T[] tArr, T t2, Comparator<? super T> comparator, int i3, int i4) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return Arrays.binarySearch(tArr, i3, i4, t2, comparator);
    }

    public static /* synthetic */ int binarySearch$default(Object[] objArr, Object obj, Comparator comparator, int i3, int i4, int i5, Object obj2) {
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = objArr.length;
        }
        return binarySearch(objArr, obj, comparator, i3, i4);
    }

    private static final <T> boolean contentDeepEqualsInline(T[] tArr, T[] other) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return ArraysKt__ArraysKt.contentDeepEquals(tArr, other);
    }

    private static final <T> boolean contentDeepEqualsNullable(T[] tArr, T[] tArr2) {
        return ArraysKt__ArraysKt.contentDeepEquals(tArr, tArr2);
    }

    private static final <T> int contentDeepHashCodeInline(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return ArraysKt__ArraysJVMKt.contentDeepHashCode(tArr);
    }

    private static final <T> int contentDeepHashCodeNullable(T[] tArr) {
        return ArraysKt__ArraysJVMKt.contentDeepHashCode(tArr);
    }

    private static final <T> String contentDeepToStringInline(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return ArraysKt__ArraysKt.contentDeepToString(tArr);
    }

    private static final <T> String contentDeepToStringNullable(T[] tArr) {
        return ArraysKt__ArraysKt.contentDeepToString(tArr);
    }

    private static final <T> boolean contentEquals(T[] tArr, T[] tArr2) {
        return Arrays.equals(tArr, tArr2);
    }

    private static final <T> int contentHashCode(T[] tArr) {
        return Arrays.hashCode(tArr);
    }

    private static final <T> String contentToString(T[] tArr) {
        String string = Arrays.toString(tArr);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static <T> T[] copyInto(T[] tArr, T[] destination, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        System.arraycopy(tArr, i4, destination, i3, i5 - i4);
        return destination;
    }

    public static /* synthetic */ Object[] copyInto$default(Object[] objArr, Object[] objArr2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i3 = 0;
        }
        if ((i6 & 4) != 0) {
            i4 = 0;
        }
        if ((i6 & 8) != 0) {
            i5 = objArr.length;
        }
        return copyInto(objArr, objArr2, i3, i4, i5);
    }

    private static final <T> T[] copyOf(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        Intrinsics.checkNotNullExpressionValue(tArr2, "copyOf(...)");
        return tArr2;
    }

    public static <T> T[] copyOfRange(T[] tArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i4, tArr.length);
        T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i3, i4);
        Intrinsics.checkNotNullExpressionValue(tArr2, "copyOfRange(...)");
        return tArr2;
    }

    private static final <T> T[] copyOfRangeInline(T[] tArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return (T[]) copyOfRange(tArr, i3, i4);
    }

    private static final <T> T elementAt(T[] tArr, int i3) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return tArr[i3];
    }

    public static <T> void fill(T[] tArr, T t2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Arrays.fill(tArr, i3, i4, t2);
    }

    public static /* synthetic */ void fill$default(Object[] objArr, Object obj, int i3, int i4, int i5, Object obj2) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = objArr.length;
        }
        fill(objArr, obj, i3, i4);
    }

    public static final <R> List<R> filterIsInstance(Object[] objArr, Class<R> klass) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Intrinsics.checkNotNullParameter(klass, "klass");
        return (List) filterIsInstanceTo(objArr, new ArrayList(), klass);
    }

    public static final <C extends Collection<? super R>, R> C filterIsInstanceTo(Object[] objArr, C destination, Class<R> klass) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(klass, "klass");
        for (Object obj : objArr) {
            if (klass.isInstance(obj)) {
                destination.add(obj);
            }
        }
        return destination;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ Double max(Double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return ArraysKt___ArraysKt.maxOrNull(dArr);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T maxBy(T[] tArr, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        T t2 = tArr[0];
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(tArr);
        if (lastIndex != 0) {
            Comparable comparable = (Comparable) selector.invoke(t2);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    T t3 = tArr[i3];
                    Comparable comparable2 = (Comparable) selector.invoke(t3);
                    if (comparable.compareTo(comparable2) < 0) {
                        t2 = t3;
                        comparable = comparable2;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
        }
        return t2;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ Object maxWith(Object[] objArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return ArraysKt___ArraysKt.maxWithOrNull(objArr, comparator);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ Double min(Double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return ArraysKt___ArraysKt.minOrNull(dArr);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T minBy(T[] tArr, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        T t2 = tArr[0];
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(tArr);
        if (lastIndex != 0) {
            Comparable comparable = (Comparable) selector.invoke(t2);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    T t3 = tArr[i3];
                    Comparable comparable2 = (Comparable) selector.invoke(t3);
                    if (comparable.compareTo(comparable2) > 0) {
                        t2 = t3;
                        comparable = comparable2;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
        }
        return t2;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ Object minWith(Object[] objArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return ArraysKt___ArraysKt.minWithOrNull(objArr, comparator);
    }

    public static <T> T[] plus(T[] tArr, T t2) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int length = tArr.length;
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, length + 1);
        tArr2[length] = t2;
        Intrinsics.checkNotNull(tArr2);
        return tArr2;
    }

    private static final <T> T[] plusElement(T[] tArr, T t2) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return (T[]) plus(tArr, t2);
    }

    public static void sort(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length > 1) {
            Arrays.sort(iArr);
        }
    }

    public static /* synthetic */ void sort$default(Comparable[] comparableArr, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i3 = 0;
        }
        if ((i5 & 2) != 0) {
            i4 = comparableArr.length;
        }
        sort(comparableArr, i3, i4);
    }

    public static final <T> void sortWith(T[] tArr, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }

    public static /* synthetic */ void sortWith$default(Object[] objArr, Comparator comparator, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = objArr.length;
        }
        sortWith(objArr, comparator, i3, i4);
    }

    private static final <T> BigDecimal sumOfBigDecimal(T[] tArr, Function1<? super T, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "valueOf(...)");
        for (T t2 : tArr) {
            bigDecimalValueOf = bigDecimalValueOf.add((BigDecimal) selector.invoke(t2));
            Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    private static final <T> BigInteger sumOfBigInteger(T[] tArr, Function1<? super T, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "valueOf(...)");
        for (T t2 : tArr) {
            bigIntegerValueOf = bigIntegerValueOf.add((BigInteger) selector.invoke(t2));
            Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    public static final <T extends Comparable<? super T>> SortedSet<T> toSortedSet(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(tArr, new TreeSet());
    }

    public static final Byte[] toTypedArray(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Byte[] bArr2 = new Byte[bArr.length];
        int length = bArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            bArr2[i3] = Byte.valueOf(bArr[i3]);
        }
        return bArr2;
    }

    public static final List<Byte> asList(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return new AnonymousClass1(bArr);
    }

    public static final <T> int binarySearch(T[] tArr, T t2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return Arrays.binarySearch(tArr, i3, i4, t2);
    }

    public static /* synthetic */ int binarySearch$default(Object[] objArr, Object obj, int i3, int i4, int i5, Object obj2) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = objArr.length;
        }
        return binarySearch(objArr, obj, i3, i4);
    }

    private static final boolean contentEquals(byte[] bArr, byte[] bArr2) {
        return Arrays.equals(bArr, bArr2);
    }

    private static final int contentHashCode(byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    private static final String contentToString(byte[] bArr) {
        String string = Arrays.toString(bArr);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static byte[] copyInto(byte[] bArr, byte[] destination, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        System.arraycopy(bArr, i4, destination, i3, i5 - i4);
        return destination;
    }

    public static /* synthetic */ byte[] copyInto$default(byte[] bArr, byte[] bArr2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i3 = 0;
        }
        if ((i6 & 4) != 0) {
            i4 = 0;
        }
        if ((i6 & 8) != 0) {
            i5 = bArr.length;
        }
        return copyInto(bArr, bArr2, i3, i4, i5);
    }

    private static final byte[] copyOf(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, tDEtWsFLJfe.TdB);
        return bArrCopyOf;
    }

    private static final byte[] copyOfRangeInline(byte[] bArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return copyOfRange(bArr, i3, i4);
    }

    private static final byte elementAt(byte[] bArr, int i3) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return bArr[i3];
    }

    public static void fill(byte[] bArr, byte b3, int i3, int i4) {
        Intrinsics.checkNotNullParameter(bArr, YvFRmou.SNDUVvLEnbV);
        Arrays.fill(bArr, i3, i4, b3);
    }

    public static /* synthetic */ void fill$default(byte[] bArr, byte b3, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = bArr.length;
        }
        fill(bArr, b3, i3, i4);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ Float max(Float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return ArraysKt___ArraysKt.maxOrNull(fArr);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ Byte maxWith(byte[] bArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return ArraysKt___ArraysKt.maxWithOrNull(bArr, (Comparator<? super Byte>) comparator);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ Float min(Float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return ArraysKt___ArraysKt.minOrNull(fArr);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ Byte minWith(byte[] bArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return ArraysKt___ArraysKt.minWithOrNull(bArr, (Comparator<? super Byte>) comparator);
    }

    public static final void sort(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length > 1) {
            Arrays.sort(jArr);
        }
    }

    public static /* synthetic */ void sort$default(byte[] bArr, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i3 = 0;
        }
        if ((i5 & 2) != 0) {
            i4 = bArr.length;
        }
        sort(bArr, i3, i4);
    }

    public static <T> void sortWith(T[] tArr, Comparator<? super T> comparator, int i3, int i4) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Arrays.sort(tArr, i3, i4, comparator);
    }

    public static final SortedSet<Byte> toSortedSet(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(bArr, new TreeSet());
    }

    public static final List<Short> asList(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return new AnonymousClass2(sArr);
    }

    public static final int binarySearch(byte[] bArr, byte b3, int i3, int i4) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return Arrays.binarySearch(bArr, i3, i4, b3);
    }

    public static /* synthetic */ int binarySearch$default(byte[] bArr, byte b3, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = bArr.length;
        }
        return binarySearch(bArr, b3, i3, i4);
    }

    private static final boolean contentEquals(short[] sArr, short[] sArr2) {
        return Arrays.equals(sArr, sArr2);
    }

    private static final int contentHashCode(short[] sArr) {
        return Arrays.hashCode(sArr);
    }

    private static final String contentToString(short[] sArr) {
        String string = Arrays.toString(sArr);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static short[] copyInto(short[] sArr, short[] destination, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        System.arraycopy(sArr, i4, destination, i3, i5 - i4);
        return destination;
    }

    public static /* synthetic */ short[] copyInto$default(short[] sArr, short[] sArr2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i3 = 0;
        }
        if ((i6 & 4) != 0) {
            i4 = 0;
        }
        if ((i6 & 8) != 0) {
            i5 = sArr.length;
        }
        return copyInto(sArr, sArr2, i3, i4, i5);
    }

    private static final short[] copyOf(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        Intrinsics.checkNotNullExpressionValue(sArrCopyOf, "copyOf(...)");
        return sArrCopyOf;
    }

    public static byte[] copyOfRange(byte[] bArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i4, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i3, i4);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOfRange, "copyOfRange(...)");
        return bArrCopyOfRange;
    }

    private static final short[] copyOfRangeInline(short[] sArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return copyOfRange(sArr, i3, i4);
    }

    private static final short elementAt(short[] sArr, int i3) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return sArr[i3];
    }

    public static void fill(short[] sArr, short s2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Arrays.fill(sArr, i3, i4, s2);
    }

    public static /* synthetic */ void fill$default(short[] sArr, short s2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = sArr.length;
        }
        fill(sArr, s2, i3, i4);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ Comparable max(Comparable[] comparableArr) {
        Intrinsics.checkNotNullParameter(comparableArr, "<this>");
        return ArraysKt___ArraysKt.maxOrNull(comparableArr);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ Short maxWith(short[] sArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return ArraysKt___ArraysKt.maxWithOrNull(sArr, (Comparator<? super Short>) comparator);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ Comparable min(Comparable[] comparableArr) {
        Intrinsics.checkNotNullParameter(comparableArr, "<this>");
        return ArraysKt___ArraysKt.minOrNull(comparableArr);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ Short minWith(short[] sArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return ArraysKt___ArraysKt.minWithOrNull(sArr, (Comparator<? super Short>) comparator);
    }

    public static final void sort(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length > 1) {
            Arrays.sort(bArr);
        }
    }

    public static /* synthetic */ void sort$default(short[] sArr, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i3 = 0;
        }
        if ((i5 & 2) != 0) {
            i4 = sArr.length;
        }
        sort(sArr, i3, i4);
    }

    public static final SortedSet<Short> toSortedSet(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(sArr, new TreeSet());
    }

    public static final List<Integer> asList(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return new AnonymousClass3(iArr);
    }

    public static final int binarySearch(short[] sArr, short s2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return Arrays.binarySearch(sArr, i3, i4, s2);
    }

    public static /* synthetic */ int binarySearch$default(short[] sArr, short s2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = sArr.length;
        }
        return binarySearch(sArr, s2, i3, i4);
    }

    private static final boolean contentEquals(int[] iArr, int[] iArr2) {
        return Arrays.equals(iArr, iArr2);
    }

    private static final int contentHashCode(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    private static final String contentToString(int[] iArr) {
        String string = Arrays.toString(iArr);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static int[] copyInto(int[] iArr, int[] destination, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        System.arraycopy(iArr, i4, destination, i3, i5 - i4);
        return destination;
    }

    public static /* synthetic */ int[] copyInto$default(int[] iArr, int[] iArr2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i3 = 0;
        }
        if ((i6 & 4) != 0) {
            i4 = 0;
        }
        if ((i6 & 8) != 0) {
            i5 = iArr.length;
        }
        return copyInto(iArr, iArr2, i3, i4, i5);
    }

    private static final int[] copyOf(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        return iArrCopyOf;
    }

    private static final int[] copyOfRangeInline(int[] iArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return copyOfRange(iArr, i3, i4);
    }

    private static final int elementAt(int[] iArr, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return iArr[i3];
    }

    public static void fill(int[] iArr, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Arrays.fill(iArr, i4, i5, i3);
    }

    public static /* synthetic */ void fill$default(int[] iArr, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i4 = 0;
        }
        if ((i6 & 4) != 0) {
            i5 = iArr.length;
        }
        fill(iArr, i3, i4, i5);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ Byte max(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return ArraysKt___ArraysKt.maxOrNull(bArr);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ Integer maxWith(int[] iArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return ArraysKt___ArraysKt.maxWithOrNull(iArr, (Comparator<? super Integer>) comparator);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ Byte min(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return ArraysKt___ArraysKt.minOrNull(bArr);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ Integer minWith(int[] iArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return ArraysKt___ArraysKt.minWithOrNull(iArr, (Comparator<? super Integer>) comparator);
    }

    public static final void sort(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (sArr.length > 1) {
            Arrays.sort(sArr);
        }
    }

    public static /* synthetic */ void sort$default(int[] iArr, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i3 = 0;
        }
        if ((i5 & 2) != 0) {
            i4 = iArr.length;
        }
        sort(iArr, i3, i4);
    }

    private static final BigDecimal sumOfBigDecimal(byte[] bArr, Function1<? super Byte, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "valueOf(...)");
        for (byte b3 : bArr) {
            bigDecimalValueOf = bigDecimalValueOf.add((BigDecimal) selector.invoke(Byte.valueOf(b3)));
            Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    private static final BigInteger sumOfBigInteger(byte[] bArr, Function1<? super Byte, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "valueOf(...)");
        for (byte b3 : bArr) {
            bigIntegerValueOf = bigIntegerValueOf.add((BigInteger) selector.invoke(Byte.valueOf(b3)));
            Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    public static final SortedSet<Integer> toSortedSet(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(iArr, new TreeSet());
    }

    public static final Short[] toTypedArray(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Short[] shArr = new Short[sArr.length];
        int length = sArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            shArr[i3] = Short.valueOf(sArr[i3]);
        }
        return shArr;
    }

    public static final List<Long> asList(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return new AnonymousClass4(jArr);
    }

    public static final int binarySearch(int[] iArr, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return Arrays.binarySearch(iArr, i4, i5, i3);
    }

    public static /* synthetic */ int binarySearch$default(int[] iArr, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i4 = 0;
        }
        if ((i6 & 4) != 0) {
            i5 = iArr.length;
        }
        return binarySearch(iArr, i3, i4, i5);
    }

    private static final boolean contentEquals(long[] jArr, long[] jArr2) {
        return Arrays.equals(jArr, jArr2);
    }

    private static final int contentHashCode(long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    private static final String contentToString(long[] jArr) {
        String string = Arrays.toString(jArr);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static long[] copyInto(long[] jArr, long[] destination, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        System.arraycopy(jArr, i4, destination, i3, i5 - i4);
        return destination;
    }

    public static /* synthetic */ long[] copyInto$default(long[] jArr, long[] jArr2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i3 = 0;
        }
        if ((i6 & 4) != 0) {
            i4 = 0;
        }
        if ((i6 & 8) != 0) {
            i5 = jArr.length;
        }
        return copyInto(jArr, jArr2, i3, i4, i5);
    }

    private static final long[] copyOf(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
        return jArrCopyOf;
    }

    public static short[] copyOfRange(short[] sArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i4, sArr.length);
        short[] sArrCopyOfRange = Arrays.copyOfRange(sArr, i3, i4);
        Intrinsics.checkNotNullExpressionValue(sArrCopyOfRange, "copyOfRange(...)");
        return sArrCopyOfRange;
    }

    private static final long[] copyOfRangeInline(long[] jArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return copyOfRange(jArr, i3, i4);
    }

    private static final long elementAt(long[] jArr, int i3) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return jArr[i3];
    }

    public static void fill(long[] jArr, long j3, int i3, int i4) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Arrays.fill(jArr, i3, i4, j3);
    }

    public static /* synthetic */ void fill$default(long[] jArr, long j3, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = jArr.length;
        }
        fill(jArr, j3, i3, i4);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ Short max(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return ArraysKt___ArraysKt.maxOrNull(sArr);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ Long maxWith(long[] jArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return ArraysKt___ArraysKt.maxWithOrNull(jArr, (Comparator<? super Long>) comparator);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ Short min(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return ArraysKt___ArraysKt.minOrNull(sArr);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ Long minWith(long[] jArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return ArraysKt___ArraysKt.minWithOrNull(jArr, (Comparator<? super Long>) comparator);
    }

    public static byte[] plus(byte[] bArr, byte b3) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int length = bArr.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, length + 1);
        bArrCopyOf[length] = b3;
        Intrinsics.checkNotNull(bArrCopyOf);
        return bArrCopyOf;
    }

    public static final void sort(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, sKeKFMqmvNzY.umJcB);
        if (dArr.length > 1) {
            Arrays.sort(dArr);
        }
    }

    public static /* synthetic */ void sort$default(long[] jArr, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i3 = 0;
        }
        if ((i5 & 2) != 0) {
            i4 = jArr.length;
        }
        sort(jArr, i3, i4);
    }

    public static final SortedSet<Long> toSortedSet(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(jArr, new TreeSet());
    }

    public static final List<Float> asList(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return new AnonymousClass5(fArr);
    }

    public static final int binarySearch(long[] jArr, long j3, int i3, int i4) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return Arrays.binarySearch(jArr, i3, i4, j3);
    }

    public static /* synthetic */ int binarySearch$default(long[] jArr, long j3, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = jArr.length;
        }
        return binarySearch(jArr, j3, i3, i4);
    }

    private static final boolean contentEquals(float[] fArr, float[] fArr2) {
        return Arrays.equals(fArr, fArr2);
    }

    private static final int contentHashCode(float[] fArr) {
        return Arrays.hashCode(fArr);
    }

    private static final String contentToString(float[] fArr) {
        String string = Arrays.toString(fArr);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static float[] copyInto(float[] fArr, float[] destination, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        System.arraycopy(fArr, i4, destination, i3, i5 - i4);
        return destination;
    }

    public static /* synthetic */ float[] copyInto$default(float[] fArr, float[] fArr2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i3 = 0;
        }
        if ((i6 & 4) != 0) {
            i4 = 0;
        }
        if ((i6 & 8) != 0) {
            i5 = fArr.length;
        }
        return copyInto(fArr, fArr2, i3, i4, i5);
    }

    private static final float[] copyOf(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        Intrinsics.checkNotNullExpressionValue(fArrCopyOf, "copyOf(...)");
        return fArrCopyOf;
    }

    private static final float[] copyOfRangeInline(float[] fArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return copyOfRange(fArr, i3, i4);
    }

    private static final float elementAt(float[] fArr, int i3) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return fArr[i3];
    }

    public static final void fill(float[] fArr, float f3, int i3, int i4) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Arrays.fill(fArr, i3, i4, f3);
    }

    public static /* synthetic */ void fill$default(float[] fArr, float f3, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = fArr.length;
        }
        fill(fArr, f3, i3, i4);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ Integer max(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return ArraysKt___ArraysKt.maxOrNull(iArr);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ Float maxWith(float[] fArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return ArraysKt___ArraysKt.maxWithOrNull(fArr, (Comparator<? super Float>) comparator);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ Integer min(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return ArraysKt___ArraysKt.minOrNull(iArr);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ Float minWith(float[] fArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return ArraysKt___ArraysKt.minWithOrNull(fArr, (Comparator<? super Float>) comparator);
    }

    public static final void sort(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length > 1) {
            Arrays.sort(fArr);
        }
    }

    public static /* synthetic */ void sort$default(float[] fArr, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i3 = 0;
        }
        if ((i5 & 2) != 0) {
            i4 = fArr.length;
        }
        sort(fArr, i3, i4);
    }

    public static final SortedSet<Float> toSortedSet(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(fArr, new TreeSet());
    }

    public static final List<Double> asList(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return new AnonymousClass6(dArr);
    }

    public static final int binarySearch(float[] fArr, float f3, int i3, int i4) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return Arrays.binarySearch(fArr, i3, i4, f3);
    }

    public static /* synthetic */ int binarySearch$default(float[] fArr, float f3, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = fArr.length;
        }
        return binarySearch(fArr, f3, i3, i4);
    }

    private static final boolean contentEquals(double[] dArr, double[] dArr2) {
        return Arrays.equals(dArr, dArr2);
    }

    private static final int contentHashCode(double[] dArr) {
        return Arrays.hashCode(dArr);
    }

    private static final String contentToString(double[] dArr) {
        String string = Arrays.toString(dArr);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static final double[] copyInto(double[] dArr, double[] destination, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        System.arraycopy(dArr, i4, destination, i3, i5 - i4);
        return destination;
    }

    public static /* synthetic */ double[] copyInto$default(double[] dArr, double[] dArr2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i3 = 0;
        }
        if ((i6 & 4) != 0) {
            i4 = 0;
        }
        if ((i6 & 8) != 0) {
            i5 = dArr.length;
        }
        return copyInto(dArr, dArr2, i3, i4, i5);
    }

    private static final double[] copyOf(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        double[] dArrCopyOf = Arrays.copyOf(dArr, dArr.length);
        Intrinsics.checkNotNullExpressionValue(dArrCopyOf, "copyOf(...)");
        return dArrCopyOf;
    }

    public static int[] copyOfRange(int[] iArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i4, iArr.length);
        int[] iArrCopyOfRange = Arrays.copyOfRange(iArr, i3, i4);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOfRange, "copyOfRange(...)");
        return iArrCopyOfRange;
    }

    private static final double[] copyOfRangeInline(double[] dArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return copyOfRange(dArr, i3, i4);
    }

    private static final double elementAt(double[] dArr, int i3) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return dArr[i3];
    }

    public static final void fill(double[] dArr, double d3, int i3, int i4) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Arrays.fill(dArr, i3, i4, d3);
    }

    public static /* synthetic */ void fill$default(double[] dArr, double d3, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = dArr.length;
        }
        fill(dArr, d3, i3, i4);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ Long max(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return ArraysKt___ArraysKt.maxOrNull(jArr);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ Double maxWith(double[] dArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return ArraysKt___ArraysKt.maxWithOrNull(dArr, (Comparator<? super Double>) comparator);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ Long min(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return ArraysKt___ArraysKt.minOrNull(jArr);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ Double minWith(double[] dArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return ArraysKt___ArraysKt.minWithOrNull(dArr, (Comparator<? super Double>) comparator);
    }

    public static final void sort(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length > 1) {
            Arrays.sort(cArr);
        }
    }

    public static /* synthetic */ void sort$default(double[] dArr, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i3 = 0;
        }
        if ((i5 & 2) != 0) {
            i4 = dArr.length;
        }
        sort(dArr, i3, i4);
    }

    private static final BigDecimal sumOfBigDecimal(short[] sArr, Function1<? super Short, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "valueOf(...)");
        for (short s2 : sArr) {
            bigDecimalValueOf = bigDecimalValueOf.add((BigDecimal) selector.invoke(Short.valueOf(s2)));
            Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    private static final BigInteger sumOfBigInteger(short[] sArr, Function1<? super Short, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "valueOf(...)");
        for (short s2 : sArr) {
            bigIntegerValueOf = bigIntegerValueOf.add((BigInteger) selector.invoke(Short.valueOf(s2)));
            Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    public static final SortedSet<Double> toSortedSet(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(dArr, new TreeSet());
    }

    public static Integer[] toTypedArray(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Integer[] numArr = new Integer[iArr.length];
        int length = iArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            numArr[i3] = Integer.valueOf(iArr[i3]);
        }
        return numArr;
    }

    public static final List<Boolean> asList(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return new AnonymousClass7(zArr);
    }

    public static final int binarySearch(double[] dArr, double d3, int i3, int i4) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return Arrays.binarySearch(dArr, i3, i4, d3);
    }

    public static /* synthetic */ int binarySearch$default(double[] dArr, double d3, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = dArr.length;
        }
        return binarySearch(dArr, d3, i3, i4);
    }

    private static final boolean contentEquals(boolean[] zArr, boolean[] zArr2) {
        return Arrays.equals(zArr, zArr2);
    }

    private static final int contentHashCode(boolean[] zArr) {
        return Arrays.hashCode(zArr);
    }

    private static final String contentToString(boolean[] zArr) {
        String string = Arrays.toString(zArr);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static final boolean[] copyInto(boolean[] zArr, boolean[] destination, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        System.arraycopy(zArr, i4, destination, i3, i5 - i4);
        return destination;
    }

    public static /* synthetic */ boolean[] copyInto$default(boolean[] zArr, boolean[] zArr2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i3 = 0;
        }
        if ((i6 & 4) != 0) {
            i4 = 0;
        }
        if ((i6 & 8) != 0) {
            i5 = zArr.length;
        }
        return copyInto(zArr, zArr2, i3, i4, i5);
    }

    private static final boolean[] copyOf(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        boolean[] zArrCopyOf = Arrays.copyOf(zArr, zArr.length);
        Intrinsics.checkNotNullExpressionValue(zArrCopyOf, "copyOf(...)");
        return zArrCopyOf;
    }

    private static final boolean[] copyOfRangeInline(boolean[] zArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return copyOfRange(zArr, i3, i4);
    }

    private static final boolean elementAt(boolean[] zArr, int i3) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return zArr[i3];
    }

    public static final void fill(boolean[] zArr, boolean z2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Arrays.fill(zArr, i3, i4, z2);
    }

    public static /* synthetic */ void fill$default(boolean[] zArr, boolean z2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = zArr.length;
        }
        fill(zArr, z2, i3, i4);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ Float max(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return ArraysKt___ArraysKt.maxOrNull(fArr);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ <R extends Comparable<? super R>> Byte maxBy(byte[] bArr, Function1<? super Byte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        byte b3 = bArr[0];
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(bArr);
        if (lastIndex == 0) {
            return Byte.valueOf(b3);
        }
        Comparable comparable = (Comparable) selector.invoke(Byte.valueOf(b3));
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte b4 = bArr[i3];
                Comparable comparable2 = (Comparable) selector.invoke(Byte.valueOf(b4));
                if (comparable.compareTo(comparable2) < 0) {
                    b3 = b4;
                    comparable = comparable2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Byte.valueOf(b3);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ Boolean maxWith(boolean[] zArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return ArraysKt___ArraysKt.maxWithOrNull(zArr, (Comparator<? super Boolean>) comparator);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ Float min(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return ArraysKt___ArraysKt.minOrNull(fArr);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ <R extends Comparable<? super R>> Byte minBy(byte[] bArr, Function1<? super Byte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        byte b3 = bArr[0];
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(bArr);
        if (lastIndex == 0) {
            return Byte.valueOf(b3);
        }
        Comparable comparable = (Comparable) selector.invoke(Byte.valueOf(b3));
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte b4 = bArr[i3];
                Comparable comparable2 = (Comparable) selector.invoke(Byte.valueOf(b4));
                if (comparable.compareTo(comparable2) > 0) {
                    b3 = b4;
                    comparable = comparable2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Byte.valueOf(b3);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ Boolean minWith(boolean[] zArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return ArraysKt___ArraysKt.minWithOrNull(zArr, (Comparator<? super Boolean>) comparator);
    }

    private static final <T extends Comparable<? super T>> void sort(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        sort((Object[]) tArr);
    }

    public static /* synthetic */ void sort$default(char[] cArr, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i3 = 0;
        }
        if ((i5 & 2) != 0) {
            i4 = cArr.length;
        }
        sort(cArr, i3, i4);
    }

    public static final SortedSet<Boolean> toSortedSet(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(zArr, new TreeSet());
    }

    public static final List<Character> asList(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return new AnonymousClass8(cArr);
    }

    public static final int binarySearch(char[] cArr, char c3, int i3, int i4) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return Arrays.binarySearch(cArr, i3, i4, c3);
    }

    public static /* synthetic */ int binarySearch$default(char[] cArr, char c3, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = cArr.length;
        }
        return binarySearch(cArr, c3, i3, i4);
    }

    private static final boolean contentEquals(char[] cArr, char[] cArr2) {
        return Arrays.equals(cArr, cArr2);
    }

    private static final int contentHashCode(char[] cArr) {
        return Arrays.hashCode(cArr);
    }

    private static final String contentToString(char[] cArr) {
        String string = Arrays.toString(cArr);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static char[] copyInto(char[] cArr, char[] destination, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        System.arraycopy(cArr, i4, destination, i3, i5 - i4);
        return destination;
    }

    public static /* synthetic */ char[] copyInto$default(char[] cArr, char[] cArr2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i3 = 0;
        }
        if ((i6 & 4) != 0) {
            i4 = 0;
        }
        if ((i6 & 8) != 0) {
            i5 = cArr.length;
        }
        return copyInto(cArr, cArr2, i3, i4, i5);
    }

    private static final char[] copyOf(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        char[] cArrCopyOf = Arrays.copyOf(cArr, cArr.length);
        Intrinsics.checkNotNullExpressionValue(cArrCopyOf, "copyOf(...)");
        return cArrCopyOf;
    }

    public static long[] copyOfRange(long[] jArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i4, jArr.length);
        long[] jArrCopyOfRange = Arrays.copyOfRange(jArr, i3, i4);
        Intrinsics.checkNotNullExpressionValue(jArrCopyOfRange, "copyOfRange(...)");
        return jArrCopyOfRange;
    }

    private static final char[] copyOfRangeInline(char[] cArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return copyOfRange(cArr, i3, i4);
    }

    private static final char elementAt(char[] cArr, int i3) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return cArr[i3];
    }

    public static final void fill(char[] cArr, char c3, int i3, int i4) {
        Intrinsics.checkNotNullParameter(cArr, cJfnYMIyomoWf.yTezcOFrrMYC);
        Arrays.fill(cArr, i3, i4, c3);
    }

    public static /* synthetic */ void fill$default(char[] cArr, char c3, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = cArr.length;
        }
        fill(cArr, c3, i3, i4);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ Double max(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return ArraysKt___ArraysKt.maxOrNull(dArr);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ Character maxWith(char[] cArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return ArraysKt___ArraysKt.maxWithOrNull(cArr, (Comparator<? super Character>) comparator);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ Double min(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, pMpIcGE.UdiIaaEhhjFWypT);
        return ArraysKt___ArraysKt.minOrNull(dArr);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ Character minWith(char[] cArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, sKeKFMqmvNzY.svOzpzEfmYpw);
        return ArraysKt___ArraysKt.minWithOrNull(cArr, (Comparator<? super Character>) comparator);
    }

    public static short[] plus(short[] sArr, short s2) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        int length = sArr.length;
        short[] sArrCopyOf = Arrays.copyOf(sArr, length + 1);
        sArrCopyOf[length] = s2;
        Intrinsics.checkNotNull(sArrCopyOf);
        return sArrCopyOf;
    }

    public static <T> void sort(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length > 1) {
            Arrays.sort(tArr);
        }
    }

    public static /* synthetic */ void sort$default(Object[] objArr, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i3 = 0;
        }
        if ((i5 & 2) != 0) {
            i4 = objArr.length;
        }
        sort(objArr, i3, i4);
    }

    public static final SortedSet<Character> toSortedSet(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(cArr, new TreeSet());
    }

    private static final byte[] copyOf(byte[] bArr, int i3) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i3);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ Character max(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return ArraysKt___ArraysKt.maxOrNull(cArr);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ Character min(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return ArraysKt___ArraysKt.minOrNull(cArr);
    }

    public static final <T extends Comparable<? super T>> void sort(T[] tArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Arrays.sort(tArr, i3, i4);
    }

    private static final BigDecimal sumOfBigDecimal(int[] iArr, Function1<? super Integer, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "valueOf(...)");
        for (int i3 : iArr) {
            bigDecimalValueOf = bigDecimalValueOf.add((BigDecimal) selector.invoke(Integer.valueOf(i3)));
            Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    private static final BigInteger sumOfBigInteger(int[] iArr, Function1<? super Integer, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "valueOf(...)");
        for (int i3 : iArr) {
            bigIntegerValueOf = bigIntegerValueOf.add((BigInteger) selector.invoke(Integer.valueOf(i3)));
            Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    public static final <T> SortedSet<T> toSortedSet(T[] tArr, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(tArr, new TreeSet(comparator));
    }

    public static Long[] toTypedArray(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Long[] lArr = new Long[jArr.length];
        int length = jArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            lArr[i3] = Long.valueOf(jArr[i3]);
        }
        return lArr;
    }

    private static final short[] copyOf(short[] sArr, int i3) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        short[] sArrCopyOf = Arrays.copyOf(sArr, i3);
        Intrinsics.checkNotNullExpressionValue(sArrCopyOf, "copyOf(...)");
        return sArrCopyOf;
    }

    public static final float[] copyOfRange(float[] fArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i4, fArr.length);
        float[] fArrCopyOfRange = Arrays.copyOfRange(fArr, i3, i4);
        Intrinsics.checkNotNullExpressionValue(fArrCopyOfRange, "copyOfRange(...)");
        return fArrCopyOfRange;
    }

    public static final void sort(byte[] bArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Arrays.sort(bArr, i3, i4);
    }

    private static final int[] copyOf(int[] iArr, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int[] iArrCopyOf = Arrays.copyOf(iArr, i3);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        return iArrCopyOf;
    }

    public static final void sort(short[] sArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Arrays.sort(sArr, i3, i4);
    }

    private static final long[] copyOf(long[] jArr, int i3) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        long[] jArrCopyOf = Arrays.copyOf(jArr, i3);
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
        return jArrCopyOf;
    }

    public static final double[] copyOfRange(double[] dArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i4, dArr.length);
        double[] dArrCopyOfRange = Arrays.copyOfRange(dArr, i3, i4);
        Intrinsics.checkNotNullExpressionValue(dArrCopyOfRange, "copyOfRange(...)");
        return dArrCopyOfRange;
    }

    public static int[] plus(int[] iArr, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int length = iArr.length;
        int[] iArrCopyOf = Arrays.copyOf(iArr, length + 1);
        iArrCopyOf[length] = i3;
        Intrinsics.checkNotNull(iArrCopyOf);
        return iArrCopyOf;
    }

    public static void sort(int[] iArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Arrays.sort(iArr, i3, i4);
    }

    private static final BigDecimal sumOfBigDecimal(long[] jArr, Function1<? super Long, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "valueOf(...)");
        for (long j3 : jArr) {
            bigDecimalValueOf = bigDecimalValueOf.add((BigDecimal) selector.invoke(Long.valueOf(j3)));
            Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    private static final BigInteger sumOfBigInteger(long[] jArr, Function1<? super Long, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "valueOf(...)");
        for (long j3 : jArr) {
            bigIntegerValueOf = bigIntegerValueOf.add((BigInteger) selector.invoke(Long.valueOf(j3)));
            Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    public static Float[] toTypedArray(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Float[] fArr2 = new Float[fArr.length];
        int length = fArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            fArr2[i3] = Float.valueOf(fArr[i3]);
        }
        return fArr2;
    }

    private static final float[] copyOf(float[] fArr, int i3) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        float[] fArrCopyOf = Arrays.copyOf(fArr, i3);
        Intrinsics.checkNotNullExpressionValue(fArrCopyOf, "copyOf(...)");
        return fArrCopyOf;
    }

    public static final void sort(long[] jArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Arrays.sort(jArr, i3, i4);
    }

    private static final double[] copyOf(double[] dArr, int i3) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        double[] dArrCopyOf = Arrays.copyOf(dArr, i3);
        Intrinsics.checkNotNullExpressionValue(dArrCopyOf, "copyOf(...)");
        return dArrCopyOf;
    }

    public static final boolean[] copyOfRange(boolean[] zArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i4, zArr.length);
        boolean[] zArrCopyOfRange = Arrays.copyOfRange(zArr, i3, i4);
        Intrinsics.checkNotNullExpressionValue(zArrCopyOfRange, "copyOfRange(...)");
        return zArrCopyOfRange;
    }

    public static final void sort(float[] fArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Arrays.sort(fArr, i3, i4);
    }

    private static final boolean[] copyOf(boolean[] zArr, int i3) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        boolean[] zArrCopyOf = Arrays.copyOf(zArr, i3);
        Intrinsics.checkNotNullExpressionValue(zArrCopyOf, "copyOf(...)");
        return zArrCopyOf;
    }

    public static final void sort(double[] dArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Arrays.sort(dArr, i3, i4);
    }

    private static final BigDecimal sumOfBigDecimal(float[] fArr, Function1<? super Float, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "valueOf(...)");
        for (float f3 : fArr) {
            bigDecimalValueOf = bigDecimalValueOf.add((BigDecimal) selector.invoke(Float.valueOf(f3)));
            Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    private static final BigInteger sumOfBigInteger(float[] fArr, Function1<? super Float, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "valueOf(...)");
        for (float f3 : fArr) {
            bigIntegerValueOf = bigIntegerValueOf.add((BigInteger) selector.invoke(Float.valueOf(f3)));
            Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    public static Double[] toTypedArray(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Double[] dArr2 = new Double[dArr.length];
        int length = dArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            dArr2[i3] = Double.valueOf(dArr[i3]);
        }
        return dArr2;
    }

    private static final char[] copyOf(char[] cArr, int i3) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        char[] cArrCopyOf = Arrays.copyOf(cArr, i3);
        Intrinsics.checkNotNullExpressionValue(cArrCopyOf, "copyOf(...)");
        return cArrCopyOf;
    }

    public static final char[] copyOfRange(char[] cArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i4, cArr.length);
        char[] cArrCopyOfRange = Arrays.copyOfRange(cArr, i3, i4);
        Intrinsics.checkNotNullExpressionValue(cArrCopyOfRange, "copyOfRange(...)");
        return cArrCopyOfRange;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ <R extends Comparable<? super R>> Short maxBy(short[] sArr, Function1<? super Short, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        short s2 = sArr[0];
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(sArr);
        if (lastIndex == 0) {
            return Short.valueOf(s2);
        }
        Comparable comparable = (Comparable) selector.invoke(Short.valueOf(s2));
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                short s3 = sArr[i3];
                Comparable comparable2 = (Comparable) selector.invoke(Short.valueOf(s3));
                if (comparable.compareTo(comparable2) < 0) {
                    s2 = s3;
                    comparable = comparable2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Short.valueOf(s2);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ <R extends Comparable<? super R>> Short minBy(short[] sArr, Function1<? super Short, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        short s2 = sArr[0];
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(sArr);
        if (lastIndex == 0) {
            return Short.valueOf(s2);
        }
        Comparable comparable = (Comparable) selector.invoke(Short.valueOf(s2));
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                short s3 = sArr[i3];
                Comparable comparable2 = (Comparable) selector.invoke(Short.valueOf(s3));
                if (comparable.compareTo(comparable2) > 0) {
                    s2 = s3;
                    comparable = comparable2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Short.valueOf(s2);
    }

    public static long[] plus(long[] jArr, long j3) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        int length = jArr.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, length + 1);
        jArrCopyOf[length] = j3;
        Intrinsics.checkNotNull(jArrCopyOf);
        return jArrCopyOf;
    }

    public static final void sort(char[] cArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Arrays.sort(cArr, i3, i4);
    }

    private static final <T> T[] copyOf(T[] tArr, int i3) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, i3);
        Intrinsics.checkNotNullExpressionValue(tArr2, "copyOf(...)");
        return tArr2;
    }

    public static final <T> void sort(T[] tArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Arrays.sort(tArr, i3, i4);
    }

    private static final BigDecimal sumOfBigDecimal(double[] dArr, Function1<? super Double, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "valueOf(...)");
        for (double d3 : dArr) {
            bigDecimalValueOf = bigDecimalValueOf.add((BigDecimal) selector.invoke(Double.valueOf(d3)));
            Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    private static final BigInteger sumOfBigInteger(double[] dArr, Function1<? super Double, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "valueOf(...)");
        for (double d3 : dArr) {
            bigIntegerValueOf = bigIntegerValueOf.add((BigInteger) selector.invoke(Double.valueOf(d3)));
            Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    public static Boolean[] toTypedArray(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Boolean[] boolArr = new Boolean[zArr.length];
        int length = zArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            boolArr[i3] = Boolean.valueOf(zArr[i3]);
        }
        return boolArr;
    }

    public static final float[] plus(float[] fArr, float f3) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        int length = fArr.length;
        float[] fArrCopyOf = Arrays.copyOf(fArr, length + 1);
        fArrCopyOf[length] = f3;
        Intrinsics.checkNotNull(fArrCopyOf);
        return fArrCopyOf;
    }

    private static final BigDecimal sumOfBigDecimal(boolean[] zArr, Function1<? super Boolean, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "valueOf(...)");
        for (boolean z2 : zArr) {
            bigDecimalValueOf = bigDecimalValueOf.add((BigDecimal) selector.invoke(Boolean.valueOf(z2)));
            Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    private static final BigInteger sumOfBigInteger(boolean[] zArr, Function1<? super Boolean, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "valueOf(...)");
        for (boolean z2 : zArr) {
            bigIntegerValueOf = bigIntegerValueOf.add((BigInteger) selector.invoke(Boolean.valueOf(z2)));
            Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    public static final Character[] toTypedArray(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Character[] chArr = new Character[cArr.length];
        int length = cArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            chArr[i3] = Character.valueOf(cArr[i3]);
        }
        return chArr;
    }

    public static final double[] plus(double[] dArr, double d3) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        int length = dArr.length;
        double[] dArrCopyOf = Arrays.copyOf(dArr, length + 1);
        dArrCopyOf[length] = d3;
        Intrinsics.checkNotNull(dArrCopyOf);
        return dArrCopyOf;
    }

    private static final BigDecimal sumOfBigDecimal(char[] cArr, Function1<? super Character, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "valueOf(...)");
        for (char c3 : cArr) {
            bigDecimalValueOf = bigDecimalValueOf.add((BigDecimal) selector.invoke(Character.valueOf(c3)));
            Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    private static final BigInteger sumOfBigInteger(char[] cArr, Function1<? super Character, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "valueOf(...)");
        for (char c3 : cArr) {
            bigIntegerValueOf = bigIntegerValueOf.add((BigInteger) selector.invoke(Character.valueOf(c3)));
            Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ <R extends Comparable<? super R>> Integer maxBy(int[] iArr, Function1<? super Integer, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        int i3 = iArr[0];
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(iArr);
        if (lastIndex == 0) {
            return Integer.valueOf(i3);
        }
        Comparable comparable = (Comparable) selector.invoke(Integer.valueOf(i3));
        int i4 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int i5 = iArr[i4];
                Comparable comparable2 = (Comparable) selector.invoke(Integer.valueOf(i5));
                if (comparable.compareTo(comparable2) < 0) {
                    i3 = i5;
                    comparable = comparable2;
                }
                if (i4 == lastIndex) {
                    break;
                }
                i4++;
            }
        }
        return Integer.valueOf(i3);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ <R extends Comparable<? super R>> Integer minBy(int[] iArr, Function1<? super Integer, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        int i3 = iArr[0];
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(iArr);
        if (lastIndex == 0) {
            return Integer.valueOf(i3);
        }
        Comparable comparable = (Comparable) selector.invoke(Integer.valueOf(i3));
        int i4 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int i5 = iArr[i4];
                Comparable comparable2 = (Comparable) selector.invoke(Integer.valueOf(i5));
                if (comparable.compareTo(comparable2) > 0) {
                    i3 = i5;
                    comparable = comparable2;
                }
                if (i4 == lastIndex) {
                    break;
                }
                i4++;
            }
        }
        return Integer.valueOf(i3);
    }

    public static final boolean[] plus(boolean[] zArr, boolean z2) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        int length = zArr.length;
        boolean[] zArrCopyOf = Arrays.copyOf(zArr, length + 1);
        zArrCopyOf[length] = z2;
        Intrinsics.checkNotNull(zArrCopyOf);
        return zArrCopyOf;
    }

    public static final char[] plus(char[] cArr, char c3) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        int length = cArr.length;
        char[] cArrCopyOf = Arrays.copyOf(cArr, length + 1);
        cArrCopyOf[length] = c3;
        Intrinsics.checkNotNull(cArrCopyOf);
        return cArrCopyOf;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ <R extends Comparable<? super R>> Long maxBy(long[] jArr, Function1<? super Long, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        long j3 = jArr[0];
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(jArr);
        if (lastIndex == 0) {
            return Long.valueOf(j3);
        }
        Comparable comparable = (Comparable) selector.invoke(Long.valueOf(j3));
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                long j4 = jArr[i3];
                Comparable comparable2 = (Comparable) selector.invoke(Long.valueOf(j4));
                if (comparable.compareTo(comparable2) < 0) {
                    j3 = j4;
                    comparable = comparable2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Long.valueOf(j3);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ <R extends Comparable<? super R>> Long minBy(long[] jArr, Function1<? super Long, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        long j3 = jArr[0];
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(jArr);
        if (lastIndex == 0) {
            return Long.valueOf(j3);
        }
        Comparable comparable = (Comparable) selector.invoke(Long.valueOf(j3));
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                long j4 = jArr[i3];
                Comparable comparable2 = (Comparable) selector.invoke(Long.valueOf(j4));
                if (comparable.compareTo(comparable2) > 0) {
                    j3 = j4;
                    comparable = comparable2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Long.valueOf(j3);
    }

    public static final <T> T[] plus(T[] tArr, Collection<? extends T> elements) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int length = tArr.length;
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, elements.size() + length);
        Iterator<? extends T> it = elements.iterator();
        while (it.hasNext()) {
            tArr2[length] = it.next();
            length++;
        }
        Intrinsics.checkNotNull(tArr2);
        return tArr2;
    }

    public static final byte[] plus(byte[] bArr, Collection<Byte> elements) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int length = bArr.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, elements.size() + length);
        Iterator<Byte> it = elements.iterator();
        while (it.hasNext()) {
            bArrCopyOf[length] = it.next().byteValue();
            length++;
        }
        Intrinsics.checkNotNull(bArrCopyOf);
        return bArrCopyOf;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ <R extends Comparable<? super R>> Float maxBy(float[] fArr, Function1<? super Float, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float f3 = fArr[0];
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(fArr);
        if (lastIndex == 0) {
            return Float.valueOf(f3);
        }
        Comparable comparable = (Comparable) selector.invoke(Float.valueOf(f3));
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                float f4 = fArr[i3];
                Comparable comparable2 = (Comparable) selector.invoke(Float.valueOf(f4));
                if (comparable.compareTo(comparable2) < 0) {
                    f3 = f4;
                    comparable = comparable2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Float.valueOf(f3);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ <R extends Comparable<? super R>> Float minBy(float[] fArr, Function1<? super Float, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float f3 = fArr[0];
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(fArr);
        if (lastIndex == 0) {
            return Float.valueOf(f3);
        }
        Comparable comparable = (Comparable) selector.invoke(Float.valueOf(f3));
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                float f4 = fArr[i3];
                Comparable comparable2 = (Comparable) selector.invoke(Float.valueOf(f4));
                if (comparable.compareTo(comparable2) > 0) {
                    f3 = f4;
                    comparable = comparable2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Float.valueOf(f3);
    }

    public static final short[] plus(short[] sArr, Collection<Short> elements) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int length = sArr.length;
        short[] sArrCopyOf = Arrays.copyOf(sArr, elements.size() + length);
        Iterator<Short> it = elements.iterator();
        while (it.hasNext()) {
            sArrCopyOf[length] = it.next().shortValue();
            length++;
        }
        Intrinsics.checkNotNull(sArrCopyOf);
        return sArrCopyOf;
    }

    public static final int[] plus(int[] iArr, Collection<Integer> elements) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int length = iArr.length;
        int[] iArrCopyOf = Arrays.copyOf(iArr, elements.size() + length);
        Iterator<Integer> it = elements.iterator();
        while (it.hasNext()) {
            iArrCopyOf[length] = it.next().intValue();
            length++;
        }
        Intrinsics.checkNotNull(iArrCopyOf);
        return iArrCopyOf;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ <R extends Comparable<? super R>> Double maxBy(double[] dArr, Function1<? super Double, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double d3 = dArr[0];
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(dArr);
        if (lastIndex == 0) {
            return Double.valueOf(d3);
        }
        Comparable comparable = (Comparable) selector.invoke(Double.valueOf(d3));
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                double d4 = dArr[i3];
                Comparable comparable2 = (Comparable) selector.invoke(Double.valueOf(d4));
                if (comparable.compareTo(comparable2) < 0) {
                    d3 = d4;
                    comparable = comparable2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Double.valueOf(d3);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ <R extends Comparable<? super R>> Double minBy(double[] dArr, Function1<? super Double, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double d3 = dArr[0];
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(dArr);
        if (lastIndex == 0) {
            return Double.valueOf(d3);
        }
        Comparable comparable = (Comparable) selector.invoke(Double.valueOf(d3));
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                double d4 = dArr[i3];
                Comparable comparable2 = (Comparable) selector.invoke(Double.valueOf(d4));
                if (comparable.compareTo(comparable2) > 0) {
                    d3 = d4;
                    comparable = comparable2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Double.valueOf(d3);
    }

    public static final long[] plus(long[] jArr, Collection<Long> elements) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int length = jArr.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, elements.size() + length);
        Iterator<Long> it = elements.iterator();
        while (it.hasNext()) {
            jArrCopyOf[length] = it.next().longValue();
            length++;
        }
        Intrinsics.checkNotNull(jArrCopyOf);
        return jArrCopyOf;
    }

    public static final float[] plus(float[] fArr, Collection<Float> elements) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int length = fArr.length;
        float[] fArrCopyOf = Arrays.copyOf(fArr, elements.size() + length);
        Iterator<Float> it = elements.iterator();
        while (it.hasNext()) {
            fArrCopyOf[length] = it.next().floatValue();
            length++;
        }
        Intrinsics.checkNotNull(fArrCopyOf);
        return fArrCopyOf;
    }

    public static final double[] plus(double[] dArr, Collection<Double> elements) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int length = dArr.length;
        double[] dArrCopyOf = Arrays.copyOf(dArr, elements.size() + length);
        Iterator<Double> it = elements.iterator();
        while (it.hasNext()) {
            dArrCopyOf[length] = it.next().doubleValue();
            length++;
        }
        Intrinsics.checkNotNull(dArrCopyOf);
        return dArrCopyOf;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ <R extends Comparable<? super R>> Boolean maxBy(boolean[] zArr, Function1<? super Boolean, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        boolean z2 = zArr[0];
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(zArr);
        if (lastIndex == 0) {
            return Boolean.valueOf(z2);
        }
        Comparable comparable = (Comparable) selector.invoke(Boolean.valueOf(z2));
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                boolean z3 = zArr[i3];
                Comparable comparable2 = (Comparable) selector.invoke(Boolean.valueOf(z3));
                if (comparable.compareTo(comparable2) < 0) {
                    z2 = z3;
                    comparable = comparable2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Boolean.valueOf(z2);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ <R extends Comparable<? super R>> Boolean minBy(boolean[] zArr, Function1<? super Boolean, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        boolean z2 = zArr[0];
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(zArr);
        if (lastIndex == 0) {
            return Boolean.valueOf(z2);
        }
        Comparable comparable = (Comparable) selector.invoke(Boolean.valueOf(z2));
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                boolean z3 = zArr[i3];
                Comparable comparable2 = (Comparable) selector.invoke(Boolean.valueOf(z3));
                if (comparable.compareTo(comparable2) > 0) {
                    z2 = z3;
                    comparable = comparable2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Boolean.valueOf(z2);
    }

    public static final boolean[] plus(boolean[] zArr, Collection<Boolean> elements) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int length = zArr.length;
        boolean[] zArrCopyOf = Arrays.copyOf(zArr, elements.size() + length);
        Iterator<Boolean> it = elements.iterator();
        while (it.hasNext()) {
            zArrCopyOf[length] = it.next().booleanValue();
            length++;
        }
        Intrinsics.checkNotNull(zArrCopyOf);
        return zArrCopyOf;
    }

    public static final char[] plus(char[] cArr, Collection<Character> elements) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int length = cArr.length;
        char[] cArrCopyOf = Arrays.copyOf(cArr, elements.size() + length);
        Iterator<Character> it = elements.iterator();
        while (it.hasNext()) {
            cArrCopyOf[length] = it.next().charValue();
            length++;
        }
        Intrinsics.checkNotNull(cArrCopyOf);
        return cArrCopyOf;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ <R extends Comparable<? super R>> Character maxBy(char[] cArr, Function1<? super Character, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        char c3 = cArr[0];
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(cArr);
        if (lastIndex == 0) {
            return Character.valueOf(c3);
        }
        Comparable comparable = (Comparable) selector.invoke(Character.valueOf(c3));
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                char c4 = cArr[i3];
                Comparable comparable2 = (Comparable) selector.invoke(Character.valueOf(c4));
                if (comparable.compareTo(comparable2) < 0) {
                    c3 = c4;
                    comparable = comparable2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Character.valueOf(c3);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ <R extends Comparable<? super R>> Character minBy(char[] cArr, Function1<? super Character, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        char c3 = cArr[0];
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(cArr);
        if (lastIndex == 0) {
            return Character.valueOf(c3);
        }
        Comparable comparable = (Comparable) selector.invoke(Character.valueOf(c3));
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                char c4 = cArr[i3];
                Comparable comparable2 = (Comparable) selector.invoke(Character.valueOf(c4));
                if (comparable.compareTo(comparable2) > 0) {
                    c3 = c4;
                    comparable = comparable2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Character.valueOf(c3);
    }

    public static <T> T[] plus(T[] tArr, T[] elements) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int length = tArr.length;
        int length2 = elements.length;
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, length + length2);
        System.arraycopy(elements, 0, tArr2, length, length2);
        Intrinsics.checkNotNull(tArr2);
        return tArr2;
    }

    public static byte[] plus(byte[] bArr, byte[] elements) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int length = bArr.length;
        int length2 = elements.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, length + length2);
        System.arraycopy(elements, 0, bArrCopyOf, length, length2);
        Intrinsics.checkNotNull(bArrCopyOf);
        return bArrCopyOf;
    }

    public static short[] plus(short[] sArr, short[] elements) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int length = sArr.length;
        int length2 = elements.length;
        short[] sArrCopyOf = Arrays.copyOf(sArr, length + length2);
        System.arraycopy(elements, 0, sArrCopyOf, length, length2);
        Intrinsics.checkNotNull(sArrCopyOf);
        return sArrCopyOf;
    }

    public static int[] plus(int[] iArr, int[] elements) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int length = iArr.length;
        int length2 = elements.length;
        int[] iArrCopyOf = Arrays.copyOf(iArr, length + length2);
        System.arraycopy(elements, 0, iArrCopyOf, length, length2);
        Intrinsics.checkNotNull(iArrCopyOf);
        return iArrCopyOf;
    }

    public static long[] plus(long[] jArr, long[] elements) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int length = jArr.length;
        int length2 = elements.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, length + length2);
        System.arraycopy(elements, 0, jArrCopyOf, length, length2);
        Intrinsics.checkNotNull(jArrCopyOf);
        return jArrCopyOf;
    }

    public static float[] plus(float[] fArr, float[] elements) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int length = fArr.length;
        int length2 = elements.length;
        float[] fArrCopyOf = Arrays.copyOf(fArr, length + length2);
        System.arraycopy(elements, 0, fArrCopyOf, length, length2);
        Intrinsics.checkNotNull(fArrCopyOf);
        return fArrCopyOf;
    }

    public static double[] plus(double[] dArr, double[] elements) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int length = dArr.length;
        int length2 = elements.length;
        double[] dArrCopyOf = Arrays.copyOf(dArr, length + length2);
        System.arraycopy(elements, 0, dArrCopyOf, length, length2);
        Intrinsics.checkNotNull(dArrCopyOf);
        return dArrCopyOf;
    }

    public static boolean[] plus(boolean[] zArr, boolean[] elements) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int length = zArr.length;
        int length2 = elements.length;
        boolean[] zArrCopyOf = Arrays.copyOf(zArr, length + length2);
        System.arraycopy(elements, 0, zArrCopyOf, length, length2);
        Intrinsics.checkNotNull(zArrCopyOf);
        return zArrCopyOf;
    }

    public static final char[] plus(char[] cArr, char[] elements) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int length = cArr.length;
        int length2 = elements.length;
        char[] cArrCopyOf = Arrays.copyOf(cArr, length + length2);
        System.arraycopy(elements, 0, cArrCopyOf, length, length2);
        Intrinsics.checkNotNull(cArrCopyOf);
        return cArrCopyOf;
    }
}
