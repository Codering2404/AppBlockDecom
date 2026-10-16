package androidx.compose.foundation.lazy.layout;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;

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
public final class NearestRangeKeyIndexMap implements LazyLayoutKeyIndexMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ObjectIntMap f8253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object[] f8254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f8255c;

    public NearestRangeKeyIndexMap(IntRange intRange, LazyLayoutIntervalContent lazyLayoutIntervalContent) {
        IntervalList intervalListJ = lazyLayoutIntervalContent.j();
        final int iG = intRange.g();
        if (!(iG >= 0)) {
            InlineClassHelperKt.c("negative nearestRange.first");
        }
        final int iMin = Math.min(intRange.h(), intervalListJ.getSize() - 1);
        if (iMin < iG) {
            this.f8253a = ObjectIntMapKt.a();
            this.f8254b = new Object[0];
            this.f8255c = 0;
        } else {
            int i3 = (iMin - iG) + 1;
            this.f8254b = new Object[i3];
            this.f8255c = iG;
            final MutableObjectIntMap mutableObjectIntMap = new MutableObjectIntMap(i3);
            intervalListJ.a(iG, iMin, new Function1<IntervalList.Interval<? extends LazyLayoutIntervalContent.Interval>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0039  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void c(androidx.compose.foundation.lazy.layout.IntervalList.Interval r7) {
                    /*
                        r6 = this;
                        java.lang.Object r0 = r7.c()
                        androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent$Interval r0 = (androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent.Interval) r0
                        kotlin.jvm.functions.Function1 r0 = r0.getKey()
                        int r1 = r1
                        int r2 = r7.b()
                        int r1 = java.lang.Math.max(r1, r2)
                        int r2 = r2
                        int r3 = r7.b()
                        int r4 = r7.a()
                        int r3 = r3 + r4
                        int r3 = r3 + (-1)
                        int r2 = java.lang.Math.min(r2, r3)
                        if (r1 > r2) goto L57
                    L27:
                        if (r0 == 0) goto L39
                        int r3 = r7.b()
                        int r3 = r1 - r3
                        java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                        java.lang.Object r3 = r0.invoke(r3)
                        if (r3 != 0) goto L3d
                    L39:
                        java.lang.Object r3 = androidx.compose.foundation.lazy.layout.Lazy_androidKt.a(r1)
                    L3d:
                        androidx.collection.MutableObjectIntMap r4 = r3
                        r4.u(r3, r1)
                        androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap r4 = r4
                        java.lang.Object[] r4 = androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap.a(r4)
                        androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap r5 = r4
                        int r5 = androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap.b(r5)
                        int r5 = r1 - r5
                        r4[r5] = r3
                        if (r1 == r2) goto L57
                        int r1 = r1 + 1
                        goto L27
                    L57:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap$2$1.c(androidx.compose.foundation.lazy.layout.IntervalList$Interval):void");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    c((IntervalList.Interval) obj);
                    return Unit.f139807a;
                }
            });
            this.f8253a = mutableObjectIntMap;
        }
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap
    public int c(Object obj) {
        ObjectIntMap objectIntMap = this.f8253a;
        int iB = objectIntMap.b(obj);
        if (iB >= 0) {
            return objectIntMap.f3077c[iB];
        }
        return -1;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap
    public Object d(int i3) {
        Object[] objArr = this.f8254b;
        int i4 = i3 - this.f8255c;
        if (i4 < 0 || i4 > ArraysKt.getLastIndex(objArr)) {
            return null;
        }
        return objArr[i4];
    }
}
