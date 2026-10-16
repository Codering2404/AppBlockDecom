package androidx.activity.result;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class IntentSenderRequest implements Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IntentSender f566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Intent f567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f568c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f569d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f565f = new Companion(null);
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new Parcelable.Creator<IntentSenderRequest>() { // from class: androidx.activity.result.IntentSenderRequest$Companion$CREATOR$1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public IntentSenderRequest createFromParcel(Parcel inParcel) {
            Intrinsics.checkNotNullParameter(inParcel, "inParcel");
            return new IntentSenderRequest(inParcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public IntentSenderRequest[] newArray(int i3) {
            return new IntentSenderRequest[i3];
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final IntentSender f570a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Intent f571b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f572c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f573d;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention
        private @interface Flag {
        }

        public Builder(IntentSender intentSender) {
            Intrinsics.checkNotNullParameter(intentSender, "intentSender");
            this.f570a = intentSender;
        }

        public final IntentSenderRequest a() {
            return new IntentSenderRequest(this.f570a, this.f571b, this.f572c, this.f573d);
        }

        public final Builder b(Intent intent) {
            this.f571b = intent;
            return this;
        }

        public final Builder c(int i3, int i4) {
            this.f573d = i3;
            this.f572c = i4;
            return this;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public Builder(PendingIntent pendingIntent) {
            Intrinsics.checkNotNullParameter(pendingIntent, "pendingIntent");
            IntentSender intentSender = pendingIntent.getIntentSender();
            Intrinsics.checkNotNullExpressionValue(intentSender, "pendingIntent.intentSender");
            this(intentSender);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public IntentSenderRequest(IntentSender intentSender, Intent intent, int i3, int i4) {
        Intrinsics.checkNotNullParameter(intentSender, "intentSender");
        this.f566a = intentSender;
        this.f567b = intent;
        this.f568c = i3;
        this.f569d = i4;
    }

    public final Intent c() {
        return this.f567b;
    }

    public final int d() {
        return this.f568c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int e() {
        return this.f569d;
    }

    public final IntentSender f() {
        return this.f566a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i3) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeParcelable(this.f566a, i3);
        dest.writeParcelable(this.f567b, i3);
        dest.writeInt(this.f568c);
        dest.writeInt(this.f569d);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public IntentSenderRequest(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Parcelable parcelable = parcel.readParcelable(IntentSender.class.getClassLoader());
        Intrinsics.checkNotNull(parcelable);
        this((IntentSender) parcelable, (Intent) parcel.readParcelable(Intent.class.getClassLoader()), parcel.readInt(), parcel.readInt());
    }
}
