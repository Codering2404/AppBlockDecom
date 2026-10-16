package cz.mobilesoft.coreblock.scene.strictmode3.options;

import cz.mobilesoft.coreblock.enums.StrictModeOption;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.options.StrictModeOptionsViewModel$onOptionClicked$1", f = "StrictModeOptionsViewModel.kt", l = {86}, m = "invokeSuspend", v = 1)
final class StrictModeOptionsViewModel$onOptionClicked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f122313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f122314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ StrictModeOptionsViewModel f122315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ StrictModeOption f122316d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StrictModeOptionsViewModel$onOptionClicked$1(StrictModeOptionsViewModel strictModeOptionsViewModel, StrictModeOption strictModeOption, Continuation continuation) {
        super(2, continuation);
        this.f122315c = strictModeOptionsViewModel;
        this.f122316d = strictModeOption;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StrictModeOptionsViewModel$onOptionClicked$1(this.f122315c, this.f122316d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f122314b;
        if (i3 == 0) {
            ResultKt.b(obj);
            boolean zContains = StrictModeOptionsViewModel.S0(this.f122315c).d().contains(this.f122316d);
            if (zContains) {
                this.f122315c.b1(this.f122316d);
            } else {
                StrictModeOptionsViewModel strictModeOptionsViewModel = this.f122315c;
                StrictModeOption strictModeOption = this.f122316d;
                this.f122313a = zContains;
                this.f122314b = 1;
                if (strictModeOptionsViewModel.c1(strictModeOption, this) == objF) {
                    return objF;
                }
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
        return ((StrictModeOptionsViewModel$onOptionClicked$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
