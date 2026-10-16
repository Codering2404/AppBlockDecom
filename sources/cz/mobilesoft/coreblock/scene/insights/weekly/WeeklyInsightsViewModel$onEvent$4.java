package cz.mobilesoft.coreblock.scene.insights.weekly;

import cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel$onEvent$4", f = "WeeklyInsightsViewModel.kt", l = {204}, m = "invokeSuspend", v = 1)
final class WeeklyInsightsViewModel$onEvent$4 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f103955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f103956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f103957c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f103958d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ WeeklyInsightsViewModel f103959f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ WeeklyInsightsViewEvent f103960g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WeeklyInsightsViewModel$onEvent$4(WeeklyInsightsViewModel weeklyInsightsViewModel, WeeklyInsightsViewEvent weeklyInsightsViewEvent, Continuation continuation) {
        super(1, continuation);
        this.f103959f = weeklyInsightsViewModel;
        this.f103960g = weeklyInsightsViewEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WeeklyInsightsViewState q(String str, WeeklyInsightsViewState weeklyInsightsViewState) {
        return WeeklyInsightsViewState.b(weeklyInsightsViewState, false, null, null, false, null, null, null, null, null, null, null, null, false, null, str, false, null, null, false, false, false, false, false, 8372223, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new WeeklyInsightsViewModel$onEvent$4(this.f103959f, this.f103960g, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f103958d;
        if (i3 == 0) {
            ResultKt.b(obj);
            WeeklyInsightsViewState weeklyInsightsViewStateV1 = WeeklyInsightsViewModel.v1(this.f103959f);
            WeeklyInsightsViewEvent weeklyInsightsViewEvent = this.f103960g;
            WeeklyInsightsViewModel weeklyInsightsViewModel = this.f103959f;
            final String strA = ((WeeklyInsightsViewEvent.OnAppSelected) weeklyInsightsViewEvent).a();
            weeklyInsightsViewModel.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.g3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return WeeklyInsightsViewModel$onEvent$4.q(strA, (WeeklyInsightsViewState) obj2);
                }
            });
            this.f103955a = SpillingKt.a(weeklyInsightsViewStateV1);
            this.f103956b = SpillingKt.a(strA);
            this.f103957c = 0;
            this.f103958d = 1;
            if (weeklyInsightsViewModel.j1(strA, this) == objF) {
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

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((WeeklyInsightsViewModel$onEvent$4) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
