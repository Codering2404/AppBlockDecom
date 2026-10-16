package cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit;

import androidx.compose.material.ScaffoldState;
import androidx.compose.material.SnackbarData;
import androidx.compose.material.SnackbarDuration;
import androidx.compose.material.SnackbarHostState;
import androidx.compose.runtime.MutableState;
import cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitConditionViewCommand;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitConditionScreenKt$CommandProcessor$2$1", f = "UsageLimitConditionScreen.kt", l = {}, m = "invokeSuspend", v = 1)
final class UsageLimitConditionScreenKt$CommandProcessor$2$1 extends SuspendLambda implements Function2<UsageLimitConditionViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f115867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f115868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function0 f115869c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ MutableState f115870d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ ScaffoldState f115871f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f115872g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ Function1 f115873h;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitConditionScreenKt$CommandProcessor$2$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitConditionScreenKt$CommandProcessor$2$1$1", f = "UsageLimitConditionScreen.kt", l = {156}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f115874a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ScaffoldState f115875b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ UsageLimitConditionViewCommand f115876c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ScaffoldState scaffoldState, UsageLimitConditionViewCommand usageLimitConditionViewCommand, Continuation continuation) {
            super(2, continuation);
            this.f115875b = scaffoldState;
            this.f115876c = usageLimitConditionViewCommand;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f115875b, this.f115876c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f115874a;
            if (i3 == 0) {
                ResultKt.b(obj);
                SnackbarHostState snackbarHostStateB = this.f115875b.b();
                String strA = ((UsageLimitConditionViewCommand.ShowSnackbar) this.f115876c).a();
                SnackbarDuration snackbarDuration = SnackbarDuration.Short;
                this.f115874a = 1;
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
    UsageLimitConditionScreenKt$CommandProcessor$2$1(Function0 function0, MutableState mutableState, ScaffoldState scaffoldState, CoroutineScope coroutineScope, Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.f115869c = function0;
        this.f115870d = mutableState;
        this.f115871f = scaffoldState;
        this.f115872g = coroutineScope;
        this.f115873h = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        UsageLimitConditionScreenKt$CommandProcessor$2$1 usageLimitConditionScreenKt$CommandProcessor$2$1 = new UsageLimitConditionScreenKt$CommandProcessor$2$1(this.f115869c, this.f115870d, this.f115871f, this.f115872g, this.f115873h, continuation);
        usageLimitConditionScreenKt$CommandProcessor$2$1.f115868b = obj;
        return usageLimitConditionScreenKt$CommandProcessor$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(UsageLimitConditionViewCommand usageLimitConditionViewCommand, Continuation continuation) {
        return ((UsageLimitConditionScreenKt$CommandProcessor$2$1) create(usageLimitConditionViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        UsageLimitConditionViewCommand usageLimitConditionViewCommand = (UsageLimitConditionViewCommand) this.f115868b;
        IntrinsicsKt.f();
        if (this.f115867a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (Intrinsics.areEqual(usageLimitConditionViewCommand, UsageLimitConditionViewCommand.CloseScreen.f115877a)) {
            this.f115869c.invoke();
        } else if (Intrinsics.areEqual(usageLimitConditionViewCommand, UsageLimitConditionViewCommand.ShowUnsavedChangesDialog.f115880a)) {
            this.f115870d.setValue(Boxing.a(true));
        } else if (usageLimitConditionViewCommand instanceof UsageLimitConditionViewCommand.ShowSnackbar) {
            SnackbarData snackbarDataB = this.f115871f.b().b();
            if (snackbarDataB != null) {
                snackbarDataB.dismiss();
            }
            BuildersKt__Builders_commonKt.d(this.f115872g, null, null, new AnonymousClass1(this.f115871f, usageLimitConditionViewCommand, null), 3, null);
        } else {
            if (!(usageLimitConditionViewCommand instanceof UsageLimitConditionViewCommand.SaveChanges)) {
                throw new NoWhenBranchMatchedException();
            }
            this.f115873h.invoke(((UsageLimitConditionViewCommand.SaveChanges) usageLimitConditionViewCommand).a());
        }
        return Unit.f139807a;
    }
}
