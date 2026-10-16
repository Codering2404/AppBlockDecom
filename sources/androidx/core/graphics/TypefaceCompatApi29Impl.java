package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class TypefaceCompatApi29Impl extends TypefaceCompatBaseImpl {
    private Font l(FontFamily fontFamily, int i3) {
        FontStyle fontStyle = new FontStyle((i3 & 1) != 0 ? ColorExtractionConstants.MAXIMUM_BRIGHTNESS_THRESHOLD : RCHTTPStatusCodes.BAD_REQUEST, (i3 & 2) != 0 ? 1 : 0);
        Font font = fontFamily.getFont(0);
        int iN = n(fontStyle, font.getStyle());
        for (int i4 = 1; i4 < fontFamily.getSize(); i4++) {
            Font font2 = fontFamily.getFont(i4);
            int iN2 = n(fontStyle, font2.getStyle());
            if (iN2 < iN) {
                font = font2;
                iN = iN2;
            }
        }
        return font;
    }

    private static FontFamily m(CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArr, ContentResolver contentResolver) {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        FontFamily.Builder builder = null;
        for (FontsContractCompat.FontInfo fontInfo : fontInfoArr) {
            try {
                parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(fontInfo.d(), "r", cancellationSignal);
            } catch (IOException e3) {
                Log.w("TypefaceCompatApi29Impl", "Font load failed", e3);
            }
            if (parcelFileDescriptorOpenFileDescriptor == null) {
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                }
            } else {
                try {
                    Font fontBuild = new Font.Builder(parcelFileDescriptorOpenFileDescriptor).setWeight(fontInfo.e()).setSlant(fontInfo.f() ? 1 : 0).setTtcIndex(fontInfo.c()).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(fontBuild);
                    } else {
                        builder.addFont(fontBuild);
                    }
                } catch (Throwable th) {
                    try {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            parcelFileDescriptorOpenFileDescriptor.close();
        }
        if (builder == null) {
            return null;
        }
        return builder.build();
    }

    private static int n(FontStyle fontStyle, FontStyle fontStyle2) {
        return (Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100) + (fontStyle.getSlant() == fontStyle2.getSlant() ? 0 : 2);
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface b(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i3) {
        try {
            FontFamily.Builder builder = null;
            for (FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry : fontFamilyFilesResourceEntry.a()) {
                try {
                    Font fontBuild = new Font.Builder(resources, fontFileResourceEntry.b()).setWeight(fontFileResourceEntry.e()).setSlant(fontFileResourceEntry.f() ? 1 : 0).setTtcIndex(fontFileResourceEntry.c()).setFontVariationSettings(fontFileResourceEntry.d()).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(fontBuild);
                    } else {
                        builder.addFont(fontBuild);
                    }
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily fontFamilyBuild = builder.build();
            return new Typeface.CustomFallbackBuilder(fontFamilyBuild).setStyle(l(fontFamilyBuild, i3).getStyle()).build();
        } catch (Exception e3) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e3);
            return null;
        }
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface c(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArr, int i3) {
        try {
            FontFamily fontFamilyM = m(cancellationSignal, fontInfoArr, context.getContentResolver());
            if (fontFamilyM == null) {
                return null;
            }
            return new Typeface.CustomFallbackBuilder(fontFamilyM).setStyle(l(fontFamilyM, i3).getStyle()).build();
        } catch (Exception e3) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e3);
            return null;
        }
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface d(Context context, CancellationSignal cancellationSignal, List list, int i3) {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily fontFamilyM = m(cancellationSignal, (FontsContractCompat.FontInfo[]) list.get(0), contentResolver);
            if (fontFamilyM == null) {
                return null;
            }
            Typeface.CustomFallbackBuilder customFallbackBuilder = new Typeface.CustomFallbackBuilder(fontFamilyM);
            for (int i4 = 1; i4 < list.size(); i4++) {
                FontFamily fontFamilyM2 = m(cancellationSignal, (FontsContractCompat.FontInfo[]) list.get(i4), contentResolver);
                if (fontFamilyM2 != null) {
                    customFallbackBuilder.addCustomFallback(fontFamilyM2);
                }
            }
            return customFallbackBuilder.setStyle(l(fontFamilyM, i3).getStyle()).build();
        } catch (Exception e3) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e3);
            return null;
        }
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    protected Typeface e(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface f(Context context, Resources resources, int i3, String str, int i4) {
        try {
            Font fontBuild = new Font.Builder(resources, i3).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(fontBuild).build()).setStyle(fontBuild.getStyle()).build();
        } catch (Exception e3) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e3);
            return null;
        }
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    protected FontsContractCompat.FontInfo j(FontsContractCompat.FontInfo[] fontInfoArr, int i3) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}
