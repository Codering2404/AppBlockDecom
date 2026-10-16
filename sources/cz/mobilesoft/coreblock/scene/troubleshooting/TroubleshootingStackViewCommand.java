package cz.mobilesoft.coreblock.scene.troubleshooting;

import cz.mobilesoft.coreblock.base.ViewCommand;
import kotlin.Metadata;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public abstract class TroubleshootingStackViewCommand implements ViewCommand {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Finish extends TroubleshootingStackViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Finish f122983a = new Finish();

        private Finish() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Finish);
        }

        public int hashCode() {
            return 387774922;
        }

        public String toString() {
            return "Finish";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowHelpItem extends TroubleshootingStackViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Function1 f122984a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowHelpItem(Function1 action) {
            super(null);
            Intrinsics.checkNotNullParameter(action, "action");
            this.f122984a = action;
        }

        public final Function1 a() {
            return this.f122984a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowHelpItem) && Intrinsics.areEqual(this.f122984a, ((ShowHelpItem) obj).f122984a);
        }

        public int hashCode() {
            return this.f122984a.hashCode();
        }

        public String toString() {
            return "ShowHelpItem(action=" + this.f122984a + ")";
        }
    }

    public /* synthetic */ TroubleshootingStackViewCommand(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private TroubleshootingStackViewCommand() {
    }
}
