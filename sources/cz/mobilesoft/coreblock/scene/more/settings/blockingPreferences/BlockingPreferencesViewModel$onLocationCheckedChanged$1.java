package cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$onLocationCheckedChanged$1", f = "BlockingPreferencesViewModel.kt", l = {285, 298, 303, 308}, m = "invokeSuspend", v = 1)
final class BlockingPreferencesViewModel$onLocationCheckedChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f108154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f108155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f108156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f108157d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ BlockingPreferencesViewState f108158f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ BlockingPreferencesViewModel f108159g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BlockingPreferencesViewModel$onLocationCheckedChanged$1(BlockingPreferencesViewState blockingPreferencesViewState, BlockingPreferencesViewModel blockingPreferencesViewModel, Continuation continuation) {
        super(2, continuation);
        this.f108158f = blockingPreferencesViewState;
        this.f108159g = blockingPreferencesViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BlockingPreferencesViewModel$onLocationCheckedChanged$1(this.f108158f, this.f108159g, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0077, code lost:
    
        if (r12.P0(r1, r11) == r0) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e0 A[PHI: r1 r7 r12
      0x00e0: PHI (r1v7 boolean) = (r1v4 boolean), (r1v6 boolean), (r1v8 boolean) binds: [B:22:0x0092, B:26:0x00b1, B:31:0x00de] A[DONT_GENERATE, DONT_INLINE]
      0x00e0: PHI (r7v3 int) = (r7v0 int), (r7v1 int), (r7v4 int) binds: [B:22:0x0092, B:26:0x00b1, B:31:0x00de] A[DONT_GENERATE, DONT_INLINE]
      0x00e0: PHI (r12v11 boolean) = (r12v5 boolean), (r12v10 boolean), (r12v13 boolean) binds: [B:22:0x0092, B:26:0x00b1, B:31:0x00de] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00fd  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$onLocationCheckedChanged$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BlockingPreferencesViewModel$onLocationCheckedChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
