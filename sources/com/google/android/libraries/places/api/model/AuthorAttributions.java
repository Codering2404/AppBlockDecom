package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AuthorAttributions implements Parcelable {
    public static AuthorAttributions d(List list) {
        return new zzco(ImmutableList.t(list));
    }

    public abstract List c();
}
