package androidx.compose.runtime.collection;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMapKt;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
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
@JvmInline
public final class ScopeMap<Key, Scope> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableScatterMap f24409a;

    public static final void a(MutableScatterMap mutableScatterMap, Object obj, Object obj2) {
        int iN = mutableScatterMap.n(obj);
        boolean z2 = iN < 0;
        Object obj3 = z2 ? null : mutableScatterMap.f3110c[iN];
        if (obj3 != null) {
            if (obj3 instanceof MutableScatterSet) {
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                ((MutableScatterSet) obj3).i(obj2);
            } else if (obj3 != obj2) {
                MutableScatterSet mutableScatterSet = new MutableScatterSet(0, 1, null);
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                mutableScatterSet.i(obj3);
                mutableScatterSet.i(obj2);
                obj2 = mutableScatterSet;
            }
            obj2 = obj3;
        }
        if (!z2) {
            mutableScatterMap.f3110c[iN] = obj2;
            return;
        }
        int i3 = ~iN;
        mutableScatterMap.f3109b[i3] = obj;
        mutableScatterMap.f3110c[i3] = obj2;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.util.Map b(androidx.collection.MutableScatterMap r15) {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.Object[] r1 = r15.f3109b
            java.lang.Object[] r2 = r15.f3110c
            long[] r15 = r15.f3108a
            int r3 = r15.length
            int r3 = r3 + (-2)
            if (r3 < 0) goto L6e
            r4 = 0
            r5 = r4
        L12:
            r6 = r15[r5]
            long r8 = ~r6
            r10 = 7
            long r8 = r8 << r10
            long r8 = r8 & r6
            r10 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r8 = r8 & r10
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 == 0) goto L69
            int r8 = r5 - r3
            int r8 = ~r8
            int r8 = r8 >>> 31
            r9 = 8
            int r8 = 8 - r8
            r10 = r4
        L2c:
            if (r10 >= r8) goto L67
            r11 = 255(0xff, double:1.26E-321)
            long r11 = r11 & r6
            r13 = 128(0x80, double:6.3E-322)
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 >= 0) goto L63
            int r11 = r5 << 3
            int r11 = r11 + r10
            r12 = r1[r11]
            r11 = r2[r11]
            java.lang.String r13 = "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.ScopeMap"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12, r13)
            boolean r13 = r11 instanceof androidx.collection.MutableScatterSet
            if (r13 == 0) goto L53
            java.lang.String r13 = "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11, r13)
            androidx.collection.MutableScatterSet r11 = (androidx.collection.MutableScatterSet) r11
            java.util.Set r11 = r11.a()
            goto L60
        L53:
            java.lang.String r13 = "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11, r13)
            java.lang.Object[] r11 = new java.lang.Object[]{r11}
            java.util.Set r11 = kotlin.collections.SetsKt.mutableSetOf(r11)
        L60:
            r0.put(r12, r11)
        L63:
            long r6 = r6 >> r9
            int r10 = r10 + 1
            goto L2c
        L67:
            if (r8 != r9) goto L6e
        L69:
            if (r5 == r3) goto L6e
            int r5 = r5 + 1
            goto L12
        L6e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.collection.ScopeMap.b(androidx.collection.MutableScatterMap):java.util.Map");
    }

    public static final void c(MutableScatterMap mutableScatterMap) {
        mutableScatterMap.k();
    }

    public static /* synthetic */ MutableScatterMap e(MutableScatterMap mutableScatterMap, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i3 & 1) != 0) {
            mutableScatterMap = ScatterMapKt.c();
        }
        return d(mutableScatterMap);
    }

    public static final boolean f(MutableScatterMap mutableScatterMap, Object obj) {
        return mutableScatterMap.c(obj);
    }

    public static boolean g(MutableScatterMap mutableScatterMap, Object obj) {
        return (obj instanceof ScopeMap) && Intrinsics.areEqual(mutableScatterMap, ((ScopeMap) obj).n());
    }

    public static final int h(MutableScatterMap mutableScatterMap) {
        return mutableScatterMap.g();
    }

    public static int i(MutableScatterMap mutableScatterMap) {
        return mutableScatterMap.hashCode();
    }

    public static final boolean j(MutableScatterMap mutableScatterMap, Object obj, Object obj2) {
        Object objE = mutableScatterMap.e(obj);
        if (objE == null) {
            return false;
        }
        if (!(objE instanceof MutableScatterSet)) {
            if (!Intrinsics.areEqual(objE, obj2)) {
                return false;
            }
            mutableScatterMap.u(obj);
            return true;
        }
        MutableScatterSet mutableScatterSet = (MutableScatterSet) objE;
        boolean z2 = mutableScatterSet.z(obj2);
        if (z2 && mutableScatterSet.e()) {
            mutableScatterMap.u(obj);
        }
        return z2;
    }

    public static final void k(MutableScatterMap mutableScatterMap, Object obj) {
        boolean zE;
        long[] jArr = mutableScatterMap.f3108a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            long j3 = jArr[i3];
            if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i4 = 8 - ((~(i3 - length)) >>> 31);
                for (int i5 = 0; i5 < i4; i5++) {
                    if ((255 & j3) < 128) {
                        int i6 = (i3 << 3) + i5;
                        Object obj2 = mutableScatterMap.f3109b[i6];
                        Object obj3 = mutableScatterMap.f3110c[i6];
                        if (obj3 instanceof MutableScatterSet) {
                            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj3;
                            mutableScatterSet.z(obj);
                            zE = mutableScatterSet.e();
                        } else {
                            zE = obj3 == obj;
                        }
                        if (zE) {
                            mutableScatterMap.v(i6);
                        }
                    }
                    j3 >>= 8;
                }
                if (i4 != 8) {
                    return;
                }
            }
            if (i3 == length) {
                return;
            } else {
                i3++;
            }
        }
    }

    public static final void l(MutableScatterMap mutableScatterMap, Object obj, Object obj2) {
        mutableScatterMap.x(obj, obj2);
    }

    public static String m(MutableScatterMap mutableScatterMap) {
        return "ScopeMap(map=" + mutableScatterMap + ')';
    }

    public boolean equals(Object obj) {
        return g(this.f24409a, obj);
    }

    public int hashCode() {
        return i(this.f24409a);
    }

    public final /* synthetic */ MutableScatterMap n() {
        return this.f24409a;
    }

    public String toString() {
        return m(this.f24409a);
    }

    public static MutableScatterMap d(MutableScatterMap mutableScatterMap) {
        return mutableScatterMap;
    }
}
