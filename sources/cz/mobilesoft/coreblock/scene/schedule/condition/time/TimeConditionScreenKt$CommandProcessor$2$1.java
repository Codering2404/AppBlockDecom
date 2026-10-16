package cz.mobilesoft.coreblock.scene.schedule.condition.time;

import androidx.compose.material.ScaffoldState;
import androidx.compose.material.SnackbarData;
import androidx.compose.material.SnackbarDuration;
import androidx.compose.material.SnackbarHostState;
import androidx.compose.runtime.MutableState;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionViewCommand;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionScreenKt$CommandProcessor$2$1", f = "TimeConditionScreen.kt", l = {}, m = "invokeSuspend", v = 1)
final class TimeConditionScreenKt$CommandProcessor$2$1 extends SuspendLambda implements Function2<TimeConditionViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f115735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f115736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function1 f115737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function0 f115738d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MutableState f115739f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ ScaffoldState f115740g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f115741h;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionScreenKt$CommandProcessor$2$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionScreenKt$CommandProcessor$2$1$1", f = "TimeConditionScreen.kt", l = {248}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f115742a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ScaffoldState f115743b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ TimeConditionViewCommand f115744c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ScaffoldState scaffoldState, TimeConditionViewCommand timeConditionViewCommand, Continuation continuation) {
            super(2, continuation);
            this.f115743b = scaffoldState;
            this.f115744c = timeConditionViewCommand;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f115743b, this.f115744c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f115742a;
            if (i3 == 0) {
                ResultKt.b(obj);
                SnackbarHostState snackbarHostStateB = this.f115743b.b();
                String strA = ((TimeConditionViewCommand.ShowSnackbar) this.f115744c).a();
                SnackbarDuration snackbarDuration = SnackbarDuration.Short;
                this.f115742a = 1;
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
    TimeConditionScreenKt$CommandProcessor$2$1(Function1 function1, Function0 function0, MutableState mutableState, ScaffoldState scaffoldState, CoroutineScope coroutineScope, Continuation continuation) {
        super(2, continuation);
        this.f115737c = function1;
        this.f115738d = function0;
        this.f115739f = mutableState;
        this.f115740g = scaffoldState;
        this.f115741h = coroutineScope;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        TimeConditionScreenKt$CommandProcessor$2$1 timeConditionScreenKt$CommandProcessor$2$1 = new TimeConditionScreenKt$CommandProcessor$2$1(this.f115737c, this.f115738d, this.f115739f, this.f115740g, this.f115741h, continuation);
        timeConditionScreenKt$CommandProcessor$2$1.f115736b = obj;
        return timeConditionScreenKt$CommandProcessor$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(TimeConditionViewCommand timeConditionViewCommand, Continuation continuation) {
        return ((TimeConditionScreenKt$CommandProcessor$2$1) create(timeConditionViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        TimeConditionViewCommand timeConditionViewCommand = (TimeConditionViewCommand) this.f115736b;
        IntrinsicsKt.f();
        if (this.f115735a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (timeConditionViewCommand instanceof TimeConditionViewCommand.SaveChanges) {
            this.f115737c.invoke(((TimeConditionViewCommand.SaveChanges) timeConditionViewCommand).a());
        } else if (Intrinsics.areEqual(timeConditionViewCommand, TimeConditionViewCommand.CloseScreen.f115745a)) {
            this.f115738d.invoke();
        } else if (Intrinsics.areEqual(timeConditionViewCommand, TimeConditionViewCommand.ShowUnsavedChangesDialog.f115748a)) {
            this.f115739f.setValue(Boxing.a(true));
        } else {
            if (!(timeConditionViewCommand instanceof TimeConditionViewCommand.ShowSnackbar)) {
                throw new NoWhenBranchMatchedException();
            }
            SnackbarData snackbarDataB = this.f115740g.b().b();
            if (snackbarDataB != null) {
                snackbarDataB.dismiss();
            }
            BuildersKt__Builders_commonKt.d(this.f115741h, null, null, new AnonymousClass1(this.f115740g, timeConditionViewCommand, null), 3, null);
        }
        return Unit.f139807a;
    }
}
