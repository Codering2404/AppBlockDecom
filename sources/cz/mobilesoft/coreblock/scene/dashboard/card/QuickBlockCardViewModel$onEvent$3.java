package cz.mobilesoft.coreblock.scene.dashboard.card;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel$onEvent$3", f = "QuickBlockCardViewModel.kt", l = {228, 229, 233, 234, 235, 238, 239, 242, 243}, m = "invokeSuspend", v = 1)
final class QuickBlockCardViewModel$onEvent$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f100491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f100492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ QuickBlockCardViewModel f100493c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    QuickBlockCardViewModel$onEvent$3(QuickBlockCardViewModel quickBlockCardViewModel, Continuation continuation) {
        super(2, continuation);
        this.f100493c = quickBlockCardViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new QuickBlockCardViewModel$onEvent$3(this.f100493c, continuation);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0059, code lost:
    
        if (r5.P0(r1, r4) != r0) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b5, code lost:
    
        if (r1.P0(r2, r4) != r0) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d9, code lost:
    
        if (r5.P0(r1, r4) != r0) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0104, code lost:
    
        if (r5.P0(r1, r4) != r0) goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009f A[PHI: r5
      0x009f: PHI (r5v30 java.lang.Object) = (r5v29 java.lang.Object), (r5v0 java.lang.Object) binds: [B:30:0x009c, B:9:0x0020] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel$onEvent$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((QuickBlockCardViewModel$onEvent$3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
