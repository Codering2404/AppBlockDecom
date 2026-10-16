package cz.mobilesoft.appblock.service;

import android.content.Intent;
import cz.mobilesoft.appblock.util.ServiceHelper;
import cz.mobilesoft.coreblock.scene.feedback.backdoorcode.BackdoorFeedbackActivity;
import cz.mobilesoft.coreblock.util.CrashHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.appblock.service.OverlayServiceV2$finish$4", f = "OverlayServiceV2.kt", l = {}, m = "invokeSuspend", v = 1)
final class OverlayServiceV2$finish$4 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f94684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ OverlayServiceV2 f94685b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OverlayServiceV2$finish$4(OverlayServiceV2 overlayServiceV2, Continuation continuation) {
        super(1, continuation);
        this.f94685b = overlayServiceV2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new OverlayServiceV2$finish$4(this.f94685b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f94684a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        try {
            ServiceHelper.f95139a.b(this.f94685b);
            Intent intent = new Intent(this.f94685b, (Class<?>) BackdoorFeedbackActivity.class);
            intent.setFlags(335544320);
            this.f94685b.startActivity(intent);
        } catch (Exception e3) {
            CrashHelper.j(e3);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((OverlayServiceV2$finish$4) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
