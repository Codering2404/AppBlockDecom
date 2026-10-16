package cz.mobilesoft.appblock.service;

import cz.mobilesoft.coreblock.dto.UrlDto;
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
@DebugMetadata(c = "cz.mobilesoft.appblock.service.LockRunnable$initialize$1", f = "LockRunnable.kt", l = {717, 718, 719, 721}, m = "invokeSuspend", v = 1)
final class LockRunnable$initialize$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f94465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f94466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f94467c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ LockRunnable f94468d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockRunnable$initialize$1(LockRunnable lockRunnable, Continuation continuation) {
        super(2, continuation);
        this.f94468d = lockRunnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String q(LockRunnable lockRunnable) {
        UrlDto urlDto = lockRunnable.W().c().getUrlDto();
        if (urlDto != null) {
            return urlDto.getDomain();
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LockRunnable$initialize$1(this.f94468d, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00eb, code lost:
    
        if (r13.e(r1, r12) != r0) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bb  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 271
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.service.LockRunnable$initialize$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LockRunnable$initialize$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
