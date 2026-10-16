package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.TextInputService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

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
@DebugMetadata(c = "androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$2$1", f = "CoreTextField.kt", l = {347}, m = "invokeSuspend")
final class CoreTextFieldKt$CoreTextField$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f9537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LegacyTextFieldState f9538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ State f9539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ TextInputService f9540d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ TextFieldSelectionManager f9541f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ ImeOptions f9542g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CoreTextFieldKt$CoreTextField$2$1(LegacyTextFieldState legacyTextFieldState, State state, TextInputService textInputService, TextFieldSelectionManager textFieldSelectionManager, ImeOptions imeOptions, Continuation continuation) {
        super(2, continuation);
        this.f9538b = legacyTextFieldState;
        this.f9539c = state;
        this.f9540d = textInputService;
        this.f9541f = textFieldSelectionManager;
        this.f9542g = imeOptions;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new CoreTextFieldKt$CoreTextField$2$1(this.f9538b, this.f9539c, this.f9540d, this.f9541f, this.f9542g, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f9537a;
        try {
            if (i3 == 0) {
                ResultKt.b(obj);
                final State state = this.f9539c;
                Flow flowQ = SnapshotStateKt.q(new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$2$1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        return Boolean.valueOf(CoreTextFieldKt.b(state));
                    }
                });
                final LegacyTextFieldState legacyTextFieldState = this.f9538b;
                final TextInputService textInputService = this.f9540d;
                final TextFieldSelectionManager textFieldSelectionManager = this.f9541f;
                final ImeOptions imeOptions = this.f9542g;
                FlowCollector flowCollector = new FlowCollector() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$2$1.2
                    public final Object a(boolean z2, Continuation continuation) {
                        if (z2 && legacyTextFieldState.f()) {
                            CoreTextFieldKt.p(textInputService, legacyTextFieldState, textFieldSelectionManager.U(), imeOptions, textFieldSelectionManager.N());
                        } else {
                            CoreTextFieldKt.m(legacyTextFieldState);
                        }
                        return Unit.f139807a;
                    }

                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return a(((Boolean) obj2).booleanValue(), continuation);
                    }
                };
                this.f9537a = 1;
                if (flowQ.collect(flowCollector, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            CoreTextFieldKt.m(this.f9538b);
            return Unit.f139807a;
        } catch (Throwable th) {
            CoreTextFieldKt.m(this.f9538b);
            throw th;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((CoreTextFieldKt$CoreTextField$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
