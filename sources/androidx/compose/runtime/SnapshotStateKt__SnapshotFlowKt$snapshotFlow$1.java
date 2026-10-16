package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1", f = "SnapshotFlow.kt", l = {142, 146, 169}, m = "invokeSuspend")
final class SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1 extends SuspendLambda implements Function2<FlowCollector<Object>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f24273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f24274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f24275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f24276d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f24277f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f24278g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f24279h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private /* synthetic */ Object f24280i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ Function0 f24281j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1(Function0 function0, Continuation continuation) {
        super(2, continuation);
        this.f24281j = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1 snapshotStateKt__SnapshotFlowKt$snapshotFlow$1 = new SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1(this.f24281j, continuation);
        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.f24280i = obj;
        return snapshotStateKt__SnapshotFlowKt$snapshotFlow$1;
    }

    /* JADX WARN: Path cross not found for [B:33:0x00cb, B:37:0x00d4], limit reached: 74 */
    /* JADX WARN: Path cross not found for [B:41:0x00e3, B:57:0x0122], limit reached: 74 */
    /* JADX WARN: Path cross not found for [B:57:0x0122, B:41:0x00e3], limit reached: 74 */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e3 A[Catch: all -> 0x0055, TRY_LEAVE, TryCatch #0 {all -> 0x0055, blocks: (B:15:0x0050, B:31:0x00c7, B:33:0x00cb, B:38:0x00d5, B:41:0x00e3, B:45:0x00f9, B:47:0x0102, B:55:0x011e, B:56:0x0121, B:42:0x00ee, B:44:0x00f6, B:53:0x011a, B:54:0x011d), top: B:68:0x0050, inners: #1 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector flowCollector, Continuation continuation) {
        return ((SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.f139807a);
    }
}
