package cz.mobilesoft.coreblock.service.job;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.service.job.DiscountNotificationJob$Companion$schedule$1", f = "DiscountNotificationJob.kt", l = {217, 165, 166, 171, 193}, m = "invokeSuspend", v = 1)
final class DiscountNotificationJob$Companion$schedule$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f123250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f123251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f123252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f123253d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f123254f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f123255g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f123256h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    long f123257i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    long f123258j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    long f123259k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    long f123260l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f123261m;

    DiscountNotificationJob$Companion$schedule$1(Continuation continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DiscountNotificationJob$Companion$schedule$1(continuation);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:0|2|(1:(3:(1:(1:(1:(11:9|91|10|11|96|75|(1:77)(1:81)|78|82|83|84)(2:14|15))(9:16|100|17|18|95|55|(1:57)(2:61|(1:63)(1:64))|65|(3:67|68|69)(3:70|71|(1:102)(8:74|96|75|(0)(0)|78|82|83|84))))(12:21|93|22|23|44|(1:46)|47|(1:49)(1:50)|51|(6:54|95|55|(0)(0)|65|(0)(0))|34|73))(6:26|89|27|28|40|(3:42|34|73)(9:43|44|(0)|47|(0)(0)|51|(0)|34|73))|87|88)(1:31))(4:32|(1:35)|34|73)|98|36|(3:38|34|73)(3:39|40|(0)(0))|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0269, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x026a, code lost:
    
        r1 = r11;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x013d A[Catch: all -> 0x0158, TryCatch #3 {all -> 0x0158, blocks: (B:55:0x0139, B:57:0x013d, B:65:0x018a, B:67:0x01a4, B:70:0x01b7, B:63:0x0163, B:64:0x0174), top: B:95:0x0139 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01a4 A[Catch: all -> 0x0158, TRY_LEAVE, TryCatch #3 {all -> 0x0158, blocks: (B:55:0x0139, B:57:0x013d, B:65:0x018a, B:67:0x01a4, B:70:0x01b7, B:63:0x0163, B:64:0x0174), top: B:95:0x0139 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01b7 A[Catch: all -> 0x0158, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0158, blocks: (B:55:0x0139, B:57:0x013d, B:65:0x018a, B:67:0x01a4, B:70:0x01b7, B:63:0x0163, B:64:0x0174), top: B:95:0x0139 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01f9 A[Catch: all -> 0x0208, TryCatch #4 {all -> 0x0208, blocks: (B:75:0x01e8, B:77:0x01f9, B:82:0x0223, B:81:0x020b), top: B:96:0x01e8 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x020b A[Catch: all -> 0x0208, TryCatch #4 {all -> 0x0208, blocks: (B:75:0x01e8, B:77:0x01f9, B:82:0x0223, B:81:0x020b), top: B:96:0x01e8 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 625
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.job.DiscountNotificationJob$Companion$schedule$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DiscountNotificationJob$Companion$schedule$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
