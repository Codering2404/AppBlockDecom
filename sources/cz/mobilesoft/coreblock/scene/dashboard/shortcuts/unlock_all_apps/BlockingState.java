package cz.mobilesoft.coreblock.scene.dashboard.shortcuts.unlock_all_apps;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class BlockingState {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class BlockingsActive extends BlockingState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final BlockingsActive f101479a = new BlockingsActive();

        private BlockingsActive() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof BlockingsActive);
        }

        public int hashCode() {
            return 1511963207;
        }

        public String toString() {
            return "BlockingsActive";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Loading extends BlockingState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Loading f101480a = new Loading();

        private Loading() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Loading);
        }

        public int hashCode() {
            return -505829633;
        }

        public String toString() {
            return "Loading";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NoActiveBlockings extends BlockingState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NoActiveBlockings f101481a = new NoActiveBlockings();

        private NoActiveBlockings() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof NoActiveBlockings);
        }

        public int hashCode() {
            return 626933882;
        }

        public String toString() {
            return "NoActiveBlockings";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class StrictModeOn extends BlockingState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final StrictModeOn f101482a = new StrictModeOn();

        private StrictModeOn() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof StrictModeOn);
        }

        public int hashCode() {
            return 972493608;
        }

        public String toString() {
            return "StrictModeOn";
        }
    }

    public /* synthetic */ BlockingState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private BlockingState() {
    }
}
