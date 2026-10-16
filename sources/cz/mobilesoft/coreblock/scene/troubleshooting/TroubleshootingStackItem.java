package cz.mobilesoft.coreblock.scene.troubleshooting;

import cz.mobilesoft.coreblock.enums.HelpItem;
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
public final class TroubleshootingStackItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HelpItem f122981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f122982b;

    public TroubleshootingStackItem(HelpItem helpItem, boolean z2) {
        Intrinsics.checkNotNullParameter(helpItem, "helpItem");
        this.f122981a = helpItem;
        this.f122982b = z2;
    }

    public static /* synthetic */ TroubleshootingStackItem b(TroubleshootingStackItem troubleshootingStackItem, HelpItem helpItem, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            helpItem = troubleshootingStackItem.f122981a;
        }
        if ((i3 & 2) != 0) {
            z2 = troubleshootingStackItem.f122982b;
        }
        return troubleshootingStackItem.a(helpItem, z2);
    }

    public final TroubleshootingStackItem a(HelpItem helpItem, boolean z2) {
        Intrinsics.checkNotNullParameter(helpItem, "helpItem");
        return new TroubleshootingStackItem(helpItem, z2);
    }

    public final HelpItem c() {
        return this.f122981a;
    }

    public final boolean d() {
        return this.f122982b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TroubleshootingStackItem)) {
            return false;
        }
        TroubleshootingStackItem troubleshootingStackItem = (TroubleshootingStackItem) obj;
        return this.f122981a == troubleshootingStackItem.f122981a && this.f122982b == troubleshootingStackItem.f122982b;
    }

    public int hashCode() {
        return (this.f122981a.hashCode() * 31) + Boolean.hashCode(this.f122982b);
    }

    public String toString() {
        return "TroubleshootingStackItem(helpItem=" + this.f122981a + ", isFinished=" + this.f122982b + ")";
    }

    public /* synthetic */ TroubleshootingStackItem(HelpItem helpItem, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(helpItem, (i3 & 2) != 0 ? false : z2);
    }
}
