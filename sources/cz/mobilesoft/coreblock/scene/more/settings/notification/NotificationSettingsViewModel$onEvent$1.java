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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel$onEvent$1", f = "NotificationSettingsViewModel.kt", l = {179}, m = "invokeSuspend", v = 1)
final class NotificationSettingsViewModel$onEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f110030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f110031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f110032c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f110033d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ NotificationSettingsViewModel f110034f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NotificationSettingsViewModel$onEvent$1(NotificationSettingsViewModel notificationSettingsViewModel, Continuation continuation) {
        super(2, continuation);
        this.f110034f = notificationSettingsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new NotificationSettingsViewModel$onEvent$1(this.f110034f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i3;
        Object objF = IntrinsicsKt.f();
        int i4 = this.f110033d;
        if (i4 == 0) {
            ResultKt.b(obj);
            NotificationPreference.ShowAfterQuickBlockEndBlockedNotifications showAfterQuickBlockEndBlockedNotificationsI = NotificationSettingsViewModel.T0(this.f110034f).i();
            if (showAfterQuickBlockEndBlockedNotificationsI != null) {
                NotificationSettingsViewModel notificationSettingsViewModel = this.f110034f;
                boolean z2 = !showAfterQuickBlockEndBlockedNotificationsI.a();
                NotificationDataStore notificationDataStoreI1 = notificationSettingsViewModel.i1();
                this.f110030a = SpillingKt.a(showAfterQuickBlockEndBlockedNotificationsI);
                this.f110031b = 0;
                this.f110032c = z2 ? 1 : 0;
                this.f110033d = 1;
                if (notificationDataStoreI1.q0(z2, this) == objF) {
                    return objF;
                }
                i3 = z2 ? 1 : 0;
            }
            return Unit.f139807a;
        }
        if (i4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        i3 = this.f110032c;
        ResultKt.b(obj);
        if (i3 != 0) {
            AnswersHelper.f128199a.T5();
        } else {
            AnswersHelper.f128199a.S5();
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((NotificationSettingsViewModel$onEvent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
