package cz.mobilesoft.coreblock.scene.selection;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.selection.BlockingSelectViewModel$onSave$1", f = "BlockingSelectViewModel.kt", l = {30, 41, 42, 48}, m = "invokeSuspend", v = 1)
final class BlockingSelectViewModel$onSave$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f118057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f118058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f118059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f118060d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f118061f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f118062g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f118063h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f118064i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f118065j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ BlockingSelectViewModel f118066k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ boolean f118067l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BlockingSelectViewModel$onSave$1(BlockingSelectViewModel blockingSelectViewModel, boolean z2, Continuation continuation) {
        super(1, continuation);
        this.f118066k = blockingSelectViewModel;
        this.f118067l = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new BlockingSelectViewModel$onSave$1(this.f118066k, this.f118067l, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01a1  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 423
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.selection.BlockingSelectViewModel$onSave$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((BlockingSelectViewModel$onSave$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
