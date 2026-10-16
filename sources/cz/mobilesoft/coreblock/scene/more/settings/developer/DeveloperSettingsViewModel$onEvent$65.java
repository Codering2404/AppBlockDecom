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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$onEvent$65", f = "DeveloperSettingsViewModel.kt", l = {805, 806, 810, 816}, m = "invokeSuspend", v = 1)
final class DeveloperSettingsViewModel$onEvent$65 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f108822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f108823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f108824c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ DeveloperSettingsViewModel f108825d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ DeveloperSettingsViewEvent f108826f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DeveloperSettingsViewModel$onEvent$65(DeveloperSettingsViewModel developerSettingsViewModel, DeveloperSettingsViewEvent developerSettingsViewEvent, Continuation continuation) {
        super(2, continuation);
        this.f108825d = developerSettingsViewModel;
        this.f108826f = developerSettingsViewEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeveloperSettingsViewState q(DeveloperSettingsViewState developerSettingsViewState) {
        return DeveloperSettingsViewState.b(developerSettingsViewState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -1, 262143, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DeveloperSettingsViewModel$onEvent$65(this.f108825d, this.f108826f, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0088, code lost:
    
        if (r1.P0(r4, r8) != r0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a6, code lost:
    
        if (r1.P0(r3, r8) != r0) goto L32;
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
            int r1 = r8.f108824c
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L34
            if (r1 == r5) goto L30
            if (r1 == r4) goto L2c
            if (r1 == r3) goto L25
            if (r1 != r2) goto L1d
            java.lang.Object r0 = r8.f108823b
            java.lang.Exception r0 = (java.lang.Exception) r0
            kotlin.ResultKt.b(r9)
            goto La9
        L1d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L25:
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Exception -> L2a
            goto La9
        L2a:
            r9 = move-exception
            goto L8b
        L2c:
            kotlin.ResultKt.b(r9)
            goto L59
        L30:
            kotlin.ResultKt.b(r9)
            goto L4e
        L34:
            kotlin.ResultKt.b(r9)
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r9 = r8.f108825d
            cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore r9 = r9.m2()
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewEvent r1 = r8.f108826f
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewEvent$OnMockInAppUpdatesSaved r1 = (cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewEvent.OnMockInAppUpdatesSaved) r1
            cz.mobilesoft.coreblock.util.updates.InAppUpdatesMockSettingsDTO r1 = r1.a()
            r8.f108824c = r5
            java.lang.Object r9 = r9.T1(r1, r8)
            if (r9 != r0) goto L4e
            goto La8
        L4e:
            cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository r9 = cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository.f129855a
            r8.f108824c = r4
            java.lang.Object r9 = r9.k(r8)
            if (r9 != r0) goto L59
            goto La8
        L59:
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewEvent r9 = r8.f108826f     // Catch: java.lang.Exception -> L2a
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewEvent$OnMockInAppUpdatesSaved r9 = (cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewEvent.OnMockInAppUpdatesSaved) r9     // Catch: java.lang.Exception -> L2a
            cz.mobilesoft.coreblock.util.updates.InAppUpdatesMockSettingsDTO r9 = r9.a()     // Catch: java.lang.Exception -> L2a
            java.util.Map r9 = r9.getParsedPriorities()     // Catch: java.lang.Exception -> L2a
            int r9 = r9.size()     // Catch: java.lang.Exception -> L2a
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r1 = r8.f108825d     // Catch: java.lang.Exception -> L2a
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewCommand$ShowToast r4 = new cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewCommand$ShowToast     // Catch: java.lang.Exception -> L2a
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r5 = r8.f108825d     // Catch: java.lang.Exception -> L2a
            int r6 = cz.mobilesoft.coreblock.R.string.fa     // Catch: java.lang.Exception -> L2a
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.d(r9)     // Catch: java.lang.Exception -> L2a
            java.lang.Object[] r7 = new java.lang.Object[]{r7}     // Catch: java.lang.Exception -> L2a
            java.lang.String r5 = cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.R1(r5, r6, r7)     // Catch: java.lang.Exception -> L2a
            r4.<init>(r5)     // Catch: java.lang.Exception -> L2a
            r8.f108822a = r9     // Catch: java.lang.Exception -> L2a
            r8.f108824c = r3     // Catch: java.lang.Exception -> L2a
            java.lang.Object r9 = cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.X1(r1, r4, r8)     // Catch: java.lang.Exception -> L2a
            if (r9 != r0) goto La9
            goto La8
        L8b:
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r1 = r8.f108825d
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewCommand$ShowToast r3 = new cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewCommand$ShowToast
            java.lang.String r4 = r9.getMessage()
            if (r4 != 0) goto L97
            java.lang.String r4 = "Error"
        L97:
            r3.<init>(r4)
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.a(r9)
            r8.f108823b = r9
            r8.f108824c = r2
            java.lang.Object r9 = cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.X1(r1, r3, r8)
            if (r9 != r0) goto La9
        La8:
            return r0
        La9:
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r9 = r8.f108825d
            cz.mobilesoft.coreblock.scene.more.settings.developer.z7 r0 = new cz.mobilesoft.coreblock.scene.more.settings.developer.z7
            r0.<init>()
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.Y1(r9, r0)
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$onEvent$65.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DeveloperSettingsViewModel$onEvent$65) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
