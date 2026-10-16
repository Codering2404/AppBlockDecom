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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$onEvent$3", f = "GeneralSettingsViewModel.kt", l = {195, 196, 197}, m = "invokeSuspend", v = 1)
final class GeneralSettingsViewModel$onEvent$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f109771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f109772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ GeneralSettingsViewModel f109773c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GeneralSettingsViewModel$onEvent$3(GeneralSettingsViewModel generalSettingsViewModel, Continuation continuation) {
        super(2, continuation);
        this.f109773c = generalSettingsViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GeneralSettingsViewState q(GeneralSettingsViewState generalSettingsViewState) {
        return generalSettingsViewState.a((16381 & 1) != 0 ? generalSettingsViewState.f109819a : null, (16381 & 2) != 0 ? generalSettingsViewState.f109820b : null, (16381 & 4) != 0 ? generalSettingsViewState.f109821c : null, (16381 & 8) != 0 ? generalSettingsViewState.f109822d : false, (16381 & 16) != 0 ? generalSettingsViewState.f109823f : false, (16381 & 32) != 0 ? generalSettingsViewState.f109824g : false, (16381 & 64) != 0 ? generalSettingsViewState.f109825h : false, (16381 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? generalSettingsViewState.f109826i : false, (16381 & Function.MAX_NARGS) != 0 ? generalSettingsViewState.f109827j : false, (16381 & 512) != 0 ? generalSettingsViewState.f109828k : true, (16381 & 1024) != 0 ? generalSettingsViewState.f109829l : false, (16381 & 2048) != 0 ? generalSettingsViewState.f109830m : false, (16381 & 4096) != 0 ? generalSettingsViewState.f109831n : false, (16381 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? generalSettingsViewState.f109832o : false);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new GeneralSettingsViewModel$onEvent$3(this.f109773c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x006b, code lost:
    
        if (r7.V(r6) != r0) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005d A[PHI: r1
      0x005d: PHI (r1v6 boolean) = (r1v5 boolean), (r1v8 boolean) binds: [B:19:0x005a, B:10:0x001d] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f109772b
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L29
            if (r1 == r4) goto L23
            if (r1 == r3) goto L1d
            if (r1 != r2) goto L15
            kotlin.ResultKt.b(r7)
            goto L78
        L15:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1d:
            boolean r1 = r6.f109771a
            kotlin.ResultKt.b(r7)
            goto L5d
        L23:
            boolean r1 = r6.f109771a
            kotlin.ResultKt.b(r7)
            goto L4c
        L29:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel r7 = r6.f109773c
            cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewState r7 = cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel.S0(r7)
            boolean r7 = r7.c()
            if (r7 == 0) goto L6e
            cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel r1 = r6.f109773c
            cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore r1 = cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel.V0(r1)
            cz.mobilesoft.coreblock.enums.TripleState r5 = cz.mobilesoft.coreblock.enums.TripleState.False
            r6.f109771a = r7
            r6.f109772b = r4
            java.lang.Object r1 = r1.H0(r5, r6)
            if (r1 != r0) goto L4b
            goto L6d
        L4b:
            r1 = r7
        L4c:
            cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel r7 = r6.f109773c
            cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore r7 = cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel.V0(r7)
            r6.f109771a = r1
            r6.f109772b = r3
            java.lang.Object r7 = r7.U0(r4, r6)
            if (r7 != r0) goto L5d
            goto L6d
        L5d:
            cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel r7 = r6.f109773c
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao r7 = cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel.T0(r7)
            r6.f109771a = r1
            r6.f109772b = r2
            java.lang.Object r7 = r7.V(r6)
            if (r7 != r0) goto L78
        L6d:
            return r0
        L6e:
            cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel r7 = r6.f109773c
            cz.mobilesoft.coreblock.scene.more.settings.generalSettings.l0 r0 = new cz.mobilesoft.coreblock.scene.more.settings.generalSettings.l0
            r0.<init>()
            cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel.e1(r7, r0)
        L78:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$onEvent$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((GeneralSettingsViewModel$onEvent$3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
