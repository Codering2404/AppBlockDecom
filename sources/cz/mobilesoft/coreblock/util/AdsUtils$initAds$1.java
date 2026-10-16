package cz.mobilesoft.coreblock.util;

import android.content.Context;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.AdsUtils$initAds$1", f = "AdsUtils.kt", l = {80}, m = "invokeSuspend", v = 1)
final class AdsUtils$initAds$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f127696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f127697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function0 f127698c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AdsUtils$initAds$1(Context context, Function0 function0, Continuation continuation) {
        super(2, continuation);
        this.f127697b = context;
        this.f127698c = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Function0 function0, InitializationStatus initializationStatus) {
        function0.invoke();
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AdsUtils$initAds$1(this.f127697b, this.f127698c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f127696a;
        if (i3 == 0) {
            ResultKt.b(obj);
            AdsUtils adsUtils = AdsUtils.f127678i;
            MobileAds.e(adsUtils.C());
            Context context = this.f127697b;
            final Function0 function0 = this.f127698c;
            MobileAds.b(context, new OnInitializationCompleteListener() { // from class: cz.mobilesoft.coreblock.util.f
                @Override // com.google.android.gms.ads.initialization.OnInitializationCompleteListener
                public final void a(InitializationStatus initializationStatus) {
                    AdsUtils$initAds$1.q(function0, initializationStatus);
                }
            });
            Flow flowY2 = adsUtils.F().Y2();
            this.f127696a = 1;
            obj = FlowKt.D(flowY2, this);
            if (obj == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        MobileAds.d(((Boolean) obj).booleanValue());
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((AdsUtils$initAds$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
