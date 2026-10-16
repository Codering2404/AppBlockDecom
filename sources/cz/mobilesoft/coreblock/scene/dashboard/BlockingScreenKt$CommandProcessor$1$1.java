package cz.mobilesoft.coreblock.scene.dashboard;

import android.app.Activity;
import android.content.Context;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.SnackbarDuration;
import androidx.compose.material.SnackbarHostState;
import androidx.compose.material.SnackbarResult;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewCommand;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingActivity;
import cz.mobilesoft.coreblock.scene.email_consent.EmailCommunicationConsentActivity;
import cz.mobilesoft.coreblock.scene.more.notifications.BlockedNotificationsActivity;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleDescriptor;
import cz.mobilesoft.coreblock.scene.streaks.detail.StreakDetailActivity;
import cz.mobilesoft.coreblock.scene.streaks.milestone.StreakMilestoneActivity;
import cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackActivity;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import cz.mobilesoft.coreblock.view.dialog.DisclaimerDialog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.BlockingScreenKt$CommandProcessor$1$1", f = "BlockingScreen.kt", l = {}, m = "invokeSuspend", v = 1)
final class BlockingScreenKt$CommandProcessor$1$1 extends SuspendLambda implements Function2<BlockingScreenViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f99095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f99096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f99097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ManagedActivityResultLauncher f99098d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f99099f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ AppCompatActivity f99100g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ ManagedActivityResultLauncher f99101h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ ScaffoldState f99102i;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.BlockingScreenKt$CommandProcessor$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.BlockingScreenKt$CommandProcessor$1$1$1", f = "BlockingScreen.kt", l = {307}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f99103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ScaffoldState f99104b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ BlockingScreenViewCommand f99105c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f99106d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ScaffoldState scaffoldState, BlockingScreenViewCommand blockingScreenViewCommand, Context context, Continuation continuation) {
            super(2, continuation);
            this.f99104b = scaffoldState;
            this.f99105c = blockingScreenViewCommand;
            this.f99106d = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f99104b, this.f99105c, this.f99106d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f99103a;
            if (i3 == 0) {
                ResultKt.b(obj);
                SnackbarHostState snackbarHostStateB = this.f99104b.b();
                String strA = ((BlockingScreenViewCommand.ShowBlockedNotificationsSnackbar) this.f99105c).a();
                String string = this.f99106d.getString(R.string.Yw);
                SnackbarDuration snackbarDuration = SnackbarDuration.Long;
                this.f99103a = 1;
                obj = snackbarHostStateB.d(strA, string, snackbarDuration, this);
                if (obj == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            if (((SnackbarResult) obj) == SnackbarResult.ActionPerformed) {
                Context context = this.f99106d;
                context.startActivity(BlockedNotificationsActivity.f107859o.a(context));
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.BlockingScreenKt$CommandProcessor$1$1$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.BlockingScreenKt$CommandProcessor$1$1$3", f = "BlockingScreen.kt", l = {354}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f99107a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ScaffoldState f99108b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ BlockingScreenViewCommand f99109c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(ScaffoldState scaffoldState, BlockingScreenViewCommand blockingScreenViewCommand, Continuation continuation) {
            super(2, continuation);
            this.f99108b = scaffoldState;
            this.f99109c = blockingScreenViewCommand;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass3(this.f99108b, this.f99109c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f99107a;
            if (i3 == 0) {
                ResultKt.b(obj);
                SnackbarHostState snackbarHostStateB = this.f99108b.b();
                String strA = ((BlockingScreenViewCommand.ShowStrictModeSnackbar) this.f99109c).a();
                this.f99107a = 1;
                if (SnackbarHostState.e(snackbarHostStateB, strA, null, null, this, 6, null) == objF) {
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

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f99110a;

        static {
            int[] iArr = new int[BlockingScreenViewCommand.ShowDisclaimerDialog.DisclaimerType.values().length];
            try {
                iArr[BlockingScreenViewCommand.ShowDisclaimerDialog.DisclaimerType.LOCATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BlockingScreenViewCommand.ShowDisclaimerDialog.DisclaimerType.WIFI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BlockingScreenViewCommand.ShowDisclaimerDialog.DisclaimerType.STRICT_MODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f99110a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BlockingScreenKt$CommandProcessor$1$1(Context context, ManagedActivityResultLauncher managedActivityResultLauncher, CoroutineScope coroutineScope, AppCompatActivity appCompatActivity, ManagedActivityResultLauncher managedActivityResultLauncher2, ScaffoldState scaffoldState, Continuation continuation) {
        super(2, continuation);
        this.f99097c = context;
        this.f99098d = managedActivityResultLauncher;
        this.f99099f = coroutineScope;
        this.f99100g = appCompatActivity;
        this.f99101h = managedActivityResultLauncher2;
        this.f99102i = scaffoldState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        BlockingScreenKt$CommandProcessor$1$1 blockingScreenKt$CommandProcessor$1$1 = new BlockingScreenKt$CommandProcessor$1$1(this.f99097c, this.f99098d, this.f99099f, this.f99100g, this.f99101h, this.f99102i, continuation);
        blockingScreenKt$CommandProcessor$1$1.f99096b = obj;
        return blockingScreenKt$CommandProcessor$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(BlockingScreenViewCommand blockingScreenViewCommand, Continuation continuation) {
        return ((BlockingScreenKt$CommandProcessor$1$1) create(blockingScreenViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        DisclaimerDialog disclaimerDialogE;
        FragmentManager supportFragmentManager;
        BlockingScreenViewCommand blockingScreenViewCommand = (BlockingScreenViewCommand) this.f99096b;
        IntrinsicsKt.f();
        if (this.f99095a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (blockingScreenViewCommand instanceof BlockingScreenViewCommand.OpenStreakDetail) {
            Context context = this.f99097c;
            context.startActivity(StreakDetailActivity.f120665g.a(context));
        } else if (blockingScreenViewCommand instanceof BlockingScreenViewCommand.OpenStreakMilestone) {
            Context context2 = this.f99097c;
            context2.startActivity(StreakMilestoneActivity.f120940g.b(context2, ((BlockingScreenViewCommand.OpenStreakMilestone) blockingScreenViewCommand).a()));
        } else if (blockingScreenViewCommand instanceof BlockingScreenViewCommand.ShowAutoLockInfoDialogAfterEnabling) {
            Activity activityB = ContextExtKt.b(this.f99097c);
            Intrinsics.checkNotNull(activityB, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            FragmentManager supportFragmentManager2 = ((FragmentActivity) activityB).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "getSupportFragmentManager(...)");
            DisclaimerDialog.C().show(supportFragmentManager2, "DisclaimerDialog");
        } else if (blockingScreenViewCommand instanceof BlockingScreenViewCommand.OpenPremiumFeatureActivity) {
            BlockingScreenViewCommand.OpenPremiumFeatureActivity openPremiumFeatureActivity = (BlockingScreenViewCommand.OpenPremiumFeatureActivity) blockingScreenViewCommand;
            this.f99097c.startActivity(Paywall.c(Paywall.f113165a, this.f99097c, new PaywallTarget.LimitScreen(openPremiumFeatureActivity.b()), "blocking_tab", openPremiumFeatureActivity.a(), false, false, false, null, 240, null));
        } else if (blockingScreenViewCommand instanceof BlockingScreenViewCommand.OpenProfileCreating) {
            this.f99098d.b(ScheduleActivity.Companion.b(ScheduleActivity.f114377m, this.f99097c, null, false, false, 14, null));
        } else if (blockingScreenViewCommand instanceof BlockingScreenViewCommand.OpenProfileWithConditionCreating) {
            BlockingScreenViewCommand.OpenProfileWithConditionCreating openProfileWithConditionCreating = (BlockingScreenViewCommand.OpenProfileWithConditionCreating) blockingScreenViewCommand;
            this.f99098d.b(ScheduleActivity.Companion.b(ScheduleActivity.f114377m, this.f99097c, new ScheduleDescriptor.NewSchedule(null, null, false, false, openProfileWithConditionCreating.a(), openProfileWithConditionCreating.b(), 15, null), false, false, 12, null));
        } else if (blockingScreenViewCommand instanceof BlockingScreenViewCommand.ShowBlockedNotificationsSnackbar) {
            BuildersKt__Builders_commonKt.d(this.f99099f, null, null, new AnonymousClass1(this.f99102i, blockingScreenViewCommand, this.f99097c, null), 3, null);
        } else if (blockingScreenViewCommand instanceof BlockingScreenViewCommand.OpenProfileDuplication) {
            BlockingScreenViewCommand.OpenProfileDuplication openProfileDuplication = (BlockingScreenViewCommand.OpenProfileDuplication) blockingScreenViewCommand;
            this.f99098d.b(ScheduleActivity.Companion.b(ScheduleActivity.f114377m, this.f99097c, new ScheduleDescriptor.ScheduleContainer(openProfileDuplication.b(), openProfileDuplication.a()), false, false, 12, null));
        } else if (blockingScreenViewCommand instanceof BlockingScreenViewCommand.ShowDisclaimerDialog) {
            int i3 = WhenMappings.f99110a[((BlockingScreenViewCommand.ShowDisclaimerDialog) blockingScreenViewCommand).a().ordinal()];
            if (i3 == 1) {
                disclaimerDialogE = DisclaimerDialog.E(ProfileType.LOCATION);
            } else if (i3 == 2) {
                disclaimerDialogE = DisclaimerDialog.E(ProfileType.WIFI);
            } else {
                if (i3 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                disclaimerDialogE = DisclaimerDialog.D();
            }
            AppCompatActivity appCompatActivity = this.f99100g;
            if (appCompatActivity != null && (supportFragmentManager = appCompatActivity.getSupportFragmentManager()) != null) {
                disclaimerDialogE.show(supportFragmentManager, "DisclaimerDialog");
            }
        } else if (blockingScreenViewCommand instanceof BlockingScreenViewCommand.OpenPauseBlockingActivity) {
            BlockingScreenViewCommand.OpenPauseBlockingActivity openPauseBlockingActivity = (BlockingScreenViewCommand.OpenPauseBlockingActivity) blockingScreenViewCommand;
            this.f99101h.b(PauseBlockingActivity.f100101g.a(this.f99097c, openPauseBlockingActivity.b(), openPauseBlockingActivity.a().h(), openPauseBlockingActivity.c()));
        } else if (blockingScreenViewCommand instanceof BlockingScreenViewCommand.OnScheduleTemplateClicked) {
            this.f99098d.b(ScheduleActivity.Companion.b(ScheduleActivity.f114377m, this.f99097c, new ScheduleDescriptor.ScheduleTemplateDescriptor(((BlockingScreenViewCommand.OnScheduleTemplateClicked) blockingScreenViewCommand).a()), false, false, 12, null));
        } else if (blockingScreenViewCommand instanceof BlockingScreenViewCommand.OpenTroubleshootingActivity) {
            Context context3 = this.f99097c;
            context3.startActivity(TroubleshootingStackActivity.f122964g.a(context3, CollectionsKt.emptyList()));
        } else if (blockingScreenViewCommand instanceof BlockingScreenViewCommand.ShowStrictModeSnackbar) {
            BuildersKt__Builders_commonKt.d(this.f99099f, null, null, new AnonymousClass3(this.f99102i, blockingScreenViewCommand, null), 3, null);
        } else if (blockingScreenViewCommand instanceof BlockingScreenViewCommand.OpenPremiumGenericActivity) {
            Context context4 = this.f99097c;
            context4.startActivity(Paywall.c(Paywall.f113165a, context4, PaywallTarget.Generic.INSTANCE, "blocking_tab", "schedule_button", false, false, false, null, 240, null));
        } else {
            if (!(blockingScreenViewCommand instanceof BlockingScreenViewCommand.OpenEmailConsentActivity)) {
                throw new NoWhenBranchMatchedException();
            }
            Context context5 = this.f99097c;
            context5.startActivity(EmailCommunicationConsentActivity.f101711g.a(context5, ((BlockingScreenViewCommand.OpenEmailConsentActivity) blockingScreenViewCommand).a()));
        }
        return Unit.f139807a;
    }
}
