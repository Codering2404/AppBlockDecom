package com.revenuecat.purchases.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.revenuecat.purchases.ReplacementMode;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class StoreReplacementMode implements ReplacementMode {
    public static final StoreReplacementMode CHARGE_FULL_PRICE;
    public static final StoreReplacementMode CHARGE_PRORATED_PRICE;
    public static final StoreReplacementMode DEFERRED;
    public static final StoreReplacementMode WITHOUT_PRORATION;
    public static final StoreReplacementMode WITH_TIME_PRORATION;
    private static final List<StoreReplacementMode> allModes;
    private final String name;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<StoreReplacementMode> CREATOR = new Creator();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final StoreReplacementMode fromName$purchases_defaultsBc8Release(String name) {
            Object next;
            Intrinsics.checkNotNullParameter(name, "name");
            Iterator it = StoreReplacementMode.allModes.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (Intrinsics.areEqual(((StoreReplacementMode) next).getName(), name)) {
                    break;
                }
            }
            return (StoreReplacementMode) next;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Creator implements Parcelable.Creator<StoreReplacementMode> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final StoreReplacementMode createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new StoreReplacementMode(parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final StoreReplacementMode[] newArray(int i3) {
            return new StoreReplacementMode[i3];
        }
    }

    static {
        StoreReplacementMode storeReplacementMode = new StoreReplacementMode("WITHOUT_PRORATION");
        WITHOUT_PRORATION = storeReplacementMode;
        StoreReplacementMode storeReplacementMode2 = new StoreReplacementMode("WITH_TIME_PRORATION");
        WITH_TIME_PRORATION = storeReplacementMode2;
        StoreReplacementMode storeReplacementMode3 = new StoreReplacementMode("CHARGE_FULL_PRICE");
        CHARGE_FULL_PRICE = storeReplacementMode3;
        StoreReplacementMode storeReplacementMode4 = new StoreReplacementMode("CHARGE_PRORATED_PRICE");
        CHARGE_PRORATED_PRICE = storeReplacementMode4;
        StoreReplacementMode storeReplacementMode5 = new StoreReplacementMode("DEFERRED");
        DEFERRED = storeReplacementMode5;
        allModes = CollectionsKt.listOf((Object[]) new StoreReplacementMode[]{storeReplacementMode, storeReplacementMode2, storeReplacementMode3, storeReplacementMode4, storeReplacementMode5});
    }

    public StoreReplacementMode(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StoreReplacementMode) && Intrinsics.areEqual(this.name, ((StoreReplacementMode) obj).name);
    }

    @Override // com.revenuecat.purchases.ReplacementMode
    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public String toString() {
        return getName();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.name);
    }
}
