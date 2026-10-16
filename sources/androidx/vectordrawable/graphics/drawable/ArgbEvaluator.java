package androidx.vectordrawable.graphics.drawable;

import android.animation.TypeEvaluator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ArgbEvaluator implements TypeEvaluator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ArgbEvaluator f53638a = new ArgbEvaluator();

    @Override // android.animation.TypeEvaluator
    public Object evaluate(float f3, Object obj, Object obj2) {
        int iIntValue = ((Integer) obj).intValue();
        float f4 = ((iIntValue >> 24) & 255) / 255.0f;
        int iIntValue2 = ((Integer) obj2).intValue();
        float fPow = (float) Math.pow(((iIntValue >> 16) & 255) / 255.0f, 2.2d);
        float fPow2 = (float) Math.pow(((iIntValue >> 8) & 255) / 255.0f, 2.2d);
        float fPow3 = (float) Math.pow((iIntValue & 255) / 255.0f, 2.2d);
        float fPow4 = (float) Math.pow(((iIntValue2 >> 16) & 255) / 255.0f, 2.2d);
        float f5 = f4 + (((((iIntValue2 >> 24) & 255) / 255.0f) - f4) * f3);
        float fPow5 = fPow2 + ((((float) Math.pow(((iIntValue2 >> 8) & 255) / 255.0f, 2.2d)) - fPow2) * f3);
        float fPow6 = fPow3 + (f3 * (((float) Math.pow((iIntValue2 & 255) / 255.0f, 2.2d)) - fPow3));
        return Integer.valueOf((Math.round(((float) Math.pow(fPow + ((fPow4 - fPow) * f3), 0.45454545454545453d)) * 255.0f) << 16) | (Math.round(f5 * 255.0f) << 24) | (Math.round(((float) Math.pow(fPow5, 0.45454545454545453d)) * 255.0f) << 8) | Math.round(((float) Math.pow(fPow6, 0.45454545454545453d)) * 255.0f));
    }
}
