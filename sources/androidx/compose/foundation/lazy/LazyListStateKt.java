package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.DensityKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScopeKt;

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
public final class LazyListStateKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final LazyListMeasureResult f7615a;

    static {
        MeasureResult measureResult = new MeasureResult() { // from class: androidx.compose.foundation.lazy.LazyListStateKt$EmptyLazyListMeasureResult$1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f7616a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final int f7617b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final Map f7618c = MapsKt.emptyMap();

            @Override // androidx.compose.ui.layout.MeasureResult
            public int getHeight() {
                return this.f7617b;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public int getWidth() {
                return this.f7616a;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public Map z() {
                return this.f7618c;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public void A() {
            }
        };
        List listEmptyList = CollectionsKt.emptyList();
        Orientation orientation = Orientation.f6031a;
        int i3 = 0;
        boolean z2 = false;
        float f3 = 0.0f;
        float f4 = 0.0f;
        boolean z3 = false;
        f7615a = new LazyListMeasureResult(null, i3, z2, f3, measureResult, f4, z3, CoroutineScopeKt.a(EmptyCoroutineContext.f139889a), DensityKt.b(1.0f, 0.0f, 2, null), ConstraintsKt.b(0, 0, 0, 0, 15, null), listEmptyList, 0, 0, 0, false, orientation, 0, 0, null);
    }

    public static final LazyListState b(final int i3, final int i4, Composer composer, int i5, int i6) {
        if ((i6 & 1) != 0) {
            i3 = 0;
        }
        if ((i6 & 2) != 0) {
            i4 = 0;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(1470655220, i5, -1, "androidx.compose.foundation.lazy.rememberLazyListState (LazyListState.kt:74)");
        }
        Object[] objArr = new Object[0];
        Saver saverA = LazyListState.f7563x.a();
        boolean z2 = ((((i5 & 14) ^ 6) > 4 && composer.e(i3)) || (i5 & 6) == 4) | ((((i5 & 112) ^ 48) > 32 && composer.e(i4)) || (i5 & 48) == 32);
        Object objG = composer.G();
        if (z2 || objG == Composer.f23746a.a()) {
            objG = new Function0<LazyListState>() { // from class: androidx.compose.foundation.lazy.LazyListStateKt$rememberLazyListState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final LazyListState invoke() {
                    return new LazyListState(i3, i4);
                }
            };
            composer.w(objG);
        }
        LazyListState lazyListState = (LazyListState) RememberSaveableKt.e(objArr, saverA, null, (Function0) objG, composer, 0, 4);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return lazyListState;
    }
}
