package cz.mobilesoft.coreblock.scene.insights;

import androidx.activity.result.ActivityResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DelayKt;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$onStatisticsPermissionResult$1", f = "InsightsViewModel.kt", l = {552}, m = "invokeSuspend", v = 1)
final class InsightsViewModel$onStatisticsPermissionResult$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f102805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f102806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ActivityResult f102807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ InsightsViewModel f102808d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InsightsViewModel$onStatisticsPermissionResult$1(ActivityResult activityResult, InsightsViewModel insightsViewModel, Continuation continuation) {
        super(1, continuation);
        this.f102807c = activityResult;
        this.f102808d = insightsViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InsightsViewState q(InsightsViewState insightsViewState) {
        return InsightsViewState.d(insightsViewState, null, CollectionsKt.emptyList(), false, null, null, null, null, 0, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0, null, false, false, null, false, false, null, null, null, null, null, null, null, null, null, false, 0L, false, false, false, null, false, false, false, -3, 32767, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new InsightsViewModel$onStatisticsPermissionResult$1(this.f102807c, this.f102808d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f102806b;
        if (i3 == 0) {
            ResultKt.b(obj);
            if (this.f102807c.d() != -1) {
                return Unit.f139807a;
            }
            boolean zIsEmpty = InsightsViewModel.x1(this.f102808d).O().isEmpty();
            int i4 = !zIsEmpty ? 1 : 0;
            if (!zIsEmpty) {
                this.f102808d.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.w7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return InsightsViewModel$onStatisticsPermissionResult$1.q((InsightsViewState) obj2);
                    }
                });
                this.f102805a = i4;
                this.f102806b = 1;
                if (DelayKt.b(1000L, this) == objF) {
                    return objF;
                }
            }
            return Unit.f139807a;
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        this.f102808d.t2();
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((InsightsViewModel$onStatisticsPermissionResult$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
