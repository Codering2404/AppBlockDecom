package cz.mobilesoft.coreblock.scene.password;

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
public abstract class PassCodeViewCommand implements ViewCommand {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnShowUnlockDialog extends PassCodeViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnShowUnlockDialog f111678a = new OnShowUnlockDialog();

        private OnShowUnlockDialog() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnShowUnlockDialog);
        }

        public int hashCode() {
            return 1277744180;
        }

        public String toString() {
            return "OnShowUnlockDialog";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnSuccess extends PassCodeViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f111679a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccess(String passCode) {
            super(null);
            Intrinsics.checkNotNullParameter(passCode, "passCode");
            this.f111679a = passCode;
        }

        public final String a() {
            return this.f111679a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnSuccess) && Intrinsics.areEqual(this.f111679a, ((OnSuccess) obj).f111679a);
        }

        public int hashCode() {
            return this.f111679a.hashCode();
        }

        public String toString() {
            return "OnSuccess(passCode=" + this.f111679a + ")";
        }
    }

    public /* synthetic */ PassCodeViewCommand(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PassCodeViewCommand() {
    }
}
