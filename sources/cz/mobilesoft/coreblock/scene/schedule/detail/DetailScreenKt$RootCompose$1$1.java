package cz.mobilesoft.coreblock.scene.schedule.detail;

import androidx.compose.material.ModalBottomSheetState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.detail.DetailScreenKt$RootCompose$1$1", f = "DetailScreen.kt", l = {}, m = "invokeSuspend", v = 1)
final class DetailScreenKt$RootCompose$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f116557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ScheduleViewState f116558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f116559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ModalBottomSheetState f116560d;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.detail.DetailScreenKt$RootCompose$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.detail.DetailScreenKt$RootCompose$1$1$1", f = "DetailScreen.kt", l = {211}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f116561a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ModalBottomSheetState f116562b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ModalBottomSheetState modalBottomSheetState, Continuation continuation) {
            super(2, continuation);
            this.f116562b = modalBottomSheetState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f116562b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f116561a;
            if (i3 == 0) {
                ResultKt.b(obj);
                ModalBottomSheetState modalBottomSheetState = this.f116562b;
                this.f116561a = 1;
                if (modalBottomSheetState.l(this) == objF) {
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
    DetailScreenKt$RootCompose$1$1(ScheduleViewState scheduleViewState, CoroutineScope coroutineScope, ModalBottomSheetState modalBottomSheetState, Continuation continuation) {
        super(2, continuation);
        this.f116558b = scheduleViewState;
        this.f116559c = coroutineScope;
        this.f116560d = modalBottomSheetState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DetailScreenKt$RootCompose$1$1(this.f116558b, this.f116559c, this.f116560d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f116557a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (this.f116558b.q()) {
            BuildersKt__Builders_commonKt.d(this.f116559c, null, null, new AnonymousClass1(this.f116560d, null), 3, null);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DetailScreenKt$RootCompose$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
