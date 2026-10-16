package androidx.compose.foundation.text.input.internal;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.WindowInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

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
@DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$startCursorJob$1", f = "TextFieldCoreModifier.kt", l = {558}, m = "invokeSuspend")
final class TextFieldCoreModifierNode$startCursorJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f10472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ TextFieldCoreModifierNode f10473b;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$startCursorJob$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$startCursorJob$1$2", f = "TextFieldCoreModifier.kt", l = {560}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f10476a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ int f10477b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ TextFieldCoreModifierNode f10478c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(TextFieldCoreModifierNode textFieldCoreModifierNode, Continuation continuation) {
            super(2, continuation);
            this.f10478c = textFieldCoreModifierNode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.f10478c, continuation);
            anonymousClass2.f10477b = ((Number) obj).intValue();
            return anonymousClass2;
        }

        public final Object h(int i3, Continuation continuation) {
            return ((AnonymousClass2) create(Integer.valueOf(i3), continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return h(((Number) obj).intValue(), (Continuation) obj2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            CursorAnimationState cursorAnimationState;
            Object objF = IntrinsicsKt.f();
            int i3 = this.f10476a;
            if (i3 == 0) {
                ResultKt.b(obj);
                if (Math.abs(this.f10477b) == 1 && (cursorAnimationState = this.f10478c.f10458m) != null) {
                    this.f10476a = 1;
                    if (cursorAnimationState.g(this) == objF) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextFieldCoreModifierNode$startCursorJob$1(TextFieldCoreModifierNode textFieldCoreModifierNode, Continuation continuation) {
        super(2, continuation);
        this.f10473b = textFieldCoreModifierNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new TextFieldCoreModifierNode$startCursorJob$1(this.f10473b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f10472a;
        if (i3 == 0) {
            ResultKt.b(obj);
            final Ref.IntRef intRef = new Ref.IntRef();
            intRef.f140142a = 1;
            final TextFieldCoreModifierNode textFieldCoreModifierNode = this.f10473b;
            Flow flowQ = SnapshotStateKt.q(new Function0<Integer>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$startCursorJob$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Integer invoke() {
                    textFieldCoreModifierNode.f10452g.o();
                    Integer numValueOf = Integer.valueOf(((textFieldCoreModifierNode.isAttached() && ((WindowInfo) CompositionLocalConsumerModifierNodeKt.a(textFieldCoreModifierNode, CompositionLocalsKt.u())).b()) ? 1 : 2) * intRef.f140142a);
                    intRef.f140142a *= -1;
                    return numValueOf;
                }
            });
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.f10473b, null);
            this.f10472a = 1;
            if (FlowKt.l(flowQ, anonymousClass2, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((TextFieldCoreModifierNode$startCursorJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
