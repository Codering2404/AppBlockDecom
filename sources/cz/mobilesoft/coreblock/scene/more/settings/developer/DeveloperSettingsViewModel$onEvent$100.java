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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$onEvent$100", f = "DeveloperSettingsViewModel.kt", l = {1032, 1033, 1034, 1035}, m = "invokeSuspend", v = 1)
final class DeveloperSettingsViewModel$onEvent$100 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f108658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ DeveloperSettingsViewModel f108659b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DeveloperSettingsViewModel$onEvent$100(DeveloperSettingsViewModel developerSettingsViewModel, Continuation continuation) {
        super(2, continuation);
        this.f108659b = developerSettingsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DeveloperSettingsViewModel$onEvent$100(this.f108659b, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0067, code lost:
    
        if (r8.P0(r1, r7) != r0) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005d  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r7.f108658a
            r2 = 0
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L2d
            if (r1 == r6) goto L29
            if (r1 == r5) goto L25
            if (r1 == r4) goto L21
            if (r1 != r3) goto L19
            kotlin.ResultKt.b(r8)
            goto L6a
        L19:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L21:
            kotlin.ResultKt.b(r8)
            goto L5d
        L25:
            kotlin.ResultKt.b(r8)
            goto L4e
        L29:
            kotlin.ResultKt.b(r8)
            goto L3f
        L2d:
            kotlin.ResultKt.b(r8)
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r8 = r7.f108659b
            cz.mobilesoft.coreblock.repository.PremiumRepositoryV2 r8 = cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.F1(r8)
            r7.f108658a = r6
            java.lang.Object r8 = r8.t(r7)
            if (r8 != r0) goto L3f
            goto L69
        L3f:
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r8 = r7.f108659b
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r8 = cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.B1(r8)
            r7.f108658a = r5
            java.lang.Object r8 = r8.B4(r2, r7)
            if (r8 != r0) goto L4e
            goto L69
        L4e:
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r8 = r7.f108659b
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r8 = cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.B1(r8)
            r7.f108658a = r4
            java.lang.Object r8 = r8.C4(r2, r7)
            if (r8 != r0) goto L5d
            goto L69
        L5d:
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r8 = r7.f108659b
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewCommand$NavigateToAutoTrialFlow r1 = cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewCommand.NavigateToAutoTrialFlow.f108312a
            r7.f108658a = r3
            java.lang.Object r8 = cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.X1(r8, r1, r7)
            if (r8 != r0) goto L6a
        L69:
            return r0
        L6a:
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$onEvent$100.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DeveloperSettingsViewModel$onEvent$100) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
