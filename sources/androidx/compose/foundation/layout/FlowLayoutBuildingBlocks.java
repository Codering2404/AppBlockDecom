package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair;
import androidx.compose.foundation.layout.FlowLayoutOverflow;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class FlowLayoutBuildingBlocks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f6801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FlowLayoutOverflowState f6802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f6803c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f6804d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f6805e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f6806f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class WrapEllipsisInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Measurable f6807a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Placeable f6808b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f6809c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f6810d;

        public /* synthetic */ WrapEllipsisInfo(Measurable measurable, Placeable placeable, long j3, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
            this(measurable, placeable, j3, z2);
        }

        public final Measurable a() {
            return this.f6807a;
        }

        public final long b() {
            return this.f6809c;
        }

        public final boolean c() {
            return this.f6810d;
        }

        public final Placeable d() {
            return this.f6808b;
        }

        public final void e(boolean z2) {
            this.f6810d = z2;
        }

        private WrapEllipsisInfo(Measurable measurable, Placeable placeable, long j3, boolean z2) {
            this.f6807a = measurable;
            this.f6808b = placeable;
            this.f6809c = j3;
            this.f6810d = z2;
        }

        public /* synthetic */ WrapEllipsisInfo(Measurable measurable, Placeable placeable, long j3, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(measurable, placeable, j3, (i3 & 8) != 0 ? true : z2, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class WrapInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f6811a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f6812b;

        public WrapInfo(boolean z2, boolean z3) {
            this.f6811a = z2;
            this.f6812b = z3;
        }

        public final boolean a() {
            return this.f6812b;
        }

        public final boolean b() {
            return this.f6811a;
        }
    }

    public /* synthetic */ FlowLayoutBuildingBlocks(int i3, FlowLayoutOverflowState flowLayoutOverflowState, long j3, int i4, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, flowLayoutOverflowState, j3, i4, i5, i6);
    }

    public final WrapEllipsisInfo a(WrapInfo wrapInfo, boolean z2, int i3, int i4, int i5, int i6) {
        WrapEllipsisInfo wrapEllipsisInfoE;
        if (!wrapInfo.a() || (wrapEllipsisInfoE = this.f6802b.e(z2, i3, i4)) == null) {
            return null;
        }
        wrapEllipsisInfoE.e(i3 >= 0 && (i6 == 0 || (i5 - IntIntPair.e(wrapEllipsisInfoE.b()) >= 0 && i6 < this.f6801a)));
        return wrapEllipsisInfoE;
    }

    public final WrapInfo b(boolean z2, int i3, long j3, IntIntPair intIntPair, int i4, int i5, int i6, boolean z3, boolean z4) {
        int i7 = i5 + i6;
        if (intIntPair == null) {
            return new WrapInfo(true, true);
        }
        if (this.f6802b.l() != FlowLayoutOverflow.OverflowType.f6866a && (i4 >= this.f6804d || IntIntPair.f(j3) - IntIntPair.f(intIntPair.i()) < 0)) {
            return new WrapInfo(true, true);
        }
        if (i3 != 0 && (i3 >= this.f6801a || IntIntPair.e(j3) - IntIntPair.e(intIntPair.i()) < 0)) {
            return z3 ? new WrapInfo(true, true) : new WrapInfo(true, b(z2, 0, IntIntPair.b(Constraints.l(this.f6803c), (IntIntPair.f(j3) - this.f6806f) - i6), IntIntPair.a(IntIntPair.b(IntIntPair.e(intIntPair.i()) - this.f6805e, IntIntPair.f(intIntPair.i()))), i4 + 1, i7, 0, true, false).a());
        }
        int iMax = i5 + Math.max(i6, IntIntPair.f(intIntPair.i()));
        IntIntPair intIntPairF = z4 ? null : this.f6802b.f(z2, i4, iMax);
        if (intIntPairF != null) {
            intIntPairF.i();
            if (i3 + 1 >= this.f6801a || ((IntIntPair.e(j3) - IntIntPair.e(intIntPair.i())) - this.f6805e) - IntIntPair.e(intIntPairF.i()) < 0) {
                if (z4) {
                    return new WrapInfo(true, true);
                }
                WrapInfo wrapInfoB = b(false, 0, IntIntPair.b(Constraints.l(this.f6803c), (IntIntPair.f(j3) - this.f6806f) - Math.max(i6, IntIntPair.f(intIntPair.i()))), intIntPairF, i4 + 1, iMax, 0, true, true);
                return new WrapInfo(wrapInfoB.a(), wrapInfoB.a());
            }
        }
        return new WrapInfo(false, false);
    }

    private FlowLayoutBuildingBlocks(int i3, FlowLayoutOverflowState flowLayoutOverflowState, long j3, int i4, int i5, int i6) {
        this.f6801a = i3;
        this.f6802b = flowLayoutOverflowState;
        this.f6803c = j3;
        this.f6804d = i4;
        this.f6805e = i5;
        this.f6806f = i6;
    }
}
