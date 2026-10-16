package cz.mobilesoft.coreblock.scene.premium.components;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import cz.mobilesoft.coreblock.scene.premium.utils.IntroPremiumScreenHelperKt;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.premium.components.PremiumOffersLayoutKt$RestorePurchaseContent$1$launcher$1$1$1", f = "PremiumOffersLayout.kt", l = {327}, m = "invokeSuspend", v = 1)
final class PremiumOffersLayoutKt$RestorePurchaseContent$1$launcher$1$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f112574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f112575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f112576c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PremiumOffersLayoutKt$RestorePurchaseContent$1$launcher$1$1$1(Context context, Continuation continuation) {
        super(1, continuation);
        this.f112576c = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new PremiumOffersLayoutKt$RestorePurchaseContent$1$launcher$1$1$1(this.f112576c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Activity activityB;
        Intent intent;
        Activity activity;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f112575b;
        if (i3 == 0) {
            ResultKt.b(obj);
            activityB = ContextExtKt.b(this.f112576c);
            if (activityB == null) {
                intent = null;
                if (intent == null && activityB != null) {
                    activityB.finish();
                }
                return Unit.f139807a;
            }
            this.f112574a = activityB;
            this.f112575b = 1;
            obj = IntroPremiumScreenHelperKt.c(activityB, null, true, false, false, this, 13, null);
            if (obj == objF) {
                return objF;
            }
            activity = activityB;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            activity = (Activity) this.f112574a;
            ResultKt.b(obj);
        }
        intent = (Intent) obj;
        activityB = activity;
        if (intent == null) {
            activityB.finish();
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((PremiumOffersLayoutKt$RestorePurchaseContent$1$launcher$1$1$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
