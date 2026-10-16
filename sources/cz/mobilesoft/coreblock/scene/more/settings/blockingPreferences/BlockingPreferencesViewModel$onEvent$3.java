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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$onEvent$3", f = "BlockingPreferencesViewModel.kt", l = {196, 207, 208}, m = "invokeSuspend", v = 1)
final class BlockingPreferencesViewModel$onEvent$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f108135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f108136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f108137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f108138d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f108139f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f108140g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f108141h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ BlockingPreferencesViewModel f108142i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ BlockingPreferencesViewEvent f108143j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BlockingPreferencesViewModel$onEvent$3(BlockingPreferencesViewModel blockingPreferencesViewModel, BlockingPreferencesViewEvent blockingPreferencesViewEvent, Continuation continuation) {
        super(2, continuation);
        this.f108142i = blockingPreferencesViewModel;
        this.f108143j = blockingPreferencesViewEvent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BlockingPreferencesViewModel$onEvent$3(this.f108142i, this.f108143j, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00a0, code lost:
    
        if (r2.m1(r1, r7, r11) == r0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0109, code lost:
    
        if (r12.C5(r4, r11) != r0) goto L31;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [boolean, int] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 271
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$onEvent$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BlockingPreferencesViewModel$onEvent$3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
