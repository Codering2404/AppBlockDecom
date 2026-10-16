package cz.mobilesoft.coreblock.scene.more.settings.generalSettings;

import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$onEvent$4", f = "GeneralSettingsViewModel.kt", l = {209, 216, 217}, m = "invokeSuspend", v = 1)
final class GeneralSettingsViewModel$onEvent$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f109774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ GeneralSettingsViewModel f109775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ GeneralSettingsViewEvent f109776c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GeneralSettingsViewModel$onEvent$4(GeneralSettingsViewModel generalSettingsViewModel, GeneralSettingsViewEvent generalSettingsViewEvent, Continuation continuation) {
        super(2, continuation);
        this.f109775b = generalSettingsViewModel;
        this.f109776c = generalSettingsViewEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GeneralSettingsViewState q(GeneralSettingsViewState generalSettingsViewState) {
        return generalSettingsViewState.a((16381 & 1) != 0 ? generalSettingsViewState.f109819a : null, (16381 & 2) != 0 ? generalSettingsViewState.f109820b : null, (16381 & 4) != 0 ? generalSettingsViewState.f109821c : null, (16381 & 8) != 0 ? generalSettingsViewState.f109822d : false, (16381 & 16) != 0 ? generalSettingsViewState.f109823f : false, (16381 & 32) != 0 ? generalSettingsViewState.f109824g : false, (16381 & 64) != 0 ? generalSettingsViewState.f109825h : false, (16381 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? generalSettingsViewState.f109826i : false, (16381 & Function.MAX_NARGS) != 0 ? generalSettingsViewState.f109827j : false, (16381 & 512) != 0 ? generalSettingsViewState.f109828k : false, (16381 & 1024) != 0 ? generalSettingsViewState.f109829l : false, (16381 & 2048) != 0 ? generalSettingsViewState.f109830m : false, (16381 & 4096) != 0 ? generalSettingsViewState.f109831n : false, (16381 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? generalSettingsViewState.f109832o : false);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new GeneralSettingsViewModel$onEvent$4(this.f109775b, this.f109776c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0078, code lost:
    
        if (r6.V(r5) != r0) goto L28;
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
            int r1 = r5.f109774a
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L25
            if (r1 == r4) goto L21
            if (r1 == r3) goto L1d
            if (r1 != r2) goto L15
            kotlin.ResultKt.b(r6)
            goto L7b
        L15:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1d:
            kotlin.ResultKt.b(r6)
            goto L6c
        L21:
            kotlin.ResultKt.b(r6)
            goto L46
        L25:
            kotlin.ResultKt.b(r6)
            cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel r6 = r5.f109775b
            cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore r6 = cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel.V0(r6)
            cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewEvent r1 = r5.f109776c
            cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewEvent$OnCategoriesAllowed r1 = (cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewEvent.OnCategoriesAllowed) r1
            boolean r1 = r1.a()
            if (r1 == 0) goto L3b
            cz.mobilesoft.coreblock.enums.TripleState r1 = cz.mobilesoft.coreblock.enums.TripleState.True
            goto L3d
        L3b:
            cz.mobilesoft.coreblock.enums.TripleState r1 = cz.mobilesoft.coreblock.enums.TripleState.False
        L3d:
            r5.f109774a = r4
            java.lang.Object r6 = r6.H0(r1, r5)
            if (r6 != r0) goto L46
            goto L7a
        L46:
            cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewEvent r6 = r5.f109776c
            cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewEvent$OnCategoriesAllowed r6 = (cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewEvent.OnCategoriesAllowed) r6
            boolean r6 = r6.a()
            if (r6 == 0) goto L5d
            cz.mobilesoft.coreblock.repository.ApplicationRepository r6 = cz.mobilesoft.coreblock.repository.ApplicationRepository.f97454a
            cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel r0 = r5.f109775b
            android.content.Context r0 = r0.A0()
            r1 = 0
            r6.r(r0, r1)
            goto L7b
        L5d:
            cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel r6 = r5.f109775b
            cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore r6 = cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel.V0(r6)
            r5.f109774a = r3
            java.lang.Object r6 = r6.U0(r4, r5)
            if (r6 != r0) goto L6c
            goto L7a
        L6c:
            cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel r6 = r5.f109775b
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao r6 = cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel.T0(r6)
            r5.f109774a = r2
            java.lang.Object r6 = r6.V(r5)
            if (r6 != r0) goto L7b
        L7a:
            return r0
        L7b:
            cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel r6 = r5.f109775b
            cz.mobilesoft.coreblock.scene.more.settings.generalSettings.m0 r0 = new cz.mobilesoft.coreblock.scene.more.settings.generalSettings.m0
            r0.<init>()
            cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel.e1(r6, r0)
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$onEvent$4.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((GeneralSettingsViewModel$onEvent$4) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
