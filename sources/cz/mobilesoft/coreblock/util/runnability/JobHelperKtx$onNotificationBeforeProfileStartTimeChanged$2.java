package cz.mobilesoft.coreblock.util.runnability;

import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.runnability.JobHelperKtx$onNotificationBeforeProfileStartTimeChanged$2", f = "JobHelperKtx.kt", l = {90}, m = "invokeSuspend", v = 1)
final class JobHelperKtx$onNotificationBeforeProfileStartTimeChanged$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f129590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ JobHelperKtx f129591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f129592c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    JobHelperKtx$onNotificationBeforeProfileStartTimeChanged$2(JobHelperKtx jobHelperKtx, List list, Continuation continuation) {
        super(1, continuation);
        this.f129591b = jobHelperKtx;
        this.f129592c = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new JobHelperKtx$onNotificationBeforeProfileStartTimeChanged$2(this.f129591b, this.f129592c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f129590a;
        if (i3 == 0) {
            ResultKt.b(obj);
            EventDataStore eventDataStore = this.f129591b.f129556c;
            long jF = TimeHelperExt.f128663a.f();
            List list = this.f129592c;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Boxing.e(((Interval) it.next()).e()));
            }
            this.f129590a = 1;
            if (eventDataStore.b2(jF, arrayList, this) == objF) {
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
        return ((JobHelperKtx$onNotificationBeforeProfileStartTimeChanged$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
