package cz.mobilesoft.coreblock.scene.schedule.preview;

import com.facebook.internal.FacebookRequestErrorClassification;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$pauseProfileFromCard$3", f = "SchedulePreviewViewModel.kt", l = {441, 443, 455, FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED, 461}, m = "invokeSuspend", v = 1)
final class SchedulePreviewViewModel$pauseProfileFromCard$3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f117504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f117505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f117506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f117507d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f117508f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f117509g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ SchedulePreviewViewModel f117510h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ Profile.PausedUntil.Time f117511i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SchedulePreviewViewModel$pauseProfileFromCard$3(SchedulePreviewViewModel schedulePreviewViewModel, Profile.PausedUntil.Time time, Continuation continuation) {
        super(1, continuation);
        this.f117510h = schedulePreviewViewModel;
        this.f117511i = time;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new SchedulePreviewViewModel$pauseProfileFromCard$3(this.f117510h, this.f117511i, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0185  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 418
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$pauseProfileFromCard$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((SchedulePreviewViewModel$pauseProfileFromCard$3) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
