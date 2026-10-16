package cz.mobilesoft.coreblock.scene.more.settings.statistics;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.SnackbarHostState;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsViewCommand;
import cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsViewEvent;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import cz.mobilesoft.coreblock.util.helperextension.DialogHelper;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsScreenKt$CommandProcessor$1$1", f = "StatisticsSettingsScreen.kt", l = {}, m = "invokeSuspend", v = 1)
final class StatisticsSettingsScreenKt$CommandProcessor$1$1 extends SuspendLambda implements Function2<StatisticsSettingsViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f110183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f110184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f110185c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Context f110186d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ ScaffoldState f110187f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Function1 f110188g;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsScreenKt$CommandProcessor$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsScreenKt$CommandProcessor$1$1$1", f = "StatisticsSettingsScreen.kt", l = {217}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f110189a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ScaffoldState f110190b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ StatisticsSettingsViewCommand f110191c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ScaffoldState scaffoldState, StatisticsSettingsViewCommand statisticsSettingsViewCommand, Continuation continuation) {
            super(2, continuation);
            this.f110190b = scaffoldState;
            this.f110191c = statisticsSettingsViewCommand;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f110190b, this.f110191c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f110189a;
            if (i3 == 0) {
                ResultKt.b(obj);
                SnackbarHostState snackbarHostStateB = this.f110190b.b();
                String strA = ((StatisticsSettingsViewCommand.ShowSnackBar) this.f110191c).a();
                this.f110189a = 1;
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
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StatisticsSettingsScreenKt$CommandProcessor$1$1(CoroutineScope coroutineScope, Context context, ScaffoldState scaffoldState, Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.f110185c = coroutineScope;
        this.f110186d = context;
        this.f110187f = scaffoldState;
        this.f110188g = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        StatisticsSettingsScreenKt$CommandProcessor$1$1 statisticsSettingsScreenKt$CommandProcessor$1$1 = new StatisticsSettingsScreenKt$CommandProcessor$1$1(this.f110185c, this.f110186d, this.f110187f, this.f110188g, continuation);
        statisticsSettingsScreenKt$CommandProcessor$1$1.f110184b = obj;
        return statisticsSettingsScreenKt$CommandProcessor$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(StatisticsSettingsViewCommand statisticsSettingsViewCommand, Continuation continuation) {
        return ((StatisticsSettingsScreenKt$CommandProcessor$1$1) create(statisticsSettingsViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        StatisticsSettingsViewCommand statisticsSettingsViewCommand = (StatisticsSettingsViewCommand) this.f110184b;
        IntrinsicsKt.f();
        if (this.f110183a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (statisticsSettingsViewCommand instanceof StatisticsSettingsViewCommand.ShowSnackBar) {
            BuildersKt__Builders_commonKt.d(this.f110185c, null, null, new AnonymousClass1(this.f110187f, statisticsSettingsViewCommand, null), 3, null);
        } else {
            if (!Intrinsics.areEqual(statisticsSettingsViewCommand, StatisticsSettingsViewCommand.ShowDisableStatisticsDialog.f110197a)) {
                throw new NoWhenBranchMatchedException();
            }
            final Activity activityB = ContextExtKt.b(this.f110186d);
            if (activityB != null) {
                final Function1 function1 = this.f110188g;
                DialogHelper.k(activityB, activityB.getString(R.string.hA), new DialogHelper.OnDialogClosedListener() { // from class: cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsScreenKt$CommandProcessor$1$1$2$1
                    @Override // cz.mobilesoft.coreblock.util.helperextension.DialogHelper.OnDialogClosedListener
                    public void a() {
                        AnswersHelper.f128199a.S6(true, "ALL");
                        Activity activity = activityB;
                        Intent intent = new Intent();
                        intent.putExtra("STATS_DISABLED", true);
                        Unit unit = Unit.f139807a;
                        activity.setResult(-1, intent);
                        function1.invoke(StatisticsSettingsViewEvent.OnStatisticsDisabledClick.f110201a);
                    }

                    @Override // cz.mobilesoft.coreblock.util.helperextension.DialogHelper.OnDialogClosedListener
                    public void b() {
                    }
                });
            }
        }
        return Unit.f139807a;
    }
}
