package cz.mobilesoft.appblock.service;

import android.content.Context;
import android.content.Intent;
import androidx.compose.runtime.MutableState;
import cz.mobilesoft.coreblock.scene.lockscreen.LockViewModel;
import cz.mobilesoft.coreblock.scene.lockscreen.LockViewState;
import cz.mobilesoft.coreblock.scene.lockscreen.ossettings.SystemSettingsActivity;
import cz.mobilesoft.coreblock.scene.lockscreen.ossettings.SystemSettingsBottomSheetDialog;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
@DebugMetadata(c = "cz.mobilesoft.appblock.service.OverlayServiceV2$LockScreen$4$1", f = "OverlayServiceV2.kt", l = {}, m = "invokeSuspend", v = 1)
final class OverlayServiceV2$LockScreen$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f94667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ MutableState f94668b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ OverlayServiceV2 f94669c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ LockViewState f94670d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ LockViewModel f94671f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OverlayServiceV2$LockScreen$4$1(MutableState mutableState, OverlayServiceV2 overlayServiceV2, LockViewState lockViewState, LockViewModel lockViewModel, Continuation continuation) {
        super(2, continuation);
        this.f94668b = mutableState;
        this.f94669c = overlayServiceV2;
        this.f94670d = lockViewState;
        this.f94671f = lockViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(OverlayServiceV2 overlayServiceV2, LockViewModel lockViewModel, MutableState mutableState, Intent intent) {
        SystemSettingsActivity.Companion companion = SystemSettingsActivity.f105722p;
        Context applicationContext = overlayServiceV2.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        overlayServiceV2.startActivity(companion.a(applicationContext, intent, (String[]) lockViewModel.X0().toArray(new String[0])));
        mutableState.setValue(Boolean.FALSE);
        OverlayServiceV2.K(overlayServiceV2, lockViewModel.Z0(), true, null, false, false, false, 60, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new OverlayServiceV2$LockScreen$4$1(this.f94668b, this.f94669c, this.f94670d, this.f94671f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f94667a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (((Boolean) this.f94668b.getValue()).booleanValue()) {
            Context applicationContext = this.f94669c.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            Set setS = this.f94670d.s();
            final OverlayServiceV2 overlayServiceV2 = this.f94669c;
            final LockViewModel lockViewModel = this.f94671f;
            final MutableState mutableState = this.f94668b;
            Function1 function1 = new Function1() { // from class: cz.mobilesoft.appblock.service.s1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return OverlayServiceV2$LockScreen$4$1.y(overlayServiceV2, lockViewModel, mutableState, (Intent) obj2);
                }
            };
            final MutableState mutableState2 = this.f94668b;
            new SystemSettingsBottomSheetDialog(applicationContext, setS, function1, new Function0() { // from class: cz.mobilesoft.appblock.service.t1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return OverlayServiceV2$LockScreen$4$1.z(mutableState2);
                }
            }).f();
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((OverlayServiceV2$LockScreen$4$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
