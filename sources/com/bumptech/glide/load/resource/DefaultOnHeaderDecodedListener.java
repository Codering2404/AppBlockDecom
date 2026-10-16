package com.bumptech.glide.load.resource;

import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.util.Log;
import android.util.Size;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class DefaultOnHeaderDecodedListener implements ImageDecoder.OnHeaderDecodedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HardwareConfigState f66806a = HardwareConfigState.b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f66807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f66808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final DecodeFormat f66809d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final DownsampleStrategy f66810e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f66811f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final PreferredColorSpace f66812g;

    public DefaultOnHeaderDecodedListener(int i3, int i4, Options options) {
        this.f66807b = i3;
        this.f66808c = i4;
        this.f66809d = (DecodeFormat) options.c(Downsampler.f66851f);
        this.f66810e = (DownsampleStrategy) options.c(DownsampleStrategy.f66846h);
        Option option = Downsampler.f66855j;
        this.f66811f = options.c(option) != null && ((Boolean) options.c(option)).booleanValue();
        this.f66812g = (PreferredColorSpace) options.c(Downsampler.f66852g);
    }

    @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
    public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        if (this.f66806a.f(this.f66807b, this.f66808c, this.f66811f, false)) {
            imageDecoder.setAllocator(3);
        } else {
            imageDecoder.setAllocator(1);
        }
        if (this.f66809d == DecodeFormat.PREFER_RGB_565) {
            imageDecoder.setMemorySizePolicy(0);
        }
        imageDecoder.setOnPartialImageListener(new ImageDecoder.OnPartialImageListener() { // from class: com.bumptech.glide.load.resource.DefaultOnHeaderDecodedListener.1
            @Override // android.graphics.ImageDecoder.OnPartialImageListener
            public boolean onPartialImage(ImageDecoder.DecodeException decodeException) {
                return false;
            }
        });
        Size size = imageInfo.getSize();
        int width = this.f66807b;
        if (width == Integer.MIN_VALUE) {
            width = size.getWidth();
        }
        int height = this.f66808c;
        if (height == Integer.MIN_VALUE) {
            height = size.getHeight();
        }
        float fB = this.f66810e.b(size.getWidth(), size.getHeight(), width, height);
        int iRound = Math.round(size.getWidth() * fB);
        int iRound2 = Math.round(size.getHeight() * fB);
        if (Log.isLoggable("ImageDecoder", 2)) {
            Log.v("ImageDecoder", "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + iRound + "x" + iRound2 + "] scaleFactor: " + fB);
        }
        imageDecoder.setTargetSize(iRound, iRound2);
        PreferredColorSpace preferredColorSpace = this.f66812g;
        if (preferredColorSpace != null) {
            imageDecoder.setTargetColorSpace(ColorSpace.get((preferredColorSpace == PreferredColorSpace.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB));
        }
    }
}
