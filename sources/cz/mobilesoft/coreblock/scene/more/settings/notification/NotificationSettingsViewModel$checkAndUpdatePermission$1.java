package cz.mobilesoft.coreblock.scene.more.settings.notification;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel$checkAndUpdatePermission$1", f = "NotificationSettingsViewModel.kt", l = {325, 325}, m = "invokeSuspend", v = 1)
final class NotificationSettingsViewModel$checkAndUpdatePermission$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f110025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f110026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ NotificationSettingsViewModel f110027c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NotificationSettingsViewModel$checkAndUpdatePermission$1(NotificationSettingsViewModel notificationSettingsViewModel, Continuation continuation) {
        super(1, continuation);
        this.f110027c = notificationSettingsViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NotificationSettingsViewState q(boolean z2, NotificationSettingsViewState notificationSettingsViewState) {
        return NotificationSettingsViewState.b(notificationSettingsViewState, Boolean.valueOf(z2), null, false, false, false, false, 0, null, false, null, false, null, 0, false, false, false, false, false, false, 524286, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new NotificationSettingsViewModel$checkAndUpdatePermission$1(this.f110027c, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x007e  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r8.f110026b
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L23
            if (r1 == r4) goto L1d
            if (r1 != r3) goto L15
            int r0 = r8.f110025a
            kotlin.ResultKt.b(r9)
            goto L77
        L15:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1d:
            int r1 = r8.f110025a
            kotlin.ResultKt.b(r9)
            goto L5b
        L23:
            kotlin.ResultKt.b(r9)
            boolean r9 = cz.mobilesoft.coreblock.util.permissions.PermissionHelper.n()
            if (r9 == 0) goto L3a
            cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel r9 = r8.f110027c
            android.content.Context r9 = r9.A0()
            boolean r9 = cz.mobilesoft.coreblock.util.permissions.PermissionHelper.o(r9)
            if (r9 != 0) goto L3a
            r9 = r4
            goto L3b
        L3a:
            r9 = r2
        L3b:
            java.lang.Boolean r1 = cz.mobilesoft.coreblock.BuildConfig.f95357b
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L7a
            cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel r1 = r8.f110027c
            cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore r1 = cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel.W0(r1)
            kotlinx.coroutines.flow.Flow r1 = r1.m1()
            r8.f110025a = r9
            r8.f110026b = r4
            java.lang.Object r1 = kotlinx.coroutines.flow.FlowKt.D(r1, r8)
            if (r1 != r0) goto L58
            goto L75
        L58:
            r7 = r1
            r1 = r9
            r9 = r7
        L5b:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L79
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.SECONDS
            r5 = 10
            long r5 = r9.toMillis(r5)
            r8.f110025a = r1
            r8.f110026b = r3
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.b(r5, r8)
            if (r9 != r0) goto L76
        L75:
            return r0
        L76:
            r0 = r1
        L77:
            r9 = r0
            goto L7a
        L79:
            r9 = r1
        L7a:
            cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel r0 = r8.f110027c
            if (r9 == 0) goto L7f
            r2 = r4
        L7f:
            cz.mobilesoft.coreblock.scene.more.settings.notification.v1 r9 = new cz.mobilesoft.coreblock.scene.more.settings.notification.v1
            r9.<init>()
            cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel.e1(r0, r9)
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel$checkAndUpdatePermission$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((NotificationSettingsViewModel$checkAndUpdatePermission$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
