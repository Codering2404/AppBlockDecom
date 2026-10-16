package cz.mobilesoft.coreblock.util;

import android.content.Context;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.runnability.ProcessNameHelper;
import java.util.Locale;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.FlavoredInitHelper$initializeAnalytics$1", f = "FlavoredInitHelper.kt", l = {}, m = "invokeSuspend", v = 1)
final class FlavoredInitHelper$initializeAnalytics$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f127874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f127875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f127876c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f127877d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlavoredInitHelper$initializeAnalytics$1(Context context, String str, Continuation continuation) {
        super(2, continuation);
        this.f127876c = context;
        this.f127877d = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        FlavoredInitHelper$initializeAnalytics$1 flavoredInitHelper$initializeAnalytics$1 = new FlavoredInitHelper$initializeAnalytics$1(this.f127876c, this.f127877d, continuation);
        flavoredInitHelper$initializeAnalytics$1.f127875b = obj;
        return flavoredInitHelper$initializeAnalytics$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        String installerPackageName;
        IntrinsicsKt.f();
        if (this.f127874a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        FirebaseCrashlytics firebaseCrashlyticsC = null;
        try {
            installerPackageName = this.f127876c.getPackageManager().getInstallerPackageName(this.f127876c.getPackageName());
        } catch (Exception e3) {
            e3.printStackTrace();
            installerPackageName = null;
        }
        String simpleName = CoroutineScope.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        Log.i(simpleName, "Installer package name: " + installerPackageName);
        boolean zB = FlavoredInitHelper.f127873a.b(installerPackageName);
        try {
            FirebaseApp.s(this.f127876c);
        } catch (IllegalStateException e4) {
            e4.printStackTrace();
        }
        try {
            firebaseCrashlyticsC = FirebaseCrashlytics.c();
        } catch (Exception unused) {
        }
        if (!zB && firebaseCrashlyticsC != null) {
            firebaseCrashlyticsC.g(false);
        }
        if (firebaseCrashlyticsC != null) {
            firebaseCrashlyticsC.i("locale", Locale.getDefault().getCountry());
        }
        if (firebaseCrashlyticsC != null) {
            String str = this.f127877d;
            String packageName = this.f127876c.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
            firebaseCrashlyticsC.i("process", ProcessNameHelper.a(str, packageName));
        }
        AnswersHelper.f128199a.u(this.f127876c, installerPackageName);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((FlavoredInitHelper$initializeAnalytics$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
