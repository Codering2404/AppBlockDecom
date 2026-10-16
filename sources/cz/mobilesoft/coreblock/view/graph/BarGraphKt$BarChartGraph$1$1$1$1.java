package cz.mobilesoft.coreblock.view.graph;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
final class BarGraphKt$BarChartGraph$1$1$1$1 implements PointerInputEventHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Function1 f132734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ SnapshotStateList f132735b;

    BarGraphKt$BarChartGraph$1$1$1$1(Function1 function1, SnapshotStateList snapshotStateList) {
        this.f132734a = function1;
        this.f132735b = snapshotStateList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b(SnapshotStateList snapshotStateList, Function1 function1, Offset offset) {
        int i3 = 0;
        for (Object obj : snapshotStateList) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (((Rect) obj).f(offset.u())) {
                function1.invoke(Integer.valueOf(i3));
                return Unit.f139807a;
            }
            i3 = i4;
        }
        function1.invoke(null);
        return Unit.f139807a;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
        final Function1 function1 = this.f132734a;
        if (function1 == null) {
            return Unit.f139807a;
        }
        final SnapshotStateList snapshotStateList = this.f132735b;
        Object objM = TapGestureDetectorKt.m(pointerInputScope, null, null, null, new Function1() { // from class: cz.mobilesoft.coreblock.view.graph.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BarGraphKt$BarChartGraph$1$1$1$1.b(snapshotStateList, function1, (Offset) obj);
            }
        }, continuation, 7, null);
        return objM == IntrinsicsKt.f() ? objM : Unit.f139807a;
    }
}
