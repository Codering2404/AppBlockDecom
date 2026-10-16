package cz.mobilesoft.coreblock.scene.schedule.condition.launchcount;

import androidx.compose.material.ScaffoldState;
import androidx.compose.material.SnackbarData;
import androidx.compose.material.SnackbarDuration;
import androidx.compose.material.SnackbarHostState;
import androidx.compose.runtime.MutableState;
import cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.LaunchCountConditionViewCommand;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.LaunchCountConditionScreenKt$CommandProcessor$2$1", f = "LaunchCountConditionScreen.kt", l = {}, m = "invokeSuspend", v = 1)
final class LaunchCountConditionScreenKt$CommandProcessor$2$1 extends SuspendLambda implements Function2<LaunchCountConditionViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f115220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f115221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function0 f115222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ MutableState f115223d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ ScaffoldState f115224f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f115225g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ Function1 f115226h;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.LaunchCountConditionScreenKt$CommandProcessor$2$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.LaunchCountConditionScreenKt$CommandProcessor$2$1$1", f = "LaunchCountConditionScreen.kt", l = {154}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f115227a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ScaffoldState f115228b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ LaunchCountConditionViewCommand f115229c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ScaffoldState scaffoldState, LaunchCountConditionViewCommand launchCountConditionViewCommand, Continuation continuation) {
            super(2, continuation);
            this.f115228b = scaffoldState;
            this.f115229c = launchCountConditionViewCommand;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f115228b, this.f115229c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f115227a;
            if (i3 == 0) {
                ResultKt.b(obj);
                SnackbarHostState snackbarHostStateB = this.f115228b.b();
                String strA = ((LaunchCountConditionViewCommand.ShowSnackbar) this.f115229c).a();
                SnackbarDuration snackbarDuration = SnackbarDuration.Short;
                this.f115227a = 1;
                if (SnackbarHostState.e(snackbarHostStateB, strA, null, snackbarDuration, this, 2, null) == objF) {
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
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LaunchCountConditionScreenKt$CommandProcessor$2$1(Function0 function0, MutableState mutableState, ScaffoldState scaffoldState, CoroutineScope coroutineScope, Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.f115222c = function0;
        this.f115223d = mutableState;
        this.f115224f = scaffoldState;
        this.f115225g = coroutineScope;
        this.f115226h = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        LaunchCountConditionScreenKt$CommandProcessor$2$1 launchCountConditionScreenKt$CommandProcessor$2$1 = new LaunchCountConditionScreenKt$CommandProcessor$2$1(this.f115222c, this.f115223d, this.f115224f, this.f115225g, this.f115226h, continuation);
        launchCountConditionScreenKt$CommandProcessor$2$1.f115221b = obj;
        return launchCountConditionScreenKt$CommandProcessor$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(LaunchCountConditionViewCommand launchCountConditionViewCommand, Continuation continuation) {
        return ((LaunchCountConditionScreenKt$CommandProcessor$2$1) create(launchCountConditionViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        LaunchCountConditionViewCommand launchCountConditionViewCommand = (LaunchCountConditionViewCommand) this.f115221b;
        IntrinsicsKt.f();
        if (this.f115220a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (Intrinsics.areEqual(launchCountConditionViewCommand, LaunchCountConditionViewCommand.CloseScreen.f115230a)) {
            this.f115222c.invoke();
        } else if (Intrinsics.areEqual(launchCountConditionViewCommand, LaunchCountConditionViewCommand.ShowUnsavedChangesDialog.f115233a)) {
            this.f115223d.setValue(Boxing.a(true));
        } else if (launchCountConditionViewCommand instanceof LaunchCountConditionViewCommand.ShowSnackbar) {
            SnackbarData snackbarDataB = this.f115224f.b().b();
            if (snackbarDataB != null) {
                snackbarDataB.dismiss();
            }
            BuildersKt__Builders_commonKt.d(this.f115225g, null, null, new AnonymousClass1(this.f115224f, launchCountConditionViewCommand, null), 3, null);
        } else {
            if (!(launchCountConditionViewCommand instanceof LaunchCountConditionViewCommand.SaveChanges)) {
                throw new NoWhenBranchMatchedException();
            }
            this.f115226h.invoke(((LaunchCountConditionViewCommand.SaveChanges) launchCountConditionViewCommand).a());
        }
        return Unit.f139807a;
    }
}
