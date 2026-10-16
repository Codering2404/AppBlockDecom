package cz.mobilesoft.coreblock.scene.more.settings.icon_select;

import android.content.Context;
import androidx.compose.runtime.MutableState;
import cz.mobilesoft.coreblock.scene.more.settings.icon_select.AppIconSelectViewCommand;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.icon_select.AppIconSelectActivity$CommandProcessor$1$1", f = "AppIconSelectActivity.kt", l = {}, m = "invokeSuspend", v = 1)
final class AppIconSelectActivity$CommandProcessor$1$1 extends SuspendLambda implements Function2<AppIconSelectViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f109894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f109895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ AppIconSelectActivity f109896c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Context f109897d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MutableState f109898f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppIconSelectActivity$CommandProcessor$1$1(AppIconSelectActivity appIconSelectActivity, Context context, MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.f109896c = appIconSelectActivity;
        this.f109897d = context;
        this.f109898f = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        AppIconSelectActivity$CommandProcessor$1$1 appIconSelectActivity$CommandProcessor$1$1 = new AppIconSelectActivity$CommandProcessor$1$1(this.f109896c, this.f109897d, this.f109898f, continuation);
        appIconSelectActivity$CommandProcessor$1$1.f109895b = obj;
        return appIconSelectActivity$CommandProcessor$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(AppIconSelectViewCommand appIconSelectViewCommand, Continuation continuation) {
        return ((AppIconSelectActivity$CommandProcessor$1$1) create(appIconSelectViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        AppIconSelectViewCommand appIconSelectViewCommand = (AppIconSelectViewCommand) this.f109895b;
        IntrinsicsKt.f();
        if (this.f109894a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (Intrinsics.areEqual(appIconSelectViewCommand, AppIconSelectViewCommand.ShowPremiumScreen.f109899a)) {
            this.f109896c.startActivity(Paywall.c(Paywall.f113165a, this.f109897d, PaywallTarget.Generic.INSTANCE, "profile_tab", "alternative_app_icon", false, false, false, null, 240, null));
        } else {
            if (!Intrinsics.areEqual(appIconSelectViewCommand, AppIconSelectViewCommand.ShowRestartDialog.f109900a)) {
                throw new NoWhenBranchMatchedException();
            }
            this.f109898f.setValue(Boxing.a(true));
        }
        return Unit.f139807a;
    }
}
