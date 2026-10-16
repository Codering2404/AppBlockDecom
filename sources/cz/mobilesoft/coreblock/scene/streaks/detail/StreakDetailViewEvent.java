package cz.mobilesoft.coreblock.scene.streaks.detail;

import cz.mobilesoft.coreblock.base.ViewEvent;
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
public abstract class StreakDetailViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnBetaBadgeClicked extends StreakDetailViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnBetaBadgeClicked f120687a = new OnBetaBadgeClicked();

        private OnBetaBadgeClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnBetaBadgeClicked);
        }

        public int hashCode() {
            return -1290697358;
        }

        public String toString() {
            return "OnBetaBadgeClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnCreateBlockingClicked extends StreakDetailViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnCreateBlockingClicked f120688a = new OnCreateBlockingClicked();

        private OnCreateBlockingClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnCreateBlockingClicked);
        }

        public int hashCode() {
            return 1241533432;
        }

        public String toString() {
            return "OnCreateBlockingClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnMonthSelected extends StreakDetailViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f120689a;

        public OnMonthSelected(int i3) {
            super(null);
            this.f120689a = i3;
        }

        public final int a() {
            return this.f120689a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnMonthSelected) && this.f120689a == ((OnMonthSelected) obj).f120689a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f120689a);
        }

        public String toString() {
            return "OnMonthSelected(index=" + this.f120689a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnNextMonthClicked extends StreakDetailViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnNextMonthClicked f120690a = new OnNextMonthClicked();

        private OnNextMonthClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnNextMonthClicked);
        }

        public int hashCode() {
            return 1144521848;
        }

        public String toString() {
            return "OnNextMonthClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPreviousMonthClicked extends StreakDetailViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnPreviousMonthClicked f120691a = new OnPreviousMonthClicked();

        private OnPreviousMonthClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnPreviousMonthClicked);
        }

        public int hashCode() {
            return -1140396164;
        }

        public String toString() {
            return "OnPreviousMonthClicked";
        }
    }

    public /* synthetic */ StreakDetailViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private StreakDetailViewEvent() {
    }
}
