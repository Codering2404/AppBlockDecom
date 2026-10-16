package androidx.compose.foundation;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

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
@DebugMetadata(c = "androidx.compose.foundation.CombinedClickableNode$clickPointerInput$4", f = "Clickable.kt", l = {770}, m = "invokeSuspend")
final class CombinedClickableNode$clickPointerInput$4 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f4873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f4874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ long f4875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ CombinedClickableNode f4876d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CombinedClickableNode$clickPointerInput$4(CombinedClickableNode combinedClickableNode, Continuation continuation) {
        super(3, continuation);
        this.f4876d = combinedClickableNode;
    }

    public final Object h(PressGestureScope pressGestureScope, long j3, Continuation continuation) {
        CombinedClickableNode$clickPointerInput$4 combinedClickableNode$clickPointerInput$4 = new CombinedClickableNode$clickPointerInput$4(this.f4876d, continuation);
        combinedClickableNode$clickPointerInput$4.f4874b = pressGestureScope;
        combinedClickableNode$clickPointerInput$4.f4875c = j3;
        return combinedClickableNode$clickPointerInput$4.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return h((PressGestureScope) obj, ((Offset) obj2).u(), (Continuation) obj3);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f4873a;
        if (i3 == 0) {
            ResultKt.b(obj);
            PressGestureScope pressGestureScope = (PressGestureScope) this.f4874b;
            long j3 = this.f4875c;
            if (this.f4876d.F2()) {
                CombinedClickableNode combinedClickableNode = this.f4876d;
                this.f4873a = 1;
                if (combinedClickableNode.H2(pressGestureScope, j3, this) == objF) {
                    return objF;
                }
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }
}
