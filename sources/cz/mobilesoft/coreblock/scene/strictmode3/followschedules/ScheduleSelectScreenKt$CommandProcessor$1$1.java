package cz.mobilesoft.coreblock.scene.strictmode3.followschedules;

import android.content.Context;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.SnackbarDuration;
import androidx.compose.material.SnackbarHostState;
import androidx.compose.runtime.MutableState;
import cz.mobilesoft.coreblock.enums.StrictModeTitleAlternatives;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleDescriptor;
import cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleSelectViewCommand;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleSelectScreenKt$CommandProcessor$1$1", f = "ScheduleSelectScreen.kt", l = {}, m = "invokeSuspend", v = 1)
final class ScheduleSelectScreenKt$CommandProcessor$1$1 extends SuspendLambda implements Function2<ScheduleSelectViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f122025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f122026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function2 f122027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Context f122028d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MutableState f122029f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ MutableState f122030g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f122031h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ ScaffoldState f122032i;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleSelectScreenKt$CommandProcessor$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleSelectScreenKt$CommandProcessor$1$1$1", f = "ScheduleSelectScreen.kt", l = {142}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f122033a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ScaffoldState f122034b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f122035c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ScaffoldState scaffoldState, Context context, Continuation continuation) {
            super(2, continuation);
            this.f122034b = scaffoldState;
            this.f122035c = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f122034b, this.f122035c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f122033a;
            if (i3 == 0) {
                ResultKt.b(obj);
                SnackbarHostState snackbarHostStateB = this.f122034b.b();
                String string = this.f122035c.getString(StrictModeTitleAlternatives.Companion.a());
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                SnackbarDuration snackbarDuration = SnackbarDuration.Short;
                this.f122033a = 1;
                if (SnackbarHostState.e(snackbarHostStateB, string, null, snackbarDuration, this, 2, null) == objF) {
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
    ScheduleSelectScreenKt$CommandProcessor$1$1(Function2 function2, Context context, MutableState mutableState, MutableState mutableState2, CoroutineScope coroutineScope, ScaffoldState scaffoldState, Continuation continuation) {
        super(2, continuation);
        this.f122027c = function2;
        this.f122028d = context;
        this.f122029f = mutableState;
        this.f122030g = mutableState2;
        this.f122031h = coroutineScope;
        this.f122032i = scaffoldState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ScheduleSelectScreenKt$CommandProcessor$1$1 scheduleSelectScreenKt$CommandProcessor$1$1 = new ScheduleSelectScreenKt$CommandProcessor$1$1(this.f122027c, this.f122028d, this.f122029f, this.f122030g, this.f122031h, this.f122032i, continuation);
        scheduleSelectScreenKt$CommandProcessor$1$1.f122026b = obj;
        return scheduleSelectScreenKt$CommandProcessor$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ScheduleSelectViewCommand scheduleSelectViewCommand, Continuation continuation) {
        return ((ScheduleSelectScreenKt$CommandProcessor$1$1) create(scheduleSelectViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ScheduleSelectViewCommand scheduleSelectViewCommand = (ScheduleSelectViewCommand) this.f122026b;
        IntrinsicsKt.f();
        if (this.f122025a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (scheduleSelectViewCommand instanceof ScheduleSelectViewCommand.OnSaveClicked) {
            ScheduleSelectViewCommand.OnSaveClicked onSaveClicked = (ScheduleSelectViewCommand.OnSaveClicked) scheduleSelectViewCommand;
            this.f122027c.invoke(onSaveClicked.b(), onSaveClicked.a());
        } else if (Intrinsics.areEqual(scheduleSelectViewCommand, ScheduleSelectViewCommand.OnCreateNewScheduleClicked.f122051a)) {
            Context context = this.f122028d;
            context.startActivity(ScheduleActivity.Companion.b(ScheduleActivity.f114377m, context, new ScheduleDescriptor.NewSchedule(null, null, true, false, null, null, 59, null), false, false, 12, null));
        } else if (scheduleSelectViewCommand instanceof ScheduleSelectViewCommand.ShowInfoDialog) {
            ScheduleSelectViewCommand.ShowInfoDialog showInfoDialog = (ScheduleSelectViewCommand.ShowInfoDialog) scheduleSelectViewCommand;
            this.f122029f.setValue(TuplesKt.a(showInfoDialog.b(), showInfoDialog.a()));
            this.f122030g.setValue(Boxing.a(true));
        } else {
            if (!Intrinsics.areEqual(scheduleSelectViewCommand, ScheduleSelectViewCommand.OnStrictModeActive.f122054a)) {
                throw new NoWhenBranchMatchedException();
            }
            BuildersKt__Builders_commonKt.d(this.f122031h, null, null, new AnonymousClass1(this.f122032i, this.f122028d, null), 3, null);
        }
        return Unit.f139807a;
    }
}
