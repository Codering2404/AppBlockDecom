package cz.mobilesoft.appblock.service;

import android.content.Context;
import android.os.Bundle;
import com.facebook.login.widget.ToolTipPopup;
import cz.mobilesoft.coreblock.service.ForegroundServiceLauncher;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

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
@DebugMetadata(c = "cz.mobilesoft.appblock.service.LockServiceHelperKt$launchForegroundService$1", f = "LockServiceHelper.kt", l = {18}, m = "invokeSuspend", v = 1)
final class LockServiceHelperKt$launchForegroundService$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f94522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ForegroundServiceLauncher f94523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f94524c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Bundle f94525d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockServiceHelperKt$launchForegroundService$1(ForegroundServiceLauncher foregroundServiceLauncher, Context context, Bundle bundle, Continuation continuation) {
        super(2, continuation);
        this.f94523b = foregroundServiceLauncher;
        this.f94524c = context;
        this.f94525d = bundle;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LockServiceHelperKt$launchForegroundService$1(this.f94523b, this.f94524c, this.f94525d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f94522a;
        if (i3 == 0) {
            ResultKt.b(obj);
            this.f94522a = 1;
            if (DelayKt.b(ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        if (!this.f94523b.d()) {
            this.f94523b.f(this.f94524c, this.f94525d);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LockServiceHelperKt$launchForegroundService$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
