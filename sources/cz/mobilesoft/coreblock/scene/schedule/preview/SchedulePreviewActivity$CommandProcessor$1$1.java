package cz.mobilesoft.coreblock.scene.schedule.preview;

import android.content.Context;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.SnackbarDuration;
import androidx.compose.material.SnackbarHostState;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingActivity;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleDescriptor;
import cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewCommand;
import cz.mobilesoft.coreblock.storage.datastore.entity.ProfileDisabledSuggestStrictModeState;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewActivity$CommandProcessor$1$1", f = "SchedulePreviewActivity.kt", l = {}, m = "invokeSuspend", v = 1)
final class SchedulePreviewActivity$CommandProcessor$1$1 extends SuspendLambda implements Function2<SchedulePreviewViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f117353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f117354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ManagedActivityResultLauncher f117355c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Context f117356d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function0 f117357f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f117358g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ SchedulePreviewActivity f117359h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ ScaffoldState f117360i;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewActivity$CommandProcessor$1$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewActivity$CommandProcessor$1$1$2", f = "SchedulePreviewActivity.kt", l = {197}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f117361a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ScaffoldState f117362b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ SchedulePreviewViewCommand f117363c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ScaffoldState scaffoldState, SchedulePreviewViewCommand schedulePreviewViewCommand, Continuation continuation) {
            super(2, continuation);
            this.f117362b = scaffoldState;
            this.f117363c = schedulePreviewViewCommand;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.f117362b, this.f117363c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f117361a;
            if (i3 == 0) {
                ResultKt.b(obj);
                SnackbarHostState snackbarHostStateB = this.f117362b.b();
                String strA = ((SchedulePreviewViewCommand.ShowSnackBar) this.f117363c).a();
                SnackbarDuration snackbarDuration = SnackbarDuration.Short;
                this.f117361a = 1;
                if (SnackbarHostState.e(snackbarHostStateB, strA, null, snackbarDuration, this, 2, null) == objF) {
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
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SchedulePreviewActivity$CommandProcessor$1$1(ManagedActivityResultLauncher managedActivityResultLauncher, Context context, Function0 function0, CoroutineScope coroutineScope, SchedulePreviewActivity schedulePreviewActivity, ScaffoldState scaffoldState, Continuation continuation) {
        super(2, continuation);
        this.f117355c = managedActivityResultLauncher;
        this.f117356d = context;
        this.f117357f = function0;
        this.f117358g = coroutineScope;
        this.f117359h = schedulePreviewActivity;
        this.f117360i = scaffoldState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        SchedulePreviewActivity$CommandProcessor$1$1 schedulePreviewActivity$CommandProcessor$1$1 = new SchedulePreviewActivity$CommandProcessor$1$1(this.f117355c, this.f117356d, this.f117357f, this.f117358g, this.f117359h, this.f117360i, continuation);
        schedulePreviewActivity$CommandProcessor$1$1.f117354b = obj;
        return schedulePreviewActivity$CommandProcessor$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(SchedulePreviewViewCommand schedulePreviewViewCommand, Continuation continuation) {
        return ((SchedulePreviewActivity$CommandProcessor$1$1) create(schedulePreviewViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        SchedulePreviewViewCommand schedulePreviewViewCommand = (SchedulePreviewViewCommand) this.f117354b;
        IntrinsicsKt.f();
        if (this.f117353a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (schedulePreviewViewCommand instanceof SchedulePreviewViewCommand.OnEditScheduleClicked) {
            Profile profileA = ((SchedulePreviewViewCommand.OnEditScheduleClicked) schedulePreviewViewCommand).a();
            if (profileA != null) {
                Context context = this.f117356d;
                Function0 function0 = this.f117357f;
                context.startActivity(ScheduleActivity.Companion.b(ScheduleActivity.f114377m, context, new ScheduleDescriptor.ScheduleId(profileA.r(), profileA.G()), false, false, 12, null));
                function0.invoke();
            }
        } else if (schedulePreviewViewCommand instanceof SchedulePreviewViewCommand.OpenPauseBlockingActivity) {
            ManagedActivityResultLauncher managedActivityResultLauncher = this.f117355c;
            PauseBlockingActivity.Companion companion = PauseBlockingActivity.f100101g;
            SchedulePreviewViewCommand.OpenPauseBlockingActivity openPauseBlockingActivity = (SchedulePreviewViewCommand.OpenPauseBlockingActivity) schedulePreviewViewCommand;
            long jB = openPauseBlockingActivity.b();
            ProfileDisabledSuggestStrictModeState profileDisabledSuggestStrictModeStateC = openPauseBlockingActivity.c();
            managedActivityResultLauncher.b(companion.a(this.f117356d, jB, openPauseBlockingActivity.a().h(), profileDisabledSuggestStrictModeStateC));
        } else if (schedulePreviewViewCommand instanceof SchedulePreviewViewCommand.OpenPremiumFeatureActivity) {
            SchedulePreviewViewCommand.OpenPremiumFeatureActivity openPremiumFeatureActivity = (SchedulePreviewViewCommand.OpenPremiumFeatureActivity) schedulePreviewViewCommand;
            this.f117356d.startActivity(Paywall.c(Paywall.f113165a, this.f117356d, new PaywallTarget.LimitScreen(openPremiumFeatureActivity.b()), "blocking_tab", openPremiumFeatureActivity.a(), false, false, false, null, 240, null));
        } else if (schedulePreviewViewCommand instanceof SchedulePreviewViewCommand.OpenProfileDuplication) {
            Context context2 = this.f117356d;
            SchedulePreviewViewCommand.OpenProfileDuplication openProfileDuplication = (SchedulePreviewViewCommand.OpenProfileDuplication) schedulePreviewViewCommand;
            context2.startActivity(ScheduleActivity.Companion.b(ScheduleActivity.f114377m, context2, new ScheduleDescriptor.ScheduleContainer(openProfileDuplication.b(), openProfileDuplication.a()), false, false, 12, null));
        } else if (Intrinsics.areEqual(schedulePreviewViewCommand, SchedulePreviewViewCommand.OnCloseClicked.f117385a)) {
            this.f117357f.invoke();
        } else if (schedulePreviewViewCommand instanceof SchedulePreviewViewCommand.ShowSnackBar) {
            BuildersKt__Builders_commonKt.d(this.f117358g, null, null, new AnonymousClass2(this.f117360i, schedulePreviewViewCommand, null), 3, null);
        } else {
            if (!(schedulePreviewViewCommand instanceof SchedulePreviewViewCommand.OpenPremiumGenericActivity)) {
                throw new NoWhenBranchMatchedException();
            }
            this.f117359h.startActivity(Paywall.c(Paywall.f113165a, this.f117356d, PaywallTarget.Generic.INSTANCE, "schedule_inactive_preview", "schedule_inactive_preview_premium_button", false, false, false, null, 240, null));
        }
        return Unit.f139807a;
    }
}
