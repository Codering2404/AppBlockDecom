package cz.mobilesoft.coreblock.util;

import cz.mobilesoft.coreblock.storage.room.dao.blocking.AdultContentWebsiteDao;
import cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.AdultContentDownloadWorker$saveWithProgressAnimation$2", f = "AdultContentDownloadWorker.kt", l = {204}, m = "invokeSuspend", v = 1)
final class AdultContentDownloadWorker$saveWithProgressAnimation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f127754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f127755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private /* synthetic */ Object f127756c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ AdultContentDownloadWorker f127757d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ List f127758f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ List f127759g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ List f127760h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AdultContentDownloadWorker$saveWithProgressAnimation$2(AdultContentDownloadWorker adultContentDownloadWorker, List list, List list2, List list3, Continuation continuation) {
        super(2, continuation);
        this.f127757d = adultContentDownloadWorker;
        this.f127758f = list;
        this.f127759g = list2;
        this.f127760h = list3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        AdultContentDownloadWorker$saveWithProgressAnimation$2 adultContentDownloadWorker$saveWithProgressAnimation$2 = new AdultContentDownloadWorker$saveWithProgressAnimation$2(this.f127757d, this.f127758f, this.f127759g, this.f127760h, continuation);
        adultContentDownloadWorker$saveWithProgressAnimation$2.f127756c = obj;
        return adultContentDownloadWorker$saveWithProgressAnimation$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Job job;
        CoroutineScope coroutineScope = (CoroutineScope) this.f127756c;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f127755b;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            job = (Job) this.f127754a;
            try {
                ResultKt.b(obj);
                Job.DefaultImpls.b(job, null, 1, null);
                return Unit.f139807a;
            } catch (Throwable th) {
                th = th;
                Job.DefaultImpls.b(job, null, 1, null);
                throw th;
            }
        }
        ResultKt.b(obj);
        Job jobD = BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new AdultContentDownloadWorker$saveWithProgressAnimation$2$loadingJob$1(null), 3, null);
        try {
            AdultContentWebsiteDao adultContentWebsiteDaoU = this.f127757d.u();
            BlockingDatabase blockingDatabaseV = this.f127757d.v();
            List list = this.f127758f;
            List list2 = this.f127759g;
            List list3 = this.f127760h;
            this.f127756c = SpillingKt.a(coroutineScope);
            this.f127754a = jobD;
            this.f127755b = 1;
            if (adultContentWebsiteDaoU.N(blockingDatabaseV, list, list2, list3, this) == objF) {
                return objF;
            }
            job = jobD;
            Job.DefaultImpls.b(job, null, 1, null);
            return Unit.f139807a;
        } catch (Throwable th2) {
            th = th2;
            job = jobD;
            Job.DefaultImpls.b(job, null, 1, null);
            throw th;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((AdultContentDownloadWorker$saveWithProgressAnimation$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
