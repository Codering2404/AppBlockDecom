package cz.mobilesoft.coreblock.scene.onboarding;

import android.content.Context;
import android.content.Intent;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.compose.runtime.MutableState;
import cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewEventV2;
import cz.mobilesoft.coreblock.scene.premium.utils.IntroPremiumScreenHelperKt;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.onboarding.OnboardingActivityV2$NavigationHost$1$1$4$4$1$1", f = "OnboardingActivityV2.kt", l = {346}, m = "invokeSuspend", v = 1)
final class OnboardingActivityV2$NavigationHost$1$1$4$4$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f110911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f110912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ MutableState f110913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ OnboardingActivityV2 f110914d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ ManagedActivityResultLauncher f110915f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Function1 f110916g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OnboardingActivityV2$NavigationHost$1$1$4$4$1$1(MutableState mutableState, OnboardingActivityV2 onboardingActivityV2, ManagedActivityResultLauncher managedActivityResultLauncher, Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.f110913c = mutableState;
        this.f110914d = onboardingActivityV2;
        this.f110915f = managedActivityResultLauncher;
        this.f110916g = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        OnboardingActivityV2$NavigationHost$1$1$4$4$1$1 onboardingActivityV2$NavigationHost$1$1$4$4$1$1 = new OnboardingActivityV2$NavigationHost$1$1$4$4$1$1(this.f110913c, this.f110914d, this.f110915f, this.f110916g, continuation);
        onboardingActivityV2$NavigationHost$1$1$4$4$1$1.f110912b = obj;
        return onboardingActivityV2$NavigationHost$1$1$4$4$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        OnboardingActivityV2$NavigationHost$1$1$4$4$1$1 onboardingActivityV2$NavigationHost$1$1$4$4$1$1;
        CoroutineScope coroutineScope = (CoroutineScope) this.f110912b;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f110911a;
        if (i3 == 0) {
            ResultKt.b(obj);
            AnswersHelper.f128199a.Y2();
            this.f110913c.setValue(Boxing.a(true));
            Context applicationContext = this.f110914d.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            this.f110912b = coroutineScope;
            this.f110911a = 1;
            onboardingActivityV2$NavigationHost$1$1$4$4$1$1 = this;
            obj = IntroPremiumScreenHelperKt.c(applicationContext, null, true, false, true, onboardingActivityV2$NavigationHost$1$1$4$4$1$1, 5, null);
            if (obj == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            onboardingActivityV2$NavigationHost$1$1$4$4$1$1 = this;
        }
        Intent intent = (Intent) obj;
        if (intent != null) {
            onboardingActivityV2$NavigationHost$1$1$4$4$1$1.f110915f.b(intent);
        } else {
            onboardingActivityV2$NavigationHost$1$1$4$4$1$1.f110916g.invoke(OnboardingViewEventV2.OnOnboardingSkipped.f110939a);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((OnboardingActivityV2$NavigationHost$1$1$4$4$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
