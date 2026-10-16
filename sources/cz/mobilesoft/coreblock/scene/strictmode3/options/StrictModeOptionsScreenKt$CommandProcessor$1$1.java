package cz.mobilesoft.coreblock.scene.strictmode3.options;

import android.content.Context;
import android.content.Intent;
import cz.mobilesoft.coreblock.scene.permission.PermissionActivity;
import cz.mobilesoft.coreblock.scene.strictmode3.options.StrictModeOptionsViewCommand;
import cz.mobilesoft.coreblock.view.compose.ActivityLauncher;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.options.StrictModeOptionsScreenKt$CommandProcessor$1$1", f = "StrictModeOptionsScreen.kt", l = {}, m = "invokeSuspend", v = 1)
final class StrictModeOptionsScreenKt$CommandProcessor$1$1 extends SuspendLambda implements Function2<StrictModeOptionsViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f122289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f122290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f122291c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ActivityLauncher f122292d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function1 f122293f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StrictModeOptionsScreenKt$CommandProcessor$1$1(Context context, ActivityLauncher activityLauncher, Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.f122291c = context;
        this.f122292d = activityLauncher;
        this.f122293f = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        StrictModeOptionsScreenKt$CommandProcessor$1$1 strictModeOptionsScreenKt$CommandProcessor$1$1 = new StrictModeOptionsScreenKt$CommandProcessor$1$1(this.f122291c, this.f122292d, this.f122293f, continuation);
        strictModeOptionsScreenKt$CommandProcessor$1$1.f122290b = obj;
        return strictModeOptionsScreenKt$CommandProcessor$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(StrictModeOptionsViewCommand strictModeOptionsViewCommand, Continuation continuation) {
        return ((StrictModeOptionsScreenKt$CommandProcessor$1$1) create(strictModeOptionsViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        StrictModeOptionsViewCommand strictModeOptionsViewCommand = (StrictModeOptionsViewCommand) this.f122290b;
        IntrinsicsKt.f();
        if (this.f122289a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (strictModeOptionsViewCommand instanceof StrictModeOptionsViewCommand.ShowPermissionActivity) {
            StrictModeOptionsViewCommand.ShowPermissionActivity showPermissionActivity = (StrictModeOptionsViewCommand.ShowPermissionActivity) strictModeOptionsViewCommand;
            Intent intentB = PermissionActivity.Companion.b(PermissionActivity.f111772j, this.f122291c, showPermissionActivity.b(), false, false, false, null, null, 116, null);
            this.f122292d.a().setValue(showPermissionActivity.a());
            this.f122292d.b().b(intentB);
        } else {
            if (!Intrinsics.areEqual(strictModeOptionsViewCommand, StrictModeOptionsViewCommand.Close.f122294a)) {
                throw new NoWhenBranchMatchedException();
            }
            this.f122293f.invoke(Boxing.a(true));
        }
        return Unit.f139807a;
    }
}
