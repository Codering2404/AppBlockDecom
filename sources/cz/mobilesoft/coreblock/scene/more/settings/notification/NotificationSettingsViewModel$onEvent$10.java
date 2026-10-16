package cz.mobilesoft.coreblock.scene.more.settings.notification;

import cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel$onEvent$10", f = "NotificationSettingsViewModel.kt", l = {286}, m = "invokeSuspend", v = 1)
final class NotificationSettingsViewModel$onEvent$10 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f110035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f110036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ NotificationSettingsViewModel f110037c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NotificationSettingsViewModel$onEvent$10(NotificationSettingsViewModel notificationSettingsViewModel, Continuation continuation) {
        super(2, continuation);
        this.f110037c = notificationSettingsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new NotificationSettingsViewModel$onEvent$10(this.f110037c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i3;
        Object objF = IntrinsicsKt.f();
        int i4 = this.f110036b;
        if (i4 == 0) {
            ResultKt.b(obj);
            boolean z2 = !NotificationSettingsViewModel.T0(this.f110037c).q();
            NotificationDataStore notificationDataStoreI1 = this.f110037c.i1();
            this.f110035a = z2 ? 1 : 0;
            this.f110036b = 1;
            if (notificationDataStoreI1.y0(z2, this) == objF) {
                return objF;
            }
            i3 = z2 ? 1 : 0;
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i3 = this.f110035a;
            ResultKt.b(obj);
        }
        if (i3 != 0) {
            AnswersHelper.f128199a.r6();
        } else {
            AnswersHelper.f128199a.q6();
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((NotificationSettingsViewModel$onEvent$10) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
