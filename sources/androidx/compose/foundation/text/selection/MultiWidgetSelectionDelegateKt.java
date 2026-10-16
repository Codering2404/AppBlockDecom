package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import java.util.Comparator;
import kotlin.Metadata;

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
public final class MultiWidgetSelectionDelegateKt {
    public static final void a(SelectionLayoutBuilder selectionLayoutBuilder, TextLayoutResult textLayoutResult, long j3, long j4, long j5) {
        Direction direction;
        Direction direction2;
        long j6;
        Direction directionB;
        Direction direction3;
        Direction directionB2;
        Direction direction4;
        Direction direction5;
        int iD;
        int iE;
        Selection.AnchorInfo anchorInfoE;
        Selection.AnchorInfo anchorInfoC;
        Rect rect = new Rect(0.0f, 0.0f, (int) (textLayoutResult.B() >> 32), (int) (textLayoutResult.B() & 4294967295L));
        Direction directionF = f(j3, rect);
        Direction directionG = g(j3, rect);
        if (selectionLayoutBuilder.h()) {
            Selection selectionF = selectionLayoutBuilder.f();
            direction = directionG;
            direction2 = directionF;
            j6 = j5;
            direction4 = direction2;
            directionB2 = b(direction2, direction, selectionLayoutBuilder, j5, selectionF != null ? selectionF.c() : null);
            direction3 = directionB2;
            direction5 = direction3;
            directionB = direction;
        } else {
            direction = directionG;
            direction2 = directionF;
            Selection selectionF2 = selectionLayoutBuilder.f();
            j6 = j5;
            directionB = b(direction2, direction, selectionLayoutBuilder, j6, selectionF2 != null ? selectionF2.e() : null);
            direction3 = direction2;
            directionB2 = direction;
            direction4 = directionB;
            direction5 = direction4;
        }
        if (h(SelectionLayoutKt.f(direction2, direction), direction5)) {
            int length = textLayoutResult.l().j().length();
            if (selectionLayoutBuilder.h()) {
                iE = d(j3, textLayoutResult);
                Selection selectionF3 = selectionLayoutBuilder.f();
                iD = (selectionF3 == null || (anchorInfoC = selectionF3.c()) == null) ? iE : e(anchorInfoC, selectionLayoutBuilder.g(), j6, length);
            } else {
                iD = d(j3, textLayoutResult);
                Selection selectionF4 = selectionLayoutBuilder.f();
                iE = (selectionF4 == null || (anchorInfoE = selectionF4.e()) == null) ? iD : e(anchorInfoE, selectionLayoutBuilder.g(), j6, length);
            }
            selectionLayoutBuilder.a(j6, iE, direction4, directionB, iD, direction3, directionB2, (9223372034707292159L & j4) == 9205357640488583168L ? -1 : d(j4, textLayoutResult), textLayoutResult);
        }
    }

    private static final Direction b(Direction direction, Direction direction2, SelectionLayoutBuilder selectionLayoutBuilder, long j3, Selection.AnchorInfo anchorInfo) {
        Direction directionC;
        return (anchorInfo == null || (directionC = c(selectionLayoutBuilder, anchorInfo.e(), j3)) == null) ? SelectionLayoutKt.f(direction, direction2) : directionC;
    }

    private static final Direction c(SelectionLayoutBuilder selectionLayoutBuilder, long j3, long j4) {
        int iCompare = selectionLayoutBuilder.g().compare(Long.valueOf(j3), Long.valueOf(j4));
        return iCompare < 0 ? Direction.f11217a : iCompare > 0 ? Direction.f11219c : Direction.f11218b;
    }

    private static final int d(long j3, TextLayoutResult textLayoutResult) {
        int i3 = (int) (4294967295L & j3);
        if (Float.intBitsToFloat(i3) <= 0.0f) {
            return 0;
        }
        return Float.intBitsToFloat(i3) >= textLayoutResult.w().h() ? textLayoutResult.l().j().length() : textLayoutResult.x(j3);
    }

    private static final int e(Selection.AnchorInfo anchorInfo, Comparator comparator, long j3, int i3) {
        int iCompare = comparator.compare(Long.valueOf(anchorInfo.e()), Long.valueOf(j3));
        if (iCompare < 0) {
            return 0;
        }
        return iCompare > 0 ? i3 : anchorInfo.d();
    }

    private static final Direction f(long j3, Rect rect) {
        int i3 = (int) (j3 >> 32);
        return Float.intBitsToFloat(i3) < rect.o() ? Direction.f11217a : Float.intBitsToFloat(i3) > rect.p() ? Direction.f11219c : Direction.f11218b;
    }

    private static final Direction g(long j3, Rect rect) {
        int i3 = (int) (j3 & 4294967295L);
        return Float.intBitsToFloat(i3) < rect.r() ? Direction.f11217a : Float.intBitsToFloat(i3) > rect.i() ? Direction.f11219c : Direction.f11218b;
    }

    private static final boolean h(Direction direction, Direction direction2) {
        return direction == Direction.f11218b || direction != direction2;
    }
}
