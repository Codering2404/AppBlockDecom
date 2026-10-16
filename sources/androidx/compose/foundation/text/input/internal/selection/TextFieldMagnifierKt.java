package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.input.internal.TextLayoutState;
import androidx.compose.foundation.text.input.internal.TextLayoutStateKt;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
public final class TextFieldMagnifierKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10721a;

        static {
            int[] iArr = new int[Handle.values().length];
            try {
                iArr[Handle.f9697a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Handle.f9698b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Handle.f9699c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f10721a = iArr;
        }
    }

    public static final long a(TransformedTextFieldState transformedTextFieldState, TextFieldSelectionState textFieldSelectionState, TextLayoutState textLayoutState, long j3) {
        int iN;
        long jA0 = textFieldSelectionState.a0();
        if ((9223372034707292159L & jA0) == 9205357640488583168L || transformedTextFieldState.o().length() == 0) {
            return Offset.f25596b.b();
        }
        long jG = transformedTextFieldState.o().g();
        Handle handleY = textFieldSelectionState.Y();
        int i3 = handleY == null ? -1 : WhenMappings.f10721a[handleY.ordinal()];
        if (i3 == -1) {
            return Offset.f25596b.b();
        }
        if (i3 == 1 || i3 == 2) {
            iN = TextRange.n(jG);
        } else {
            if (i3 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            iN = TextRange.i(jG);
        }
        TextLayoutResult textLayoutResultF = textLayoutState.f();
        if (textLayoutResultF == null) {
            return Offset.f25596b.b();
        }
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jA0 >> 32));
        int iQ = textLayoutResultF.q(iN);
        float fS = textLayoutResultF.s(iQ);
        float fT = textLayoutResultF.t(iQ);
        float fO = RangesKt.o(fIntBitsToFloat, Math.min(fS, fT), Math.max(fS, fT));
        if (!IntSize.e(j3, IntSize.f29998b.a()) && Math.abs(fIntBitsToFloat - fO) > ((int) (j3 >> 32)) / 2) {
            return Offset.f25596b.b();
        }
        float fV = textLayoutResultF.v(iQ);
        long jE = Offset.e((((long) Float.floatToRawIntBits(((textLayoutResultF.m(iQ) - fV) / 2) + fV)) & 4294967295L) | (((long) Float.floatToRawIntBits(fO)) << 32));
        LayoutCoordinates layoutCoordinatesJ = textLayoutState.j();
        if (layoutCoordinatesJ != null) {
            if (!layoutCoordinatesJ.m()) {
                layoutCoordinatesJ = null;
            }
            if (layoutCoordinatesJ != null) {
                jE = TextLayoutStateKt.a(jE, SelectionManagerKt.i(layoutCoordinatesJ));
            }
        }
        return TextLayoutStateKt.c(textLayoutState, jE);
    }
}
