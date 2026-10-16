package cz.mobilesoft.coreblock.scene.more.settings.notification;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel$onEvent$2", f = "NotificationSettingsViewModel.kt", l = {191, 193}, m = "invokeSuspend", v = 1)
final class NotificationSettingsViewModel$onEvent$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f110044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f110045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ NotificationSettingsViewModel f110046c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NotificationSettingsViewModel$onEvent$2(NotificationSettingsViewModel notificationSettingsViewModel, Continuation continuation) {
        super(2, continuation);
        this.f110046c = notificationSettingsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new NotificationSettingsViewModel$onEvent$2(this.f110046c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((NotificationSettingsViewModel$onEvent$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0061  */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r4.f110045b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L24
            if (r1 == r3) goto L1d
            if (r1 != r2) goto L14
            int r0 = r4.f110044a
            kotlin.ResultKt.b(r5)
            goto L58
        L14:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            r0 = 0
            java.lang.String r0 = androidx.media3.exoplayer.audio.wRw.CbYNFSEGaQj.UdNR
            r5.<init>(r0)
            throw r5
        L1d:
            int r1 = r4.f110044a
            kotlin.ResultKt.b(r5)
            r5 = r1
            goto L43
        L24:
            kotlin.ResultKt.b(r5)
            cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel r5 = r4.f110046c
            cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewState r5 = cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel.T0(r5)
            boolean r5 = r5.h()
            r5 = r5 ^ r3
            cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel r1 = r4.f110046c
            cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore r1 = cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel.V0(r1)
            r4.f110044a = r5
            r4.f110045b = r3
            java.lang.Object r1 = r1.h0(r5, r4)
            if (r1 != r0) goto L43
            goto L56
        L43:
            if (r5 != 0) goto L59
            cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel r1 = r4.f110046c
            cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore r1 = cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel.V0(r1)
            r4.f110044a = r5
            r4.f110045b = r2
            r2 = 0
            java.lang.Object r1 = r1.q0(r2, r4)
            if (r1 != r0) goto L57
        L56:
            return r0
        L57:
            r0 = r5
        L58:
            r5 = r0
        L59:
            if (r5 == 0) goto L61
            cz.mobilesoft.coreblock.util.analytics.AnswersHelper r5 = cz.mobilesoft.coreblock.util.analytics.AnswersHelper.f128199a
            r5.V5()
            goto L66
        L61:
            cz.mobilesoft.coreblock.util.analytics.AnswersHelper r5 = cz.mobilesoft.coreblock.util.analytics.AnswersHelper.f128199a
            r5.U5()
        L66:
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel$onEvent$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
