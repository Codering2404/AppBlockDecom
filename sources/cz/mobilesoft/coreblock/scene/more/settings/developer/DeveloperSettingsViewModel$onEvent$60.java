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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$onEvent$60", f = "DeveloperSettingsViewModel.kt", l = {767, 773}, m = "invokeSuspend", v = 1)
final class DeveloperSettingsViewModel$onEvent$60 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f108812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f108813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f108814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ DeveloperSettingsViewModel f108815d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DeveloperSettingsViewModel$onEvent$60(DeveloperSettingsViewModel developerSettingsViewModel, Continuation continuation) {
        super(2, continuation);
        this.f108815d = developerSettingsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DeveloperSettingsViewModel$onEvent$60(this.f108815d, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0091, code lost:
    
        if (r3.P0(r4, r7) == r0) goto L31;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r7.f108814c
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L23
            if (r1 == r3) goto L1f
            if (r1 != r2) goto L17
            java.lang.Object r0 = r7.f108812a
            java.lang.String r0 = (java.lang.String) r0
            kotlin.ResultKt.b(r8)
            goto L94
        L17:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1f:
            kotlin.ResultKt.b(r8)
            goto L35
        L23:
            kotlin.ResultKt.b(r8)
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r8 = r7.f108815d
            cz.mobilesoft.coreblock.storage.datastore.TrialConversionDataStore r8 = cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.U1(r8)
            r7.f108814c = r3
            java.lang.Object r8 = r8.F(r7)
            if (r8 != r0) goto L35
            goto L93
        L35:
            cz.mobilesoft.coreblock.storage.datastore.TrialConversionState r8 = (cz.mobilesoft.coreblock.storage.datastore.TrialConversionState) r8
            java.lang.String r8 = r8.d()
            if (r8 != 0) goto L4f
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r8 = r7.f108815d
            cz.mobilesoft.coreblock.repository.PremiumRepositoryV2 r8 = cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.F1(r8)
            com.revenuecat.purchases.CustomerInfo r8 = r8.B()
            if (r8 == 0) goto L4e
            java.lang.String r8 = cz.mobilesoft.coreblock.util.subscription.RevenueCatExtKt.b(r8)
            goto L4f
        L4e:
            r8 = 0
        L4f:
            cz.mobilesoft.coreblock.util.notifications.NotificationHelper r1 = cz.mobilesoft.coreblock.util.notifications.NotificationHelper.f128940a
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r3 = r7.f108815d
            android.content.Context r3 = r3.A0()
            if (r8 != 0) goto L5c
            java.lang.String r4 = "mock_trial_conversion_product"
            goto L5d
        L5c:
            r4 = r8
        L5d:
            boolean r1 = r1.L(r3, r4)
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r3 = r7.f108815d
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewCommand$ShowToast r4 = new cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewCommand$ShowToast
            if (r1 != 0) goto L6a
            java.lang.String r5 = "Not shown - POST_NOTIFICATIONS permission missing"
            goto L80
        L6a:
            if (r8 != 0) goto L6f
            java.lang.String r5 = "Shown with a placeholder SKU - the Play deep link will not resolve"
            goto L80
        L6f:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Failed-conversion notification shown for "
            r5.append(r6)
            r5.append(r8)
            java.lang.String r5 = r5.toString()
        L80:
            r4.<init>(r5)
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
            r7.f108812a = r8
            r7.f108813b = r1
            r7.f108814c = r2
            java.lang.Object r8 = cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.X1(r3, r4, r7)
            if (r8 != r0) goto L94
        L93:
            return r0
        L94:
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$onEvent$60.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DeveloperSettingsViewModel$onEvent$60) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
