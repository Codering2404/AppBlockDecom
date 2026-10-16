package androidx.compose.material;

import androidx.compose.ui.unit.Density;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.material.SwipeableKt$swipeable$3$3$1", f = "Swipeable.kt", l = {617}, m = "invokeSuspend")
final class SwipeableKt$swipeable$3$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f14330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ SwipeableState f14331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Map f14332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ResistanceConfig f14333d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Density f14334f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Function2 f14335g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ float f14336h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SwipeableKt$swipeable$3$3$1(SwipeableState swipeableState, Map map, ResistanceConfig resistanceConfig, Density density, Function2 function2, float f3, Continuation continuation) {
        super(2, continuation);
        this.f14331b = swipeableState;
        this.f14332c = map;
        this.f14333d = resistanceConfig;
        this.f14334f = density;
        this.f14335g = function2;
        this.f14336h = f3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SwipeableKt$swipeable$3$3$1(this.f14331b, this.f14332c, this.f14333d, this.f14334f, this.f14335g, this.f14336h, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f14330a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Map mapM = this.f14331b.m();
            this.f14331b.B(this.f14332c);
            this.f14331b.E(this.f14333d);
            SwipeableState swipeableState = this.f14331b;
            final Map map = this.f14332c;
            final Function2 function2 = this.f14335g;
            final Density density = this.f14334f;
            swipeableState.F(new Function2<Float, Float, Float>() { // from class: androidx.compose.material.SwipeableKt$swipeable$3$3$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public final Float c(float f3, float f4) {
                    return Float.valueOf(((ThresholdConfig) function2.invoke(MapsKt.getValue(map, Float.valueOf(f3)), MapsKt.getValue(map, Float.valueOf(f4)))).a(density, f3, f4));
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    return c(((Number) obj2).floatValue(), ((Number) obj3).floatValue());
                }
            });
            this.f14331b.G(this.f14334f.M1(this.f14336h));
            SwipeableState swipeableState2 = this.f14331b;
            Map map2 = this.f14332c;
            this.f14330a = 1;
            if (swipeableState2.A(mapM, map2, this) == objF) {
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
        return ((SwipeableKt$swipeable$3$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
