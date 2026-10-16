package cz.mobilesoft.coreblock.scene.more.settings.generalSettings;

import android.content.Context;
import android.content.Intent;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.compose.runtime.MutableState;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsScreenKt$GeneralSettingsScreen$1$2$1$generalSettings$3$1$1", f = "GeneralSettingsScreen.kt", l = {152, 159}, m = "invokeSuspend", v = 1)
final class GeneralSettingsScreenKt$GeneralSettingsScreen$1$2$1$generalSettings$3$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f109699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f109700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ GeneralSettingsViewState f109701c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Context f109702d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ ManagedActivityResultLauncher f109703f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ MutableState f109704g;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsScreenKt$GeneralSettingsScreen$1$2$1$generalSettings$3$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsScreenKt$GeneralSettingsScreen$1$2$1$generalSettings$3$1$1$1", f = "GeneralSettingsScreen.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f109705a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ManagedActivityResultLauncher f109706b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Intent f109707c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ MutableState f109708d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ManagedActivityResultLauncher managedActivityResultLauncher, Intent intent, MutableState mutableState, Continuation continuation) {
            super(2, continuation);
            this.f109706b = managedActivityResultLauncher;
            this.f109707c = intent;
            this.f109708d = mutableState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f109706b, this.f109707c, this.f109708d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f109705a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            GeneralSettingsScreenKt.C(this.f109708d, false);
            ContextExtKt.g(this.f109706b, this.f109707c);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsScreenKt$GeneralSettingsScreen$1$2$1$generalSettings$3$1$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsScreenKt$GeneralSettingsScreen$1$2$1$generalSettings$3$1$1$2", f = "GeneralSettingsScreen.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f109709a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ManagedActivityResultLauncher f109710b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Intent f109711c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ MutableState f109712d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ManagedActivityResultLauncher managedActivityResultLauncher, Intent intent, MutableState mutableState, Continuation continuation) {
            super(2, continuation);
            this.f109710b = managedActivityResultLauncher;
            this.f109711c = intent;
            this.f109712d = mutableState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.f109710b, this.f109711c, this.f109712d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f109709a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            GeneralSettingsScreenKt.C(this.f109712d, true);
            ContextExtKt.g(this.f109710b, this.f109711c);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GeneralSettingsScreenKt$GeneralSettingsScreen$1$2$1$generalSettings$3$1$1(GeneralSettingsViewState generalSettingsViewState, Context context, ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState, Continuation continuation) {
        super(1, continuation);
        this.f109701c = generalSettingsViewState;
        this.f109702d = context;
        this.f109703f = managedActivityResultLauncher;
        this.f109704g = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new GeneralSettingsScreenKt$GeneralSettingsScreen$1$2$1$generalSettings$3$1$1(this.f109701c, this.f109702d, this.f109703f, this.f109704g, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0053, code lost:
    
        if (kotlinx.coroutines.BuildersKt.g(r2, r4, r7) == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x007e, code lost:
    
        if (kotlinx.coroutines.BuildersKt.g(r3, r4, r7) == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0080, code lost:
    
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r7.f109700b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1f
            if (r1 == r3) goto L17
            if (r1 != r2) goto Lf
            goto L17
        Lf:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L17:
            java.lang.Object r0 = r7.f109699a
            android.content.Intent r0 = (android.content.Intent) r0
            kotlin.ResultKt.b(r8)
            goto L81
        L1f:
            kotlin.ResultKt.b(r8)
            cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewState r8 = r7.f109701c
            boolean r8 = r8.p()
            r1 = 0
            if (r8 == 0) goto L56
            cz.mobilesoft.coreblock.util.analytics.AnswersHelper r8 = cz.mobilesoft.coreblock.util.analytics.AnswersHelper.f128199a
            r8.s6()
            cz.mobilesoft.coreblock.scene.password.PassCodeActivity$Companion r8 = cz.mobilesoft.coreblock.scene.password.PassCodeActivity.f111670f
            android.content.Context r2 = r7.f109702d
            cz.mobilesoft.coreblock.scene.password.PassCodeType r4 = cz.mobilesoft.coreblock.scene.password.PassCodeType.Remove
            android.content.Intent r8 = r8.a(r2, r4)
            kotlinx.coroutines.MainCoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.c()
            cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsScreenKt$GeneralSettingsScreen$1$2$1$generalSettings$3$1$1$1 r4 = new cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsScreenKt$GeneralSettingsScreen$1$2$1$generalSettings$3$1$1$1
            androidx.activity.compose.ManagedActivityResultLauncher r5 = r7.f109703f
            androidx.compose.runtime.MutableState r6 = r7.f109704g
            r4.<init>(r5, r8, r6, r1)
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
            r7.f109699a = r8
            r7.f109700b = r3
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.g(r2, r4, r7)
            if (r8 != r0) goto L81
            goto L80
        L56:
            cz.mobilesoft.coreblock.util.analytics.AnswersHelper r8 = cz.mobilesoft.coreblock.util.analytics.AnswersHelper.f128199a
            r8.u6()
            cz.mobilesoft.coreblock.scene.password.PassCodeActivity$Companion r8 = cz.mobilesoft.coreblock.scene.password.PassCodeActivity.f111670f
            android.content.Context r3 = r7.f109702d
            cz.mobilesoft.coreblock.scene.password.PassCodeType r4 = cz.mobilesoft.coreblock.scene.password.PassCodeType.Create
            android.content.Intent r8 = r8.a(r3, r4)
            kotlinx.coroutines.MainCoroutineDispatcher r3 = kotlinx.coroutines.Dispatchers.c()
            cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsScreenKt$GeneralSettingsScreen$1$2$1$generalSettings$3$1$1$2 r4 = new cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsScreenKt$GeneralSettingsScreen$1$2$1$generalSettings$3$1$1$2
            androidx.activity.compose.ManagedActivityResultLauncher r5 = r7.f109703f
            androidx.compose.runtime.MutableState r6 = r7.f109704g
            r4.<init>(r5, r8, r6, r1)
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
            r7.f109699a = r8
            r7.f109700b = r2
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.g(r3, r4, r7)
            if (r8 != r0) goto L81
        L80:
            return r0
        L81:
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsScreenKt$GeneralSettingsScreen$1$2$1$generalSettings$3$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((GeneralSettingsScreenKt$GeneralSettingsScreen$1$2$1$generalSettings$3$1$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
