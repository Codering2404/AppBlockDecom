package cz.mobilesoft.coreblock.scene.insights;

import android.content.Context;
import androidx.compose.material3.SnackbarDuration;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.MutableState;
import cz.mobilesoft.coreblock.enums.StrictModeTitleAlternatives;
import cz.mobilesoft.coreblock.scene.app_feel.AppFeelActivity;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.InsightsScreenKt$CommandProcessor$2$1", f = "InsightsScreen.kt", l = {}, m = "invokeSuspend", v = 1)
final class InsightsScreenKt$CommandProcessor$2$1 extends SuspendLambda implements Function2<InsightsViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f102634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f102635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ MutableState f102636c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ MutableState f102637d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MutableState f102638f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Context f102639g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f102640h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ Function1 f102641i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ Function0 f102642j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ MutableState f102643k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ MutableState f102644l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final /* synthetic */ SnackbarHostState f102645m;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.insights.InsightsScreenKt$CommandProcessor$2$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.InsightsScreenKt$CommandProcessor$2$1$1", f = "InsightsScreen.kt", l = {159}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f102646a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SnackbarHostState f102647b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f102648c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SnackbarHostState snackbarHostState, String str, Continuation continuation) {
            super(2, continuation);
            this.f102647b = snackbarHostState;
            this.f102648c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f102647b, this.f102648c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f102646a;
            if (i3 == 0) {
                ResultKt.b(obj);
                SnackbarHostState snackbarHostState = this.f102647b;
                String str = this.f102648c;
                this.f102646a = 1;
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

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.insights.InsightsScreenKt$CommandProcessor$2$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.InsightsScreenKt$CommandProcessor$2$1$2", f = "InsightsScreen.kt", l = {191}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f102649a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SnackbarHostState f102650b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ InsightsViewCommand f102651c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(SnackbarHostState snackbarHostState, InsightsViewCommand insightsViewCommand, Continuation continuation) {
            super(2, continuation);
            this.f102650b = snackbarHostState;
            this.f102651c = insightsViewCommand;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.f102650b, this.f102651c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f102649a;
            if (i3 == 0) {
                ResultKt.b(obj);
                SnackbarHostState snackbarHostState = this.f102650b;
                String strA = ((InsightsViewCommand.ShowSnackBar) this.f102651c).a();
                SnackbarDuration snackbarDuration = SnackbarDuration.Short;
                this.f102649a = 1;
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
    InsightsScreenKt$CommandProcessor$2$1(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, Context context, CoroutineScope coroutineScope, Function1 function1, Function0 function0, MutableState mutableState4, MutableState mutableState5, SnackbarHostState snackbarHostState, Continuation continuation) {
        super(2, continuation);
        this.f102636c = mutableState;
        this.f102637d = mutableState2;
        this.f102638f = mutableState3;
        this.f102639g = context;
        this.f102640h = coroutineScope;
        this.f102641i = function1;
        this.f102642j = function0;
        this.f102643k = mutableState4;
        this.f102644l = mutableState5;
        this.f102645m = snackbarHostState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        InsightsScreenKt$CommandProcessor$2$1 insightsScreenKt$CommandProcessor$2$1 = new InsightsScreenKt$CommandProcessor$2$1(this.f102636c, this.f102637d, this.f102638f, this.f102639g, this.f102640h, this.f102641i, this.f102642j, this.f102643k, this.f102644l, this.f102645m, continuation);
        insightsScreenKt$CommandProcessor$2$1.f102635b = obj;
        return insightsScreenKt$CommandProcessor$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(InsightsViewCommand insightsViewCommand, Continuation continuation) {
        return ((InsightsScreenKt$CommandProcessor$2$1) create(insightsViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        InsightsViewCommand insightsViewCommand = (InsightsViewCommand) this.f102635b;
        IntrinsicsKt.f();
        if (this.f102634a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (Intrinsics.areEqual(insightsViewCommand, InsightsViewCommand.DismissBottomSheet.f102661a)) {
            this.f102636c.setValue(Boxing.a(false));
        } else if (Intrinsics.areEqual(insightsViewCommand, InsightsViewCommand.ShowAppBlockWarningDialog.f102664a)) {
            this.f102637d.setValue(Boxing.a(true));
        } else if (Intrinsics.areEqual(insightsViewCommand, InsightsViewCommand.ShowExcludedAppsBottomSheet.f102665a)) {
            this.f102638f.setValue(Boxing.a(true));
        } else if (Intrinsics.areEqual(insightsViewCommand, InsightsViewCommand.ShowStrictModeActive.f102670a)) {
            String string = this.f102639g.getString(StrictModeTitleAlternatives.Companion.a());
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            BuildersKt__Builders_commonKt.d(this.f102640h, null, null, new AnonymousClass1(this.f102645m, string, null), 3, null);
        } else if (insightsViewCommand instanceof InsightsViewCommand.CreateNewSchedule) {
            this.f102641i.invoke(((InsightsViewCommand.CreateNewSchedule) insightsViewCommand).a());
        } else if (Intrinsics.areEqual(insightsViewCommand, InsightsViewCommand.ShowExcludedPremiumCard.f102666a)) {
            this.f102642j.invoke();
        } else if (Intrinsics.areEqual(insightsViewCommand, InsightsViewCommand.OpenAppFeel.f102662a)) {
            Context context = this.f102639g;
            context.startActivity(AppFeelActivity.f98567f.a(context, true));
        } else if (Intrinsics.areEqual(insightsViewCommand, InsightsViewCommand.ScrollToMoodCheckIn.f102663a)) {
            this.f102643k.setValue(Boxing.a(true));
        } else if (Intrinsics.areEqual(insightsViewCommand, InsightsViewCommand.ShowMoodCheckInDisableDialog.f102667a)) {
            this.f102644l.setValue(Boxing.a(true));
        } else if (insightsViewCommand instanceof InsightsViewCommand.ShowPremiumScreen) {
            Context context2 = this.f102639g;
            context2.startActivity(Paywall.c(Paywall.f113165a, context2, new PaywallTarget.LimitScreen(((InsightsViewCommand.ShowPremiumScreen) insightsViewCommand).a()), "insights_detail", "no_of_schedules_limit", false, false, false, null, 240, null));
        } else {
            if (!(insightsViewCommand instanceof InsightsViewCommand.ShowSnackBar)) {
                throw new NoWhenBranchMatchedException();
            }
            BuildersKt__Builders_commonKt.d(this.f102640h, null, null, new AnonymousClass2(this.f102645m, insightsViewCommand, null), 3, null);
        }
        return Unit.f139807a;
    }
}
