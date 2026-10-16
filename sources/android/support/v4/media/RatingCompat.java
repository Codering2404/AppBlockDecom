package android.support.v4.media;

import android.media.Rating;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new Parcelable.Creator<RatingCompat>() { // from class: android.support.v4.media.RatingCompat.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public RatingCompat[] newArray(int i3) {
            return new RatingCompat[i3];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f203c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface StarStyle {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Style {
    }

    RatingCompat(int i3, float f3) {
        this.f201a = i3;
        this.f202b = f3;
    }

    public static RatingCompat a(Object obj) {
        RatingCompat ratingCompatG = null;
        if (obj != null) {
            Rating rating = (Rating) obj;
            int ratingStyle = rating.getRatingStyle();
            if (rating.isRated()) {
                switch (ratingStyle) {
                    case 1:
                        ratingCompatG = c(rating.hasHeart());
                        break;
                    case 2:
                        ratingCompatG = f(rating.isThumbUp());
                        break;
                    case 3:
                    case 4:
                    case 5:
                        ratingCompatG = e(ratingStyle, rating.getStarRating());
                        break;
                    case 6:
                        ratingCompatG = d(rating.getPercentRating());
                        break;
                    default:
                        return null;
                }
            } else {
                ratingCompatG = g(ratingStyle);
            }
            ratingCompatG.f203c = obj;
        }
        return ratingCompatG;
    }

    public static RatingCompat c(boolean z2) {
        return new RatingCompat(1, z2 ? 1.0f : 0.0f);
    }

    public static RatingCompat d(float f3) {
        if (f3 >= 0.0f && f3 <= 100.0f) {
            return new RatingCompat(6, f3);
        }
        Log.e("Rating", "Invalid percentage-based rating value");
        return null;
    }

    public static RatingCompat e(int i3, float f3) {
        float f4;
        if (i3 == 3) {
            f4 = 3.0f;
        } else if (i3 == 4) {
            f4 = 4.0f;
        } else {
            if (i3 != 5) {
                Log.e("Rating", "Invalid rating style (" + i3 + ") for a star rating");
                return null;
            }
            f4 = 5.0f;
        }
        if (f3 >= 0.0f && f3 <= f4) {
            return new RatingCompat(i3, f3);
        }
        Log.e("Rating", "Trying to set out of range star-based rating");
        return null;
    }

    public static RatingCompat f(boolean z2) {
        return new RatingCompat(2, z2 ? 1.0f : 0.0f);
    }

    public static RatingCompat g(int i3) {
        switch (i3) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return new RatingCompat(i3, -1.0f);
            default:
                return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return this.f201a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rating:style=");
        sb.append(this.f201a);
        sb.append(" rating=");
        float f3 = this.f202b;
        sb.append(f3 < 0.0f ? "unrated" : String.valueOf(f3));
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f201a);
        parcel.writeFloat(this.f202b);
    }
}
