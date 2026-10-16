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
@DebugMetadata(c = "cz.mobilesoft.coreblock.service.job.TrialConversionReminderJob$onRunJob$1", f = "TrialConversionReminderJob.kt", l = {48, 49, 50, 56, 62}, m = "invokeSuspend", v = 1)
final class TrialConversionReminderJob$onRunJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job.Result>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f123494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f123495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f123496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f123497d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ TrialConversionReminderJob f123498f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TrialConversionReminderJob$onRunJob$1(TrialConversionReminderJob trialConversionReminderJob, Continuation continuation) {
        super(2, continuation);
        this.f123498f = trialConversionReminderJob;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new TrialConversionReminderJob$onRunJob$1(this.f123498f, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x0121, code lost:
    
        if (r3.C(true, r9) == r0) goto L71;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007a A[Catch: Exception -> 0x001c, TryCatch #0 {Exception -> 0x001c, blocks: (B:9:0x0017, B:72:0x0124, B:16:0x002b, B:63:0x00f1, B:65:0x00fb, B:67:0x00fe, B:69:0x0111, B:74:0x0127, B:17:0x0030, B:39:0x0091, B:41:0x0099, B:43:0x009c, B:45:0x00a8, B:47:0x00ae, B:49:0x00b4, B:51:0x00c2, B:57:0x00d0, B:59:0x00d3, B:18:0x0034, B:32:0x0072, B:34:0x007a, B:36:0x007d, B:19:0x0038, B:25:0x0053, B:27:0x005b, B:29:0x005e, B:22:0x003f), top: B:78:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007d A[Catch: Exception -> 0x001c, TryCatch #0 {Exception -> 0x001c, blocks: (B:9:0x0017, B:72:0x0124, B:16:0x002b, B:63:0x00f1, B:65:0x00fb, B:67:0x00fe, B:69:0x0111, B:74:0x0127, B:17:0x0030, B:39:0x0091, B:41:0x0099, B:43:0x009c, B:45:0x00a8, B:47:0x00ae, B:49:0x00b4, B:51:0x00c2, B:57:0x00d0, B:59:0x00d3, B:18:0x0034, B:32:0x0072, B:34:0x007a, B:36:0x007d, B:19:0x0038, B:25:0x0053, B:27:0x005b, B:29:0x005e, B:22:0x003f), top: B:78:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0099 A[Catch: Exception -> 0x001c, TryCatch #0 {Exception -> 0x001c, blocks: (B:9:0x0017, B:72:0x0124, B:16:0x002b, B:63:0x00f1, B:65:0x00fb, B:67:0x00fe, B:69:0x0111, B:74:0x0127, B:17:0x0030, B:39:0x0091, B:41:0x0099, B:43:0x009c, B:45:0x00a8, B:47:0x00ae, B:49:0x00b4, B:51:0x00c2, B:57:0x00d0, B:59:0x00d3, B:18:0x0034, B:32:0x0072, B:34:0x007a, B:36:0x007d, B:19:0x0038, B:25:0x0053, B:27:0x005b, B:29:0x005e, B:22:0x003f), top: B:78:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009c A[Catch: Exception -> 0x001c, TryCatch #0 {Exception -> 0x001c, blocks: (B:9:0x0017, B:72:0x0124, B:16:0x002b, B:63:0x00f1, B:65:0x00fb, B:67:0x00fe, B:69:0x0111, B:74:0x0127, B:17:0x0030, B:39:0x0091, B:41:0x0099, B:43:0x009c, B:45:0x00a8, B:47:0x00ae, B:49:0x00b4, B:51:0x00c2, B:57:0x00d0, B:59:0x00d3, B:18:0x0034, B:32:0x0072, B:34:0x007a, B:36:0x007d, B:19:0x0038, B:25:0x0053, B:27:0x005b, B:29:0x005e, B:22:0x003f), top: B:78:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00fb A[Catch: Exception -> 0x001c, TryCatch #0 {Exception -> 0x001c, blocks: (B:9:0x0017, B:72:0x0124, B:16:0x002b, B:63:0x00f1, B:65:0x00fb, B:67:0x00fe, B:69:0x0111, B:74:0x0127, B:17:0x0030, B:39:0x0091, B:41:0x0099, B:43:0x009c, B:45:0x00a8, B:47:0x00ae, B:49:0x00b4, B:51:0x00c2, B:57:0x00d0, B:59:0x00d3, B:18:0x0034, B:32:0x0072, B:34:0x007a, B:36:0x007d, B:19:0x0038, B:25:0x0053, B:27:0x005b, B:29:0x005e, B:22:0x003f), top: B:78:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00fe A[Catch: Exception -> 0x001c, TryCatch #0 {Exception -> 0x001c, blocks: (B:9:0x0017, B:72:0x0124, B:16:0x002b, B:63:0x00f1, B:65:0x00fb, B:67:0x00fe, B:69:0x0111, B:74:0x0127, B:17:0x0030, B:39:0x0091, B:41:0x0099, B:43:0x009c, B:45:0x00a8, B:47:0x00ae, B:49:0x00b4, B:51:0x00c2, B:57:0x00d0, B:59:0x00d3, B:18:0x0034, B:32:0x0072, B:34:0x007a, B:36:0x007d, B:19:0x0038, B:25:0x0053, B:27:0x005b, B:29:0x005e, B:22:0x003f), top: B:78:0x000b }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.job.TrialConversionReminderJob$onRunJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((TrialConversionReminderJob$onRunJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
