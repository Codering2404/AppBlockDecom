package cz.mobilesoft.coreblock.service.job;

import com.evernote.android.job.Job;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.service.job.IntervalStartJob$onRunJob$1", f = "IntervalStartJob.kt", l = {49, 51, 54, 66, 80, 91}, m = "invokeSuspend", v = 1)
final class IntervalStartJob$onRunJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f123302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f123303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f123304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f123305d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f123306f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f123307g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f123308h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    long f123309i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    long f123310j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f123311k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private /* synthetic */ Object f123312l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final /* synthetic */ Job.Params f123313m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final /* synthetic */ IntervalStartJob f123314n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    IntervalStartJob$onRunJob$1(Job.Params params, IntervalStartJob intervalStartJob, Continuation continuation) {
        super(2, continuation);
        this.f123313m = params;
        this.f123314n = intervalStartJob;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        IntervalStartJob$onRunJob$1 intervalStartJob$onRunJob$1 = new IntervalStartJob$onRunJob$1(this.f123313m, this.f123314n, continuation);
        intervalStartJob$onRunJob$1.f123312l = obj;
        return intervalStartJob$onRunJob$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x02e0, code lost:
    
        if (r1.D(r13, r5, r10, r30) != r2) goto L67;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0299  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 760
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.job.IntervalStartJob$onRunJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((IntervalStartJob$onRunJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
