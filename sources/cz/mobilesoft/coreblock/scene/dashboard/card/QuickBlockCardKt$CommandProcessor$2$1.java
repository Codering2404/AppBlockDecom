package cz.mobilesoft.coreblock.scene.dashboard.card;

import android.app.Activity;
import android.content.Context;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.SnackbarHostState;
import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.MutableState;
import cz.mobilesoft.coreblock.enums.Permission;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockViewCommand;
import cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockViewEvent;
import cz.mobilesoft.coreblock.scene.email_consent.EmailCommunicationConsentActivity;
import cz.mobilesoft.coreblock.scene.permission.PermissionActivity;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroActivity;
import cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectActivity;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleDescriptor;
import cz.mobilesoft.coreblock.util.InterstitialUtils;
import cz.mobilesoft.coreblock.util.constants.AdUnitId;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import cz.mobilesoft.coreblock.util.helperextension.DialogHelper;
import cz.mobilesoft.coreblock.util.permissions.PermissionDTO;
import cz.mobilesoft.coreblock.view.compose.ActivityLauncher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardKt$CommandProcessor$2$1", f = "QuickBlockCard.kt", l = {313}, m = "invokeSuspend", v = 1)
final class QuickBlockCardKt$CommandProcessor$2$1 extends SuspendLambda implements Function2<QuickBlockViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f100422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f100423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ScaffoldState f100424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Context f100425d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ ActivityLauncher f100426f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f100427g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ MutableState f100428h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ MutableLongState f100429i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ MutableState f100430j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ MutableState f100431k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ MutableState f100432l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final /* synthetic */ Function1 f100433m;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardKt$CommandProcessor$2$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardKt$CommandProcessor$2$1$1", f = "QuickBlockCard.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f100434a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ MutableState f100435b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MutableState mutableState, Continuation continuation) {
            super(2, continuation);
            this.f100435b = mutableState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f100435b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f100434a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.f100435b.setValue(Boxing.a(true));
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    QuickBlockCardKt$CommandProcessor$2$1(ScaffoldState scaffoldState, Context context, ActivityLauncher activityLauncher, CoroutineScope coroutineScope, MutableState mutableState, MutableLongState mutableLongState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.f100424c = scaffoldState;
        this.f100425d = context;
        this.f100426f = activityLauncher;
        this.f100427g = coroutineScope;
        this.f100428h = mutableState;
        this.f100429i = mutableLongState;
        this.f100430j = mutableState2;
        this.f100431k = mutableState3;
        this.f100432l = mutableState4;
        this.f100433m = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(Function1 function1, boolean z2) {
        function1.invoke(QuickBlockViewEvent.OnAdClosed.f100561a);
        return Unit.f139807a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        QuickBlockCardKt$CommandProcessor$2$1 quickBlockCardKt$CommandProcessor$2$1 = new QuickBlockCardKt$CommandProcessor$2$1(this.f100424c, this.f100425d, this.f100426f, this.f100427g, this.f100428h, this.f100429i, this.f100430j, this.f100431k, this.f100432l, this.f100433m, continuation);
        quickBlockCardKt$CommandProcessor$2$1.f100423b = obj;
        return quickBlockCardKt$CommandProcessor$2$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        QuickBlockViewCommand quickBlockViewCommand = (QuickBlockViewCommand) this.f100423b;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f100422a;
        if (i3 == 0) {
            ResultKt.b(obj);
            if (quickBlockViewCommand instanceof QuickBlockViewCommand.ShowSnackBar) {
                SnackbarHostState snackbarHostStateB = this.f100424c.b();
                String strA = ((QuickBlockViewCommand.ShowSnackBar) quickBlockViewCommand).a();
                this.f100423b = SpillingKt.a(quickBlockViewCommand);
                this.f100422a = 1;
                if (SnackbarHostState.e(snackbarHostStateB, strA, null, null, this, 6, null) == objF) {
                    return objF;
                }
            } else if (quickBlockViewCommand instanceof QuickBlockViewCommand.ShowNoBlockingLevelSelected) {
                this.f100425d.startActivity(ScheduleActivity.Companion.b(ScheduleActivity.f114377m, this.f100425d, new ScheduleDescriptor.QuickBlock(false, true, false, false, null, null, 61, null), false, false, 12, null));
                Unit unit = Unit.f139807a;
            } else if (quickBlockViewCommand instanceof QuickBlockViewCommand.ShowPermissionsBeforeStart) {
                QuickBlockViewCommand.ShowPermissionsBeforeStart showPermissionsBeforeStart = (QuickBlockViewCommand.ShowPermissionsBeforeStart) quickBlockViewCommand;
                this.f100426f.a().setValue(Boxing.e(showPermissionsBeforeStart.b()));
                PermissionActivity.Companion companion = PermissionActivity.f111772j;
                Context context = this.f100425d;
                List listA = showPermissionsBeforeStart.a();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listA, 10));
                Iterator it = listA.iterator();
                while (it.hasNext()) {
                    arrayList.add(new PermissionDTO((Permission) it.next(), false, false, 6, null));
                }
                this.f100426f.b().b(PermissionActivity.Companion.b(companion, context, arrayList, false, false, false, null, null, 124, null));
                Unit unit2 = Unit.f139807a;
            } else if (quickBlockViewCommand instanceof QuickBlockViewCommand.ShowPremiumFeatureScreen) {
                QuickBlockViewCommand.ShowPremiumFeatureScreen showPremiumFeatureScreen = (QuickBlockViewCommand.ShowPremiumFeatureScreen) quickBlockViewCommand;
                this.f100425d.startActivity(Paywall.c(Paywall.f113165a, this.f100425d, new PaywallTarget.LimitScreen(showPremiumFeatureScreen.b()), "blocking_tab", showPremiumFeatureScreen.a(), false, false, false, null, 240, null));
                Unit unit3 = Unit.f139807a;
            } else if (quickBlockViewCommand instanceof QuickBlockViewCommand.ShowTimeSelectBottomSheet) {
                BuildersKt__Builders_commonKt.d(this.f100427g, null, null, new AnonymousClass1(this.f100432l, null), 3, null);
            } else if (quickBlockViewCommand instanceof QuickBlockViewCommand.TryToShowInterstitialAd) {
                Activity activityB = ContextExtKt.b(this.f100425d);
                Intrinsics.checkNotNull(activityB, "null cannot be cast to non-null type android.app.Activity");
                InterstitialUtils interstitialUtils = InterstitialUtils.f127880h;
                AdUnitId adUnitId = AdUnitId.APP_INTERSTITIAL;
                PremiumState premiumStateA = ((QuickBlockViewCommand.TryToShowInterstitialAd) quickBlockViewCommand).a();
                final Function1 function1 = this.f100433m;
                interstitialUtils.t(activityB, adUnitId, premiumStateA, new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.o1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return QuickBlockCardKt$CommandProcessor$2$1.y(function1, ((Boolean) obj2).booleanValue());
                    }
                });
                Unit unit4 = Unit.f139807a;
            } else if (quickBlockViewCommand instanceof QuickBlockViewCommand.ShowQuickBlockContainsAppBlockError) {
                Activity activityB2 = ContextExtKt.b(this.f100425d);
                Intrinsics.checkNotNull(activityB2, "null cannot be cast to non-null type android.app.Activity");
                DialogHelper.o(activityB2);
                Unit unit5 = Unit.f139807a;
            } else if (quickBlockViewCommand instanceof QuickBlockViewCommand.ShowTimerUpsellDialog) {
                this.f100428h.setValue(Boxing.a(true));
                Unit unit6 = Unit.f139807a;
            } else if (quickBlockViewCommand instanceof QuickBlockViewCommand.ShowStrictModeActiveDialog) {
                this.f100429i.t(((QuickBlockViewCommand.ShowStrictModeActiveDialog) quickBlockViewCommand).a());
                this.f100430j.setValue(Boxing.a(true));
                Unit unit7 = Unit.f139807a;
            } else if (quickBlockViewCommand instanceof QuickBlockViewCommand.GoToPremiumScreen) {
                this.f100425d.startActivity(Paywall.c(Paywall.f113165a, this.f100425d, new PaywallTarget.LimitScreen(PremiumFeature.QUICK_BLOCK_TIMER), "blocking_tab", "qb_timer", false, false, false, null, 240, null));
                Unit unit8 = Unit.f139807a;
            } else if (quickBlockViewCommand instanceof QuickBlockViewCommand.ShowTimeSelectScreen) {
                this.f100425d.startActivity(QuickBlockTimeSelectActivity.Companion.b(QuickBlockTimeSelectActivity.f114243g, this.f100425d, ((QuickBlockViewCommand.ShowTimeSelectScreen) quickBlockViewCommand).a(), false, 4, null));
                Unit unit9 = Unit.f139807a;
            } else if (Intrinsics.areEqual(quickBlockViewCommand, QuickBlockViewCommand.ShowPomodoroScreen.f100550a)) {
                this.f100425d.startActivity(PomodoroActivity.Companion.b(PomodoroActivity.f114048f, this.f100425d, false, 2, null));
                Unit unit10 = Unit.f139807a;
            } else if (Intrinsics.areEqual(quickBlockViewCommand, QuickBlockViewCommand.ShowStopDialog.f100555a)) {
                this.f100431k.setValue(Boxing.a(true));
                Unit unit11 = Unit.f139807a;
            } else {
                if (!(quickBlockViewCommand instanceof QuickBlockViewCommand.OpenEmailConsentActivity)) {
                    throw new NoWhenBranchMatchedException();
                }
                Context context2 = this.f100425d;
                context2.startActivity(EmailCommunicationConsentActivity.f101711g.a(context2, ((QuickBlockViewCommand.OpenEmailConsentActivity) quickBlockViewCommand).a()));
                Unit unit12 = Unit.f139807a;
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
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public final Object invoke(QuickBlockViewCommand quickBlockViewCommand, Continuation continuation) {
        return ((QuickBlockCardKt$CommandProcessor$2$1) create(quickBlockViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }
}
