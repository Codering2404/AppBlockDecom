package cz.mobilesoft.coreblock.scene.more.changelog.intro;

import android.content.Intent;
import android.os.Bundle;
import cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.changelog.intro.ChangelogIntroActivity$continueToNextActivity$1", f = "ChangelogIntroActivity.kt", l = {120}, m = "invokeSuspend", v = 1)
final class ChangelogIntroActivity$continueToNextActivity$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f106999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f107000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ChangelogIntroActivity f107001c;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.changelog.intro.ChangelogIntroActivity$continueToNextActivity$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.changelog.intro.ChangelogIntroActivity$continueToNextActivity$1$1", f = "ChangelogIntroActivity.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f107002a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ChangelogIntroActivity f107003b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Intent f107004c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ChangelogIntroActivity changelogIntroActivity, Intent intent, Continuation continuation) {
            super(2, continuation);
            this.f107003b = changelogIntroActivity;
            this.f107004c = intent;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f107003b, this.f107004c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f107002a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.f107003b.startActivity(this.f107004c);
            this.f107003b.finish();
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChangelogIntroActivity$continueToNextActivity$1(ChangelogIntroActivity changelogIntroActivity, Continuation continuation) {
        super(2, continuation);
        this.f107001c = changelogIntroActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ChangelogIntroActivity$continueToNextActivity$1(this.f107001c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Bundle bundle;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f107000b;
        if (i3 == 0) {
            ResultKt.b(obj);
            Intent intent = new Intent(this.f107001c, (Class<?>) DashboardActivity.class);
            Bundle extras = this.f107001c.getIntent().getExtras();
            if (extras != null && (bundle = extras.getBundle("EXTRAS")) != null) {
                intent.putExtras(bundle);
            }
            MainCoroutineDispatcher mainCoroutineDispatcherC = Dispatchers.c();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f107001c, intent, null);
            this.f106999a = SpillingKt.a(intent);
            this.f107000b = 1;
            if (BuildersKt.g(mainCoroutineDispatcherC, anonymousClass1, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ChangelogIntroActivity$continueToNextActivity$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
