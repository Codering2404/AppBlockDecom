package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class Selection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AnchorInfo f11258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AnchorInfo f11259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f11260c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnchorInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ResolvedTextDirection f11261a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f11262b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f11263c;

        public AnchorInfo(ResolvedTextDirection resolvedTextDirection, int i3, long j3) {
            this.f11261a = resolvedTextDirection;
            this.f11262b = i3;
            this.f11263c = j3;
        }

        public static /* synthetic */ AnchorInfo b(AnchorInfo anchorInfo, ResolvedTextDirection resolvedTextDirection, int i3, long j3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                resolvedTextDirection = anchorInfo.f11261a;
            }
            if ((i4 & 2) != 0) {
                i3 = anchorInfo.f11262b;
            }
            if ((i4 & 4) != 0) {
                j3 = anchorInfo.f11263c;
            }
            return anchorInfo.a(resolvedTextDirection, i3, j3);
        }

        public final AnchorInfo a(ResolvedTextDirection resolvedTextDirection, int i3, long j3) {
            return new AnchorInfo(resolvedTextDirection, i3, j3);
        }

        public final ResolvedTextDirection c() {
            return this.f11261a;
        }

        public final int d() {
            return this.f11262b;
        }

        public final long e() {
            return this.f11263c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AnchorInfo)) {
                return false;
            }
            AnchorInfo anchorInfo = (AnchorInfo) obj;
            return this.f11261a == anchorInfo.f11261a && this.f11262b == anchorInfo.f11262b && this.f11263c == anchorInfo.f11263c;
        }

        public int hashCode() {
            return (((this.f11261a.hashCode() * 31) + Integer.hashCode(this.f11262b)) * 31) + Long.hashCode(this.f11263c);
        }

        public String toString() {
            return "AnchorInfo(direction=" + this.f11261a + ", offset=" + this.f11262b + ", selectableId=" + this.f11263c + ')';
        }
    }

    public Selection(AnchorInfo anchorInfo, AnchorInfo anchorInfo2, boolean z2) {
        this.f11258a = anchorInfo;
        this.f11259b = anchorInfo2;
        this.f11260c = z2;
    }

    public static /* synthetic */ Selection b(Selection selection, AnchorInfo anchorInfo, AnchorInfo anchorInfo2, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            anchorInfo = selection.f11258a;
        }
        if ((i3 & 2) != 0) {
            anchorInfo2 = selection.f11259b;
        }
        if ((i3 & 4) != 0) {
            z2 = selection.f11260c;
        }
        return selection.a(anchorInfo, anchorInfo2, z2);
    }

    public final Selection a(AnchorInfo anchorInfo, AnchorInfo anchorInfo2, boolean z2) {
        return new Selection(anchorInfo, anchorInfo2, z2);
    }

    public final AnchorInfo c() {
        return this.f11259b;
    }

    public final boolean d() {
        return this.f11260c;
    }

    public final AnchorInfo e() {
        return this.f11258a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Selection)) {
            return false;
        }
        Selection selection = (Selection) obj;
        return Intrinsics.areEqual(this.f11258a, selection.f11258a) && Intrinsics.areEqual(this.f11259b, selection.f11259b) && this.f11260c == selection.f11260c;
    }

    public final Selection f(Selection selection) {
        if (selection == null) {
            return this;
        }
        boolean z2 = this.f11260c;
        if (z2 || selection.f11260c) {
            return new Selection(selection.f11260c ? selection.f11258a : selection.f11259b, z2 ? this.f11259b : this.f11258a, true);
        }
        return b(this, null, selection.f11259b, false, 5, null);
    }

    public final long g() {
        return TextRangeKt.b(this.f11258a.d(), this.f11259b.d());
    }

    public int hashCode() {
        return (((this.f11258a.hashCode() * 31) + this.f11259b.hashCode()) * 31) + Boolean.hashCode(this.f11260c);
    }

    public String toString() {
        return "Selection(start=" + this.f11258a + ", end=" + this.f11259b + ", handlesCrossed=" + this.f11260c + ')';
    }
}
