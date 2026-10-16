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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$onEvent$102", f = "DeveloperSettingsViewModel.kt", l = {1054, 1057, 1058}, m = "invokeSuspend", v = 1)
final class DeveloperSettingsViewModel$onEvent$102 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f108663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f108664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ DeveloperSettingsViewModel f108665c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DeveloperSettingsViewModel$onEvent$102(DeveloperSettingsViewModel developerSettingsViewModel, Continuation continuation) {
        super(2, continuation);
        this.f108665c = developerSettingsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DeveloperSettingsViewModel$onEvent$102(this.f108665c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x006e, code lost:
    
        if (r6.P0(r3, r5) != r0) goto L23;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r5.f108664b
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L29
            if (r1 == r4) goto L23
            if (r1 == r3) goto L1d
            if (r1 != r2) goto L15
            kotlin.ResultKt.b(r6)
            goto L71
        L15:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1d:
            int r1 = r5.f108663a
            kotlin.ResultKt.b(r6)
            goto L5d
        L23:
            int r1 = r5.f108663a
            kotlin.ResultKt.b(r6)
            goto L49
        L29:
            kotlin.ResultKt.b(r6)
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r6 = r5.f108665c
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewState r6 = cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.y1(r6)
            boolean r6 = r6.m()
            r6 = r6 ^ r4
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r1 = r5.f108665c
            cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore r1 = r1.m2()
            r5.f108663a = r6
            r5.f108664b = r4
            java.lang.Object r1 = r1.Q1(r6, r5)
            if (r1 != r0) goto L48
            goto L70
        L48:
            r1 = r6
        L49:
            if (r1 == 0) goto L71
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r6 = r5.f108665c
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r6 = cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.B1(r6)
            r5.f108663a = r1
            r5.f108664b = r3
            r3 = 0
            java.lang.Object r6 = r6.C4(r3, r5)
            if (r6 != r0) goto L5d
            goto L70
        L5d:
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r6 = r5.f108665c
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewCommand$ShowToast r3 = new cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewCommand$ShowToast
            java.lang.String r4 = "Auto-trial expired card (variant C) forced on dashboard/profile"
            r3.<init>(r4)
            r5.f108663a = r1
            r5.f108664b = r2
            java.lang.Object r6 = cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.X1(r6, r3, r5)
            if (r6 != r0) goto L71
        L70:
            return r0
        L71:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$onEvent$102.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DeveloperSettingsViewModel$onEvent$102) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
