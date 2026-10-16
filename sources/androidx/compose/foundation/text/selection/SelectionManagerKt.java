package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
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
public final class SelectionManagerKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Rect f11463a = new Rect(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11464a;

        static {
            int[] iArr = new int[Handle.values().length];
            try {
                iArr[Handle.f9698b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Handle.f9699c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Handle.f9697a.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f11464a = iArr;
        }
    }

    public static final long c(SelectionManager selectionManager, long j3) {
        Selection selectionD = selectionManager.D();
        if (selectionD == null) {
            return Offset.f25596b.b();
        }
        Handle handleV = selectionManager.v();
        int i3 = handleV == null ? -1 : WhenMappings.f11464a[handleV.ordinal()];
        if (i3 == -1) {
            return Offset.f25596b.b();
        }
        if (i3 == 1) {
            return f(selectionManager, j3, selectionD.e());
        }
        if (i3 == 2) {
            return f(selectionManager, j3, selectionD.c());
        }
        if (i3 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        throw new IllegalStateException("SelectionContainer does not support cursor");
    }

    public static final boolean d(Rect rect, long j3) {
        float fO = rect.o();
        float fP = rect.p();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j3 >> 32));
        if (fO > fIntBitsToFloat || fIntBitsToFloat > fP) {
            return false;
        }
        float fR = rect.r();
        float fI = rect.i();
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j3 & 4294967295L));
        return fR <= fIntBitsToFloat2 && fIntBitsToFloat2 <= fI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List e(List list) {
        int size = list.size();
        return (size == 0 || size == 1) ? list : CollectionsKt.listOf(CollectionsKt.first(list), CollectionsKt.last(list));
    }

    private static final long f(SelectionManager selectionManager, long j3, Selection.AnchorInfo anchorInfo) {
        float fO;
        Selectable selectableP = selectionManager.p(anchorInfo);
        if (selectableP == null) {
            return Offset.f25596b.b();
        }
        LayoutCoordinates layoutCoordinatesQ = selectionManager.q();
        if (layoutCoordinatesQ == null) {
            return Offset.f25596b.b();
        }
        LayoutCoordinates layoutCoordinatesZ = selectableP.z();
        if (layoutCoordinatesZ == null) {
            return Offset.f25596b.b();
        }
        int iD = anchorInfo.d();
        if (iD > selectableP.h()) {
            return Offset.f25596b.b();
        }
        Offset offsetS = selectionManager.s();
        Intrinsics.checkNotNull(offsetS);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (layoutCoordinatesZ.S(layoutCoordinatesQ, offsetS.u()) >> 32));
        long jM = selectableP.m(iD);
        if (TextRange.h(jM)) {
            fO = selectableP.d(iD);
        } else {
            float fD = selectableP.d(TextRange.n(jM));
            float fA = selectableP.a(TextRange.i(jM) - 1);
            fO = RangesKt.o(fIntBitsToFloat, Math.min(fD, fA), Math.max(fD, fA));
        }
        if (fO == -1.0f) {
            return Offset.f25596b.b();
        }
        if (!IntSize.e(j3, IntSize.f29998b.a()) && Math.abs(fIntBitsToFloat - fO) > ((int) (j3 >> 32)) / 2) {
            return Offset.f25596b.b();
        }
        float fI = selectableP.i(iD);
        if (fI == -1.0f) {
            return Offset.f25596b.b();
        }
        return layoutCoordinatesQ.S(layoutCoordinatesZ, Offset.e((((long) Float.floatToRawIntBits(fO)) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(fI)))));
    }

    public static final Rect g(List list, LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates layoutCoordinatesZ;
        int[] iArr;
        List list2 = list;
        if (list2.isEmpty()) {
            return f11463a;
        }
        Rect rect = f11463a;
        float fB = rect.b();
        float fC = rect.c();
        float fD = rect.d();
        float fE = rect.e();
        int size = list2.size();
        char c3 = 0;
        int i3 = 0;
        while (i3 < size) {
            Pair pair = (Pair) list2.get(i3);
            Selectable selectable = (Selectable) pair.a();
            Selection selection = (Selection) pair.b();
            int iD = selection.e().d();
            int iD2 = selection.c().d();
            if (iD != iD2 && (layoutCoordinatesZ = selectable.z()) != null) {
                int iMin = Math.min(iD, iD2);
                int iMax = Math.max(iD, iD2) - 1;
                if (iMin == iMax) {
                    iArr = new int[1];
                    iArr[c3] = iMin;
                } else {
                    int[] iArr2 = new int[2];
                    iArr2[c3] = iMin;
                    iArr2[1] = iMax;
                    iArr = iArr2;
                }
                Rect rect2 = f11463a;
                float fB2 = rect2.b();
                float fC2 = rect2.c();
                float fD2 = rect2.d();
                float fE2 = rect2.e();
                int length = iArr.length;
                int i4 = 0;
                while (i4 < length) {
                    int i5 = i4;
                    Rect rectF = selectable.f(iArr[i5]);
                    fB2 = Math.min(fB2, rectF.o());
                    fC2 = Math.min(fC2, rectF.r());
                    fD2 = Math.max(fD2, rectF.p());
                    fE2 = Math.max(fE2, rectF.i());
                    i4 = i5 + 1;
                }
                long jE = Offset.e((((long) Float.floatToRawIntBits(fB2)) << 32) | (((long) Float.floatToRawIntBits(fC2)) & 4294967295L));
                long jE2 = Offset.e((((long) Float.floatToRawIntBits(fE2)) & 4294967295L) | (((long) Float.floatToRawIntBits(fD2)) << 32));
                long jS = layoutCoordinates.S(layoutCoordinatesZ, jE);
                long jS2 = layoutCoordinates.S(layoutCoordinatesZ, jE2);
                fB = Math.min(fB, Float.intBitsToFloat((int) (jS >> 32)));
                fC = Math.min(fC, Float.intBitsToFloat((int) (jS & 4294967295L)));
                fD = Math.max(fD, Float.intBitsToFloat((int) (jS2 >> 32)));
                fE = Math.max(fE, Float.intBitsToFloat((int) (jS2 & 4294967295L)));
            }
            i3++;
            list2 = list;
            c3 = 0;
        }
        return new Rect(fB, fC, fD, fE);
    }

    public static final Selection h(Selection selection, Selection selection2) {
        Selection selectionF;
        return (selection == null || (selectionF = selection.f(selection2)) == null) ? selection2 : selectionF;
    }

    public static final Rect i(LayoutCoordinates layoutCoordinates) {
        Rect rectC = LayoutCoordinatesKt.c(layoutCoordinates);
        return RectKt.a(layoutCoordinates.X(rectC.t()), layoutCoordinates.X(rectC.l()));
    }
}
