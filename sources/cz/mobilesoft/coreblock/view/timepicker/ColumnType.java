package cz.mobilesoft.coreblock.view.timepicker;

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
abstract class ColumnType {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Custom extends ColumnType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Integer f132965a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f132966b;

        public Custom(Integer num, boolean z2) {
            super(null);
            this.f132965a = num;
            this.f132966b = z2;
        }

        public final Integer a() {
            return this.f132965a;
        }

        public final boolean b() {
            return this.f132966b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Custom)) {
                return false;
            }
            Custom custom = (Custom) obj;
            return Intrinsics.areEqual(this.f132965a, custom.f132965a) && this.f132966b == custom.f132966b;
        }

        public int hashCode() {
            Integer num = this.f132965a;
            return ((num == null ? 0 : num.hashCode()) * 31) + Boolean.hashCode(this.f132966b);
        }

        public String toString() {
            return "Custom(resId=" + this.f132965a + ", isAmPm=" + this.f132966b + ")";
        }

        public /* synthetic */ Custom(Integer num, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? false : z2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Days extends ColumnType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Days f132967a = new Days();

        private Days() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Days);
        }

        public int hashCode() {
            return 3812928;
        }

        public String toString() {
            return "Days";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Hours extends ColumnType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Hours f132968a = new Hours();

        private Hours() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Hours);
        }

        public int hashCode() {
            return 122308166;
        }

        public String toString() {
            return "Hours";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Minutes extends ColumnType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Minutes f132969a = new Minutes();

        private Minutes() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Minutes);
        }

        public int hashCode() {
            return 1538435670;
        }

        public String toString() {
            return "Minutes";
        }
    }

    public /* synthetic */ ColumnType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ColumnType() {
    }
}
