package com.bumptech.glide.load.resource;

import android.content.Context;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class UnitTransformation<T> implements Transformation<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Transformation f66815b = new UnitTransformation();

    private UnitTransformation() {
    }

    public static UnitTransformation c() {
        return (UnitTransformation) f66815b;
    }

    @Override // com.bumptech.glide.load.Key
    public void b(MessageDigest messageDigest) {
    }

    @Override // com.bumptech.glide.load.Transformation
    public Resource a(Context context, Resource resource, int i3, int i4) {
        return resource;
    }
}
