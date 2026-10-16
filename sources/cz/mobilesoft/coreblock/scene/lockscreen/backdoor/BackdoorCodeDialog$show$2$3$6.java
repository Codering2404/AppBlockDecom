package cz.mobilesoft.coreblock.scene.lockscreen.backdoor;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.databinding.DialogRichEditTextBinding;
import cz.mobilesoft.coreblock.util.Canceled;
import cz.mobilesoft.coreblock.util.FailedWithError;
import cz.mobilesoft.coreblock.util.Loading;
import cz.mobilesoft.coreblock.util.Success;
import cz.mobilesoft.coreblock.util.ViewModelState;
import cz.mobilesoft.coreblock.util.view.ViewHelperExtKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$show$2$3$6", f = "BackdoorCodeDialog.kt", l = {232}, m = "invokeSuspend", v = 1)
final class BackdoorCodeDialog$show$2$3$6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f105628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BackdoorCodeDialog f105629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ DialogRichEditTextBinding f105630c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BackdoorCodeDialog$show$2$3$6(BackdoorCodeDialog backdoorCodeDialog, DialogRichEditTextBinding dialogRichEditTextBinding, Continuation continuation) {
        super(2, continuation);
        this.f105629b = backdoorCodeDialog;
        this.f105630c = dialogRichEditTextBinding;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BackdoorCodeDialog$show$2$3$6(this.f105629b, this.f105630c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f105628a;
        if (i3 == 0) {
            ResultKt.b(obj);
            MutableStateFlow mutableStateFlow = this.f105629b.f105581j;
            final BackdoorCodeDialog backdoorCodeDialog = this.f105629b;
            final DialogRichEditTextBinding dialogRichEditTextBinding = this.f105630c;
            FlowCollector flowCollector = new FlowCollector() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$show$2$3$6.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object emit(ViewModelState viewModelState, Continuation continuation) {
                    String string;
                    AlertDialog alertDialog = backdoorCodeDialog.f105583l;
                    if (alertDialog == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("alertDialog");
                        alertDialog = null;
                    }
                    if (alertDialog.isShowing()) {
                        EditText editText = dialogRichEditTextBinding.f96533d;
                        Intrinsics.checkNotNullExpressionValue(editText, "editText");
                        boolean z2 = viewModelState instanceof Canceled;
                        editText.setVisibility(z2 ? 0 : 8);
                        TextView errorTextView = dialogRichEditTextBinding.f96534e;
                        Intrinsics.checkNotNullExpressionValue(errorTextView, "errorTextView");
                        boolean z3 = viewModelState instanceof FailedWithError;
                        errorTextView.setVisibility(z3 ? 0 : 8);
                        TextView textView = dialogRichEditTextBinding.f96534e;
                        FailedWithError failedWithError = z3 ? (FailedWithError) viewModelState : null;
                        if (failedWithError == null || (string = failedWithError.c()) == null) {
                            string = backdoorCodeDialog.B().getString(R.string.E9);
                            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        }
                        textView.setText(string);
                        ProgressBar progressBar = dialogRichEditTextBinding.f96536g;
                        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
                        progressBar.setVisibility(viewModelState instanceof Loading ? 0 : 8);
                        ImageView checkImageView = dialogRichEditTextBinding.f96531b;
                        Intrinsics.checkNotNullExpressionValue(checkImageView, "checkImageView");
                        boolean z4 = viewModelState instanceof Success;
                        checkImageView.setVisibility(z4 ? 0 : 8);
                        Button button = backdoorCodeDialog.f105584m;
                        if (button != null) {
                            button.setEnabled(z2 || z3);
                        }
                        Button button2 = backdoorCodeDialog.f105584m;
                        if (button2 != null) {
                            button2.setText(z3 ? R.string.Ks : R.string.PF);
                        }
                        if (z4) {
                            ImageView checkImageView2 = dialogRichEditTextBinding.f96531b;
                            Intrinsics.checkNotNullExpressionValue(checkImageView2, "checkImageView");
                            ViewHelperExtKt.b(checkImageView2);
                        }
                    }
                    return Unit.f139807a;
                }
            };
            this.f105628a = 1;
            if (mutableStateFlow.collect(flowCollector, this) == objF) {
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
        return ((BackdoorCodeDialog$show$2$3$6) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
