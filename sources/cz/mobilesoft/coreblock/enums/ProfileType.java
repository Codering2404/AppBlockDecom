package cz.mobilesoft.coreblock.enums;

import android.os.Parcel;
import android.os.Parcelable;
import cz.mobilesoft.coreblock.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
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
public final class ProfileType implements Parcelable {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ProfileType[] $VALUES;
    public static final Parcelable.Creator<ProfileType> CREATOR;
    public static final Companion Companion;
    private final int mask;
    private final int order;
    public static final ProfileType COMBINED = new ProfileType("COMBINED", 0, -1, -1);
    public static final ProfileType TIME = new ProfileType("TIME", 1, 0, 1);
    public static final ProfileType LOCATION = new ProfileType("LOCATION", 2, 1, 2);
    public static final ProfileType WIFI = new ProfileType("WIFI", 3, 2, 4);
    public static final ProfileType BLUETOOTH = new ProfileType("BLUETOOTH", 4, 3, 8);
    public static final ProfileType STRICT_MODE = new ProfileType("STRICT_MODE", 5, 4, Integer.MIN_VALUE);
    public static final ProfileType USAGE_LIMIT = new ProfileType("USAGE_LIMIT", 6, 5, 16);
    public static final ProfileType LAUNCH_COUNT = new ProfileType("LAUNCH_COUNT", 7, 6, 32);
    public static final ProfileType QUICK_BLOCK = new ProfileType("QUICK_BLOCK", 8, 7, 64);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ProfileType a(int i3, boolean z2) {
            ProfileType profileType;
            ProfileType next;
            if (z2) {
                i3 &= ~ProfileType.STRICT_MODE.mask;
            }
            Iterator<ProfileType> it = ProfileType.getEntries().iterator();
            while (true) {
                profileType = null;
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next.mask == i3) {
                    break;
                }
            }
            ProfileType profileType2 = next;
            if (profileType2 != null) {
                return profileType2;
            }
            ProfileType profileType3 = ProfileType.TIME;
            if (profileType3.isSetTo(i3)) {
                int iClearFrom = profileType3.clearFrom(i3);
                Iterator<ProfileType> it2 = ProfileType.getEntries().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    ProfileType next2 = it2.next();
                    if (next2.mask == iClearFrom) {
                        profileType = next2;
                        break;
                    }
                }
                ProfileType profileType4 = profileType;
                if (profileType4 != null) {
                    return profileType4;
                }
            }
            return ProfileType.COMBINED;
        }

        public final List b(int i3) {
            ArrayList arrayList = new ArrayList();
            for (ProfileType profileType : CollectionsKt.minus(CollectionsKt.minus(ProfileType.getEntries(), ProfileType.COMBINED), ProfileType.STRICT_MODE)) {
                if (profileType.isSetTo(i3)) {
                    arrayList.add(profileType);
                }
            }
            return arrayList;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f97036a;

        static {
            int[] iArr = new int[ProfileType.values().length];
            try {
                iArr[ProfileType.TIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProfileType.LOCATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProfileType.WIFI.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ProfileType.USAGE_LIMIT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ProfileType.LAUNCH_COUNT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f97036a = iArr;
        }
    }

    private static final /* synthetic */ ProfileType[] $values() {
        return new ProfileType[]{COMBINED, TIME, LOCATION, WIFI, BLUETOOTH, STRICT_MODE, USAGE_LIMIT, LAUNCH_COUNT, QUICK_BLOCK};
    }

    static {
        ProfileType[] profileTypeArr$values = $values();
        $VALUES = profileTypeArr$values;
        $ENTRIES = EnumEntriesKt.a(profileTypeArr$values);
        Companion = new Companion(null);
        CREATOR = new Parcelable.Creator<ProfileType>() { // from class: cz.mobilesoft.coreblock.enums.ProfileType.Creator
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final ProfileType createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return ProfileType.valueOf(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final ProfileType[] newArray(int i3) {
                return new ProfileType[i3];
            }
        };
    }

    private ProfileType(String str, int i3, int i4, int i5) {
        this.order = i4;
        this.mask = i5;
    }

    @JvmStatic
    public static final ProfileType getByMask(int i3, boolean z2) {
        return Companion.a(i3, z2);
    }

    public static EnumEntries<ProfileType> getEntries() {
        return $ENTRIES;
    }

    public static ProfileType valueOf(String str) {
        return (ProfileType) Enum.valueOf(ProfileType.class, str);
    }

    public static ProfileType[] values() {
        return (ProfileType[]) $VALUES.clone();
    }

    public final boolean canBeChangedInStrictMode() {
        int i3 = WhenMappings.f97036a[ordinal()];
        return i3 == 1 || i3 == 3 || i3 == 4 || i3 == 5;
    }

    public final int clearFrom(int i3) {
        return i3 & (~this.mask);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int getActiveScheduleIconResId() {
        int i3 = WhenMappings.f97036a[ordinal()];
        return i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? i3 != 5 ? R.drawable.N4 : R.drawable.U2 : R.drawable.T4 : R.drawable.V4 : R.drawable.P4 : R.drawable.R4;
    }

    public final int getAlternativeScheduleIconResId() {
        int i3 = WhenMappings.f97036a[ordinal()];
        return i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? i3 != 5 ? R.drawable.M1 : R.drawable.T2 : R.drawable.M6 : R.drawable.Y6 : R.drawable.s3 : R.drawable.n6;
    }

    public final Integer getBigScheduleImageResId() {
        int i3 = WhenMappings.f97036a[ordinal()];
        if (i3 == 1) {
            return Integer.valueOf(R.drawable.z7);
        }
        if (i3 == 2) {
            return Integer.valueOf(R.drawable.y7);
        }
        if (i3 == 3) {
            return Integer.valueOf(R.drawable.B7);
        }
        if (i3 == 4) {
            return Integer.valueOf(R.drawable.A7);
        }
        if (i3 != 5) {
            return null;
        }
        return Integer.valueOf(R.drawable.x7);
    }

    public final Integer getDisabledBigScheduleImageResId() {
        int i3 = WhenMappings.f97036a[ordinal()];
        if (i3 == 1) {
            return Integer.valueOf(R.drawable.u7);
        }
        if (i3 == 2) {
            return Integer.valueOf(R.drawable.t7);
        }
        if (i3 == 3) {
            return Integer.valueOf(R.drawable.w7);
        }
        if (i3 == 4) {
            return Integer.valueOf(R.drawable.v7);
        }
        if (i3 != 5) {
            return null;
        }
        return Integer.valueOf(R.drawable.s7);
    }

    public final int getDisabledScheduleIconResId() {
        int i3 = WhenMappings.f97036a[ordinal()];
        return i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? i3 != 5 ? R.drawable.O4 : R.drawable.V2 : R.drawable.U4 : R.drawable.W4 : R.drawable.Q4 : R.drawable.S4;
    }

    public final Integer getHintResId() {
        int i3 = WhenMappings.f97036a[ordinal()];
        if (i3 == 1) {
            return Integer.valueOf(R.string.nv);
        }
        if (i3 == 2) {
            return Integer.valueOf(R.string.mu);
        }
        if (i3 == 3) {
            return Integer.valueOf(R.string.qv);
        }
        if (i3 == 4) {
            return Integer.valueOf(R.string.pv);
        }
        if (i3 != 5) {
            return null;
        }
        return Integer.valueOf(R.string.uu);
    }

    public final Integer getNotAvailableWithTextResId() {
        int i3 = WhenMappings.f97036a[ordinal()];
        if (i3 == 4) {
            return Integer.valueOf(R.string.tu);
        }
        if (i3 != 5) {
            return null;
        }
        return Integer.valueOf(R.string.su);
    }

    public final List<Integer> getScheduleHintTagResIdList() {
        int i3 = WhenMappings.f97036a[ordinal()];
        if (i3 == 1) {
            return CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.string.gu), Integer.valueOf(R.string.du), Integer.valueOf(R.string.Vt), Integer.valueOf(R.string.Wt)});
        }
        if (i3 == 2) {
            return CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.string.cu), Integer.valueOf(R.string.gu), Integer.valueOf(R.string.Zt)});
        }
        if (i3 == 3) {
            return CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.string.Xt), Integer.valueOf(R.string.bu), Integer.valueOf(R.string.fu)});
        }
        if (i3 == 4) {
            return CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.string.Yt), Integer.valueOf(R.string.eu)});
        }
        if (i3 != 5) {
            return null;
        }
        return CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.string.Yt), Integer.valueOf(R.string.Wt), Integer.valueOf(R.string.au)});
    }

    public final Integer getTitleResId() {
        int i3 = WhenMappings.f97036a[ordinal()];
        if (i3 == 1) {
            return Integer.valueOf(R.string.Lq);
        }
        if (i3 == 2) {
            return Integer.valueOf(R.string.Iq);
        }
        if (i3 == 3) {
            return Integer.valueOf(R.string.Mq);
        }
        if (i3 == 4) {
            return Integer.valueOf(R.string.JF);
        }
        if (i3 != 5) {
            return null;
        }
        return Integer.valueOf(R.string.Bi);
    }

    public final boolean isSetTo(int i3) {
        return (i3 & this.mask) != 0;
    }

    public final int mask() {
        return this.mask;
    }

    @Deprecated
    public final int order() {
        return this.order;
    }

    public final int setTo(int i3) {
        return i3 | this.mask;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i3) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(name());
    }
}
