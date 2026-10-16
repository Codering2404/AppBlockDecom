package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.selection.SelectionHandlesKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

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
@DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2", f = "TextFieldSelectionState.kt", l = {}, m = "invokeSuspend")
final class TextFieldSelectionState$selectionHandleGestures$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f10907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f10908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ TextFieldSelectionState f10909c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ PointerInputScope f10910d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ boolean f10911f;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$1", f = "TextFieldSelectionState.kt", l = {392}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f10912a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextFieldSelectionState f10913b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ PointerInputScope f10914c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TextFieldSelectionState textFieldSelectionState, PointerInputScope pointerInputScope, Continuation continuation) {
            super(2, continuation);
            this.f10913b = textFieldSelectionState;
            this.f10914c = pointerInputScope;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f10913b, this.f10914c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f10912a;
            if (i3 == 0) {
                ResultKt.b(obj);
                TextFieldSelectionState textFieldSelectionState = this.f10913b;
                PointerInputScope pointerInputScope = this.f10914c;
                this.f10912a = 1;
                if (textFieldSelectionState.R(pointerInputScope, this) == objF) {
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
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$2", f = "TextFieldSelectionState.kt", l = {394}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f10915a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ PointerInputScope f10916b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ TextFieldSelectionState f10917c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f10918d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(PointerInputScope pointerInputScope, TextFieldSelectionState textFieldSelectionState, boolean z2, Continuation continuation) {
            super(2, continuation);
            this.f10916b = pointerInputScope;
            this.f10917c = textFieldSelectionState;
            this.f10918d = z2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.f10916b, this.f10917c, this.f10918d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f10915a;
            if (i3 == 0) {
                ResultKt.b(obj);
                PointerInputScope pointerInputScope = this.f10916b;
                final TextFieldSelectionState textFieldSelectionState = this.f10917c;
                final boolean z2 = this.f10918d;
                TapOnPosition tapOnPosition = new TapOnPosition() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.selectionHandleGestures.2.2.1
                    @Override // androidx.compose.foundation.text.input.internal.selection.TapOnPosition
                    public final void a(long j3) {
                        textFieldSelectionState.n0();
                        TextFieldSelectionState textFieldSelectionState2 = textFieldSelectionState;
                        boolean z3 = z2;
                        textFieldSelectionState2.I0(z3 ? Handle.f9698b : Handle.f9699c, SelectionHandlesKt.a(textFieldSelectionState2.b0(z3)));
                    }
                };
                final TextFieldSelectionState textFieldSelectionState2 = this.f10917c;
                Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.selectionHandleGestures.2.2.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m90invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m90invoke() {
                        textFieldSelectionState2.G();
                    }
                };
                this.f10915a = 1;
                if (PressDownGestureKt.a(pointerInputScope, tapOnPosition, function0, this) == objF) {
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
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$3", f = "TextFieldSelectionState.kt", l = {411}, m = "invokeSuspend")
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f10922a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextFieldSelectionState f10923b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ PointerInputScope f10924c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f10925d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(TextFieldSelectionState textFieldSelectionState, PointerInputScope pointerInputScope, boolean z2, Continuation continuation) {
            super(2, continuation);
            this.f10923b = textFieldSelectionState;
            this.f10924c = pointerInputScope;
            this.f10925d = z2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass3(this.f10923b, this.f10924c, this.f10925d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f10922a;
            if (i3 == 0) {
                ResultKt.b(obj);
                TextFieldSelectionState textFieldSelectionState = this.f10923b;
                PointerInputScope pointerInputScope = this.f10924c;
                boolean z2 = this.f10925d;
                this.f10922a = 1;
                if (textFieldSelectionState.O(pointerInputScope, z2, this) == objF) {
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
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextFieldSelectionState$selectionHandleGestures$2(TextFieldSelectionState textFieldSelectionState, PointerInputScope pointerInputScope, boolean z2, Continuation continuation) {
        super(2, continuation);
        this.f10909c = textFieldSelectionState;
        this.f10910d = pointerInputScope;
        this.f10911f = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        TextFieldSelectionState$selectionHandleGestures$2 textFieldSelectionState$selectionHandleGestures$2 = new TextFieldSelectionState$selectionHandleGestures$2(this.f10909c, this.f10910d, this.f10911f, continuation);
        textFieldSelectionState$selectionHandleGestures$2.f10908b = obj;
        return textFieldSelectionState$selectionHandleGestures$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f10907a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.f10908b;
        CoroutineStart coroutineStart = CoroutineStart.f140919d;
        BuildersKt__Builders_commonKt.d(coroutineScope, null, coroutineStart, new AnonymousClass1(this.f10909c, this.f10910d, null), 1, null);
        BuildersKt__Builders_commonKt.d(coroutineScope, null, coroutineStart, new AnonymousClass2(this.f10910d, this.f10909c, this.f10911f, null), 1, null);
        return BuildersKt__Builders_commonKt.d(coroutineScope, null, coroutineStart, new AnonymousClass3(this.f10909c, this.f10910d, this.f10911f, null), 1, null);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((TextFieldSelectionState$selectionHandleGestures$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
