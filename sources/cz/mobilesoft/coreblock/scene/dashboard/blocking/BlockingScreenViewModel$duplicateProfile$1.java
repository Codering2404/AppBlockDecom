package cz.mobilesoft.coreblock.scene.dashboard.blocking;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$duplicateProfile$1", f = "BlockingScreenViewModel.kt", l = {810, 811, 818, 821}, m = "invokeSuspend", v = 1)
final class BlockingScreenViewModel$duplicateProfile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f99702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f99703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f99704c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f99705d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f99706f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ BlockingScreenViewModel f99707g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ ProfileViewDTO f99708h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BlockingScreenViewModel$duplicateProfile$1(BlockingScreenViewModel blockingScreenViewModel, ProfileViewDTO profileViewDTO, Continuation continuation) {
        super(2, continuation);
        this.f99707g = blockingScreenViewModel;
        this.f99708h = profileViewDTO;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BlockingScreenViewModel$duplicateProfile$1(this.f99707g, this.f99708h, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0145, code lost:
    
        if (r5.P0(r6, r42) != r1) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0159, code lost:
    
        if (r2.P0(r4, r42) == r1) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d7  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r43) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 351
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$duplicateProfile$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BlockingScreenViewModel$duplicateProfile$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
