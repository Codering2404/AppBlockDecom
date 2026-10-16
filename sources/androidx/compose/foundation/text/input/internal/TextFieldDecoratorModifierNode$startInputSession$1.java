package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.content.internal.ReceiveContentConfiguration;
import androidx.compose.foundation.text.input.internal.selection.TextToolbarState;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.PlatformTextInputModifierNodeKt;
import androidx.compose.ui.platform.PlatformTextInputSessionScope;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

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
@DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$startInputSession$1", f = "TextFieldDecoratorModifier.kt", l = {759}, m = "invokeSuspend")
final class TextFieldDecoratorModifierNode$startInputSession$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f10586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ TextFieldDecoratorModifierNode f10587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ReceiveContentConfiguration f10588c;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$startInputSession$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$startInputSession$1$1", f = "TextFieldDecoratorModifier.kt", l = {760}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<PlatformTextInputSessionScope, Continuation<?>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f10589a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f10590b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ TextFieldDecoratorModifierNode f10591c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ ReceiveContentConfiguration f10592d;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$startInputSession$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        /* synthetic */ class C00281 extends FunctionReferenceImpl implements Function1<ImeAction, Unit> {
            C00281(Object obj) {
                super(1, obj, TextFieldDecoratorModifierNode.class, "onImeActionPerformed", "onImeActionPerformed-KlQnJC8(I)V", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                q(((ImeAction) obj).p());
                return Unit.f139807a;
            }

            public final void q(int i3) {
                ((TextFieldDecoratorModifierNode) this.receiver).T2(i3);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, ReceiveContentConfiguration receiveContentConfiguration, Continuation continuation) {
            super(2, continuation);
            this.f10591c = textFieldDecoratorModifierNode;
            this.f10592d = receiveContentConfiguration;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f10591c, this.f10592d, continuation);
            anonymousClass1.f10590b = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(PlatformTextInputSessionScope platformTextInputSessionScope, Continuation continuation) {
            return ((AnonymousClass1) create(platformTextInputSessionScope, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f10589a;
            if (i3 == 0) {
                ResultKt.b(obj);
                PlatformTextInputSessionScope platformTextInputSessionScope = (PlatformTextInputSessionScope) this.f10590b;
                TransformedTextFieldState transformedTextFieldStateO2 = this.f10591c.O2();
                TextLayoutState textLayoutStateP2 = this.f10591c.P2();
                ImeOptions imeOptionsN = this.f10591c.J2().n(this.f10591c.L2());
                ReceiveContentConfiguration receiveContentConfiguration = this.f10592d;
                C00281 c00281 = new C00281(this.f10591c);
                final TextFieldDecoratorModifierNode textFieldDecoratorModifierNode = this.f10591c;
                Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode.startInputSession.1.1.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m84invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m84invoke() {
                        textFieldDecoratorModifierNode.N2().L0(TextToolbarState.f10962c);
                    }
                };
                MutableSharedFlow mutableSharedFlowM2 = this.f10591c.M2();
                ViewConfiguration viewConfiguration = (ViewConfiguration) CompositionLocalConsumerModifierNodeKt.a(this.f10591c, CompositionLocalsKt.t());
                this.f10589a = 1;
                if (AndroidTextInputSession_androidKt.e(platformTextInputSessionScope, transformedTextFieldStateO2, textLayoutStateP2, imeOptionsN, receiveContentConfiguration, c00281, function0, mutableSharedFlowM2, viewConfiguration, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextFieldDecoratorModifierNode$startInputSession$1(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, ReceiveContentConfiguration receiveContentConfiguration, Continuation continuation) {
        super(2, continuation);
        this.f10587b = textFieldDecoratorModifierNode;
        this.f10588c = receiveContentConfiguration;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new TextFieldDecoratorModifierNode$startInputSession$1(this.f10587b, this.f10588c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f10586a;
        if (i3 == 0) {
            ResultKt.b(obj);
            TextFieldDecoratorModifierNode textFieldDecoratorModifierNode = this.f10587b;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(textFieldDecoratorModifierNode, this.f10588c, null);
            this.f10586a = 1;
            if (PlatformTextInputModifierNodeKt.c(textFieldDecoratorModifierNode, anonymousClass1, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((TextFieldDecoratorModifierNode$startInputSession$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
