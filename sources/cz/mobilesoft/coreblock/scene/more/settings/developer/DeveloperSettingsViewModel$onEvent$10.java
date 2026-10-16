package cz.mobilesoft.coreblock.scene.more.settings.developer;

import com.facebook.internal.FacebookRequestErrorClassification;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$onEvent$10", f = "DeveloperSettingsViewModel.kt", l = {488, FacebookRequestErrorClassification.ESC_APP_INACTIVE, 496}, m = "invokeSuspend", v = 1)
final class DeveloperSettingsViewModel$onEvent$10 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f108655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f108656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ DeveloperSettingsViewModel f108657c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DeveloperSettingsViewModel$onEvent$10(DeveloperSettingsViewModel developerSettingsViewModel, Continuation continuation) {
        super(2, continuation);
        this.f108657c = developerSettingsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DeveloperSettingsViewModel$onEvent$10(this.f108657c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0058, code lost:
    
        if (r6.P0(r2, r5) == r0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008f, code lost:
    
        if (r6.h0("", r5) != r0) goto L33;
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
            int r1 = r5.f108656b
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L28
            if (r1 == r4) goto L24
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            kotlin.ResultKt.b(r6)
            goto L92
        L16:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1e:
            int r1 = r5.f108655a
            kotlin.ResultKt.b(r6)
            goto L7f
        L24:
            kotlin.ResultKt.b(r6)
            goto L5b
        L28:
            kotlin.ResultKt.b(r6)
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r6 = r5.f108657c
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewState r6 = cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.y1(r6)
            cz.mobilesoft.coreblock.scene.more.settings.developer.streaks.StreakDebugHelper$Snapshot r6 = r6.N()
            if (r6 == 0) goto L43
            cz.mobilesoft.coreblock.scene.streaks.StreakStats r6 = r6.e()
            if (r6 == 0) goto L43
            int r6 = r6.b()
        L41:
            r1 = r6
            goto L45
        L43:
            r6 = 0
            goto L41
        L45:
            if (r1 > 0) goto L5e
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r6 = r5.f108657c
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewCommand$ShowToast r2 = new cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewCommand$ShowToast
            java.lang.String r3 = "No streak is running. Seed one first"
            r2.<init>(r3)
            r5.f108655a = r1
            r5.f108656b = r4
            java.lang.Object r6 = cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.X1(r6, r2, r5)
            if (r6 != r0) goto L5b
            goto L91
        L5b:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        L5e:
            cz.mobilesoft.coreblock.scene.streaks.StreakConfiguration r6 = cz.mobilesoft.coreblock.scene.streaks.StreakConfiguration.f120230a
            java.util.List r6 = r6.b()
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.d(r1)
            boolean r6 = r6.contains(r4)
            if (r6 == 0) goto L7f
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r6 = r5.f108657c
            cz.mobilesoft.coreblock.storage.datastore.StreakDataStore r6 = cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.K1(r6)
            r5.f108655a = r1
            r5.f108656b = r3
            java.lang.Object r6 = r6.Z(r1, r5)
            if (r6 != r0) goto L7f
            goto L91
        L7f:
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r6 = r5.f108657c
            cz.mobilesoft.coreblock.storage.datastore.StreakDataStore r6 = cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.K1(r6)
            r5.f108655a = r1
            r5.f108656b = r2
            java.lang.String r1 = ""
            java.lang.Object r6 = r6.h0(r1, r5)
            if (r6 != r0) goto L92
        L91:
            return r0
        L92:
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r6 = r5.f108657c
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.W1(r6)
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$onEvent$10.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DeveloperSettingsViewModel$onEvent$10) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
