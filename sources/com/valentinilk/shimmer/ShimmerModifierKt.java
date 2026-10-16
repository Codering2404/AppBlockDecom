package com.valentinilk.shimmer;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Density;
import com.valentinilk.shimmer.ShimmerBounds;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ShimmerModifierKt {
    public static final Modifier a(Modifier modifier, final Shimmer shimmer) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return ComposedModifierKt.b(modifier, InspectableValueKt.b() ? new Function1<InspectorInfo, Unit>() { // from class: com.valentinilk.shimmer.ShimmerModifierKt$shimmer$$inlined$debugInspectorInfo$1
            {
                super(1);
            }

            public final void c(InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.d("shimmer");
                inspectorInfo.b().c("customShimmer", shimmer);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((InspectorInfo) obj);
                return Unit.f139807a;
            }
        } : InspectableValueKt.a(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: com.valentinilk.shimmer.ShimmerModifierKt$shimmer$2

            /* JADX INFO: renamed from: com.valentinilk.shimmer.ShimmerModifierKt$shimmer$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "com.valentinilk.shimmer.ShimmerModifierKt$shimmer$2$1", f = "ShimmerModifier.kt", l = {31}, m = "invokeSuspend")
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f93817a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ Shimmer f93818b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ ShimmerArea f93819c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(Shimmer shimmer, ShimmerArea shimmerArea, Continuation continuation) {
                    super(2, continuation);
                    this.f93818b = shimmer;
                    this.f93819c = shimmerArea;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    return new AnonymousClass1(this.f93818b, this.f93819c, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objF = IntrinsicsKt.f();
                    int i3 = this.f93817a;
                    if (i3 == 0) {
                        ResultKt.b(obj);
                        MutableStateFlow mutableStateFlowA = this.f93818b.a();
                        final ShimmerArea shimmerArea = this.f93819c;
                        FlowCollector<Rect> flowCollector = new FlowCollector<Rect>() { // from class: com.valentinilk.shimmer.ShimmerModifierKt.shimmer.2.1.1
                            @Override // kotlinx.coroutines.flow.FlowCollector
                            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                            public final Object emit(Rect rect, Continuation continuation) {
                                shimmerArea.j(rect);
                                return Unit.f139807a;
                            }
                        };
                        this.f93817a = 1;
                        if (mutableStateFlowA.collect(flowCollector, this) == objF) {
                            return objF;
                        }
                    } else {
                        if (i3 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                    }
                    throw new KotlinNothingValueException();
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                }
            }

            {
                super(3);
            }

            public final Modifier c(Modifier composed, Composer composer, int i3) {
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                composer.F(-1522903081);
                if (ComposerKt.M()) {
                    ComposerKt.U(-1522903081, i3, -1, "com.valentinilk.shimmer.shimmer.<anonymous> (ShimmerModifier.kt:21)");
                }
                Shimmer shimmerA = shimmer;
                composer.F(131081225);
                if (shimmerA == null) {
                    shimmerA = ShimmerKt.a(ShimmerBounds.View.f93798b, null, composer, 6, 2);
                }
                composer.Y();
                float fM1 = ((Density) composer.q(CompositionLocalsKt.f())).M1(shimmerA.c().h());
                Object objValueOf = Float.valueOf(fM1);
                Object objValueOf2 = Float.valueOf(shimmerA.c().e());
                composer.F(511388516);
                boolean Z = composer.Z(objValueOf) | composer.Z(objValueOf2);
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new ShimmerArea(fM1, shimmerA.c().e());
                    composer.w(objG);
                }
                composer.Y();
                ShimmerArea shimmerArea = (ShimmerArea) objG;
                EffectsKt.f(shimmerArea, shimmerA, new AnonymousClass1(shimmerA, shimmerArea, null), composer, 584);
                composer.F(511388516);
                boolean Z2 = composer.Z(shimmerArea) | composer.Z(shimmerA);
                Object objG2 = composer.G();
                if (Z2 || objG2 == Composer.f23746a.a()) {
                    objG2 = new ShimmerModifier(shimmerArea, shimmerA.b());
                    composer.w(objG2);
                }
                composer.Y();
                ShimmerModifier shimmerModifier = (ShimmerModifier) objG2;
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                composer.Y();
                return shimmerModifier;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return c((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }
        });
    }
}
