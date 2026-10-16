package androidx.compose.ui.node;

import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

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
public interface ComposeUiNode {
    public static final Companion f8 = Companion.f27291a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f27291a = new Companion();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Function0 f27292b = LayoutNode.T.a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final Function0 f27293c = new Function0<LayoutNode>() { // from class: androidx.compose.ui.node.ComposeUiNode$Companion$VirtualConstructor$1
            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final LayoutNode invoke() {
                return new LayoutNode(true, 0, 2, null);
            }
        };

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Function2 f27294d = new Function2<ComposeUiNode, Modifier, Unit>() { // from class: androidx.compose.ui.node.ComposeUiNode$Companion$SetModifier$1
            public final void c(ComposeUiNode composeUiNode, Modifier modifier) {
                composeUiNode.l(modifier);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((ComposeUiNode) obj, (Modifier) obj2);
                return Unit.f139807a;
            }
        };

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final Function2 f27295e = new Function2<ComposeUiNode, Density, Unit>() { // from class: androidx.compose.ui.node.ComposeUiNode$Companion$SetDensity$1
            public final void c(ComposeUiNode composeUiNode, Density density) {
                composeUiNode.d(density);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((ComposeUiNode) obj, (Density) obj2);
                return Unit.f139807a;
            }
        };

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final Function2 f27296f = new Function2<ComposeUiNode, CompositionLocalMap, Unit>() { // from class: androidx.compose.ui.node.ComposeUiNode$Companion$SetResolvedCompositionLocals$1
            public final void c(ComposeUiNode composeUiNode, CompositionLocalMap compositionLocalMap) {
                composeUiNode.n(compositionLocalMap);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((ComposeUiNode) obj, (CompositionLocalMap) obj2);
                return Unit.f139807a;
            }
        };

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final Function2 f27297g = new Function2<ComposeUiNode, MeasurePolicy, Unit>() { // from class: androidx.compose.ui.node.ComposeUiNode$Companion$SetMeasurePolicy$1
            public final void c(ComposeUiNode composeUiNode, MeasurePolicy measurePolicy) {
                composeUiNode.k(measurePolicy);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((ComposeUiNode) obj, (MeasurePolicy) obj2);
                return Unit.f139807a;
            }
        };

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final Function2 f27298h = new Function2<ComposeUiNode, LayoutDirection, Unit>() { // from class: androidx.compose.ui.node.ComposeUiNode$Companion$SetLayoutDirection$1
            public final void c(ComposeUiNode composeUiNode, LayoutDirection layoutDirection) {
                composeUiNode.c(layoutDirection);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((ComposeUiNode) obj, (LayoutDirection) obj2);
                return Unit.f139807a;
            }
        };

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final Function2 f27299i = new Function2<ComposeUiNode, ViewConfiguration, Unit>() { // from class: androidx.compose.ui.node.ComposeUiNode$Companion$SetViewConfiguration$1
            public final void c(ComposeUiNode composeUiNode, ViewConfiguration viewConfiguration) {
                composeUiNode.h(viewConfiguration);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((ComposeUiNode) obj, (ViewConfiguration) obj2);
                return Unit.f139807a;
            }
        };

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final Function2 f27300j = new Function2<ComposeUiNode, Integer, Unit>() { // from class: androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1
            public final void c(ComposeUiNode composeUiNode, int i3) {
                composeUiNode.e(i3);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((ComposeUiNode) obj, ((Number) obj2).intValue());
                return Unit.f139807a;
            }
        };

        private Companion() {
        }

        public final Function0 a() {
            return f27292b;
        }

        public final Function2 b() {
            return f27300j;
        }

        public final Function2 c() {
            return f27295e;
        }

        public final Function2 d() {
            return f27298h;
        }

        public final Function2 e() {
            return f27297g;
        }

        public final Function2 f() {
            return f27294d;
        }

        public final Function2 g() {
            return f27296f;
        }

        public final Function2 h() {
            return f27299i;
        }

        public final Function0 i() {
            return f27293c;
        }
    }

    void c(LayoutDirection layoutDirection);

    void d(Density density);

    void e(int i3);

    void h(ViewConfiguration viewConfiguration);

    void k(MeasurePolicy measurePolicy);

    void l(Modifier modifier);

    void n(CompositionLocalMap compositionLocalMap);
}
