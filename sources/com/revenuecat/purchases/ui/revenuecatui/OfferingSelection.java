package com.revenuecat.purchases.ui.revenuecatui;

import android.os.Parcel;
import android.os.Parcelable;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.PresentedOfferingContext;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
public abstract class OfferingSelection {
    public static final int $stable = 0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class IdAndPresentedOfferingContext extends OfferingSelection implements Parcelable {
        public static final int $stable = 0;
        public static final Parcelable.Creator<IdAndPresentedOfferingContext> CREATOR = new Creator();
        private final String offeringId;
        private final PresentedOfferingContext presentedOfferingContext;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Creator implements Parcelable.Creator<IdAndPresentedOfferingContext> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final IdAndPresentedOfferingContext createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new IdAndPresentedOfferingContext(parcel.readString(), (PresentedOfferingContext) parcel.readParcelable(IdAndPresentedOfferingContext.class.getClassLoader()));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final IdAndPresentedOfferingContext[] newArray(int i3) {
                return new IdAndPresentedOfferingContext[i3];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IdAndPresentedOfferingContext(String offeringId, PresentedOfferingContext presentedOfferingContext) {
            super(null);
            Intrinsics.checkNotNullParameter(offeringId, "offeringId");
            this.offeringId = offeringId;
            this.presentedOfferingContext = presentedOfferingContext;
        }

        public static /* synthetic */ IdAndPresentedOfferingContext copy$default(IdAndPresentedOfferingContext idAndPresentedOfferingContext, String str, PresentedOfferingContext presentedOfferingContext, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = idAndPresentedOfferingContext.offeringId;
            }
            if ((i3 & 2) != 0) {
                presentedOfferingContext = idAndPresentedOfferingContext.presentedOfferingContext;
            }
            return idAndPresentedOfferingContext.copy(str, presentedOfferingContext);
        }

        public final String component1() {
            return this.offeringId;
        }

        public final PresentedOfferingContext component2() {
            return this.presentedOfferingContext;
        }

        public final IdAndPresentedOfferingContext copy(String offeringId, PresentedOfferingContext presentedOfferingContext) {
            Intrinsics.checkNotNullParameter(offeringId, "offeringId");
            return new IdAndPresentedOfferingContext(offeringId, presentedOfferingContext);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IdAndPresentedOfferingContext)) {
                return false;
            }
            IdAndPresentedOfferingContext idAndPresentedOfferingContext = (IdAndPresentedOfferingContext) obj;
            return Intrinsics.areEqual(this.offeringId, idAndPresentedOfferingContext.offeringId) && Intrinsics.areEqual(this.presentedOfferingContext, idAndPresentedOfferingContext.presentedOfferingContext);
        }

        public final String getOfferingId() {
            return this.offeringId;
        }

        public final PresentedOfferingContext getPresentedOfferingContext() {
            return this.presentedOfferingContext;
        }

        public int hashCode() {
            int iHashCode = this.offeringId.hashCode() * 31;
            PresentedOfferingContext presentedOfferingContext = this.presentedOfferingContext;
            return iHashCode + (presentedOfferingContext == null ? 0 : presentedOfferingContext.hashCode());
        }

        public String toString() {
            return "IdAndPresentedOfferingContext(offeringId=" + this.offeringId + ", presentedOfferingContext=" + this.presentedOfferingContext + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i3) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeString(this.offeringId);
            out.writeParcelable(this.presentedOfferingContext, i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class None extends OfferingSelection {
        public static final int $stable = 0;
        public static final None INSTANCE = new None();

        private None() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OfferingType extends OfferingSelection {
        public static final int $stable = 0;
        private final Offering offeringType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OfferingType(Offering offeringType) {
            super(null);
            Intrinsics.checkNotNullParameter(offeringType, "offeringType");
            this.offeringType = offeringType;
        }

        public static /* synthetic */ OfferingType copy$default(OfferingType offeringType, Offering offering, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                offering = offeringType.offeringType;
            }
            return offeringType.copy(offering);
        }

        public final Offering component1() {
            return this.offeringType;
        }

        public final OfferingType copy(Offering offeringType) {
            Intrinsics.checkNotNullParameter(offeringType, "offeringType");
            return new OfferingType(offeringType);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OfferingType) && Intrinsics.areEqual(this.offeringType, ((OfferingType) obj).offeringType);
        }

        public final Offering getOfferingType() {
            return this.offeringType;
        }

        public int hashCode() {
            return this.offeringType.hashCode();
        }

        public String toString() {
            return "OfferingType(offeringType=" + this.offeringType + ')';
        }
    }

    public /* synthetic */ OfferingSelection(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final Offering getOffering() {
        if (this instanceof OfferingType) {
            return ((OfferingType) this).getOfferingType();
        }
        if ((this instanceof IdAndPresentedOfferingContext) || Intrinsics.areEqual(this, None.INSTANCE)) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final String getOfferingIdentifier() {
        if (this instanceof OfferingType) {
            return ((OfferingType) this).getOfferingType().getIdentifier();
        }
        if (this instanceof IdAndPresentedOfferingContext) {
            return ((IdAndPresentedOfferingContext) this).getOfferingId();
        }
        if (Intrinsics.areEqual(this, None.INSTANCE)) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    private OfferingSelection() {
    }
}
