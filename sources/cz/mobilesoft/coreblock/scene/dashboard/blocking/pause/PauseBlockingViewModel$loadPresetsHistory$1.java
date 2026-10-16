package cz.mobilesoft.coreblock.scene.dashboard.blocking.pause;

import cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewState;
import cz.mobilesoft.coreblock.storage.room.dao.core.SchedulePauseHistoryDao;
import cz.mobilesoft.coreblock.storage.room.entity.core.SchedulePauseHistoryEntity;
import cz.mobilesoft.coreblock.storage.room.entity.core.SchedulePauseHistoryEntityKt;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel$loadPresetsHistory$1", f = "PauseBlockingViewModel.kt", l = {127}, m = "invokeSuspend", v = 1)
final class PauseBlockingViewModel$loadPresetsHistory$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f100142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f100143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f100144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ PauseBlockingViewModel f100145d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PauseBlockingViewModel$loadPresetsHistory$1(PauseBlockingViewModel pauseBlockingViewModel, Continuation continuation) {
        super(2, continuation);
        this.f100145d = pauseBlockingViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PauseBlockingViewState q(List list, PauseBlockingViewState pauseBlockingViewState) {
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (hashSet.add(Long.valueOf(SchedulePauseHistoryEntityKt.a((SchedulePauseHistoryEntity) obj)))) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i3 = 0;
        int i4 = 0;
        while (i4 < size) {
            Object obj2 = arrayList.get(i4);
            i4++;
            if (!((SchedulePauseHistoryEntity) obj2).e()) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        int size2 = arrayList2.size();
        while (i3 < size2) {
            Object obj3 = arrayList2.get(i3);
            i3++;
            arrayList3.add(new PauseBlockingViewState.PauseBlockingType.Custom(SchedulePauseHistoryEntityKt.a((SchedulePauseHistoryEntity) obj3)));
        }
        return PauseBlockingViewState.b(pauseBlockingViewState, null, arrayList3, null, list, null, 21, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PauseBlockingViewModel$loadPresetsHistory$1(this.f100145d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        PauseBlockingViewModel$loadPresetsHistory$1 pauseBlockingViewModel$loadPresetsHistory$1;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f100144c;
        if (i3 == 0) {
            ResultKt.b(obj);
            Pair pairO = TimeHelperExt.f128663a.o();
            long jLongValue = ((Number) pairO.a()).longValue();
            long jLongValue2 = ((Number) pairO.b()).longValue();
            SchedulePauseHistoryDao schedulePauseHistoryDaoN1 = this.f100145d.n1();
            this.f100142a = jLongValue;
            this.f100143b = jLongValue2;
            this.f100144c = 1;
            pauseBlockingViewModel$loadPresetsHistory$1 = this;
            obj = schedulePauseHistoryDaoN1.M(jLongValue, jLongValue2, pauseBlockingViewModel$loadPresetsHistory$1);
            if (obj == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            pauseBlockingViewModel$loadPresetsHistory$1 = this;
        }
        if (((List) obj).isEmpty()) {
            obj = null;
        }
        final List list = (List) obj;
        if (list != null) {
            pauseBlockingViewModel$loadPresetsHistory$1.f100145d.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.r0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return PauseBlockingViewModel$loadPresetsHistory$1.q(list, (PauseBlockingViewState) obj2);
                }
            });
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((PauseBlockingViewModel$loadPresetsHistory$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
