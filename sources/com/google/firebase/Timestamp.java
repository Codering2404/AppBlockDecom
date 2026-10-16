package com.google.firebase;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;

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
public final class Timestamp implements Comparable<Timestamp>, Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f87619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f87620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f87618c = new Companion(null);
    public static final Parcelable.Creator<Timestamp> CREATOR = new Parcelable.Creator<Timestamp>() { // from class: com.google.firebase.Timestamp$Companion$CREATOR$1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Timestamp createFromParcel(Parcel source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new Timestamp(source.readLong(), source.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Timestamp[] newArray(int i3) {
            return new Timestamp[i3];
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(long j3, int i3) {
            if (i3 < 0 || i3 >= 1000000000) {
                throw new IllegalArgumentException(("Timestamp nanoseconds out of range: " + i3).toString());
            }
            if (-62135596800L > j3 || j3 >= 253402300800L) {
                throw new IllegalArgumentException(("Timestamp seconds out of range: " + j3).toString());
            }
        }

        private Companion() {
        }
    }

    public Timestamp(long j3, int i3) {
        f87618c.b(j3, i3);
        this.f87619a = j3;
        this.f87620b = i3;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(Timestamp other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return ComparisonsKt.e(this, other, new PropertyReference1Impl() { // from class: com.google.firebase.Timestamp.compareTo.1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Long.valueOf(((Timestamp) obj).d());
            }
        }, new PropertyReference1Impl() { // from class: com.google.firebase.Timestamp.compareTo.2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((Timestamp) obj).c());
            }
        });
    }

    public final int c() {
        return this.f87620b;
    }

    public final long d() {
        return this.f87619a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof Timestamp) && compareTo((Timestamp) obj) == 0;
        }
        return true;
    }

    public int hashCode() {
        long j3 = this.f87619a;
        return (((((int) j3) * 1369) + ((int) (j3 >> 32))) * 37) + this.f87620b;
    }

    public String toString() {
        return "Timestamp(seconds=" + this.f87619a + ", nanoseconds=" + this.f87620b + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i3) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeLong(this.f87619a);
        dest.writeInt(this.f87620b);
    }
}
