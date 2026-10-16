package ru.noties.markwon.html.tag;

import android.text.TextUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.AnalyticsEvents;
import java.util.Map;
import ru.noties.markwon.html.CssInlineStyleParser;
import ru.noties.markwon.html.CssProperty;
import ru.noties.markwon.html.tag.ImageHandler;
import ru.noties.markwon.image.ImageSize;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
class ImageSizeParserImpl implements ImageHandler.ImageSizeParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CssInlineStyleParser f147329a;

    ImageSizeParserImpl(CssInlineStyleParser cssInlineStyleParser) {
        this.f147329a = cssInlineStyleParser;
    }

    @Override // ru.noties.markwon.html.tag.ImageHandler.ImageSizeParser
    public ImageSize a(Map map) {
        ImageSize.Dimension dimensionB;
        ImageSize.Dimension dimensionB2;
        String str = (String) map.get(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
        if (!TextUtils.isEmpty(str)) {
            dimensionB = null;
            dimensionB2 = null;
            for (CssProperty cssProperty : this.f147329a.b(str)) {
                String strA = cssProperty.a();
                if (ViewHierarchyConstants.DIMENSION_WIDTH_KEY.equals(strA)) {
                    dimensionB = b(cssProperty.c());
                } else if (ViewHierarchyConstants.DIMENSION_HEIGHT_KEY.equals(strA)) {
                    dimensionB2 = b(cssProperty.c());
                }
                if (dimensionB != null && dimensionB2 != null) {
                    break;
                }
            }
        } else {
            dimensionB = null;
            dimensionB2 = null;
        }
        if (dimensionB != null && dimensionB2 != null) {
            return new ImageSize(dimensionB, dimensionB2);
        }
        if (dimensionB == null) {
            dimensionB = b((String) map.get(ViewHierarchyConstants.DIMENSION_WIDTH_KEY));
        }
        if (dimensionB2 == null) {
            dimensionB2 = b((String) map.get(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY));
        }
        if (dimensionB == null && dimensionB2 == null) {
            return null;
        }
        return new ImageSize(dimensionB, dimensionB2);
    }

    ImageSize.Dimension b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length();
        int i3 = length - 1;
        int i4 = i3;
        while (i4 > -1) {
            if (Character.isDigit(str.charAt(i4))) {
                int i5 = i4 + 1;
                try {
                    return new ImageSize.Dimension(Float.parseFloat(str.substring(0, i5)), i4 == i3 ? null : str.substring(i5, length));
                } catch (NumberFormatException unused) {
                    return null;
                }
            }
            i4--;
        }
        return null;
    }
}
