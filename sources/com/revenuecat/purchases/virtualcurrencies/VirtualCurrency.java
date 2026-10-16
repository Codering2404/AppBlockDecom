package com.revenuecat.purchases.virtualcurrencies;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

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
@Serializable
public final class VirtualCurrency implements Parcelable {
    private final int balance;
    private final String code;
    private final String name;
    private final String serverDescription;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<VirtualCurrency> CREATOR = new Creator();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<VirtualCurrency> serializer() {
            return VirtualCurrency$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Creator implements Parcelable.Creator<VirtualCurrency> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VirtualCurrency createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new VirtualCurrency(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VirtualCurrency[] newArray(int i3) {
            return new VirtualCurrency[i3];
        }
    }

    @Deprecated
    public /* synthetic */ VirtualCurrency(int i3, int i4, String str, String str2, @SerialName String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i3 & 7)) {
            PluginExceptionsKt.b(i3, 7, VirtualCurrency$$serializer.INSTANCE.getDescriptor());
        }
        this.balance = i4;
        this.name = str;
        this.code = str2;
        if ((i3 & 8) == 0) {
            this.serverDescription = null;
        } else {
            this.serverDescription = str3;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(VirtualCurrency virtualCurrency, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.w(serialDescriptor, 0, virtualCurrency.balance);
        compositeEncoder.y(serialDescriptor, 1, virtualCurrency.name);
        compositeEncoder.y(serialDescriptor, 2, virtualCurrency.code);
        if (!compositeEncoder.z(serialDescriptor, 3) && virtualCurrency.serverDescription == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 3, StringSerializer.f142891a, virtualCurrency.serverDescription);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VirtualCurrency)) {
            return false;
        }
        VirtualCurrency virtualCurrency = (VirtualCurrency) obj;
        return this.balance == virtualCurrency.balance && Intrinsics.areEqual(this.name, virtualCurrency.name) && Intrinsics.areEqual(this.code, virtualCurrency.code) && Intrinsics.areEqual(this.serverDescription, virtualCurrency.serverDescription);
    }

    public final int getBalance() {
        return this.balance;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getName() {
        return this.name;
    }

    public final String getServerDescription() {
        return this.serverDescription;
    }

    public int hashCode() {
        int iHashCode = ((((this.balance * 31) + this.name.hashCode()) * 31) + this.code.hashCode()) * 31;
        String str = this.serverDescription;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "VirtualCurrency(balance=" + this.balance + ", name=" + this.name + ", code=" + this.code + ", serverDescription=" + this.serverDescription + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeInt(this.balance);
        out.writeString(this.name);
        out.writeString(this.code);
        out.writeString(this.serverDescription);
    }

    public VirtualCurrency(int i3, String name, String code, String str) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(code, "code");
        this.balance = i3;
        this.name = name;
        this.code = code;
        this.serverDescription = str;
    }

    public /* synthetic */ VirtualCurrency(int i3, String str, String str2, String str3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, str2, (i4 & 8) != 0 ? null : str3);
    }

    @SerialName
    public static /* synthetic */ void getServerDescription$annotations() {
    }
}
