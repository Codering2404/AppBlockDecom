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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$onEvent$7", f = "DeveloperSettingsViewModel.kt", l = {FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED, 461}, m = "invokeSuspend", v = 1)
final class DeveloperSettingsViewModel$onEvent$7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f108836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f108837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ DeveloperSettingsViewModel f108838c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DeveloperSettingsViewModel$onEvent$7(DeveloperSettingsViewModel developerSettingsViewModel, Continuation continuation) {
        super(2, continuation);
        this.f108838c = developerSettingsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DeveloperSettingsViewModel$onEvent$7(this.f108838c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0055, code lost:
    
        if (r1.P0(r3, r11) == r0) goto L17;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r11.f108837b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L24
            if (r1 == r3) goto L1f
            if (r1 != r2) goto L17
            java.lang.Object r0 = r11.f108836a
            java.lang.Integer r0 = (java.lang.Integer) r0
            kotlin.ResultKt.b(r12)
            r8 = r11
            goto L58
        L17:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L1f:
            kotlin.ResultKt.b(r12)
            r8 = r11
            goto L3c
        L24:
            kotlin.ResultKt.b(r12)
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r12 = r11.f108838c
            cz.mobilesoft.coreblock.scene.streaks.StreakNudgePlanner r4 = cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.M1(r12)
            r11.f108837b = r3
            r5 = 0
            r7 = 0
            r9 = 3
            r10 = 0
            r8 = r11
            java.lang.Object r12 = cz.mobilesoft.coreblock.scene.streaks.StreakNudgePlanner.e(r4, r5, r7, r8, r9, r10)
            if (r12 != r0) goto L3c
            goto L57
        L3c:
            java.lang.Integer r12 = (java.lang.Integer) r12
            if (r12 != 0) goto L5b
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r1 = r8.f108838c
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewCommand$ShowToast r3 = new cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewCommand$ShowToast
            java.lang.String r4 = "No reminder is due"
            r3.<init>(r4)
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.a(r12)
            r8.f108836a = r12
            r8.f108837b = r2
            java.lang.Object r12 = cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.X1(r1, r3, r11)
            if (r12 != r0) goto L58
        L57:
            return r0
        L58:
            kotlin.Unit r12 = kotlin.Unit.f139807a
            return r12
        L5b:
            cz.mobilesoft.coreblock.util.notifications.NotificationHelper r0 = cz.mobilesoft.coreblock.util.notifications.NotificationHelper.f128940a
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r1 = r8.f108838c
            android.app.Application r1 = r1.y0()
            int r12 = r12.intValue()
            r0.I(r1, r12)
            kotlin.Unit r12 = kotlin.Unit.f139807a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$onEvent$7.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DeveloperSettingsViewModel$onEvent$7) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
