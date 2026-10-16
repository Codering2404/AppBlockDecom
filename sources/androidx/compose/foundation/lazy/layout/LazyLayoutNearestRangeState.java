package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

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
public final class LazyLayoutNearestRangeState implements State<IntRange> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Companion f8148f = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f8150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableState f8151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f8152d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final IntRange b(int i3, int i4, int i5) {
            int i6 = (i3 / i4) * i4;
            return RangesKt.B(Math.max(i6 - i5, 0), i6 + i4 + i5);
        }

        private Companion() {
        }
    }

    public LazyLayoutNearestRangeState(int i3, int i4, int i5) {
        this.f8149a = i4;
        this.f8150b = i5;
        this.f8151c = SnapshotStateKt.i(f8148f.b(i3, i4, i5), SnapshotStateKt.r());
        this.f8152d = i3;
    }

    private void i(IntRange intRange) {
        this.f8151c.setValue(intRange);
    }

    @Override // androidx.compose.runtime.State
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public IntRange getValue() {
        return (IntRange) this.f8151c.getValue();
    }

    public final void n(int i3) {
        if (i3 != this.f8152d) {
            this.f8152d = i3;
            i(f8148f.b(i3, this.f8149a, this.f8150b));
        }
    }
}
