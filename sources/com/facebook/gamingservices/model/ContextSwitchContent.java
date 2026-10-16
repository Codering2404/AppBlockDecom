package com.facebook.gamingservices.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.ShareModelBuilder;
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
public final class ContextSwitchContent implements ShareModel {
    public static final CREATOR CREATOR = new CREATOR(null);
    private final String contextID;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder implements ShareModelBuilder<ContextSwitchContent, Builder> {
        private String contextID;

        public final String getContextID$facebook_gamingservices_release() {
            return this.contextID;
        }

        public final Builder setContextID(String str) {
            this.contextID = str;
            return this;
        }

        public final void setContextID$facebook_gamingservices_release(String str) {
            this.contextID = str;
        }

        @Override // com.facebook.share.ShareBuilder
        public ContextSwitchContent build() {
            return new ContextSwitchContent(this, null);
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(ContextSwitchContent contextSwitchContent) {
            Builder contextID;
            return (contextSwitchContent == null || (contextID = setContextID(contextSwitchContent.getContextID())) == null) ? this : contextID;
        }

        public final Builder readFrom(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return readFrom((ContextSwitchContent) parcel.readParcelable(ContextSwitchContent.class.getClassLoader()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CREATOR implements Parcelable.Creator<ContextSwitchContent> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContextSwitchContent createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ContextSwitchContent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContextSwitchContent[] newArray(int i3) {
            return new ContextSwitchContent[i3];
        }
    }

    public /* synthetic */ ContextSwitchContent(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getContextID() {
        return this.contextID;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.contextID);
    }

    private ContextSwitchContent(Builder builder) {
        this.contextID = builder.getContextID$facebook_gamingservices_release();
    }

    public ContextSwitchContent(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.contextID = parcel.readString();
    }
}
