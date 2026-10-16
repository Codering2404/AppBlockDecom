package androidx.compose.material;

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
@DebugMetadata(c = "androidx.compose.material.DefaultFloatingActionButtonElevation$elevation$1$1", f = "FloatingActionButton.kt", l = {283}, m = "invokeSuspend")
final class DefaultFloatingActionButtonElevation$elevation$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f12576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ FloatingActionButtonElevationAnimatable f12577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ DefaultFloatingActionButtonElevation f12578c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DefaultFloatingActionButtonElevation$elevation$1$1(FloatingActionButtonElevationAnimatable floatingActionButtonElevationAnimatable, DefaultFloatingActionButtonElevation defaultFloatingActionButtonElevation, Continuation continuation) {
        super(2, continuation);
        this.f12577b = floatingActionButtonElevationAnimatable;
        this.f12578c = defaultFloatingActionButtonElevation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DefaultFloatingActionButtonElevation$elevation$1$1(this.f12577b, this.f12578c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f12576a;
        if (i3 == 0) {
            ResultKt.b(obj);
            FloatingActionButtonElevationAnimatable floatingActionButtonElevationAnimatable = this.f12577b;
            float f3 = this.f12578c.f12572a;
            float f4 = this.f12578c.f12573b;
            float f5 = this.f12578c.f12574c;
            float f6 = this.f12578c.f12575d;
            this.f12576a = 1;
            if (floatingActionButtonElevationAnimatable.f(f3, f4, f5, f6, this) == objF) {
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
        return ((DefaultFloatingActionButtonElevation$elevation$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
