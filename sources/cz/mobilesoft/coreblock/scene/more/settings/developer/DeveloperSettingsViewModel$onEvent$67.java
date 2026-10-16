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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$onEvent$67", f = "DeveloperSettingsViewModel.kt", l = {828, 829}, m = "invokeSuspend", v = 1)
final class DeveloperSettingsViewModel$onEvent$67 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f108827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f108828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ DeveloperSettingsViewEvent f108829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ DeveloperSettingsViewModel f108830d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DeveloperSettingsViewModel$onEvent$67(DeveloperSettingsViewEvent developerSettingsViewEvent, DeveloperSettingsViewModel developerSettingsViewModel, Continuation continuation) {
        super(2, continuation);
        this.f108829c = developerSettingsViewEvent;
        this.f108830d = developerSettingsViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeveloperSettingsViewState q(DeveloperSettingsViewState developerSettingsViewState) {
        return DeveloperSettingsViewState.b(developerSettingsViewState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -1, 262143, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DeveloperSettingsViewModel$onEvent$67(this.f108829c, this.f108830d, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x006d, code lost:
    
        if (r9.X1(r4, r8) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r8.f108828b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L20
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r9)
            goto L70
        L12:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1a:
            int r1 = r8.f108827a
            kotlin.ResultKt.b(r9)
            goto L57
        L20:
            kotlin.ResultKt.b(r9)
            cz.mobilesoft.coreblock.model.RemoteConfig r9 = cz.mobilesoft.coreblock.model.RemoteConfig.f97054c
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewEvent r1 = r8.f108829c
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewEvent$OnMockRemoteConfigSaved r1 = (cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewEvent.OnMockRemoteConfigSaved) r1
            java.lang.String r1 = r1.a()
            java.util.Map r9 = r9.D(r1)
            int r1 = r9.size()
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r9 = r8.f108830d
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewCommand$ShowToast r4 = new cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewCommand$ShowToast
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r5 = r8.f108830d
            int r6 = cz.mobilesoft.coreblock.R.string.Pa
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.d(r1)
            java.lang.Object[] r7 = new java.lang.Object[]{r7}
            java.lang.String r5 = cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.R1(r5, r6, r7)
            r4.<init>(r5)
            r8.f108827a = r1
            r8.f108828b = r3
            java.lang.Object r9 = cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.X1(r9, r4, r8)
            if (r9 != r0) goto L57
            goto L6f
        L57:
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r9 = r8.f108830d
            cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore r9 = r9.m2()
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewEvent r4 = r8.f108829c
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewEvent$OnMockRemoteConfigSaved r4 = (cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewEvent.OnMockRemoteConfigSaved) r4
            java.lang.String r4 = r4.a()
            r8.f108827a = r1
            r8.f108828b = r2
            java.lang.Object r9 = r9.X1(r4, r8)
            if (r9 != r0) goto L70
        L6f:
            return r0
        L70:
            cz.mobilesoft.coreblock.model.RemoteConfig r9 = cz.mobilesoft.coreblock.model.RemoteConfig.f97054c     // Catch: java.lang.IllegalStateException -> L76
            r9.A(r3)     // Catch: java.lang.IllegalStateException -> L76
            goto L7a
        L76:
            r9 = move-exception
            r9.printStackTrace()
        L7a:
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r9 = r8.f108830d
            cz.mobilesoft.coreblock.scene.more.settings.developer.a8 r0 = new cz.mobilesoft.coreblock.scene.more.settings.developer.a8
            r0.<init>()
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.Y1(r9, r0)
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$onEvent$67.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DeveloperSettingsViewModel$onEvent$67) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
