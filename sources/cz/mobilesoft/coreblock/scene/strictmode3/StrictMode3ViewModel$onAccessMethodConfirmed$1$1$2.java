package cz.mobilesoft.coreblock.scene.strictmode3;

import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.enums.StrictModeState;
import java.util.List;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$onAccessMethodConfirmed$1$1$2", f = "StrictMode3ViewModel.kt", l = {755}, m = "invokeSuspend", v = 1)
final class StrictMode3ViewModel$onAccessMethodConfirmed$1$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f121294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ StrictMode3ViewModel f121295b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ StrictModeAccessMethod f121296c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ List f121297d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ List f121298f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ StrictModeState f121299g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StrictMode3ViewModel$onAccessMethodConfirmed$1$1$2(StrictMode3ViewModel strictMode3ViewModel, StrictModeAccessMethod strictModeAccessMethod, List list, List list2, StrictModeState strictModeState, Continuation continuation) {
        super(2, continuation);
        this.f121295b = strictMode3ViewModel;
        this.f121296c = strictModeAccessMethod;
        this.f121297d = list;
        this.f121298f = list2;
        this.f121299g = strictModeState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StrictMode3ViewModel$onAccessMethodConfirmed$1$1$2(this.f121295b, this.f121296c, this.f121297d, this.f121298f, this.f121299g, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f121294a;
        if (i3 == 0) {
            ResultKt.b(obj);
            StrictMode3ViewModel strictMode3ViewModel = this.f121295b;
            StrictModeAccessMethod strictModeAccessMethod = this.f121296c;
            List list = this.f121297d;
            List list2 = this.f121298f;
            StrictModeState strictModeState = this.f121299g;
            this.f121294a = 1;
            if (strictMode3ViewModel.S1(strictModeAccessMethod, list, list2, strictModeState, this) == objF) {
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
        return ((StrictMode3ViewModel$onAccessMethodConfirmed$1$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
