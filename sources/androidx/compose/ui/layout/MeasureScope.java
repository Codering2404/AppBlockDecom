package androidx.compose.ui.layout;

import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;

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
@MeasureScopeMarker
@Metadata
public interface MeasureScope extends IntrinsicMeasureScope {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
    }

    static /* synthetic */ MeasureResult B0(MeasureScope measureScope, int i3, int i4, Map map, Function1 function1, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: layout");
        }
        if ((i5 & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        return measureScope.c1(i3, i4, map, function1);
    }

    default MeasureResult U1(final int i3, final int i4, final Map map, final Function1 function1, final Function1 function12) {
        if (!((i3 & (-16777216)) == 0 && ((-16777216) & i4) == 0)) {
            InlineClassHelperKt.c("Size(" + i3 + " x " + i4 + ") is out of range. Each dimension must be between 0 and 16777215.");
        }
        return new MeasureResult(i3, i4, map, function1, this, function12) { // from class: androidx.compose.ui.layout.MeasureScope$layout$1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f27157a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final int f27158b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final Map f27159c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final Function1 f27160d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f27161e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ MeasureScope f27162f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ Function1 f27163g;

            {
                this.f27161e = i3;
                this.f27162f = this;
                this.f27163g = function12;
                this.f27157a = i3;
                this.f27158b = i4;
                this.f27159c = map;
                this.f27160d = function1;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public void A() {
                MeasureScope measureScope = this.f27162f;
                if (measureScope instanceof LookaheadCapablePlaceable) {
                    this.f27163g.invoke(((LookaheadCapablePlaceable) measureScope).B1());
                } else {
                    this.f27163g.invoke(new SimplePlacementScope(this.f27161e, this.f27162f.getLayoutDirection()));
                }
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public Function1 B() {
                return this.f27160d;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public int getHeight() {
                return this.f27158b;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public int getWidth() {
                return this.f27157a;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public Map z() {
                return this.f27159c;
            }
        };
    }

    default MeasureResult c1(int i3, int i4, Map map, Function1 function1) {
        return U1(i3, i4, map, null, function1);
    }
}
