package cz.mobilesoft.coreblock;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.MainActivity$signInLauncher$1$1", f = "MainActivity.kt", l = {107}, m = "invokeSuspend", v = 1)
final class MainActivity$signInLauncher$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f95414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ActivityResult f95415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MainActivity f95416c;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.MainActivity$signInLauncher$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.MainActivity$signInLauncher$1$1$1", f = "MainActivity.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f95417a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ActivityResult f95418b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MainActivity f95419c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ActivityResult activityResult, MainActivity mainActivity, Continuation continuation) {
            super(2, continuation);
            this.f95418b = activityResult;
            this.f95419c = mainActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f95418b, this.f95419c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f95417a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            if (this.f95418b.d() == -1) {
                Intent intent = new Intent(this.f95419c, (Class<?>) DashboardActivity.class);
                intent.putExtra("SHOW_OREO_NOTIFICATION_DIALOG", this.f95419c.f95373x);
                intent.putExtra("OPEN_BLOCK_NOTIFICATIONS", this.f95419c.f95374y);
                intent.putExtra("OPEN_CHANGELOG", this.f95419c.f95375z);
                intent.putExtra("STATISTICS_INTERVAL", this.f95419c.A);
                intent.putExtra("IS_TILE_SERVICE", this.f95419c.B);
                String str = this.f95419c.E;
                if (str != null) {
                    intent.putExtra("SHORTCUT_ACTION", str);
                }
                intent.addFlags(603979776);
                this.f95419c.startActivity(intent);
            }
            this.f95419c.finish();
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$signInLauncher$1$1(ActivityResult activityResult, MainActivity mainActivity, Continuation continuation) {
        super(2, continuation);
        this.f95415b = activityResult;
        this.f95416c = mainActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new MainActivity$signInLauncher$1$1(this.f95415b, this.f95416c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f95414a;
        if (i3 == 0) {
            ResultKt.b(obj);
            MainCoroutineDispatcher mainCoroutineDispatcherC = Dispatchers.c();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f95415b, this.f95416c, null);
            this.f95414a = 1;
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
        return ((MainActivity$signInLauncher$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
