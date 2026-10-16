package androidx.compose.foundation.text.input.internal;

import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.foundation.content.internal.ReceiveContentConfiguration;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3;
import androidx.compose.ui.platform.PlatformTextInputMethodRequest;
import androidx.compose.ui.platform.PlatformTextInputSession;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextRange;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
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
@DebugMetadata(c = "androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3", f = "AndroidTextInputSession.android.kt", l = {124}, m = "invokeSuspend")
final class AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f10207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f10208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ MutableSharedFlow f10209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ TransformedTextFieldState f10210d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ TextLayoutState f10211f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ ComposeInputMethodManager f10212g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ PlatformTextInputSession f10213h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ ImeOptions f10214i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ ReceiveContentConfiguration f10215j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ Function1 f10216k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ Function0 f10217l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final /* synthetic */ ViewConfiguration f10218m;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$1", f = "AndroidTextInputSession.android.kt", l = {86}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f10219a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TransformedTextFieldState f10220b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ComposeInputMethodManager f10221c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TransformedTextFieldState transformedTextFieldState, ComposeInputMethodManager composeInputMethodManager, Continuation continuation) {
            super(2, continuation);
            this.f10220b = transformedTextFieldState;
            this.f10221c = composeInputMethodManager;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void q(ComposeInputMethodManager composeInputMethodManager, TextFieldCharSequence textFieldCharSequence, TextFieldCharSequence textFieldCharSequence2, boolean z2) {
            long jG = textFieldCharSequence.g();
            TextRange textRangeD = textFieldCharSequence.d();
            long jG2 = textFieldCharSequence2.g();
            TextRange textRangeD2 = textFieldCharSequence2.d();
            if (z2) {
                composeInputMethodManager.b();
            } else {
                if (TextRange.g(jG, jG2) && Intrinsics.areEqual(textRangeD, textRangeD2)) {
                    return;
                }
                composeInputMethodManager.a(TextRange.l(jG2), TextRange.k(jG2), textRangeD2 != null ? TextRange.l(textRangeD2.r()) : -1, textRangeD2 != null ? TextRange.k(textRangeD2.r()) : -1);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f10220b, this.f10221c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f10219a;
            if (i3 == 0) {
                ResultKt.b(obj);
                TransformedTextFieldState transformedTextFieldState = this.f10220b;
                final ComposeInputMethodManager composeInputMethodManager = this.f10221c;
                TextFieldState.NotifyImeListener notifyImeListener = new TextFieldState.NotifyImeListener() { // from class: androidx.compose.foundation.text.input.internal.b
                    @Override // androidx.compose.foundation.text.input.TextFieldState.NotifyImeListener
                    public final void a(TextFieldCharSequence textFieldCharSequence, TextFieldCharSequence textFieldCharSequence2, boolean z2) {
                        AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3.AnonymousClass1.q(composeInputMethodManager, textFieldCharSequence, textFieldCharSequence2, z2);
                    }
                };
                this.f10219a = 1;
                if (transformedTextFieldState.i(notifyImeListener, this) == objF) {
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
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3(MutableSharedFlow mutableSharedFlow, TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState, ComposeInputMethodManager composeInputMethodManager, PlatformTextInputSession platformTextInputSession, ImeOptions imeOptions, ReceiveContentConfiguration receiveContentConfiguration, Function1 function1, Function0 function0, ViewConfiguration viewConfiguration, Continuation continuation) {
        super(2, continuation);
        this.f10209c = mutableSharedFlow;
        this.f10210d = transformedTextFieldState;
        this.f10211f = textLayoutState;
        this.f10212g = composeInputMethodManager;
        this.f10213h = platformTextInputSession;
        this.f10214i = imeOptions;
        this.f10215j = receiveContentConfiguration;
        this.f10216k = function1;
        this.f10217l = function0;
        this.f10218m = viewConfiguration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InputConnection q(final TransformedTextFieldState transformedTextFieldState, ImeOptions imeOptions, ReceiveContentConfiguration receiveContentConfiguration, ComposeInputMethodManager composeInputMethodManager, Function1 function1, CursorAnchorInfoController cursorAnchorInfoController, TextLayoutState textLayoutState, Function0 function0, ViewConfiguration viewConfiguration, EditorInfo editorInfo) {
        AndroidTextInputSession_androidKt.c(null, new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$3$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "createInputConnection(value=\"" + ((Object) transformedTextFieldState.o()) + "\")";
            }
        }, 1, null);
        AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$3$textInputSession$1 androidTextInputSession_androidKt$platformSpecificTextInputSession$3$3$textInputSession$1 = new AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$3$textInputSession$1(new DefaultImeEditCommandScope(transformedTextFieldState), transformedTextFieldState, composeInputMethodManager, function1, receiveContentConfiguration, cursorAnchorInfoController, textLayoutState, function0, viewConfiguration);
        EditorInfo_androidKt.b(editorInfo, transformedTextFieldState.o(), transformedTextFieldState.o().g(), imeOptions, receiveContentConfiguration != null ? AndroidTextInputSession_androidKt.f10202a : null);
        return new StatelessInputConnection(androidTextInputSession_androidKt$platformSpecificTextInputSession$3$3$textInputSession$1, editorInfo);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3 androidTextInputSession_androidKt$platformSpecificTextInputSession$3 = new AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3(this.f10209c, this.f10210d, this.f10211f, this.f10212g, this.f10213h, this.f10214i, this.f10215j, this.f10216k, this.f10217l, this.f10218m, continuation);
        androidTextInputSession_androidKt$platformSpecificTextInputSession$3.f10208b = obj;
        return androidTextInputSession_androidKt$platformSpecificTextInputSession$3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f10207a;
        if (i3 == 0) {
            ResultKt.b(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.f10208b;
            BuildersKt__Builders_commonKt.d(coroutineScope, null, CoroutineStart.f140919d, new AnonymousClass1(this.f10210d, this.f10212g, null), 1, null);
            MutableSharedFlow mutableSharedFlow = this.f10209c;
            if (mutableSharedFlow != null) {
                BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$2$1(mutableSharedFlow, this.f10212g, null), 3, null);
            }
            final CursorAnchorInfoController cursorAnchorInfoController = new CursorAnchorInfoController(this.f10210d, this.f10211f, this.f10212g, coroutineScope);
            PlatformTextInputSession platformTextInputSession = this.f10213h;
            final TransformedTextFieldState transformedTextFieldState = this.f10210d;
            final ImeOptions imeOptions = this.f10214i;
            final ReceiveContentConfiguration receiveContentConfiguration = this.f10215j;
            final ComposeInputMethodManager composeInputMethodManager = this.f10212g;
            final Function1 function1 = this.f10216k;
            final TextLayoutState textLayoutState = this.f10211f;
            final Function0 function0 = this.f10217l;
            final ViewConfiguration viewConfiguration = this.f10218m;
            PlatformTextInputMethodRequest platformTextInputMethodRequest = new PlatformTextInputMethodRequest() { // from class: androidx.compose.foundation.text.input.internal.a
                @Override // androidx.compose.ui.platform.PlatformTextInputMethodRequest
                public final InputConnection a(EditorInfo editorInfo) {
                    return AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3.q(transformedTextFieldState, imeOptions, receiveContentConfiguration, composeInputMethodManager, function1, cursorAnchorInfoController, textLayoutState, function0, viewConfiguration, editorInfo);
                }
            };
            this.f10207a = 1;
            if (platformTextInputSession.b(platformTextInputMethodRequest, this) == objF) {
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
        return ((AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
