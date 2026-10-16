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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$onEvent$3", f = "DeveloperSettingsViewModel.kt", l = {408, 411, 415}, m = "invokeSuspend", v = 1)
final class DeveloperSettingsViewModel$onEvent$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f108752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f108753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ DeveloperSettingsViewModel f108754c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DeveloperSettingsViewModel$onEvent$3(DeveloperSettingsViewModel developerSettingsViewModel, Continuation continuation) {
        super(2, continuation);
        this.f108754c = developerSettingsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DeveloperSettingsViewModel$onEvent$3(this.f108754c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
    
        if (r1.P0(r2, r12) == r0) goto L24;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r12.f108753b
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L30
            if (r1 == r4) goto L2b
            if (r1 == r3) goto L22
            if (r1 != r2) goto L1a
            java.lang.Object r0 = r12.f108752a
            java.lang.Integer r0 = (java.lang.Integer) r0
            kotlin.ResultKt.b(r13)
            r9 = r12
            goto L7d
        L1a:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L22:
            java.lang.Object r0 = r12.f108752a
            java.lang.Integer r0 = (java.lang.Integer) r0
            kotlin.ResultKt.b(r13)
            r9 = r12
            goto L64
        L2b:
            kotlin.ResultKt.b(r13)
            r9 = r12
            goto L48
        L30:
            kotlin.ResultKt.b(r13)
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r13 = r12.f108754c
            cz.mobilesoft.coreblock.scene.streaks.StreakAchievementNotificationPlanner r5 = cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.J1(r13)
            r12.f108753b = r4
            r6 = 0
            r8 = 0
            r10 = 3
            r11 = 0
            r9 = r12
            java.lang.Object r13 = cz.mobilesoft.coreblock.scene.streaks.StreakAchievementNotificationPlanner.c(r5, r6, r8, r9, r10, r11)
            if (r13 != r0) goto L48
            goto L7b
        L48:
            java.lang.Integer r13 = (java.lang.Integer) r13
            if (r13 != 0) goto L67
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r1 = r9.f108754c
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewCommand$ShowToast r2 = new cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewCommand$ShowToast
            java.lang.String r4 = "No milestone is due"
            r2.<init>(r4)
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.a(r13)
            r9.f108752a = r13
            r9.f108753b = r3
            java.lang.Object r13 = cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.X1(r1, r2, r12)
            if (r13 != r0) goto L64
            goto L7b
        L64:
            kotlin.Unit r13 = kotlin.Unit.f139807a
            return r13
        L67:
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r1 = r9.f108754c
            cz.mobilesoft.coreblock.storage.datastore.StreakDataStore r1 = cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.K1(r1)
            int r3 = r13.intValue()
            r9.f108752a = r13
            r9.f108753b = r2
            java.lang.Object r1 = r1.Z(r3, r12)
            if (r1 != r0) goto L7c
        L7b:
            return r0
        L7c:
            r0 = r13
        L7d:
            cz.mobilesoft.coreblock.util.notifications.NotificationHelper r13 = cz.mobilesoft.coreblock.util.notifications.NotificationHelper.f128940a
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r1 = r9.f108754c
            android.app.Application r1 = r1.y0()
            int r0 = r0.intValue()
            r13.H(r1, r0)
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r13 = r9.f108754c
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.W1(r13)
            kotlin.Unit r13 = kotlin.Unit.f139807a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$onEvent$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DeveloperSettingsViewModel$onEvent$3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
