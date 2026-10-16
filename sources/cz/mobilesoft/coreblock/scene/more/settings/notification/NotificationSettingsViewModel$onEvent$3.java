package cz.mobilesoft.coreblock.scene.more.settings.notification;

import cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationPreference;
import cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel$onEvent$3", f = "NotificationSettingsViewModel.kt", l = {206}, m = "invokeSuspend", v = 1)
final class NotificationSettingsViewModel$onEvent$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f110047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f110048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f110049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f110050d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ NotificationSettingsViewModel f110051f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NotificationSettingsViewModel$onEvent$3(NotificationSettingsViewModel notificationSettingsViewModel, Continuation continuation) {
        super(2, continuation);
        this.f110051f = notificationSettingsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new NotificationSettingsViewModel$onEvent$3(this.f110051f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i3;
        Object objF = IntrinsicsKt.f();
        int i4 = this.f110050d;
        if (i4 == 0) {
            ResultKt.b(obj);
            NotificationPreference.ShowAfterScheduleEndBlockedNotifications showAfterScheduleEndBlockedNotificationsK = NotificationSettingsViewModel.T0(this.f110051f).k();
            if (showAfterScheduleEndBlockedNotificationsK != null) {
                NotificationSettingsViewModel notificationSettingsViewModel = this.f110051f;
                boolean z2 = !showAfterScheduleEndBlockedNotificationsK.a();
                NotificationDataStore notificationDataStoreI1 = notificationSettingsViewModel.i1();
                this.f110047a = SpillingKt.a(showAfterScheduleEndBlockedNotificationsK);
                this.f110048b = 0;
                this.f110049c = z2 ? 1 : 0;
                this.f110050d = 1;
                if (notificationDataStoreI1.s0(z2, this) == objF) {
                    return objF;
                }
                i3 = z2 ? 1 : 0;
            }
            return Unit.f139807a;
        }
        if (i4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        i3 = this.f110049c;
        ResultKt.b(obj);
        if (i3 != 0) {
            AnswersHelper.f128199a.h6();
        } else {
            AnswersHelper.f128199a.g6();
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((NotificationSettingsViewModel$onEvent$3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
