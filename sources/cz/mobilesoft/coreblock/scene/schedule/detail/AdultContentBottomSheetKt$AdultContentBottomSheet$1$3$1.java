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
import kotlinx.coroutines.DelayKt;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.detail.AdultContentBottomSheetKt$AdultContentBottomSheet$1$3$1", f = "AdultContentBottomSheet.kt", l = {189}, m = "invokeSuspend", v = 1)
final class AdultContentBottomSheetKt$AdultContentBottomSheet$1$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f116480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f116481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ModalBottomSheetState f116482c;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.detail.AdultContentBottomSheetKt$AdultContentBottomSheet$1$3$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.detail.AdultContentBottomSheetKt$AdultContentBottomSheet$1$3$1$1", f = "AdultContentBottomSheet.kt", l = {191}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f116483a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ModalBottomSheetState f116484b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ModalBottomSheetState modalBottomSheetState, Continuation continuation) {
            super(2, continuation);
            this.f116484b = modalBottomSheetState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f116484b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f116483a;
            if (i3 == 0) {
                ResultKt.b(obj);
                ModalBottomSheetState modalBottomSheetState = this.f116484b;
                this.f116483a = 1;
                if (modalBottomSheetState.i(this) == objF) {
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
    AdultContentBottomSheetKt$AdultContentBottomSheet$1$3$1(CoroutineScope coroutineScope, ModalBottomSheetState modalBottomSheetState, Continuation continuation) {
        super(2, continuation);
        this.f116481b = coroutineScope;
        this.f116482c = modalBottomSheetState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AdultContentBottomSheetKt$AdultContentBottomSheet$1$3$1(this.f116481b, this.f116482c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f116480a;
        if (i3 == 0) {
            ResultKt.b(obj);
            this.f116480a = 1;
            if (DelayKt.b(1500L, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        BuildersKt__Builders_commonKt.d(this.f116481b, null, null, new AnonymousClass1(this.f116482c, null), 3, null);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((AdultContentBottomSheetKt$AdultContentBottomSheet$1$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
