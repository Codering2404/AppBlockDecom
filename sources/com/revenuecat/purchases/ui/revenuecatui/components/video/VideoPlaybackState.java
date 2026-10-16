package com.revenuecat.purchases.ui.revenuecatui.components.video;

import android.os.Parcel;
import android.os.Parcelable;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class VideoPlaybackState implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<VideoPlaybackState> CREATOR = new Creator();
    private final boolean playWhenReady;
    private final int positionMs;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Creator implements Parcelable.Creator<VideoPlaybackState> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VideoPlaybackState createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new VideoPlaybackState(parcel.readInt(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VideoPlaybackState[] newArray(int i3) {
            return new VideoPlaybackState[i3];
        }
    }

    public VideoPlaybackState(int i3, boolean z2) {
        this.positionMs = i3;
        this.playWhenReady = z2;
    }

    public static /* synthetic */ VideoPlaybackState copy$default(VideoPlaybackState videoPlaybackState, int i3, boolean z2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = videoPlaybackState.positionMs;
        }
        if ((i4 & 2) != 0) {
            z2 = videoPlaybackState.playWhenReady;
        }
        return videoPlaybackState.copy(i3, z2);
    }

    public final int component1() {
        return this.positionMs;
    }

    public final boolean component2() {
        return this.playWhenReady;
    }

    public final VideoPlaybackState copy(int i3, boolean z2) {
        return new VideoPlaybackState(i3, z2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoPlaybackState)) {
            return false;
        }
        VideoPlaybackState videoPlaybackState = (VideoPlaybackState) obj;
        return this.positionMs == videoPlaybackState.positionMs && this.playWhenReady == videoPlaybackState.playWhenReady;
    }

    public final boolean getPlayWhenReady() {
        return this.playWhenReady;
    }

    public final int getPositionMs() {
        return this.positionMs;
    }

    public int hashCode() {
        return (Integer.hashCode(this.positionMs) * 31) + Boolean.hashCode(this.playWhenReady);
    }

    public String toString() {
        return "VideoPlaybackState(positionMs=" + this.positionMs + ", playWhenReady=" + this.playWhenReady + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeInt(this.positionMs);
        out.writeInt(this.playWhenReady ? 1 : 0);
    }
}
