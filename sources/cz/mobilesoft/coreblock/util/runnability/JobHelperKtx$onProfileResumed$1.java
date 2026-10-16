package cz.mobilesoft.coreblock.util.runnability;

import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.runnability.JobHelperKtx$onProfileResumed$1", f = "JobHelperKtx.kt", l = {107}, m = "invokeSuspend", v = 1)
final class JobHelperKtx$onProfileResumed$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f129593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ JobHelperKtx f129594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Profile f129595c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    JobHelperKtx$onProfileResumed$1(JobHelperKtx jobHelperKtx, Profile profile, Continuation continuation) {
        super(1, continuation);
        this.f129594b = jobHelperKtx;
        this.f129595c = profile;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new JobHelperKtx$onProfileResumed$1(this.f129594b, this.f129595c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f129593a;
        if (i3 == 0) {
            ResultKt.b(obj);
            EventDataStore eventDataStore = this.f129594b.f129556c;
            long jF = TimeHelperExt.f128663a.f();
            List listListOf = CollectionsKt.listOf(Boxing.e(this.f129595c.r()));
            this.f129593a = 1;
            if (eventDataStore.n2(jF, listListOf, this) == objF) {
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
        return ((JobHelperKtx$onProfileResumed$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
