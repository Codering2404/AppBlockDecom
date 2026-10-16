package cz.mobilesoft.appblock.service;

import cz.mobilesoft.appblock.service.InitOverlayForegroundService;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.appblock.service.InitOverlayForegroundService$determineRequiredServicesSafely$2", f = "InitOverlayForegroundService.kt", l = {477, 503, 510}, m = "invokeSuspend", v = 1)
final class InitOverlayForegroundService$determineRequiredServicesSafely$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super InitOverlayForegroundService.RequiredServices>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f94172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f94173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f94174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f94175d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f94176f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f94177g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f94178h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ InitOverlayForegroundService f94179i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitOverlayForegroundService$determineRequiredServicesSafely$2(InitOverlayForegroundService initOverlayForegroundService, Continuation continuation) {
        super(2, continuation);
        this.f94179i = initOverlayForegroundService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new InitOverlayForegroundService$determineRequiredServicesSafely$2(this.f94179i, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0232  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 570
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.service.InitOverlayForegroundService$determineRequiredServicesSafely$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((InitOverlayForegroundService$determineRequiredServicesSafely$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
