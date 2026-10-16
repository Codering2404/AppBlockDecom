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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$onEvent$69", f = "DeveloperSettingsViewModel.kt", l = {848, 851, 857}, m = "invokeSuspend", v = 1)
final class DeveloperSettingsViewModel$onEvent$69 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f108833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f108834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ DeveloperSettingsViewModel f108835c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DeveloperSettingsViewModel$onEvent$69(DeveloperSettingsViewModel developerSettingsViewModel, Continuation continuation) {
        super(2, continuation);
        this.f108835c = developerSettingsViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeveloperSettingsViewState y(DeveloperSettingsViewState developerSettingsViewState) {
        return DeveloperSettingsViewState.b(developerSettingsViewState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, true, null, -1, 393215, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeveloperSettingsViewState z(DeveloperSettingsViewState developerSettingsViewState) {
        return DeveloperSettingsViewState.b(developerSettingsViewState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -1, 393215, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DeveloperSettingsViewModel$onEvent$69(this.f108835c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0063, code lost:
    
        if (r1.P0(r2, r5) == r0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0072, code lost:
    
        if (r1.P0(r3, r5) == r0) goto L22;
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
            int r1 = r5.f108834b
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L22
            if (r1 == r4) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            goto L1a
        L12:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1a:
            kotlin.ResultKt.b(r6)
            goto L75
        L1e:
            kotlin.ResultKt.b(r6)
            goto L40
        L22:
            kotlin.ResultKt.b(r6)
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r6 = r5.f108835c
            cz.mobilesoft.coreblock.scene.more.settings.developer.b8 r1 = new cz.mobilesoft.coreblock.scene.more.settings.developer.b8
            r1.<init>()
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.Y1(r6, r1)
            cz.mobilesoft.coreblock.scene.more.settings.developer.tools.InsightsGenerator r6 = cz.mobilesoft.coreblock.scene.more.settings.developer.tools.InsightsGenerator.f109440a
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r1 = r5.f108835c
            cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockSessionDao r1 = cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.A1(r1)
            r5.f108834b = r4
            java.lang.Object r6 = r6.b(r1, r5)
            if (r6 != r0) goto L40
            goto L74
        L40:
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            if (r6 != 0) goto L66
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r1 = r5.f108835c
            cz.mobilesoft.coreblock.scene.more.settings.developer.c8 r2 = new cz.mobilesoft.coreblock.scene.more.settings.developer.c8
            r2.<init>()
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.Y1(r1, r2)
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r1 = r5.f108835c
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewCommand$ShowToast r2 = new cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewCommand$ShowToast
            java.lang.String r4 = "No known apps in DB — use the app first, then retry"
            r2.<init>(r4)
            r5.f108833a = r6
            r5.f108834b = r3
            java.lang.Object r6 = cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.X1(r1, r2, r5)
            if (r6 != r0) goto L75
            goto L74
        L66:
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r1 = r5.f108835c
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewCommand$RestartApp r3 = cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewCommand.RestartApp.f108348a
            r5.f108833a = r6
            r5.f108834b = r2
            java.lang.Object r6 = cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.X1(r1, r3, r5)
            if (r6 != r0) goto L75
        L74:
            return r0
        L75:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$onEvent$69.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DeveloperSettingsViewModel$onEvent$69) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
