package com.facebook.gamingservices.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.ShareModelBuilder;
import java.util.Collections;
import java.util.List;
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
public final class ContextChooseContent implements ShareModel {
    public static final CREATOR CREATOR = new CREATOR(null);
    private final List<String> filters;
    private final Integer maxSize;
    private final Integer minSize;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder implements ShareModelBuilder<ContextChooseContent, Builder> {
        private List<String> filters;
        private Integer maxSize;
        private Integer minSize;

        public final List<String> getFilters$facebook_gamingservices_release() {
            return this.filters;
        }

        public final Integer getMaxSize$facebook_gamingservices_release() {
            return this.maxSize;
        }

        public final Integer getMinSize$facebook_gamingservices_release() {
            return this.minSize;
        }

        public final Builder setFilters(List<String> list) {
            this.filters = list;
            return this;
        }

        public final void setFilters$facebook_gamingservices_release(List<String> list) {
            this.filters = list;
        }

        public final Builder setMaxSize(Integer num) {
            this.maxSize = num;
            return this;
        }

        public final void setMaxSize$facebook_gamingservices_release(Integer num) {
            this.maxSize = num;
        }

        public final Builder setMinSize(Integer num) {
            this.minSize = num;
            return this;
        }

        public final void setMinSize$facebook_gamingservices_release(Integer num) {
            this.minSize = num;
        }

        @Override // com.facebook.share.ShareBuilder
        public ContextChooseContent build() {
            return new ContextChooseContent(this, null);
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(ContextChooseContent contextChooseContent) {
            Builder minSize;
            return (contextChooseContent == null || (minSize = setFilters(contextChooseContent.getFilters()).setMaxSize(contextChooseContent.getMaxSize()).setMinSize(contextChooseContent.getMinSize())) == null) ? this : minSize;
        }

        public final Builder readFrom(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return readFrom((ContextChooseContent) parcel.readParcelable(ContextChooseContent.class.getClassLoader()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CREATOR implements Parcelable.Creator<ContextChooseContent> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContextChooseContent createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ContextChooseContent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContextChooseContent[] newArray(int i3) {
            return new ContextChooseContent[i3];
        }
    }

    public /* synthetic */ ContextChooseContent(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final List<String> getFilters() {
        List<String> list = this.filters;
        if (list != null) {
            return Collections.unmodifiableList(list);
        }
        return null;
    }

    public final Integer getMaxSize() {
        return this.maxSize;
    }

    public final Integer getMinSize() {
        return this.minSize;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeStringList(this.filters);
        Integer num = this.maxSize;
        out.writeInt(num != null ? num.intValue() : 0);
        Integer num2 = this.minSize;
        out.writeInt(num2 != null ? num2.intValue() : 0);
    }

    private ContextChooseContent(Builder builder) {
        this.filters = builder.getFilters$facebook_gamingservices_release();
        this.maxSize = builder.getMaxSize$facebook_gamingservices_release();
        this.minSize = builder.getMinSize$facebook_gamingservices_release();
    }

    public ContextChooseContent(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.filters = parcel.createStringArrayList();
        this.maxSize = Integer.valueOf(parcel.readInt());
        this.minSize = Integer.valueOf(parcel.readInt());
    }
}
