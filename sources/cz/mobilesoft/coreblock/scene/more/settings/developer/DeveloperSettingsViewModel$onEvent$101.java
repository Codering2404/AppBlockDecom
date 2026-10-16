package cz.mobilesoft.coreblock.scene.more.settings.developer;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$onEvent$101", f = "DeveloperSettingsViewModel.kt", l = {1041, 1045}, m = "invokeSuspend", v = 1)
final class DeveloperSettingsViewModel$onEvent$101 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f108660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f108661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ DeveloperSettingsViewModel f108662c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DeveloperSettingsViewModel$onEvent$101(DeveloperSettingsViewModel developerSettingsViewModel, Continuation continuation) {
        super(2, continuation);
        this.f108662c = developerSettingsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DeveloperSettingsViewModel$onEvent$101(this.f108662c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0063, code lost:
    
        if (r8.P0(r3, r7) == r0) goto L16;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r8v5, types: [cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r7.f108661b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L20
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r8)
            goto L69
        L12:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1a:
            int r1 = r7.f108660a
            kotlin.ResultKt.b(r8)
            goto L40
        L20:
            kotlin.ResultKt.b(r8)
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r8 = r7.f108662c
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewState r8 = cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.y1(r8)
            boolean r8 = r8.l()
            r1 = r8 ^ 1
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r8 = r7.f108662c
            cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore r8 = r8.m2()
            r7.f108660a = r1
            r7.f108661b = r3
            java.lang.Object r8 = r8.P1(r1, r7)
            if (r8 != r0) goto L40
            goto L65
        L40:
            if (r1 == 0) goto L66
            long r3 = java.lang.System.currentTimeMillis()
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.SECONDS
            r5 = 15
            long r5 = r8.toMillis(r5)
            long r3 = r3 + r5
            cz.mobilesoft.coreblock.util.runnability.JobHelper.n(r3)
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r8 = r7.f108662c
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewCommand$ShowToast r3 = new cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewCommand$ShowToast
            java.lang.String r4 = "Auto-trial expired armed: notification in 15s + auto-show on next app open"
            r3.<init>(r4)
            r7.f108660a = r1
            r7.f108661b = r2
            java.lang.Object r8 = cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.X1(r8, r3, r7)
            if (r8 != r0) goto L69
        L65:
            return r0
        L66:
            cz.mobilesoft.coreblock.util.runnability.JobHelper.a()
        L69:
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$onEvent$101.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DeveloperSettingsViewModel$onEvent$101) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
