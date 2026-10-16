package androidx.compose.material3;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$3$1", f = "NavigationDrawer.android.kt", l = {}, m = "invokeSuspend")
final class NavigationDrawer_androidKt$DrawerPredictiveBackHandler$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f18700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ DrawerState f18701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ DrawerPredictiveBackState f18702c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NavigationDrawer_androidKt$DrawerPredictiveBackHandler$3$1(DrawerState drawerState, DrawerPredictiveBackState drawerPredictiveBackState, Continuation continuation) {
        super(2, continuation);
        this.f18701b = drawerState;
        this.f18702c = drawerPredictiveBackState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new NavigationDrawer_androidKt$DrawerPredictiveBackHandler$3$1(this.f18701b, this.f18702c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f18700a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (this.f18701b.i()) {
            this.f18702c.a();
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((NavigationDrawer_androidKt$DrawerPredictiveBackHandler$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
