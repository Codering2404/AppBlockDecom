package cz.mobilesoft.appblock.util;

import android.content.Context;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.koin.java.KoinJavaComponent;

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
@DebugMetadata(c = "cz.mobilesoft.appblock.util.NotificationHelper$showProfileEndNotification$2", f = "NotificationHelper.kt", l = {74}, m = "invokeSuspend", v = 1)
final class NotificationHelper$showProfileEndNotification$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f95118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f95119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f95120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Context f95121d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ long f95122f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ boolean f95123g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ boolean f95124h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ boolean f95125i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NotificationHelper$showProfileEndNotification$2(long j3, Context context, long j4, boolean z2, boolean z3, boolean z4, Continuation continuation) {
        super(2, continuation);
        this.f95120c = j3;
        this.f95121d = context;
        this.f95122f = j4;
        this.f95123g = z2;
        this.f95124h = z3;
        this.f95125i = z4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new NotificationHelper$showProfileEndNotification$2(this.f95120c, this.f95121d, this.f95122f, this.f95123g, this.f95124h, this.f95125i, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f95119b;
        if (i3 == 0) {
            ResultKt.b(obj);
            ProfileDao profileDao = (ProfileDao) KoinJavaComponent.c(ProfileDao.class, null, null, 6, null);
            long j3 = this.f95120c;
            this.f95118a = profileDao;
            this.f95119b = 1;
            obj = profileDao.e(j3, this);
            if (obj == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        Profile profile = (Profile) obj;
        if (profile == null) {
            return null;
        }
        NotificationHelper.f95109a.e(this.f95121d, profile, this.f95122f, this.f95123g, this.f95124h, this.f95125i);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((NotificationHelper$showProfileEndNotification$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
