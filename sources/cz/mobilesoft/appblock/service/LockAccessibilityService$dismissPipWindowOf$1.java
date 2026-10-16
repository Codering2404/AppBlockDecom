package cz.mobilesoft.appblock.service;

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
@DebugMetadata(c = "cz.mobilesoft.appblock.service.LockAccessibilityService$dismissPipWindowOf$1", f = "LockAccessibilityService.kt", l = {906, 913}, m = "invokeSuspend", v = 1)
final class LockAccessibilityService$dismissPipWindowOf$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f94273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f94274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f94275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f94276d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f94277f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f94278g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f94279h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f94280i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ LockAccessibilityService f94281j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ String f94282k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockAccessibilityService$dismissPipWindowOf$1(LockAccessibilityService lockAccessibilityService, String str, Continuation continuation) {
        super(2, continuation);
        this.f94281j = lockAccessibilityService;
        this.f94282k = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LockAccessibilityService$dismissPipWindowOf$1(this.f94281j, this.f94282k, continuation);
    }

    /* JADX WARN: Path cross not found for [B:18:0x0084, B:20:0x009b], limit reached: 31 */
    /* JADX WARN: Path cross not found for [B:20:0x009b, B:18:0x0084], limit reached: 31 */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00f3  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00e7 -> B:29:0x00ea). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.service.LockAccessibilityService$dismissPipWindowOf$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LockAccessibilityService$dismissPipWindowOf$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
