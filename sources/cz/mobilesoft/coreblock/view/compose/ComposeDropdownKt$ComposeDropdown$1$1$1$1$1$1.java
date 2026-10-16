package cz.mobilesoft.coreblock.view.compose;

import androidx.compose.material.ScaffoldState;
import androidx.compose.material.SnackbarDuration;
import androidx.compose.material.SnackbarHostState;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.view.compose.ComposeDropdownKt$ComposeDropdown$1$1$1$1$1$1", f = "ComposeDropdown.kt", l = {68}, m = "invokeSuspend", v = 1)
final class ComposeDropdownKt$ComposeDropdown$1$1$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f130466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ScaffoldState f130467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f130468c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ComposeDropdownKt$ComposeDropdown$1$1$1$1$1$1(ScaffoldState scaffoldState, String str, Continuation continuation) {
        super(2, continuation);
        this.f130467b = scaffoldState;
        this.f130468c = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ComposeDropdownKt$ComposeDropdown$1$1$1$1$1$1(this.f130467b, this.f130468c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        SnackbarHostState snackbarHostStateB;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f130466a;
        if (i3 == 0) {
            ResultKt.b(obj);
            ScaffoldState scaffoldState = this.f130467b;
            if (scaffoldState != null && (snackbarHostStateB = scaffoldState.b()) != null) {
                String str = this.f130468c;
                SnackbarDuration snackbarDuration = SnackbarDuration.Short;
                this.f130466a = 1;
                obj = snackbarHostStateB.d(str, null, snackbarDuration, this);
                if (obj == objF) {
                    return objF;
                }
            }
            return Unit.f139807a;
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ComposeDropdownKt$ComposeDropdown$1$1$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
