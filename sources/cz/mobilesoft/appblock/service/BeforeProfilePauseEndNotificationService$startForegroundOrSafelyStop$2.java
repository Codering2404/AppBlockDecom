package cz.mobilesoft.appblock.service;

import androidx.core.app.NotificationCompat;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.notifications.NotificationHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.appblock.service.BeforeProfilePauseEndNotificationService$startForegroundOrSafelyStop$2", f = "BeforeProfilePauseEndNotificationService.kt", l = {}, m = "invokeSuspend", v = 1)
final class BeforeProfilePauseEndNotificationService$startForegroundOrSafelyStop$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f94075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BeforeProfilePauseEndNotificationService f94076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f94077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ NotificationCompat.Builder f94078d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BeforeProfilePauseEndNotificationService$startForegroundOrSafelyStop$2(BeforeProfilePauseEndNotificationService beforeProfilePauseEndNotificationService, long j3, NotificationCompat.Builder builder, Continuation continuation) {
        super(2, continuation);
        this.f94076b = beforeProfilePauseEndNotificationService;
        this.f94077c = j3;
        this.f94078d = builder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BeforeProfilePauseEndNotificationService$startForegroundOrSafelyStop$2(this.f94076b, this.f94077c, this.f94078d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f94075a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (this.f94076b.f94040c.size() == 0) {
            BeforeProfilePauseEndNotificationService beforeProfilePauseEndNotificationService = this.f94076b;
            try {
                beforeProfilePauseEndNotificationService.startForeground(10013, NotificationHelper.f128940a.q(beforeProfilePauseEndNotificationService));
            } catch (Exception e3) {
                CrashHelper.j(e3);
            }
            this.f94076b.E();
            NotificationHelper.f128940a.h(beforeProfilePauseEndNotificationService);
            return Unit.f139807a;
        }
        if (this.f94076b.f94040c.size() != 1 || !this.f94076b.f94040c.contains(Boxing.e(this.f94077c))) {
            return Unit.f139807a;
        }
        NotificationCompat.Builder builder = this.f94078d;
        if (builder == null) {
            return null;
        }
        BeforeProfilePauseEndNotificationService beforeProfilePauseEndNotificationService2 = this.f94076b;
        try {
            beforeProfilePauseEndNotificationService2.startForeground(beforeProfilePauseEndNotificationService2.g(), builder.c());
        } catch (Exception e4) {
            CrashHelper.j(e4);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BeforeProfilePauseEndNotificationService$startForegroundOrSafelyStop$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
