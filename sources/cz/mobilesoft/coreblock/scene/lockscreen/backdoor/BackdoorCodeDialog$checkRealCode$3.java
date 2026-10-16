package cz.mobilesoft.coreblock.scene.lockscreen.backdoor;

import android.widget.TextView;
import cz.mobilesoft.coreblock.databinding.DialogRichEditTextBinding;
import cz.mobilesoft.coreblock.util.Canceled;
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
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$checkRealCode$3", f = "BackdoorCodeDialog.kt", l = {344}, m = "invokeSuspend", v = 1)
final class BackdoorCodeDialog$checkRealCode$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f105603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BackdoorCodeDialog f105604b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BackdoorCodeDialog$checkRealCode$3(BackdoorCodeDialog backdoorCodeDialog, Continuation continuation) {
        super(2, continuation);
        this.f105604b = backdoorCodeDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BackdoorCodeDialog$checkRealCode$3(this.f105604b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f105603a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Job job = this.f105604b.f105585n;
            DialogRichEditTextBinding dialogRichEditTextBinding = null;
            if (job != null) {
                Job.DefaultImpls.b(job, null, 1, null);
            }
            DialogRichEditTextBinding dialogRichEditTextBinding2 = this.f105604b.f105582k;
            if (dialogRichEditTextBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                dialogRichEditTextBinding = dialogRichEditTextBinding2;
            }
            TextView countdownTextView = dialogRichEditTextBinding.f96532c;
            Intrinsics.checkNotNullExpressionValue(countdownTextView, "countdownTextView");
            countdownTextView.setVisibility(8);
            MutableStateFlow mutableStateFlow = this.f105604b.f105581j;
            Canceled canceled = Canceled.f127782a;
            this.f105603a = 1;
            if (mutableStateFlow.emit(canceled, this) == objF) {
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
        return ((BackdoorCodeDialog$checkRealCode$3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
