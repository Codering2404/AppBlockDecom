package cz.mobilesoft.coreblock.scene.strictmode3.access;

import androidx.navigation.NavController;
import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeAccessViewCommand;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeAccessActivityKt$CommandProcessor$1$1", f = "StrictModeAccessActivity.kt", l = {}, m = "invokeSuspend", v = 1)
final class StrictModeAccessActivityKt$CommandProcessor$1$1 extends SuspendLambda implements Function2<StrictModeAccessViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f121512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f121513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ NavController f121514c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function1 f121515d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function2 f121516f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StrictModeAccessActivityKt$CommandProcessor$1$1(NavController navController, Function1 function1, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f121514c = navController;
        this.f121515d = function1;
        this.f121516f = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        StrictModeAccessActivityKt$CommandProcessor$1$1 strictModeAccessActivityKt$CommandProcessor$1$1 = new StrictModeAccessActivityKt$CommandProcessor$1$1(this.f121514c, this.f121515d, this.f121516f, continuation);
        strictModeAccessActivityKt$CommandProcessor$1$1.f121513b = obj;
        return strictModeAccessActivityKt$CommandProcessor$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(StrictModeAccessViewCommand strictModeAccessViewCommand, Continuation continuation) {
        return ((StrictModeAccessActivityKt$CommandProcessor$1$1) create(strictModeAccessViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        StrictModeAccessViewCommand strictModeAccessViewCommand = (StrictModeAccessViewCommand) this.f121513b;
        IntrinsicsKt.f();
        if (this.f121512a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (strictModeAccessViewCommand instanceof StrictModeAccessViewCommand.ShowPinCodeScreen) {
            NavController.P(this.f121514c, AccessNavigation.PinCode.getRoute(), null, null, 6, null);
        } else if (strictModeAccessViewCommand instanceof StrictModeAccessViewCommand.ShowTimerScreen) {
            this.f121515d.invoke(StrictModeAccessMethod.Timer);
        } else if (strictModeAccessViewCommand instanceof StrictModeAccessViewCommand.OnAccessMethodConfirmed) {
            StrictModeAccessViewCommand.OnAccessMethodConfirmed onAccessMethodConfirmed = (StrictModeAccessViewCommand.OnAccessMethodConfirmed) strictModeAccessViewCommand;
            this.f121516f.invoke(onAccessMethodConfirmed.a(), onAccessMethodConfirmed.b());
        } else if (strictModeAccessViewCommand instanceof StrictModeAccessViewCommand.ShowScheduleSelectScreen) {
            NavController.P(this.f121514c, AccessNavigation.FollowSchedules.getRoute(), null, null, 6, null);
        } else {
            if (!(strictModeAccessViewCommand instanceof StrictModeAccessViewCommand.ShowCooldownScreen)) {
                throw new NoWhenBranchMatchedException();
            }
            this.f121515d.invoke(StrictModeAccessMethod.Cooldown);
        }
        return Unit.f139807a;
    }
}
