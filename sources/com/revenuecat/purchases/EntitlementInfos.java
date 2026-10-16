package com.revenuecat.purchases;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
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
public final class EntitlementInfos implements Parcelable {
    public static final Parcelable.Creator<EntitlementInfos> CREATOR = new Creator();
    private final Map<String, EntitlementInfo> active;
    private final Map<String, EntitlementInfo> all;
    private final VerificationResult verification;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Creator implements Parcelable.Creator<EntitlementInfos> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final EntitlementInfos createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i3 = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(i3);
            for (int i4 = 0; i4 != i3; i4++) {
                linkedHashMap.put(parcel.readString(), EntitlementInfo.CREATOR.createFromParcel(parcel));
            }
            return new EntitlementInfos(linkedHashMap, VerificationResult.valueOf(parcel.readString()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final EntitlementInfos[] newArray(int i3) {
            return new EntitlementInfos[i3];
        }
    }

    public EntitlementInfos(Map<String, EntitlementInfo> all, VerificationResult verification) {
        Intrinsics.checkNotNullParameter(all, "all");
        Intrinsics.checkNotNullParameter(verification, "verification");
        this.all = all;
        this.verification = verification;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, EntitlementInfo> entry : all.entrySet()) {
            if (entry.getValue().isActive()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        this.active = linkedHashMap;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(EntitlementInfos.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.revenuecat.purchases.EntitlementInfos");
        EntitlementInfos entitlementInfos = (EntitlementInfos) obj;
        return Intrinsics.areEqual(this.all, entitlementInfos.all) && Intrinsics.areEqual(this.active, entitlementInfos.active) && this.verification == entitlementInfos.verification;
    }

    public final EntitlementInfo get(String s2) {
        Intrinsics.checkNotNullParameter(s2, "s");
        return this.all.get(s2);
    }

    public final Map<String, EntitlementInfo> getActive() {
        return this.active;
    }

    public final Map<String, EntitlementInfo> getAll() {
        return this.all;
    }

    public final VerificationResult getVerification() {
        return this.verification;
    }

    public int hashCode() {
        return (this.all.hashCode() * 31) + this.active.hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        Map<String, EntitlementInfo> map = this.all;
        out.writeInt(map.size());
        for (Map.Entry<String, EntitlementInfo> entry : map.entrySet()) {
            out.writeString(entry.getKey());
            entry.getValue().writeToParcel(out, i3);
        }
        out.writeString(this.verification.name());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public EntitlementInfos(Map<String, EntitlementInfo> all) {
        this(all, VerificationResult.NOT_REQUESTED);
        Intrinsics.checkNotNullParameter(all, "all");
    }
}
