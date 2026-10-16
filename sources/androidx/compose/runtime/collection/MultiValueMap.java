package androidx.compose.runtime.collection;

import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.ObjectList;
import androidx.collection.ObjectListKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

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
@JvmInline
public final class MultiValueMap<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableScatterMap f24387a;

    private /* synthetic */ MultiValueMap(MutableScatterMap mutableScatterMap) {
        this.f24387a = mutableScatterMap;
    }

    public static final void a(MutableScatterMap mutableScatterMap, Object obj, Object obj2) {
        int iN = mutableScatterMap.n(obj);
        boolean z2 = iN < 0;
        Object obj3 = z2 ? null : mutableScatterMap.f3110c[iN];
        TypeIntrinsics.n(obj3);
        if (obj3 != null) {
            if (obj3 instanceof MutableObjectList) {
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type androidx.collection.MutableObjectList<kotlin.Any>");
                MutableObjectList mutableObjectList = (MutableObjectList) obj3;
                mutableObjectList.n(obj2);
                obj2 = mutableObjectList;
            } else {
                obj2 = ObjectListKt.h(obj3, obj2);
            }
        }
        if (!z2) {
            mutableScatterMap.f3110c[iN] = obj2;
            return;
        }
        int i3 = ~iN;
        mutableScatterMap.f3109b[i3] = obj;
        mutableScatterMap.f3110c[i3] = obj2;
    }

    public static final /* synthetic */ MultiValueMap b(MutableScatterMap mutableScatterMap) {
        return new MultiValueMap(mutableScatterMap);
    }

    public static final void c(MutableScatterMap mutableScatterMap) {
        mutableScatterMap.k();
    }

    public static /* synthetic */ MutableScatterMap e(MutableScatterMap mutableScatterMap, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        int i4 = 1;
        if ((i3 & 1) != 0) {
            mutableScatterMap = new MutableScatterMap(0, i4, null);
        }
        return d(mutableScatterMap);
    }

    public static final boolean f(MutableScatterMap mutableScatterMap, Object obj) {
        return mutableScatterMap.b(obj);
    }

    public static boolean g(MutableScatterMap mutableScatterMap, Object obj) {
        return (obj instanceof MultiValueMap) && Intrinsics.areEqual(mutableScatterMap, ((MultiValueMap) obj).p());
    }

    public static final ObjectList h(MutableScatterMap mutableScatterMap, Object obj) {
        Object objE = mutableScatterMap.e(obj);
        return objE == null ? ObjectListKt.f() : objE instanceof MutableObjectList ? (ObjectList) objE : ObjectListKt.i(objE);
    }

    public static int i(MutableScatterMap mutableScatterMap) {
        return mutableScatterMap.hashCode();
    }

    public static final boolean j(MutableScatterMap mutableScatterMap) {
        return mutableScatterMap.h();
    }

    public static final boolean k(MutableScatterMap mutableScatterMap) {
        return mutableScatterMap.i();
    }

    public static final Object l(MutableScatterMap mutableScatterMap, Object obj) {
        Object objE = mutableScatterMap.e(obj);
        if (objE == null) {
            return null;
        }
        if (!(objE instanceof MutableObjectList)) {
            mutableScatterMap.u(obj);
            return objE;
        }
        MutableObjectList mutableObjectList = (MutableObjectList) objE;
        Object objA = mutableObjectList.A(0);
        if (mutableObjectList.g()) {
            mutableScatterMap.u(obj);
        }
        if (mutableObjectList.e() == 1) {
            mutableScatterMap.x(obj, mutableObjectList.c());
        }
        return objA;
    }

    public static final Object m(MutableScatterMap mutableScatterMap, Object obj) {
        Object objE = mutableScatterMap.e(obj);
        if (objE == null) {
            return null;
        }
        if (!(objE instanceof MutableObjectList)) {
            mutableScatterMap.u(obj);
            return objE;
        }
        MutableObjectList mutableObjectList = (MutableObjectList) objE;
        Object objB = ExtensionsKt.b(mutableObjectList);
        Intrinsics.checkNotNull(objB, "null cannot be cast to non-null type V of androidx.compose.runtime.collection.MultiValueMap");
        if (mutableObjectList.g()) {
            mutableScatterMap.u(obj);
        }
        if (mutableObjectList.e() == 1) {
            mutableScatterMap.x(obj, mutableObjectList.c());
        }
        return objB;
    }

    public static final void n(MutableScatterMap mutableScatterMap, Object obj, Function1 function1) {
        Object objE = mutableScatterMap.e(obj);
        if (objE != null) {
            if (!(objE instanceof MutableObjectList)) {
                if (((Boolean) function1.invoke(objE)).booleanValue()) {
                    mutableScatterMap.u(obj);
                    return;
                }
                return;
            }
            MutableObjectList mutableObjectList = (MutableObjectList) objE;
            int i3 = mutableObjectList.f3082b;
            Object[] objArr = mutableObjectList.f3081a;
            int i4 = 0;
            IntRange intRangeB = RangesKt.B(0, i3);
            int iG = intRangeB.g();
            int iH = intRangeB.h();
            if (iG <= iH) {
                while (true) {
                    objArr[iG - i4] = objArr[iG];
                    if (((Boolean) function1.invoke(objArr[iG])).booleanValue()) {
                        i4++;
                    }
                    if (iG == iH) {
                        break;
                    } else {
                        iG++;
                    }
                }
            }
            ArraysKt.fill(objArr, (Object) null, i3 - i4, i3);
            mutableObjectList.f3082b -= i4;
            if (mutableObjectList.g()) {
                mutableScatterMap.u(obj);
            }
            if (mutableObjectList.e() == 0) {
                mutableScatterMap.x(obj, mutableObjectList.c());
            }
        }
    }

    public static String o(MutableScatterMap mutableScatterMap) {
        return "MultiValueMap(map=" + mutableScatterMap + ')';
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final androidx.collection.ObjectList q(androidx.collection.MutableScatterMap r14) {
        /*
            boolean r0 = r14.h()
            if (r0 == 0) goto Lb
            androidx.collection.ObjectList r14 = androidx.collection.ObjectListKt.f()
            return r14
        Lb:
            androidx.collection.MutableObjectList r0 = new androidx.collection.MutableObjectList
            r1 = 0
            r2 = 0
            r3 = 1
            r0.<init>(r2, r3, r1)
            java.lang.Object[] r1 = r14.f3110c
            long[] r14 = r14.f3108a
            int r3 = r14.length
            int r3 = r3 + (-2)
            if (r3 < 0) goto L69
            r4 = r2
        L1d:
            r5 = r14[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L64
            int r7 = r4 - r3
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r2
        L37:
            if (r9 >= r7) goto L62
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L5e
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r1[r10]
            boolean r11 = r10 instanceof androidx.collection.MutableObjectList
            if (r11 == 0) goto L56
            java.lang.String r11 = "null cannot be cast to non-null type androidx.collection.MutableObjectList<V of androidx.compose.runtime.collection.MultiValueMap>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10, r11)
            androidx.collection.MutableObjectList r10 = (androidx.collection.MutableObjectList) r10
            r0.p(r10)
            goto L5e
        L56:
            java.lang.String r11 = "null cannot be cast to non-null type V of androidx.compose.runtime.collection.MultiValueMap"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10, r11)
            r0.n(r10)
        L5e:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L37
        L62:
            if (r7 != r8) goto L69
        L64:
            if (r4 == r3) goto L69
            int r4 = r4 + 1
            goto L1d
        L69:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.collection.MultiValueMap.q(androidx.collection.MutableScatterMap):androidx.collection.ObjectList");
    }

    public boolean equals(Object obj) {
        return g(this.f24387a, obj);
    }

    public int hashCode() {
        return i(this.f24387a);
    }

    public final /* synthetic */ MutableScatterMap p() {
        return this.f24387a;
    }

    public String toString() {
        return o(this.f24387a);
    }

    public static MutableScatterMap d(MutableScatterMap mutableScatterMap) {
        return mutableScatterMap;
    }
}
