package cz.mobilesoft.coreblock.scene.insights.weekly;

import android.content.Context;
import androidx.compose.material3.SnackbarDuration;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.MutableState;
import cz.mobilesoft.coreblock.enums.StrictModeTitleAlternatives;
import cz.mobilesoft.coreblock.scene.insights.InsightsViewCommand;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsActivity$CommandProcessor$2$1", f = "WeeklyInsightsActivity.kt", l = {}, m = "invokeSuspend", v = 1)
final class WeeklyInsightsActivity$CommandProcessor$2$1 extends SuspendLambda implements Function2<InsightsViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f103887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f103888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ MutableState f103889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ MutableState f103890d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MutableState f103891f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Context f103892g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f103893h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ Function1 f103894i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ Function0 f103895j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ SnackbarHostState f103896k;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsActivity$CommandProcessor$2$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsActivity$CommandProcessor$2$1$1", f = "WeeklyInsightsActivity.kt", l = {176}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f103897a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SnackbarHostState f103898b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f103899c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SnackbarHostState snackbarHostState, String str, Continuation continuation) {
            super(2, continuation);
            this.f103898b = snackbarHostState;
            this.f103899c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f103898b, this.f103899c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f103897a;
            if (i3 == 0) {
                ResultKt.b(obj);
                SnackbarHostState snackbarHostState = this.f103898b;
                String str = this.f103899c;
                this.f103897a = 1;
                if (SnackbarHostState.f(snackbarHostState, str, null, false, null, this, 14, null) == objF) {
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
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsActivity$CommandProcessor$2$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsActivity$CommandProcessor$2$1$2", f = "WeeklyInsightsActivity.kt", l = {202}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f103900a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SnackbarHostState f103901b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ InsightsViewCommand f103902c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(SnackbarHostState snackbarHostState, InsightsViewCommand insightsViewCommand, Continuation continuation) {
            super(2, continuation);
            this.f103901b = snackbarHostState;
            this.f103902c = insightsViewCommand;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.f103901b, this.f103902c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f103900a;
            if (i3 == 0) {
                ResultKt.b(obj);
                SnackbarHostState snackbarHostState = this.f103901b;
                String strA = ((InsightsViewCommand.ShowSnackBar) this.f103902c).a();
                SnackbarDuration snackbarDuration = SnackbarDuration.Short;
                this.f103900a = 1;
                if (SnackbarHostState.f(snackbarHostState, strA, null, false, snackbarDuration, this, 6, null) == objF) {
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
    WeeklyInsightsActivity$CommandProcessor$2$1(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, Context context, CoroutineScope coroutineScope, Function1 function1, Function0 function0, SnackbarHostState snackbarHostState, Continuation continuation) {
        super(2, continuation);
        this.f103889c = mutableState;
        this.f103890d = mutableState2;
        this.f103891f = mutableState3;
        this.f103892g = context;
        this.f103893h = coroutineScope;
        this.f103894i = function1;
        this.f103895j = function0;
        this.f103896k = snackbarHostState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        WeeklyInsightsActivity$CommandProcessor$2$1 weeklyInsightsActivity$CommandProcessor$2$1 = new WeeklyInsightsActivity$CommandProcessor$2$1(this.f103889c, this.f103890d, this.f103891f, this.f103892g, this.f103893h, this.f103894i, this.f103895j, this.f103896k, continuation);
        weeklyInsightsActivity$CommandProcessor$2$1.f103888b = obj;
        return weeklyInsightsActivity$CommandProcessor$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(InsightsViewCommand insightsViewCommand, Continuation continuation) {
        return ((WeeklyInsightsActivity$CommandProcessor$2$1) create(insightsViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        InsightsViewCommand insightsViewCommand = (InsightsViewCommand) this.f103888b;
        IntrinsicsKt.f();
        if (this.f103887a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (Intrinsics.areEqual(insightsViewCommand, InsightsViewCommand.DismissBottomSheet.f102661a)) {
            this.f103889c.setValue(Boxing.a(false));
        } else if (Intrinsics.areEqual(insightsViewCommand, InsightsViewCommand.ShowAppBlockWarningDialog.f102664a)) {
            this.f103890d.setValue(Boxing.a(true));
        } else if (Intrinsics.areEqual(insightsViewCommand, InsightsViewCommand.ShowExcludedAppsBottomSheet.f102665a)) {
            this.f103891f.setValue(Boxing.a(true));
        } else if (Intrinsics.areEqual(insightsViewCommand, InsightsViewCommand.ShowStrictModeActive.f102670a)) {
            String string = this.f103892g.getString(StrictModeTitleAlternatives.Companion.a());
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            BuildersKt__Builders_commonKt.d(this.f103893h, null, null, new AnonymousClass1(this.f103896k, string, null), 3, null);
        } else if (insightsViewCommand instanceof InsightsViewCommand.CreateNewSchedule) {
            this.f103894i.invoke(((InsightsViewCommand.CreateNewSchedule) insightsViewCommand).a());
        } else if (Intrinsics.areEqual(insightsViewCommand, InsightsViewCommand.ShowExcludedPremiumCard.f102666a)) {
            this.f103895j.invoke();
        } else if (insightsViewCommand instanceof InsightsViewCommand.ShowPremiumScreen) {
            Context context = this.f103892g;
            context.startActivity(Paywall.c(Paywall.f113165a, context, new PaywallTarget.LimitScreen(((InsightsViewCommand.ShowPremiumScreen) insightsViewCommand).a()), "weekly_insights", "no_of_schedules_limit", false, false, false, null, 240, null));
        } else if (!Intrinsics.areEqual(insightsViewCommand, InsightsViewCommand.OpenAppFeel.f102662a) && !Intrinsics.areEqual(insightsViewCommand, InsightsViewCommand.ScrollToMoodCheckIn.f102663a) && !Intrinsics.areEqual(insightsViewCommand, InsightsViewCommand.ShowMoodCheckInDisableDialog.f102667a)) {
            if (!(insightsViewCommand instanceof InsightsViewCommand.ShowSnackBar)) {
                throw new NoWhenBranchMatchedException();
            }
            BuildersKt__Builders_commonKt.d(this.f103893h, null, null, new AnonymousClass2(this.f103896k, insightsViewCommand, null), 3, null);
        }
        return Unit.f139807a;
    }
}
