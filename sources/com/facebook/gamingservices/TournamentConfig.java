package com.facebook.gamingservices;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.gamingservices.internal.DateFormatter;
import com.facebook.gamingservices.internal.TournamentScoreType;
import com.facebook.gamingservices.internal.TournamentSortOrder;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.ShareModelBuilder;
import java.time.Instant;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class TournamentConfig implements ShareModel {
    public static final CREATOR CREATOR = new CREATOR(null);
    private final Instant endTime;
    private final Image image;
    private final String payload;
    private final TournamentScoreType scoreType;
    private final TournamentSortOrder sortOrder;
    private final String title;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder implements ShareModelBuilder<TournamentConfig, Builder> {
        private Instant endTime;
        private Image image;
        private String payload;
        private TournamentScoreType scoreType;
        private TournamentSortOrder sortOrder;
        private String title;

        public final Instant getEndTime() {
            return this.endTime;
        }

        public final Image getImage() {
            return this.image;
        }

        public final String getPayload() {
            return this.payload;
        }

        public final TournamentScoreType getScoreType() {
            return this.scoreType;
        }

        public final TournamentSortOrder getSortOrder() {
            return this.sortOrder;
        }

        public final String getTitle() {
            return this.title;
        }

        public final Builder readFrom$facebook_gamingservices_release(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return readFrom((TournamentConfig) parcel.readParcelable(TournamentConfig.class.getClassLoader()));
        }

        public final void setEndTime(Instant instant) {
            this.endTime = instant;
        }

        public final void setImage(Image image) {
            this.image = image;
        }

        public final void setPayload(String str) {
            this.payload = str;
        }

        public final void setScoreType(TournamentScoreType tournamentScoreType) {
            this.scoreType = tournamentScoreType;
        }

        public final void setSortOrder(TournamentSortOrder tournamentSortOrder) {
            this.sortOrder = tournamentSortOrder;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final Builder setTournamentEndTime(Instant endTime) {
            Intrinsics.checkNotNullParameter(endTime, "endTime");
            this.endTime = endTime;
            return this;
        }

        public final Builder setTournamentImage(Image image) {
            this.image = image;
            return this;
        }

        public final Builder setTournamentPayload(String str) {
            this.payload = str;
            return this;
        }

        public final Builder setTournamentScoreType(TournamentScoreType scoreType) {
            Intrinsics.checkNotNullParameter(scoreType, "scoreType");
            this.scoreType = scoreType;
            return this;
        }

        public final Builder setTournamentSortOrder(TournamentSortOrder sortOrder) {
            Intrinsics.checkNotNullParameter(sortOrder, "sortOrder");
            this.sortOrder = sortOrder;
            return this;
        }

        public final Builder setTournamentTitle(String str) {
            this.title = str;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public TournamentConfig build() {
            return new TournamentConfig(this, null);
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(TournamentConfig tournamentConfig) {
            if (tournamentConfig == null) {
                return this;
            }
            TournamentSortOrder sortOrder = tournamentConfig.getSortOrder();
            if (sortOrder != null) {
                setTournamentSortOrder(sortOrder);
            }
            TournamentScoreType scoreType = tournamentConfig.getScoreType();
            if (scoreType != null) {
                setTournamentScoreType(scoreType);
            }
            Instant endTime = tournamentConfig.getEndTime();
            if (endTime != null) {
                setTournamentEndTime(endTime);
            }
            String title = tournamentConfig.getTitle();
            if (title != null) {
                setTournamentTitle(title);
            }
            setTournamentPayload(tournamentConfig.getPayload());
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CREATOR implements Parcelable.Creator<TournamentConfig> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TournamentConfig createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new TournamentConfig(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TournamentConfig[] newArray(int i3) {
            return new TournamentConfig[i3];
        }
    }

    public /* synthetic */ TournamentConfig(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final Instant getEndTime() {
        return this.endTime;
    }

    public final Image getImage() {
        return this.image;
    }

    public final String getPayload() {
        return this.payload;
    }

    public final TournamentScoreType getScoreType() {
        return this.scoreType;
    }

    public final TournamentSortOrder getSortOrder() {
        return this.sortOrder;
    }

    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(String.valueOf(this.sortOrder));
        out.writeString(String.valueOf(this.scoreType));
        out.writeString(String.valueOf(this.endTime));
        out.writeString(this.title);
        out.writeString(this.payload);
    }

    private TournamentConfig(Builder builder) {
        this.title = builder.getTitle();
        this.sortOrder = builder.getSortOrder();
        this.scoreType = builder.getScoreType();
        this.endTime = builder.getEndTime();
        this.image = builder.getImage();
        this.payload = builder.getPayload();
    }

    public TournamentConfig(Parcel parcel) {
        TournamentSortOrder tournamentSortOrder;
        TournamentScoreType tournamentScoreType;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.title = parcel.readString();
        TournamentSortOrder[] tournamentSortOrderArrValues = TournamentSortOrder.values();
        int length = tournamentSortOrderArrValues.length;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                tournamentSortOrder = null;
                break;
            }
            tournamentSortOrder = tournamentSortOrderArrValues[i4];
            if (Intrinsics.areEqual(tournamentSortOrder.name(), parcel.readString())) {
                break;
            } else {
                i4++;
            }
        }
        this.sortOrder = tournamentSortOrder;
        TournamentScoreType[] tournamentScoreTypeArrValues = TournamentScoreType.values();
        int length2 = tournamentScoreTypeArrValues.length;
        while (true) {
            if (i3 >= length2) {
                tournamentScoreType = null;
                break;
            }
            tournamentScoreType = tournamentScoreTypeArrValues[i3];
            if (Intrinsics.areEqual(tournamentScoreType.name(), parcel.readString())) {
                break;
            } else {
                i3++;
            }
        }
        this.scoreType = tournamentScoreType;
        String string = parcel.readString();
        this.endTime = string != null ? Instant.from(DateFormatter.INSTANCE.format$facebook_gamingservices_release(string)) : null;
        this.payload = parcel.readString();
        this.image = null;
    }
}
