package com.revenuecat.purchases.ui.revenuecatui.customercenter.data;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class ExpirationOrRenewal {
    public static final int $stable = 0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Expiration extends ExpirationOrRenewal {
        public static final int $stable = 0;
        private final String date;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Expiration(String date) {
            super(null);
            Intrinsics.checkNotNullParameter(date, "date");
            this.date = date;
        }

        public static /* synthetic */ Expiration copy$default(Expiration expiration, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = expiration.date;
            }
            return expiration.copy(str);
        }

        public final String component1() {
            return this.date;
        }

        public final Expiration copy(String date) {
            Intrinsics.checkNotNullParameter(date, "date");
            return new Expiration(date);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Expiration) && Intrinsics.areEqual(this.date, ((Expiration) obj).date);
        }

        public final String getDate() {
            return this.date;
        }

        public int hashCode() {
            return this.date.hashCode();
        }

        public String toString() {
            return "Expiration(date=" + this.date + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Renewal extends ExpirationOrRenewal {
        public static final int $stable = 0;
        private final String date;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Renewal(String date) {
            super(null);
            Intrinsics.checkNotNullParameter(date, "date");
            this.date = date;
        }

        public static /* synthetic */ Renewal copy$default(Renewal renewal, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = renewal.date;
            }
            return renewal.copy(str);
        }

        public final String component1() {
            return this.date;
        }

        public final Renewal copy(String date) {
            Intrinsics.checkNotNullParameter(date, "date");
            return new Renewal(date);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Renewal) && Intrinsics.areEqual(this.date, ((Renewal) obj).date);
        }

        public final String getDate() {
            return this.date;
        }

        public int hashCode() {
            return this.date.hashCode();
        }

        public String toString() {
            return "Renewal(date=" + this.date + ')';
        }
    }

    public /* synthetic */ ExpirationOrRenewal(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ExpirationOrRenewal() {
    }
}
