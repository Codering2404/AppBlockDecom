package androidx.compose.ui.scrollcapture;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.platform.SemanticsUtils_androidKt;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

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
public final class ScrollCapture_androidKt {
    private static final boolean a(SemanticsNode semanticsNode) {
        Function2 function2C = c(semanticsNode);
        ScrollAxisRange scrollAxisRange = (ScrollAxisRange) SemanticsConfigurationKt.a(semanticsNode.w(), SemanticsProperties.f28517a.M());
        return (function2C == null || scrollAxisRange == null || ((Number) scrollAxisRange.a().invoke()).floatValue() <= 0.0f) ? false : true;
    }

    private static final List b(SemanticsNode semanticsNode) {
        return semanticsNode.l(false, false, false);
    }

    public static final Function2 c(SemanticsNode semanticsNode) {
        return (Function2) SemanticsConfigurationKt.a(semanticsNode.w(), SemanticsActions.f28471a.v());
    }

    private static final void d(SemanticsNode semanticsNode, int i3, Function1 function1) {
        SemanticsNode semanticsNode2;
        MutableVector mutableVector = new MutableVector(new SemanticsNode[16], 0);
        List listB = b(semanticsNode);
        while (true) {
            mutableVector.f(mutableVector.o(), listB);
            while (mutableVector.o() != 0) {
                semanticsNode2 = (SemanticsNode) mutableVector.u(mutableVector.o() - 1);
                if (!SemanticsUtils_androidKt.f(semanticsNode2) && !semanticsNode2.w().d(SemanticsProperties.f28517a.f())) {
                    NodeCoordinator nodeCoordinatorE = semanticsNode2.e();
                    if (nodeCoordinatorE == null) {
                        InlineClassHelperKt.d("Expected semantics node to have a coordinator.");
                        throw new KotlinNothingValueException();
                    }
                    LayoutCoordinates layoutCoordinatesU1 = nodeCoordinatorE.u1();
                    IntRect intRectB = IntRectKt.b(LayoutCoordinatesKt.c(layoutCoordinatesU1));
                    if (intRectB.m()) {
                        continue;
                    } else {
                        if (!a(semanticsNode2)) {
                            break;
                        }
                        int i4 = i3 + 1;
                        function1.invoke(new ScrollCaptureCandidate(semanticsNode2, i4, intRectB, layoutCoordinatesU1));
                        d(semanticsNode2, i4, function1);
                    }
                }
            }
            return;
            listB = b(semanticsNode2);
        }
    }

    static /* synthetic */ void e(SemanticsNode semanticsNode, int i3, Function1 function1, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 0;
        }
        d(semanticsNode, i3, function1);
    }
}
