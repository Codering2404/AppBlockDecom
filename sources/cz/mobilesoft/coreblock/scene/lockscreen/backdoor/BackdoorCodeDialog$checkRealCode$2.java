package cz.mobilesoft.coreblock.scene.lockscreen.backdoor;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
final class BackdoorCodeDialog$checkRealCode$2<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ BackdoorCodeDialog f105593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Function0 f105594b;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$checkRealCode$2$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$checkRealCode$2$2", f = "BackdoorCodeDialog.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f105595a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ BackdoorCodeDialog f105596b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(BackdoorCodeDialog backdoorCodeDialog, Continuation continuation) {
            super(2, continuation);
            this.f105596b = backdoorCodeDialog;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.f105596b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f105595a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.f105596b.T();
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    BackdoorCodeDialog$checkRealCode$2(BackdoorCodeDialog backdoorCodeDialog, Function0 function0) {
        this.f105593a = backdoorCodeDialog;
        this.f105594b = function0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x010d, code lost:
    
        if (r2.I(r3) != r4) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01dc, code lost:
    
        if (r2 != r4) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x021a, code lost:
    
        if (r2.emit(r5, r3) == r4) goto L73;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d9 A[PHI: r1
      0x00d9: PHI (r1v7 cz.mobilesoft.coreblock.util.DataState) = (r1v4 cz.mobilesoft.coreblock.util.DataState), (r1v9 cz.mobilesoft.coreblock.util.DataState) binds: [B:28:0x00d5, B:20:0x0086] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00fe A[PHI: r1
      0x00fe: PHI (r1v10 cz.mobilesoft.coreblock.util.DataState) = (r1v7 cz.mobilesoft.coreblock.util.DataState), (r1v15 cz.mobilesoft.coreblock.util.DataState) binds: [B:35:0x00fa, B:19:0x007d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0174 A[PHI: r1 r5 r7
      0x0174: PHI (r1v25 int) = (r1v23 int), (r1v26 int) binds: [B:51:0x0170, B:15:0x0051] A[DONT_GENERATE, DONT_INLINE]
      0x0174: PHI (r5v13 int) = (r5v11 int), (r5v14 int) binds: [B:51:0x0170, B:15:0x0051] A[DONT_GENERATE, DONT_INLINE]
      0x0174: PHI (r7v9 cz.mobilesoft.coreblock.util.DataState) = (r7v6 cz.mobilesoft.coreblock.util.DataState), (r7v11 cz.mobilesoft.coreblock.util.DataState) binds: [B:51:0x0170, B:15:0x0051] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object emit(cz.mobilesoft.coreblock.util.DataState r18, kotlin.coroutines.Continuation r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 574
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$checkRealCode$2.emit(cz.mobilesoft.coreblock.util.DataState, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
