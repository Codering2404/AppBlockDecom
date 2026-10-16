package cz.mobilesoft.coreblock.util.profile;

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
public abstract class ProfileItemType {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Dashboard extends ProfileItemType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Dashboard f129300a = new Dashboard();

        private Dashboard() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class DetailList extends ProfileItemType {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Intro extends DetailList {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final Intro f129301a = new Intro();

            private Intro() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Statistics extends DetailList {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final Statistics f129302a = new Statistics();

            private Statistics() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class StrictMode extends DetailList {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final StrictMode f129303a = new StrictMode();

            private StrictMode() {
                super(null);
            }
        }

        public /* synthetic */ DetailList(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private DetailList() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class SelectBottomSheet extends ProfileItemType {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Statistics extends SelectBottomSheet {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final Statistics f129304a = new Statistics();

            private Statistics() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class StrictMode extends SelectBottomSheet {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final StrictMode f129305a = new StrictMode();

            private StrictMode() {
                super(null);
            }
        }

        public /* synthetic */ SelectBottomSheet(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private SelectBottomSheet() {
            super(null);
        }
    }

    public /* synthetic */ ProfileItemType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ProfileItemType() {
    }
}
