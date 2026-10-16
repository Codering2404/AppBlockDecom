package cz.mobilesoft.coreblock.scene.dashboard.blocking.pause;

import android.content.Context;
import android.content.Intent;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewCommand;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingActivity$RootCompose$1$1", f = "PauseBlockingActivity.kt", l = {}, m = "invokeSuspend", v = 1)
final class PauseBlockingActivity$RootCompose$1$1 extends SuspendLambda implements Function2<PauseBlockingViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f100104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f100105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ PauseBlockingActivity f100106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Context f100107d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PauseBlockingActivity$RootCompose$1$1(PauseBlockingActivity pauseBlockingActivity, Context context, Continuation continuation) {
        super(2, continuation);
        this.f100106c = pauseBlockingActivity;
        this.f100107d = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        PauseBlockingActivity$RootCompose$1$1 pauseBlockingActivity$RootCompose$1$1 = new PauseBlockingActivity$RootCompose$1$1(this.f100106c, this.f100107d, continuation);
        pauseBlockingActivity$RootCompose$1$1.f100105b = obj;
        return pauseBlockingActivity$RootCompose$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(PauseBlockingViewCommand pauseBlockingViewCommand, Continuation continuation) {
        return ((PauseBlockingActivity$RootCompose$1$1) create(pauseBlockingViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        PauseBlockingViewCommand pauseBlockingViewCommand = (PauseBlockingViewCommand) this.f100105b;
        IntrinsicsKt.f();
        if (this.f100104a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (pauseBlockingViewCommand instanceof PauseBlockingViewCommand.OnProfilePaused) {
            PauseBlockingActivity pauseBlockingActivity = this.f100106c;
            Intent intent = new Intent();
            PauseBlockingViewCommand.OnProfilePaused onProfilePaused = (PauseBlockingViewCommand.OnProfilePaused) pauseBlockingViewCommand;
            intent.putExtra("PAUSED_UNTIL", onProfilePaused.a());
            intent.putExtra("PROFILE_ID", onProfilePaused.b());
            Unit unit = Unit.f139807a;
            pauseBlockingActivity.setResult(-1, intent);
            this.f100106c.finish();
        } else {
            if (!(pauseBlockingViewCommand instanceof PauseBlockingViewCommand.OnPremiumRequired)) {
                throw new NoWhenBranchMatchedException();
            }
            if (Intrinsics.areEqual(((PauseBlockingViewCommand.OnPremiumRequired) pauseBlockingViewCommand).a(), PremiumState.OldFull.INSTANCE)) {
                Context context = this.f100107d;
                Paywall paywall = Paywall.f113165a;
                String string = this.f100106c.getString(R.string.r2);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                context.startActivity(Paywall.c(paywall, context, new PaywallTarget.OneTimeToSub(string), "blocking_tab", "schedule_pause", false, false, false, null, 240, null));
            } else {
                Context context2 = this.f100107d;
                context2.startActivity(Paywall.c(Paywall.f113165a, context2, new PaywallTarget.LimitScreen(PremiumFeature.PAUSE_SCHEDULES), "blocking_tab", "schedule_pause", false, false, false, null, 240, null));
            }
        }
        return Unit.f139807a;
    }
}
