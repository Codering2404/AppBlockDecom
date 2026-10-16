package com.google.android.gms.cloudmessaging;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class CloudMessage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CloudMessage> CREATOR = new zza();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Intent f71365a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MessagePriority {
    }

    public CloudMessage(Intent intent) {
        this.f71365a = intent;
    }

    public Intent M() {
        return this.f71365a;
    }

    public String N() {
        String stringExtra = this.f71365a.getStringExtra("google.message_id");
        return stringExtra == null ? this.f71365a.getStringExtra("message_id") : stringExtra;
    }

    final Integer O() {
        if (this.f71365a.hasExtra("google.product_id")) {
            return Integer.valueOf(this.f71365a.getIntExtra("google.product_id", 0));
        }
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.E(parcel, 1, this.f71365a, i3, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
