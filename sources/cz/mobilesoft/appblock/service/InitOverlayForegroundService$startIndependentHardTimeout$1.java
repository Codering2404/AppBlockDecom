package cz.mobilesoft.appblock.service;

import android.util.Log;
import com.facebook.share.HKJ.pnxuebdT;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

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
@DebugMetadata(c = "cz.mobilesoft.appblock.service.InitOverlayForegroundService$startIndependentHardTimeout$1", f = "InitOverlayForegroundService.kt", l = {597}, m = "invokeSuspend", v = 1)
final class InitOverlayForegroundService$startIndependentHardTimeout$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f94181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ InitOverlayForegroundService f94182b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitOverlayForegroundService$startIndependentHardTimeout$1(InitOverlayForegroundService initOverlayForegroundService, Continuation continuation) {
        super(2, continuation);
        this.f94182b = initOverlayForegroundService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new InitOverlayForegroundService$startIndependentHardTimeout$1(this.f94182b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((InitOverlayForegroundService$startIndependentHardTimeout$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f94181a;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException(pnxuebdT.PrTURYHyk);
            }
        } else {
            ResultKt.b(obj);
            this.f94181a = 1;
            if (DelayKt.b(300000L, this) == objF) {
                return objF;
            }
        }
        Log.w("InitOverlayService", "initOverlayService hardTimeout reached -> stopping overlay");
        this.f94182b.D("independent_hard_timeout");
        return Unit.f139807a;
    }
}
