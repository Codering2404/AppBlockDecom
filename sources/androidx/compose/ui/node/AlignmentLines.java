package androidx.compose.ui.node;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public abstract class AlignmentLines {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AlignmentLinesOwner f27263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f27264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f27265c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f27266d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f27267e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f27268f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f27269g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AlignmentLinesOwner f27270h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map f27271i;

    public /* synthetic */ AlignmentLines(AlignmentLinesOwner alignmentLinesOwner, DefaultConstructorMarker defaultConstructorMarker) {
        this(alignmentLinesOwner);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(AlignmentLine alignmentLine, int i3, NodeCoordinator nodeCoordinator) {
        float f3 = i3;
        long jE = Offset.e((((long) Float.floatToRawIntBits(f3)) << 32) | (((long) Float.floatToRawIntBits(f3)) & 4294967295L));
        while (true) {
            jE = d(nodeCoordinator, jE);
            nodeCoordinator = nodeCoordinator.Y2();
            Intrinsics.checkNotNull(nodeCoordinator);
            if (Intrinsics.areEqual(nodeCoordinator, this.f27263a.g0())) {
                break;
            } else if (e(nodeCoordinator).containsKey(alignmentLine)) {
                float fI = i(nodeCoordinator, alignmentLine);
                jE = Offset.e((((long) Float.floatToRawIntBits(fI)) << 32) | (((long) Float.floatToRawIntBits(fI)) & 4294967295L));
            }
        }
        int iRound = Math.round(alignmentLine instanceof HorizontalAlignmentLine ? Float.intBitsToFloat((int) (jE & 4294967295L)) : Float.intBitsToFloat((int) (jE >> 32)));
        Map map = this.f27271i;
        if (map.containsKey(alignmentLine)) {
            iRound = AlignmentLineKt.c(alignmentLine, ((Number) MapsKt.getValue(this.f27271i, alignmentLine)).intValue(), iRound);
        }
        map.put(alignmentLine, Integer.valueOf(iRound));
    }

    protected abstract long d(NodeCoordinator nodeCoordinator, long j3);

    protected abstract Map e(NodeCoordinator nodeCoordinator);

    public final AlignmentLinesOwner f() {
        return this.f27263a;
    }

    public final boolean g() {
        return this.f27264b;
    }

    public final Map h() {
        return this.f27271i;
    }

    protected abstract int i(NodeCoordinator nodeCoordinator, AlignmentLine alignmentLine);

    public final boolean j() {
        return this.f27265c || this.f27267e || this.f27268f || this.f27269g;
    }

    public final boolean k() {
        o();
        return this.f27270h != null;
    }

    public final boolean l() {
        return this.f27266d;
    }

    public final void m() {
        this.f27264b = true;
        AlignmentLinesOwner alignmentLinesOwnerU = this.f27263a.U();
        if (alignmentLinesOwnerU == null) {
            return;
        }
        if (this.f27265c) {
            alignmentLinesOwnerU.E0();
        } else if (this.f27267e || this.f27266d) {
            alignmentLinesOwnerU.requestLayout();
        }
        if (this.f27268f) {
            this.f27263a.E0();
        }
        if (this.f27269g) {
            this.f27263a.requestLayout();
        }
        alignmentLinesOwnerU.z().m();
    }

    public final void n() {
        this.f27271i.clear();
        this.f27263a.w0(new Function1<AlignmentLinesOwner, Unit>() { // from class: androidx.compose.ui.node.AlignmentLines$recalculate$1
            {
                super(1);
            }

            public final void c(AlignmentLinesOwner alignmentLinesOwner) {
                if (alignmentLinesOwner.u()) {
                    if (alignmentLinesOwner.z().g()) {
                        alignmentLinesOwner.a0();
                    }
                    Map map = alignmentLinesOwner.z().f27271i;
                    AlignmentLines alignmentLines = this.f27272a;
                    for (Map.Entry entry : map.entrySet()) {
                        alignmentLines.c((AlignmentLine) entry.getKey(), ((Number) entry.getValue()).intValue(), alignmentLinesOwner.g0());
                    }
                    NodeCoordinator nodeCoordinatorY2 = alignmentLinesOwner.g0().Y2();
                    Intrinsics.checkNotNull(nodeCoordinatorY2);
                    while (!Intrinsics.areEqual(nodeCoordinatorY2, this.f27272a.f().g0())) {
                        Set<AlignmentLine> setKeySet = this.f27272a.e(nodeCoordinatorY2).keySet();
                        AlignmentLines alignmentLines2 = this.f27272a;
                        for (AlignmentLine alignmentLine : setKeySet) {
                            alignmentLines2.c(alignmentLine, alignmentLines2.i(nodeCoordinatorY2, alignmentLine), nodeCoordinatorY2);
                        }
                        nodeCoordinatorY2 = nodeCoordinatorY2.Y2();
                        Intrinsics.checkNotNull(nodeCoordinatorY2);
                    }
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((AlignmentLinesOwner) obj);
                return Unit.f139807a;
            }
        });
        this.f27271i.putAll(e(this.f27263a.g0()));
        this.f27264b = false;
    }

    public final void o() {
        AlignmentLinesOwner alignmentLinesOwner;
        AlignmentLines alignmentLinesZ;
        AlignmentLines alignmentLinesZ2;
        if (j()) {
            alignmentLinesOwner = this.f27263a;
        } else {
            AlignmentLinesOwner alignmentLinesOwnerU = this.f27263a.U();
            if (alignmentLinesOwnerU == null) {
                return;
            }
            alignmentLinesOwner = alignmentLinesOwnerU.z().f27270h;
            if (alignmentLinesOwner == null || !alignmentLinesOwner.z().j()) {
                AlignmentLinesOwner alignmentLinesOwner2 = this.f27270h;
                if (alignmentLinesOwner2 == null || alignmentLinesOwner2.z().j()) {
                    return;
                }
                AlignmentLinesOwner alignmentLinesOwnerU2 = alignmentLinesOwner2.U();
                if (alignmentLinesOwnerU2 != null && (alignmentLinesZ2 = alignmentLinesOwnerU2.z()) != null) {
                    alignmentLinesZ2.o();
                }
                AlignmentLinesOwner alignmentLinesOwnerU3 = alignmentLinesOwner2.U();
                alignmentLinesOwner = (alignmentLinesOwnerU3 == null || (alignmentLinesZ = alignmentLinesOwnerU3.z()) == null) ? null : alignmentLinesZ.f27270h;
            }
        }
        this.f27270h = alignmentLinesOwner;
    }

    public final void p() {
        this.f27264b = true;
        this.f27265c = false;
        this.f27267e = false;
        this.f27266d = false;
        this.f27268f = false;
        this.f27269g = false;
        this.f27270h = null;
    }

    public final void q(boolean z2) {
        this.f27267e = z2;
    }

    public final void r(boolean z2) {
        this.f27269g = z2;
    }

    public final void s(boolean z2) {
        this.f27268f = z2;
    }

    public final void t(boolean z2) {
        this.f27266d = z2;
    }

    public final void u(boolean z2) {
        this.f27265c = z2;
    }

    private AlignmentLines(AlignmentLinesOwner alignmentLinesOwner) {
        this.f27263a = alignmentLinesOwner;
        this.f27264b = true;
        this.f27271i = new HashMap();
    }
}
