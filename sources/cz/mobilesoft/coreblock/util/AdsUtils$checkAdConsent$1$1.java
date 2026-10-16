package cz.mobilesoft.coreblock.util;

import android.app.Activity;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.google.android.ump.ConsentInformation;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.AdsUtils$checkAdConsent$1$1", f = "AdsUtils.kt", l = {113, 119, 124}, m = "invokeSuspend", v = 1)
final class AdsUtils$checkAdConsent$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f127682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f127683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f127684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ConsentInformation f127685d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Activity f127686f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Function1 f127687g;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.util.AdsUtils$checkAdConsent$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.util.AdsUtils$checkAdConsent$1$1$1", f = "AdsUtils.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f127688a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1 f127689b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f127690c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Function1 function1, int i3, Continuation continuation) {
            super(2, continuation);
            this.f127689b = function1;
            this.f127690c = i3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f127689b, this.f127690c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f127688a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.f127689b.invoke(Boxing.d(this.f127690c));
            FacebookSdk.setAdvertiserIDCollectionEnabled(true);
            AdsUtils adsUtils = AdsUtils.f127678i;
            String simpleName = AdsUtils.class.getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
            Log.d(simpleName, "onConsentInfoUpdateSuccess, is obtained");
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.util.AdsUtils$checkAdConsent$1$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.util.AdsUtils$checkAdConsent$1$1$2", f = "AdsUtils.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f127691a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f127692b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ConsentInformation f127693c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1 f127694d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(int i3, ConsentInformation consentInformation, Function1 function1, Continuation continuation) {
            super(2, continuation);
            this.f127692b = i3;
            this.f127693c = consentInformation;
            this.f127694d = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.f127692b, this.f127693c, this.f127694d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f127691a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            FacebookSdk.setAdvertiserIDCollectionEnabled(this.f127692b == 1);
            if (this.f127692b != 2 || !this.f127693c.isConsentFormAvailable()) {
                this.f127694d.invoke(Boxing.d(this.f127692b));
                AdsUtils adsUtils = AdsUtils.f127678i;
                String str = "onConsentInfoUpdateSuccess, is code " + this.f127692b;
                String simpleName = AdsUtils.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                Log.d(simpleName, str);
            } else if (PrefManager.f126839a.K0() < 5) {
                this.f127694d.invoke(Boxing.d(3));
                AdsUtils adsUtils2 = AdsUtils.f127678i;
                String simpleName2 = AdsUtils.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName2, "getSimpleName(...)");
                Log.d(simpleName2, "onConsentInfoUpdateSuccess, is required, but too few launches, setting to obtained");
            } else {
                this.f127694d.invoke(Boxing.d(this.f127692b));
                AdsUtils adsUtils3 = AdsUtils.f127678i;
                String simpleName3 = AdsUtils.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName3, "getSimpleName(...)");
                Log.d(simpleName3, "onConsentInfoUpdateSuccess, is required");
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AdsUtils$checkAdConsent$1$1(ConsentInformation consentInformation, Activity activity, Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.f127685d = consentInformation;
        this.f127686f = activity;
        this.f127687g = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AdsUtils$checkAdConsent$1$1(this.f127685d, this.f127686f, this.f127687g, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x008f, code lost:
    
        if (kotlinx.coroutines.BuildersKt.g(r12, r3, r11) == r0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c8, code lost:
    
        if (kotlinx.coroutines.BuildersKt.g(r12, r2, r11) == r0) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0092  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.AdsUtils$checkAdConsent$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((AdsUtils$checkAdConsent$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
