package androidx.compose.runtime.changelist;

import androidx.compose.runtime.Anchor;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SlotWriter;
import kotlin.Metadata;

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
public final class OperationKt {
    private static final int c(SlotWriter slotWriter) {
        int iC0 = slotWriter.c0();
        int iE0 = slotWriter.e0();
        while (iE0 >= 0 && !slotWriter.u0(iE0)) {
            iE0 = slotWriter.I0(iE0);
        }
        int iM0 = iE0 + 1;
        int iG0 = 0;
        while (iM0 < iC0) {
            if (slotWriter.o0(iC0, iM0)) {
                if (slotWriter.u0(iM0)) {
                    iG0 = 0;
                }
                iM0++;
            } else {
                iG0 += slotWriter.u0(iM0) ? 1 : slotWriter.G0(iM0);
                iM0 += slotWriter.m0(iM0);
            }
        }
        return iG0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int d(SlotWriter slotWriter, Anchor anchor, Applier applier) {
        int iE = slotWriter.E(anchor);
        if (!(slotWriter.c0() < iE)) {
            ComposerKt.t("Check failed");
        }
        e(slotWriter, applier, iE);
        int iC = c(slotWriter);
        while (slotWriter.c0() < iE) {
            if (slotWriter.n0(iE)) {
                if (slotWriter.t0()) {
                    applier.h(slotWriter.E0(slotWriter.c0()));
                    iC = 0;
                }
                slotWriter.j1();
            } else {
                iC += slotWriter.Y0();
            }
        }
        if (!(slotWriter.c0() == iE)) {
            ComposerKt.t("Check failed");
        }
        return iC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(SlotWriter slotWriter, Applier applier, int i3) {
        while (!slotWriter.p0(i3)) {
            slotWriter.Z0();
            if (slotWriter.u0(slotWriter.e0())) {
                applier.k();
            }
            slotWriter.T();
        }
    }
}
