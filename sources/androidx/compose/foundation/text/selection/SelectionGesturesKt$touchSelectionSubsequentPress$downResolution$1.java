package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

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
@DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1", f = "SelectionGestures.kt", l = {283}, m = "invokeSuspend")
final class SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super DownResolution>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f11365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f11366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f11367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Ref.LongRef f11368d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1(long j3, Ref.LongRef longRef, Continuation continuation) {
        super(2, continuation);
        this.f11367c = j3;
        this.f11368d = longRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1 selectionGesturesKt$touchSelectionSubsequentPress$downResolution$1 = new SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1(this.f11367c, this.f11368d, continuation);
        selectionGesturesKt$touchSelectionSubsequentPress$downResolution$1.f11366b = obj;
        return selectionGesturesKt$touchSelectionSubsequentPress$downResolution$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation continuation) {
        return ((SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        AwaitPointerEventScope awaitPointerEventScope;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f11365a;
        if (i3 == 0) {
            ResultKt.b(obj);
            AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) this.f11366b;
            long j3 = this.f11367c;
            final Ref.LongRef longRef = this.f11368d;
            Function2<PointerInputChange, Offset, Unit> function2 = new Function2<PointerInputChange, Offset, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1$firstDragPastSlop$1
                {
                    super(2);
                }

                public final void c(PointerInputChange pointerInputChange, long j4) {
                    pointerInputChange.a();
                    longRef.f140143a = j4;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    c((PointerInputChange) obj2, ((Offset) obj3).u());
                    return Unit.f139807a;
                }
            };
            this.f11366b = awaitPointerEventScope2;
            this.f11365a = 1;
            Object objI = DragGestureDetectorKt.i(awaitPointerEventScope2, j3, function2, this);
            if (objI == objF) {
                return objF;
            }
            awaitPointerEventScope = awaitPointerEventScope2;
            obj = objI;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            awaitPointerEventScope = (AwaitPointerEventScope) this.f11366b;
            ResultKt.b(obj);
        }
        if (((PointerInputChange) obj) != null && (this.f11368d.f140143a & 9223372034707292159L) != 9205357640488583168L) {
            return DownResolution.f11223b;
        }
        PointerInputChange pointerInputChange = (PointerInputChange) CollectionsKt.first(awaitPointerEventScope.U0().c());
        if (!PointerEventKt.d(pointerInputChange)) {
            return DownResolution.f11225d;
        }
        pointerInputChange.a();
        return DownResolution.f11222a;
    }
}
