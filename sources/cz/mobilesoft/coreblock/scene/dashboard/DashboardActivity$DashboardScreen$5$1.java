package cz.mobilesoft.coreblock.scene.dashboard;

import android.app.Activity;
import android.content.Context;
import android.view.Window;
import androidx.compose.runtime.MutableState;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$DashboardScreen$5$1", f = "DashboardActivity.kt", l = {}, m = "invokeSuspend", v = 1)
final class DashboardActivity$DashboardScreen$5$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f99158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f99159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ MutableState f99160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f99161d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f99162f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DashboardActivity$DashboardScreen$5$1(Context context, MutableState mutableState, int i3, int i4, Continuation continuation) {
        super(2, continuation);
        this.f99159b = context;
        this.f99160c = mutableState;
        this.f99161d = i3;
        this.f99162f = i4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DashboardActivity$DashboardScreen$5$1(this.f99159b, this.f99160c, this.f99161d, this.f99162f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f99158a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        Context context = this.f99159b;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        Window window = ((Activity) context).getWindow();
        if (((Boolean) this.f99160c.getValue()).booleanValue()) {
            AnswersHelper.f128199a.L7();
            window.setNavigationBarColor(this.f99161d);
        } else {
            window.setNavigationBarColor(this.f99162f);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DashboardActivity$DashboardScreen$5$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
