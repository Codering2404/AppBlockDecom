package cz.mobilesoft.coreblock.view.timeselector;

import cz.mobilesoft.coreblock.base.ViewCommand;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public abstract class TimeSelectCommand implements ViewCommand {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CloseTimerScreen extends TimeSelectCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final CloseTimerScreen f133337a = new CloseTimerScreen();

        private CloseTimerScreen() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowMaximumTimerValueReached extends TimeSelectCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f133338a;

        public ShowMaximumTimerValueReached(int i3) {
            super(null);
            this.f133338a = i3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowMaximumTimerValueReached) && this.f133338a == ((ShowMaximumTimerValueReached) obj).f133338a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f133338a);
        }

        public String toString() {
            return "ShowMaximumTimerValueReached(maximumDays=" + this.f133338a + ")";
        }
    }

    public /* synthetic */ TimeSelectCommand(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private TimeSelectCommand() {
    }
}
