package ru.noties.markwon.html.tag;

import android.text.TextUtils;
import java.util.Map;
import org.commonmark.node.Image;
import ru.noties.markwon.MarkwonConfiguration;
import ru.noties.markwon.RenderProps;
import ru.noties.markwon.SpanFactory;
import ru.noties.markwon.html.CssInlineStyleParser;
import ru.noties.markwon.html.HtmlTag;
import ru.noties.markwon.image.ImageProps;
import ru.noties.markwon.image.ImageSize;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class ImageHandler extends SimpleTagHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImageSizeParser f147328a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface ImageSizeParser {
        ImageSize a(Map map);
    }

    ImageHandler(ImageSizeParser imageSizeParser) {
        this.f147328a = imageSizeParser;
    }

    public static ImageHandler a() {
        return new ImageHandler(new ImageSizeParserImpl(CssInlineStyleParser.a()));
    }

    @Override // ru.noties.markwon.html.tag.SimpleTagHandler
    public Object getSpans(MarkwonConfiguration markwonConfiguration, RenderProps renderProps, HtmlTag htmlTag) {
        SpanFactory spanFactoryA;
        String str = (String) htmlTag.c().get("src");
        if (TextUtils.isEmpty(str) || (spanFactoryA = markwonConfiguration.f().a(Image.class)) == null) {
            return null;
        }
        String strA = markwonConfiguration.i().a(str);
        ImageSize imageSizeA = this.f147328a.a(htmlTag.c());
        ImageProps.f147371a.e(renderProps, strA);
        ImageProps.f147373c.e(renderProps, imageSizeA);
        ImageProps.f147372b.e(renderProps, Boolean.FALSE);
        return spanFactoryA.a(markwonConfiguration, renderProps);
    }
}
