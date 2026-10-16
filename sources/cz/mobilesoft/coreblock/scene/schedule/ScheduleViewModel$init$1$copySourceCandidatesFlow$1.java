package cz.mobilesoft.coreblock.scene.schedule;

import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$init$1$copySourceCandidatesFlow$1", f = "ScheduleViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
final class ScheduleViewModel$init$1$copySourceCandidatesFlow$1 extends SuspendLambda implements Function3<List<? extends ProfileWithConfiguration>, Boolean, Continuation<? super List<? extends Pair<? extends Long, ? extends Profile.BlockingMode>>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f114650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f114651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ boolean f114652c;

    ScheduleViewModel$init$1$copySourceCandidatesFlow$1(Continuation continuation) {
        super(3, continuation);
    }

    public final Object h(List list, boolean z2, Continuation continuation) {
        ScheduleViewModel$init$1$copySourceCandidatesFlow$1 scheduleViewModel$init$1$copySourceCandidatesFlow$1 = new ScheduleViewModel$init$1$copySourceCandidatesFlow$1(continuation);
        scheduleViewModel$init$1$copySourceCandidatesFlow$1.f114651b = list;
        scheduleViewModel$init$1$copySourceCandidatesFlow$1.f114652c = z2;
        return scheduleViewModel$init$1$copySourceCandidatesFlow$1.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return h((List) obj, ((Boolean) obj2).booleanValue(), (Continuation) obj3);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        List list = (List) this.f114651b;
        boolean z2 = this.f114652c;
        IntrinsicsKt.f();
        if (this.f114650a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            ProfileWithConfiguration profileWithConfiguration = (ProfileWithConfiguration) obj2;
            if (profileWithConfiguration.b() && (z2 || !profileWithConfiguration.p().R())) {
                arrayList.add(obj2);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj3 = arrayList.get(i3);
            i3++;
            ProfileWithConfiguration profileWithConfiguration2 = (ProfileWithConfiguration) obj3;
            arrayList2.add(TuplesKt.a(Boxing.e(profileWithConfiguration2.p().r()), profileWithConfiguration2.p().o()));
        }
        return arrayList2;
    }
}
