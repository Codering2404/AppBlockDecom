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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$onEvent$117", f = "DeveloperSettingsViewModel.kt", l = {1134, 1136}, m = "invokeSuspend", v = 1)
final class DeveloperSettingsViewModel$onEvent$117 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f108694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ DeveloperSettingsViewModel f108695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ DeveloperSettingsViewEvent f108696c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DeveloperSettingsViewModel$onEvent$117(DeveloperSettingsViewModel developerSettingsViewModel, DeveloperSettingsViewEvent developerSettingsViewEvent, Continuation continuation) {
        super(2, continuation);
        this.f108695b = developerSettingsViewModel;
        this.f108696c = developerSettingsViewEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeveloperSettingsViewState q(DeveloperSettingsViewState developerSettingsViewState) {
        return DeveloperSettingsViewState.b(developerSettingsViewState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -1, 262143, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DeveloperSettingsViewModel$onEvent$117(this.f108695b, this.f108696c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DeveloperSettingsViewModel$onEvent$117) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0051, code lost:
    
        if (r5.P0(r1, r4) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r4.f108694a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1f
            if (r1 == r3) goto L1b
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r5)
            goto L54
        L12:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            r0 = 0
            java.lang.String r0 = com.google.firebase.sessions.api.ITd.wgbAZXYjrv.JAVjcCC
            r5.<init>(r0)
            throw r5
        L1b:
            kotlin.ResultKt.b(r5)
            goto L3d
        L1f:
            kotlin.ResultKt.b(r5)
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r5 = r4.f108695b
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r5 = cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.B1(r5)
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewEvent r1 = r4.f108696c
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewEvent$OnOnboardingFlowVariantSelected r1 = (cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewEvent.OnOnboardingFlowVariantSelected) r1
            cz.mobilesoft.coreblock.scene.onboarding.OnboardingFlowVariant r1 = r1.a()
            java.lang.String r1 = r1.getKey()
            r4.f108694a = r3
            java.lang.Object r5 = r5.h5(r1, r4)
            if (r5 != r0) goto L3d
            goto L53
        L3d:
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r5 = r4.f108695b
            cz.mobilesoft.coreblock.scene.more.settings.developer.l7 r1 = new cz.mobilesoft.coreblock.scene.more.settings.developer.l7
            r1.<init>()
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.Y1(r5, r1)
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r5 = r4.f108695b
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewCommand$NavigateToOnboarding r1 = cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewCommand.NavigateToOnboarding.f108328a
            r4.f108694a = r2
            java.lang.Object r5 = cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.X1(r5, r1, r4)
            if (r5 != r0) goto L54
        L53:
            return r0
        L54:
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$onEvent$117.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
