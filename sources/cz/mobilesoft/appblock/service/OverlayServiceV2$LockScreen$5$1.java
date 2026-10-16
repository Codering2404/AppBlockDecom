package cz.mobilesoft.appblock.service;

import androidx.compose.runtime.MutableState;
import cz.mobilesoft.coreblock.scene.lockscreen.LockViewEvent;
import cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog;
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
import kotlinx.coroutines.CoroutineScope;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.appblock.service.OverlayServiceV2$LockScreen$5$1", f = "OverlayServiceV2.kt", l = {}, m = "invokeSuspend", v = 1)
final class OverlayServiceV2$LockScreen$5$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f94672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ MutableState f94673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ OverlayServiceV2 f94674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function1 f94675d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OverlayServiceV2$LockScreen$5$1(MutableState mutableState, OverlayServiceV2 overlayServiceV2, Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.f94673b = mutableState;
        this.f94674c = overlayServiceV2;
        this.f94675d = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(Function1 function1, MutableState mutableState) {
        function1.invoke(LockViewEvent.OnBackdoorDialogSuccess.f105475a);
        mutableState.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new OverlayServiceV2$LockScreen$5$1(this.f94673b, this.f94674c, this.f94675d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f94672a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (((Boolean) this.f94673b.getValue()).booleanValue()) {
            BackdoorCodeDialog backdoorCodeDialog = new BackdoorCodeDialog(this.f94674c, null, 2, null);
            final Function1 function1 = this.f94675d;
            final MutableState mutableState = this.f94673b;
            BackdoorCodeDialog.M(backdoorCodeDialog, new Function0() { // from class: cz.mobilesoft.appblock.service.u1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return OverlayServiceV2$LockScreen$5$1.q(function1, mutableState);
                }
            }, null, 2, null);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((OverlayServiceV2$LockScreen$5$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
