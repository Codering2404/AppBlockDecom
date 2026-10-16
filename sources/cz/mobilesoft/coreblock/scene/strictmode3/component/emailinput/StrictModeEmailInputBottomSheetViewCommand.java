package cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput;

import cz.mobilesoft.coreblock.base.ViewCommand;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public abstract class StrictModeEmailInputBottomSheetViewCommand implements ViewCommand {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ApprovalEmailSet extends StrictModeEmailInputBottomSheetViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f121859a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ApprovalEmailSet(String email) {
            super(null);
            Intrinsics.checkNotNullParameter(email, "email");
            this.f121859a = email;
        }

        public final String a() {
            return this.f121859a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ApprovalEmailSet) && Intrinsics.areEqual(this.f121859a, ((ApprovalEmailSet) obj).f121859a);
        }

        public int hashCode() {
            return this.f121859a.hashCode();
        }

        public String toString() {
            return "ApprovalEmailSet(email=" + this.f121859a + ")";
        }
    }

    public /* synthetic */ StrictModeEmailInputBottomSheetViewCommand(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private StrictModeEmailInputBottomSheetViewCommand() {
    }
}
