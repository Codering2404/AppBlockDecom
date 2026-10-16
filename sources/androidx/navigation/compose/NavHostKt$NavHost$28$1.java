package androidx.navigation.compose;

import androidx.compose.animation.core.SeekableTransitionState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.State;
import androidx.navigation.NavBackStackEntry;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.navigation.compose.NavHostKt$NavHost$28$1", f = "NavHost.kt", l = {628}, m = "invokeSuspend")
final class NavHostKt$NavHost$28$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f49102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ SeekableTransitionState f49103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ State f49104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ MutableFloatState f49105d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NavHostKt$NavHost$28$1(SeekableTransitionState seekableTransitionState, State state, MutableFloatState mutableFloatState, Continuation continuation) {
        super(2, continuation);
        this.f49103b = seekableTransitionState;
        this.f49104c = state;
        this.f49105d = mutableFloatState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new NavHostKt$NavHost$28$1(this.f49103b, this.f49104c, this.f49105d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f49102a;
        if (i3 == 0) {
            ResultKt.b(obj);
            if (NavHostKt.E(this.f49104c).size() > 1) {
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) NavHostKt.E(this.f49104c).get(NavHostKt.E(this.f49104c).size() - 2);
                SeekableTransitionState seekableTransitionState = this.f49103b;
                float F = NavHostKt.F(this.f49105d);
                this.f49102a = 1;
                if (seekableTransitionState.P(F, navBackStackEntry, this) == objF) {
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
        return ((NavHostKt$NavHost$28$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
