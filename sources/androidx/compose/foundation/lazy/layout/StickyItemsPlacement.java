package androidx.compose.foundation.lazy.layout;

import androidx.collection.IntList;
import androidx.collection.IntListKt;
import java.util.List;
import kotlin.Metadata;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public interface StickyItemsPlacement {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f8289a = Companion.f8290a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f8290a = new Companion();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final StickyItemsPlacement f8291b = new StickyItemsPlacement() { // from class: androidx.compose.foundation.lazy.layout.StickyItemsPlacement$Companion$StickToTopPlacement$1
            @Override // androidx.compose.foundation.lazy.layout.StickyItemsPlacement
            public int a(List list, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                Object obj;
                int size = list.size();
                int i10 = 0;
                while (true) {
                    if (i10 >= size) {
                        obj = null;
                        break;
                    }
                    obj = list.get(i10);
                    if (((LazyLayoutMeasuredItem) obj).getIndex() != i3) {
                        break;
                    }
                    i10++;
                }
                LazyLayoutMeasuredItem lazyLayoutMeasuredItem = (LazyLayoutMeasuredItem) obj;
                int iC = lazyLayoutMeasuredItem != null ? LazyLayoutStickyItemsKt.c(lazyLayoutMeasuredItem) : Integer.MIN_VALUE;
                int iMax = i5 == Integer.MIN_VALUE ? -i6 : Math.max(-i6, i5);
                return iC != Integer.MIN_VALUE ? Math.min(iMax, iC - i4) : iMax;
            }

            @Override // androidx.compose.foundation.lazy.layout.StickyItemsPlacement
            public IntList b(int i3, int i4, IntList intList) {
                int i5;
                if (i4 - i3 < 0 || (i5 = intList.f2877b) == 0) {
                    return IntListKt.a();
                }
                IntRange intRangeB = RangesKt.B(0, i5);
                int iG = intRangeB.g();
                int iH = intRangeB.h();
                int iE = -1;
                if (iG <= iH) {
                    while (intList.e(iG) <= i3) {
                        iE = intList.e(iG);
                        if (iG == iH) {
                            break;
                        }
                        iG++;
                    }
                }
                return iE == -1 ? IntListKt.a() : IntListKt.b(iE);
            }
        };

        private Companion() {
        }

        public final StickyItemsPlacement a() {
            return f8291b;
        }
    }

    int a(List list, int i3, int i4, int i5, int i6, int i7, int i8, int i9);

    IntList b(int i3, int i4, IntList intList);
}
