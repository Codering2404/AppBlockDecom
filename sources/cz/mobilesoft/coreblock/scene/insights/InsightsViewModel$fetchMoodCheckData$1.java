package cz.mobilesoft.coreblock.scene.insights;

import cz.mobilesoft.coreblock.storage.room.dao.core.MoodCheckInEntityDao;
import cz.mobilesoft.coreblock.storage.room.entity.core.MoodCheckInEntity;
import java.time.LocalDate;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$fetchMoodCheckData$1", f = "InsightsViewModel.kt", l = {1129}, m = "invokeSuspend", v = 1)
final class InsightsViewModel$fetchMoodCheckData$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f102732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ InsightsViewModel f102733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ LocalDate f102734c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InsightsViewModel$fetchMoodCheckData$1(InsightsViewModel insightsViewModel, LocalDate localDate, Continuation continuation) {
        super(1, continuation);
        this.f102733b = insightsViewModel;
        this.f102734c = localDate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InsightsViewState q(MoodCheckInEntity moodCheckInEntity, InsightsViewState insightsViewState) {
        return InsightsViewState.d(insightsViewState, null, null, false, null, null, null, null, 0, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0, null, false, false, null, false, false, null, null, null, null, null, null, null, null, null, false, 0L, false, false, false, moodCheckInEntity, false, false, false, -1, 30719, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new InsightsViewModel$fetchMoodCheckData$1(this.f102733b, this.f102734c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f102732a;
        if (i3 == 0) {
            ResultKt.b(obj);
            MoodCheckInEntityDao moodCheckInEntityDaoO2 = this.f102733b.o2();
            LocalDate localDate = this.f102734c;
            Intrinsics.checkNotNull(localDate);
            this.f102732a = 1;
            obj = moodCheckInEntityDaoO2.K(localDate, this);
            if (obj == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        final MoodCheckInEntity moodCheckInEntity = (MoodCheckInEntity) obj;
        this.f102733b.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.m7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return InsightsViewModel$fetchMoodCheckData$1.q(moodCheckInEntity, (InsightsViewState) obj2);
            }
        });
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((InsightsViewModel$fetchMoodCheckData$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
