package com.facebook.ads.redexgen.core;

import android.graphics.drawable.Drawable;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ox, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC0955Ox extends Drawable {
    public static String[] A00 = {"Bq6maawZ0clc1FQAmj5JQZ", "VAIBWau0AGjNNTEN3MsesX9vol", "j9uAnr9SO1508v2Fml3gke", "ZCgsP4jhFD2e5OZklqeZfYu5I7s7wZNA", "gWy56vmTKK0E", "vsILSp0QdnJQHstvTHvz6zn3fr5EWYkf", "Ft8tZM9UwubEJUOv9H1JFeEwlzUnh", "KM7boO2xaC3ZbV22lXcue9aE71LlUQ5e"};
    public static final double A01 = Math.cos(Math.toRadians(45.0d));

    public static float A00(float f3, float f4, boolean z2) {
        if (z2) {
            return (float) (((double) f3) + ((1.0d - A01) * ((double) f4)));
        }
        return f3;
    }

    public static float A01(float f3, float f4, boolean z2) {
        if (z2) {
            return (float) (((double) (1.5f * f3)) + ((1.0d - A01) * ((double) f4)));
        }
        float f5 = 1.5f * f3;
        if (A00[6].length() == 2) {
            throw new RuntimeException();
        }
        A00[3] = "QZbxm3QXOF2yqMmVze25YX6oNvKBlq6Q";
        return f5;
    }
}
