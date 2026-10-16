package com.github.mikephil.charting.utils;

import android.os.Parcel;
import android.os.Parcelable;
import com.github.mikephil.charting.utils.ObjectPool;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MPPointF extends ObjectPool.Poolable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static ObjectPool f68791f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Parcelable.Creator f68792g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f68793c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f68794d;

    static {
        ObjectPool objectPoolA = ObjectPool.a(32, new MPPointF(0.0f, 0.0f));
        f68791f = objectPoolA;
        objectPoolA.g(0.5f);
        f68792g = new Parcelable.Creator<MPPointF>() { // from class: com.github.mikephil.charting.utils.MPPointF.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public MPPointF createFromParcel(Parcel parcel) {
                MPPointF mPPointF = new MPPointF(0.0f, 0.0f);
                mPPointF.e(parcel);
                return mPPointF;
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public MPPointF[] newArray(int i3) {
                return new MPPointF[i3];
            }
        };
    }

    public MPPointF() {
    }

    public static MPPointF b() {
        return (MPPointF) f68791f.b();
    }

    public static MPPointF c(float f3, float f4) {
        MPPointF mPPointF = (MPPointF) f68791f.b();
        mPPointF.f68793c = f3;
        mPPointF.f68794d = f4;
        return mPPointF;
    }

    public static MPPointF d(MPPointF mPPointF) {
        MPPointF mPPointF2 = (MPPointF) f68791f.b();
        mPPointF2.f68793c = mPPointF.f68793c;
        mPPointF2.f68794d = mPPointF.f68794d;
        return mPPointF2;
    }

    public static void f(MPPointF mPPointF) {
        f68791f.c(mPPointF);
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    protected ObjectPool.Poolable a() {
        return new MPPointF(0.0f, 0.0f);
    }

    public void e(Parcel parcel) {
        this.f68793c = parcel.readFloat();
        this.f68794d = parcel.readFloat();
    }

    public MPPointF(float f3, float f4) {
        this.f68793c = f3;
        this.f68794d = f4;
    }
}
