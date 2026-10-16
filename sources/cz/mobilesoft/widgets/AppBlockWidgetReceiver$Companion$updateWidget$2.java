package cz.mobilesoft.widgets;

import android.util.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

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
@DebugMetadata(c = "cz.mobilesoft.widgets.AppBlockWidgetReceiver$Companion$updateWidget$2", f = "AppBlockWidgetReceiver.kt", l = {}, m = "invokeSuspend", v = 1)
final class AppBlockWidgetReceiver$Companion$updateWidget$2 extends SuspendLambda implements Function2<AppBlockWidgetState, Continuation<? super AppBlockWidgetState>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f133882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Function1 f133883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ AppBlockWidgetState f133884c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppBlockWidgetReceiver$Companion$updateWidget$2(Function1 function1, AppBlockWidgetState appBlockWidgetState, Continuation continuation) {
        super(2, continuation);
        this.f133883b = function1;
        this.f133884c = appBlockWidgetState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AppBlockWidgetReceiver$Companion$updateWidget$2(this.f133883b, this.f133884c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(AppBlockWidgetState appBlockWidgetState, Continuation continuation) {
        return ((AppBlockWidgetReceiver$Companion$updateWidget$2) create(appBlockWidgetState, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f133882a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        AppBlockWidgetState appBlockWidgetState = (AppBlockWidgetState) this.f133883b.invoke(this.f133884c);
        Log.d("AppBlockWidgetReceiver", "Updating widget with state: " + appBlockWidgetState);
        return appBlockWidgetState;
    }
}
