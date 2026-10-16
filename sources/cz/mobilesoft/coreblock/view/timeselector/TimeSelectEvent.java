package cz.mobilesoft.coreblock.view.timeselector;

import cz.mobilesoft.coreblock.base.ViewEvent;
import cz.mobilesoft.coreblock.view.timeselector.TimeSelectViewState;
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
public abstract class TimeSelectEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnBackspaceClicked extends TimeSelectEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnBackspaceClicked f133339a = new OnBackspaceClicked();

        private OnBackspaceClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnDoubleZeroesClicked extends TimeSelectEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnDoubleZeroesClicked f133340a = new OnDoubleZeroesClicked();

        private OnDoubleZeroesClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnNumberClicked extends TimeSelectEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f133341a;

        public final int a() {
            return this.f133341a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnNumberClicked) && this.f133341a == ((OnNumberClicked) obj).f133341a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f133341a);
        }

        public String toString() {
            return "OnNumberClicked(number=" + this.f133341a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnTimeTypeClicked extends TimeSelectEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TimeSelectViewState.TimeType f133342a;

        public final TimeSelectViewState.TimeType a() {
            return this.f133342a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnTimeTypeClicked) && this.f133342a == ((OnTimeTypeClicked) obj).f133342a;
        }

        public int hashCode() {
            return this.f133342a.hashCode();
        }

        public String toString() {
            return "OnTimeTypeClicked(timeType=" + this.f133342a + ")";
        }
    }

    public /* synthetic */ TimeSelectEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private TimeSelectEvent() {
    }
}
