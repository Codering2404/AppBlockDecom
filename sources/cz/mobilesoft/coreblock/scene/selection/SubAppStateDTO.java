package cz.mobilesoft.coreblock.scene.selection;

import cz.mobilesoft.coreblock.repository.SubApp;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class SubAppStateDTO {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f118095d = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SubApp f118096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f118097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f118098c;

    public SubAppStateDTO(SubApp subApp, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(subApp, "subApp");
        this.f118096a = subApp;
        this.f118097b = z2;
        this.f118098c = z3;
    }

    public static /* synthetic */ SubAppStateDTO b(SubAppStateDTO subAppStateDTO, SubApp subApp, boolean z2, boolean z3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            subApp = subAppStateDTO.f118096a;
        }
        if ((i3 & 2) != 0) {
            z2 = subAppStateDTO.f118097b;
        }
        if ((i3 & 4) != 0) {
            z3 = subAppStateDTO.f118098c;
        }
        return subAppStateDTO.a(subApp, z2, z3);
    }

    public final SubAppStateDTO a(SubApp subApp, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(subApp, "subApp");
        return new SubAppStateDTO(subApp, z2, z3);
    }

    public final SubApp c() {
        return this.f118096a;
    }

    public final boolean d() {
        return this.f118098c;
    }

    public final boolean e() {
        return this.f118097b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubAppStateDTO)) {
            return false;
        }
        SubAppStateDTO subAppStateDTO = (SubAppStateDTO) obj;
        return Intrinsics.areEqual(this.f118096a, subAppStateDTO.f118096a) && this.f118097b == subAppStateDTO.f118097b && this.f118098c == subAppStateDTO.f118098c;
    }

    public int hashCode() {
        return (((this.f118096a.hashCode() * 31) + Boolean.hashCode(this.f118097b)) * 31) + Boolean.hashCode(this.f118098c);
    }

    public String toString() {
        return "SubAppStateDTO(subApp=" + this.f118096a + ", isSelected=" + this.f118097b + ", isEnabled=" + this.f118098c + ")";
    }

    public /* synthetic */ SubAppStateDTO(SubApp subApp, boolean z2, boolean z3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(subApp, (i3 & 2) != 0 ? false : z2, (i3 & 4) != 0 ? true : z3);
    }
}
