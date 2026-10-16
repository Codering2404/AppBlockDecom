package androidx.compose.ui.semantics;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import java.util.Iterator;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class SemanticsConfiguration implements SemanticsPropertyReceiver, Iterable<Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object>>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableScatterMap f28497a = ScatterMapKt.c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map f28498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f28499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f28500d;

    @Override // androidx.compose.ui.semantics.SemanticsPropertyReceiver
    public void a(SemanticsPropertyKey semanticsPropertyKey, Object obj) {
        if (!(obj instanceof AccessibilityAction) || !d(semanticsPropertyKey)) {
            this.f28497a.x(semanticsPropertyKey, obj);
            return;
        }
        Object objE = this.f28497a.e(semanticsPropertyKey);
        Intrinsics.checkNotNull(objE, "null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>");
        AccessibilityAction accessibilityAction = (AccessibilityAction) objE;
        MutableScatterMap mutableScatterMap = this.f28497a;
        AccessibilityAction accessibilityAction2 = (AccessibilityAction) obj;
        String strB = accessibilityAction2.b();
        if (strB == null) {
            strB = accessibilityAction.b();
        }
        Function functionA = accessibilityAction2.a();
        if (functionA == null) {
            functionA = accessibilityAction.a();
        }
        mutableScatterMap.x(semanticsPropertyKey, new AccessibilityAction(strB, functionA));
    }

    public final void b(SemanticsConfiguration semanticsConfiguration) {
        int i3;
        if (semanticsConfiguration.f28499c) {
            this.f28499c = true;
        }
        if (semanticsConfiguration.f28500d) {
            this.f28500d = true;
        }
        MutableScatterMap mutableScatterMap = semanticsConfiguration.f28497a;
        Object[] objArr = mutableScatterMap.f3109b;
        Object[] objArr2 = mutableScatterMap.f3110c;
        long[] jArr = mutableScatterMap.f3108a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i4 = 0;
        while (true) {
            long j3 = jArr[i4];
            if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i5 = 8;
                int i6 = 8 - ((~(i4 - length)) >>> 31);
                int i7 = 0;
                while (i7 < i6) {
                    if ((255 & j3) < 128) {
                        int i8 = (i4 << 3) + i7;
                        Object obj = objArr[i8];
                        Object obj2 = objArr2[i8];
                        SemanticsPropertyKey semanticsPropertyKey = (SemanticsPropertyKey) obj;
                        if (!this.f28497a.b(semanticsPropertyKey)) {
                            this.f28497a.x(semanticsPropertyKey, obj2);
                        } else if (obj2 instanceof AccessibilityAction) {
                            Object objE = this.f28497a.e(semanticsPropertyKey);
                            Intrinsics.checkNotNull(objE, "null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>");
                            AccessibilityAction accessibilityAction = (AccessibilityAction) objE;
                            MutableScatterMap mutableScatterMap2 = this.f28497a;
                            String strB = accessibilityAction.b();
                            if (strB == null) {
                                strB = ((AccessibilityAction) obj2).b();
                            }
                            i3 = i5;
                            String str = strB;
                            Function functionA = accessibilityAction.a();
                            if (functionA == null) {
                                functionA = ((AccessibilityAction) obj2).a();
                            }
                            mutableScatterMap2.x(semanticsPropertyKey, new AccessibilityAction(str, functionA));
                        }
                        i3 = i5;
                    } else {
                        i3 = i5;
                    }
                    j3 >>= i3;
                    i7++;
                    i5 = i3;
                }
                if (i6 != i5) {
                    return;
                }
            }
            if (i4 == length) {
                return;
            } else {
                i4++;
            }
        }
    }

    public final boolean d(SemanticsPropertyKey semanticsPropertyKey) {
        return this.f28497a.c(semanticsPropertyKey);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean e() {
        /*
            r15 = this;
            androidx.collection.MutableScatterMap r0 = r15.f28497a
            java.lang.Object[] r1 = r0.f3109b
            java.lang.Object[] r2 = r0.f3110c
            long[] r0 = r0.f3108a
            int r3 = r0.length
            int r3 = r3 + (-2)
            r4 = 0
            if (r3 < 0) goto L50
            r5 = r4
        Lf:
            r6 = r0[r5]
            long r8 = ~r6
            r10 = 7
            long r8 = r8 << r10
            long r8 = r8 & r6
            r10 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r8 = r8 & r10
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 == 0) goto L4b
            int r8 = r5 - r3
            int r8 = ~r8
            int r8 = r8 >>> 31
            r9 = 8
            int r8 = 8 - r8
            r10 = r4
        L29:
            if (r10 >= r8) goto L49
            r11 = 255(0xff, double:1.26E-321)
            long r11 = r11 & r6
            r13 = 128(0x80, double:6.3E-322)
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 >= 0) goto L45
            int r11 = r5 << 3
            int r11 = r11 + r10
            r12 = r1[r11]
            r11 = r2[r11]
            androidx.compose.ui.semantics.SemanticsPropertyKey r12 = (androidx.compose.ui.semantics.SemanticsPropertyKey) r12
            boolean r11 = r12.b()
            if (r11 == 0) goto L45
            r0 = 1
            return r0
        L45:
            long r6 = r6 >> r9
            int r10 = r10 + 1
            goto L29
        L49:
            if (r8 != r9) goto L50
        L4b:
            if (r5 == r3) goto L50
            int r5 = r5 + 1
            goto Lf
        L50:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.semantics.SemanticsConfiguration.e():boolean");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SemanticsConfiguration)) {
            return false;
        }
        SemanticsConfiguration semanticsConfiguration = (SemanticsConfiguration) obj;
        return Intrinsics.areEqual(this.f28497a, semanticsConfiguration.f28497a) && this.f28499c == semanticsConfiguration.f28499c && this.f28500d == semanticsConfiguration.f28500d;
    }

    public final SemanticsConfiguration f() {
        SemanticsConfiguration semanticsConfiguration = new SemanticsConfiguration();
        semanticsConfiguration.f28499c = this.f28499c;
        semanticsConfiguration.f28500d = this.f28500d;
        semanticsConfiguration.f28497a.s(this.f28497a);
        return semanticsConfiguration;
    }

    public final Object g(SemanticsPropertyKey semanticsPropertyKey) {
        Object objE = this.f28497a.e(semanticsPropertyKey);
        if (objE != null) {
            return objE;
        }
        throw new IllegalStateException("Key not present: " + semanticsPropertyKey + " - consider getOrElse or getOrNull");
    }

    public final Object h(SemanticsPropertyKey semanticsPropertyKey, Function0 function0) {
        Object objE = this.f28497a.e(semanticsPropertyKey);
        return objE == null ? function0.invoke() : objE;
    }

    public int hashCode() {
        return (((this.f28497a.hashCode() * 31) + Boolean.hashCode(this.f28499c)) * 31) + Boolean.hashCode(this.f28500d);
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object>> iterator() {
        Map mapA = this.f28498b;
        if (mapA == null) {
            mapA = this.f28497a.a();
            this.f28498b = mapA;
        }
        return mapA.entrySet().iterator();
    }

    public final Object l(SemanticsPropertyKey semanticsPropertyKey, Function0 function0) {
        Object objE = this.f28497a.e(semanticsPropertyKey);
        return objE == null ? function0.invoke() : objE;
    }

    public final MutableScatterMap n() {
        return this.f28497a;
    }

    public final boolean o() {
        return this.f28500d;
    }

    public final boolean p() {
        return this.f28499c;
    }

    public final void q(SemanticsConfiguration semanticsConfiguration) {
        MutableScatterMap mutableScatterMap = semanticsConfiguration.f28497a;
        Object[] objArr = mutableScatterMap.f3109b;
        Object[] objArr2 = mutableScatterMap.f3110c;
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
                        Object obj = objArr[i6];
                        Object obj2 = objArr2[i6];
                        SemanticsPropertyKey semanticsPropertyKey = (SemanticsPropertyKey) obj;
                        Object objE = this.f28497a.e(semanticsPropertyKey);
                        Intrinsics.checkNotNull(semanticsPropertyKey, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsPropertyKey<kotlin.Any?>");
                        Object objC = semanticsPropertyKey.c(objE, obj2);
                        if (objC != null) {
                            this.f28497a.x(semanticsPropertyKey, objC);
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

    public final void s(boolean z2) {
        this.f28500d = z2;
    }

    public final void t(boolean z2) {
        this.f28499c = z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x007b A[PHI: r4
      0x007b: PHI (r4v4 java.lang.String) = (r4v3 java.lang.String), (r4v5 java.lang.String) binds: [B:12:0x0042, B:19:0x0079] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String toString() {
        /*
            r19 = this;
            r0 = r19
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            boolean r2 = r0.f28499c
            java.lang.String r3 = ", "
            java.lang.String r4 = ""
            if (r2 == 0) goto L18
            r1.append(r4)
            java.lang.String r2 = "mergeDescendants=true"
            r1.append(r2)
            r4 = r3
        L18:
            boolean r2 = r0.f28500d
            if (r2 == 0) goto L25
            r1.append(r4)
            java.lang.String r2 = "isClearingSemantics=true"
            r1.append(r2)
            r4 = r3
        L25:
            androidx.collection.MutableScatterMap r2 = r0.f28497a
            java.lang.Object[] r5 = r2.f3109b
            java.lang.Object[] r6 = r2.f3110c
            long[] r2 = r2.f3108a
            int r7 = r2.length
            int r7 = r7 + (-2)
            if (r7 < 0) goto L80
            r8 = 0
            r9 = r8
        L34:
            r10 = r2[r9]
            long r12 = ~r10
            r14 = 7
            long r12 = r12 << r14
            long r12 = r12 & r10
            r14 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r12 = r12 & r14
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 == 0) goto L7b
            int r12 = r9 - r7
            int r12 = ~r12
            int r12 = r12 >>> 31
            r13 = 8
            int r12 = 8 - r12
            r14 = r8
        L4e:
            if (r14 >= r12) goto L79
            r15 = 255(0xff, double:1.26E-321)
            long r15 = r15 & r10
            r17 = 128(0x80, double:6.3E-322)
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 >= 0) goto L75
            int r15 = r9 << 3
            int r15 = r15 + r14
            r16 = r5[r15]
            r15 = r6[r15]
            androidx.compose.ui.semantics.SemanticsPropertyKey r16 = (androidx.compose.ui.semantics.SemanticsPropertyKey) r16
            r1.append(r4)
            java.lang.String r4 = r16.a()
            r1.append(r4)
            java.lang.String r4 = " : "
            r1.append(r4)
            r1.append(r15)
            r4 = r3
        L75:
            long r10 = r10 >> r13
            int r14 = r14 + 1
            goto L4e
        L79:
            if (r12 != r13) goto L80
        L7b:
            if (r9 == r7) goto L80
            int r9 = r9 + 1
            goto L34
        L80:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r3 = 0
            java.lang.String r3 = androidx.compose.ui.platform.JvmActuals_jvmKt.a(r0, r3)
            r2.append(r3)
            java.lang.String r3 = "{ "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = " }"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.semantics.SemanticsConfiguration.toString():java.lang.String");
    }
}
