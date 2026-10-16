package cz.mobilesoft.coreblock.scene.onboarding;

import android.content.Context;
import android.content.Intent;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.compose.runtime.MutableState;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import cz.mobilesoft.coreblock.scene.onboarding.OnboardingActivityV2;
import cz.mobilesoft.coreblock.scene.premium.utils.IntroPremiumScreenHelperKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.onboarding.OnboardingActivityV2$NavigationHost$1$1$15$1$1$1", f = "OnboardingActivityV2.kt", l = {465}, m = "invokeSuspend", v = 1)
final class OnboardingActivityV2$NavigationHost$1$1$15$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f110903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f110904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private /* synthetic */ Object f110905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ OnboardingViewStateV2 f110906d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MutableState f110907f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ OnboardingActivityV2 f110908g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ ManagedActivityResultLauncher f110909h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ NavHostController f110910i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OnboardingActivityV2$NavigationHost$1$1$15$1$1$1(OnboardingViewStateV2 onboardingViewStateV2, MutableState mutableState, OnboardingActivityV2 onboardingActivityV2, ManagedActivityResultLauncher managedActivityResultLauncher, NavHostController navHostController, Continuation continuation) {
        super(2, continuation);
        this.f110906d = onboardingViewStateV2;
        this.f110907f = mutableState;
        this.f110908g = onboardingActivityV2;
        this.f110909h = managedActivityResultLauncher;
        this.f110910i = navHostController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        OnboardingActivityV2$NavigationHost$1$1$15$1$1$1 onboardingActivityV2$NavigationHost$1$1$15$1$1$1 = new OnboardingActivityV2$NavigationHost$1$1$15$1$1$1(this.f110906d, this.f110907f, this.f110908g, this.f110909h, this.f110910i, continuation);
        onboardingActivityV2$NavigationHost$1$1$15$1$1$1.f110905c = obj;
        return onboardingActivityV2$NavigationHost$1$1$15$1$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        OnboardingActivityV2$NavigationHost$1$1$15$1$1$1 onboardingActivityV2$NavigationHost$1$1$15$1$1$1;
        String str;
        CoroutineScope coroutineScope = (CoroutineScope) this.f110905c;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f110904b;
        if (i3 == 0) {
            ResultKt.b(obj);
            String strT = this.f110906d.t(OnboardingActivityV2.OnboardingNavItem.AppBlockCanHelpYou.getRoute());
            this.f110907f.setValue(strT);
            Context applicationContext = this.f110908g.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            boolean zN = this.f110906d.n();
            this.f110905c = coroutineScope;
            this.f110903a = strT;
            this.f110904b = 1;
            onboardingActivityV2$NavigationHost$1$1$15$1$1$1 = this;
            Object objC = IntroPremiumScreenHelperKt.c(applicationContext, null, true, zN, true, onboardingActivityV2$NavigationHost$1$1$15$1$1$1, 1, null);
            if (objC == objF) {
                return objF;
            }
            str = strT;
            obj = objC;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String str2 = (String) this.f110903a;
            ResultKt.b(obj);
            onboardingActivityV2$NavigationHost$1$1$15$1$1$1 = this;
            str = str2;
        }
        Intent intent = (Intent) obj;
        if (intent != null) {
            onboardingActivityV2$NavigationHost$1$1$15$1$1$1.f110909h.b(intent);
        } else {
            MutableState mutableState = onboardingActivityV2$NavigationHost$1$1$15$1$1$1.f110907f;
            NavHostController navHostController = onboardingActivityV2$NavigationHost$1$1$15$1$1$1.f110910i;
            mutableState.setValue(null);
            NavController.P(navHostController, str, null, null, 6, null);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((OnboardingActivityV2$NavigationHost$1$1$15$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
