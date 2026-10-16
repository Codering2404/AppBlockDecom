package com.google.android.libraries.places.internal;

import android.text.TextUtils;
import com.google.common.collect.ImmutableList;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class zzrz {
    zzrz() {
    }

    public abstract ImmutableList a();

    public abstract ImmutableList b();

    public abstract UUID c();

    public abstract long d();

    public final String toString() {
        return TextUtils.join(" -> ", a());
    }
}
